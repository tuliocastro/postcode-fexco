;
(function () {

    angular.module(CONSTANTS.APP).config(Routes);

    function Routes($stateProvider) {

        $stateProvider

            .state({
                name: 'postcoder',
                url: '/postcoder',
                template: CONSTANTS.EMPTY_TEMPLATE,
                abstract: true
            })

            .state({
                name: 'postcoder.api',
                url: '/api',
                templateUrl: "postcoder/api.html",
                controller: "PostcoderAPICtrl as ctrl",
                resolve: {
                    _lookups: function (LookupServiceExecutor) {

                        console.log(LookupServiceExecutor);
                        return LookupServiceExecutor.list();
                    }

                }
            });

    }

})();