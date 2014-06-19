package remoteapps.appkeydatabase;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import filehandle.SaveDelete;

public class Mapping {
	
	private static final String VlcIntKeysFile = "src//remoteapps//appkeydatabase//VlcIntKeys.txt";
	private static final String VlcStrKeysFile = "src//remoteapps//appkeydatabase//VlcStrKeys.txt";
	private static final String AdobeIntKeysFile = "src//remoteapps//appkeydatabase//AdobeStrKeys.txt";
	public static ArrayList<Vector<Integer>> VlcIntKeysList;
	public static ArrayList<Vector<String>> VlcStrKeysList;
	public Mapping(){
		SaveDelete mViSaveDelete=new SaveDelete();
		mViSaveDelete.OpenFile(VlcIntKeysFile);
		SaveDelete mVsSaveDelete = new SaveDelete();
		mVsSaveDelete.OpenFile(VlcStrKeysFile);
		readfile();
		SaveDelete mAiSaveDelete = new SaveDelete();
		mAiSaveDelete.OpenFile(AdobeIntKeysFile);
		readfile();
	}
	private void readfile() {
		// TODO Auto-generated method stub
		
	}
	

}
