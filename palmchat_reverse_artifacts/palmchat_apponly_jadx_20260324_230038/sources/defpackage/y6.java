package defpackage;

import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22128a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;

    public static y6 a(NestAdData nestAdData) {
        y6 y6Var = new y6();
        if (nestAdData != null) {
            y6Var.u(nestAdData.getAdCode());
            y6Var.q(nestAdData.getRequestId());
            y6Var.r(nestAdData.getAdScene());
            y6Var.p(nestAdData.getUseRequestId());
            y6Var.m(nestAdData.getAppId());
            y6Var.l(nestAdData.getAdCost());
            y6Var.n(nestAdData.getDspName());
            y6Var.s(nestAdData.getSdkFrom());
            y6Var.t(NestSdkVersion.INSTANCE.getVersion(c.b()));
        }
        return y6Var;
    }

    public int b() {
        return this.j;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.k;
    }

    public String g() {
        return this.f22128a;
    }

    public int h() {
        return this.f;
    }

    public String i() {
        return this.c;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.g;
    }

    public void l(int i) {
        this.j = i;
    }

    public void m(String str) {
        this.d = str;
    }

    public void n(String str) {
        this.i = str;
    }

    public void o(String str) {
        this.h = str;
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.f22128a = str;
    }

    public void r(int i) {
        this.f = i;
    }

    public void s(String str) {
        this.c = str;
    }

    public void t(String str) {
        this.b = str;
    }

    public void u(String str) {
        this.e = str;
    }

    public void v(String str) {
        this.g = str;
    }
}
