package com.kedu.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.FilesDAO;
import com.kedu.dto.FilesDTO;

@Controller
@RequestMapping("/files")
public class FilesController {

	@Autowired
	private FilesDAO dao;

	@RequestMapping("/upload")
	public String upload(String text, MultipartFile[] files) throws Exception {

		String path = "D:/uploads/";

		for(MultipartFile file : files) {
			if(file.isEmpty()) {
				continue;
			}
			String oriName = file.getOriginalFilename();
			String sysName = UUID.randomUUID() + "_" + oriName;

			file.transferTo(new File(path + sysName));
			dao.insert(new FilesDTO(0, oriName, sysName, null, 0));
		}

		return "redirect:/";
	}
	@RequestMapping("/download")
	public void download(String sysname,String oriname,HttpServletResponse resp) throws Exception {
		
		File target = new File("D:/uploads/" + sysname);
		oriname = new String(oriname.getBytes(),"ISO-8859-1"); // 한글 안깨지게 하는 작업
		
		resp.setContentType("application/octet-stream"); // "지금 resp에 태워 보내는 데이터는 HTML이 아니라 파일 스트림이다" 라고 명시
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + oriname  + "\"");
		
		
		FileInputStream fis = new FileInputStream(target);
		FileCopyUtils.copy(fis, resp.getOutputStream());
		
		
	
	}

}
