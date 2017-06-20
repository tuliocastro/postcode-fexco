;
(function () {

    angular.module(CONSTANTS.APP).service('DocumentoService', Service);

    function Service(API, GlobalConstantes, LoginSession) {

        return {

            getUrlArquivo: function (tokenDocumento) {

                var url = GlobalConstantes.API_BASE_ENDPOINT + '/bureau/documento/{0}/arquivo?___tu={1}&___ts={2}';

                var tokenLogin = LoginSession.getTokenUsuario();

                var tokenSessao = LoginSession.getTokenSessao();

                return url.format(tokenDocumento, tokenLogin, tokenSessao);

            }

        }

    }

})();
