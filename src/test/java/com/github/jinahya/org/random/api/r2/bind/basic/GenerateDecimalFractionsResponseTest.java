package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@Slf4j
class GenerateDecimalFractionsResponseTest extends RandomOrgResponseTest<GenerateDecimalFractionsResponse> {

    GenerateDecimalFractionsResponseTest() {
        super(GenerateDecimalFractionsResponse.class);
    }

    @Test
    void generateDecimalFractions_01_response() throws IOException {
        acceptValueFromResource("/example/basic/generateDecimalFractions_01_response.json", v -> {
            assertEquals(10, v.getResult().getRandom().getData().size());
            assertIterableEquals(asList(0.0753205, 0.59823072, 0.46109946, 0.28453638, 0.92390558, 0.53087566,
                                        0.48139983, 0.06829921, 0.1878, 0.10107864),
                                 v.getResult().getRandom().getData());
            assertEquals("2013-01-25 19:16:42Z", v.getResult().getRandom().getCompletionTime());
            assertEquals(266, v.getResult().getBitsUsed());
            assertEquals(199734, v.getResult().getBitsLeft());
            assertEquals(8463, v.getResult().getRequestsLeft());
            assertEquals(0, v.getResult().getAdvisoryDelay());
            assertEquals(42L, v.getId());
        });
    }

    @Test
    void generateDecimalFractions_02_response() throws IOException {
        acceptValueFromResource("/example/basic/generateDecimalFractions_02_response.json", v -> {
            assertEquals(4, v.getResult().getRandom().getData().size());
            assertIterableEquals(asList(0.8, 0.94, 0.72, 0.2), v.getResult().getRandom().getData());
            assertEquals("2013-01-25 19:21:15Z", v.getResult().getRandom().getCompletionTime());
            assertEquals(27, v.getResult().getBitsUsed());
            assertEquals(199973, v.getResult().getBitsLeft());
            assertEquals(9999, v.getResult().getRequestsLeft());
            assertEquals(2000, v.getResult().getAdvisoryDelay());
            assertEquals(3076L, v.getId());
        });
    }

    @Test
    void generateDecimalFractions_03_response() throws IOException {
        acceptValueFromResource("/example/basic/generateDecimalFractions_03_response.json", v -> {
            assertEquals("2013-01-25 19:24:33Z", v.getResult().getRandom().getCompletionTime());
            assertEquals(66439, v.getResult().getBitsUsed());
            assertEquals(133561, v.getResult().getBitsLeft());
            assertEquals(4782, v.getResult().getRequestsLeft());
            assertEquals(0, v.getResult().getAdvisoryDelay());
            assertEquals(4352L, v.getId());
        });
    }
}
