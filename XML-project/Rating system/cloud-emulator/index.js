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
	
	c.query("INSERT INTO rating (comment, value, reservation_id, accommodation_id, version, approved) VALUES ('"+ req.body.comment + "','"+ req.body.value + "','"+ req.body.reservationId + "','"+ req.body.accommodationId + "'"
	+ ",'0'"+ ",false)");

	c.query('SELECT * FROM rating', (err,rows) => {
	  if(err) throw err;

		var niz = [];
	  
		for(var i = 0; i < rows.length;i++){
		
		
		niz.push(Array.prototype.slice.call(rows[i].approved, 0));
		
		if(niz[i][0] === 1)
			rows[i].approved = true;
		else
			rows[i].approved = false;
		
		}
		
	  res.setHeader('Content-Type', 'application/json');
	  res.status(200).send(JSON.stringify(rows));
	}); 

});
	
}

exports.updateRating = function(req, res) {
	
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
	
	c.query("UPDATE ratings SET approved = true WHERE id = '" + req.body.id +"'");

	 res.status(200).send(true);
	}); 

};
	
exports.updateRating = function(req, res) {
	
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
	
	c.query("DELETE FROM ratings WHERE id = '" + req.body.id +"'");

	 res.status(200).send(true);
	}); 

};

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

			var niz = [];
		  
			for(var i = 0; i < rows.length;i++){
			
			
			niz.push(Array.prototype.slice.call(rows[i].approved, 0));
			
			if(niz[i][0] === 1)
				rows[i].approved = true;
			else
				rows[i].approved = false;
			
			}
			
		  res.setHeader('Content-Type', 'application/json');
		  res.status(200).send(JSON.stringify(rows));
		}); 
		
	});
}

var Connection = require('tedious').Connection;
var Request = require('tedious').Request;

exports.getAzure = function(req, res) {

	var config  = {
		server : 'xml-database.database.windows.net',
		userName : 'xml-user',
		password : 'Ivanivan123',
		options: 
		{
		   database: 'rating-system' //update me
		   , encrypt: true
		}
	}
	
	var connection = new Connection(config);

// Attempt to connect and execute queries if connection goes through
	connection.on('connect', function(err) 
	   {
		 if (err) 
		   {
			  console.log(err)
		   }
		else
		   {
			    request = new Request(
				  "SELECT * FROM ratings",
					 function(err, rowCount, rows) 
							{
								console.log(rowCount + ' row(s) returned');
								process.exit();
							}
						);
						
				var niz = [];

				request.on('row', function(columns) {
					columns.forEach(function(column) {
						console.log("%s\t%s", column.metadata.colName, column.value);
						niz.push(column);
					 });
						 });
				connection.execSql(request);
				
				
				
				res.setHeader('Content-Type', 'application/json');
				res.status(200).send(JSON.stringify(niz));
		   }
	   }
	 );



}
