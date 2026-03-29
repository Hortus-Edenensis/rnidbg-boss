package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz implements com.ss.android.socialbase.downloader.network.n {
    @Override // com.ss.android.socialbase.downloader.network.n
    public com.ss.android.socialbase.downloader.network.x u(String str, List<com.ss.android.socialbase.downloader.model.fx> list) throws IOException {
        OkHttpClient okHttpClientBg = com.ss.android.socialbase.downloader.downloader.fx.bg();
        if (okHttpClientBg == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.fx fxVar : list) {
                builderHead.addHeader(fxVar.u(), com.ss.android.socialbase.downloader.jk.iz.x(fxVar.nr()));
            }
        }
        final Call callNewCall = okHttpClientBg.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.jk.u.u(2097152)) {
            responseExecute.close();
        }
        return new com.ss.android.socialbase.downloader.network.x() { // from class: com.ss.android.socialbase.downloader.impls.iz.1
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

            @Override // com.ss.android.socialbase.downloader.network.x
            public String u(String str2) {
                return responseExecute.header(str2);
            }
        };
    }
}
