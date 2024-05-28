import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecursivListFilesToTxT {

	/*
	 * Modify the previous exercise. Now, instead of displaying the result on the
	 * screen, it saves the result in a TXT file.
	 */

	public static void main(String[] args) {

		String path = "C:\\Users\\Marine\\Documents";
		File fObj = new File(path);

		if (fObj.exists() && fObj.isDirectory()) {
			// array for the files of the directory pointed by fObj
			File a[] = fObj.listFiles();
			// creating a BufferedWriter object to write to a file

			try (BufferedWriter writer = new BufferedWriter(new FileWriter("directory_listing.txt"))) {
				RecursivListFilesToTxT obj = new RecursivListFilesToTxT();
				obj.printFileNames(a, 0, 0, writer);
			} catch (IOException e) {
				System.out.println("Could not create file");
				e.printStackTrace();
			}
		}
	}

	public void printFileNames(File[] a, int i, int lvl, BufferedWriter writer) throws IOException {
		// Check if the file array is null
		if (a == null) {
			return;
		}
		// base case of the recursion
		// i == a.length means the directory has
		// no more files. Hence, the recursion has to stop
		if (i == a.length) {
			return;
		}

		// tabs for providing the indentation
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < lvl; j++) {
			sb.append("\t");
		}

		// checking if the encountered object is a file or not
		if (a[i].isFile()) {
			// Get the last modified date of the file
			Date lastModifiedDate = new Date(a[i].lastModified());
			// Format the date to readable form
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = dateFormat.format(lastModifiedDate);

			// Write file name and last modified date to the file
			writer.write(sb.toString() + "File: " + a[i].getName() + " Last Modified: " + formattedDate + "\n");
			// for sub-directories
		}else if (a[i].isDirectory()) {
			writer.write(sb.toString() + "Directory: [" + a[i].getName() + "]" + "\n");
			printFileNames(a[i].listFiles(), 0, lvl + 1, writer);
		}

		printFileNames(a, i + 1, lvl, writer);
	}
}
