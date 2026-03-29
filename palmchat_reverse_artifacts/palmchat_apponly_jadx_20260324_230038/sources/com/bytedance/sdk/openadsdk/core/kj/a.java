package com.bytedance.sdk.openadsdk.core.kj;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.nr.b;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.be;
import com.ss.bytertc.engine.type.ErrorCode;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5295a;
    private final int[] b;
    private final String bg;
    private final String bq;
    private SparseArray<b.u> c;
    private final boolean d;
    private final String dw;
    private final int[] fx;
    private byte gi;
    private final float iz;
    private final long jk;
    private final int k;
    private String kj;
    private final int l;
    private final int mv;
    private final float my;
    private final float n;
    private final int[] nr;
    private final int o;
    private final float pn;
    private int q;
    private int qq;
    private final float s;
    private final String sx;
    private final int t;
    private final int[] u;
    private final float x;
    private int z;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String bg;
        private String bq;
        private String c;
        private String dw;
        float fx;
        private int[] jk;
        private String kj;
        private int[] l;
        private int[] mv;
        int nr;
        private SparseArray<b.u> o;
        private int sx;
        private int[] t;
        float u;
        private long b = -1;
        private long pn = -1;
        private float iz = -1.0f;
        private float x = -1.0f;
        private float n = -1.0f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f5296a = -1.0f;
        private int s = -1;
        private int k = -1;
        private int my = ErrorCode.ERROR_CODE_LICENSE_NOT_MATCH_WITH_CACHE;
        private int q = -1;
        private int qq = -1;
        private int z = -1;
        private boolean gi = false;
        private byte d = 0;

        public u b(float f) {
            this.x = f;
            return this;
        }

        public u fx(float f) {
            this.iz = f;
            return this;
        }

        public u iz(float f) {
            this.f5296a = f;
            return this;
        }

        public u n(int i) {
            this.z = i;
            return this;
        }

        public u nr(float f) {
            this.fx = f;
            return this;
        }

        public u pn(float f) {
            this.n = f;
            return this;
        }

        public u u(byte b) {
            this.d = b;
            return this;
        }

        public u x(int i) {
            this.qq = i;
            return this;
        }

        public u b(int[] iArr) {
            this.mv = iArr;
            return this;
        }

        public u fx(int[] iArr) {
            this.l = iArr;
            return this;
        }

        public u iz(int i) {
            this.q = i;
            return this;
        }

        public u nr(int i) {
            this.sx = i;
            return this;
        }

        public u pn(int i) {
            this.my = i;
            return this;
        }

        public u u(float f) {
            this.u = f;
            return this;
        }

        public u b(int i) {
            this.k = i;
            return this;
        }

        public u fx(int i) {
            this.s = i;
            return this;
        }

        public u nr(long j) {
            this.pn = j;
            return this;
        }

        public u pn(String str) {
            this.kj = str;
            return this;
        }

        public u u(int i) {
            this.nr = i;
            return this;
        }

        public u b(String str) {
            this.c = str;
            return this;
        }

        public u fx(String str) {
            this.dw = str;
            return this;
        }

        public u nr(int[] iArr) {
            this.t = iArr;
            return this;
        }

        public u u(SparseArray<b.u> sparseArray) {
            this.o = sparseArray;
            return this;
        }

        public u nr(String str) {
            this.bq = str;
            return this;
        }

        public u u(long j) {
            this.b = j;
            return this;
        }

        public u u(int[] iArr) {
            this.jk = iArr;
            return this;
        }

        public u u(String str) {
            this.bg = str;
            return this;
        }

        public u u(boolean z) {
            this.gi = z;
            return this;
        }

        public a u() {
            return new a(this);
        }
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.u;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.u[1]));
            }
            int[] iArr2 = this.nr;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.nr[1]));
            }
            int[] iArr3 = this.fx;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.fx[1]));
            }
            int[] iArr4 = this.b;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.b[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    b.u uVarValueAt = this.c.valueAt(i);
                    if (uVarValueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(uVarValueAt.fx)).putOpt("mr", Double.valueOf(uVarValueAt.nr)).putOpt("phase", Integer.valueOf(uVarValueAt.u)).putOpt("ts", Long.valueOf(uVarValueAt.b));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.o)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.pn)).putOpt("down_y", Float.toString(this.iz)).putOpt("up_x", Float.toString(this.x)).putOpt("up_y", Float.toString(this.n)).putOpt("down_time", Long.valueOf(this.f5295a)).putOpt("up_time", Long.valueOf(this.jk)).putOpt("toolType", Integer.valueOf(this.t)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt(az.at, Integer.valueOf(this.mv)).putOpt(be.ar, Float.valueOf(this.s)).putOpt("densityDpi", Integer.valueOf(this.k)).putOpt("scaleDensity", Float.valueOf(this.my)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.sx).putOpt("areaType", this.bg).putOpt("rectInfo", this.dw).putOpt("click_area_id", this.bq);
            int i2 = this.q;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.qq;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
            int i4 = this.z;
            if (i4 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i4)).putOpt("dpa_pid", this.kj);
            }
            if (this.d) {
                jSONObject.put("referer", "directDownload");
            }
            jSONObject.putOpt("convert_type", Byte.valueOf(this.gi));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private a(u uVar) {
        this.qq = -1;
        this.z = -1;
        this.u = uVar.t;
        this.nr = uVar.l;
        this.b = uVar.mv;
        this.fx = uVar.jk;
        this.pn = uVar.f5296a;
        this.iz = uVar.n;
        this.x = uVar.x;
        this.n = uVar.iz;
        this.f5295a = uVar.pn;
        this.jk = uVar.b;
        this.t = uVar.s;
        this.l = uVar.k;
        this.mv = uVar.my;
        this.s = uVar.u;
        this.sx = uVar.bg;
        this.bg = uVar.bq;
        this.dw = uVar.c;
        this.bq = uVar.dw;
        this.k = uVar.nr;
        this.my = uVar.fx;
        this.o = uVar.sx;
        this.c = uVar.o;
        this.q = uVar.q;
        this.qq = uVar.qq;
        this.kj = uVar.kj;
        this.z = uVar.z;
        this.d = uVar.gi;
        this.gi = uVar.d;
    }
}
