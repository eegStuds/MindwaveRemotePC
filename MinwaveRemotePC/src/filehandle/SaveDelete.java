package filehandle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SaveDelete {

	private BufferedReader mReader;
	private BufferedWriter mWriter;
	private String mFilename;

/* public static void main(String[] args) throws IOException {

		SaveDelete pSaveDelete = new SaveDelete();
		pSaveDelete.createfile("tere");
		BufferedWriter pbf = pSaveDelete.getBufferedWriter();
		try {
			pbf.write("timesec" + "       " + "timmemillies" + "       "
					+ "Gamma1");
			pbf.newLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (pbf != null)
			System.out.print("done Writing!");
		try {
			pbf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// System.out.println(vec);
*/
	public void createfile(String pFilename) {
		mFilename = pFilename;
		try {
			mWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream( mFilename)));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ////////////////////////////////////////////
	// /////////////////make//////////////////////////////
	// ///////////////////////////

	public void OpenFile(String pfileName) {
		mFilename = pfileName;

		if (mWriter == null) {

			try {
				mWriter = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(mFilename)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    if (mReader == null) {

			try {
				mReader = new BufferedReader(new FileReader( mFilename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void writeOpenfile(String pfilename) {
		mFilename = pfilename;
		if (mWriter == null) {
			try {
				mWriter = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(mFilename )));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

	public void readOpenfile(String pfilename) {
		if (mReader == null) {
			mFilename = pfilename;

			try {
				mReader = new BufferedReader(new FileReader(mFilename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

	// //////////////////////////////////////////
	// /////////////////////////////////////////////
	// /////////////----------------//////////////////////////

	public BufferedReader getBufferedReader() {
		return mReader;
	}

	public BufferedWriter getBufferedWriter() {
		return mWriter;
	}

	public void setBufferReader(BufferedReader pBufferedReader) {
		mReader = pBufferedReader;
	}
	public void setBufferedWriter(BufferedWriter pBufferedWriter){
		mWriter = pBufferedWriter;
	}

	// public writetofile(String pFilename,)

}
