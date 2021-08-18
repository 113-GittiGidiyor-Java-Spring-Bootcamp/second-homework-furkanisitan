package dev.patika.hw02.api.helpers;

import dev.patika.hw02.core.utilities.constants.ResponseMessage;
import dev.patika.hw02.core.utilities.helpers.ApiErrors;
import dev.patika.hw02.core.utilities.results.abstracts.DataResult;
import dev.patika.hw02.core.utilities.results.helpers.DataResultHelper;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DataResultResponseHelper {

    @SafeVarargs
    public static <T> ResponseEntity<DataResult<T>> notFound(String name, Pair<String, Object>... parameters) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DataResultHelper.fail(ResponseMessage.NOT_FOUND, ApiErrors.entityNotFound(name, parameters)));
    }
}
