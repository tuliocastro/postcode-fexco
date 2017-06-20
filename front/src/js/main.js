;
(function () {

    window.CONSTANTS = {
        APP: 'app',
        EMPTY_TEMPLATE: '<ui-view />'
    };

    angular.module(CONSTANTS.APP, [
        'ui.router',
        'LocalStorageModule'

    ]);

    angular.module(CONSTANTS.APP).config(function ($urlRouterProvider, $httpProvider) {

        $urlRouterProvider.otherwise('/configuration');

    });

    angular.module(CONSTANTS.APP).run(function ($rootScope, GlobalConstants) {

        $rootScope.constants = GlobalConstants;

    });

})();