import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void displayResults(int i, double percentage){
    	DecimalFormat df = new DecimalFormat("#.##");
    	//df.format(percentage);
    	System.out.println(i + " die is " + df.format(percentage) + "%.");
    }
    
    public static void solve(){
        System.out.println("The probability of rolling a 1 or 5 with...");
    	for(int i = 1; i<=6; i++){
        	double numDie = (double)i;
        	double outs = Math.pow(6, i);
        	double wins = Math.pow(4, i);
        	double difference = outs - wins;
        	double percentage = difference/outs*100;
        	displayResults(i, percentage);
        	
        }
    }
}