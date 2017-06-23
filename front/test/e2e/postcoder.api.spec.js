// spec.js
describe('Postcoder API Route', function () {

    const API_KEY_TEST = "PCW45-12345-12345-1234X";

    var inputApiKey = element(by.model('ctrl.apiKey'));
    var alertInfo = element(by.css('.alert.alert-info'));

    beforeEach(function () {

        browser.get('http://localhost:8090/');

        inputApiKey.sendKeys(API_KEY_TEST);

        browser.actions().sendKeys(protractor.Key.ENTER).perform();

        browser.wait(1000);

        browser.waitForAngular();

    });


    it('should see an alert info', function () {
        expect(alertInfo.getText()).toContain('fill');
    });

    it('should list results', function () {

        //Select first option
        element(by.model('ctrl.selectedLookup'))
            .all(by.tagName('option'))
            .get(1)
            .click();

        element(by.model('field.value')).sendKeys('Adelaide Road')


    });

});