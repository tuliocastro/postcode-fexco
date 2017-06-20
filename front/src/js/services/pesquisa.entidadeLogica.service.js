;
(function () {

    angular.module(CONSTANTS.APP).service('PesquisaEntidadeLogicaService', Service);

    function Service(API) {

        return {

            fazerCarga: function () {
                return API.get({
                    url: 'visualizador/cargaMongo'
                });

            },

            filtrar: function (filtro) {
                return API.post({
                    data: {
                        filtro: filtro
                    },
                    url: 'visualizador/pesquisa/filtrar'
                });

            },

            recuperarTodosOperadores: function () {
                return API.get({
                    url: 'visualizador/pesquisa/operadores'
                });

            }

        }

    }

})();
