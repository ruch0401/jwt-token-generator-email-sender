var http = require('http');
var util = require('util');
var express = require('express'); // importing express module
var cors = require('cors');
var bodyParser = require('body-parser')
var path = require('path')

var app = express(); // Init the express application

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, '/')));

app.use(cors({
    origin: '*'
}));

app.all('*', function (req, res) {
    res.sendFile('index.html', {root: __dirname})
});

app.on('error', function (err) {
    util.log(err);
    process.exit(1);
}).listen(1593, function () {
    util.log('Server running on Port 1593')
});