package com.moglix.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
@Component
public class FileUtils {
	
	private File file;
	private String DESTINATION;
	private Path path;
	
	
	public FileUtils() {
		this.file=new File("");
		path=Paths.get(this.file.getAbsolutePath(),"src","main","resources","uploads");
		this.DESTINATION=path.toString();
	}
	
	
	
	
	
	public ArrayList<String[]> getData() throws IOException {
		String loc=this.DESTINATION+File.separator+"pla.csv";
	    File file=new File(loc);
	    
	    FileReader read=new FileReader(file);
	    BufferedReader br=new BufferedReader(read);
	    String line="";
	    int n=1;
	    
	    ArrayList<String[]> data=new ArrayList<String[]>();
	     
	    
	    while((line=br.readLine())!=null) {
	    		String arr[]=line.split(",");
	    	     data.add(arr);
	    
	    }	
		return data;
		
	}

}
