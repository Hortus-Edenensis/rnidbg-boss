package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y56 extends mo4 {
    public String e;
    public String f;
    public String g;
    public String h;
    public String i = "0";
    public String j;
    public String k;

    public String g() {
        return this.j;
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.k;
    }

    public String k() {
        return this.i;
    }

    public void l(String str) {
        this.f = str;
    }

    public void m(String str) {
        this.j = str;
    }

    public void n(String str) {
        this.g = str;
    }

    public void o(String str) {
        this.h = str;
    }

    public void p(String str) {
        this.e = str;
    }

    public void q(String str) {
        this.k = str;
    }

    public void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i = str;
    }
}
