;
(function () {

    const CONFIGURATION_ROUTE = "configuration";

    window.CONSTANTS = {
        APP: 'app',
        EMPTY_TEMPLATE: '<ui-view />'
    };

    angular.module(CONSTANTS.APP, [
        'ui.router',
        'LocalStorageModule',
        'sticky'
    ]);

    angular.module(CONSTANTS.APP).config(function ($urlRouterProvider, $httpProvider) {

        $urlRouterProvider.otherwise(CONFIGURATION_ROUTE);

    });

    angular.module(CONSTANTS.APP).run(function ($rootScope, $state, GlobalConstants, $transitions, APIKeySession) {

        $rootScope.constants = GlobalConstants;

        $transitions.onBefore({to: 'postcoder.**'}, function (trans) {

            if (!APIKeySession.get()) {
                return $state.target(CONFIGURATION_ROUTE);
            }

        });

    });

})();