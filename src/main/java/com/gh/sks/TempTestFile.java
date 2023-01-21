package com.gh.sks;

public class TempTestFile
{
    String testString = "Testing information with files";
    boolean inString = false;

    public boolean testFunc(String temp)
    {
        for(char c: testString.toCharArray())
        {
            if(c == 'i')
            {
                inString = true;
                break;
            }
        }
        return inString;
    }
}
