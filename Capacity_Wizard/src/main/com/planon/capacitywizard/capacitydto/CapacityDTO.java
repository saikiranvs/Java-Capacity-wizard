package main.com.planon.capacitywizard.capacitydto;

import java.util.Date;

import main.com.planon.capacitywizard.days.Days;

public class CapacityDTO {
	private Days option;
	private Date startDate;
	private Date endDate;
	private int date;
	private Days numberOfWeek;
	private int occurences;
	private Days[] days;

	public CapacityDTO(Days aOption, Date aStartDate, Date aEndDate, int aDate, Days aNumberOfWeek, int aOccurences,
			Days... aDays) {
		this.option = aOption;
		this.startDate = aStartDate;
		this.endDate = aEndDate;
		this.date = aDate;
		this.numberOfWeek = aNumberOfWeek;
		this.occurences = aOccurences;
		this.days = aDays;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int aDate) {
		this.date = aDate;
	}

	public Days getNumberOfWeek() {
		return numberOfWeek;
	}

	public void setNumberOfWeek(Days aNumberOfWeek) {
		this.numberOfWeek = aNumberOfWeek;
	}

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}

	public Days[] getDays() {
		return days;
	}

	public void setDays(Days[] days) {
		this.days = days;
	}

	public Days getOption() {
		return option;
	}

	public void setOption(Days option) {
		this.option = option;
	}

}
