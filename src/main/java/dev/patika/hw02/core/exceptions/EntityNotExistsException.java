package dev.patika.hw02.core.exceptions;

import dev.patika.hw02.core.utilities.helpers.ApiErrors;
import org.springframework.data.util.Pair;

public class EntityNotExistsException extends RuntimeException {

    private final String name;
    private final Pair<String, Object>[] parameters;

    @SafeVarargs
    public EntityNotExistsException(String name, Pair<String, Object>... parameters) {
        super(ApiErrors.entityNotFound(name, parameters));
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public Pair<String, Object>[] getParameters() {
        return parameters;
    }
}
