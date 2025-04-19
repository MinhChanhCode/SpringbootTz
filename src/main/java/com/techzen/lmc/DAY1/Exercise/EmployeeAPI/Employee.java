package com.techzen.lmc.DAY1.Exercise.EmployeeAPI;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
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
    Integer departmentId;

}
