package practice.basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class InputAndOutput {

	public static void main(String[] args) {
		try (
//				FileOutputStream fo = new FileOutputStream("a.txt");
				FileInputStream fi = new FileInputStream("a.txt");

				
				
				FileReader fr = new FileReader("a.txt");
				BufferedReader br = new BufferedReader(fr);
				
				BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
				ByteArrayOutputStream out = new ByteArrayOutputStream()
						
				
				
				) {
			
			byte[] buf = new byte[1024];
			int len =0;
			while((len=in.read(buf))!=-1) {
				out.write(buf, 0, len);
			}
			
			byte[] arr = out.toByteArray();
			String s = new String(arr);
			System.out.println(s);
			
			// < system in and out>
//			InputStream keyboard = System.in;
//			PrintStream console = System.out;
//			int c = 0;
//			while ((c = keyboard.read()) != -1) {
//				console.write(c);
//			}
			System.out.println("=========================");
			String line = null;
			int c =0;
			while((line = br.readLine())!= null) {
				System.out.println(line);
				System.out.println(++c);
			}
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
