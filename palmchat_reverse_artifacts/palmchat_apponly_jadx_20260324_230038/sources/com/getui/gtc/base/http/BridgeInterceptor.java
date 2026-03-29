package com.getui.gtc.base.http;

import android.net.Network;
import android.util.Log;
import com.efs.sdk.base.Constants;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BridgeInterceptor implements Interceptor {
    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        boolean z;
        Request request = chain.request();
        Request.Builder builder = new Request.Builder(request);
        Network network = request.network();
        if (network != null) {
            Log.d("GTC", "gtc h use n");
            uRLConnectionOpenConnection = network.openConnection(request.url());
        } else {
            uRLConnectionOpenConnection = request.url().openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builder.addHeader("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builder.addHeader("Content-Length", Long.toString(jContentLength)).removeHeader("Transfer-Encoding");
            } else {
                builder.addHeader("Transfer-Encoding", HTTP.CHUNK_CODING).removeHeader("Content-Length");
            }
        }
        if (request.header("Host") == null) {
            builder.addHeader("Host", request.url().getHost());
        }
        if (request.header("Connection") == null) {
            builder.addHeader("Connection", HTTP.CONN_KEEP_ALIVE);
        }
        if (request.header(HttpHeaders.ACCEPT_ENCODING) == null && request.header(HttpHeaders.RANGE) == null) {
            builder.addHeader(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            z = true;
        } else {
            z = false;
        }
        Response responseProceed = ((RealInterceptorChain) chain).proceed(builder.build(), httpURLConnection);
        Response.Builder builderRequest = new Response.Builder(responseProceed).request(request);
        if (z && Constants.CP_GZIP.equalsIgnoreCase(responseProceed.header("Content-Encoding")) && responseProceed.body() != null) {
            builderRequest.body(ResponseBody.create(responseProceed.body().contentType(), -1L, new GZIPInputStream(responseProceed.body().byteStream()))).removeHeader("Content-Encoding").removeHeader("Content-Length");
        }
        return builderRequest.build();
    }
}
