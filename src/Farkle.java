import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class Farkle {

	public static void main(String[] args) {
		long runs = (long)1000001;
		double days = (double)runs*3/60/60/24;
		double years = days/365;
		System.out.println("patience, we are simulating " + NumberFormat.getNumberInstance(Locale.US).format(runs) + " dice rolls");
		System.out.println("if we were to do this by hand it would take approx " + NumberFormat.getNumberInstance(Locale.US).format(days) + " days");
		System.out.println("or, " + years + " years.");
		for(long i = (long)0; i< runs; i++){
			//System.out.println("roll number " + i);
			Roll r = new Roll();
			r.initialize();
			r.runTests();
			//this is a comment, making some changes
			if(i%10000000 == 0){ System.out.println("another 10M mark has passed."); }
		}
		System.out.println("THE FARKLE PROBABILITY MACHINE!!!!\nthis program written by Maka for \nthe benefit of Aunty Cheryl.");
        System.out.println("you can know your odds on each roll :)");
		Roll.displayResults((int)runs);
		Solution.solve();

	}

}
