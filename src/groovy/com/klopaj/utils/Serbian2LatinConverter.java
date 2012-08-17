/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.utils;

/**
 * Serbian to Latin converter.
 */
public class Serbian2LatinConverter {

	protected static final char[][] serbianLatin;
	protected static final char[][] serbianCyrillic;

	private static final int SL_LEFT_BOUNDRY = 256;
	private static final int SL_RIGHT_BOUNDRY = SL_LEFT_BOUNDRY + 128;
	private static final int SC_LEFT_BOUNDRY = 1024;
	private static final int SC_RIGHT_BOUNDRY = SC_LEFT_BOUNDRY + 128;

	static {
		// Latin
		serbianLatin = new char[128][];
		for (int i = 0; i < 128; i++) {
			serbianLatin[i] = new char[]{(char) (i + SL_LEFT_BOUNDRY)};
		}

		// upper case
		serbianLatin['Š' - SL_LEFT_BOUNDRY] = new char[]{'S'};
		serbianLatin['Ć' - SL_LEFT_BOUNDRY] = new char[]{'C'};
		serbianLatin['Č' - SL_LEFT_BOUNDRY] = new char[]{'C'};
		serbianLatin['Ž' - SL_LEFT_BOUNDRY] = new char[]{'Z'};
		serbianLatin['Đ' - SL_LEFT_BOUNDRY] = new char[]{'D', 'J'};

		// lower case
		serbianLatin['š' - SL_LEFT_BOUNDRY] = new char[]{'s'};
		serbianLatin['ć' - SL_LEFT_BOUNDRY] = new char[]{'c'};
		serbianLatin['č' - SL_LEFT_BOUNDRY] = new char[]{'c'};
		serbianLatin['ž' - SL_LEFT_BOUNDRY] = new char[]{'z'};
		serbianLatin['đ' - SL_LEFT_BOUNDRY] = new char[]{'d', 'j'};

		// Cyrillic
		serbianCyrillic = new char[128][];
		for (int i = 0; i < 128; i++) {
			serbianCyrillic[i] = new char[]{(char) (i + SC_LEFT_BOUNDRY)};
		}

		// upper case
		serbianCyrillic['А' - SC_LEFT_BOUNDRY] = new char[]{'A'};
		serbianCyrillic['Б' - SC_LEFT_BOUNDRY] = new char[]{'B'};
		serbianCyrillic['В' - SC_LEFT_BOUNDRY] = new char[]{'V'};
		serbianCyrillic['Г' - SC_LEFT_BOUNDRY] = new char[]{'G'};
		serbianCyrillic['Д' - SC_LEFT_BOUNDRY] = new char[]{'D'};
		serbianCyrillic['Ђ' - SC_LEFT_BOUNDRY] = new char[]{'D', 'J'};
		serbianCyrillic['Е' - SC_LEFT_BOUNDRY] = new char[]{'E'};
		serbianCyrillic['Ж' - SC_LEFT_BOUNDRY] = new char[]{'Z'};
		serbianCyrillic['З' - SC_LEFT_BOUNDRY] = new char[]{'Z'};
		serbianCyrillic['И' - SC_LEFT_BOUNDRY] = new char[]{'I'};
		serbianCyrillic['Ј' - SC_LEFT_BOUNDRY] = new char[]{'J'};
		serbianCyrillic['К' - SC_LEFT_BOUNDRY] = new char[]{'K'};
		serbianCyrillic['Л' - SC_LEFT_BOUNDRY] = new char[]{'L'};
		serbianCyrillic['Љ' - SC_LEFT_BOUNDRY] = new char[]{'L', 'J'};
		serbianCyrillic['М' - SC_LEFT_BOUNDRY] = new char[]{'M'};
		serbianCyrillic['Н' - SC_LEFT_BOUNDRY] = new char[]{'N'};
		serbianCyrillic['Њ' - SC_LEFT_BOUNDRY] = new char[]{'N', 'J'};
		serbianCyrillic['О' - SC_LEFT_BOUNDRY] = new char[]{'O'};
		serbianCyrillic['П' - SC_LEFT_BOUNDRY] = new char[]{'P'};
		serbianCyrillic['Р' - SC_LEFT_BOUNDRY] = new char[]{'R'};
		serbianCyrillic['С' - SC_LEFT_BOUNDRY] = new char[]{'S'};
		serbianCyrillic['Т' - SC_LEFT_BOUNDRY] = new char[]{'T'};
		serbianCyrillic['Ћ' - SC_LEFT_BOUNDRY] = new char[]{'C'};
		serbianCyrillic['У' - SC_LEFT_BOUNDRY] = new char[]{'U'};
		serbianCyrillic['Ф' - SC_LEFT_BOUNDRY] = new char[]{'F'};
		serbianCyrillic['Х' - SC_LEFT_BOUNDRY] = new char[]{'H'};
		serbianCyrillic['Ц' - SC_LEFT_BOUNDRY] = new char[]{'C'};
		serbianCyrillic['Ч' - SC_LEFT_BOUNDRY] = new char[]{'C'};
		serbianCyrillic['Џ' - SC_LEFT_BOUNDRY] = new char[]{'D', 'Z'};
		serbianCyrillic['Ш' - SC_LEFT_BOUNDRY] = new char[]{'S'};

		// lower case
		serbianCyrillic['а' - SC_LEFT_BOUNDRY] = new char[]{'a'};
		serbianCyrillic['б' - SC_LEFT_BOUNDRY] = new char[]{'b'};
		serbianCyrillic['в' - SC_LEFT_BOUNDRY] = new char[]{'v'};
		serbianCyrillic['г' - SC_LEFT_BOUNDRY] = new char[]{'g'};
		serbianCyrillic['д' - SC_LEFT_BOUNDRY] = new char[]{'d'};
		serbianCyrillic['ђ' - SC_LEFT_BOUNDRY] = new char[]{'d', 'j'};
		serbianCyrillic['е' - SC_LEFT_BOUNDRY] = new char[]{'e'};
		serbianCyrillic['ж' - SC_LEFT_BOUNDRY] = new char[]{'z'};
		serbianCyrillic['з' - SC_LEFT_BOUNDRY] = new char[]{'z'};
		serbianCyrillic['и' - SC_LEFT_BOUNDRY] = new char[]{'i'};
		serbianCyrillic['ј' - SC_LEFT_BOUNDRY] = new char[]{'j'};
		serbianCyrillic['к' - SC_LEFT_BOUNDRY] = new char[]{'k'};
		serbianCyrillic['л' - SC_LEFT_BOUNDRY] = new char[]{'l'};
		serbianCyrillic['љ' - SC_LEFT_BOUNDRY] = new char[]{'l', 'j'};
		serbianCyrillic['м' - SC_LEFT_BOUNDRY] = new char[]{'m'};
		serbianCyrillic['н' - SC_LEFT_BOUNDRY] = new char[]{'n'};
		serbianCyrillic['њ' - SC_LEFT_BOUNDRY] = new char[]{'n', 'j'};
		serbianCyrillic['о' - SC_LEFT_BOUNDRY] = new char[]{'o'};
		serbianCyrillic['п' - SC_LEFT_BOUNDRY] = new char[]{'p'};
		serbianCyrillic['р' - SC_LEFT_BOUNDRY] = new char[]{'r'};
		serbianCyrillic['с' - SC_LEFT_BOUNDRY] = new char[]{'s'};
		serbianCyrillic['т' - SC_LEFT_BOUNDRY] = new char[]{'t'};
		serbianCyrillic['ћ' - SC_LEFT_BOUNDRY] = new char[]{'c'};
		serbianCyrillic['у' - SC_LEFT_BOUNDRY] = new char[]{'u'};
		serbianCyrillic['ф' - SC_LEFT_BOUNDRY] = new char[]{'f'};
		serbianCyrillic['х' - SC_LEFT_BOUNDRY] = new char[]{'h'};
		serbianCyrillic['ц' - SC_LEFT_BOUNDRY] = new char[]{'c'};
		serbianCyrillic['ч' - SC_LEFT_BOUNDRY] = new char[]{'c'};
		serbianCyrillic['џ' - SC_LEFT_BOUNDRY] = new char[]{'d', 'z'};
		serbianCyrillic['ш' - SC_LEFT_BOUNDRY] = new char[]{'s'};
	}


	/**
	 * Converts Serbian string to latin.
	 * Recognizes both latin and cyril letters.
	 */
	public String convertToLatin(String string) {
		if (string == null) {
			return null;
		}
		return convertToLatin(string.toCharArray());
	}

	public String convertToLatin(char[] chars) {
		StringBuilder latinString = new StringBuilder();
		for (char c : chars) {
			if (c >= SL_LEFT_BOUNDRY && c < SL_RIGHT_BOUNDRY) {
				latinString.append(serbianLatin[c - SL_LEFT_BOUNDRY]);
			} else if (c >= SC_LEFT_BOUNDRY && c < SC_RIGHT_BOUNDRY) {
				latinString.append(serbianCyrillic[c - SC_LEFT_BOUNDRY]);
			} else {
				latinString.append(c);
			}
		}
		return latinString.toString();
	}

}
