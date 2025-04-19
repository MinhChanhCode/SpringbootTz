package com.techzen.lmc.DAY2.Exercise.ApiLombok.Exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public enum ErrorCode {
    EMPLOYEE_NOT_EXISTED(40401, "Employee is not exits!", HttpStatus.NOT_FOUND);

    int code;
    String message;
    HttpStatusCode statusCode;

}
