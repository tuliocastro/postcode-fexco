;
(function () {

    angular.module(CONSTANTS.APP).factory('HttpExceptionInterceptor', Factory);

    function Factory($q, $injector) {

        return {

            responseError: function (response) {

                var data = response.data;

                if (response.status !== 200 && data && data.message) {
                    console.log('show growl');
                    $injector.get('growl').error(data.message);
                }

                return $q.reject(response);

            }

        };

    }

})();