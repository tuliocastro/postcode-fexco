// spec.js
describe('Postcoder API Route', function () {

    const API_KEY_TEST = "PCW45-12345-12345-1234X";

    const HOST = 'http://localhost:8081/';

    var inputApiKey = element(by.model('ctrl.apiKey'));
    var alertInfo = element(by.css('.alert.alert-info'));


    beforeEach(function () {

        browser.get(HOST);

        inputApiKey.sendKeys(API_KEY_TEST);

        browser.actions().sendKeys(protractor.Key.ENTER).perform();


    });


    it('should list results', function () {

        browser.waitForAngular();

        //Select first option
        var select = element(by.model('ctrl.selectedLookup'));
        select.$('[label="Irish Address"]').click();


    });

});