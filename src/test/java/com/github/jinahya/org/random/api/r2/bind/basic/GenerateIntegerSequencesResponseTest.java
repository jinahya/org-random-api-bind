package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;
import java.util.function.Consumer;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@Slf4j
class GenerateIntegerSequencesResponseTest
        extends RandomOrgResponseTest<GenerateIntegerSequencesResponse, GenerateIntegerSequencesResponse.Result> {

    static final ThreadLocal<Base> BASE = new ThreadLocal<>();

    GenerateIntegerSequencesResponseTest() {
        super(GenerateIntegerSequencesResponse.class, GenerateIntegerSequencesResponse.Result.class);
    }

    @Override
    protected void acceptValueFromResource(final String name,
                                           final Consumer<? super GenerateIntegerSequencesResponse> consumer)
            throws IOException {
        super.acceptValueFromResource(name, v -> {
            consumer.accept(v);
        });
    }

    @Test
    void generateIntegerSequences_01_response(final TestInfo testInfo) throws IOException {
        acceptValueFromResource("/example/basic/generateIntegerSequences_01_response.json", v -> {
            assertEquals(2, v.getResult().getRandom().getData().size());
            assertIterableEquals(asList(28, 31, 41, 65, 42), v.getResult().getRandom().getData().get(0));
            assertIterableEquals(singletonList(14), v.getResult().getRandom().getData().get(1));
            assertEquals("2018-01-29 17:34:46Z", v.getResult().getRandom().getCompletionTime());
            assertEquals(36, v.getResult().getBitsUsed());
            assertEquals(833949, v.getResult().getBitsLeft());
            assertEquals(199598, v.getResult().getRequestsLeft());
            assertEquals(200, v.getResult().getAdvisoryDelay());
        });
    }

    @Test
    void generateIntegerSequences_02_response(final TestInfo testInfo) throws IOException {
        acceptValueFromResource("/example/basic/generateIntegerSequences_02_response.json", v -> {
        });
    }

    @Test
    void generateIntegerSequences_03_response(final TestInfo testInfo) throws IOException {
        acceptValueFromResource("/example/basic/generateIntegerSequences_03_response.json", v -> {
        });
    }
}
