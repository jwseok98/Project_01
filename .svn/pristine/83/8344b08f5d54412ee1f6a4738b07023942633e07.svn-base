package com.lgcns.laf.page.dao;

import java.sql.Connection;
import java.util.Vector;

import com.lgcns.laf.collection.LBox;
import com.lgcns.laf.collection.LVectorBox;
import com.lgcns.laf.exception.LException;

public class LPageFactory {
	
	public LPageFactory createStatement(String pageSpec) {
		return this;
	}
	
	public LVectorBox execute(Connection conn, String sql, Vector values, LBox box, String pageSpec) throws LException {
		if(conn == null) {
			throw new LException("conn is null.");
		}
		return new LVectorBox("result");
	}
}