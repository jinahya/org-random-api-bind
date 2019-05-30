package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestParams;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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
                   ",replacement=" + replacement +
                   "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Params)) return false;
            if (!super.equals(o)) return false;
            Params params = (Params) o;
            return getN() == params.getN() &&
                   getDecimalPlaces() == params.getDecimalPlaces() &&
                   Objects.equals(getReplacement(), params.getReplacement());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getN(), getDecimalPlaces(), getReplacement());
        }

        @Setter
        @Getter
        private int n;

        @Setter
        @Getter
        private int decimalPlaces;

        @Setter
        @Getter
        private Boolean replacement;
    }
}
