;
(function () {

    angular.module(CONSTANTS.APP).service('UsuarioService', Service);

    function Service(API) {

        return {

            recuperarTodos: function (data) {
                return API.get({
                    data: data,
                    url: 'bureau/usuarios'
                });
            },

            recuperar: function (token) {
                return API.get({
                    url: 'bureau/usuario/' + token
                });
            },

        }

    }

})();
