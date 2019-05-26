package com.github.jinahya.org.random.api.release2.bind.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.jinahya.jsonrpc2.bind.ErrorObject;
import com.github.jinahya.jsonrpc2.bind.ResponseObject;
import com.github.jinahya.org.random.api.release2.bind.IntegralBase;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class GenerateIntegerSequencesResponseObject
        extends ResponseObject<GenerateIntegerSequencesResponseObject.Result, ErrorObject.Undefined> {

    // -----------------------------------------------------------------------------------------------------------------
    @Setter
    @Getter
    public static class Result {

        @Setter
        @Getter
        public static class Random {

            // -----------------------------------------------------------------------------------------------------------------

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "data=" + Arrays.toString(data) +
                       ",completionTime=" + completionTime +
                       "}";
            }

            // -----------------------------------------------------------------------------------------------------------------
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Random)) return false;
                Random random = (Random) o;
                return Arrays.equals(data, random.data) &&
                       Objects.equals(completionTime, random.completionTime);
            }

            @Override
            public int hashCode() {
                int result = Objects.hash(completionTime);
                result = 31 * result + Arrays.hashCode(data);
                return result;
            }

            // ---------------------------------------------------------------------------------------------------------
//            @JsonIgnore
//            @JsonbTransient
//            public IntStream getDataStream(final ToIntFunction<Object> mapper) {
//                return Arrays.stream(data).mapToInt(mapper);
//            }
//
//            @JsonIgnore
//            @JsonbTransient
//            public IntStream getDataStream(final Integer base) {
//                if (false) { // TODO: 2019-05-26 fix this!
//                    return getDataStream(IntegralBase.ofNumericValue(base));
//                }
//                if (base == null || base == 2) {
//                    return getDataStream(datum -> ((Number) datum).intValue());
//                }
//                return getDataStream(datum -> Integer.parseInt((String) datum, base));
//            }
//
//            @JsonIgnore
//            @JsonbTransient
//            public IntStream getDataStream(final IntegralBase base) {
//                if (base == null || base == IntegralBase.BASE0x0A) {
//                    return getDataStream(datum -> ((Number) datum).intValue());
//                }
//                return getDataStream(datum -> Integer.parseInt((String) datum, base.getNumericValue()));
//            }

            // ---------------------------------------------------------------------------------------------------------
            @NotEmpty
            private Object[] data;

            @NotNull
            private String completionTime;
        }

        // -----------------------------------------------------------------------------------------------------------------

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

        // -----------------------------------------------------------------------------------------------------------------
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

        // -----------------------------------------------------------------------------------------------------------------
        @Valid
        @NotNull
        private Random random;

        private int bitsUsed;

        private int bitsLeft;

        private int requestsLeft;

        private int advisoryDelay;
    }
}
