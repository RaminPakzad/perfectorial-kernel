package com.perfecturial.util;

import com.perfecturial.dao.FileDao;
import com.perfecturial.entity.SessionFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/16/2015
 */
@Service
public class DownloadFile {
    @Autowired
    private FileDao fileDao;
    private Map<String, File> fileMap = new HashMap<String, File>();

    public byte[] download(String fileId, int size, long from) throws IOException {
        File file = null;
        if (fileMap.containsKey(fileId))
            file = fileMap.get(fileId);
        else {
            SessionFile sessionFile = fileDao.getByFileId(fileId);
            if (sessionFile == null)
                throw new RuntimeException();
            String fileLocation = sessionFile.getFileLocation();
            file = new File(fileLocation);
            if (!file.exists())
                throw new RuntimeException();
            fileMap.put(fileId, file);
        }
        return getFileBytes(file, size, from);
    }

    private byte[] getFileBytes(File file, int length, long from) throws IOException {
        if ((from + length) > file.length())
            length = new Long(file.length() - from).intValue();
        byte[] b = new byte[length];
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.seek(from);
        randomAccessFile.read(b);
        randomAccessFile.close();
        return b;
    }
}
