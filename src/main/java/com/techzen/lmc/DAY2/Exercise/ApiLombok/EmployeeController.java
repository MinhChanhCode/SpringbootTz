package com.techzen.lmc.DAY2.Exercise.ApiLombok;

import com.techzen.lmc.DAY2.Exercise.ApiLombok.DTO.JsonResponse;
import com.techzen.lmc.DAY2.Learn.Lombok.Exception.AppException;
import com.techzen.lmc.DAY2.Learn.Lombok.Exception.ErrorCode;
import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController

public class EmployeeController {
    public final List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "LMC", LocalDate.now(), "Nam", 2000000.0, "0375248073"),
                    new Employee(UUID.randomUUID(), "Mr.Quang", LocalDate.now(), "Nam", 30000000.0, "0375248074"),
                    new Employee(UUID.randomUUID(), "Mr.Huyen", LocalDate.now(), "Nữ", 40000000.0, "0375248075")
            )
    );

    @GetMapping
    public ResponseEntity<?> getAll() {
        return JsonResponse.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return JsonResponse.created(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Employee employee) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(e -> {
                    e.setName(employee.getName());
                    e.setDob(employee.getDob());
                    e.setGender(employee.getGender());
                    e.setSalary(employee.getSalary());
                    e.setPhone(employee.getPhone());
                })
                .orElseThrow() ->new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(s -> {
                    employees.remove(s);
                    return JsonResponse.noContent();
                })
                .orElseThrow() ->new AppException(ErrorCode.EMPLOYEE_NOT_EXISTED);

    }


}