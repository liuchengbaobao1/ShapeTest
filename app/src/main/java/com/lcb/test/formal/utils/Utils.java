package com.lcb.test.formal.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by baocheng.liu on 2017/3/20.
 */

public class Utils {

    /**
     * 通过规则判断手机号
     */
    public static boolean judgePhoneNums(String mobiles) {
        Pattern p = Pattern.compile("^[1][34578][0-9]{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
