package com.perfecturial.logic;

import com.perfecturial.dto.DownloadRequest;
import com.perfecturial.util.DownloadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/24/2015
 */
@Service
public class FileLogic {
    @Autowired
    DownloadFile downloadFile;

    public byte[] download(DownloadRequest downloadRequest) {

        try {
            return downloadFile.download(downloadRequest.getFileId(), downloadRequest.getSize(), downloadRequest.getSize());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
