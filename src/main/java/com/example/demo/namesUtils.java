package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class namesUtils {
 
	List<String> names=new ArrayList<String>();
	Scanner sc=null;
	public List<String> getNames(){
	File file;
	try {
		file = ResourceUtils.getFile("classpath:names.txt");
		sc = new Scanner(file);
		while(sc.hasNextLine()){
			names.add(sc.nextLine());
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return names;
	}
	
}
