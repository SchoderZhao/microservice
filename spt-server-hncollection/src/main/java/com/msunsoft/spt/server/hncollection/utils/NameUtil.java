package com.msunsoft.spt.server.hncollection.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameUtil {

    public static String replaceNameX(String str){
        String reg = ".{1}";
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        int i = 0;
        while(m.find()){
            i++;
            if(i==1)
                continue;
            m.appendReplacement(sb, "*");
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
