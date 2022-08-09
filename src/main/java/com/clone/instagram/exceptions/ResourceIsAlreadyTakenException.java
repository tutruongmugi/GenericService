package com.clone.instagram.exceptions;

import com.clone.instagram.payloads.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Resource already exists")
@Getter
public class ResourceIsAlreadyTakenException extends RuntimeException {
    private ApiResponse apiResponse;

    public ResourceIsAlreadyTakenException(String resourceName, String fieldName, Object fieldValue) {
        super();
        String message = String.format("%s  with %s: '%s' is already taken", resourceName, fieldName, fieldValue);

        this.apiResponse = new ApiResponse(Boolean.FALSE, message);
    }
}
