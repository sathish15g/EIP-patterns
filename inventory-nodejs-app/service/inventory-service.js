
var Inventory=require("../model/Inventory");
var rabbitmqconn=require('../messaging/rabbitmqconnection');
var inventRepo = require("../repo/inventory-repo.js");
/*
var inventoryrepository={
		
		inventoryMap: null,
		
		initializeMap: function(){
			console.log("Initializing the hash map");
			this.inventoryMap=new HashMap();
		},

				
		saveInventory:function(inventory){
			console.log("save inventory is called"+inventory);
			this.inventoryMap.set(inventory.productName,JSON.stringify(inventory));
			
		},
		
		getInventory:function(productName){
			console.log("get inventory is called"+productName);
			return this.inventoryMap.get(productName);
		}
};
inventoryrepository.initializeMap();
*/

var inventoryservice={

		saveInventory:function(inventory){
            inventRepo.save(inventory)
		},
		
		getInventory:function(inventoryId){
			console.log("get inventory service is called"+inventoryId);
			return inventRepo.getinventory(inventoryId);
		},

		getInventories:function(){
			return inventRepo.getInventories()
		},

		updateInventory:function(inventory){
			return inventRepo.updateInventory();
		}
		
};


module.exports=inventoryservice;
