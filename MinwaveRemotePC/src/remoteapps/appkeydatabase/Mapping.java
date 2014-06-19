package remoteapps.appkeydatabase;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import filehandle.SaveDelete;

public class Mapping {
	
	private static final String VlcIntKeysFile = "src//remoteapps//appkeydatabase//VlcIntKeys.txt";
	private static final String VlcStrKeysFile = "src//remoteapps//appkeydatabase//VlcStrKeys.txt";
	public static ArrayList<Vector<Integer>> VlcIntKeysList;
	public static ArrayList<Vector<String>> VlcStrKeysList;
	public Mapping(){
		SaveDelete mSaveDelete=new SaveDelete();
		mSaveDelete.OpenFile(VlcIntKeysFile);
		SaveDelete mmSaveDelete = new SaveDelete();
		mmSaveDelete.OpenFile(VlcStrKeysFile);
		
	}

}
