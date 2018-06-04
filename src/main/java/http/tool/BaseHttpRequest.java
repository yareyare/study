package http.tool;

import exception.BaseException;
import okhttp3.Callback;
import okhttp3.ResponseBody;

import java.util.Map;

/**
 * Created by ivy on 2017/12/7.
 */
public interface BaseHttpRequest {

    void doGetAsyn(String url, Map<String, String> param,Map<String,String> headers, Callback callback)throws Exception;

    void doPostAsyn(String url, Map<String, String> param,Map<String,String> headers, Callback callback)throws Exception;

    String doGet(String url, Map<String, String> param, Map<String, String> headers)throws Exception;

    String doPost(String url, Map<String, String> param, Map<String, String> headers) throws Exception;
}
