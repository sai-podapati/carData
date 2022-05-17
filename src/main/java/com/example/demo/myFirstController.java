package com.example.demo;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.internal.Path;

@RestController
public class myFirstController {
	
	@Autowired
	namesUtils utils;

	@RequestMapping("/hello")
	public String sayHello(){
		String msg="Hello Mr. Satya";
		return msg;
	}
	
	@RequestMapping("/wishes")
	public String sayWishes(){
		System.out.println(utils.getNames().toString());
		return "Good luck for your career";
	}
	
	@RequestMapping("/download1")
	public ResponseEntity<InputStreamResource> downloadTextFileExample1() throws FileNotFoundException {
		File fileName;
		fileName = new File("names.txt");
//		fileName.setWritable(true);
		
		FileWriter file;
		try {
			file = new FileWriter(fileName, true);
			for(String name: utils.getNames()){
				file.write(name);
				file.write(System.getProperty("line.separator"));
			}
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStreamResource resource = new InputStreamResource(new FileInputStream(fileName));
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
				.contentLength(fileName.length())
				.body(resource);
	}
	
	
}
