package com.example.FileDownloader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileDownloadController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        try {
            // Path to the file
            Path filePath = Paths.get("D:\\temp\\hyper-v.txt");
            Resource resource = new UrlResource(filePath.toUri());
            System.out.println("Sending file...");
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
