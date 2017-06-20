;
(function () {

    angular.module(CONSTANTS.APP).service('EntidadeLogicaService', Service);

    function Service(API) {

        return {

            recuperarTodos: function (data) {
                return API.get({
                    data: data,
                    url: 'visualizador/entidadeslogicas'
                });
            },
        }

    }

})();
