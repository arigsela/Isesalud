package com.isesalud.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
public class DateUtil
{
	// Date formats.
	public static final String SIMPLE_DATE_FORMAT = "dd/MM/yyyy";
	public static final String FULL_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	// Prebuilt dates.
	public static final Date EMPTY_DATE = getDate("01/01/1900");
	public static final Date FINAL_DATE = getDate("01/01/5000");

	/**
	 */
	public static Date getDate(final String stringDate, final String format)
	{
		Date date;
		try
		{
			date = new SimpleDateFormat(format).parse(stringDate);
		}
		catch (ParseException p)
		{
			date = null;
		}
		return date;
	}

	/**
	 */
	public static Date getDate(final String stringDate)
	{
		return getDate(stringDate, SIMPLE_DATE_FORMAT);
	}

	/**
	 */
	public static String getDate(final Date date, final String format)
	{
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 */
	public static String getDate(final Date date)
	{
		return getDate(date, SIMPLE_DATE_FORMAT);
	}

	/**
	 */
	public static Date getDateFD(final Date date)
	{
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 */
	public static Date getDateFT(final Date date)
	{
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 */
	public static Date getDateLT(final Date date)
	{
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 */
	public static int getYear(final Date date)
	{
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 */
	public static Date addDays(final Date date, final int days)
	{
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, days);
		return c.getTime();
	}

	/**
	 */
	public static Date addMonths(final Date date, final int months)
	{
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		return c.getTime();
	}

	/**
	 */
	public static Date addYears(final Date date, final int years)
	{
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, years);
		return c.getTime();
	}
	
	public static Date addMinutes(final Date date, final int minutes){
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, minutes);
		return c.getTime();
	}

	/**
	 */
	public static long getTime()
	{
		return System.currentTimeMillis();
	}

	/**
	 */
	public static long getElapsedTime(final long startTime)
	{
		return getTime() - startTime;
	}

	/**
	 */
	public static long getDiffTime(final Date date1, final Date date2)
	{
		return date1.getTime() - date2.getTime();
	}
	
	public static Date combineDateTime(Date date, Date time){
		Calendar calDT = Calendar.getInstance();
		calDT.setTime(date);
		
		Calendar calT = Calendar.getInstance();
		calT.setTime(time);
		
		calDT.set(Calendar.HOUR_OF_DAY, calT.get(Calendar.HOUR_OF_DAY));
		calDT.set(Calendar.MINUTE, calT.get(Calendar.MINUTE));
		calDT.set(Calendar.SECOND, calT.get(Calendar.SECOND));
		calDT.set(Calendar.MILLISECOND, calT.get(Calendar.MILLISECOND));
		
		Date result = calDT.getTime();
		
		return result;
	}
}
