package rabinkarp;

public class RK {
	
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	
	private int m;
	private char[] s;
	private int hash = 0;
	private int p;
	private int count = 0;
	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		
		this.m = m;
		s = new char[m];
		
		for (int i = 0;i<m;i++){
			s[i] = '!';
		}
		
		
		int counter = 1;
		for(int j =0;j<m;j++){
			counter = counter*31 %511;
		}
		p = counter;
		
	}
	public int value(char c){
		if(c=='!'){
			return 0;
		}
		else{
			return (int)c;
		}
	}
	
	
	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		if(m==1){
			return value(d);
		}
		char c = s[count];
		s[count] = d;
		hash =  ((value(d)%511)+ (hash*31%511) - (p%511)*value(c)%511 )%511;
		
		while(hash<0){
			hash+=511;
		}
		count = (count+1)%m;
		return hash;
		
		
		
		
		
		
		
		
	}

}
