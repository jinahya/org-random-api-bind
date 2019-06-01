package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.MAX_N;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params.MIN_N;
import static java.util.stream.Collectors.toList;

/**
 * The response class for {@link GenerateIntegersRequest}.
 */
public class GenerateIntegersResponse extends RandomOrgResponse<GenerateIntegersResponse.Result> {

    /**
     * The type for {@code result} attribute of {@link GenerateIntegersResponse}.
     */
    public static class Result extends RandomOrgResponseResult {

        public static class Random {

            static List<Object> data(@NonNull final List<Object> data) {
                return data.stream()
                        .map(v -> {
                            if (v instanceof String) {
                                return v;
                            }
                            return ((Number) v).intValue();
                        })
                        .collect(toList());
            }

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "data=" + data +
                       ",completionTime=" + completionTime +
                       "}";
            }

            public void setData(final List<Object> data) {
                this.data = data;
                if (this.data != null) {
                    this.data = data(this.data);
                }
            }

            @Size(min = MIN_N, max = MAX_N)
            @NotNull
            @Setter
            private List<@NotNull Object> data;

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
