/*
 * Created on 31 Jul, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.shatayu.delegate;

import java.util.ArrayList;

/**
 * @author Shetty
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public interface EmployeeHIbernateDAO {

	public void addEmployee(Employee e);

	public ArrayList getAllEmployees();
}
