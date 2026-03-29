package com.bytedance.sdk.openadsdk.k;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.n;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private volatile String b;
    private String fx;
    private String nr;
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static fx u = new fx();
    }

    private String jk() {
        Map<String, Object> mapT = t();
        if (mapT == null) {
            return null;
        }
        Object obj = mapT.get("od");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private boolean l() {
        String strC = n.o().c();
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        strC.hashCode();
        switch (strC) {
        }
        return false;
    }

    private Map<String, Object> t() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx;
        if (d.fx >= 6408 && (bVarSx = n.o().sx()) != null) {
            return bVarSx.k();
        }
        return null;
    }

    public static fx u() {
        return u.u;
    }

    public boolean a() {
        return nr(b());
    }

    public String b() {
        Map<String, Object> mapT = t();
        if (mapT == null) {
            return null;
        }
        Object obj = mapT.get("blt");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public boolean fx() {
        if (!TextUtils.isEmpty(this.b)) {
            return !TextUtils.equals("0", this.b);
        }
        Map<String, Object> mapT = t();
        if (mapT != null) {
            Object obj = mapT.get("uip");
            if (obj instanceof String) {
                String str = (String) obj;
                this.b = str;
                return !TextUtils.equals("0", str);
            }
        }
        this.b = "1";
        return true;
    }

    public boolean iz() {
        return !TextUtils.equals(nr(), "0");
    }

    public boolean n() {
        Map<String, Object> mapT = t();
        if (mapT != null) {
            Object obj = mapT.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.fx = str;
                return !TextUtils.equals(str, "0");
            }
        }
        return true;
    }

    public String nr() {
        Map<String, Object> mapT;
        try {
            mapT = t();
        } catch (Exception unused) {
        }
        if (mapT == null) {
            fx(null);
            return null;
        }
        Object obj = mapT.get("motion_info");
        if (obj instanceof String) {
            if (TextUtils.equals("0", (String) obj)) {
                fx("0");
                return "0";
            }
            fx("1");
            return "1";
        }
        fx(null);
        return null;
    }

    public void pn() {
        if (l()) {
            String strJk = jk();
            if (TextUtils.equals(strJk, this.nr)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.live.nr.u().u("setOaidEnabled", u(strJk));
            this.nr = strJk;
        }
    }

    public boolean x() {
        if (l()) {
            return u(jk());
        }
        return true;
    }

    private fx() {
    }

    private boolean u(String str) {
        return !TextUtils.equals(str, "0");
    }

    private void fx(String str) {
        if (!TextUtils.equals(this.u, str)) {
            com.bytedance.sdk.openadsdk.core.live.nr.u().u("setSensorEnable", !TextUtils.equals(str, "0"));
        }
        this.u = str;
    }

    private boolean nr(String str) {
        return !TextUtils.equals(str, "0");
    }
}
