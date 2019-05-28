package com.github.jinahya.org.random.api.release2.bind.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.jinahya.jsonrpc2.bind.RequestObject;
import com.github.jinahya.org.random.api.release2.bind.RandomOrgRequestObject;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class GenerateIntegersRequestObject extends RandomOrgRequestObject<GenerateIntegersRequestObject.Params> {

    @Setter
    @Getter
    public static class Params {

        public static final int MIN_N = 0x01;

        public static final int MAX_N = 0x1e4;

        public static final int MIN_MIN = -0x1e9;

        public static final int MAX_MIN = 0x1e9;

        public static final int MIN_MAX = -0x1e9;

        public static final int MAX_MAX = 0x1e9;

        static boolean isValidBase(final int base) {
            return base == 2 || base == 8 || base == 10 || base == 16;
        }

        @Override
        public String toString() {
            return super.toString() + "{" +
                   "apiKey=" + apiKey +
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
            Params params = (Params) o;
            return n == params.n &&
                   min == params.min &&
                   max == params.max &&
                   Objects.equals(apiKey, params.apiKey) &&
                   Objects.equals(replacement, params.replacement) &&
                   Objects.equals(base, params.base);
        }

        @Override
        public int hashCode() {
            return Objects.hash(apiKey, n, min, max, replacement, base);
        }

        @JsonIgnore
        @JsonbTransient
        @AssertTrue(message = "a non-null value of base attribute must be either 2, 8, 10, or 16")
        public boolean isBaseValid() {
            return base == null || isValidBase(base);
        }

        @NotNull
        private String apiKey;

        @Min(MIN_N)
        @Max(MAX_N)
        private int n;

        @Min(MIN_MIN)
        @Max(MAX_MIN)
        private int min;

        @Min(MIN_MAX)
        @Max(MAX_MAX)
        private int max;

        private Boolean replacement;

        private Integer base;
    }

    /**
     * A constant for {@code method} attribute. The value is {@value #METHOD}.
     */
    public static final String METHOD = "generateIntegers";

    /**
     * Creates a new instance. This constructor sets the {@code method} attribute with {@value #METHOD}.
     */
    public GenerateIntegersRequestObject() {
        super();
        setMethod(METHOD);
    }
}
