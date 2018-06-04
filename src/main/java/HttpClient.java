import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ivy on 2017/7/6.
 */


public class HttpClient {

    public Map<String, String> getPostXml(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map requestMap = request.getParameterMap();
        Iterator iterator = requestMap.keySet().iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            String[] values = (String[]) requestMap.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }
        return params;
    }
}
