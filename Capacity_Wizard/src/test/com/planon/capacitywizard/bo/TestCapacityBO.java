package test.com.planon.capacitywizard.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.com.planon.capacitywizard.capacitybo.CapacityBO;
import main.com.planon.capacitywizard.days.Days;

public class TestCapacityBO {

	public static CapacityBO aCapacityBO;

	@BeforeClass
	public static void beforeClass() {
		aCapacityBO = new CapacityBO();
	}

	@Test
	public void testFetchMonthlyDayData() throws ParseException {

		List<Date> aFirstDatesList = aCapacityBO.fetchDates(Days.MONTHLY_DAY, "1/1/2018", "1/1/2019", 5,
				Days.FOURTHWEEKOFMONTH, 2, Days.SUNDAY, Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY,
				Days.FRIDAY, Days.SATURDAY);

		Date aFirstExpectedOutput = new SimpleDateFormat("E MMM dd 00:00:00 z yyyy")
				.parse("Fri Jan 05 00:00:00 IST 2018");
		Date aFirstActualOutput = aFirstDatesList.get(0);

		assertNotNull(aFirstDatesList);
		assertEquals(6, aFirstDatesList.size());
		assertEquals(aFirstExpectedOutput, aFirstActualOutput);
	}

	@Test
	public void testFetchMonthlyWeekData() throws ParseException {
		List<Date> aSecondDatesList = aCapacityBO.fetchDates(Days.MONTHLY_WEEK, "1/1/2018", "1/1/2019", 5,
				Days.FOURTHWEEKOFMONTH, 1, Days.SUNDAY, Days.TUESDAY, Days.THURSDAY, Days.SATURDAY);
		Date aSecondExpectedOutput = new SimpleDateFormat("E MMM dd 00:00:00 z yyyy")
				.parse("Sun Jan 21 00:00:00 IST 2018");
		Date aSecondActualOutput = aSecondDatesList.get(0);

		assertNotNull(aSecondDatesList);
		assertEquals(42, aSecondDatesList.size());
		assertEquals(aSecondExpectedOutput, aSecondActualOutput);

	}

	@Test
	public void testFetchWeeklyData() throws ParseException {

		List<Date> aThirdDatesList = aCapacityBO.fetchDates(Days.WEEKLY, "1/1/2018", "1/1/2019", 5,
				Days.FOURTHWEEKOFMONTH, 1, Days.MONDAY, Days.WEDNESDAY, Days.FRIDAY, Days.SUNDAY);

		Date aThirdExpectedOutput = new SimpleDateFormat("E MMM dd 00:00:00 z yyyy")
				.parse("Mon Jan 01 00:00:00 IST 2018");
		Date aThirdActualOutput = aThirdDatesList.get(0);

		assertNotNull(aThirdDatesList);
		assertEquals(207, aThirdDatesList.size());
		assertEquals(aThirdExpectedOutput, aThirdActualOutput);

	}
}