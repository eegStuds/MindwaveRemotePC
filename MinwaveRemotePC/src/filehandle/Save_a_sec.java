package filehandle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Calendar;

public class Save_a_sec {

	public static void main(String[] args) throws IOException {
        
		String s = "                   ";
		String str = "#TIME"+s+"A"+s+"B"+s+"C"+s+"D"+s+"E"+s+"F"+s+"G"+s+"H"+s+"I"+s+"J"+s+"K ";
		SaveDelete mSaveDelete = new SaveDelete();
		
		String pFilename = "D://Save_a_sec/sec.text";
		mSaveDelete.createfile(pFilename );
		
		BufferedWriter wr = null;
		wr= mSaveDelete.getBufferedWriter();
		wr.write(str);
		long now = Calendar.getInstance().getTimeInMillis();
		int a = 1;      int e = 1;      int I = 1;
		int b = 1;      int f = 1;      int j = 1;
		int c = 1;      int g = 1;      int k = 1;
		int d = 1;      int h = 1;
		wr.newLine();
		for(int i=0; i<512; i++){
			wr.write(now + s + String.valueOf(a) + s + String.valueOf(b) + s + String.valueOf(c) + s +
				String.valueOf(d) + s + String.valueOf(e) + s + String.valueOf(f) + s +
				String.valueOf(g) + s + String.valueOf(h) + s + String.valueOf(I) + s +
				String.valueOf(j) + s + String.valueOf(k));
				wr.newLine();
				
			    a = a+1;     e = e+5;        I = I+9;
			    b = b+2;     f = f+6;        j = j+10;
			    c = c+3;     g = g+7;        k = k+11;
			    d = d+4;     h = h+8;  
		}
		wr.close();
			
		mSaveDelete.readOpenfile(pFilename);
			
		BufferedReader br=mSaveDelete.getBufferedReader();
		for(int m=0; m<512; m++){
		   	String line = br.readLine();
		    String[] columns = line.split(s);
		   
			System.out.println(columns[2]);
		    }
		    br.close();
				
	}
}
