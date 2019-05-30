package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.Random;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class GenerateIntegersResponse extends RandomOrgResponse<GenerateIntegersResponse.Result> {

    public static class Result extends RandomOrgResponseResult {

        @Override
        public String toString() {
            return super.toString() + "{" +
                   "random=" + random +
                   ",bitsUsed=" + bitsUsed +
                   ",bitsLeft=" + bitsLeft +
                   ",requestsLeft=" + requestsLeft +
                   ",advisoryDelay=" + advisoryDelay +
                   "}";
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (!(o instanceof Result)) return false;
            Result result = (Result) o;
            return bitsUsed == result.bitsUsed &&
                   bitsLeft == result.bitsLeft &&
                   requestsLeft == result.requestsLeft &&
                   advisoryDelay == result.advisoryDelay &&
                   Objects.equals(random, result.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(random, bitsUsed, bitsLeft, requestsLeft, advisoryDelay);
        }

        @Valid
        @NotNull
        @Setter
        @Getter
        private Random random;

        @Setter
        @Getter
        private int bitsUsed;

        @Setter
        @Getter
        private int bitsLeft;

        @Setter
        @Getter
        private int requestsLeft;

        @Setter
        @Getter
        private int advisoryDelay;
    }
}
