var request = require('request');
var express = require('express');
var router = express.Router();
router.get('/redirect/inventory',function(req,res){

	 request({
		//url:'https://www.google.co.in',
		url:'http://localhost:8081/',
		method:'GET'

	},function(error,response,body){
		console.log("welocme");
		res.write(body);
		res.end();

	});


});
module.exports=router;