;
(function () {

    angular.module(CONSTANTS.APP).service('ReferenciacaoService', Service);

    function Service(API) {

        return {

            recuperarTiposDocumentais: function (tokenRegistroProduto) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/referenciacao/documentos/tipos'
                });

            },

            recuperarDocumentosPorTipo: function (tokenRegistroProduto, tokenTipoDocumental) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenTipoDocumental: tokenTipoDocumental
                    },
                    url: 'bureau/referenciacao/documentos'
                });

            },

            carregarRegistrosCampos: function (tokenRegistroProduto, tokenDocumento) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenDocumento: tokenDocumento
                    },
                    url: 'bureau/referenciacao/campos/registros'
                });
            },

            transcreverRegistroCampo: function (tokenRegistroProduto, form) {
                return API.post({
                    data: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        form: form
                    },
                    url: 'bureau/referenciacao/campo/registro/transcrever'
                });
            },

            atualizarEstadoRegistroCampo: function (tokenRegistroProduto, form) {
                return API.post({
                    data: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        form: form
                    },
                    url: 'bureau/referenciacao/campo/registro/estado'
                });
            },

            concluirFase: function (tokenRegistroProduto) {
                return API.post({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    url: 'bureau/referenciacao/concluir'
                });
            },


            recuperarEntidadesLogicasSugeridas: function (tokenRegistroProduto, tokensRegistrosCampos) {
                return API.post({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokensRegistrosCampos: tokensRegistrosCampos
                    },
                    url: 'bureau/referenciacao/entidades/logicas/sugestao'
                });
            },

            recuperarRegistrosLogicosPorDocumento: function (tokenRegistroProduto, tokenDocumento) {
                return API.get({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenDocumento: tokenDocumento
                    },
                    url: 'bureau/referenciacao/documento/registros/logicos'
                });
            },

            recuperarRegistrosEntidadesLogicasSugeridas: function (tokenRegistroProduto, form) {

                return API.post({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto
                    },
                    data: {
                        form: form
                    },
                    url: 'bureau/referenciacao/registros/entidades/logicas/sugestao'
                });

            },

            cadastrarRegistroEntidadeLogica: function (tokenRegistroProduto, tokenEntidadeLogica, tokensRegistrosCampos, tokensRegistrosEntidadesLogicas) {
                return API.put({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                    },
                    data: {
                        form: {
                            tokenEntidadeLogica: tokenEntidadeLogica,
                            tokensRegistrosCampos: tokensRegistrosCampos,
                            tokensRegistrosEntidadesLogicas: tokensRegistrosEntidadesLogicas
                        }
                    },
                    url: 'bureau/referenciacao/registro/entidade/logica'
                });
            },

            removerRegistroEntidadeLogica: function (tokenRegistroProduto, tokenRegistroEntidadeLogica) {
                return API.delete({
                    params: {
                        tokenRegistroProduto: tokenRegistroProduto,
                        tokenRegistroEntidadeLogica: tokenRegistroEntidadeLogica
                    },
                    url: 'bureau/referenciacao/registro/entidade/logica'
                });
            },


        }

    }

})();
