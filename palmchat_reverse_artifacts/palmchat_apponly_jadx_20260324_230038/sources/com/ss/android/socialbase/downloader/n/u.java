package com.ss.android.socialbase.downloader.n;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.jk.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private static JSONObject b;
    private static JSONObject fx;
    private static boolean iz;
    private static Boolean pn;
    private static u x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f10621a;
    private final Boolean jk;
    private final JSONObject n;
    private int t;
    private static final n<Integer, u> u = new n<>(16, 16);
    private static final u nr = new u(null);

    static {
        u();
    }

    private u(JSONObject jSONObject) {
        Boolean bool;
        this.n = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || iz("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(MapController.DEFAULT_LAYER_TAG) && !iz(MapController.DEFAULT_LAYER_TAG)) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(MapController.DEFAULT_LAYER_TAG, 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.f10621a = jSONObject2;
        this.jk = bool;
    }

    @NonNull
    public static u fx() {
        return nr;
    }

    public static boolean iz(String str) {
        JSONObject jSONObject = fx;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    @NonNull
    public static JSONObject nr() {
        return fx.bf();
    }

    public static void u() {
        Boolean boolValueOf;
        JSONObject jSONObjectBf = fx.bf();
        iz = jSONObjectBf.optInt("disable_task_setting", 0) == 1;
        fx = jSONObjectBf.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectBf.optJSONObject("bugfix");
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has(MapController.DEFAULT_LAYER_TAG)) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(MapController.DEFAULT_LAYER_TAG, 0) == 1);
        }
        b = jSONObjectOptJSONObject;
        pn = boolValueOf;
    }

    public JSONObject b(String str) {
        JSONObject jSONObject = this.n;
        return (jSONObject == null || !jSONObject.has(str) || iz(str)) ? nr().optJSONObject(str) : this.n.optJSONObject(str);
    }

    public JSONArray pn(String str) {
        JSONObject jSONObject = this.n;
        return (jSONObject == null || !jSONObject.has(str) || iz(str)) ? nr().optJSONArray(str) : this.n.optJSONArray(str);
    }

    public String fx(String str) {
        return u(str, "");
    }

    public boolean nr(String str, boolean z) {
        if (this.f10621a != null && !iz(str)) {
            if (this.f10621a.has(str)) {
                return this.f10621a.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.jk;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = b;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return b.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = pn;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    private static u fx(int i) {
        DownloadInfo downloadInfo;
        if (iz) {
            return nr;
        }
        Context contextOa = fx.oa();
        if (contextOa != null && (downloadInfo = Downloader.getInstance(contextOa).getDownloadInfo(i)) != null) {
            return nr(downloadInfo);
        }
        return nr;
    }

    public static void u(String str, boolean z) {
        try {
            if (b == null) {
                b = new JSONObject();
            }
            b.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static u u(int i) {
        return u(i, (DownloadInfo) null);
    }

    public int nr(String str) {
        return u(str, 0);
    }

    public static void nr(int i) {
        u uVar = x;
        if (uVar != null && uVar.t == i) {
            x = null;
        }
        n<Integer, u> nVar = u;
        synchronized (nVar) {
            nVar.remove(Integer.valueOf(i));
        }
    }

    @NonNull
    public static u u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return nr;
        }
        return u(downloadInfo.getId(), downloadInfo);
    }

    private static u u(int i, DownloadInfo downloadInfo) {
        u uVarFx;
        u uVar = x;
        if (uVar != null && uVar.t == i) {
            return uVar;
        }
        n<Integer, u> nVar = u;
        synchronized (nVar) {
            uVarFx = nVar.get(Integer.valueOf(i));
        }
        if (uVarFx == null) {
            uVarFx = downloadInfo == null ? fx(i) : nr(downloadInfo);
            synchronized (nVar) {
                nVar.put(Integer.valueOf(i), uVarFx);
            }
        }
        uVarFx.t = i;
        x = uVarFx;
        return uVarFx;
    }

    private static u nr(DownloadInfo downloadInfo) {
        if (iz) {
            return nr;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new u(new JSONObject(downloadSettingString));
            }
        } catch (Throwable unused) {
        }
        return nr;
    }

    public boolean u(String str) {
        return nr(str, false);
    }

    public int u(String str, int i) {
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.has(str) && !iz(str)) {
            return this.n.optInt(str, i);
        }
        return nr().optInt(str, i);
    }

    public long u(String str, long j) {
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.has(str) && !iz(str)) {
            return this.n.optLong(str, j);
        }
        return nr().optLong(str, j);
    }

    public double u(String str, double d) {
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.has(str) && !iz(str)) {
            return this.n.optDouble(str, d);
        }
        return nr().optDouble(str, d);
    }

    public String u(String str, String str2) {
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.has(str) && !iz(str)) {
            return this.n.optString(str, str2);
        }
        return nr().optString(str, str2);
    }

    @NonNull
    public static u u(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != nr() && !iz) {
            u uVar = x;
            if (uVar != null && uVar.n == jSONObject) {
                return uVar;
            }
            n<Integer, u> nVar = u;
            synchronized (nVar) {
                for (u uVar2 : nVar.values()) {
                    if (uVar2.n == jSONObject) {
                        x = uVar2;
                        return uVar2;
                    }
                }
                u uVar3 = new u(jSONObject);
                x = uVar3;
                return uVar3;
            }
        }
        return nr;
    }

    public static void u(int i, JSONObject jSONObject) {
        u next;
        if (jSONObject == null || jSONObject == nr() || iz) {
            return;
        }
        n<Integer, u> nVar = u;
        synchronized (nVar) {
            u uVar = x;
            if (uVar != null && uVar.n == jSONObject) {
                uVar.t = i;
            } else {
                Iterator<u> it = nVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.n == jSONObject) {
                        next.t = i;
                        break;
                    }
                }
                if (next == null) {
                    uVar = new u(jSONObject);
                    uVar.t = i;
                } else {
                    uVar = next;
                }
                x = uVar;
            }
            u.put(Integer.valueOf(i), uVar);
        }
    }
}
