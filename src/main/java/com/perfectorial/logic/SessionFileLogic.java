package com.perfectorial.logic;

import com.perfectorial.dto.DownloadRequest;
import com.perfectorial.entity.SessionFile;
import com.perfectorial.util.DownloadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/24/2015
 */
@Service
public class SessionFileLogic extends AbstractGenericLogic<SessionFile> {
    @Autowired
    private DownloadFile downloadFile;

    public byte[] download(DownloadRequest downloadRequest) {
        return downloadFile.download(downloadRequest.getFileId(), downloadRequest.getSize(), downloadRequest.getSize());
    }
}
