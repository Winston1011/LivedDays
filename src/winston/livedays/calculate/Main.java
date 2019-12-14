/*************
 * @author : Zhi,Deng.  Group 1.
 * @date: 2019/12/04  04£º18
 * @motto: Life is wonderful and stayying up for coding hhhhhhhh
 * 
 *************/

package winston.livedays.calculate;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int y1,m1,d1,y2,m2,d2;
		@SuppressWarnings("resource") //actually I do not know what's this meannig,the " input" tips me do this
		Scanner input = new Scanner(System.in);
			
		System.out.println("Date of Birth :");
		y1 = input.nextInt();
		m1 = input.nextInt();
		d1 = input.nextInt();
		System.out.println("Today's date :");
		y2 = input.nextInt();
		m2 = input.nextInt();
		d2 = input.nextInt();	
		
		CalculateDays c1 = new CalculateDays(y1, m1, d1, y2, m2, d2);
		
		System.out.println("My age : " + c1.getLivedYears() + " years " + c1.getLivedMonths() + " months " + c1.getLivedDays() + " days");
		System.out.println("My age converted in days: " + c1.getAlldays());
		
	}

}
