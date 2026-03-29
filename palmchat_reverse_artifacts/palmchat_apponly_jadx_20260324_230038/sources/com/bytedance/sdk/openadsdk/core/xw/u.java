package com.bytedance.sdk.openadsdk.core.xw;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.rv;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.sx;
import com.kuaishou.weapon.p0.t;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.ad.view.AdView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final u u = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f5409a;
    private boolean n;
    private rv x;
    private String nr = "";
    private String fx = "";
    private String b = "";
    private String pn = "";
    private JSONArray iz = new JSONArray();

    private u() {
    }

    private Long b() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.pn = String.valueOf(jCurrentTimeMillis);
        return Long.valueOf(jCurrentTimeMillis);
    }

    private Long fx() {
        Long lValueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        this.fx = lValueOf.toString();
        return lValueOf;
    }

    private String nr() {
        String strNr = sx.nr();
        this.nr = strNr;
        return strNr;
    }

    public static u u() {
        return u;
    }

    private ActivityManager.MemoryInfo nr(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        this.b = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    public void u(Context context) {
        if (!dw.nr().sx()) {
            this.n = false;
            return;
        }
        if (this.n) {
            return;
        }
        try {
            nr();
            b();
            fx();
            nr(context);
            fx(context);
            this.x = kj.t();
            this.n = true;
        } catch (Exception unused) {
        }
    }

    private JSONArray fx(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap map = new HashMap();
            map.put(AdView.DOUYIN, "a");
            map.put(AdView.DOUYIN_LITE, "al");
            map.put("com.dragon.read", t.k);
            map.put("com.ss.android.article.news", "n");
            map.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", entry.getValue());
                    jSONObject.put("i", j);
                    if (TextUtils.equals((CharSequence) entry.getValue(), "a") || TextUtils.equals((CharSequence) entry.getValue(), "n")) {
                        jSONObject.put("u", packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.iz = jSONArray;
        } catch (Throwable unused2) {
        }
        return jSONArray;
    }

    public void u(rv rvVar) {
        this.x = rvVar;
    }

    public void u(int[] iArr) {
        this.f5409a = iArr;
    }

    public void u(JSONObject jSONObject) {
        if (dw.nr().sx()) {
            try {
                rv rvVar = this.x;
                if (rvVar != null) {
                    JSONObject jSONObjectFx = rvVar.fx();
                    jSONObjectFx.put("sl", 0);
                    jSONObject.put("u_t", jSONObjectFx);
                }
                jSONObject.put("boot_time_sec", this.pn);
                jSONObject.put(SharePluginInfo.ISSUE_MEMORY, this.b);
                jSONObject.put("disk", this.fx);
                jSONObject.put("client_tun", this.nr);
                jSONObject.put("pkg_info", this.iz);
                int[] iArr = this.f5409a;
                if (iArr != null) {
                    jSONObject.put("inode", Arrays.toString(iArr));
                }
            } catch (Exception unused) {
            }
        }
    }
}
