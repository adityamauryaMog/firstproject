package com.moglix.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Component
public class FileUpload {
	File file;
	
	
	public String DESTINATION="";
	public Path path;
	
	public FileUpload() {
		// TODO Auto-generated constructor stub
		this.file=new File("");
		this.DESTINATION=this.file.getAbsolutePath();
		 this.path=Paths.get(this.DESTINATION, "src","main","resources","uploads");
		 this.DESTINATION=this.path.toString();
		  
	}
	
	public void upload(MultipartFile file) throws IOException {
		byte[] fi=file.getBytes();
		System.out.println(this.DESTINATION);
		Path p=Paths.get(this.DESTINATION,file.getOriginalFilename());
		Files.write(p,fi);
	
    }
	
    public List<String> getFile(String filename) throws IOException {
    	Path p=Paths.get(this.DESTINATION,filename);
    	List<String> data=Files.readAllLines(p);
		return data;
	}	
}
	
