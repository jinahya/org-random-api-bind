package com.github.jinahya.org.random.api.r2.bind.basic;

import com.github.jinahya.org.random.api.r2.bind.Random;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponse;
import com.github.jinahya.org.random.api.r2.bind.RandomOrgResponseResult;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GenerateDecimalFractionsResponse extends RandomOrgResponse<GenerateDecimalFractionsResponse.Result> {

    public static class Result extends RandomOrgResponseResult {

    }

    @Valid
    @NotNull
    private Random random;

    private int bitsUsed;

    private int bitsLeft;

    private int requestsLeft;

    private int advisoryDelay;
}
