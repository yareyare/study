package http;

import http.tool.BaseHttpRequest;
import http.tool.HttpRequest;
import http.tool.HttpsRequest;
import okhttp3.Callback;
import okhttp3.ResponseBody;

import java.util.Map;

/**
 * Created by ivy on 2017/12/7.
 */
public class Request implements BaseHttpRequest{


    @Override
    public String doGet(String url, Map<String, String> param, Map<String, String> headers) throws Exception {
        if (url.startsWith("http")){
            return new HttpRequest().doGet(url,param,headers);
        }else{
            return new HttpsRequest().doGet(url,param,headers);
        }
    }

    @Override
    public String doPost(String url, Map<String, String> param, Map<String, String> headers) throws Exception {
        if (url.startsWith("http")){
            return new HttpRequest().doPost(url,param,headers);
        }else{
            return new HttpsRequest().doPost(url,param,headers);
        }
    }

    @Override
    public void doGetAsyn(String url, Map<String, String> param,Map<String,String> headers, Callback callback) throws Exception{
        if (url.startsWith("http")){
            new HttpRequest().doGetAsyn(url,param,headers,callback);
        }else{
            new HttpsRequest().doGetAsyn(url,param,headers,callback);
        }
    }

    @Override
    public void doPostAsyn(String url, Map<String, String> param,Map<String,String> headers, Callback callback) throws Exception {
        if (url.startsWith("http")){
            new HttpRequest().doPostAsyn(url,param,headers,callback);
        }else{
            new HttpsRequest().doPostAsyn(url,param,headers,callback);
        }
    }


}
