package com.france.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CloseDateBase {

	public static void closeObject(ResultSet rs, PreparedStatement ps, Connection con) {
		closeObject(rs);
		closeObject(ps, con);
	}

	public static void closeObject(PreparedStatement ps, Connection con) {
		closeObject(ps);
		closeObject(con);
	}

	public static void closeObject(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
		}
	}

	public static void closeObject(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}
	}

	public static void closeObject(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
		}
	}

}
