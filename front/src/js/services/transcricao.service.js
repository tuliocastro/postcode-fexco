;
(function () {

    angular.module(CONSTANTS.APP).service('TranscricaoService', Service);

    function Service(API) {

        return {

            recuperarTiposDocumentais: function (tokenRegistroProduto) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/transcricao/documentos/tipos'
                });

            },

            recuperarDocumentosPorTipo: function (tokenRegistroProduto, tokenTipoDocumental) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenTipoDocumental: tokenTipoDocumental
                    },
                    url: 'bureau/transcricao/documentos'
                });

            },

            carregarRegistrosCampos: function (tokenRegistroProduto, tokenDocumento) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenDocumento: tokenDocumento
                    },
                    url: 'bureau/transcricao/campos/registros'
                });
            },

            transcreverRegistroCampo: function (tokenRegistroProduto, form) {
                return API.post({
                    data: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        form: form
                    },
                    url: 'bureau/transcricao/campo/registro/transcrever'
                });
            },

            atualizarEstadoRegistroCampo: function (tokenRegistroProduto, form) {
                return API.post({
                    data: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        form: form
                    },
                    url: 'bureau/transcricao/campo/registro/estado'
                });
            },

            concluirFase: function (tokenRegistroProduto) {
                return API.post({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/transcricao/concluir'
                });
            }
        }

    }

})();
