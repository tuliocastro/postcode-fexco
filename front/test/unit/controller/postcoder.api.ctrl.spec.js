'use strict';

describe('PostcoderAPICtrl', function () {

    var lookupsMock = [];

    beforeEach(function () {

        module(CONSTANTS.APP);


    });

    it('should instantiate controller', inject(function ($controller) {

        var ctrl = $controller('PostcoderAPICtrl', {_lookups: lookupsMock});

        assert.equal(ctrl != null, true);

    }));


    it('should reset values', inject(function ($controller) {

        var ctrl = $controller('PostcoderAPICtrl', {_lookups: lookupsMock});

        ctrl.reset();

        assert.equal(ctrl.params.page == 0, true);

    }));


    it('should go to next page', inject(function ($controller, $q) {


        var lookupsMock = [
            {
                execute: function () {
                    return $q.resolve("ok");
                }
            }
        ];

        var ctrl = $controller('PostcoderAPICtrl', {_lookups: lookupsMock});

        ctrl.selectedLookup = lookupsMock[0];

        ctrl.nextPage();

        assert.equal(ctrl.params.page > 0, true);

    }));

    it('should go to next page', inject(function ($controller, $q) {


        var lookupsMock = [
            {
                execute: function () {
                    return $q.resolve("ok");
                }
            }
        ];

        var ctrl = $controller('PostcoderAPICtrl', {_lookups: lookupsMock});

        ctrl.selectedLookup = lookupsMock[0];

        ctrl.nextPage();

        ctrl.previousPage();

        assert.equal(ctrl.params.page == 0, true);

    }));



});