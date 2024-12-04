package org.example.backend;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/api")
public class DataController {

    @PostMapping("/data")
    public String saveData(@RequestBody String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
            writer.write(data);
            writer.newLine();
            return "Data saved successfully";
        } catch (IOException e) {
            e.printStackTrace(); // Выводим стек ошибок в консоль
            return "Error saving data: " + e.getMessage();
        }
    }

    @GetMapping("/read")
    public String readData() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных: " + e.getMessage();
        }
        return content.toString(); // Возвращаем содержимое файла
    }
}