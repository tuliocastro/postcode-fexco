;
(function () {

    angular.module(CONSTANTS.APP).factory('API', Factory);

    function Factory(GlobalConstants, $http, $httpParamSerializerJQLike) {

        var DEFAULT_OPTS = {loading: true};

        function buildURL(url) {
            return GlobalConstants.API_BASE_ENDPOINT + '/' + url;
        }

        return {

            engine: function (opts) {

                var promise = $http({
                    data: opts.data,
                    method: opts.method,
                    headers: opts.headers,
                    url: buildURL(opts.url),
                    params: opts.params,
                    transformRequest: opts.transformRequest
                });

                if (opts.loading) {
                    // TODO promise.finally(loading.stop);
                }

                return promise;

            },

            upload: function (opts) {

                var _opts = angular.extend({
                    method: 'POST',
                    headers: {
                        'Content-Type': undefined
                    },
                    transformRequest: null
                }, DEFAULT_OPTS, opts);

                return this.engine(_opts);

            },

            get: function (opts) {

                var _opts = angular.extend({
                    method: 'GET',
                    transformRequest: null
                }, DEFAULT_OPTS, opts);

                return this.engine(_opts);

            },

            post: function (opts) {

                var _opts = angular.extend({
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    },
                    transformRequest: $httpParamSerializerJQLike
                }, DEFAULT_OPTS, opts);

                return this.engine(_opts);

            },

            put: function (opts) {

                var _opts = angular.extend({
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    },
                    transformRequest: $httpParamSerializerJQLike
                }, DEFAULT_OPTS, opts);

                return this.engine(_opts);

            },

            delete: function (opts) {

                var _opts = angular.extend({
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    },
                    transformRequest: $httpParamSerializerJQLike
                }, DEFAULT_OPTS, opts);

                return this.engine(_opts);

            }

        };

    }

})();