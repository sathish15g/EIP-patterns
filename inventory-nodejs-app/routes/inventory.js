var express = require('express');
var Inventory=require('../model/Inventory');

var inventoryservice=require('../service/inventory-service');
var router = express.Router();
var redis = require('redis');
var client = redis.createClient();
client.on("error",function(err){
    console.log("Error:",err);
});


/* Save the inventory with the details. */
router.post('/save', function(req, res) {
	
	 console.log("inventory save is called ");
	
	 var inventory=new Inventory(req.body.inventoryId,req.body.inventoryName,req.body.quantity,req.body.price,req.body.category);
	 console.log("Inventory to be saved "+inventory.toString());
	 inventoryservice.saveInventory(inventory);
	 res.setHeader('Content-Type', 'application/json');
	 res.json(JSON.parse(inventory));
	 client.set(inventory.inventoryId,JSON.stringify(inventory),redis.print)
});

/* Get the inventory with inventory Id. */
router.get('/get/:inventoryid', function(req, res) {
	
	 console.log("inventory get is called ");
	 var inventoryid=req.params.inventoryid;
	 console.log("inventory id is "+inventoryid);
    client.get(inventoryid,function(err,reply){
        if(reply == null){
            console.log("Given Order not available in cache");
            inventory = inventoryservice.getInventory(inventoryid).then(function(rows){
                console.log("inventoryid fetched from DB:"+JSON.stringify(rows));
                res.writeHead(200, { 'Content-Type': 'application/json'});
                res.end(JSON.stringify(rows));
            }).catch(function(e){
                console.log(e.stack);
            });
        }
        else{
            inventory=reply.toString();
            console.log("inventory fetched from Redis:"+inventory);
            console.log("inventory"+JSON.stringify(inventory));
            res.json(JSON.parse(inventory));
        }

    });
});

module.exports = router;
