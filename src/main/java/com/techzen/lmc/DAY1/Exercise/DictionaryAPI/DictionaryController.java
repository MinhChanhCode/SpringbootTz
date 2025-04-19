package com.techzen.lmc.DAY1.Exercise.DictionaryAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class DictionaryController {
    private final Map<String, String> dictionaryMap = Map.ofEntries(
            Map.entry("Hello", "Xin chào"),
            Map.entry("Apple", "Quả táo"),
            Map.entry("Banana", "Quả chuối"),
            Map.entry("Badminton", "Cầu lông"),
            Map.entry("Program", "Chương trình"),
            Map.entry("Sorry", "Xin lỗi"),
            Map.entry("Please", "Làm ơn"),
            Map.entry("Language", "Ngôn ngữ")
    );


    @GetMapping("/dictionary")
    public ResponseEntity<String> dictionary(@RequestParam(defaultValue = "") String world) {
        String translation = dictionaryMap.get(world.trim());

        if (translation != null) {
            return ResponseEntity.ok(translation);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not find");
    }
}
