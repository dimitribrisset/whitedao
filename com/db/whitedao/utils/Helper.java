package com.db.whitedao.utils;

import java.util.Date;

public class Helper {
	public static Long randomId(){
		return new Date().getTime();
	}
}
