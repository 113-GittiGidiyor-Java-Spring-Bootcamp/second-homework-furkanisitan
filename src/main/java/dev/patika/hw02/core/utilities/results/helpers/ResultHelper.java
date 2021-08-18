package dev.patika.hw02.core.utilities.results.helpers;

import dev.patika.hw02.core.utilities.results.abstracts.Result;
import dev.patika.hw02.core.utilities.results.concretes.ErrorResult;
import dev.patika.hw02.core.utilities.results.concretes.SuccessResult;

import java.util.Arrays;

public class ResultHelper {

    public static Result ok() {
        return new SuccessResult();
    }

    public static Result ok(String message) {
        return new SuccessResult(message);
    }

    public static Result fail(String message) {
        return new ErrorResult(message);
    }

    public static Result fail(String message, String... errors) {
        return new ErrorResult(message, Arrays.asList(errors));
    }
}
