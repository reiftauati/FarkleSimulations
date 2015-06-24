import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class Roll {
		ArrayList<Integer> array = new ArrayList<>();
		HashMap<Integer, Integer> freq = new HashMap<>();
		static HashMap<String, Integer> results = new HashMap<String, Integer>();
		static Long finalTally = (long) 0;
		int d1;
		int d2;
		int d3;
		int d4;
		int d5;
		int d6;
		int total;
	public void initialize(){
		shakeAndBake();
		getFrequencies();
	}
	public void shakeAndBake(){
		if(!array.isEmpty()) array.clear();
		d1 = randomizer();
		d2 = randomizer();
		d3 = randomizer();
		d4 = randomizer();
		d5 = randomizer();
		d6 = randomizer();
		array.add(d1);
		array.add(d2);
		array.add(d3);
		array.add(d4);
		array.add(d5);
		array.add(d6);
		
	}
	
	public void getFrequencies(){
		int count = 0;
		for(Integer i : array){
			if(freq.containsKey(i)){ 
				count = freq.get(i);
				count++;
				freq.put(i, count);
			} else {
				freq.put(i, 1);
			}
		}
	}
	
	public void runTests(){
		boolean on = false;
		if(twoSetsOfThreeOfAKind()){ 
			total = 2500; 
			finalTally += total;
			int count = results.containsKey("twoSetsOfThreeOfAKind") ? results.get("twoSetsOfThreeOfAKind") : 0;
			results.put("twoSetsOfThreeOfAKind", count + 1);
			if(on) System.out.println("->two sets of three of a kind");
		} else if(fourOfAKindAndAPair()){ 
			total = 1500;
			finalTally += total;
			int count = results.containsKey("fourOfAKindAndAPair") ? results.get("fourOfAKindAndAPair") : 0;
			results.put("fourOfAKindAndAPair", count + 1);
			if(on) System.out.println("->4 of a kind and a pair");
		} else if(threePairs()) { 
			total = 1500;
			finalTally += total;
			int count = results.containsKey("threePairs") ? results.get("threePairs") : 0;
			results.put("threePairs", count + 1);
			if(on) System.out.println("->three pairs");
		} else if(aStraight()) { 
			total = 1500;
			finalTally += total;
			if(on) System.out.println("->a straight was found!");
			int count = results.containsKey("aStraight") ? results.get("aStraight") : 0;
			results.put("aStraight", count + 1);
		}
		else if(sixOfAKind()){ 
			total = 3000;
			finalTally += total;
			int count = results.containsKey("sixOfAKind") ? results.get("sixOfAKind") : 0;
			results.put("sixOfAKind", count + 1);
			if(on) System.out.println("->six of a kind");
		} else if(fiveOfAKind()){ 
			total = 3000;
			finalTally += total;
			int count = results.containsKey("fiveOfAKind") ? results.get("fiveOfAKind") : 0;
			results.put("fiveOfAKind", count + 1);
			if(on) System.out.println("->five of a kind");
		} else if(fourOfAKind()){ 
			total = 3000;
			finalTally += total;
			int count = results.containsKey("fourOfAKind") ? results.get("fourOfAKind") : 0;
			results.put("fourOfAKind", count + 1);
			if(on) System.out.println("->four of a kind");
		} else if(threeOfAKind()!= 0){
			if(threeOfAKind() == 1) { total = 300; finalTally += total; }
			else { total = threeOfAKind()*100; finalTally += total;
			int count = results.containsKey("threeOfAKind") ? results.get("threeOfAKind") : 0;
			results.put("threeOfAKind", count + 1);
			}
			if(on) System.out.println("->three of a kind");
		} else if(onesAndFives()!= 0){
			total = onesAndFives();
			finalTally += total;
			int count = results.containsKey("onesAndFives") ? results.get("onesAndFives") : 0;
			results.put("onesAndFives", count + 1);
			if(on) System.out.println("->ones and fives!");
		}
		//after all is said and done, do your printing.
		//printer();
		if(on) System.out.println("total is " + total);
	}
	public int onesAndFives(){
		int ones = freq.containsKey(1) ? freq.get(1) : 0;
		int fives = freq.containsKey(5) ? freq.get(5) : 0;
		
		return ones*100 + fives*50;
	}
	
	public int threeOfAKind(){
		for(Integer i : freq.keySet()){
			if(freq.get(i) == 3) { 
				return i;
			}
		}
		return 0;
	}
	
	public boolean fourOfAKind(){
		for(Integer i : freq.keySet()){
			if(freq.get(i) == 4) { 
				return true;
			}
		}
		return false;
	}
	
	public boolean fiveOfAKind(){
		for(Integer i : freq.keySet()){
			if(freq.get(i) == 5) { 
				return true;
			}
		}
		return false;
	}
	
	public boolean sixOfAKind(){
		for(Integer i : freq.keySet()){
			if(freq.get(i) == 6) { 
				return true;
			}
		}
		return false;
	}
	
	public boolean aStraight(){
		boolean a1, a2, a3, a4, a5, a6  = false;
		for(Integer i : freq.keySet()){
			int value = freq.get(i);
			if(value !=1) { 
				return false;
			} 
		}
		return true;
	}
	
	public boolean threePairs(){
		int pairCount = 0;
		for(Integer i : freq.keySet()){
			if(freq.get(i) == 2) { 
				pairCount++;
			}
		}
		if (pairCount == 3) { return true; }
		else { return false; }
	}
	
	public boolean fourOfAKindAndAPair(){
		boolean fourOfAKind = false;
		boolean andAPair = false;
		for(Integer i : freq.keySet()){
			if(freq.get(i) == 2) { 
				andAPair = true;;
			}
			if(freq.get(i) == 4) { 
				fourOfAKind = true;;
			}
		}
		if(fourOfAKind && andAPair) { return true; }
		else { return false; }
	}
	
	public boolean twoSetsOfThreeOfAKind(){
		int tripCount = 0;
		for(Integer i : freq.keySet()){
			if(freq.get(i) == 3) { 
				tripCount++;
			}
		}
		if(tripCount == 2) { return true; }
		else { return false; }
	}
	
	public int randomizer(){
		Random rand = new Random();
		int max = 6;
		int min = 1;
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public void printer(){
		for(int i = 0; i<array.size(); i++){
			System.out.print(array.get(i) + " ");
		}
		System.out.println("");
		for (Integer c: freq.keySet()){
            String key =c.toString();
            String value = freq.get(c).toString();  
            System.out.println(key + ":" + value);  
		} 
		System.out.println("points are " + total);
	}
	
	public static void displayResults(long runs){
		for (String s : results.keySet()){
            String key = s;
            double percentage = (double)results.get(s)*100/(double)runs;
            int value = results.get(s);
            System.out.print(key + " appeared ");
            System.out.printf("%,d", value);
            System.out.print(" times, ");
            System.out.printf("%.3f", percentage);
            System.out.print("% of rolls");
            System.out.println("");
		} 
		double avgRoll = finalTally/(double)runs;
		System.out.print("after ");
		System.out.printf("%,d", runs);
		System.out.print(" rolls, the average points in a single roll was ");
		System.out.printf("%.3f\n", avgRoll);
	}
}
