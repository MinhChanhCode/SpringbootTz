package com.techzen.lmc.DAY1.Exercise.CalculateAPI;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Calculate {
     String firstNumber;
     String secondNumber;
     String operator;
}
