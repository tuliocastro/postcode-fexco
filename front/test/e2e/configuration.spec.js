// spec.js
describe('Configuration Route', function () {

    const API_KEY_TEST = "PCW45-12345-12345-1234X";

    var inputApiKey = element(by.model('ctrl.apiKey'));
    var resetButton = element(by.css('.btn.btn-default'));
    var submitButton = element(by.css('.btn.btn-success'));

    beforeEach(function () {
        browser.get('http://localhost:8090/');
    });

    it('should add an API-KEY', function () {
        inputApiKey.sendKeys(API_KEY_TEST);
        expect(inputApiKey.getAttribute('value')).toEqual(API_KEY_TEST);
    });

    it('should reset api input', function () {
        inputApiKey.sendKeys(API_KEY_TEST);
        resetButton.click();
        expect(inputApiKey.getAttribute('value')).toEqual("");
    });

    it('should submit on enter', function () {

        inputApiKey.sendKeys(API_KEY_TEST);

        browser.actions().sendKeys(protractor.Key.ENTER).perform().then(function () {

            expect(browser.driver.getCurrentUrl()).toEqual("http://localhost:8090/#!/postcoder/api");

        });

    });


    it('should submit on click', function () {

        inputApiKey.sendKeys("PCW45-12345-12345-1234X");

        submitButton.click().then(function () {

            expect(browser.driver.getCurrentUrl()).toEqual("http://localhost:8090/#!/postcoder/api");

        });

    });


});