public class Algebra {
	public static void main(String args[]) {
	    // Tests operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36)); 
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1++; 
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1--; 
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int newX = x1;
			for (int i = 1 ; i < x2; i++) {
				x1 = plus(x1,newX);
			} 
			return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n >= 0) {
			int newX = x;
			for (int i = 1 ; i < n; i++) {
				x = times(x,newX);
			} 
		}
			return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 1;
		int newX = x2;
			while (x1 >= x2) {
				x2 = plus(x2,newX);
				count++;
			}
				if (x2 > x1) {
					count = minus(count,1);
				}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int div = div(x1, x2);
		int times = times(div, x2);
		x1 = minus(x1, times);
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int newX = 0;
		for (int i = 0; i <= x; i++) {
			newX = times(i, i);
				if (newX > x) {
					newX = minus(i,1);
					break;
				} else if (newX == x) {
					newX = i;
					break;
				}
		}
		return newX;
	}	  	  
}