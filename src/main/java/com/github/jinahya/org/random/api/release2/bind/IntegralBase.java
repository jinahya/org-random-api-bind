package com.github.jinahya.org.random.api.release2.bind;

import lombok.Getter;

@Getter
public enum IntegralBase {

    // -----------------------------------------------------------------------------------------------------------------
    BASE0x02(0x02),

    BASE0x08(0x08),

    BASE0x0A(0x0A),

    BASE0x10(0x10);

    // -----------------------------------------------------------------------------------------------------------------
    public static IntegralBase ofNumericValue(final int numericValue) {
        for (final IntegralBase value : values()) {
            if (value.numericValue == numericValue) {
                return value;
            }
        }
        throw new IllegalArgumentException("unknown numeric value: " + numericValue);
    }

    // -----------------------------------------------------------------------------------------------------------------
    IntegralBase(final int numericValue) {
        this.numericValue = numericValue;
    }

    // -----------------------------------------------------------------------------------------------------------------
    final int numericValue;
}
