;
(function () {

    angular.module(CONSTANTS.APP).service('ProdutoService', Service);

    function Service(API) {

        return {

            recuperarTodos: function (data) {
                return API.get({
                    data: data,
                    url: 'bureau/produtos'
                });
            },

            recuperar: function (token) {
                return API.get({
                    url: 'bureau/produto/' + token
                });
            },

        }

    }

})();
