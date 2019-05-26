package com.github.jinahya.org.random.api.release2.bind.basic;

import com.github.jinahya.jsonrpc2.bind.RequestObject;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static com.github.jinahya.org.random.api.release2.bind.basic.GenerateIntegersRequestObject.Params.isValidBase;

public class GenerateIntegerSequencesRequestObject extends RequestObject<GenerateIntegerSequencesRequestObject.Params> {

    @Setter
    @Getter
    public static class Params {

        // -------------------------------------------------------------------------------------------------------------
        public static final int MIN_N = 1;

        public static final int MAX_N = 1000;

        // -----------------------------------------------------------------------------------------------------------------
        public static final int MIN_LENGTH = 1;

        public static final int MAX_LENGTH = 10000;

        // -------------------------------------------------------------------------------------------------------------
        public static final int MIN_MIN = -1000000000;

        public static final int MAX_MIN = +1000000000;

        // -------------------------------------------------------------------------------------------------------------
        public static final int MIN_MAX = -1000000000;

        public static final int MAX_MAX = +1000000000;

        // -------------------------------------------------------------------------------------------------------------
//        @JsonIgnore
//        @JsonbTransient
//        @AssertTrue(message = "a non-null value of base attribute must be either 2, 8, 10, or 16")
//        public boolean isBaseValid() {
//            return base == null || (base == 2 || base == 8 || base == 10 || base == 16);
//        }

        // -------------------------------------------------------------------------------------------------------------
        @Override
        public String toString() {
            return super.toString() + "{" +
                   "apiKey=" + apiKey +
                   ",n=" + n +
                   ",length=" + length +
                   ",min=" + min +
                   ",max=" + max +
                   ",replacement=" + replacement +
                   ",base=" + base +
                   '}';
        }

        // -------------------------------------------------------------------------------------------------------------

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Params)) return false;
            Params params = (Params) o;
            return n == params.n &&
                   Objects.equals(apiKey, params.apiKey) &&
                   Objects.equals(length, params.length) &&
                   Objects.equals(min, params.min) &&
                   Objects.equals(max, params.max) &&
                   Objects.equals(replacement, params.replacement) &&
                   Objects.equals(base, params.base);
        }

        @Override
        public int hashCode() {
            return Objects.hash(apiKey, n, length, min, max, replacement, base);
        }

        // -------------------------------------------------------------------------------------------------------------
        private boolean isIntArrayOrInteger(final Object value, final int min, final int max) {
            if (value == null) {
                return true;
            }
            if (value instanceof int[]) {
                return ((int[]) value).length == n;
            }
            if (!(value instanceof Integer)) {
                return false;
            }
            return ((int) value) >= min && ((int) value) <= max;
        }

        @AssertTrue
        private boolean isLengthValid() {
            return isIntArrayOrInteger(length, MIN_LENGTH, MAX_LENGTH);
        }

        @AssertTrue
        private boolean isMinValid() {
            return isIntArrayOrInteger(min, MIN_MIN, MAX_MIN);
        }

        @AssertTrue
        private boolean isMaxValid() {
            return isIntArrayOrInteger(max, MIN_MAX, MAX_MAX);
        }

        @AssertTrue
        private boolean isReplacementValid() {
            if (replacement == null) {
                return true;
            }
            if (replacement instanceof boolean[]) {
                return ((boolean[]) replacement).length == n;
            }
            return replacement instanceof Boolean;
        }

        @AssertTrue
        private boolean isBaseValid() {
            if (base == null) {
                return true;
            }
            if (base instanceof int[]) {
                if (((int[]) replacement).length != n) {
                    return false;
                }
                for (final int b : ((int[]) base)) {
                    if (!isValidBase(b)) {
                        return false;
                    }
                }
            }
            if (!(base instanceof Integer)) {
                return false;
            }
            if (!isValidBase((int) base)) {
                return false;
            }
            return true;
        }

        // -------------------------------------------------------------------------------------------------------------
        @NotNull
        private String apiKey;

        @Min(MIN_N)
        @Max(MAX_N)
        private int n;

        @NotNull
        private Object length;

        private Object min;

        private Object max;

        // -------------------------------------------------------------------------------------------------------------
        private Object replacement;

        private Object base;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A constant for {@code method} attribute. The value is {@value #METHOD}.
     */
    public static final String METHOD = "generateIntegers";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance. This constructor sets the {@code method} attribute with {@value #METHOD}.
     */
    public GenerateIntegerSequencesRequestObject() {
        super();
        setMethod(METHOD);
    }
}
