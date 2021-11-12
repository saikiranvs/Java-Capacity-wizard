package main.com.planon.capacitywizard.days;

public enum Days {

	SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7), FIRSTWEEKOFMONTH(1), SECONDWEEKOFMONTH(2),
	THIRDWEEKOFMONTH(3), FOURTHWEEKOFMONTH(4), FIFTHWEEKOFMONTH(5),SIXTHWEEKOFMONTH(6), MONTHLY_WEEK(1), WEEKLY(2), MONTHLY_DAY(3);

	private int aValue;

	public int getAction() {
		return this.aValue;
	}

	private Days(int action) {
		this.aValue = action;
	}
}