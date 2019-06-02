package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateDecimalFractionsRequest.Params.MAX_N;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateDecimalFractionsRequest.Params.MIN_N;

public class GenerateDecimalFractionsResponse extends RandomOrgResponse<GenerateDecimalFractionsResponse.Result> {

    public static class Result extends RandomOrgResponseResult {

        public static class Random {

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "data=" + data +
                       ",completionTime=" + completionTime +
                       "}";
            }

            @Size(min = MIN_N, max = MAX_N)
            @Setter
            @Getter
            private List<Double> data;

            @Setter
            @Getter
            private String completionTime;
        }

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

        @Valid
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
