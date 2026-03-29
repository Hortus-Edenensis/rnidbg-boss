package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x implements IDownloadHttpService {
    private final com.ss.android.socialbase.downloader.jk.n<String, OkHttpClient> u = new com.ss.android.socialbase.downloader.jk.n<>(4, 8);

    private OkHttpClient u(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.u) {
                    OkHttpClient okHttpClient = this.u.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderDw = com.ss.android.socialbase.downloader.downloader.fx.dw();
                    builderDw.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.x.2
                    });
                    OkHttpClient okHttpClientBuild = builderDw.build();
                    synchronized (this.u) {
                        this.u.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable unused) {
        }
        return com.ss.android.socialbase.downloader.downloader.fx.bg();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.a downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.fx> list) throws IOException {
        String strNr;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strNr = null;
        } else {
            strNr = null;
            for (com.ss.android.socialbase.downloader.model.fx fxVar : list) {
                String strU = fxVar.u();
                if (strNr == null && "ss_d_request_host_ip_114".equals(strU)) {
                    strNr = fxVar.nr();
                } else {
                    builderUrl.addHeader(strU, com.ss.android.socialbase.downloader.jk.iz.x(fxVar.nr()));
                }
            }
        }
        OkHttpClient okHttpClientU = !TextUtils.isEmpty(strNr) ? u(str, strNr) : com.ss.android.socialbase.downloader.downloader.fx.bg();
        if (okHttpClientU == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientU.newCall(builderUrl.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        String strHeader = responseExecute.header("Content-Encoding");
        final InputStream gZIPInputStream = (strHeader == null || !Constants.CP_GZIP.equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.ss.android.socialbase.downloader.network.pn() { // from class: com.ss.android.socialbase.downloader.impls.x.1
            @Override // com.ss.android.socialbase.downloader.network.a
            public void b() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call == null || call.getCanceled()) {
                        return;
                    }
                    callNewCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.x
            public void fx() {
                Call call = callNewCall;
                if (call == null || call.getCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.x
            public int nr() throws IOException {
                return responseExecute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.u
            public String pn() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.network.a
            public InputStream u() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.x
            public String u(String str2) {
                return responseExecute.header(str2);
            }
        };
    }
}
