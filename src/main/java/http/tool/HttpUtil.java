package http.tool;

import okhttp3.Request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by ivy on 2017/12/7.
 */
public class HttpUtil {

    //http get param 拼接
    public static String contentParam(String url, Map<String, String> param) {
        if (param == null || "".equals(param)) {
            return url;
        }
        StringBuffer paramStr = new StringBuffer();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            paramStr.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        if (url.indexOf("?") > -1) {
            url = url.concat(paramStr.toString());
        } else {
            url = url.concat("?").concat(paramStr.substring(1, paramStr.length()));
        }
        return url;
    }

    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();
        param.put("name", "ivy");
        param.put("address", "shanghai");
        param.put("iphone", "3");
        String url = HttpUtil.contentParam("http://www.baidu.com?a=1", param);
        System.out.println(url);
    }

    public static void addHeaders(Request.Builder builder, Map<String, String> headers) {
        if (headers == null || headers.size() == 0) {
            return;
        }
        headers.forEach((key, value) -> {
            if (value != null) {
                builder.header(key, value);
            }
        });
    }
}
