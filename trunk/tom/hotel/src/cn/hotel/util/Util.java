package cn.hotel.util;

public class Util {
	public static boolean isNull(Object o){
		if (o == null) {
			return true;
		}
		if (o instanceof String) {
			if ("".equals(o)) {
				return true;
			}
		}
		return false;
	}
	public static boolean notNull(Object o){
		return !isNull(o);
	}
	
}
