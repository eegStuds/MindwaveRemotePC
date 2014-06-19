package remoteapps.appkeydatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import filehandle.SaveDelete;

public class MappVLC {
	
	private static final String VlcIntKeysFile = "src//remoteapps//appkeydatabase//VlcIntKeys.txt";
	private static final String VlcStrKeysFile = "src//remoteapps//appkeydatabase//VlcStrKeys.txt";
//	private static final String AdobeIntKeysFile = "src//remoteapps//appkeydatabase//AdobeStrKeys.txt";
	public static ArrayList<Vector<Integer>> VlcIntKeysList;
	public static ArrayList<Vector<String>> VlcStrKeysList;
/*	public MappVLC(){
		SaveDelete mViSaveDelete=new SaveDelete();
		mViSaveDelete.OpenFile(VlcIntKeysFile);
		SaveDelete mVsSaveDelete = new SaveDelete();
		mVsSaveDelete.OpenFile(VlcStrKeysFile);
		readfile();
		SaveDelete mAiSaveDelete = new SaveDelete();
		mAiSaveDelete.OpenFile(AdobeIntKeysFile);
		readfile();
 } */
	
	public static void main(String[] args) throws IOException{
		MappVLC pReadInts =new MappVLC();
		pReadInts.scanfile();
		
	}
	public void scanfile(){
		
		ArrayList<Vector<Integer>> VlcIntKeysList = new ArrayList<Vector<Integer>>();
		Vector<Integer> intvecs;
		Scanner scanner;
		Scanner lineScanner;
		String line;
		try {
			scanner = new Scanner(new File(VlcIntKeysFile));
			
			while(scanner.hasNextLine()){
				line=scanner.nextLine();
				lineScanner=new Scanner(line);
				intvecs = new Vector<Integer>();
				while(lineScanner.hasNextInt()){
					intvecs.add(lineScanner.nextInt());					
				}
				VlcIntKeysList.add(intvecs);
				lineScanner.close();
				}
				scanner.close();
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(VlcIntKeysList.get(6).get(0));
	}
}



