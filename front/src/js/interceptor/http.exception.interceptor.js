;
(function () {

    angular.module(CONSTANTS.APP).factory('HttpExceptionInterceptor', Factory);

    function Factory($q, $injector) {

        return {

            responseError: function (response) {

                if (response.status < 0) {
                    $injector.get('growl').error("Server API is not responding...");
                    return $q.reject(response);
                }

                var data = response.data;

                if (response.status !== 200 && data && data.message) {
                    $injector.get('growl').error(data.message);
                }

                return $q.reject(response);

            }

        };

    }

})();