package com.perfectorial.controller;

import com.perfectorial.dto.DownloadRequest;
import com.perfectorial.logic.SessionFileLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/24/2015
 */
@Controller
public class FileController {
    @Autowired
    private SessionFileLogic sessionFileLogic;

    @RequestMapping(value = URIConstants.File.DOWNLOAD, method = RequestMethod.GET)
    public @ResponseBody byte[] download(@RequestBody DownloadRequest categoryFilter) {
        return sessionFileLogic.download(categoryFilter);
    }
}
