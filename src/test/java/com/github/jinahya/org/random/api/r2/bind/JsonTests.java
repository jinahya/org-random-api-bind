package com.github.jinahya.org.random.api.r2.bind;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public final class JsonTests {

    // -----------------------------------------------------------------------------------------------------------------
    public static <T> void doWithResource(final String resourceName, final Class<? extends T> valueType)
            throws IOException {
        final List<T> values = new ArrayList<>();
        {
            final T value = JsonbUtils.value(resourceName, valueType);
            log.debug("value: {}", value);
            BeanValidationUtils.requireValid(value);
            values.add(value);
            final String json = JsonbUtils.JSONB.toJson(value);
            log.debug("json: {}", json);
        }
        {
            final T value = JacksonUtils.value(resourceName, valueType);
            log.debug("value: {}", value);
            BeanValidationUtils.requireValid(value);
            values.add(value);
            final String json = JacksonUtils.OBJECT_MAPPER.writeValueAsString(value);
            log.debug("json: {}", json);
        }
//        for (final T value1 : values) {
//            for (final T value2 : values) {
//                assertEquals(value1, value2);
//            }
//        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private JsonTests() {
        super();
    }
}
