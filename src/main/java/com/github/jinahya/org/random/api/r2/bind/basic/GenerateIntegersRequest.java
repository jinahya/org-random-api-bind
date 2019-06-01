package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestParams;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * The request object for {@value #METHOD}.
 */
@Slf4j
public class GenerateIntegersRequest extends RandomOrgRequest<GenerateIntegersRequest.Params> {

    public static abstract class AbstractElement extends RandomOrgRequestParams {

        public static final int MIN_MIN = -1000000000;

        public static final int MAX_MIN = +1000000000;

        public static final int MIN_MAX = -1000000000;

        public static final int MAX_MAX = +1000000000;

        @Override
        public String toString() {
            return super.toString() + "{" +
                   ",min=" + min +
                   ",max=" + max +
                   ",replacement=" + replacement +
                   ",base=" + base +
                   "}";
        }

        @AssertTrue(message = "min must be less than or equal to max")
        private boolean isMinIsLessThanOrEqualsToMax() {
            return min <= max;
        }

        @Max(MAX_MIN)
        @Min(MIN_MIN)
        @Setter
        @Getter
        private int min;

        @Max(MAX_MAX)
        @Min(MIN_MAX)
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
     * Value type for {@code params} attribute of {@link GenerateIntegersRequest}.
     */
    public static class Params extends AbstractElement {

        public static final int MIN_N = 1;

        public static final int MAX_N = 10000; // 1e4

        @Override
        public String toString() {
            return super.toString() + "{" +
                   "n=" + n +
                   "}";
        }

        @Min(MIN_N)
        @Max(MAX_N)
        @Setter
        @Getter
        private int n;
    }

    /**
     * The fixed value for {@code method} attribute. The value is {@value #METHOD}.
     */
    public static final String METHOD = "generateIntegers";

    /**
     * Creates a new instance. This constructor sets the {@code method} attribute with {@value #METHOD}.
     */
    public GenerateIntegersRequest() {
        super();
        setMethod(METHOD);
    }

    @Pattern(regexp = METHOD)
    @Override
    public String getMethod() {
        return super.getMethod();
    }
}
