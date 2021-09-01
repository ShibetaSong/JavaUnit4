package day03_Demo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLDemo1 {
	//https://qd.myapp.com/myapp/qqteam/pcqq/PCQQ2020.exe
	public static void main(String[] args) throws Exception{
		System.out.println("欢迎使用 新职课 文件下载器");
		System.out.println("请输入要下载的文件地址：");
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		//1.	创建一个URL变量
		URL url = new URL(text);
		//2.	获取文件名称
		String name = url.getFile();///myapp/qqteam/pcqq/PCQQ2020.exe
		name = name.substring(name.lastIndexOf("/")+1);
		//3.	通过url ， 打开连接
		URLConnection conn = url.openConnection();
		//4.	通过连接对象， 获取文件总长度  字节数
		long length = conn.getContentLengthLong();
		//5.	通过连接对象， 获取资源的输入流
		InputStream is = conn.getInputStream();
		//6.	创建一个文件输出流 ， 用于保存下载的内容
		File file = new File("C:\\Users\\cdd\\Desktop\\"+name);
		FileOutputStream fos = new FileOutputStream(file);
		
		int len = -1;
		byte[] bytes = new byte[1024*1024];
		int sum = 0;
		while(true) {
			len = is.read(bytes);
			if(len == -1) {
				break;
			}
			fos.write(bytes, 0, len);
			sum+=len;
			System.out.println("正在下载："+sum/(length/100)+"%");
		}
		is.close();
		fos.close();
		
		/*
		while(true) {
			int b = is.read();
			if(b==-1) {
				break;
			}
			fos.write(b);
			System.out.println("下载了一个字节");
		}
		*/
		System.out.println("下载完毕");
		
		
	}

}
