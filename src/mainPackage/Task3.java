package mainPackage;



import java.util.ArrayList;
import java.util.List;


class Calendar{// - это Календарь 
	private int year; //На календаре отображон год
	private List<CalendarSheet> calendarSheets;//в каледнаре есть листочки
	Calendar(int year){
		this.year=year;
	}
	void addCalendarSheet(List<CalendarSheet> calendarSheets) {
		this.calendarSheets = calendarSheets;
	}
	 @Override
		public String toString() {
			String s="";
			String s2="";
			  for (int i=0; i < calendarSheets.size(); i++)
		        {
				  for(int j = 0; j<calendarSheets.get(i).dayOfTheMonths.size();j++ )
					  s2=s2 + "\r\n  |+++++| Число  : "
			            		+ ""+calendarSheets.get(i).getDayOfTheMonths().get(j).getNumber()+" "
			            				+ "  |+++++| День недели  : "
			            				+ ""+calendarSheets.get(i).getDayOfTheMonths().get(j).getDayOfTheWeek()+" "
			            						+ " |+++++| Выходной ли  этот день?  : "
			            						+ ""+calendarSheets.get(i).getDayOfTheMonths().get(j).isHoliday()+" "
        						+ " ";
		            s = s + "\r\n  |+++++| Название месяца : "
		            		+ ""+calendarSheets.get(i).getMonth()+" "
		            						+ " "+"\r\n"+s2;
		        }
				 return "{" +
	            " Вы просматриваете календарт :'" + year  + "года \r\n "+
	            ", Список месяцев : ||'" + s  + '\'' +
	            '}';
		}
	
 public class CalendarSheet{//собственно это Листочки
	 private String month;// на листиках нарисованы месяцы
	 private List<DayOfTheMonth> dayOfTheMonths; //в каждом месяце есть дни
	 CalendarSheet(String month){
		 this.month=month;
	 }
	 void addDayOfTheMonth(List<DayOfTheMonth> dayOfTheMonths) {
		 this.dayOfTheMonths=dayOfTheMonths;
	 }
	 
	 public class DayOfTheMonth{// Дни
		 private int number;//каждый день имеет число
		 private String dayOfTheWeek;//каждый день являет частью дня недели
		 private boolean holiday;//каждый день либо является либо не является выходным днём
		 DayOfTheMonth(int number, String dayOfTheWeek, boolean holiday){
			 this.number=number;
			 this.dayOfTheWeek=dayOfTheWeek;
			 this.holiday=holiday;
		 }
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getDayOfTheWeek() {
			return dayOfTheWeek;
		}
		public void setDayOfTheWeek(String dayOfTheWeek) {
			this.dayOfTheWeek = dayOfTheWeek;
		}
		public boolean isHoliday() {
			return holiday;
		}
		public void setHoliday(boolean holiday) {
			this.holiday = holiday;
		}
		 
	 }
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public List<DayOfTheMonth> getDayOfTheMonths() {
		return dayOfTheMonths;
	}
 }
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}	

public List<CalendarSheet> getCalendarSheets() {
	return calendarSheets;
}
}
public class Task3 {

	public static void main(String[] args) {
		List<Calendar> сalendars = new ArrayList<>();
		List<Calendar.CalendarSheet> сalendarSheets = new ArrayList<>();
		List<Calendar.CalendarSheet.DayOfTheMonth> dayOfTheMonths = new ArrayList<>();
		String[] days  = new String[] {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
		Calendar objCalendar = new Calendar(2020); //создадим календарь 2020 годы
		Calendar.CalendarSheet objCalendarSheet = objCalendar.new CalendarSheet("March"); // создадим месяц Март 2020 года
		int j=6;//Месяц март начинается с 6 дня недели Воскресенья
		boolean b;
		for(int i = 1; i < 32 ; i++) {
			if(j>4)
				b=true;
			else b=false;
		Calendar.CalendarSheet.DayOfTheMonth objDayOfTheMonth = objCalendarSheet.new DayOfTheMonth(i,days[j],b);
		dayOfTheMonths.add(objDayOfTheMonth);
		j++;
		if(j==7)
			j=0;
		}
		
		objCalendarSheet.addDayOfTheMonth(dayOfTheMonths);//добавим дни в месяц
		сalendarSheets.add(objCalendarSheet); //добавим в коллекцию
		objCalendar.addCalendarSheet(сalendarSheets);//добавим месяц в год
		сalendars.add(objCalendar);
		for (Calendar u : сalendars) {
	    	System.out.println(u); //посмотрим что получилось 
	    }
		}

}
