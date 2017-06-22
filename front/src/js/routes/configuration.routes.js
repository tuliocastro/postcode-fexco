;
(function () {

    angular.module(CONSTANTS.APP).config(Routes);

    function Routes($stateProvider) {

        $stateProvider

            .state({
                name: 'configuration',
                url: '/configuration',
                templateUrl: "configuration.html",
                controller: "ConfigurationCtrl as ctrl"
            });

    }

})();