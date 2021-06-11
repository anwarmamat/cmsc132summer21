package frequency;
import utils.In;
import utils.Stopwatch;
/**
 *
 * @author UMD CS
 * CMSC132 Summer 2020
 */
public class WordFrequency {
	
	private static Frequency<String> freq ;
	
	public static void insertWords(String str){
		
        String delims = "[ .,?!'\"()}{;/<>&=#-:\\ _]+";
        String[] words = str.split(delims);
        for(String s: words){
            s = s.toLowerCase();
            if(!s.equals("")) 
            	freq.insert(s);
            
        }
    }

  /**
  * Do NOT modify this method
  */
	public static String freq(String inputSource, int maxLines){
		In in;
		freq = new Frequency();
        int MAX = 100;
        String inputSourceName = inputSource;
        try {
            in = new In(inputSourceName);
            while (!in.isEmpty()) {
                String s = in.readLine();
                if(!s.equals(""))
                	insertWords(s);   
            }            
        }
        catch (Exception e) { 
            e.printStackTrace();
        }
        return freq.getWords(maxLines).replaceAll(" ", ",");
	}
  

    /**
     * You are allowed to modify main method for testing purposes only
     * Changes will be lost upon submission
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        In in;
        freq = new Frequency();
        int MAX = 100;
        String inputSourceName = "https://www.gutenberg.org/files/2600/2600-h/2600-h.htm";
        System.out.println("read from " + inputSourceName);
        System.out.println("---------------------------------------------------------------------------");
        Stopwatch sw = new Stopwatch();
        
        String result = freq(inputSourceName, MAX);
        System.out.println("Elapsed time:" + sw.elapsedTime());
        
        System.out.println(result);
    }
}
