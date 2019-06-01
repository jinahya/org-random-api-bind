package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Slf4j
class GenerateIntegersRequestTest
        extends RandomOrgRequestTest<GenerateIntegersRequest, GenerateIntegersRequest.Params> {

    GenerateIntegersRequestTest() {
        super(GenerateIntegersRequest.class, GenerateIntegersRequest.Params.class);
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
