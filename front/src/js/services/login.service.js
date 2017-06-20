;
(function () {

    angular.module(CONSTANTS.APP).service('LoginService', Service);

    function Service(API) {

        return {

            login: function (data) {
                return API.post({
                    data: data,
                    url: 'visualizador/login'
                });
            },

            logout: function () {
                return API.get({
                    url: 'logout'
                });
            }

        }

    }

})();
