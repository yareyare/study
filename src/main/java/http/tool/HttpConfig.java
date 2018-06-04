package http.tool;

/**
 * Created by ivy on 2017/12/7.
 */

import okhttp3.*;

public class HttpConfig {

    public final static Integer CONNECT_TIOMOUT = 5000; //传输超时

    public final static Integer SOCKET_TIMOUT = 5000;   //连接超时


    public static final okhttp3.MediaType MEDIA_TYPE_JSON = okhttp3.MediaType.parse( "application/json; charset=utf-8" );//
    public static final okhttp3.MediaType MEDIA_TYPE_MARKDOWN = okhttp3.MediaType.parse( "text/x-markdown; charset=utf-8" );
    public static final okhttp3.MediaType MEDIA_TYPE_PNG = okhttp3.MediaType.parse( "image/png" );//
    public static final okhttp3.MediaType MEDIA_TYPE_FORM = okhttp3.MediaType.parse( "application/x-www-form-urlencoded; charset=utf-8" );//
    public static final okhttp3.MediaType MEDIA_TYPE_FORM_DATA = okhttp3.MediaType.parse( "multipart/form-data; charset=utf-8" );//
    public static final okhttp3.MediaType MEDIA_TYPE_TEXT = okhttp3.MediaType.parse( "text/plan; charset=utf-8" );//

}
