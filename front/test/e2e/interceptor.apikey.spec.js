// spec.js
describe('Postcoder API Route', function () {

    const HOST = 'http://localhost:8081/';

    beforeEach(function () {

        browser.get(HOST+'#!/postcoder/api');
        browser.refresh()

    });


    it('should not see the search screen if api key was not set', function () {

        var inputAPI = element(by.model('ctrl.apiKey'));

        expect(inputAPI.isPresent()).toBe(false);

    });

});