package com.github.jinahya.org.random.api.r2.bind;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public abstract class RandomOrgRequestParams implements Serializable {

    @Override
    public String toString() {
        return super.toString() + "{" +
               "apiKey=" + apiKey +
               "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RandomOrgRequestParams)) return false;
        RandomOrgRequestParams that = (RandomOrgRequestParams) o;
        return Objects.equals(apiKey, that.apiKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey);
    }

    @NotEmpty
    private String apiKey;
}
