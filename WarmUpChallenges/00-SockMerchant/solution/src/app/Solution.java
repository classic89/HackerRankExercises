package app;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution extends App{
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        // int sock = 0;
        for (int i = 0; i < ar.length-1; i++) {
            int sock = ar[i];
            // System.out.print(" "+sock+" ");
            if (set.contains(sock)) {
                // block of code to be executed if set.contains(sock) is true
                // System.out.print(" T ");
                set.remove(sock);
                count++;  
            } else { 
                // block of code to be executed if set.contains(sock) is false
                // System.out.print(" F ");
                set.add(sock);
            } 
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = null;
        FileWriter out = null;
        try{
            File outputFile = getOutputFile();
            out = new FileWriter(outputFile);
            bufferedWriter = new BufferedWriter(out);
            int[] ar = App.AppMain();
            int result = sockMerchant(App.getAttribute(), ar);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            out.close();
        }
        
    }
}


class App {

    // private static final Scanner scanner = new Scanner(System.in);
    private static final String LOCAL_FILE = "C:\\dev\\repo\\HackerRank\\HackerRankExercises\\WarmUpChallenges\\00-SockMerchant\\sock-merchant-test-cases";
    private static final String extension = ".txt";
    private static final String SYSTEM_PATH = System.getenv("OUTPUT_PATH");

    private static int Attribute; // private = restricted access
    
      // Getter
    public int getAttribute() {
        return Attribute;
    }
    
      // Setter
    public void setAttribute(int newAttribute) {
        this.Attribute = newAttribute;
    }
    

    public static int[] AppMain() throws Exception {
        System.out.print("Hello\n");
        FileReader in = null;
        Scanner scanner = null;
        try{
            File inputFile = getInputFile();
            in = new FileReader(inputFile);
            scanner = new Scanner(in);
            int n = scanner.nextInt();
            setAttribute(n);
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] ar = new int[n];
            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                ar[i] = arItem;
            }
            return ar;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            in.close();
            scanner.close();
        }
        
    }

    static String hasThisFilePath(String filename){
        if (SYSTEM_PATH == null || SYSTEM_PATH.isEmpty()) {
        // block of code to be executed if filename.isEmpty() is true
            String pathOfLocalFile = LOCAL_FILE + filename + extension;
            // System.out.println("path: "+pathOfLocalFile);
            return pathOfLocalFile;
        } else { 
        // block of code to be executed if filename.isEmpty() is false
            return SYSTEM_PATH;
        } 
    }

    static File getOutputFile(){
        File testFile = new File(hasThisFilePath("\\output\\output01"));
        testFile.setReadable(true);
        return testFile;
    }

    static File getInputFile(){
        File testFile = new File(hasThisFilePath("\\input\\input08"));
        return testFile;
    }

}