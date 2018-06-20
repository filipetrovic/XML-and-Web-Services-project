var mysql = require('mysql');
var cors = require('cors')();

exports.addRating = function(req, res) {
	
	cors(req, res, () => {
	
	var c = mysql.createConnection({
			host : 'localhost',
				user : 'root',
				password : 'root',
				database : 'xml-db'
	});
	
	c.connect(function(err) {
	  if (err) throw err;
	  console.log("Connected!");
	});
	
	c.query("INSERT INTO rating (comment, value, reservation_id, accommodation_id) VALUES ('"+ req.body.comment + "','"+ req.body.value + "','"+ req.body.reservationId + "','"+ req.body.accommodationId + "')");

	c.query('SELECT * FROM rating', (err,rows) => {
	  if(err) throw err;
	  res.status(200).send(rows);
	}); 

});
	
}

exports.getRatings = function(req, res) {

	cors(req, res, () => {
		
		var c = mysql.createConnection({
			host : 'localhost',
			user : 'root',
			password : 'root',
			database : 'xml-db'
		});
	
		c.connect(function(err) {
		  if (err) throw err;
		  console.log("Connected!");
		});
		
		c.query('SELECT * FROM rating', (err,rows) => {
		  if(err) throw err;
		  res.status(200).send(rows);
		}); 
		
	});
}
