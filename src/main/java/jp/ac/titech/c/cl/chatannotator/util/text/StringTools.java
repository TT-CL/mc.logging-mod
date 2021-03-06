package jp.ac.titech.c.cl.chatannotator.util.text;

import org.apache.commons.lang3.tuple.Pair;

public class StringTools
{
    public static String printAllCharacters(String str)
    {
    	for(char c: str.toCharArray())
    	{
    		System.out.println(c + " : " + Integer.toHexString(c));
    	}
    	return str;
    }

    /**
     * Delete '§.' in the string
     */
    public static String deleteIllegalCharacters(String str)
    {
    	String ret = "";

    	for(int i=0; i<str.length(); i++)
    	{
    		char c = str.charAt(i);
    		if(c == '§') {
    			// Skip next char
    			i++;
    			continue;
    		}
    		ret += c;
    	}

    	return ret;
    }

    /**
     * Separate the String into 2 parts: prefix surrounded by symbols, and the main body after that
     */
    // TODO: ava.lang.StringIndexOutOfBoundsException: String index out of range: -1 when command input
    public static Pair<String, String> separatePrefixBySymbols(String str, char firstSymbol, char secondSymbol)
    {
    	String first;
    	String second;

		try
		{
			first = str.substring(str.indexOf(firstSymbol) + 1, str.indexOf(secondSymbol));
			second = str.substring(str.indexOf(secondSymbol) + 1);
		}
		catch (IndexOutOfBoundsException e)
		{
			// no prefix
			first = "";
			second = str;
		}

    	return Pair.of(first, second);
    }

}
