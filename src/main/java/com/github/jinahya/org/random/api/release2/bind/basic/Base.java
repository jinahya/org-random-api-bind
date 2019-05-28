package com.github.jinahya.org.random.api.release2.bind.basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Base {

    // -----------------------------------------------------------------------------------------------------------------
    B0x02(Bases.B0x02),

    B0x08(Bases.B0x08),

    B0x0A(Bases.B0x0A),

    B0x10(Bases.B0x10);

    // -----------------------------------------------------------------------------------------------------------------
    // TODO: 2019-05-28 check if can be omitted
    // https://github.com/FasterXML/jackson-databind/issues/1850
    @JsonCreator
    public static Base valueOf(final int base) {
        for (final Base value : values()) {
            if (value.base == base) {
                return value;
            }
        }
        throw new IllegalArgumentException("unknown base: " + base);
    }

    // -----------------------------------------------------------------------------------------------------------------
    Base(final int base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
               "base=" + base +
               "}";
    }

    // -----------------------------------------------------------------------------------------------------------------
    @JsonValue
    @Getter
    final int base;
}
