package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.Element.MAX_LENGTH;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.Element.MIN_LENGTH;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.MAX_N;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegerSequencesRequest.Params.MIN_N;

public class GenerateIntegerSequencesResponse
        extends RandomOrgResponse<GenerateIntegerSequencesResponse.Result> {

    public static class Result extends RandomOrgResponseResult {

        public static class Random {

            static boolean isEachElementInEachListInDataEitherStringOrNumber(@NonNull final List<List<Object>> data) {
                for (final List<Object> e : data) {
                    if (!GenerateIntegersResponse.Result.Random.isEachElementInDataEitherStringOrNumber(e)) {
                        return false;
                    }
                }
                return true;
            }

            static Stream<IntStream> getDataStream(@NonNull final List<List<Object>> data,
                                                   @NotNull final List<Base> base) {
                return IntStream.range(0, data.size())
                        .mapToObj(i -> GenerateIntegersResponse.Result.Random.getDataStream(data.get(i), base.get(i)));
            }

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "data=" + data +
                       ",completionTime=" + completionTime +
                       "}";
            }

            @AssertTrue
            private boolean isEachElementInEachListInDataValid() {
                return isEachElementInEachListInDataEitherStringOrNumber(getData());
            }

            public Stream<IntStream> getDataStream(@NotNull final List<Base> base) {
                return getDataStream(getData(), base);
            }

            public List<List<Object>> getData() {
                if (data == null) {
                    data = new ArrayList<>();
                }
                return data;
            }

            @Size(min = MIN_N, max = MAX_N)
            @NotNull
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

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Result)) return false;
            Result result = (Result) obj;
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
