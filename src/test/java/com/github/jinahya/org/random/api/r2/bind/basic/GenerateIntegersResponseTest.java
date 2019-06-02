package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class GenerateIntegersResponseTest extends RandomOrgResponseTest<GenerateIntegersResponse> {

    static final ThreadLocal<Base> BASE = new ThreadLocal<>();

    GenerateIntegersResponseTest() {
        super(GenerateIntegersResponse.class);
    }

    @Override
    protected void acceptValueFromResource(final String name, final Consumer<? super GenerateIntegersResponse> consumer)
            throws IOException {
        super.acceptValueFromResource(name, v -> {
            consumer.accept(v);
            final GenerateIntegersResponse.Result result = v.getResult();
            assertNotNull(result);
            final GenerateIntegersResponse.Result.Random random = result.getRandom();
            assertNotNull(random);
        });
    }

    @Test
    void generateIntegers_01_response(final TestInfo testInfo) throws IOException {
        acceptValueFromResource("/example/basic/generateIntegers_01_response.json", v -> {
        });
    }

    @Test
    void generateIntegers_02_response() throws IOException {
        acceptValueFromResource("/example/basic/generateIntegers_02_response.json", v -> {
        });
    }

    @Test
    void generateIntegers_03_response() throws IOException {
        BASE.set(Base.B0x10);
        acceptValueFromResource("/example/basic/generateIntegers_03_response.json", v -> {
        });
        BASE.remove();
    }
}
