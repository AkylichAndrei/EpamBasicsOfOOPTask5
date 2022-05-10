package mainPackage;



import java.util.ArrayList;
import java.util.List;


class Calendar{// - ��� ��������� 
	private int year; //�� ��������� ��������� ���
	private List<CalendarSheet> calendarSheets;//� ��������� ���� ��������
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
					  s2=s2 + "\r\n  |+++++| �����  : "
			            		+ ""+calendarSheets.get(i).getDayOfTheMonths().get(j).getNumber()+" "
			            				+ "  |+++++| ���� ������  : "
			            				+ ""+calendarSheets.get(i).getDayOfTheMonths().get(j).getDayOfTheWeek()+" "
			            						+ " |+++++| �������� ��  ���� ����?  : "
			            						+ ""+calendarSheets.get(i).getDayOfTheMonths().get(j).isHoliday()+" "
        						+ " ";
		            s = s + "\r\n  |+++++| �������� ������ : "
		            		+ ""+calendarSheets.get(i).getMonth()+" "
		            						+ " "+"\r\n"+s2;
		        }
				 return "{" +
	            " �� �������������� ��������� :'" + year  + "���� \r\n "+
	            ", ������ ������� : ||'" + s  + '\'' +
	            '}';
		}
	
 public class CalendarSheet{//���������� ��� ��������
	 private String month;// �� �������� ���������� ������
	 private List<DayOfTheMonth> dayOfTheMonths; //� ������ ������ ���� ���
	 CalendarSheet(String month){
		 this.month=month;
	 }
	 void addDayOfTheMonth(List<DayOfTheMonth> dayOfTheMonths) {
		 this.dayOfTheMonths=dayOfTheMonths;
	 }
	 
	 public class DayOfTheMonth{// ���
		 private int number;//������ ���� ����� �����
		 private String dayOfTheWeek;//������ ���� ������ ������ ��� ������
		 private boolean holiday;//������ ���� ���� �������� ���� �� �������� �������� ���
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
		List<Calendar> �alendars = new ArrayList<>();
		List<Calendar.CalendarSheet> �alendarSheets = new ArrayList<>();
		List<Calendar.CalendarSheet.DayOfTheMonth> dayOfTheMonths = new ArrayList<>();
		String[] days  = new String[] {"�����������", "�������", "�����", "�������", "�������", "�������", "�����������"};
		Calendar objCalendar = new Calendar(2020); //�������� ��������� 2020 ����
		Calendar.CalendarSheet objCalendarSheet = objCalendar.new CalendarSheet("March"); // �������� ����� ���� 2020 ����
		int j=6;//����� ���� ���������� � 6 ��� ������ �����������
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
		
		objCalendarSheet.addDayOfTheMonth(dayOfTheMonths);//������� ��� � �����
		�alendarSheets.add(objCalendarSheet); //������� � ���������
		objCalendar.addCalendarSheet(�alendarSheets);//������� ����� � ���
		�alendars.add(objCalendar);
		for (Calendar u : �alendars) {
	    	System.out.println(u); //��������� ��� ���������� 
	    }
		}

}
