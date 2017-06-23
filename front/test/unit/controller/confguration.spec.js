'use strict';

describe('ConfigurationCtrl', function () {
    //initialise module
    beforeEach(module('app'));

    //params initialised in scope for tests
    var ctrl, scope;

    beforeEach(inject(function ($controller) {
        //get controller from $controller provider
        scope = {};
        ctrl = $controller('ConfigurationCtrl', {
            $scope: scope
        });
    }));

    it('should add name parameter to scope', function () {
        expect(scope.name).toBeDefined();
    });
});