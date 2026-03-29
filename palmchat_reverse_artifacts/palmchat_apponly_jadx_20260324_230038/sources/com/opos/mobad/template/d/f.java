package com.opos.mobad.template.d;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f {
    String A;
    String B;
    int D;
    int E;
    int G;
    int H;
    String I;
    String J;
    String K;
    e L;
    e M;
    String O;
    int P;
    String Q;
    View S;
    String c;
    String d;
    e i;
    e j;
    e k;
    String m;
    e n;
    e o;
    String p;
    String q;
    int r;
    int s;
    String t;
    com.opos.mobad.template.d v;
    a w;
    long x;
    long y;
    com.opos.mobad.template.e z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, String> f9415a = new HashMap();
    List<Pair<String, String>> b = new ArrayList();
    List<e> e = new ArrayList();
    List<e> f = new ArrayList();
    List<String> g = new ArrayList();
    boolean h = false;
    String l = "广告";
    boolean u = false;
    int C = 3000;
    int F = 0;
    int N = 0;
    com.opos.mobad.template.e.a R = com.opos.mobad.template.e.a.UNKNOWN;

    public b a() {
        List<e> list;
        e eVar = this.n;
        if ((eVar == null || TextUtils.isEmpty(eVar.f9414a)) && ((list = this.e) == null || list.size() <= 0)) {
            return null;
        }
        return new b(this);
    }

    public c b() {
        e eVar = this.o;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            return null;
        }
        return new c(this);
    }

    public d c() {
        return new d(this);
    }

    public f d(int i) {
        this.E = i;
        return this;
    }

    public f e(int i) {
        this.D = i;
        return this;
    }

    public f f(int i) {
        this.r = i;
        return this;
    }

    public f g(int i) {
        this.s = i;
        return this;
    }

    public f h(int i) {
        this.C = i;
        return this;
    }

    public f i(int i) {
        this.N = i;
        return this;
    }

    public f j(String str) {
        this.K = str;
        return this;
    }

    public f k(String str) {
        this.J = str;
        return this;
    }

    public f l(String str) {
        this.I = str;
        return this;
    }

    public String toString() {
        return "ShowDataBuilder{mExtParamMap=" + this.f9415a + ", mPairList=" + this.b + ", mDesc='" + this.c + "', mTitle='" + this.d + "', mImgList=" + this.e + ", mFloatLayerImgList=" + this.f + ", mLabelList=" + this.g + ", mShowLogo=" + this.h + ", mLogoUrl=" + this.i + ", mSurfaceLogoUrl=" + this.j + ", mDarkLogoUrl=" + this.k + ", mLogoTxt='" + this.l + "', mClickBnText='" + this.m + "', mIconUrl=" + this.n + ", mVideoUrl=" + this.o + ", mRewardTips='" + this.p + "', mRewardHints='" + this.q + "', mCloseBnStyle=" + this.r + ", mImgType=" + this.s + ", mAdSource='" + this.t + "', mShowFeedback=" + this.u + ", mSplashBottomTemplate=" + this.v + ", mAdAppData=" + this.w + ", mDuration=" + this.x + ", mCloseBtnTime=" + this.y + ", mSplashSkipTemplate=" + this.z + ", mDownloadSize='" + this.A + "', mDownloadTimes='" + this.B + "', mCarouselTime=" + this.C + ", mDynamicPopDelayTime=" + this.D + ", mVolumeStatus=" + this.E + ", vipAction=" + this.F + ", shakeSensorTime=" + this.G + ", shakeSensorDiff=" + this.H + ", mFloatTitle='" + this.I + "', mFloatDesc='" + this.J + "', mFloatBtnTitle='" + this.K + "', mFloatIconFile=" + this.L + ", mEndBackgroundFile=" + this.M + ", processEndElementStatus=" + this.N + ", mHostName='" + this.O + "', mHostIconRes=" + this.P + ", mHostGreetings='" + this.Q + "', interactiveMode=" + this.R + "', mGameView=" + this.S + '}';
    }

    public f a(int i) {
        this.G = i;
        return this;
    }

    public f b(int i) {
        this.H = i;
        return this;
    }

    public f c(int i) {
        this.F = i;
        return this;
    }

    public f d(String str) {
        this.m = str;
        return this;
    }

    public f e(String str) {
        this.t = str;
        return this;
    }

    public f f(String str) {
        this.p = str;
        return this;
    }

    public f g(String str) {
        this.q = str;
        return this;
    }

    public f h(String str) {
        this.A = str;
        return this;
    }

    public f i(String str) {
        this.B = str;
        return this;
    }

    public f j(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.b.add(new Pair<>(str, str2));
        }
        return this;
    }

    public f a(long j, long j2) {
        this.x = j;
        this.y = j2;
        return this;
    }

    public f b(String str) {
        this.d = str;
        return this;
    }

    public f c(String str) {
        this.l = str;
        return this;
    }

    public f d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.j = new e(str);
        } else {
            this.j = new e(str, str2);
        }
        return this;
    }

    public f e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.k = new e(str);
        } else {
            this.k = new e(str, str2);
        }
        return this;
    }

    public f f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        if (TextUtils.isEmpty(str2)) {
            this.n = new e(str);
        } else {
            this.n = new e(str, str2);
        }
        return this;
    }

    public f g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        if (TextUtils.isEmpty(str2)) {
            this.o = new e(str);
        } else {
            this.o = new e(str, str2);
        }
        return this;
    }

    public f h(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.L = new e(str);
        } else {
            this.L = new e(str, str2);
        }
        return this;
    }

    public f i(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.f9415a.put(str, str2);
        return this;
    }

    public f a(a aVar) {
        this.w = aVar;
        return this;
    }

    public f b(String str, String str2) {
        this.f.add(TextUtils.isEmpty(str2) ? new e(str) : new e(str, str2));
        return this;
    }

    public f c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.i = new e(str);
        } else {
            this.i = new e(str, str2);
        }
        return this;
    }

    public f a(com.opos.mobad.template.d dVar) {
        this.v = dVar;
        return this;
    }

    public f b(boolean z) {
        this.u = z;
        return this;
    }

    public f a(com.opos.mobad.template.e.a aVar) {
        this.R = aVar;
        return this;
    }

    public f a(com.opos.mobad.template.e eVar) {
        this.z = eVar;
        return this;
    }

    public f a(String str) {
        this.c = str;
        return this;
    }

    public f a(String str, String str2) {
        this.e.add(TextUtils.isEmpty(str2) ? new e(str) : new e(str, str2));
        return this;
    }

    public f a(boolean z) {
        this.h = z;
        return this;
    }
}
