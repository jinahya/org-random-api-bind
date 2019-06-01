package com.github.jinahya.org.random.api.r2.bind.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.IntStream;

import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.MAX_N;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params.MIN_N;
import static java.lang.Integer.parseInt;
import static java.util.Optional.ofNullable;

/**
 * The response class for {@link GenerateIntegersRequest}.
 */
public class GenerateIntegersResponse extends RandomOrgResponse<GenerateIntegersResponse.Result> {

    /**
     * The type for {@code result} attribute of {@link GenerateIntegersResponse}.
     */
    public static class Result extends RandomOrgResponseResult {

        public static class Random {

            static boolean isEachElementInDataEitherStringOrNumber(@NonNull final List<Object> data) {
                for (final Object e : data) {
                    if (!(e instanceof String) && !(e instanceof Number)) {
                        return false;
                    }
                }
                return true;
            }

            static IntStream getDataStream(@NonNull final List<Object> data, final Base base) {
                return data.stream().mapToInt(e -> {
                    if (e instanceof String) {
                        return parseInt((String) e, ofNullable(base).orElse(Base.B0x0A).base);
                    }
                    return ((Number) e).intValue();
                });
            }

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "data=" + data +
                       ",completionTime=" + completionTime +
                       "}";
            }

            @AssertTrue(message = "each element in data must be either an instance of String or an instance of Number")
            private boolean isEachElementInDataEitherStringOrNumber() {
                if (data == null) {
                    return true;
                }
                return isEachElementInDataEitherStringOrNumber(data);
            }

            @JsonIgnore
            @JsonbTransient
            IntStream getDataStream(final Base base) {
                if (data == null) {
                    return IntStream.empty();
                }
                return getDataStream(data, base);
            }

            @Size(min = MIN_N, max = MAX_N)
            @NotNull
            @Setter
            @Getter
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
