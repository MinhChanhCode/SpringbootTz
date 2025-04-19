package com.techzen.lmc.DAY2.Learn.Lombok.Student;

import com.techzen.lmc.DAY2.Learn.Lombok.DTO.APIResponse;
import com.techzen.lmc.DAY2.Learn.Lombok.Exception.AppException;
import com.techzen.lmc.DAY2.Learn.Lombok.Exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
    private final List<Student> students = new ArrayList<>(  //add database
            Arrays.asList(
                    new Student(1, "Mr.Quang", 10.0),
                    new Student(2, "LMC", 10),
                    new Student(3, "Huyen", 10)
            )
    );

    //    @RequestMapping(value = "/students", method = RequestMethod.GET)  //list database
    @GetMapping()
    public ResponseEntity<APIResponse<List<Student>>> getStudents() {
        return ResponseEntity.ok(APIResponse.<List<Student>>builder()
                .data(students)
                .build());
    }

    //    @RequestMapping(value = "/students", method = RequestMethod.POST)       //post database
    @PostMapping()
    public ResponseEntity<Student> save(@RequestBody Student student) {
        student.setId((int) (Math.random() * 10000000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Student>> LMCs(@PathVariable("id") int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(APIResponse.<Student>builder()
                        .data(student)
                        .build()
                );
            }
        }

        throw new AppException(ErrorCode.STUDENT_NOT_EXITS);
    }
}




