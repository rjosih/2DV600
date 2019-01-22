/**
 * 
 */
package re222gr_assign1;

/**
 * @author rjosi
 *
 */
public class Time {
	private int seconds;
	private int minutes;
	private int hours;

	// default
	public Time() {
		hours = 0;
		minutes = 0;
		seconds = 0;
	}

	// constructor with three parameters
	public Time(int hrs, int min, int sec) {
		hours = hrs;
		minutes = min;
		seconds = sec;
	}

	// constructor with one parameter: convert seconds to hours and minutes
	public Time(int seconds) {
		hours = seconds / 3600;
		minutes = seconds / 60;
		seconds = seconds / 1;
	}

	// convert seconds to hours and minutes
	public void setClock(int seconds) {
		hours = seconds / 3600;
		minutes = seconds / 60;
		seconds = seconds / 1;
	}

	// get hours
	public int getHours() {
		return hours;
	}

	// set hours
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	// get minutes
	public int getMinutes() {
		return minutes;
	}

	// set minutes
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	// get seconds
	public int getSeconds() {
		return seconds;
	}

	// set seconds
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	// makes the ticks in the time
	public void tick() {
		  seconds++;
		  if (seconds == 60){
			  seconds = seconds % 60;          // reset seconds
		    minutes++;              // increment minutes
		    if (minutes == 60) {
		    	minutes = 0;
		    	hours++;
		    	if(hours == 24) {
		    		hours = 0;
		    	}
		    }
		  }
	}

	// decrease the ticks with -1
	public void tickDown() {
		seconds = seconds - 1;

		if (seconds < 0) {
			seconds = 50;
			minutes = minutes - 1;
		}

		if (minutes < 0) {
			minutes = 59;
			hours = hours - 1;
		}

		if (hours < 0) {
			hours = hours + 23;
		}
	}

	// adding two different times
	public Object addTime(Time t) {
		seconds = seconds + t.seconds;
		if (seconds >= 60) {
			seconds = seconds % 60;
			minutes++;
		}

		minutes = minutes + t.minutes;
		if (minutes >= 60) {
			minutes = minutes % 60;
			hours++;
		}

		hours = hours + t.hours;
		if (hours >= 24) {
			hours = hours % 24;
			hours++;
		}
		return hours + ":" + minutes + ":" + seconds;
	}

	// difference between two times
	public String subtractTime(Time t) {
		hours = hours - t.hours;
		minutes = minutes - t.minutes;
		seconds = seconds - t.seconds;		
		if(hours < 0) {
			hours = -hours;
		}
		if(minutes < 0) {
			minutes = -minutes;
		}
		if(seconds < 0) {
			seconds = -seconds;
		}
		return hours + ":" + minutes + ":" + seconds;
	}

	// presenting hours, minutes and seconds
	public String toString() {
		return hours + ":" + minutes + ":" + seconds;
	}
}
