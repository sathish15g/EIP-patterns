var chai = require('chai');

var expect = chai.expect;
var should = chai.should();
var chaiHttp = require('chai-http');

chai.use(chaiHttp);
var inventory = {
    "inventoryId": "13",
    "inventoryName": "Fsports",
    "quantity": "3",
    "price": 5000000,
    "category": "Shoes for men"
}
describe('postInventory()',function(){

    it('should post inventory successfully and return 200',(done)=> {
        chai.request('http://localhost:8081/')
        .post('inventory/save')
        .send(inventory)
        .end((err, res)=>{
        expect(res).to.have.status(200);
        res.body.should.be.a('object');
        done();
        });
    });
});
describe('getInventory()',function(){

    it('should get inventory successfully',(done)=>{
        chai.request('http://localhost:8081/')
        .get('inventory/get/13')
        .end((err, res)=> {
        expect(res).to.be.json;
    expect(res.body).to.eql(inventory);
    res.body.should.be.a('object');
    res.body.should.have.property('inventoryName');
    done();
});
});
});