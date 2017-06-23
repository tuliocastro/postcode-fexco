// spec.js
describe('Postcoder API Route', function () {

    beforeEach(function () {

        browser.get('http://localhost:8090/#!/postcoder/api');

    });


    it('should not see the search screen if api key was not set', function () {

        var inputAPI = element(by.model('ctrl.apiKey'));

        expect(inputAPI.isPresent()).toBe(false);
    });

});