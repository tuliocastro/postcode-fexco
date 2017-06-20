;
(function () {

    angular.module(CONSTANTS.APP).service('IdentificacaoDocumentoService', Service);

    function Service(API) {

        return {

            recuperarTodosPorProduto: function (tokenRegistroProduto) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/identificacao/documentos/tipos'
                });

            },

            cadastrarDocumento: function (tokenRegistroProduto, data) {
                return API.put({
                    data: {
                        form: data,
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/identificacao/documento'
                });
            },

            alterarDocumento: function (tokenRegistroProduto, data) {
                return API.post({
                    data: {
                        form: data,
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/identificacao/documento'
                });
            },

            removerDocumento: function (tokenRegistroProduto, tokenDocumento) {
                return API.delete({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenDocumento: tokenDocumento
                    },
                    url: 'bureau/identificacao/documento'
                });
            },

            concluirFase: function (tokenRegistroProduto) {
                return API.post({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/identificacao/concluir'
                });
            },


        }

    }

})();
