package com.khackathon.nest.global.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Schema(description = "성공 Response")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SuccessResponse<T> {

    @Schema(description = "성공 여부, 항상 true", defaultValue = "true")
    private final boolean status = true;
    private T data;

    public static <T> SuccessResponse<T> of(T data) {
        SuccessResponse<T> successResponse = new SuccessResponse<>();
        successResponse.data = data;
        return successResponse;
    }

    public ResponseEntity<SuccessResponse<T>> asHttp(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(this);
    }
}
