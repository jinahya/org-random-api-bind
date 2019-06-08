package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.RandomOrgIT;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequest;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgRequestParams;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;

abstract class RandomOrgBasicIT<
        T extends RandomOrgRequest<U>, U extends RandomOrgRequestParams, V extends RandomOrgResponse<W>,
        W extends RandomOrgResponseResult>
        extends RandomOrgIT<T, U, V, W> {

    public static final String URL = "https://api.random.org/json-rpc/2/invoke";

    RandomOrgBasicIT(final Class<? extends T> requestClass, final Class<? extends U> paramsClass,
                     final Class<? extends V> responseClass, final Class<? extends W> resultClass) {
        super(requestClass, paramsClass, responseClass, resultClass);
    }

    protected V call(final T requestInstance) {
        return super.call(URL, requestInstance);
    }
}
