package com.example;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Path("/token")
public class TokenGeneration {

    @GET
    @Path("/{userName}/{consumerApp}/{tokenValidity}")
    @Produces(MediaType.TEXT_PLAIN)
    public String generateToken(@PathParam("userName") final String username,
                                @PathParam("consumerApp") final String consumerApp,
                                @PathParam("tokenValidity") final Long tokenValidity) {
        String token = null;
        try {
            token = generate(username, consumerApp, tokenValidity);
        } catch (JOSEException ex) {
            ex.printStackTrace();
        }
        return token;
    }

    public String generate(final String username, final String consumerAppKey, final Long tokenValidity) throws JOSEException {
        final LocalDateTime expiryDateTemp = LocalDateTime.now().plusDays(tokenValidity);
        ZonedDateTime zdt = expiryDateTemp.atZone(ZoneId.systemDefault());
        Date expiryDate = Date.from(zdt.toInstant());

        // Create HMAC signer
        JWSSigner signer = new MACSigner("abcdefghijklmnopqrstuvwxyz123456");

        // Prepare JWT with claims set
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject("zs\\" + username)
                .issuer("https://c2id.com")
                .issueTime(new Date())
                .claim("roles", "admin")
                .claim("flow_designer_app_key", consumerAppKey)
                .expirationTime(expiryDate)
                .notBeforeTime(new Date())
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

        // Apply the HMAC protection
        signedJWT.sign(signer);

        // Serialize to compact form, produces something like
        // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
        return signedJWT.serialize();
    }
}
