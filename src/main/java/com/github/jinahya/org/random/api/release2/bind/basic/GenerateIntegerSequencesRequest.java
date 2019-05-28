package com.github.jinahya.org.random.api.release2.bind.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jinahya.org.random.api.release2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.release2.bind.RandomOrgRequestParams;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class GenerateIntegerSequencesRequest
        extends RandomOrgRequest<GenerateIntegerSequencesRequest.Params> {

    public static class Params extends RandomOrgRequestParams {

        public static class Element {

            public static final int MIN_LENGTH = 1;

            public static final int MAX_LENGTH = 10000;

            public static final int MIN_MIN = -1000000000;

            public static final int MAX_MIN = +1000000000;

            public static final int MIN_MAX = -1000000000;

            public static final int MAX_MAX = +1000000000;

            @Override
            public String toString() {
                return super.toString() + "{" +
                       "length=" + length +
                       ",min=" + min +
                       ",max=" + max +
                       ",replacement=" + replacement +
                       ",base=" + base +
                       "}";
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Element)) return false;
                Element element = (Element) o;
                return getLength() == element.getLength() &&
                       getMin() == element.getMin() &&
                       getMax() == element.getMax() &&
                       Objects.equals(getReplacement(), element.getReplacement()) &&
                       Objects.equals(getBase(), element.getBase());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getLength(), getMin(), getMax(), getReplacement(), getBase());
            }

            // ---------------------------------------------------------------------------------------------------------
            @Max(MAX_LENGTH)
            @Min(MIN_LENGTH)
            @Setter
            @Getter
            private int length;

            @Max(MAX_MIN)
            @Min(MIN_MIN)
            @Setter
            @Getter
            private int min;

            @Max(MAX_MAX)
            @Min(MIN_MAX)
            @Setter
            @Getter
            private int max;

            @Setter
            @Getter
            private Boolean replacement;

            @Setter
            @Getter
            private Integer base;
        }

        public static final int MIN_N = 1;

        public static final int MAX_N = 1000;

        @JsonProperty(value = "n")
        @JsonbProperty(value = "n")
        public int getN() {
            return getElements().size();
        }

        public Object getLength() {
            if (elements == null || elements.isEmpty()) {
                throw new IllegalStateException("no elements added");
            }
            if (getElements().size() == 1) {
                return elements.get(0).length;
            }
            return getElements().stream().mapToInt(Element::getLength).toArray();
        }

        public Object getMin() {
            if (elements == null || elements.isEmpty()) {
                throw new IllegalStateException("no elements added");
            }
            if (getElements().size() == 1) {
                return elements.get(0).min;
            }
            return getElements().stream().mapToInt(Element::getMin).toArray();
        }

        public Object getMax() {
            if (elements == null || elements.isEmpty()) {
                throw new IllegalStateException("no elements added");
            }
            if (getElements().size() == 1) {
                return elements.get(0).max;
            }
            return getElements().stream().mapToInt(Element::getMax).toArray();
        }

        List<Element> getElements() {
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

        @JsonIgnore
        @JsonbTransient
        @Size(min = MIN_N, max = MAX_N)
        @NotEmpty
        private transient List<Element> elements;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A constant for {@code method} attribute. The value is {@value #METHOD}.
     */
    public static final String METHOD = "generateIntegers";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance. This constructor sets the {@code method} attribute with {@value #METHOD}.
     */
    public GenerateIntegerSequencesRequest() {
        super();
        setMethod(METHOD);
    }
}
