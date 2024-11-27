public class Algebra {
	public static void main(String args[]) {
	    // Tests operations
	    System.out.println(plus(2, 3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,-3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36)); 
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	public static int abs(int x) {
		int x2 = x;
		int count = 0;
		if (x2 >= 0) {
			return x2;
		} else if (x2 < 0) {
			while (x2 < 0) {
				x2++;
				count++;
			}
		}
		return count;
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int count = 0;
		if (x2 < 0) {
			while (x2 < 0) {
				x2++;
				count++;
			}
				for (int i = 0; i < count; i++) {
					x1--;
				}
		} else {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int count = 0;
		if (x2 < 0) {
			while (x2 < 0) {
				x2++;
				count++;
			}
				for (int i = 0; i < count; i++) {
					x1++;
				}
		} else {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
		}
		return x1;
	}

	
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int newX1 = x1;
        int result = 0;
        int count = 0;
        if (newX1 < 0) {
			while (newX1 < 0) {
				newX1++;
				count++;
			}
            newX1 = count;
		}
        int newX2 = x2;
		count = 0;
        if (newX2 < 0) {
			while (newX2 < 0) {
				newX2++;
				count++;
			}
            newX2 = count;
		}
        if (x1 == 0 || x2 == 0) {
            return 0;
        } 
        for (int i = 1 ; i <= newX2; i++) {
            result = plus(result, newX1);
        }
        if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
            result = minus(0, result);
            }
        return result; 
        }
    
	
	

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int newX = x;
		if (n > 0) {
			for (int i = 1 ; i < n; i++) {
				newX = times(x,newX);
			}	
		} else if (n == 0) {
			newX = 1;
		}	
		return newX;

	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 0;
		int result = 0;
		int newX2 = x2;
		if (newX2 < 0) {
			while (newX2 < 0) {
				newX2++;
				count++;
			}
			newX2 = count;
		}
		int newX1 = x1;
		count = 0;
		if (newX1 < 0) {
			while (newX1 < 0) {
				newX1++;
				count++;
			}
			newX1 = count;
		}
		count = 0;
		result = 0;
		while (newX1 >= result) {
			result += newX2;
			count++;
		}
		if (result > newX1) {
			count = count - 1;
		}
		if ((x1 < 0 && x2 > 0) || (x2 < 0 && x1 > 0)) {
			count = 0 - count;
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


