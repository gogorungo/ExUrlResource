package org.comstudy21.ex01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Ex02Url {

	public Ex02Url() throws IOException {
		String imgUrlPath = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTExMjhfMjc5%2FMDAxNjM4MDUwMDI3MDE5.s5vYr1ws-q8Yhus4K_AR4TlNR7al21K_KAKoN7S2u90g.WYo5TEXDsWwYVU506wlabK09yqDCnZqx-tDm8ggV720g.JPEG.joo3203%2FDSC02122.JPG&type=sc960_832";
		URL url = new URL(imgUrlPath);
		
		InputStream is = url.openStream();
		DataInputStream dis = new DataInputStream(is);
		
		File dir = new File("images");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		String saveFilePath = "Photo.jpg";
		File file = new File(dir, saveFilePath);
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		
		int data = 0;
		while((data=dis.read())!=-1) {
			// 파일로 저장 하기
			dos.write(data);
		}
		
		if(dis != null) dis.close();
		if(is != null) is.close();
		if(dos != null) dos.close();
		if(fos != null) fos.close();
	}
	
	public static void main(String[] args) throws IOException {
		new Ex02Url();
	}
}
