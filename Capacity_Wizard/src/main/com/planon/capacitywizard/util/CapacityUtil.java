package main.com.planon.capacitywizard.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import main.com.planon.capacitywizard.capacitydto.CapacityDTO;
import main.com.planon.capacitywizard.days.Days;

public class CapacityUtil {

	public static List<Date> calculateDates(CapacityDTO aCapacityDTO) {

		List<Date> aDateList = new ArrayList<Date>();
		Calendar aStartdate = Calendar.getInstance();
		Days[] aDays = aCapacityDTO.getDays();
		int aSelectedDay = 0, aCurrentDay = 0;
		for (int i = 0; i < aDays.length; i++) {

			aStartdate.setTime(aCapacityDTO.getStartDate());

			while ((aStartdate.getTime()).before(aCapacityDTO.getEndDate())) {

				aSelectedDay = aDays[i].getAction();
				aCurrentDay = aStartdate.get(Calendar.DAY_OF_WEEK);
//				System.out.print("loop");
				if (aCapacityDTO.getOption() == Days.MONTHLY_WEEK) {

					aStartdate.set(Calendar.WEEK_OF_MONTH, aCapacityDTO.getNumberOfWeek().getAction());
					getExactDate(aSelectedDay, aCurrentDay, aStartdate, aCapacityDTO, aDateList);
					aStartdate.add(Calendar.MONTH, aCapacityDTO.getOccurences());

				} else if (aCapacityDTO.getOption() == Days.WEEKLY) {
					getExactDate(aSelectedDay, aCurrentDay, aStartdate, aCapacityDTO, aDateList);
					aStartdate.add(Calendar.WEEK_OF_YEAR, aCapacityDTO.getOccurences());

				} else if (aCapacityDTO.getOption() == Days.MONTHLY_DAY) {

					if (aStartdate.getActualMaximum(Calendar.DAY_OF_MONTH) < aCapacityDTO.getDate()) {
						aStartdate.add(Calendar.MONTH, 1);
						if (aStartdate.get(Calendar.DATE) != aCapacityDTO.getDate()) {
							aStartdate.add(Calendar.DATE, (aCapacityDTO.getDate() - aStartdate.get(Calendar.DATE)));
						}
					}
					aStartdate.set(Calendar.DAY_OF_MONTH, aCapacityDTO.getDate());
					getExactDate(aSelectedDay, aCurrentDay, aStartdate, aCapacityDTO, aDateList);
					aStartdate.add(Calendar.MONTH, aCapacityDTO.getOccurences());
				}
			} // while
			if (aCapacityDTO.getOption() == Days.MONTHLY_DAY) {
				break;
			}
		}
		return aDateList;

	}

	private static void getExactDate(int aSelectedDay, int aCurrentDay, Calendar aStartdate, CapacityDTO aCapacityDTO,
			List<Date> aDateList) {
		if (aCapacityDTO.getOption() == Days.MONTHLY_WEEK || aCapacityDTO.getOption() == Days.WEEKLY) {

			if (aSelectedDay < aCurrentDay) {
				aStartdate.add(Calendar.DATE, (aSelectedDay - aCurrentDay + 7));
			} else {
				aStartdate.add(Calendar.DATE, (aSelectedDay - aCurrentDay));
			}
			if (aStartdate.getTime().before(aCapacityDTO.getStartDate())) {
				aStartdate.add(Calendar.DATE, 7);
				System.out.println(aStartdate.getTime());
			}
		}
		Date aDate = aStartdate.getTime();
		aDateList.add(aDate);
		System.out.println("     " + aStartdate.getTime());
	}
}