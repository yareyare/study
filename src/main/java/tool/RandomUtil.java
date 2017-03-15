package tool;

import java.util.Random;

/** 
 * @author  张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2017年3月3日 下午3:24:30 
 * @version 1.0  
 */
public class RandomUtil {
    
    public static String GetRandomString(int Len) {
        String[] baseString = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        Random random = new Random();
        int length = baseString.length;
        String randomString = "";
        for (int i = 0; i < length; i++) {
            randomString += baseString[random.nextInt(length)];
        }
        random = new Random(System.currentTimeMillis());
        String resultStr = "";
        for (int i = 0; i < Len; i++) {
            resultStr += randomString.charAt(random.nextInt(randomString.length() - 1));
        }
        return resultStr;
    }
    
    //len 为100 则生成100内的随机数
    private static String getRandom(int len) {
        double a = Math.random();
        int i = (int) (a * len + len);
        String messageCode = String.valueOf(i);
        return messageCode;
    }
}
