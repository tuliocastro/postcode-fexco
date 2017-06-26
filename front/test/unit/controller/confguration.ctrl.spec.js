'use strict';

describe('ConfigurationCtrl', function () {

    beforeEach(function () {

        module(CONSTANTS.APP);

    });

    it('should instantiate controller', inject(function ($controller) {

        var ctrl = $controller('ConfigurationCtrl');

        assert.equal(ctrl != null, true);

    }));


    it('should get api key session', inject(function ($controller) {

        var APIKeySession = {
            get: function () {
                return 'teste';
            }
        }

        var ctrl = $controller('ConfigurationCtrl', {APIKeySession: APIKeySession});

        assert.equal(ctrl.apiKey != null, true);
        assert.equal(ctrl.apiKey == 'teste', true);


    }));

    it('should save api key session', inject(function ($controller) {

        var APIKeySession = {
            mockKey: 'teste',
            get: function () {
                return this.mockKey;
            },
            store: function () {
                this.mockKey = 'mocked';
            }
        };

        var ctrl = $controller('ConfigurationCtrl', {APIKeySession: APIKeySession});

        assert.equal(ctrl.apiKey != null, true);
        assert.equal(ctrl.apiKey == 'teste', true);

        ctrl.save();


        assert.equal(APIKeySession.get() == 'mocked', true);


    }));

    it('should reset apy key', inject(function ($controller) {

        var APIKeySession = {
            mockKey: 'teste',
            get: function () {
                return this.mockKey;
            },
            store: function () {
                this.mockKey = 'mocked';
            }
        };

        var ctrl = $controller('ConfigurationCtrl', {APIKeySession: APIKeySession});

        assert.equal(ctrl.apiKey != null, true);
        assert.equal(ctrl.apiKey == 'teste', true);

        ctrl.reset();


        assert.equal(ctrl.apiKey, null);


    }));
});