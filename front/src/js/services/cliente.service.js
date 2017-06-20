;
(function () {

    angular.module(CONSTANTS.APP).service('ClienteService', Service);

    function Service(API) {

        return {

            recuperarTodos: function (data) {
                return API.get({
                    data: data,
                    url: 'visualizador/clientes'
                });
            },

            recuperar: function (token) {
                return API.get({
                    url: 'visualizador/cliente/' + token
                });
            }

        }

    }

})();
