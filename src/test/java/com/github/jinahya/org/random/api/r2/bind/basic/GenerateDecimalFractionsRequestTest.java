package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateDecimalFractionsRequestTest extends RandomOrgRequestTest<GenerateDecimalFractionsRequest> {

    GenerateDecimalFractionsRequestTest() {
        super(GenerateDecimalFractionsRequest.class);
    }

    @Override
    protected void acceptValueFromResource(final String name,
                                           final Consumer<? super GenerateDecimalFractionsRequest> consumer)
            throws IOException {
        super.acceptValueFromResource(name, v -> {
            consumer.accept(v);
            assertEquals("generateDecimalFractions", v.getMethod());
        });
    }

    @Test
    void generateDecimalFractions_01_request() throws IOException {
        acceptValueFromResource("/example/basic/generateDecimalFractions_01_request.json", v -> {
            assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", v.getParams().getApiKey());
            assertEquals(10, v.getParams().getN());
            assertEquals(8, v.getParams().getDecimalPlaces());
            assertEquals(true, v.getParams().getReplacement());
        });
    }

    @Test
    void generateDecimalFractions_02_request() throws IOException {
        acceptValueFromResource("/example/basic/generateDecimalFractions_02_request.json", v -> {
            assertEquals(3076L, v.getId());
            assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", v.getParams().getApiKey());
            assertEquals(4, v.getParams().getN());
            assertEquals(2, v.getParams().getDecimalPlaces());
            assertEquals(false, v.getParams().getReplacement());
        });
    }

    @Test
    void generateDecimalFractions_03_request() throws IOException {
        acceptValueFromResource("/example/basic/generateDecimalFractions_03_request.json", v -> {
            assertEquals(4352L, v.getId());
            assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", v.getParams().getApiKey());
            assertEquals(1000, v.getParams().getN());
            assertEquals(14, v.getParams().getDecimalPlaces());
        });
    }
}
