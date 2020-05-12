package week1;

/**
 * A class for tracking visitors passing through a turnstile. A turnstile has a name, e.g. "North-West Entrance A", and keeps track of both an hourly and a total visitor count.
 * When a visitor walks through the turnstile, the software will call the {@link #incrementCounter()} method on the corresponding Turnstile object. 
 * Every hour, the software will record the hourly count using {@link #getHourly()} and the total count using {@link #getTotal()}, and will reset the hourly count using {@link #newHour()}.

 * To allow the staff to provide exceptions and adjustments, two mutators for each count are also provided. 
 * The counts can be set directly using {@link #setHourCounter(int count)} and {@link #setTotalCounter(int count)}, or both counters can be adjusted by a number using {@link #setHourCounter(int count)}
 * or using {@link #setTotalCounter(int count)}.
 *
 * CS1122 - Summer 2020
 *
 * @author Quentin Ross
 */

public class Turnstile{

    private String name;
    private int totalCount = 0;
    private int hourlyCount = 0;
    private int currentHour = 0;

	/**
	 *	A constructor for the class that sets the name of the object.
	 *
	 * @param name		the name used to identify the object.
	 */
	public Turnstile(String name){
        this.name = name;
	}

	/**
	 * Return the name of the specific Turnstile.
	 *  
	 * @return			the string containing the name of the Turnstile object.
	 */
	public String getName(){
        return name;
	}
	
	/**
	 * Return a count of the total number of people who have gone through this turnstile
	 * since it was last reset.
	 *
	 * @return			the number of people who have gone through this turnstile since the
	 *          		last reset.
	 */
	public int getTotal(){
        return totalCount;
	}
	
	/**
	 * Return a count of the total number of people who have gone through this turnstile
	 * in the last hour.
	 *
	 * @return			the number of people who have gone through this turnstile this hour.
	 */
	public int getHourly(){
        return hourlyCount;
	}
	
	/**
	 * This is called each time a person walks through the turnstile.
	 */
	public void incrementCounter(){
        hourlyCount++;
        totalCount++;
	}
	
	/**
	 * Reset all counters to 0, as well as changing to a new hour.
	 */
	public void reset(){
        totalCount = 0;
        hourlyCount = 0;
        currentHour++;
	}
	
	/**
	 * Switch to a new hour. This should reset the hourly counter, but should
	 * leave the counter for the total alone.
	 */
	public void newHour(){
        hourlyCount = 0;
        currentHour++;
	}
	
	/**
	 * In case of emergencies, we may need to manually set the hourly total for some reason.
	 * In this case, we need this method. If a negative value is provided, instead set the counter to 0.
	 *
	 * @param count		the new count that our hourly count should be set to.
	 */
	public void setHourCounter(int count){
        hourlyCount = Math.max(count, 0);
	}
	
	/**
	 * In case of emergencies, we may need to manually set the counter total for some reason.
	 * In this case, we need this method. If a negative value is provided, instead set the counter to 0.
	 *
	 * @param count		the value the total count should be set to.
	 */
	public void setTotalCounter(int count){
        totalCount = Math.max(count, 0);
	} 
	 
	 
	/**
	 * The toString method should return a string in the following format:
	 * "[NAME]: Total = [total_count], Hourly = [hourly_count]"
	 * where the square brackets signifiy what should be replaced with your information.
	 *
	 * @return	a string that displays the name, total count, and hourly count in the specified format.
	 */
    public String toString() {
        return name + ": Total = " + totalCount + ", Hourly = " + hourlyCount;
    }

	//Oh No! The method header is missing!?!?!
	 
	/**
	 * The main method here is provided to help you test your program.
	 * The first test is done for you, but you should test all problems!
	 */


	public static void main(String[] args){
		
		Turnstile example = new Turnstile("Rekhi stop");
		//Should print: "Test Name: Total = 0, Hourly = 0"
		System.out.println(example);
		
		//These are other things you can use to test, but are not part of an actual test!
		example.setTotalCounter(100);
		example.setHourCounter(50);
		example.incrementCounter();
		System.out.println(example.getName());
		System.out.println(example.getTotal());
		System.out.println(example.getHourly());
		example.reset();
		example.newHour();

        Turnstile example2 = new Turnstile("EERC stop");
        example2.setTotalCounter(20);
        example2.setHourCounter(10);
        for (int i = 0; i < 15; i++) {
            example2.incrementCounter();
        }
        System.out.println(example2);
        example2.newHour();
        System.out.println(example2.getTotal());
        System.out.println(example2.getHourly());
        example2.reset();

	}
}