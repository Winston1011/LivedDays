/*************
 * @author :Zhi,Deng.  Group 1.
 * @date: 2019/12/04  04£º18 modified: 2019/12/08 23:03
 * @motto: Life is wonderful and stayying up for coding hhhhhhhh
 * @methods: calculate all liveddays and diffrent lived years, months, and days!
 *************/

package winston.livedays.calculate;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculateDays {
	private int year1, month1, day1;
	private int year2, month2, day2;
	
	public CalculateDays(int y1,int m1, int d1,int y2,int m2, int d2) {
		this.year1 = y1;
		this.month1 = m1;
		this.day1 = d1;
		this.year2 = y2;
		this.month2 = m2;
		this.day2 = d2;
	}
	
	private static int[] month = {31,30,28};	
	private static final Map<Integer,Integer> monthMap = new LinkedHashMap<>();
		
	static {
		monthMap.put(1, month[0]);
		monthMap.put(2, month[2]);
		monthMap.put(3, month[0]);
		monthMap.put(4, month[1]);
		monthMap.put(5, month[0]);
		monthMap.put(6, month[1]);
		monthMap.put(7, month[0]);
		monthMap.put(8, month[0]);
		monthMap.put(9, month[1]);
		monthMap.put(10, month[0]);
		monthMap.put(11, month[1]);
		monthMap.put(12, month[0]);	
	}
	
	
	/**** get the years we have been lived (nothing about the days)*******/
	public int getLivedYears() {		
		return (month2 > month1 ||(month2 == month1 && day2 >= day1)) ? (year2 - year1) : year2 - year1 -1;
	}	
	
	/**** get the months we have been lived (nothing about the years)*******/
	public int getLivedMonths() {	
		return (month2 >= month1 && day2 >= day1) ? month2 - month1
				:((month2 <= month1 && day2 < day1) ? 11- month1 + month2
						:((month2 > month1 && day2 < day1) ? month2 - month1 -1
								: 12 - month1 + month2  ) );
	}
		
	/**** get the days we have been lived*******/
	public int getLivedDays() {	
		return day2 < day1 ? ((IsLeap(year1) == 365 ? monthMap.get(month1): 29 ) - day1 + day2 ): day2 -day1;
	}
	
	/****I used 0/12/31 as my base date point,to calculate the diff value of each date from base year point	*****/
	public int getDiffValue(int y,int m,int d) {		
		return m==1 ? (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400 + d 
				: (m == 2 ? (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400 + d +31 
				:(y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400 + (m - 1)*28 + (13*(m+1))/5 - 7 + d +IsLeap(y)/366 );	
	}
	
	/**** get the alldays we have been lived *******/
	public int getAlldays() {
		return getDiffValue(year2,month2,day2) - getDiffValue(year1,month1,day1);
	}
	
	/****	Define whether if it is a leap year	***/
	public int IsLeap(int y) {		
		return (y % 400 == 0 || (y % 4 == 0 && y % 100 !=0 )) ? 366 : 365;
	}
			
}
