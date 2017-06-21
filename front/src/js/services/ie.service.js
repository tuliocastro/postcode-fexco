;
(function () {

    angular.module(CONSTANTS.APP).service('IEService', Service);

    function Service(API, APIKeySession) {

        return {

            findAddress: function (query, params) {
                return API.get({
                    params: params,
                    url: APIKeySession.get() + '/address/ie/' + query
                });
            },

            findAddressGeo: function (query, params) {
                return API.get({
                    params: params,
                    url: APIKeySession.get() + '/address/ie/' + query
                });
            },

            findPosition: function (query, params) {
                return API.get({
                    params: params,
                    url: APIKeySession.get() + '/address/ie/' + query
                });
            },

            findReverseGeo: function (query, params) {
                return API.get({
                    params: params,
                    url: APIKeySession.get() + '/address/ie/' + query
                });
            }

        }

    }

})();
