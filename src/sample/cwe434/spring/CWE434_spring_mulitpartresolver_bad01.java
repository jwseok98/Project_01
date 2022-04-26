/*
 * 위험한 형식 파일 업로드
 * 참조: 없음. 스프링 MVC 기반 파일업로드 샘플
 */
package sample.cwe434.spring;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CWE434_spring_mulitpartresolver_bad01 {
	
	@RequestMapping("/upload")
	public String upload(Model model, MultipartFile file) {
		// MultipartFile.getOriginalFilename() 메서드의 반환값을 조건식에 의한 체크없이
		// MultipartFile.getInputStream() 메서드가 호출되면 탐지 해야함.
		
		String savePath = "/upload/" + file.getOriginalFilename();
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		byte[] buff = new byte[1024 * 2];
		int len = -1;
		
		try {
			// POTENTIAL FLAW
			bis = new BufferedInputStream(file.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(savePath));
			
			while ((len = bis.read(buff)) != 0) {
				bos.write(buff, 0, len);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return "failed";
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (Exception e) {}
			}
		}
		return "success";
	}
	
	@RequestMapping("/upload2")
	public String upload2(Model model, MultipartFile file) {
		// MultipartFile.getOriginalFilename() 메서드의 반환값을 조건식에 의한 체크없이
		// MultipartFile.getBytes() 메서드가 호출되면 탐지 해야함.
		
		String savePath = "/upload/" + file.getOriginalFilename();
		
		BufferedOutputStream bos = null;
		
		try {
			// POTENTIAL FLAW
			byte[] data = file.getBytes();
			
			bos = new BufferedOutputStream(new FileOutputStream(savePath));
			bos.write(data);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return "failed";
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {}
			}
		}
		return "success";
	}
}
