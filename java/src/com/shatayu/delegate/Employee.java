/*
 * Created on 31 Jul, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.shatayu.delegate;

/**
 * @author Shetty
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Employee {
	private String employeeId;
	private String employeeName;
	private Integer id;

	/**
	 * @return Returns the employeeId.
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @return Returns the employeeName.
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	public Integer getId() {
		return this.id;
	}

	/**
	 * @param employeeId
	 *            The employeeId to set.
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @param employeeName
	 *            The employeeName to set.
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
