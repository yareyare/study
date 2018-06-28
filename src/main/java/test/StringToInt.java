package test;

/**
 * 手写String 转 int
 */
public class StringToInt {

    private static int[] transform(String str ){
        int[] intValues = new int[str.length()];
        char[] chars = str.toCharArray();
        for (int i = 0 ; i< str.length();i ++){
            char c = chars[i];
            int integer = c - '0';
            intValues[i] = integer;
        }
        return intValues;
    }

    public static void main(String[] args) {
        String str = "1234567890aA";
        int[] transform = transform(str);
        for (int a : transform){
            System.out.println(a);
        }
    }
}
