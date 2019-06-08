package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.ApiKeyParameterResolver;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params.MAX_MAX;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params.MAX_MIN;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params.MAX_N;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params.MIN_MIN;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersRequest.Params.MIN_N;
import static com.github.jinahya.org.random.api.r2.bind.basic.GenerateIntegersResponse.Result;
import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateIntegersIT extends RandomOrgBasicIT<GenerateIntegersRequest, Params, GenerateIntegersResponse, Result> {

    GenerateIntegersIT() {
        super(GenerateIntegersRequest.class, Params.class, GenerateIntegersResponse.class, Result.class);
    }

    @EnabledIfSystemProperty(named = RandomOrgIT.SYSTEM_PROPERTY_API_KEY, matches = ".+")
    @Test
    void call(@ApiKeyParameterResolver.ApiKey final String apiKey) {
        final GenerateIntegersRequest request = new GenerateIntegersRequest();
        request.setParams(new GenerateIntegersRequest.Params());
        final int n = current().nextInt(MIN_N, MAX_N + 1);
        final int min = current().nextInt(MIN_MIN, MAX_MIN + 1);
        final int max = current().nextInt(min, MAX_MAX + 1);
        final Boolean replacement = current().nextBoolean() ? null : current().nextBoolean();
        final Base base = current().nextBoolean() ? null : Base.values()[current().nextInt(Base.values().length)];
        request.getParams().setApiKey(apiKey);
        request.getParams().setN(n);
        request.getParams().setMin(min);
        request.getParams().setMax(max);
        request.getParams().setReplacement(replacement);
        request.getParams().setBase(base);
        request.setId(System.nanoTime());
        log.debug("request: {}", request);
        final GenerateIntegersResponse response = call(request);
        log.debug("response: {}", response);
        assertEquals(request.getId(), response.getId());
    }
}
