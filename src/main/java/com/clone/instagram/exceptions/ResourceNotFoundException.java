package com.clone.instagram.exceptions;

import com.clone.instagram.payloads.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private ApiResponse apiResponse;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super();
        String message = String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue);
        this.apiResponse = new ApiResponse(false, message);
    }
}
