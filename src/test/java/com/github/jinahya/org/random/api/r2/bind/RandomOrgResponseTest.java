package com.github.jinahya.org.random.api.r2.bind;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.github.jinahya.org.random.api.r2.bind.BeanValidationUtils.requireValid;
import static java.util.Objects.requireNonNull;

public abstract class RandomOrgResponseTest<
        ResponseType extends RandomOrgResponse<ResultType>, ResultType extends RandomOrgResponseResult> {

    public RandomOrgResponseTest(final Class<? extends ResponseType> responseClass,
                                 final Class<? extends ResultType> resultClass) {
        super();
        this.responseClass = requireNonNull(responseClass, "responseClass is null");
        this.resultClass = requireNonNull(resultClass, "resultClass is null");
    }

    protected void acceptValueFromResource(final String name, final Consumer<? super ResponseType> consumer)
            throws IOException {
        consumer.accept(requireValid(JsonbUtils.value(name, responseClass)));
        consumer.accept(requireValid(JacksonUtils.value(name, responseClass)));
    }

    protected <U> void acceptValueFromResource(final String name, final Supplier<? extends U> supplier,
                                               final BiConsumer<? super ResponseType, ? super U> consumer)
            throws IOException {
        acceptValueFromResource(name, v -> consumer.accept(v, supplier.get()));
    }

    protected final Class<? extends ResponseType> responseClass;

    protected final Class<? extends ResultType> resultClass;
}
