package com.fexco.postcode.dto.request;

import java.io.Serializable;

/**
 * É uma boa pratica colocar a requisicao em objetos pois dessa forma podemos tratar os campos pelo tipo,
 * aplicar Regras de negocios especificas e/ou colocar valores padrões para os campos.
 */
public class PremiseRequest implements Serializable {

    public Integer lines;

    public String include;

    public String exclude;

    public String format = "json";

    public String addtags;

    public String identifier;

    public String callback;

    public Integer page = 0;

    public Boolean postcodeonly;

    public Boolean alias;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremiseRequest that = (PremiseRequest) o;

        if (lines != null ? !lines.equals(that.lines) : that.lines != null) return false;
        if (include != null ? !include.equals(that.include) : that.include != null) return false;
        if (exclude != null ? !exclude.equals(that.exclude) : that.exclude != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (addtags != null ? !addtags.equals(that.addtags) : that.addtags != null) return false;
        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        if (callback != null ? !callback.equals(that.callback) : that.callback != null) return false;
        if (page != null ? !page.equals(that.page) : that.page != null) return false;
        if (postcodeonly != null ? !postcodeonly.equals(that.postcodeonly) : that.postcodeonly != null) return false;
        return alias != null ? alias.equals(that.alias) : that.alias == null;

    }

    @Override
    public int hashCode() {
        int result = lines != null ? lines.hashCode() : 0;
        result = 31 * result + (include != null ? include.hashCode() : 0);
        result = 31 * result + (exclude != null ? exclude.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (addtags != null ? addtags.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (callback != null ? callback.hashCode() : 0);
        result = 31 * result + (page != null ? page.hashCode() : 0);
        result = 31 * result + (postcodeonly != null ? postcodeonly.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        return result;
    }
}
