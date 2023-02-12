package com.example.warehouse.controller;

import com.example.warehouse.entity.Attachment;
import com.example.warehouse.entity.AttachmentContent;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.AttachmentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;
    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){
        return attachmentService.uploadFile(request);
    }


    @GetMapping("/download/{id}")
    public void getFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attachmentService.getFile(id, response);
    }
}
