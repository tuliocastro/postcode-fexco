;
(function () {

    angular.module(CONSTANTS.APP).service('UsuarioPerfilService', Service);

    function Service(API) {

        return {

            recuperarTodos: function () {
                return API.get({
                    url: 'usuarios/perfis'
                });
            }

        }

    }

})();
