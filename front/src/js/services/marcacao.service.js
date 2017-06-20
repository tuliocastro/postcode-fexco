;
(function () {

    angular.module(CONSTANTS.APP).service('MarcacaoService', Service);

    function Service(API) {

        return {

            recuperarTiposDocumentais: function (tokenRegistroProduto) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/marcacao/documentos/tipos'
                });

            },

            recuperarDocumentosPorTipo: function (tokenRegistroProduto, tokenTipoDocumental) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenTipoDocumental: tokenTipoDocumental
                    },
                    url: 'bureau/marcacao/documentos'
                });

            },

            carregarCampos: function (tokenRegistroProduto, tokenTipoDocumental, tokenDocumento) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenTipoDocumental: tokenTipoDocumental,
                        tokenDocumento: tokenDocumento
                    },
                    url: 'bureau/marcacao/campos'
                });
            },

            cadastrarRegistroCampo: function (tokenRegistroProduto, data) {
                return API.put({
                    data: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        form: data
                    },
                    url: 'bureau/marcacao/campo/registro'
                });
            },

            atualizarRegistroCampo: function (tokenRegistroProduto, data) {
                return API.post({
                    data: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        form: data
                    },
                    url: 'bureau/marcacao/campo/registro'
                });
            },

            removerRegistroCampo: function (tokenRegistroProduto, tokenRegistroCampo) {
                return API.delete({
                    data: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenRegistroCampo: tokenRegistroCampo
                    },
                    url: 'bureau/marcacao/campo/registro'
                });
            },

            concluirFase: function (tokenRegistroProduto) {
                return API.post({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/marcacao/concluir'
                });
            }
        }

    }

})();
