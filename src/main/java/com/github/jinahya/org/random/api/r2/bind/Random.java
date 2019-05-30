package com.github.jinahya.org.random.api.r2.bind;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class Random {

    @Override
    public String toString() {
        return super.toString() + "{" +
               "data=" + data +
               ",completionTime=" + completionTime +
               "}";
    }

    private boolean dataEquals(final Random r) {
        assert r != null;
        if (data == r.data) {
            return true;
        }
        if (data == null || r.data == null) {
            return false;
        }
        if (data.size() != r.data.size()) {
            return false;
        }
        for (int i = 0; i < data.size(); i++) {
            final Object d1 = data.get(i);
            final Object d2 = r.data.get(i);
            if (d1 instanceof String && d2 instanceof String) { // both not null && both are Strings
                if (!d1.equals(d2)) {
                    return false;
                } else {
                    continue;
                }
            }
            if (!(d1 instanceof Number) || !(d2 instanceof Number)) {
                return false;
            }
            if (((Number) d1).intValue() != ((Number) d2).intValue()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Random)) {
            return false;
        }
        final Random random = (Random) o;
        if (!dataEquals(random)) {
            return false;
        }
        return //Arrays.equals(data, random.data) &&
                Objects.equals(completionTime, random.completionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getCompletionTime());
    }

    @NotEmpty
    @Setter
    @Getter
    private List<Object> data;

    @NotNull
    @Setter
    @Getter
    private String completionTime;
}
