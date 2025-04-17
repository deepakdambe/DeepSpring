package com.example.FileDownloader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileDownloadController.class)
public class FileDownloadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDownloadFile_Success() throws Exception {
        // Ensure the file exists in the location expected by the controller
        Path filePath = Paths.get("files/sample.txt");
        Files.createDirectories(filePath.getParent());
        Files.createFile(filePath);

        // Perform the GET request to /download
        mockMvc.perform(MockMvcRequestBuilders.get("/download"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Disposition", "attachment; filename=\"sample.txt\""))
                .andExpect(MockMvcResultMatchers.content().contentType("application/octet-stream"));

        // Clean up the created file after test
        Files.deleteIfExists(filePath);
    }

    @Test
    public void testDownloadFile_FileNotFound() throws Exception {
        // Ensure the file does not exist
        Path filePath = Paths.get("files/sample.txt");
        Files.deleteIfExists(filePath);

        // Perform the GET request to /download
        mockMvc.perform(MockMvcRequestBuilders.get("/download"))
                .andExpect(status().isInternalServerError());
    }
}
