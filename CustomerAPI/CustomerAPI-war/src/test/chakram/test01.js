var chakram = require('chakram');
var params = require('./params.js');
var customerJohnSmithCREATE = require('./customer-john-smith-CREATE.js');
var customerJohnSmithUPDATE = require('./customer-john-smith-UPDATE.js');

var baseUrl = params.baseUrl;

console.log('baseUrl = ' + baseUrl);


var customerId;

describe("Customer API - createCustomer Operation", function() {

    var apiResponse;

    before("Create a customer named John Smith and keep track of its ID", function () {

        apiResponse = chakram.post(baseUrl + "/customers", customerJohnSmithCREATE.payload);
        apiResponse.then(function(respObj) {
            customerId = respObj.body.id;
            console.log("created : " + customerId);
        });
    });

    it("should have HTTP status 200", function () {
        return chakram.expect(apiResponse).to.have.status(200);
    });

});



describe("Customer API - searchCustomers Operation", function() {

});



describe("Customer API - deleteCustomer Operation", function() {

});


describe("Customer API - viewCustomer Operation", function() {

});


describe("Customer API - updateCustomer Operation", function() {

    before("Update customer named John Smith", function () {

        console.log("CustId for update = " + customerId);

        customerJohnSmithUPDATE.payload.id = customerId;

        apiResponse = chakram.put(baseUrl + "/customers/" + customerId, customerJohnSmithUPDATE.payload);
        apiResponse.then(function(respObj) {
            console.log("updated : " + customerId);
        });
    });

    it("should have HTTP status 200", function () {
        return chakram.expect(apiResponse).to.have.status(200);
    });

});


describe("Customer API - createCustomerCard Operation", function() {

});


describe("Customer API - deleteCustomerCard Operation", function() {

});


describe("Customer API - updateCustomerCard Operation", function() {

});
