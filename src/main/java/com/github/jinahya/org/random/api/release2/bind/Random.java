package com.github.jinahya.org.random.api.release2.bind;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

public class Random {

    @Override
    public String toString() {
        return super.toString() + "{" +
               "data=" + Arrays.toString(data) +
               ",completionTime=" + completionTime +
               "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Random)) return false;
        Random random = (Random) o;
        return Arrays.equals(data, random.data) &&
               Objects.equals(completionTime, random.completionTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(completionTime);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @NotEmpty
    @Setter
    @Getter
    private Object[] data;

    @NotNull
    @Setter
    @Getter
    private String completionTime;
}
