;
(function () {

    angular.module(CONSTANTS.APP).config(Routes);

    function Routes($stateProvider) {

        $stateProvider

            .state({
                name: 'ie',
                url: '/ie',
                template: CONSTANTS.EMPTY_TEMPLATE,
                abstract: true
            })

            .state({
                name: 'ie.address',
                url: '/address',
                templateUrl: "ie/address.html",
                controller: "AddressIECtrl as ctrl"
            });

    }

})();