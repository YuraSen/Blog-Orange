package com.example.orange.service;

import com.example.orange.domain.User;
import com.example.orange.util.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    private static final String FILE_PATH = "C:\\Users\\senin\\IdeaProjects\\Blog-Orange\\src\\main\\resources\\PASS-CARD\\pass-card.txt";

    @Override
    public Integer getActive(User user) {
        try {
            File file = new File(FILE_PATH);
            return Integer.valueOf(new String(Files.readAllBytes(file.toPath())));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    @Override
    public File openFile() {
        try {
            return new File(FILE_PATH);
        } catch (Exception e) {
            log.warn("Could not to open the file: " + FILE_PATH, e);
        }
        return null;
    }

    @PostConstruct
    @Override
    public void defaultInitialize() {
        try {
            File file = openFile();
            Files.write(file.toPath(), "1".getBytes());
        } catch (Exception e) {
            log.warn("Could not to write into the file: " + FILE_PATH, e);
        }
    }

    @Override
    public void passCardWriteToFile(Integer activation) {
        try {
            File file = openFile();
            Files.write(file.toPath(), "1".getBytes());
        } catch (Exception e) {
            log.warn("Could not to write into the file: " + FILE_PATH, e);
        }
    }

    @PreDestroy
    @Override
    public void dropFile() {
        try {
            File file = openFile();
            BufferedWriter writer = Files.newBufferedWriter(file.toPath());
            writer.write("");
            writer.flush();
        } catch (Exception e) {
            log.warn("Could not drop the data of file" + FILE_PATH, e);
        }
    }
}

