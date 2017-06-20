;
(function () {

    angular.module(CONSTANTS.APP).service('RegistroProdutoService', Service);

    function Service(API, LoginSession, GlobalConstantes) {

        return {

            recuperarTodosDisponiveis: function () {
                return API.get({
                    url: 'bureau/produtos/registros/disponiveis'
                });
            },

            recuperarTodosAlocados: function () {
                return API.get({
                    url: 'bureau/produtos/registros/alocados'
                });
            },

            recuperar: function (token) {
                return API.get({
                    url: 'bureau/produto/registro/' + token
                });
            },

            trabalhar: function (token) {
                return API.post({
                    url: 'bureau/produto/registro/' + token + '/trabalhar'
                });
            },

            arquivo: function (token) {
                return API.post({
                    url: 'bureau/produto/registro/' + token + '/arquivo'
                });
            },

            getUrlArquivo: function (tokenRegistroProduto) {

                var url = GlobalConstantes.API_BASE_ENDPOINT + '/bureau/produto/registro/{0}/arquivo?___tu={1}&___ts={2}';

                var tokenLogin = LoginSession.getTokenUsuario();

                var tokenSessao = LoginSession.getTokenSessao();

                return url.format(tokenRegistroProduto, tokenLogin, tokenSessao);

            }

        }

    }

})();
