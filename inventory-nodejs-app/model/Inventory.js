class Inventory{
	
	constructor(inventoryId,inventoryName,quantity,price,category){
		this.inventoryId=inventoryId;
		this.inventoryName=inventoryName;
		this.quantity=quantity;
		this.price=price;
		this.category=category;

	}
	
	getInventoryId(){
		return this.inventoryId;
	}
	
	getInventoryName(){
			return this.inventoryName;
	}

    getCategory(){
        return this.category;
    }
	toString(){
		return JSON.stringify(this);
	}
}

module.exports=Inventory;
