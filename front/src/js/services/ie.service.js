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
                    url: APIKeySession.get() + '/addressgeo/ie/' + query
                });
            },

            findPosition: function (query, params) {
                return API.get({
                    params: params,
                    url: APIKeySession.get() + '/position/ie/' + query
                });
            },

            findReverseGeo: function (latitude, longitude, params) {
                console.log('finding reverse geo');
                return API.get({
                    params: params,
                    url: APIKeySession.get() + '/rgeo/ie/' + latitude + '/' + longitude
                });
            }

        }

    }

})();
