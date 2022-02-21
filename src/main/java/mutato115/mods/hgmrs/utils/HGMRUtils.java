package mutato115.mods.hgmrs.utils;

public class HGMRUtils {
	
	public static boolean isSameSimplifiedString(String stringA, String stringB) {
		if (simplifyString(stringA).equals(simplifyString(stringB))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String simplifyString(String string) {
		string = string.toLowerCase();
		string = string.replaceAll("\\s", "");
		string = string.replaceAll("\\p{Punct}", "");
		
		string = string.replaceAll("(d|m|s)ein", "");
		string = string.replaceAll("ein", "");
		string = string.replaceAll("(der)|(die)|(das)", "");
		
		string = string.replaceAll("tz", "t");
		string = string.replaceAll("zt", "t");
		string = string.replaceAll("dt", "t");
		string = string.replaceAll("t+", "t");
		string = string.replaceAll("d+", "t");
		
		string = string.replaceAll("n+", "n");
		string = string.replaceAll("m+", "m");
		string = string.replaceAll("r+", "r");
		string = string.replaceAll("p+", "b");
		string = string.replaceAll("b+", "b");
		string = string.replaceAll("d+", "d");
		string = string.replaceAll("y+", "i");
		string = string.replaceAll("j+", "i");
		
		
		string = string.replaceAll("s+", "s");
		string = string.replaceAll("ß", "s");
		
		string = string.replaceAll("schp", "sp");
		string = string.replaceAll("scht", "st");
		string = string.replaceAll("ph", "f");
		
		string = string.replaceAll("c+", "k");
		string = string.replaceAll("k+", "k");
		string = string.replaceAll("ck", "k");
		
		string = string.replaceAll("ae", "ä");
		string = string.replaceAll("oe", "ö");
		string = string.replaceAll("ue", "ü");
		
		string = string.replaceAll("a+", "a");
		string = string.replaceAll("e+", "e");
		string = string.replaceAll("i+", "i");
		string = string.replaceAll("o+", "o");
		string = string.replaceAll("u+", "u");
		
		string = string.replaceAll("ah", "a");
		string = string.replaceAll("ai", "ei");
		string = string.replaceAll("eh", "e");
		string = string.replaceAll("ey", "ei");
		string = string.replaceAll("ih", "i");
		string = string.replaceAll("ie", "i");
		string = string.replaceAll("oh", "o");
		string = string.replaceAll("uh", "u");
		string = string.replaceAll("äh", "ä");
		string = string.replaceAll("öh", "ö");
		string = string.replaceAll("üh", "ü");
		
		return string;
	}

}
