package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.nr.u.iz;
import com.bytedance.sdk.component.nr.u.k;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.mv;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.nr;
import com.bytedance.sdk.component.nr.u.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static l okHttpClient;

    public static String buildRangeHeader(long j, long j2) {
        String strFormRangeStrBySize = formRangeStrBySize(j, j2);
        if (strFormRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(strFormRangeStrBySize);
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        s.u uVar = new s.u();
        uVar.u(aVMDLRequest.urls[i]);
        uVar.u("GET", (k) null);
        uVar.u(toOkHttpHeaders(aVMDLRequest));
        nr nrVarU = getOkHttpClient().u(uVar.nr());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            my myVarNr = nrVarU.nr();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, myVarNr, nrVarU);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + "-" + j2;
        }
        if (j >= 0) {
            return j + "-";
        }
        if (j >= 0 || j2 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(j2));
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    private static synchronized l getOkHttpClient() {
        long j;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            if (config != null) {
                long j2 = config.mOpenTimeOut > 0 ? r4 * 1000 : 10000L;
                j = j2;
                j = config.mRWTimeOut > 0 ? r1 * 1000 : 10000L;
            } else {
                j = 10000;
            }
            l.u uVar = new l.u();
            uVar.u(Collections.singletonList(mv.HTTP_1_1));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            uVar.u(j, timeUnit).nr(j, timeUnit).fx(j, timeUnit);
            okHttpClient = uVar.u();
        }
        return okHttpClient;
    }

    private static iz toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        iz.u uVar = new iz.u();
        HashMap<String, String> map = aVMDLRequest.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                entry.getKey();
                entry.getValue();
                uVar.nr(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            uVar.nr(HttpHeaders.RANGE, strBuildRangeHeader);
        }
        uVar.nr(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        return uVar.u();
    }
}
