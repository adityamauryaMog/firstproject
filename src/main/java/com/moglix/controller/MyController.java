package com.moglix.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.moglix.dto.Account;
import com.moglix.dto.User;
import com.moglix.service.AccountService;
import com.moglix.utils.FileUpload;
import com.moglix.utils.FileUtils;


@RestController
public class MyController {
	
	@Autowired
	FileUtils f;
	
	@Autowired
	AccountService service;
	
	@Autowired
	FileUpload fileUpload;
	
	File file=new File("");	
//upload file
	
@PostMapping(value="upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
public String uploadFile(@RequestParam("file") MultipartFile file) {
	
	String filename=file.getOriginalFilename();
	String fileType=filename.substring(filename.lastIndexOf('.')+1);
	System.out.println(this.file.getAbsolutePath()+File.separator+"add");
	
	if(fileType.equals("csv")) {
		System.out.println("this is csv");
		try {
			fileUpload.upload(file);
			return "Uploaded Successfully";
		} catch (IOException e) {
			
			e.printStackTrace();
			return "Uploading failed";
		}
		
	}
	
	return "Invalid File Format";
	
	
}	
@GetMapping(value="data/{filename}")
public List<String> get(@PathVariable("filename") String filename) throws IOException{
	return fileUpload.getFile(filename);
}
	

// getting all data	
@GetMapping("get")	
 public List<Account>  getDatas() {
    return service.getDatas();	
}	


//getting by id
@GetMapping("get/{id}")	
public ResponseEntity<?>  getData(@PathVariable("id") int id) {
   Account res=service.getData(id);	
   if(res!=null) {
	   return ResponseEntity.ok(res);
   }
   
   
   return new ResponseEntity<String>("THIS ID NOT EXISTS",HttpStatus.NO_CONTENT);
}




	
	

	//adding into database
 @GetMapping("add")
  public void addAccount() throws IOException, InterruptedException {
		List<Account> accounts=this.hello();
		
		for(int i=0;i<accounts.size();i++) {
			service.addAccount(accounts.get(i));
		}
		
		
		
	}
	
	
	
	
	

	@GetMapping
	public List<Account> hello() throws IOException, InterruptedException {
		 
		
		
		 ArrayList<String[]> data=f.getData();
		 ArrayList<Account> arr=new ArrayList<Account>();
		 
		 for(int i=1;i<data.size();i++) {
			 String a[]=data.get(i);
			 for(int k=0;k<a.length;k++) {
				 System.out.print(a[k]+ ",");
			 }
			 System.out.println();
			 System.out.println(Arrays.toString(a));
			 Account account=new Account();
			 
			 account.setMsn(a[0]);
			 account.setGtin(a[1]);
			 account.setIdentifierExists(a[2]);
			 account.setCustomLabel2(a[3]);
			 account.setCustomLabel3(a[4]);
			 account.setCustomLabel4(a[5]);
			 
			 account.setPromotionId(a[6]);
			 account.setIsGoogleActive(a[7]);
			 account.setIsFacebookActive(a[8]);
			 
			 account.setIsCriteoActive(a[9]);
			 account.setAvailability(a[10]);
			 
			 
			 arr.add(account); 
			 
			 
		 }
		 
		 
		 
		 return arr;
		
	}
	
	
  @GetMapping("getdata")	
  public List<String[]> getData() throws IOException {
	  
	  return f.getData();
	
}
	



}
