var express=require('express')
var app=express(); 
var mysql=require('mysql');
var port=process.env.PORT || 5000
var con=mysql.createConnection({

	host: "ec2-52-37-241-124.us-west-2.compute.amazonaws.com",
	user: "root",
	password: "password",
	database: "credit_data"
});


app.use(express.static(__dirname+'/'))

app.use(function(req, res, next) {
 res.setHeader('Access-Control-Allow-Origin', '*');
 res.setHeader('Access-Control-Allow-Methods', 'GET, POST');
 res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type,Authorization');
 next();
});
 
function db_connect()
	{
	con.connect(function(err){
		if(err)
			throw err;
		else
			console.log("Connection established succesfully");
		
		});
	}

 
 
app.get('/',function(req,res){
	 res.send("WELCOME");

})


app.get('/approved',function(req,res){
	var statement="select count(*) as value from dummy_credit_predict where dummy='APPROVED'";
	con.query(statement,function(err,rows){
		if(err) throw err;
		else{
			console.log("Data Retrieval Success");
			res.json(rows);
		}
	})
	
})

app.get('/notapproved',function(req,res){
	var statement="select count(*) as value from dummy_credit_predict where dummy='NOT APPROVED'";
	con.query(statement,function(err,rows){
		if(err) throw err;
		else{
			console.log("Data Retrieval Success");
			res.json(rows);
		}
	})
	
})


app.get('/approved_education_level_retrieval',function(req,res){
	var statement="select count(*) as Count, EducationLevel from credit_data group by EducationLevel having EducationLevel in (select distinct EducationLevel from credit_data where Approved=1) ";
	con.query(statement,function(err,rows){
		if(err) throw err;
		else{
			console.log("Data Retrieval Success");
			res.json(rows);
		}
	})
	
})


app.get('/denied_education_level_retrieval',function(req,res){
	var statement="select count(*) as Count, EducationLevel from credit_data group by EducationLevel having EducationLevel in (select distinct EducationLevel from credit_data where Approved=0) ";
	con.query(statement,function(err,rows){
		if(err) throw err;
		else{
			console.log("Data Retrieval Success");
			res.json(rows);
		}
	})
	
})

 
app.listen(port);
console.log("Go to port : "+port)

 
