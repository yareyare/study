package http.tool;

import exception.BaseException;
import okhttp3.*;
import org.apache.log4j.Logger;
import tool.Code;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Created by ivy on 2017/12/7.
 */
public class HttpRequest implements BaseHttpRequest {

    private final Logger LOG = Logger.getLogger(HttpRequest.class);

    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(HttpConfig.CONNECT_TIOMOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(HttpConfig.SOCKET_TIMOUT, TimeUnit.MILLISECONDS)
            .readTimeout(HttpConfig.SOCKET_TIMOUT, TimeUnit.MILLISECONDS)
            .build();

    @Override
    public String doGet(String url, Map<String, String> param, Map<String, String> headers) throws Exception {
        Request.Builder builder = new Request.Builder();
        HttpUtil.addHeaders(builder, headers);
        Request request = builder.url(HttpUtil.contentParam(url, param))
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        ResponseBody body = response.body();
        return body.string();
    }

    public String doGet(String url, Map<String, String> param) throws Exception {
       return doGet(url,param,null);
    }

    @Override
    public String doPost(String url, Map<String, String> param, Map<String, String> headers) throws Exception {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder().url(url);
        HttpUtil.addHeaders(builder, headers);
        okhttp3.FormBody.Builder form_builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            form_builder.add(entry.getKey(), String.valueOf(entry.getValue()));
        }
        Request request = builder.post(form_builder.build()).build();
        Response response = null;
        response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }
    public String doPost(String url, Map<String, String> param) throws Exception {
        return doPost(url,param,null);
    }

    public String doPostJson(String url, String jsonParam, Map<String, String> headers) throws Exception {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder().url(url);
        HttpUtil.addHeaders(builder, headers);
        Request request = builder.post(RequestBody.create(HttpConfig.MEDIA_TYPE_JSON, jsonParam)).build();
        Response response = null;
        response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }


    @Override
    public void doGetAsyn(String url, Map<String, String> param, Map<String, String> headers, Callback callback) {
        Request.Builder builder = new Request.Builder();
        HttpUtil.addHeaders(builder, headers);
        Request request = builder.url(HttpUtil.contentParam(url, param))
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    @Override
    public void doPostAsyn(String url, Map<String, String> param, Map<String, String> headers, Callback callback) throws Exception {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder().url(url);
        HttpUtil.addHeaders(builder, headers);
        okhttp3.FormBody.Builder form_builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            form_builder.add(entry.getKey(), String.valueOf(entry.getValue()));
        }
        Request request = builder.post(form_builder.build()).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
