;
(function () {

    angular.module(CONSTANTS.APP).service('UKService', Service);

    function Service(API, APIKeySession) {

        return {

            findAddress: function (query, params) {
                return API.get({
                    params: params,
                    url: APIKeySession.get() + '/address/uk/' + query
                });
            }

        }

    }

})();
