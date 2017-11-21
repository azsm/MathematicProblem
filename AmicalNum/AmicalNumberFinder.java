import java.util.*;

public class AmicalNumberFinder {
	private static int LIMIT = 10000; 
	
	public static void main(String[] args) {
		List<AmicalNumberCouple> couples = new ArrayList<>();

		for(int currentValue = 2; currentValue < LIMIT; currentValue++) {
			int dividerSumValue = dividerSum(currentValue);
			if(dividerSumValue > currentValue && currentValue == dividerSum(dividerSumValue)) {
				couples.add(new AmicalNumberCouple(currentValue, dividerSumValue));
			}
		}
		
		couples.forEach(couple -> System.out.println(couple.toString()));
	}

	private static int dividerSum(int num) {
		int dividerSumValue = 1;
		
		for(int potentialDivider = 2; potentialDivider <= num/2; potentialDivider++) {
			dividerSumValue = dividerSumValue 
				+ (num % potentialDivider == 0 ? potentialDivider : 0);	
		}

		return dividerSumValue;
	}

	private static class AmicalNumberCouple{
		private int lowerValue; 
		private int upperValue; 

		public AmicalNumberCouple(int l, int u) {
			this.lowerValue = l; 
			this.upperValue = u;
		}

		public int getLowerValue() {
			return lowerValue;
		}

		public int getUpperValue() {
			return upperValue;
		}

		@Override 
		public String toString() {
			return "(" + lowerValue + ","
				 + upperValue + ")";
		}
	}
}
