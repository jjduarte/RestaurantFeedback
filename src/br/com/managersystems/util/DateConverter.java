package br.com.managersystems.util;

import java.sql.Date;
import java.util.Calendar;

public class DateConverter {



	public Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
