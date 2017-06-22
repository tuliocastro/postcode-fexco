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
        'sticky',
        'angular-growl'
    ]);

    angular.module(CONSTANTS.APP).config(function ($urlRouterProvider, $httpProvider, growlProvider) {

        //Default Route
        $urlRouterProvider.otherwise(CONFIGURATION_ROUTE);

        //Http Interceptors
        $httpProvider.interceptors.push('HttpExceptionInterceptor');

        //Growl
        growlProvider.globalTimeToLive(5000);

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