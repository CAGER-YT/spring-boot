package com.example.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file) {
        // Check if file is empty
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }

        try {
            // Get the file's original name
            String fileName = file.getOriginalFilename();

            // Process the file (you can save it or perform any operation)
            byte[] bytes = file.getBytes();

            // Here, you would save the file to your storage (e.g., file system or database)
            // For demonstration, we're just returning the file name.
            return "File uploaded successfully: " + fileName;

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        }
    }
}
