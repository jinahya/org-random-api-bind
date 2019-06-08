package com.github.jinahya.org.random.api.r2.bind;

import org.glassfish.jersey.logging.LoggingFeature;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

@ExtendWith({ApiKeyParameterResolver.class})
public abstract class RandomOrgIT<
        T extends RandomOrgRequest<U>, U extends RandomOrgRequestParams, V extends RandomOrgResponse<W>,
        W extends RandomOrgResponseResult> {

    public static final String SYSTEM_PROPERTY_API_KEY = "apiKey";

    public RandomOrgIT(final Class<? extends T> requestClass, final Class<? extends U> paramsClass,
                       final Class<? extends V> responseClass, final Class<? extends W> resultClass) {
        super();
        this.requestClass = requireNonNull(requestClass, "requestClass is null");
        this.paramsClass = requireNonNull(paramsClass, "paramsClass is null");
        this.responseClass = requireNonNull(responseClass, "responseClass is null");
        this.resultClass = requireNonNull(resultClass, "resultClass is null");
    }

    protected V call(final String url, final T requestInstance) {
        return ClientBuilder.newBuilder().build()
                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
                .property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "WARNING")
                .target(url)
                .request()
                .post(Entity.entity(requestInstance, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(responseClass);
    }

    protected final Class<? extends T> requestClass;

    protected final Class<? extends U> paramsClass;

    protected final Class<? extends V> responseClass;

    protected final Class<? extends W> resultClass;
}
