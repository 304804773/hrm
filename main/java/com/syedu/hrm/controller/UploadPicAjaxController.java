package com.syedu.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

@Controller
public class UploadPicAjaxController {

    @RequestMapping("/notice/uploadPic")
    @ResponseBody
    public String getJson(MultipartFile file, HttpServletResponse response, HttpServletRequest request)throws  Exception{
        String realPath=request.getServletContext().getRealPath("/images/notice/");
        String newFileName=UUID.randomUUID().toString()+file.getOriginalFilename();
        file.transferTo(new File(realPath+newFileName));
        return "/images/notice/"+newFileName;
    }
}
