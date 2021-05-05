package com.example.orange.util;

import com.example.orange.domain.User;

import java.io.File;

public interface FileService {
    Integer getActive(User user);

    void defaultInitialize();

    File openFile();

    void passCardWriteToFile(Integer activation);

    void dropFile();

}
