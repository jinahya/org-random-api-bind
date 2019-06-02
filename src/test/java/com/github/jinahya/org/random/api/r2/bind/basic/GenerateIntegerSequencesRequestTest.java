package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Consumer;

@Slf4j
class GenerateIntegerSequencesRequestTest extends RandomOrgRequestTest<GenerateIntegerSequencesRequest> {

    GenerateIntegerSequencesRequestTest() {
        super(GenerateIntegerSequencesRequest.class);
    }

    @Override
    protected void acceptValueFromResource(String name, Consumer<? super GenerateIntegerSequencesRequest> consumer)
            throws IOException {
        super.acceptValueFromResource(name, v -> {
            consumer.accept(v);
        });
    }

    @Test
    void generateIntegerSequences_01_request() throws IOException {
        acceptValueFromResource("/example/basic/generateIntegerSequences_01_request.json", v -> {
        });
    }

    @Test
    void generateIntegerSequences_02_request() throws IOException {
        acceptValueFromResource("/example/basic/generateIntegerSequences_02_request.json", v -> {
        });
    }

    @Test
    void generateIntegerSequences_03_request() throws IOException {
        acceptValueFromResource("/example/basic/generateIntegerSequences_03_request.json", v -> {
        });
    }
}
