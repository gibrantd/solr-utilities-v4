/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities.service.helper;

/**
 *
 * @author Attivio
 */
public class StringUtils {

    public static String convertirCamelCaseEnGuionbajo(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        char prevChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') {
                result.append('_');
            } else if (prevChar == ' ' || prevChar == '_') {
                result.append(Character.toLowerCase(c));
            } else if (Character.isUpperCase(c) && !Character.isUpperCase(prevChar)) {
                result.append('_');
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
            prevChar = c;
        }
        return result.toString();
    }
}
