package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class yd {
    private static final String[] iz = {"channel", "package", "app_version"};
    private final mh fx;
    private final Context nr;
    private boolean u;
    private final SharedPreferences x;
    private final ArrayList<w> pn = new ArrayList<>(32);
    private int n = 0;

    @NonNull
    private JSONObject b = new JSONObject();

    public yd(Context context, mh mhVar) {
        this.nr = context;
        this.fx = mhVar;
        this.x = mhVar.pn();
        if (u.nr) {
            ec.u(context);
        }
    }

    @NonNull
    private JSONObject k() {
        return this.b;
    }

    public String a() {
        return k().optString("install_id", "");
    }

    public void b() {
        xg.iz().a();
    }

    public String fx() {
        String strOptString = this.u ? k().optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            iz();
            strOptString = this.u ? k().optString("app_version", null) : null;
        }
        return strOptString;
    }

    public boolean iz() {
        synchronized (this.pn) {
            if (this.pn.size() == 0) {
                this.pn.add(new cj(this.nr, this.fx));
                this.pn.add(new wi(this.nr));
                this.pn.add(new su(this.nr, this.fx));
                this.pn.add(new ay(this.nr));
                this.pn.add(new v(this.nr));
                this.pn.add(new eh(this.nr, this.fx));
                this.pn.add(new lf(this.nr));
                this.pn.add(new gc(this.nr, this.fx));
                this.pn.add(new mk(this.nr, this.fx));
                this.pn.add(new p());
                this.pn.add(new kw(this.fx));
                this.pn.add(new f(this.nr));
                this.pn.add(new za(this.nr));
                this.pn.add(new tm(this.nr, this.fx));
                this.pn.add(new xw(this.nr, this.fx));
                this.pn.add(new nb(this.nr, this.fx));
                this.pn.add(new tk(this.nr, this.fx));
            }
        }
        JSONObject jSONObjectK = k();
        JSONObject jSONObject = new JSONObject();
        gb.nr(jSONObject, jSONObjectK);
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (w wVar : this.pn) {
            if (!wVar.u || wVar.fx || u(wVar)) {
                try {
                    wVar.u = wVar.u(jSONObject);
                } catch (SecurityException e) {
                    if (!wVar.nr) {
                        i++;
                        ti.nr("loadHeader, " + this.n, e);
                        if (!wVar.u && this.n > 10) {
                            wVar.u = true;
                        }
                    }
                } catch (JSONException e2) {
                    ti.nr(e2);
                }
                if (!wVar.u && !wVar.nr) {
                    i2++;
                }
            }
            z &= wVar.u || wVar.nr;
        }
        if (z) {
            int length = iz.length;
            for (int i3 = 0; i3 < length; i3++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(r7[i3]));
            }
            String strOptString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    jSONObject.put("user_unique_id", strOptString);
                } catch (JSONException unused) {
                }
            }
        }
        this.b = jSONObject;
        this.u = z;
        if (ti.nr) {
            ti.u("loadHeader, " + this.u + ", " + this.n + ", " + this.b.toString(), null);
        } else {
            ti.b("loadHeader, " + this.u + ", " + this.n, null);
        }
        if (i > 0 && i == i2) {
            this.n++;
            if (l() != 0) {
                this.n += 10;
            }
        }
        if (this.u) {
            u.l().u(x(), a(), jk());
        }
        return this.u;
    }

    public String jk() {
        return k().optString("ssid", "");
    }

    public int l() {
        String strOptString = k().optString("device_id", "");
        k().optString("install_id", "");
        if (nr(strOptString)) {
            return this.x.getInt("version_code", 0) == k().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long mv() {
        return k().optLong("register_time", 0L);
    }

    public String n() {
        return k().optString("aid", "");
    }

    public int nr() {
        int iOptInt = this.u ? k().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            iz();
            iOptInt = this.u ? k().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public void pn() {
        try {
            new nb(this.nr, this.fx).u(this.b);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.u("od", "e:" + e.getMessage(), e);
        }
    }

    public String s() {
        return k().optString("ab_sdk_version", "");
    }

    public String t() {
        return k().optString("user_unique_id", "");
    }

    @Nullable
    public JSONObject u() {
        if (this.u) {
            return k();
        }
        return null;
    }

    public String x() {
        return k().optString("device_id", "");
    }

    @Nullable
    public <T> T u(String str, T t) {
        Object objOpt;
        JSONObject jSONObjectK = k();
        if (jSONObjectK == null || (objOpt = jSONObjectK.opt(str)) == null) {
            objOpt = null;
        }
        return objOpt == null ? t : (T) objOpt;
    }

    private synchronized void nr(JSONObject jSONObject) {
        if (jSONObject == null) {
            ti.nr("null abconfig", null);
            return;
        }
        String strOptString = k().optString("ab_version");
        if (!TextUtils.isEmpty(strOptString)) {
            String[] strArrSplit = strOptString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> itKeys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString(OapsKey.KEY_VERID));
                        } catch (JSONException e) {
                            ti.nr(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            nr("ab_version", u(hashSet));
        }
    }

    private boolean u(w wVar) {
        boolean z = !this.fx.sx() && wVar.b;
        if (ti.nr) {
            ti.u("needSyncFromSub " + wVar + " " + z, null);
        }
        return z;
    }

    public void u(JSONObject jSONObject) {
        this.fx.fx(jSONObject);
        nr(jSONObject);
    }

    private String u(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void u(HashMap<String, Object> map) {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = k().optJSONObject(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                ti.nr(e);
            }
        }
        if (nr(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObjectOptJSONObject)) {
            this.fx.nr(jSONObjectOptJSONObject);
        }
    }

    public static void u(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private boolean nr(String str, Object obj) {
        boolean z;
        Object objOpt = k().opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.b;
                    JSONObject jSONObject2 = new JSONObject();
                    gb.nr(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.b = jSONObject2;
                } catch (JSONException e) {
                    ti.nr(e);
                }
            }
            z = true;
        }
        ti.u("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z;
    }

    public static boolean u(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public boolean u(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (ti.nr) {
            ti.u("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zNr = nr(str);
        boolean zNr2 = nr(str2);
        try {
            boolean zNr3 = nr(str3);
            int i = this.x.getInt("version_code", 0);
            int iOptInt = k().optInt("version_code", 0);
            SharedPreferences.Editor editorEdit = this.x.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zNr) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                nr("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zNr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                u.u("tt_fetch_did_error", jSONObject2);
            }
            String strOptString = k().optString("device_id", "");
            if (zNr && nr("device_id", str)) {
                editorEdit.putString("device_id", str);
                z = true;
            } else {
                z = false;
            }
            String strOptString2 = k().optString("install_id", "");
            if (zNr2 && nr("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z = true;
            }
            String strOptString3 = k().optString("ssid", "");
            if (zNr3 && nr("ssid", str3)) {
                editorEdit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            u.l().u(z2, strOptString, str, strOptString2, str2, strOptString3, str3);
            editorEdit.apply();
        } catch (JSONException e) {
            ti.nr(e);
        }
        return zNr && zNr2;
    }

    public static boolean nr(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str) && !"Null".equalsIgnoreCase(str)) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                if (str.charAt(i) != '0') {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }
}
