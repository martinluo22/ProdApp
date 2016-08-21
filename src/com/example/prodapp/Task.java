package com.example.prodapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Task {

	private boolean recurring;
	private String category;
	private String startDateString;
	private String endDateString;
	private Date startDate;
	private Date endDate;
	
	
	//http://www.java2s.com/Tutorial/Java/0040__Data-Type/SimpleDateFormat.htm
	private static void dateParser(String dateString, Date date){
		
		String datePattern = "MM/dd/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		try{
		date = dateFormat.parse(dateString);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	}
	
	public void setRecurring(boolean recurring){
		this.recurring = recurring;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public void setStartDate(String startDateString){
		this.startDateString = startDateString;
		dateParser(startDateString,startDate);		
	}
	
	public void setEndDate(String endDateString){
		this.endDateString = endDateString;
		dateParser(endDateString,endDate);
	}
	
	public boolean getRecurring(){
		return this.recurring;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public Date getStartDate(){
		return this.startDate;
	}
	
	public Date getEndDate(){
		return this.endDate;
	}
	
	public String getStartDateString(){
		return this.startDateString;
	}
	
	public String getEndDateString(){
		return this.endDateString;
	}
	
	
}
