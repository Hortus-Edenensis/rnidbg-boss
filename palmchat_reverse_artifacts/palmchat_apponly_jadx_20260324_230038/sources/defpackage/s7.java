package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.adsdk.entity.LxEventReplace;
import com.zenmen.palmchat.ad.model.AdInfoBean;
import com.zenmen.palmchat.ad.model.GDTDownloadRespBean;
import com.zenmen.palmchat.ad.webview.AdWebActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.qd3;
import defpackage.rp2;
import java.util.List;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20676a;
    public String b;
    public long c;
    public String d;
    public int e;
    public int f;
    public int g;
    public String h;
    public qd3 i;
    public w5 j;
    public az4 k;
    public cj l;
    public x5 m;
    public AdInfoBean n;
    public boolean o;
    public String p;
    public String q;
    public gs1 r;
    public long s = 0;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s7.this.a();
        }
    }

    public static String G(String str, AdInfoBean adInfoBean) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        LogUtil.i("AdsBean", "replacePlaceholder adInfoBean = " + adInfoBean);
        LogUtil.i("AdsBean", "replacePlaceholder befor url = " + str);
        if (adInfoBean != null) {
            if (str.contains("__REQ_WIDTH__")) {
                str = str.replace("__REQ_WIDTH__", String.valueOf(adInfoBean.getWidth()));
            }
            if (str.contains("__REQ_HEIGHT__")) {
                str = str.replace("__REQ_HEIGHT__", String.valueOf(adInfoBean.getHeight()));
            }
            if (str.contains("__WIDTH__")) {
                str = str.replace("__WIDTH__", String.valueOf(adInfoBean.getWidth()));
            }
            if (str.contains("__HEIGHT__")) {
                str = str.replace("__HEIGHT__", String.valueOf(adInfoBean.getHeight()));
            }
            if (str.contains(LxEventReplace.__DOWN_X__)) {
                str = str.replace(LxEventReplace.__DOWN_X__, String.valueOf(adInfoBean.getClickX()));
            }
            if (str.contains(LxEventReplace.__DOWN_Y__)) {
                str = str.replace(LxEventReplace.__DOWN_Y__, String.valueOf(adInfoBean.getClickY()));
            }
            if (str.contains(LxEventReplace.__UP_X__)) {
                str = str.replace(LxEventReplace.__UP_X__, String.valueOf(adInfoBean.getClickX()));
            }
            if (str.contains(LxEventReplace.__UP_Y__)) {
                str = str.replace(LxEventReplace.__UP_Y__, String.valueOf(adInfoBean.getClickY()));
            }
            if (str.contains(LxEventReplace.__VIDEO_TIME__)) {
                str = str.replace(LxEventReplace.__VIDEO_TIME__, String.valueOf(adInfoBean.getVideoTime()));
            }
            if (str.contains("__PLAY_TIME__")) {
                str = str.replace("__PLAY_TIME__", String.valueOf(adInfoBean.getPlayTime()));
            }
            if (str.contains("__PHONE_PPI__")) {
                str = str.replace("__PHONE_PPI__", String.valueOf(adInfoBean.getPhonePPI()));
            }
            if (str.contains(LxEventReplace.__BEGIN_TIME__)) {
                str = str.replace(LxEventReplace.__BEGIN_TIME__, String.valueOf(adInfoBean.getBeginTime()));
            }
            if (str.contains(LxEventReplace.__END_TIME__)) {
                str = str.replace(LxEventReplace.__END_TIME__, String.valueOf(adInfoBean.getEndTime()));
            }
            if (str.contains("__PLAY_FIRST_FRAME__")) {
                str = str.replace("__PLAY_FIRST_FRAME__", String.valueOf(adInfoBean.getPlayFirstFrame()));
            }
            if (str.contains("__PLAY_LAST_FRAME__")) {
                str = str.replace("__PLAY_LAST_FRAME__", String.valueOf(adInfoBean.getPlayLastFrame()));
            }
            if (str.contains("__SCENE__")) {
                str = str.replace("__SCENE__", String.valueOf(adInfoBean.getScene()));
            }
            if (str.contains("__TYPE__")) {
                str = str.replace("__TYPE__", String.valueOf(adInfoBean.getType()));
            }
            if (str.contains("__BEHAVIOR__")) {
                str = str.replace("__BEHAVIOR__", String.valueOf(adInfoBean.getBehavior()));
            }
            if (str.contains("__STATUS__")) {
                str = str.replace("__STATUS__", String.valueOf(adInfoBean.getStatus()));
            }
        }
        LogUtil.i("AdsBean", "replacePlaceholder newUrl  = " + str);
        return str;
    }

    public boolean A() {
        return n() != null && n().h() == 3;
    }

    public boolean B() {
        qd3 qd3Var = this.i;
        return qd3Var != null && qd3Var.f() > 0;
    }

    public boolean C() {
        qd3 qd3Var;
        return (d() != 201 || (qd3Var = this.i) == null || TextUtils.isEmpty(qd3Var.g())) ? false : true;
    }

    public boolean D() {
        qd3.a aVarJ;
        return (n() == null || (aVarJ = n().j()) == null || TextUtils.isEmpty(aVarJ.a())) ? false : true;
    }

    public boolean E() {
        return z() || x();
    }

    public String F(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (A() && str.contains("__CLICK_ID__")) {
            LogUtil.d("AdsBean", "replaceClickIdWithGDT before url = " + str);
            if (n() != null && n().d() != null && n().d().getData() != null) {
                GDTDownloadRespBean.GDTDataBean data = n().d().getData();
                if (!TextUtils.isEmpty(data.getClickid())) {
                    str = str.replace("__CLICK_ID__", data.getClickid());
                }
            } else if (i() != null && i().d() != null && i().d().getData() != null) {
                GDTDownloadRespBean.GDTDataBean data2 = i().d().getData();
                if (!TextUtils.isEmpty(data2.getClickid())) {
                    str = str.replace("__CLICK_ID__", data2.getClickid());
                }
            }
        }
        LogUtil.d("AdsBean", "replaceClickIdWithGDT  newUrl = " + str);
        return str;
    }

    public void H() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportBsClick= ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.l) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void I() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportBtnClick ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.h) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void J() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportBtnDownloadStart");
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.i) == null) {
            return;
        }
        for (String str : list) {
            V(str, A() ? F(str) : str);
        }
    }

    public void K() {
        if (!B() || g()) {
            a();
            return;
        }
        int iRandom = (int) (Math.random() * 100.0d);
        LogUtil.d("AdsBean", "reportClick delay = " + iRandom);
        R();
        new Handler().postDelayed(new a(), (long) iRandom);
    }

    public void L() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportDeepClick ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.r) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void M() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportDeeplinkError ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.n) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void N() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportDeeplinkInstall,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.m) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void O() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportDeeplinkSuccess5s,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.o) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void P() {
        List<String> list;
        LogUtil.e("AdsBean", "report--->reportDownloadStart ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.d) == null) {
            return;
        }
        for (String str : list) {
            String strF = A() ? F(str) : str;
            LogUtil.d("AdsBean", "report--->reportDownloadStart=" + strF);
            V(str, strF);
        }
    }

    public void Q() {
        List<String> list;
        if (!g()) {
            LogUtil.d("AdsBean", "report--->reportInView, pvid = " + p() + ", md5 = " + m());
            az4 az4Var = this.k;
            if (az4Var != null && (list = az4Var.b) != null) {
                for (String str : list) {
                    V(str, str);
                }
            }
        }
        a0(true);
    }

    public void R() {
        List<String> list;
        if (!f()) {
            LogUtil.d("AdsBean", "report--->ReportPercentinView, pvid = " + p() + ", md5 = " + m());
            az4 az4Var = this.k;
            if (az4Var != null && (list = az4Var.s) != null) {
                for (String str : list) {
                    V(str, str);
                }
            }
        }
        Z(true);
    }

    public void S(boolean z) {
        List<String> list;
        List<String> list2;
        List<String> list3;
        LogUtil.d("AdsBean", "report--->reportPlayBegin ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var != null && (list3 = az4Var.t) != null) {
            for (String str : list3) {
                V(str, G(str, e()));
            }
        }
        if (z) {
            LogUtil.d("AdsBean", "report--->reportPlayBegin autoStart ,pvid=" + p());
            az4 az4Var2 = this.k;
            if (az4Var2 == null || (list2 = az4Var2.p) == null) {
                return;
            }
            for (String str2 : list2) {
                V(str2, G(str2, e()));
            }
            return;
        }
        LogUtil.d("AdsBean", "report--->reportPlayBegin handStart ,pvid=" + p());
        az4 az4Var3 = this.k;
        if (az4Var3 == null || (list = az4Var3.q) == null) {
            return;
        }
        for (String str3 : list) {
            V(str3, G(str3, e()));
        }
    }

    public void T() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportPlayEnd ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.v) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void U() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportPlayQuit ,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.u) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public final void V(String str, String str2) {
        kw4.f(str, str2, null);
    }

    public void W(int i) {
        this.g = i;
    }

    public void X(x5 x5Var) {
        this.m = x5Var;
    }

    public void Y(AdInfoBean adInfoBean) {
        this.n = adInfoBean;
    }

    public void Z(boolean z) {
        this.u = z;
    }

    public void a() {
        List<String> list;
        LogUtil.d("AdsBean", "report--->reportClick,pvid=" + p());
        az4 az4Var = this.k;
        if (az4Var == null || (list = az4Var.c) == null) {
            return;
        }
        for (String str : list) {
            V(str, G(str, e()));
        }
    }

    public void a0(boolean z) {
        this.t = z;
    }

    public void b(Activity activity) {
        if (this.l != null && y()) {
            String strA = this.l.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            rp2.a aVar = new rp2.a();
            aVar.l(strA);
            aVar.g(-1);
            aVar.k(false);
            activity.startActivity(vj6.a(activity, aVar));
        }
    }

    public void b0(w5 w5Var) {
        this.j = w5Var;
    }

    public void c(Activity activity) {
        if (this.i != null && C()) {
            String strG = this.i.g();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            LogUtil.d("AdsBean", "executeRedirectClick  isLX15980Open = " + jo6.n());
            if (jo6.n()) {
                if (strG.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || strG.startsWith(BaseConstants.SCHEME_HTTPS)) {
                    Intent intent = new Intent(activity, (Class<?>) AdWebActivity.class);
                    intent.putExtra("web_url", strG);
                    activity.startActivity(intent);
                    return;
                }
                return;
            }
            rp2.a aVar = new rp2.a();
            aVar.l(strG);
            aVar.g(-1);
            aVar.k(false);
            aVar.i(h13.p);
            activity.startActivity(vj6.a(activity, aVar));
        }
    }

    public void c0(cj cjVar) {
        this.l = cjVar;
    }

    public int d() {
        return this.g;
    }

    public void d0(boolean z) {
        this.o = z;
    }

    public AdInfoBean e() {
        return this.n;
    }

    public void e0(long j) {
        this.c = j;
    }

    public boolean f() {
        return this.u;
    }

    public void f0(String str) {
        this.q = str;
    }

    public boolean g() {
        return this.t;
    }

    public void g0(gs1 gs1Var) {
        this.r = gs1Var;
    }

    public String h() {
        gs1 gs1Var = this.r;
        if (gs1Var != null) {
            return gs1Var.d;
        }
        return null;
    }

    public void h0(GDTDownloadRespBean gDTDownloadRespBean) {
        if (gDTDownloadRespBean != null) {
            if (n() != null) {
                n().o(gDTDownloadRespBean);
            }
            if (i() != null) {
                i().k(gDTDownloadRespBean);
            }
        }
    }

    public cj i() {
        return this.l;
    }

    public void i0(String str) {
        this.h = str;
    }

    public String j() {
        return this.q;
    }

    public void j0(qd3 qd3Var) {
        this.i = qd3Var;
    }

    public gs1 k() {
        return this.r;
    }

    public void k0(String str) {
        this.b = str;
    }

    public int l() {
        int iF;
        qd3 qd3Var = this.i;
        if (qd3Var == null || (iF = qd3Var.f()) <= 0) {
            return 0;
        }
        LogUtil.d("AdsBean", "inviewPercent = " + iF);
        return iF;
    }

    public void l0(String str) {
        this.p = str;
    }

    public String m() {
        return this.h;
    }

    public void m0(az4 az4Var) {
        this.k = az4Var;
    }

    public qd3 n() {
        return this.i;
    }

    public void n0(String str) {
        this.f20676a = str;
    }

    public String o() {
        w5 w5Var = this.j;
        if (w5Var != null) {
            return w5Var.b;
        }
        return null;
    }

    public void o0(String str) {
        this.d = str;
    }

    public String p() {
        return this.p;
    }

    public void p0(int i) {
        this.f = i;
    }

    public String q() {
        return this.d;
    }

    public void q0(int i) {
        this.e = i;
    }

    public int r() {
        return this.f;
    }

    public qd3.a s() {
        if (n() == null || n().j() == null) {
            return null;
        }
        return n().j();
    }

    public String t() {
        return (n() == null || n().j() == null || TextUtils.isEmpty(n().j().c())) ? "" : n().j().c();
    }

    public void u(AdInfoBean adInfoBean) {
        Y(adInfoBean);
        if (n() != null) {
            n().k(adInfoBean);
        }
        if (i() != null) {
            i().f(adInfoBean);
        }
    }

    public boolean v() {
        return this.o;
    }

    public boolean w() {
        return j() != null && j().toLowerCase().startsWith("baidu");
    }

    public boolean x() {
        cj cjVar = this.l;
        return cjVar != null && cjVar.c() == 2;
    }

    public boolean y() {
        cj cjVar = this.l;
        return cjVar != null && cjVar.c() == 1;
    }

    public boolean z() {
        return d() == 202 && this.j != null;
    }
}
