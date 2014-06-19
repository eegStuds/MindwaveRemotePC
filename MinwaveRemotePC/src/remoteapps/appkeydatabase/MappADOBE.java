package remoteapps.appkeydatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import filehandle.SaveDelete;

public class MappADOBE {
	
	private static final String AdobeIntKeysFile = "src//remoteapps//appkeydatabase//AdobeStrKeys.txt";
	public static ArrayList<Vector<Integer>> AdobeIntKeysList;
	
	////////// CREAT FILE, IF NOT CREATED //////////////////////////  
    /* 	public MappADOBE(){
			SaveDelete mAiSaveDelete = new SaveDelete();
			mAiSaveDelete.OpenFile(AdobeIntKeysFile);
			readfile();
    } */
	
	public static void main(String[] args) throws IOException{
		MappADOBE pReadInts =new MappADOBE();
		pReadInts.scanfile();
		
	}
	public void scanfile(){
		
		ArrayList<Vector<Integer>> VlcIntKeysList = new ArrayList<Vector<Integer>>();
		Vector<Integer> intvecs;
		Scanner scanner;
		Scanner lineScanner;
		String line;
		try {
			scanner = new Scanner(new File(AdobeIntKeysFile));
			
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
		System.out.println(VlcIntKeysList.get(6).get(1));
	}
}



