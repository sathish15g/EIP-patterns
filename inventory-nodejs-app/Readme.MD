

# inventory-nodejs-app

<b> inventory microservice app built using node JS. </b>

### Download & Run 

Download the project and run 

```
npm install

```

### Run the application 

```

node app.js 

```

### Test the application 

<b> Save the inventory </b> : 

url : 
```
http://localhost:3000/inventory/save
```

header :
```
 Content-Type →application/json; charset=utf-8
 ```

body:
```
 {
    "inventoryId": "10",
    "inventoryName": "Fsports",
    "size": "3",
    "price": 5000000,
    "discount": 0,
    "color": "White",
    "category": "Shoes for men"
}

```

Get the inventory : 

```
http://localhost:3000/inventory/get/{inventoryId}
```
