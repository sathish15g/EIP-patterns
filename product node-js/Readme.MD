

# product-nodejs-app

<b> Product microservice app built using node JS. </b>

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

<b> Save the product </b> : 

url : 
```
http://localhost:3000/product/save
```

header :
```
 Content-Type →application/json; charset=utf-8
 ```

body:
```
 {
    "productId": "10",
    "productName": "Fsports",
    "size": "3",
    "price": 5000000,
    "discount": 0,
    "color": "White",
    "category": "Shoes for men"
}

```

Get the product : 

```
http://localhost:3000/product/get/{productId}
```
