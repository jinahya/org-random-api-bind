package com.github.jinahya.org.random.api.r2.bind;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.github.jinahya.org.random.api.r2.bind.BeanValidationUtils.requireValid;
import static java.util.Objects.requireNonNull;

public abstract class RandomOrgResponseTest<T extends RandomOrgResponse<?>> {

    public RandomOrgResponseTest(final Class<? extends T> responseClass) {
        super();
        this.responseClass = requireNonNull(responseClass, "responseClass is null");
    }

    protected void acceptValueFromResource(final String name, final Consumer<? super T> consumer)
            throws IOException {
        consumer.accept(requireValid(JsonbUtils.value(name, responseClass)));
        consumer.accept(requireValid(JacksonUtils.value(name, responseClass)));
    }

    protected <U> void acceptValueFromResource(final String name, final Supplier<? extends U> supplier,
                                               final BiConsumer<? super T, ? super U> consumer)
            throws IOException {
        acceptValueFromResource(name, v -> consumer.accept(v, supplier.get()));
    }

    protected final Class<? extends T> responseClass;
}
