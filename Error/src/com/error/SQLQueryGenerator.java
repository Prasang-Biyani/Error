package com.error;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class SQLQueryGenerator {

	private HttpServletRequest request;
	public SQLQueryGenerator(HttpServletRequest request) {
		this.request = request;
	}
	//Query Generate Function
	public String generateQuery() {
		String errorNumber = request.getParameter("errornum");
		String errorType = request.getParameter("errortype");
		String errorDesc = request.getParameter("errordesc");
		String errorStartDate = request.getParameter("errorstartdate");
		String errorStartTime = request.getParameter("errorstarttime");
		String errorEndDate = request.getParameter("errorenddate");
		String errorEndTime = request.getParameter("errorendtime");
		StringBuffer sb = new StringBuffer();
		
		if(errorNumber.length() == 0 && errorType.length() == 0 && errorDesc.length() == 0 && errorStartDate.length() == 0 &&
				errorStartTime.length() == 0 && errorEndDate.length() == 0 && errorEndTime.length() ==0) {
			sb.append("Select * from error");
		}else {
			sb.append("Select * from error where ");
		}
		List<String> partialQueries = new ArrayList<String>();
		//partialQueries.add(constructExactMatchQuery(ErrorDAO.ERROR_SEARCH_EID, errorNumber));
		partialQueries.add(constructExactMatchQuery(ErrorDAO.ERROR_SEARCH_EID, errorNumber));
		partialQueries.add(constructExactMatchQuery(ErrorDAO.ERROR_SEARCH_CATEGORY, errorType));
		partialQueries.add(constructPatternMatchQuery(ErrorDAO.ERROR_SEARCH_DESC, errorDesc));
		partialQueries.add(constructDateMatchQuery(ErrorDAO.ERROR_SEARCH_DATE, errorStartDate, errorEndDate));
		partialQueries.add(constructDateMatchQuery(ErrorDAO.ERROR_SEARCH_TIME, errorStartTime, errorEndTime));
		Iterator<String> it = partialQueries.iterator();
		
		boolean lastSuccess = false;
		while (it.hasNext()) {					//Checks whether paritalQueries has next element or not
			String partialQuery = it.next();	//Collects the value of current iterator
			System.out.println(partialQuery);
			if (partialQuery.length() != 0) {	//Check whether multiple fields are there or not
				if (lastSuccess) {
					sb.append(" and ");
				}
				sb.append(partialQuery);
				lastSuccess = true;
			} /*else {
				lastSuccess = false;
			}*/
		}
		sb.append(";");
		System.out.println("Query constructed : " + sb.toString());
		return sb.toString();
	}
	
	String constructExactMatchQuery(String column, String input) {
		StringBuffer sb = new StringBuffer();
		if (input != null && input.length() != 0 ) {
			sb.append(column).append(" = ").append("\"").append(input).append("\"");
		}
		return sb.toString();
	}
	
	String constructPatternMatchQuery(String column, String input) {
		StringBuffer sb = new StringBuffer();
		if (input != null && input.length() != 0 ) {
			sb.append(column).append(" like ").append("\"%").append(input).append("%\"");
		}
		return sb.toString();
	}
	
	String constructDateMatchQuery(String column, String startDate, String endDate) {
		StringBuffer sb = new StringBuffer();
		if (startDate != null && startDate.length() != 0 ) {
			sb.append(column).append(" >= ").append("\"").append(startDate).append("\"");
		}
		if (endDate != null && endDate.length() != 0) {
			if (startDate != null && startDate.length() != 0 ) {
				sb.append(column).append(" >= ").append("\"").append(startDate).append("\"");
				sb.append(" and ").append(column).append(" <= " ).append("\"").append(endDate).append("\"");
			}
			else
				sb.append(column).append(" <= " ).append("\"").append(endDate).append("\"");
		}
		return sb.toString();
	}
	
	String constructTimeMatchQuery(String column, String startTime, String endTime) {
		StringBuffer sb = new StringBuffer();
		if (startTime != null && startTime.length() != 0 ) {
			sb.append(column).append(" >= ").append("\"").append(startTime).append("\"");
		}
		if (endTime != null && endTime.length() != 0 ) {
			sb.append(" and ").append(column).append(" <=" ).append("\"").append(endTime).append("\"");
		}
		return sb.toString();
	}
}
