package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.JsonTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Slf4j
public class GenerateIntegersTest {

    @Test
    void request01() throws IOException {
        JsonTests.doWithResource("/example/basic/generateIntegers_01_request.json", GenerateIntegersRequest.class);
    }

    @Test
    void response01() throws IOException {
        JsonTests.doWithResource("/example/basic/generateIntegers_01_response.json", GenerateIntegersResponse.class);
    }

    @Test
    void request02() throws IOException {
        JsonTests.doWithResource("/example/basic/generateIntegers_02_request.json", GenerateIntegersRequest.class);
    }

    @Test
    void response02() throws IOException {
        JsonTests.doWithResource("/example/basic/generateIntegers_02_response.json", GenerateIntegersResponse.class);
    }

    @Test
    void request03() throws IOException {
        JsonTests.doWithResource("/example/basic/generateIntegers_03_request.json", GenerateIntegersRequest.class);
    }

    @Test
    void response03() throws IOException {
        JsonTests.doWithResource("/example/basic/generateIntegers_03_response.json", GenerateIntegersResponse.class);
    }
}
