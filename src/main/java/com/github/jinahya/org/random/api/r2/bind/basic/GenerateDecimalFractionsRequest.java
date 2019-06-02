package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestParams;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class GenerateDecimalFractionsRequest extends RandomOrgRequest<GenerateDecimalFractionsRequest.Params> {

    public static class Params extends RandomOrgRequestParams {

        public static final int MIN_N = 1;

        public static final int MAX_N = 10000;

        public static final int MIN_DECIMAL_PLACES = 1;

        public static final int MAX_DECIMAL_PLACES = 14;

        @Override
        public String toString() {
            return super.toString() + "{" +
                   "n=" + n +
                   ",decimalPlaces=" + decimalPlaces +
                   "}";
        }

        @Max(MAX_N)
        @Min(MIN_N)
        @Setter
        @Getter
        private int n;

        @Max(MAX_DECIMAL_PLACES)
        @Min(MIN_DECIMAL_PLACES)
        @Setter
        @Getter
        private int decimalPlaces;

        @Setter
        @Getter
        private Boolean replacement;
    }
}
