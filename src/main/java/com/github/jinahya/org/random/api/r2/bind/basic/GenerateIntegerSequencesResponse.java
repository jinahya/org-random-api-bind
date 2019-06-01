package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.Element.MAX_LENGTH;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.Element.MIN_LENGTH;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.MAX_N;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.MIN_N;
import static java.util.stream.Collectors.toList;

public class GenerateIntegerSequencesResponse
        extends RandomOrgResponse<GenerateIntegerSequencesResponse.Result> {

    public static class Result extends RandomOrgResponseResult {

        public static class Random {

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "data=" + data +
                       ",completionTime=" + completionTime +
                       "}";
            }

            public void setData(final List<List<Object>> data) {
                this.data = data;
                if (this.data != null) {
                    this.data = this.data.stream().map(GenerateIntegersResponse.Result.Random::data).collect(toList());
                }
            }

            @Size(min = MIN_N, max = MAX_N)
            @NotNull
            @Getter
            private List<@Size(min = MIN_LENGTH, max = MAX_LENGTH) @NotNull List<@NotNull Object>> data;

            @NotNull
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
