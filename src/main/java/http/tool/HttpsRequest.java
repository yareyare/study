package http.tool;

import okhttp3.*;
import okio.Buffer;
import org.apache.log4j.Logger;
import tool.JsonConvert;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ivy on 2017/12/7.
 */
public final class HttpsRequest implements BaseHttpRequest {

    private final Logger LOG = Logger.getLogger(HttpsRequest.class);

    private OkHttpClient client = null;

    public HttpsRequest() {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            client = new OkHttpClient.Builder()
                    .connectTimeout(HttpConfig.CONNECT_TIOMOUT, TimeUnit.SECONDS)
                    .writeTimeout(HttpConfig.SOCKET_TIMOUT, TimeUnit.SECONDS)
                    .readTimeout(HttpConfig.SOCKET_TIMOUT, TimeUnit.SECONDS)
                    .sslSocketFactory(sslContext.getSocketFactory(), new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }).hostnameVerifier(new TrustAllHostNameVerifier()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HttpsRequest(String certificate) {
        SSLContext sslContext = null;
        if (certificate != null && !certificate.equals("")) {
            certificate = certificate.replace("\\\\n", "\n");
            sslContext = sslContextForTrustedCertificates(trustedCertificatesInputStream(certificate));
        } else {
            try {
                sslContext = SSLContext.getInstance("SSL");
                sslContext.init(new KeyManager[0], new TrustManager[]{new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }}, new SecureRandom());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .sslSocketFactory(sslContext.getSocketFactory()).hostnameVerifier(new TrustAllHostNameVerifier()).build();

    }


    @Override
    public String doGet(String url, Map<String, String> param, Map<String, String> headers) {
        return null;
    }

    public String doGet(String url, Map<String, String> param, Map<String, String> headers, String certificate) {
        if (certificate == null || "".equals(certificate)) {
            doGet(url, param, headers, certificate);
        } else {

        }
        return null;
    }

    @Override
    public String doPost(String url, Map<String, String> param, Map<String, String> headers) throws IOException {
        RequestBody formBody = new okhttp3.FormBody.Builder().add("param", JsonConvert.toJson(param)).build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = client.newCall(request).execute();
        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }
        return response.body().string();

    }

    @Override
    public void doGetAsyn(String url, Map<String, String> param, Map<String, String> headers, Callback callback) {

    }

    @Override
    public void doPostAsyn(String url, Map<String, String> param, Map<String, String> headers, Callback callback) {

    }


    private static class TrustAllHostNameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }


    // keytool -printcert -rfc -file sinowaycredit.cer > sinowaycredit.cer.txt
    // 将字符串形式的证书转成stream
    private InputStream trustedCertificatesInputStream(String sinowaycredit_cer) {
        System.out.println(sinowaycredit_cer);
        return new Buffer()
                // .writeUtf8(comodoRsaCertificationAuthority)
                // .writeUtf8(entrustRootCertificateAuthority)
                .writeUtf8(sinowaycredit_cer).inputStream();
    }

    // 组装sslfactory
    private SSLContext sslContextForTrustedCertificates(InputStream in) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(in);
            if (certificates.isEmpty()) {
                throw new IllegalArgumentException("expected non-empty set of trusted certificates");
            }

            // Put the certificates a key store.
            char[] password = "password".toCharArray(); // Any password will
            // work.
            KeyStore keyStore = newEmptyKeyStore(password);
            int index = 0;
            for (Certificate certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificate);
            }

            // Wrap it up in an SSL context.
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, password);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sslContext;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    private KeyStore newEmptyKeyStore(char[] password) throws GeneralSecurityException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream in = null; // By convention, 'null' creates an empty key
            // store.
            keyStore.load(in, password);
            return keyStore;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }


}
