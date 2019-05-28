package com.github.jinahya.org.random.api.release2.bind.basic;

import javax.json.bind.adapter.JsonbAdapter;

import static java.util.Optional.ofNullable;

public class BaseTypeAdapter implements JsonbAdapter<Base, Integer> {

    @Override
    public Integer adaptToJson(final Base base) throws Exception {
        return ofNullable(base).map(Base::getBase).orElse(null);
    }

    @Override
    public Base adaptFromJson(final Integer base) throws Exception {
        if (base == null) {
            return null;
        }
        return Base.valueOf(base);
    }
}
