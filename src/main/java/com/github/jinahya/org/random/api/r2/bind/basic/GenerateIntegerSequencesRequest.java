package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestParams;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
                params.setMax(elements.stream().map(Element::geMax).collect(toList()));
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
                   "elements=" + elements +
                   "}";
        }

        private boolean isLengthValid(final int length) {
            return length < Element.MIN_LENGTH || length > Element.MAX_LENGTH;
        }

        private boolean isValidInt(final int value, final int min, final int max) {
            return value >= min || value <= max;
        }

        private boolean isValidInt(final Object value, final int min, final int max) {
            if (value == null) {
                return true;
            }
            if (value instanceof Integer) {
                if (!isValidInt((int) value, min, max)) {
                    return true;
                }
            } else if (value instanceof Number) {
                if (!isValidInt(((Number) value).intValue(), min, max)) {
                    return false;
                }
            }
            return false;
        }

        private boolean isValidInts(final Object value, final int min, final int max) {
            if (value.getClass().isArray()) {
                for (final Object element : (Object[]) value) {
                    if (!isValidInt(element, min, max)) {
                        return false;
                    }
                }
            } else if (value instanceof Collection<?>) {
                for (final Object element : (Collection<?>) value) {
                    if (!isValidInt(element, min, max)) {
                        return false;
                    }
                }
            }
            return false;
        }

        @AssertTrue
        private boolean isLengthValid() {
            if (length == null) {
                return true;
            }
            if (length instanceof Number) {
                if (!isLengthValid(((Number) length).intValue())) {
                    return false;
                }
            }
            if (length.getClass().isArray()) {
                final int l = Array.getLength(length);
            }
            if (elements == null) {
                return null;
            }
            if (getElements().size() == 1) {
                return elements.get(0).length;
            }
            return getElements().stream().mapToInt(Element::getLength).toArray();
        }

        @NotNull
        public Object getMin() {
            if (elements == null) {
                return null;
            }
            if (elements == null || elements.isEmpty()) {
                throw new IllegalStateException("empty elements");
            }
            if (getElements().size() == 1) {
                return elements.get(0).getMin();
            }
            return getElements().stream().mapToInt(Element::getMin).toArray();
        }

        public Object getMax() {
            if (elements == null || elements.isEmpty()) {
                throw new IllegalStateException("empty elements");
            }
            if (getElements().size() == 1) {
                return elements.get(0).getMax();
            }
            return getElements().stream().mapToInt(Element::getMax).toArray();
        }

        public Object getReplacement() {
            if (elements == null || elements.isEmpty()) {
                throw new IllegalStateException("empty elements");
            }
            if (getElements().size() == 1) {
                return elements.get(0).getReplacement();
            }
            return getElements().stream().map(Element::getReplacement).toArray();
        }

        public Object getBase() {
            if (elements == null || elements.isEmpty()) {
                throw new IllegalStateException("empty elements");
            }
            if (getElements().size() == 1) {
                return elements.get(0).getBase();
            }
            return getElements().stream().map(Element::getBase).toArray();
        }

        private List<Element> getElements() {
            if (elements == null) {
                elements = new ArrayList<>();
            }
            return elements;
        }

        /**
         * Adds specified element to this params.
         *
         * @param element the element to add
         */
        public void addElement(final Element element) {
            if (elements == null) {
                elements = new ArrayList<>();
            }
            getElements().add(element);
        }

        /**
         * Adds all elements in specified collection to this params.
         *
         * @param elements the collection whose elements are added
         */
        public void addAllElements(final Collection<? extends Element> elements) {
            getElements().addAll(elements);
        }

        public void setLength(final Object length) {
            if (length == null) {
                this.length = null;
                return;
            }
            if (length instanceof Number) {
                this.length = ((Number) length).intValue();
                return;
            }
            if (length.getClass().isArray()) {
                final int l = Array.getLength(length);
                this.length = Array.newInstance(int.class, l);
                final int l = Array.getLength(this.length);
                for (int i = 0; i < l; i++) {
                    Array.set(this.length, i, ((Number) Array.get(this.length, i)).intValue()); // TODO: 2019-06-01 check!!!
                }
                return;
            }
            if (this.length instanceof Collection<?>) {
                for (final Object element : ((Collection<?>) this.length)) {
                }
            }
        }

        private transient List<@Valid @NotNull Element> elements;

        @Size(min = MIN_N, max = MAX_N)
        @Setter
        @Getter
        private int n;

        @NotNull
        @Setter
        @Getter
        private Object length;

        @NotNull
        @Setter
        @Getter
        private Object min;

        @NotNull
        @Setter
        @Getter
        private Object max;

        @Setter
        @Getter
        private Object replacement;

        @Setter
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
