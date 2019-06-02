package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateIntegersRequestTest extends RandomOrgRequestTest<GenerateIntegersRequest> {

    GenerateIntegersRequestTest() {
        super(GenerateIntegersRequest.class);
    }

    @Override
    protected void acceptValueFromResource(final String name, final Consumer<? super GenerateIntegersRequest> consumer)
            throws IOException {
        super.acceptValueFromResource(name, v -> {
            assertEquals("generateIntegers", v.getMethod());
            consumer.accept(v);
        });
    }

    @Test
    void generateIntegers_01_request() throws IOException {
        acceptValueFromResource("/example/basic/generateIntegers_01_request.json", v -> {
        });
    }

    @Test
    void generateIntegers_02_request() throws IOException {
        acceptValueFromResource("/example/basic/generateIntegers_02_request.json", v -> {
        });
    }

    @Test
    void generateIntegers_03_request() throws IOException {
        acceptValueFromResource("/example/basic/generateIntegers_03_request.json", v -> {
        });
    }
}
