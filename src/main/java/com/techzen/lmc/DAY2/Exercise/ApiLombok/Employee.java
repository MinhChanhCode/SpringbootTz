package com.techzen.lmc.DAY2.Exercise.ApiLombok;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Employee {
    UUID id;
    String name;
    LocalDate dob;
    String gender;
    Double salary;
    String phone;

}
