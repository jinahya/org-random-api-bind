package com.github.jinahya.org.random.api.release2.bind.basic;

import com.github.jinahya.org.random.api.release2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.release2.bind.RandomOrgRequestParams;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

/**
 * The request object for {@value #METHOD}.
 */
public class GenerateIntegersRequest extends RandomOrgRequest<GenerateIntegersRequest.Params> {

    public static class Params extends RandomOrgRequestParams {

        public static final int MIN_N = 0x01;

        public static final int MAX_N = 0x1e4;

        public static final int MIN_MIN = -0x1e9;

        public static final int MAX_MIN = 0x1e9;

        public static final int MIN_MAX = -0x1e9;

        public static final int MAX_MAX = 0x1e9;

        @Override
        public String toString() {
            return super.toString() + "{" +
                   ",n=" + n +
                   ",min=" + min +
                   ",max=" + max +
                   ",replacement=" + replacement +
                   ",base=" + base +
                   '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Params)) return false;
            if (!super.equals(o)) return false;
            Params params = (Params) o;
            return getN() == params.getN() &&
                   getMin() == params.getMin() &&
                   getMax() == params.getMax() &&
                   Objects.equals(getReplacement(), params.getReplacement()) &&
                   getBase() == params.getBase();
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getN(), getMin(), getMax(), getReplacement(), getBase());
        }

        @Min(MIN_N)
        @Max(MAX_N)
        @Setter
        @Getter
        private int n;

        @Min(MIN_MIN)
        @Max(MAX_MIN)
        @Setter
        @Getter
        private int min;

        @Min(MIN_MAX)
        @Max(MAX_MAX)
        @Setter
        @Getter
        private int max;

        @Setter
        @Getter
        private Boolean replacement;

        @JsonbTypeAdapter(BaseTypeAdapter.class)
        @Setter
        @Getter
        private Base base;
    }

    /**
     * A constant for {@code method} attribute. The value is {@value #METHOD}.
     */
    public static final String METHOD = "generateIntegers";

    /**
     * Creates a new instance. This constructor sets the {@code method} attribute with {@value #METHOD}.
     */
    public GenerateIntegersRequest() {
        super();
        setMethod(METHOD);
    }
}
