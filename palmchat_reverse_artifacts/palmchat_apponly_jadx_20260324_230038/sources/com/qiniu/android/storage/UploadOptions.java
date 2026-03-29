package com.qiniu.android.storage;

import android.os.Looper;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class UploadOptions {
    public final UpCancellationSignal cancellationSignal;
    public final boolean checkCrc;
    public final Map<String, String> metaDataParam;
    public final String mimeType;
    public final NetReadyHandler netReadyHandler;
    public final Map<String, String> params;
    public final UpProgressHandler progressHandler;

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal) {
        this(map, str, z, upProgressHandler, upCancellationSignal, null);
    }

    public static UploadOptions defaultOptions() {
        return new UploadOptions(null, null, false, null, null);
    }

    private static Map<String, String> filterMetaDataParam(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("x-qn-meta-") && entry.getValue() != null && !entry.getValue().equals("")) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    private static Map<String, String> filterParam(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("x:") && entry.getValue() != null && !entry.getValue().equals("")) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    private static String mime(String str) {
        return (str == null || str.equals("")) ? "application/octet-stream" : str;
    }

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal, NetReadyHandler netReadyHandler) {
        this(map, null, str, z, upProgressHandler, upCancellationSignal, netReadyHandler);
    }

    public UploadOptions(Map<String, String> map, Map<String, String> map2, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal, NetReadyHandler netReadyHandler) {
        final int i = 6;
        try {
            String str2 = map.get("netCheckTime");
            if (str2 != null) {
                i = Integer.parseInt(str2);
            }
        } catch (Exception unused) {
        }
        this.params = filterParam(map);
        this.metaDataParam = filterMetaDataParam(map2);
        this.mimeType = mime(str);
        this.checkCrc = z;
        this.progressHandler = upProgressHandler == null ? new UpProgressHandler() { // from class: com.qiniu.android.storage.UploadOptions.1
            @Override // com.qiniu.android.storage.UpProgressHandler
            public void progress(String str3, double d) {
                LogUtil.d("" + d);
            }
        } : upProgressHandler;
        this.cancellationSignal = upCancellationSignal == null ? new UpCancellationSignal() { // from class: com.qiniu.android.storage.UploadOptions.2
            @Override // com.qiniu.android.http.CancellationHandler
            public boolean isCancelled() {
                return false;
            }
        } : upCancellationSignal;
        this.netReadyHandler = netReadyHandler == null ? new NetReadyHandler() { // from class: com.qiniu.android.storage.UploadOptions.3
            @Override // com.qiniu.android.storage.NetReadyHandler
            public void waitReady() {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    return;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (AndroidNetwork.isNetWorkReady()) {
                        return;
                    }
                }
            }
        } : netReadyHandler;
    }
}
