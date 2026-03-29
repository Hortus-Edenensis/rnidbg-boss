package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.mv;
import com.ss.android.socialbase.downloader.depend.qq;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.depend.sx;
import com.ss.android.socialbase.downloader.downloader.bg;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private String ay;
    private List<String> b;
    private com.ss.android.socialbase.downloader.downloader.n bg;
    private bg bq;
    private boolean c;
    private IDownloadFileUriProvider cj;
    private com.ss.android.socialbase.downloader.notification.u dw;
    private int eh;
    private String f;
    private String fx;
    private boolean gc;
    private boolean gi;
    private int h;
    private String iz;
    private String ja;
    private String k;
    private String kj;
    private long lf;
    private boolean mh;
    private IDownloadListener mv;
    private List<com.ss.android.socialbase.downloader.model.fx> n;
    private int nb;
    private Context nr;
    private boolean o;
    private s oa;
    private String p;
    private boolean pb;
    private String pn;
    private boolean q;
    private String qq;
    private boolean rh;
    private IDownloadListener s;
    private ja su;
    private com.ss.android.socialbase.downloader.downloader.x sx;
    private sx tk;
    private Activity u;
    private com.ss.android.socialbase.appdownloader.fx.iz w;
    private boolean wi;
    private boolean wq;
    private String x;
    private boolean xg;
    private qq xw;
    private int y;
    private JSONObject yd;
    private long z;
    private int[] za;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10595a = true;
    private boolean jk = false;
    private boolean t = true;
    private boolean l = false;
    private String my = AdBaseConstants.MIME_APK;
    private int d = 5;
    private boolean bf = true;
    private EnqueueType m = EnqueueType.ENQUEUE_NONE;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private int f10596jp = 150;
    private boolean bc = true;
    private List<mv> v = new ArrayList();
    private boolean mk = true;
    private boolean kw = true;

    public iz(@NonNull Context context, @NonNull String str) {
        this.nr = context.getApplicationContext();
        this.fx = str;
    }

    public IDownloadListener a() {
        return this.mv;
    }

    public boolean ay() {
        return this.kw;
    }

    public List<com.ss.android.socialbase.downloader.model.fx> b() {
        return this.n;
    }

    public qq bc() {
        return this.xw;
    }

    public boolean bf() {
        return this.pb;
    }

    public int bg() {
        return this.nb;
    }

    public String bq() {
        return this.qq;
    }

    public long c() {
        return this.z;
    }

    public ja cj() {
        return this.su;
    }

    public boolean d() {
        return this.wq;
    }

    public String dw() {
        return this.kj;
    }

    public int[] eh() {
        return this.za;
    }

    public String fx() {
        return this.x;
    }

    public String gc() {
        return this.ay;
    }

    public Activity getActivity() {
        return this.u;
    }

    public Context getContext() {
        return this.nr;
    }

    public boolean gi() {
        return this.bf;
    }

    public bg h() {
        return this.bq;
    }

    public boolean iz() {
        return this.jk;
    }

    public int ja() {
        return this.y;
    }

    public IDownloadListener jk() {
        return this.s;
    }

    public boolean jp() {
        return this.gi;
    }

    public com.ss.android.socialbase.downloader.downloader.n k() {
        return this.bg;
    }

    public boolean kj() {
        return this.rh;
    }

    public JSONObject kw() {
        return this.yd;
    }

    public String l() {
        return this.my;
    }

    public boolean lf() {
        return this.gc;
    }

    public EnqueueType m() {
        return this.m;
    }

    public int mh() {
        return this.eh;
    }

    public List<String> mk() {
        return this.b;
    }

    public boolean mv() {
        return this.o;
    }

    public com.ss.android.socialbase.downloader.downloader.x my() {
        return this.sx;
    }

    public boolean n() {
        return this.l;
    }

    public boolean nb() {
        return this.mk;
    }

    public String nr() {
        return this.pn;
    }

    public boolean o() {
        return this.c;
    }

    public com.ss.android.socialbase.appdownloader.fx.iz oa() {
        return this.w;
    }

    public sx p() {
        return this.tk;
    }

    public boolean pb() {
        return this.bc;
    }

    public boolean pn() {
        return this.f10595a;
    }

    public int q() {
        return this.d;
    }

    public int qq() {
        return this.h;
    }

    public int rh() {
        return this.f10596jp;
    }

    public com.ss.android.socialbase.downloader.notification.u s() {
        return this.dw;
    }

    public boolean su() {
        return this.mh;
    }

    public boolean sx() {
        return this.q;
    }

    public String t() {
        return this.k;
    }

    public List<mv> tk() {
        return this.v;
    }

    public String u() {
        return this.fx;
    }

    public String v() {
        return this.f;
    }

    public IDownloadFileUriProvider w() {
        return this.cj;
    }

    public String wi() {
        return this.p;
    }

    public boolean wq() {
        return this.xg;
    }

    public boolean x() {
        return this.t;
    }

    public boolean xg() {
        return this.wi;
    }

    public s xw() {
        return this.oa;
    }

    public String y() {
        return this.iz;
    }

    public long yd() {
        return this.lf;
    }

    public String z() {
        return this.ja;
    }

    public iz a(String str) {
        this.ja = str;
        return this;
    }

    public iz b(String str) {
        this.p = str;
        return this;
    }

    public iz fx(@NonNull String str) {
        this.x = str;
        return this;
    }

    public iz iz(String str) {
        this.my = str;
        return this;
    }

    public iz jk(boolean z) {
        this.wq = z;
        return this;
    }

    public iz k(boolean z) {
        this.gc = z;
        return this;
    }

    public iz l(boolean z) {
        this.xg = z;
        return this;
    }

    public iz mv(boolean z) {
        this.bc = z;
        return this;
    }

    public iz my(boolean z) {
        this.mk = z;
        return this;
    }

    public iz n(String str) {
        this.kj = str;
        return this;
    }

    public iz nr(String str) {
        this.iz = str;
        return this;
    }

    public iz pn(String str) {
        this.k = str;
        return this;
    }

    public iz s(boolean z) {
        this.gi = z;
        return this;
    }

    public iz t(boolean z) {
        this.pb = z;
        return this;
    }

    public void u(int i) {
        this.nb = i;
    }

    public iz x(String str) {
        this.qq = str;
        return this;
    }

    public iz a(boolean z) {
        this.bf = z;
        return this;
    }

    public iz b(boolean z) {
        this.o = z;
        return this;
    }

    public iz fx(boolean z) {
        this.l = z;
        return this;
    }

    public iz iz(boolean z) {
        this.q = z;
        return this;
    }

    public iz jk(String str) {
        this.f = str;
        return this;
    }

    public iz n(boolean z) {
        this.wi = z;
        return this;
    }

    public iz nr(boolean z) {
        this.jk = z;
        return this;
    }

    public iz pn(boolean z) {
        this.c = z;
        return this;
    }

    public iz t(String str) {
        this.ay = str;
        return this;
    }

    public iz u(String str) {
        this.pn = str;
        return this;
    }

    public iz x(boolean z) {
        this.rh = z;
        return this;
    }

    public iz b(int i) {
        this.f10596jp = i;
        return this;
    }

    public iz fx(int i) {
        this.h = i;
        return this;
    }

    public iz iz(int i) {
        this.eh = i;
        return this;
    }

    public iz nr(int i) {
        this.d = i;
        return this;
    }

    public iz pn(int i) {
        this.y = i;
        return this;
    }

    public iz u(List<com.ss.android.socialbase.downloader.model.fx> list) {
        this.n = list;
        return this;
    }

    public iz nr(List<String> list) {
        this.b = list;
        return this;
    }

    public iz u(boolean z) {
        this.f10595a = z;
        return this;
    }

    public iz u(IDownloadListener iDownloadListener) {
        this.mv = iDownloadListener;
        return this;
    }

    public iz u(long j) {
        this.z = j;
        return this;
    }

    public iz u(EnqueueType enqueueType) {
        this.m = enqueueType;
        return this;
    }

    public iz u(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.cj = iDownloadFileUriProvider;
        return this;
    }

    public iz u(sx sxVar) {
        this.tk = sxVar;
        return this;
    }

    public iz u(JSONObject jSONObject) {
        this.yd = jSONObject;
        return this;
    }

    public iz u(mv mvVar) {
        synchronized (this.v) {
            if (mvVar != null) {
                if (!this.v.contains(mvVar)) {
                    this.v.add(mvVar);
                    return this;
                }
            }
            return this;
        }
    }
}
