package tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @author  张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年9月30日 下午3:59:25 
 * @version 1.0  
 */
public class MatchPhone {
    public static boolean isMobilePhone(String phone) {//  
        Pattern pattern = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");  
        Matcher matcher = pattern.matcher(phone);  
        return matcher.matches();  
    }    
}
