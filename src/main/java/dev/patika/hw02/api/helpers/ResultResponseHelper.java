package dev.patika.hw02.api.helpers;

import dev.patika.hw02.core.utilities.constants.ResponseMessage;
import dev.patika.hw02.core.utilities.helpers.ApiErrors;
import dev.patika.hw02.core.utilities.results.abstracts.Result;
import dev.patika.hw02.core.utilities.results.helpers.ResultHelper;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResultResponseHelper {

    @SafeVarargs
    public static ResponseEntity<Result> notFound(String name, Pair<String, Object>... parameters) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResultHelper.fail(ResponseMessage.NOT_FOUND, ApiErrors.entityNotFound(name, parameters)));
    }
}
