/*
 * Created on 31 Jul, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.shatayu.delegate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.net.ssl.internal.www.protocol.https.Handler;

/**
 * @author Shetty
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class EmployeeHibernateDAOImpl extends HibernateDaoSupport implements
		EmployeeHIbernateDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.com.shatayu.delegate.EmployeeHIbernateDAO#addEmployee(src.com.shatayu.delegate.Employee)
	 */
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.com.shatayu.delegate.EmployeeHIbernateDAO#getAllEmployees()
	 */
	public ArrayList getAllEmployees() {
		// TODO Auto-generated method stub
		Connection conn = this.getSession().connection();
		ArrayList ls = new ArrayList();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Employee ");

			while (rs.next()) {
				Map mp = new HashMap();
				mp.put("employeeId", rs.getString("employeeId"));
				mp.put("employeeName", rs.getString("employeeName"));

				ls.add(mp);
			}

			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ls;

	}

}
