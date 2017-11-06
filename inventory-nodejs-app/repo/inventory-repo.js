var mysql = require('mysql');
var Promise = require('promise');
var con = mysql.createConnection({
    host : "localhost",
    user : "root",
    password : "root",
    database : "microservices"

});
con.connect(function(err) {
    if (err)
        throw err;
    console.log('connected to MySql');

});

var inventoryRepo = {
    save : function(inventory) {
        console.log("inventory in rePo", inventory);
        con.query('insert into inventory set ?', inventory,
            function(err, result) {
                console.log("Insert");
                if (err)
                    throw err;
                console.log('values inserted', result);

            });
    },
    getinventory: function(inventoryId) {

        var inventory = null;
        return new Promise(function(resolve,reject){
            con.query("select * from inventory where inventoryid='"+inventoryId+"'",function(err,rows,fields){
                console.log("Rows Fetched:"+JSON.stringify(rows));
                inventory=rows;
                if(err){
                    console.log(err);
                    reject(err);
                }
                else{
                    resolve(inventory);
                }

            });
        }).then(function(){
            return inventory;
        });
    },
    getInventories : function() {

        var inventory = null;
        return new Promise(function(resolve,reject){
            con.query("select * from inventory",function(err,rows,fields){
                console.log("Rows Fetched:"+JSON.stringify(rows));
                inventory=rows;
                if(err){
                    console.log(err);
                    reject(err);
                }
                else{
                    resolve(inventory);
                }

            });
        }).then(function(){
            return inventory;
        });
    },
    updateInventory : function(inventory) {


        return new Promise(function(resolve,reject){
            con.query("update inventory set inventoryname=?, quantity=?, price=?,category=? where inventoryid=?",[inventory.inventoryName,inventory.quantity,inventory.price,inventory.category],function(err,result){
                if(err){
                    console.log(err);
                    reject(err);
                }
                else{
                    resolve(result.affectedRows);
                }

            });
        });
    }


}

module.exports = inventoryRepo;