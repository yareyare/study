package http;

import http.tool.HttpRequest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import tool.JsonConvert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivy on 2017/12/11.
 */
public class TestHttp {

    private static void doGet() {
        String result = null;
        try {
            result = new HttpRequest().doGet("http://zzn.juxinli.com/how_do_api/question/getRandomQuestion?userId=10dcfa83d262444f8311969b9e0f1d55", null);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doPost() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("questionId", "92ae1257618a4c1b876082b70de0e399");
        paramMap.put("index", "1");
        paramMap.put("length", "5");

        String result = null;
        try {
            result = new HttpRequest().doPost("http://zzn.juxinli.com/how_do_api/commont/getNewComont", paramMap, headers);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doPostJson() {
        //doPostJson
        String jsonParam = "{\"index\":1, \"pageSize\":10, \"userId\":\"10dcfa83d262444f8311969b9e0f1d55\"}";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        String result = null;
        try {
            result = new HttpRequest().doPostJson("http://zzn.juxinli.com:80/how_do_api/question/getAllQuestion", jsonParam, headers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    private static void doGetAsyn() {
        try {
            new Request().doGetAsyn("http://zzn.juxinli.com/how_do_api/question/getRandomQuestion?userId=10dcfa83d262444f8311969b9e0f1d55", null, null, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println(response.body().string());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doPostAsyn() {

        try {
            Map<String, String> headers = new HashMap<>();
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("questionId", "92ae1257618a4c1b876082b70de0e399");
            paramMap.put("index", "1");
            paramMap.put("length", "5");
            String result = null;

            new Request().doPostAsyn("http://zzn.juxinli.com/how_do_api/commont/getNewComont", paramMap, null, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println(response.body().string());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        doGet();
//        doGetAsyn();
//        doPost();
        doPostAsyn();

    }
}
