package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestParams;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@Slf4j
public class GenerateIntegerSequencesRequest
        extends RandomOrgRequest<GenerateIntegerSequencesRequest.Params> {

    public static class Params extends RandomOrgRequestParams {

        public static class Element extends GenerateIntegersRequest.AbstractElement {

            public static final int MIN_LENGTH = 1;

            public static final int MAX_LENGTH = 10000;

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "length=" + length +
                       "}";
            }

            @Max(MAX_LENGTH)
            @Min(MIN_LENGTH)
            @Setter
            @Getter
            private int length;
        }

        public static Params of(@NonNull final List<? extends Element> elements) {
            if (elements.isEmpty()) {
                throw new IllegalArgumentException("empty elements");
            }
            final Params params = new Params();
            params.setN(elements.size());
            if (elements.size() == 1) {
                final Element element = elements.get(0);
                params.setLength(element.getLength());
                params.setMin(element.getMin());
                params.setMax(element.getMax());
                params.setReplacement(element.getReplacement());
                params.setBase(element.getBase());
            } else {
                params.setLength(elements.stream().map(Element::getLength).collect(toList()));
                params.setMin(elements.stream().map(Element::getMin).collect(toList()));
                params.setMax(elements.stream().map(Element::getMax).collect(toList()));
                params.setReplacement(elements.stream().map(Element::getReplacement).collect(toList()));
                params.setBase(elements.stream().map(Element::getBase).collect(toList()));
            }
            return params;
        }

        public static final int MIN_N = 1;

        public static final int MAX_N = 1000;

        @Override
        public String toString() {
            return super.toString() + "{" +
                   "n=" + n +
                   ",length=" + length +
                   ",min=" + min +
                   ",max=" + max +
                   ",replacement=" + replacement +
                   ",base=" + base +
                   "}";
        }

        private Object set(final Object value) {
            if (value == null) {
                return null;
            }
            if (value instanceof Number) {
                return ((Number) value).intValue();
            }
            if (value.getClass().isArray()) {
                final int length = Array.getLength(value);
                final List<Integer> list = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    list.add(((Number) Array.get(value, i)).intValue());
                }
                return list;
            }
            assert value instanceof Collection<?>;
            final List<Integer> list = new ArrayList<>(((Collection<?>) value).size());
            for (final Object element : ((Collection<?>) value)) {
                list.add(((Number) element).intValue());
            }
            return list;
        }

        public void setLength(final Object length) {
            this.length = set(length);
        }

        public void setMin(final Object min) {
            this.min = set(min);
        }

        public void setMax(final Object max) {
            this.max = set(max);
        }

        public void setReplacement(final Object replacement) {
            if (replacement == null) {
                this.replacement = null;
                return;
            }
            if (replacement instanceof Boolean) {
                this.replacement = replacement;
                return;
            }
            if (replacement.getClass().isArray()) {
                final int length = Array.getLength(replacement);
                final List<Boolean> list = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    list.add((Boolean) Array.get(replacement, i));
                }
                this.replacement = list;
            }
            if (true) {
                this.replacement = replacement;
                return;
            }
            assert replacement instanceof Collection<?>;
            final List<Boolean> list = new ArrayList<>(((Collection<?>) replacement).size());
            for (final Object element : ((Collection<?>) replacement)) {
                list.add((Boolean) element);
            }
            this.replacement = list;
        }

        public void setBase(final Object base) {
            if (base == null) {
                this.base = null;
                return;
            }
            if (base instanceof Number) {
                this.base = Base.valueOf(((Number) base).intValue());
                return;
            }
            if (base.getClass().isArray()) {
                final int length = Array.getLength(base);
                final List<Base> list = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    final Number number = (Number) Array.get(base, i);
                    list.add(ofNullable(number).map(Number::intValue).map(Base::valueOf).orElse(null));
                }
                this.base = list;
            }
            assert base instanceof Collection<?>;
            final List<Base> list = new ArrayList<>(((Collection<?>) base).size());
            for (final Object element : ((Collection<?>) base)) {
                list.add(ofNullable(element).map(v -> ((Number) v).intValue()).map(Base::valueOf).orElse(null));
            }
            this.base = list;
        }

        @Max(MAX_N)
        @Min(MIN_N)
        @Setter
        @Getter
        private int n;

        @NotNull
        @Getter
        private Object length;

        @NotNull
        @Getter
        private Object min;

        @NotNull
        @Getter
        private Object max;

        @Getter
        private Object replacement;

        @Getter
        private Object base;
    }

    /**
     * The fixed value for {@code method} attribute. The value is {@value #METHOD}.
     */
    public static final String METHOD = "generateIntegers";

    /**
     * Creates a new instance. This constructor sets the {@code method} attribute with {@value #METHOD}.
     */
    public GenerateIntegerSequencesRequest() {
        super();
        setMethod(METHOD);
    }
}
