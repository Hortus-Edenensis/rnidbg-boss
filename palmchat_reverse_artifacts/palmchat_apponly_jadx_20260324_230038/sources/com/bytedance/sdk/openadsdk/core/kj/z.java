package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class z {
    private int b;
    private nr fx;
    private u nr;
    private boolean u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5326a;
        private String b;
        private String fx;
        private int iz;
        private int n;
        private int nr;
        private int pn;
        private int u;
        private int x;

        public u(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.nr = jSONObject.optInt("displayAreaAndroid");
            this.fx = jSONObject.optString("ugen_md5");
            this.b = jSONObject.optString("ugen_url");
            this.pn = jSONObject.optInt("need_backup_convert_area", 0);
            this.iz = jSONObject.optInt("min_height", 0);
            this.x = jSONObject.optInt("min_width", 0);
            this.n = jSONObject.optInt("min_ratio", 0);
            this.f5326a = jSONObject.optString("ugen_id");
            this.u = jSONObject.optInt("render_sequence", 2);
        }

        public String b() {
            return this.fx;
        }

        public int fx() {
            return this.nr;
        }

        public boolean iz() {
            return this.pn == 1;
        }

        public String nr() {
            return this.f5326a;
        }

        public String pn() {
            return this.b;
        }

        public int u() {
            return this.u;
        }

        public boolean x() {
            return !TextUtils.isEmpty(this.b);
        }

        public boolean u(int i, int i2) {
            int iB = com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), i);
            int iB2 = com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), i2);
            int i3 = this.x;
            if (i3 != 0 && iB < i3) {
                return false;
            }
            int i4 = this.iz;
            if (i4 == 0 || iB2 >= i4) {
                return iB == 0 || iB2 == 0 || ((float) iB2) / ((float) iB) >= ((float) this.n);
            }
            return false;
        }
    }

    public z(JSONObject jSONObject) {
        this.u = false;
        if (jSONObject == null) {
            return;
        }
        this.u = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (jSONObjectOptJSONObject != null) {
            this.nr = new u(jSONObjectOptJSONObject.optJSONObject("components"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("easy_playable");
        if (jSONObjectOptJSONObject2 != null) {
            this.fx = new nr(jSONObjectOptJSONObject2.optJSONObject("components"));
        }
        this.b = jSONObject.optInt("style_category");
    }

    public static int b(bc bcVar) {
        if (bcVar == null) {
            return 0;
        }
        return bcVar.m49if().b;
    }

    public static String fx(bc bcVar) {
        z zVarM49if;
        u uVar;
        if (bcVar == null || (zVarM49if = bcVar.m49if()) == null || (uVar = zVarM49if.nr) == null) {
            return null;
        }
        return uVar.nr();
    }

    public static u iz(bc bcVar) {
        z zVarM49if;
        if (bcVar == null || (zVarM49if = bcVar.m49if()) == null) {
            return null;
        }
        return zVarM49if.nr;
    }

    public static boolean nr(bc bcVar) {
        z zVarM49if;
        nr nrVar;
        return (bcVar == null || (zVarM49if = bcVar.m49if()) == null || !zVarM49if.u || (nrVar = zVarM49if.fx) == null || !nrVar.u()) ? false : true;
    }

    public static nr pn(bc bcVar) {
        z zVarM49if;
        if (bcVar == null || (zVarM49if = bcVar.m49if()) == null) {
            return null;
        }
        return zVarM49if.fx;
    }

    public static boolean u(bc bcVar) {
        z zVarM49if;
        u uVar;
        return (bcVar == null || (zVarM49if = bcVar.m49if()) == null || (uVar = zVarM49if.nr) == null || !uVar.x()) ? false : true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        u nr;
        u u;

        /* JADX INFO: compiled from: SearchBox */
        public static class u {
            int nr;
            String u;

            public u(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.u = jSONObject.optString("entry");
                this.nr = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean u() {
                return !TextUtils.isEmpty(this.u);
            }
        }

        public nr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.u = new u(jSONObject.optJSONObject("vertical"));
            this.nr = new u(jSONObject.optJSONObject("horizontal"));
        }

        public int nr() {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.nr;
            }
            u uVar2 = this.nr;
            if (uVar2 != null) {
                return uVar2.nr;
            }
            return 0;
        }

        public boolean u() {
            u uVar = this.nr;
            if (uVar != null && uVar.u()) {
                return true;
            }
            u uVar2 = this.u;
            return uVar2 != null && uVar2.u();
        }

        public String u(boolean z) {
            u uVar;
            if (z && (uVar = this.u) != null && uVar.u()) {
                return this.u.u;
            }
            u uVar2 = this.nr;
            if (uVar2 != null && uVar2.u()) {
                return this.nr.u;
            }
            u uVar3 = this.u;
            return (uVar3 == null || !uVar3.u()) ? "" : this.u.u;
        }
    }

    public static boolean u() {
        int i = com.bytedance.sdk.openadsdk.core.d.fx;
        return (i >= 6322 && i < 6400) || i >= 6406;
    }
}
