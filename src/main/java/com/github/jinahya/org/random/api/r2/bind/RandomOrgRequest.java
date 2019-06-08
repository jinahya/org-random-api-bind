package com.github.jinahya.org.random.api.r2.bind;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.jinahya.jsonrpc.bind.v2.RequestObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class RandomOrgRequest<T extends RandomOrgRequestParams> extends RequestObject<T> {

    public RandomOrgRequest(final String method) {
        super();
        setMethod(method);
    }
}
