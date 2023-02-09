package com.example.JPoint.controller;

import com.example.JPoint.model.User;
import com.example.JPoint.repository.UserRepository;
import com.example.JPoint.service.ExcelFileService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/download")
public class DownloadExcelController {
    private final UserRepository userRepository;
    private final ExcelFileService excelFileService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/excel/file/user")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
        List<User> contacts = userRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = excelFileService.export(contacts);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=contacts.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
