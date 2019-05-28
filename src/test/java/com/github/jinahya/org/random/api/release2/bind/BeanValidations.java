package com.github.jinahya.org.random.api.release2.bind;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class BeanValidations {

    public static final ValidatorFactory VALIDATION_FACTORY = Validation.buildDefaultValidatorFactory();

    public static <R> R applyValidator(final Function<? super Validator, ? extends R> function) {
        return function.apply(VALIDATION_FACTORY.getValidator());
    }

    public static <U, R> R applyValidator(final Supplier<? extends U> supplier,
                                          final BiFunction<? super Validator, ? super U, ? extends R> function) {
        return applyValidator(v -> function.apply(v, supplier.get()));
    }

    public static void acceptValidator(final Consumer<? super Validator> consumer) {
        applyValidator(v -> {
            consumer.accept(v);
            return null;
        });
    }

    public static <U> void acceptValidator(final Supplier<? extends U> supplier,
                                           final BiConsumer<? super Validator, ? super U> consumer) {
        acceptValidator(v -> consumer.accept(v, supplier.get()));
    }

    public static <T> Set<ConstraintViolation<T>> validate(final T object) {
        return applyValidator(v -> v.validate(object));
    }

    public static  <T> T requireValid(final T object) {
        final Set<ConstraintViolation<T>> violations = validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return object;
    }

    private BeanValidations() {
        super();
    }
}
