package com.bytedance.sdk.openadsdk.core.l.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface b {
    boolean fx();

    x nr();

    void nr(String str);

    boolean nr(DownloadModel downloadModel, DownloadInfo downloadInfo);

    AlertDialog u(Activity activity, boolean z, u uVar);

    String u(boolean z);

    JSONObject u();

    void u(int i, String str, Map<String, Object> map, pn pnVar);

    void u(Activity activity, String[] strArr, iz izVar);

    void u(n nVar, boolean z);

    void u(String str, byte[] bArr, String str2, pn pnVar);

    void u(WeakReference<Context> weakReference, boolean z, u uVar);

    void u(JSONObject jSONObject, String str);

    boolean u(Context context, String str);

    boolean u(DownloadModel downloadModel);

    boolean u(DownloadModel downloadModel, DownloadInfo downloadInfo);

    boolean u(String str);
}
