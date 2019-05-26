package com.github.jinahya.org.random.api.release2.bind;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.function.Consumer;

import static java.util.Optional.ofNullable;

@Slf4j
public final class JsonTests {

    // -----------------------------------------------------------------------------------------------------------------
    public static <T> void doWithResource(final String resourceName, final Class<? extends T> valueType,
                                          final Consumer<? super T> valueConsumer,
                                          final Consumer<? super String> jsonConsumer)
            throws IOException {
        {
            final T value = JsonbUtils.fromResource(resourceName, valueType);
            ofNullable(valueConsumer).ifPresent(v -> v.accept(value));
            final String json = JsonbUtils.JSONB.toJson(value);
            ofNullable(jsonConsumer).ifPresent(v -> v.accept(json));
        }
        {
            final T value = JacksonUtils.readResource(resourceName, valueType);
            ofNullable(valueConsumer).ifPresent(v -> v.accept(value));
            final String json = JacksonUtils.OBJECT_MAPPER.writeValueAsString(value);
            ofNullable(jsonConsumer).ifPresent(v -> v.accept(json));
        }
    }

    public static <T> void doWithResource(final String resourceName, final Class<? extends T> valueType)
            throws IOException {
        doWithResource(
                resourceName,
                valueType,
                value -> {
                    log.debug("value: {}", value);
                },
                json -> {
                    log.debug("value: {}", json);
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    private JsonTests() {
        super();
    }
}
