package com.example.util;

/**
 * @author: ming
 * @date: 2021/10/24 16:12
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具类
 */
public class PatternUtil {

    /**
     * 匹配邮箱
     */
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);

    /**
     * 匹配中英文和数字
     */
    private static final Pattern VALID_NUM_CHAR_REGEX = Pattern.compile("^[a-zA-Z0-9\u4E00-\u9FA5]+$");

    /**
     * 匹配 URL
     */
    private static final Pattern VALID_URL_REGEX =
            Pattern.compile("^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$");


    /**
     * 验证字符串是否只包含中英文和数字
     * @param keyword
     * @return
     */
    public static boolean validKeyword(String keyword){
        Matcher matcher = VALID_NUM_CHAR_REGEX.matcher(keyword);
        return matcher.matches();
    }

    /**
     * 验证邮箱名是否合法
     * @param emailStr
     * @return
     */
    public static boolean isEmail(String emailStr){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    /**
     * 验证 URL 是否合法
     * @param urlString
     * @return
     */
    public static boolean isURL(String urlString){
        Matcher matcher = VALID_URL_REGEX.matcher(urlString);
        return matcher.matches();
    }
}
