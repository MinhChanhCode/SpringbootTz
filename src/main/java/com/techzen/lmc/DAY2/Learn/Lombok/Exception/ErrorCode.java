package com.techzen.lmc.DAY2.Learn.Lombok.Exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)


public enum ErrorCode {
    STUDENT_NOT_EXITS(4041, "Student is not exits!", HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXITS(4042, "Teacher is not exits!", HttpStatus.NOT_FOUND);

    int code;
    String message;
    HttpStatusCode statusCode;


}
