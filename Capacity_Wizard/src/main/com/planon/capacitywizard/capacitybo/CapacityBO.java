package main.com.planon.capacitywizard.capacitybo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import main.com.planon.capacitywizard.capacitydto.CapacityDTO;
import main.com.planon.capacitywizard.days.Days;
import main.com.planon.capacitywizard.util.CapacityUtil;

public class CapacityBO {

	public List<Date> fetchDates(Days aOption, String aFirstDate, String aSecondDate, int aThirdDate,
			Days aNumberOfWeek, int aOccurences, Days... aDays) throws ParseException {
		Date aStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(aFirstDate);
		Date aEndDate = new SimpleDateFormat("dd/MM/yyyy").parse(aSecondDate);
		CapacityDTO aCapacityDTO = new CapacityDTO(aOption, aStartDate, aEndDate, aThirdDate, aNumberOfWeek,
				aOccurences, aDays);

		return CapacityUtil.calculateDates(aCapacityDTO);
	}

}