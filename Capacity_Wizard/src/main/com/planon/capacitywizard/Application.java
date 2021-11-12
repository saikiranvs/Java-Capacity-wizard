package main.com.planon.capacitywizard;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import main.com.planon.capacitywizard.capacitybo.CapacityBO;
import main.com.planon.capacitywizard.days.Days;

public class Application {

	public static void main(String[] args) throws ParseException {

		CapacityBO aCapacityBO = new CapacityBO();

		List<Date> aDateList = aCapacityBO.fetchDates(Days.WEEKLY, "1/1/2018", "1/3/2018", 31,
				Days.FIFTHWEEKOFMONTH, 2, Days.WEDNESDAY);

//		List<Date> aDateList = aCapacityBO.fetchDates(Days.MONTHLY,"1/1/2018", "1/1/2019",21, Days.SECONDWEEK, 1, Days.MONDAY,
//				Days.WEDNESDAY, Days.FRIDAY);

//		List<Date> aDateList = aCapacityBO.fetchDates(Days.MONTHLY,"1/1/2017", "1/1/2018", 7, Days.THIRDWEEK, 2, Days.TUESDAY,
//				Days.SUNDAY);

//		List<Date> aDateList = aCapacityBO.fetchDates(Days.MONTHLY,"1/1/2018", "1/1/2019", 12, Days.FOURTHWEEK, 1, Days.THURSDAY,
//				Days.SUNDAY);

//		for (Date date : aDateList) {
//			System.out.println(date);
//		}

	}
}