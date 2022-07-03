package com.amin.gestiondestock.interceptor;

import org.hibernate.EmptyInterceptor;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor {
	
	@Override
	public String onPrepareStatement(String sql) {
		if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("selecte")) {
			if (sql.contains("where")) {
				sql = sql + " and idEntreprise = 1";
			} else {
				sql = sql + " where idEntreprise = 1";
			}
		}
		
		return super.onPrepareStatement(sql);
	}

}
