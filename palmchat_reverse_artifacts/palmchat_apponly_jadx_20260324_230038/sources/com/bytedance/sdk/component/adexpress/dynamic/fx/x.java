package com.bytedance.sdk.component.adexpress.dynamic.fx;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.adexpress.dynamic.b.t;
import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.openalliance.ad.constant.dc;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    public JSONObject b;
    public String fx;
    private pn iz;
    public String nr;
    private iz pn;
    public int u;
    private String x;

    public x(pn pnVar) {
        this.iz = pnVar;
        this.u = pnVar.u();
        this.nr = pnVar.nr();
        this.fx = pnVar.fx();
        this.b = pnVar.pn().za();
        this.x = pnVar.b();
        if (com.bytedance.sdk.component.adexpress.b.nr() == 1) {
            this.pn = pnVar.x();
        } else {
            this.pn = pnVar.pn();
        }
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            this.pn = pnVar.pn();
        }
    }

    private boolean sf() {
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.nr) && this.nr.contains("adx:")) || t.nr();
    }

    private boolean ua() {
        return (com.bytedance.sdk.component.adexpress.b.u() && (this.iz.getType().contains("logo-union") || this.iz.getType().contains("logounion") || this.iz.getType().contains("logoad"))) || "logo-union".equals(this.iz.getType()) || "logounion".equals(this.iz.getType()) || "logoad".equals(this.iz.getType());
    }

    public int a() {
        int iN = n();
        if (iN == 4) {
            return 17;
        }
        return iN == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String ay() {
        return this.pn.hs();
    }

    public int b() {
        return (int) this.pn.my();
    }

    public int bc() {
        return this.pn.ge();
    }

    public int bf() {
        return this.pn.pn();
    }

    public int bg() {
        return this.pn.iq();
    }

    public boolean bq() {
        return this.pn.ic();
    }

    public boolean c() {
        return this.pn.oa();
    }

    public int cj() {
        return this.pn.fn();
    }

    public int d() {
        return u(this.pn.q());
    }

    public boolean dc() {
        return this.pn.qf();
    }

    public String dw() {
        return this.pn.qq();
    }

    public boolean eh() {
        return this.pn.mv();
    }

    public int f() {
        return this.pn.te();
    }

    public int fx() {
        return (int) this.pn.k();
    }

    public int gc() {
        return this.pn.bf();
    }

    public int ge() {
        return this.pn.ex();
    }

    public int gi() {
        String strJp = this.pn.jp();
        if ("skip-with-time-skip-btn".equals(this.iz.getType()) || dc.F.equals(this.iz.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.iz.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.iz.getType()) && !"skip-with-time".equals(this.iz.getType())) {
            if (this.u == 10 && TextUtils.equals(this.pn.y(), "click")) {
                return 5;
            }
            if (ua() && sf()) {
                return 0;
            }
            if (ua()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.iz.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strJp) && !strJp.equals("none")) {
                if (strJp.equals("video") || (this.iz.u() == 7 && TextUtils.equals(strJp, PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL))) {
                    return (com.bytedance.sdk.component.adexpress.b.u() && this.iz.pn() != null && this.iz.pn().ec()) ? 11 : 4;
                }
                if (strJp.equals(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL)) {
                    return 1;
                }
                return (strJp.equals(ClickAreaSource.CREATIVE) || "slide".equals(this.pn.y())) ? 2 : 0;
            }
        }
        return 0;
    }

    public double h() {
        return this.pn.n();
    }

    public String iz() {
        return this.u == 0 ? !TextUtils.isEmpty(this.nr) ? this.nr : this.b.optString(com.bytedance.sdk.component.adexpress.b.n.b(com.bytedance.sdk.component.adexpress.b.getContext())) : "";
    }

    public int ja() {
        return this.pn.nr();
    }

    public String jk() {
        int i = this.u;
        return (i == 2 || i == 13) ? this.nr : "";
    }

    public boolean jp() {
        return this.pn.rv();
    }

    public int ju() {
        return this.pn.dj();
    }

    public String jw() {
        return this.pn.kj();
    }

    public float k() {
        return this.pn.t();
    }

    public String kj() {
        return this.pn.jn();
    }

    public double kw() {
        return this.pn.xg();
    }

    public String l() {
        return this.x;
    }

    public boolean lf() {
        return this.pn.ja();
    }

    public String m() {
        return this.pn.y();
    }

    public boolean mh() {
        return this.pn.ki();
    }

    public int mk() {
        return this.pn.wq();
    }

    public double mv() {
        if (this.u == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.b.u() ? (int) r0 : Double.parseDouble(this.nr);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public int my() {
        return u(this.pn.z());
    }

    public int n() {
        String strDw = this.pn.dw();
        if ("left".equals(strDw)) {
            return 17;
        }
        if ("center".equals(strDw)) {
            return 4;
        }
        return "right".equals(strDw) ? 3 : 2;
    }

    public String nb() {
        return this.pn.rh();
    }

    public int nr() {
        return (int) this.pn.o();
    }

    public float o() {
        return this.pn.l();
    }

    public boolean oa() {
        return this.pn.df();
    }

    public int ob() {
        return this.pn.tr();
    }

    public double p() {
        return this.pn.pb();
    }

    public int pb() {
        return this.pn.a();
    }

    public float pn() {
        return this.pn.sx();
    }

    public int q() {
        return this.pn.w();
    }

    public String qq() {
        return this.pn.jp();
    }

    public List<String> rg() {
        return this.pn.j();
    }

    public int rh() {
        return this.pn.fx();
    }

    public boolean rv() {
        return this.pn.qe();
    }

    public double s() {
        return this.pn.bg();
    }

    public int su() {
        return this.pn.sf();
    }

    public int sx() {
        return this.pn.je();
    }

    public String t() {
        int i = this.u;
        return (i == 1 || i == 29) ? this.nr : "";
    }

    public int tk() {
        return this.pn.pq();
    }

    public String tm() {
        return this.pn.i();
    }

    public int u() {
        return (int) this.pn.s();
    }

    public String uq() {
        return this.u == 29 ? this.fx : "";
    }

    public String v() {
        return this.pn.hm();
    }

    public int w() {
        return this.pn.x();
    }

    public int wi() {
        return this.pn.zq();
    }

    public int wq() {
        return this.pn.b();
    }

    public int x() {
        return u(this.pn.c());
    }

    public String xg() {
        return this.pn.jk();
    }

    public String xw() {
        return this.pn.m();
    }

    public int y() {
        return this.pn.ob();
    }

    public String yd() {
        return this.pn.h();
    }

    public long z() {
        return this.pn.cb();
    }

    public String za() {
        return this.pn.zn();
    }

    public boolean zx() {
        return this.pn.ki();
    }

    public static float[] nr(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public void u(float f) {
        this.pn.u(f);
    }

    public static int u(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return -16777216;
    }

    public boolean u(int i) {
        pn pnVar = this.iz;
        if (pnVar == null) {
            return false;
        }
        if (i == 1) {
            this.pn = pnVar.x();
        } else {
            this.pn = pnVar.pn();
        }
        return this.pn != null;
    }
}
