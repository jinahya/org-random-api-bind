package com.github.jinahya.org.random.api.release2.bind;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public final class JsonTests {

    // -----------------------------------------------------------------------------------------------------------------
    public static <T> void doWithResource(final String resourceName, final Class<? extends T> valueType)
            throws IOException {
        {
            final T value = JsonbUtils.fromResource(resourceName, valueType);
            log.debug("value: {}", value);
            final String json = JsonbUtils.JSONB.toJson(value);
            log.debug("json: {}", json);
        }
        {
            final T value = JacksonUtils.readResource(resourceName, valueType);
            log.debug("value: {}", value);
            final String json = JacksonUtils.OBJECT_MAPPER.writeValueAsString(value);
            log.debug("json: {}", json);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private JsonTests() {
        super();
    }
}
