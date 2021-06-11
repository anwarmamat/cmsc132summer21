package tests;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestsSupport {
	
	/* Leave the following variable set to false.  We use while developing the */
	/* expected solutions for a test.  If you change it to false you will corrupt */
	/* your *.txt files containing expected results. */
	private static boolean generateOfficialResults = false;
	
	/**
	 * Feel free to use the correctResults method while developing your own tests.
	 * Notice that if you define text files with some expected results, the text
	 * files must be named starting with "studentTest" and ending with the .txt 
	 * extension. If you don't name files this way, then the submit server will 
	 * generate an authorization error.  
	 * @param filename
	 * @param results
	 * @return true if the contents of the file corresponds to those in results
	 */
	public static boolean isCorrect(String filename, String results) {
		officialUseIgnore(filename, results);
        String officialResults="";
        try {
            BufferedReader fin = new BufferedReader(new FileReader(filename));
           
            String line;
            while ((line = fin.readLine()) != null) {
                officialResults += line + "\n";
            }
            fin.close();
        }catch (IOException e) {
            System.out.println("File operation in isCorrect failed.");
            return false;
        } 
        
        results = removeBlanks(results);
        officialResults = removeBlanks(officialResults);
        
        if (results.equals(officialResults)) {
            return true;
        }
        
        return false;
    }
	
	public static boolean sameContents(String firstFile, String secondFile) {
        if (removeBlanks(fileData(firstFile)).equals(removeBlanks(fileData(secondFile))))
        	return true;
                
        return false;
	}
	
	public static String fileData(String fileName) {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Scanner fileScanner = new Scanner(bufferedReader);
		
			while (fileScanner.hasNextLine())  
				stringBuffer.append(fileScanner.nextLine());
			
			fileScanner.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return stringBuffer.toString();
    }
	
	public static String removeBlanks(String src) {
		StringBuffer resultsBuf = new StringBuffer();
		
		char curr;
		for (int i=0; i<src.length(); i++) {
			curr = src.charAt(i);
			if (curr != ' ' && curr != '\n')
				resultsBuf.append(curr);
		}
		return resultsBuf.toString();
	}
	
	public static boolean writeToFile(String filename, String message) {
		try {
			FileWriter output = new FileWriter(filename);
			output.write(message);
			output.close(); 
			
		} catch(IOException exception) { 
			System.out.println("ERROR: Writing to file " + filename + " failed.");
			return false;
		}
		return true;
	}
	
	/**
	 * We use this method to generate text files with the expected results for a test.
	 * @param filename
	 * @param results
	 */
	private static void officialUseIgnore(String filename, String results) {
		if (generateOfficialResults) {
			String warningMessage = "Warning: You will overwrite result files.";
			warningMessage += " Do you want to continue?";
			if (JOptionPane.showConfirmDialog(null, warningMessage) == JOptionPane.YES_OPTION) {
				TestsSupport.writeToFile(filename, results);
				System.out.println("File " + filename + " has been updated.");
			}
		}
	}
}