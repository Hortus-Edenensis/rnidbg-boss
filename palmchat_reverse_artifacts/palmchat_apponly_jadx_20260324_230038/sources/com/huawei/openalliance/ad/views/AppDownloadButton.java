package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.Cdo;
import com.huawei.hms.ads.dn;
import com.huawei.hms.ads.dr;
import com.huawei.hms.ads.ej;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.ji;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.kc;
import com.huawei.hms.ads.ke;
import com.huawei.hms.ads.kh;
import com.huawei.hms.ads.ki;
import com.huawei.hms.ads.kj;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.kn;
import com.huawei.hms.ads.kr;
import com.huawei.hms.ads.kw;
import com.huawei.hms.ads.ll;
import com.huawei.hms.ads.lr;
import com.huawei.hms.ads.mf;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.uiengine.common.IProgressButton;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.TextState;
import com.huawei.openalliance.ad.constant.aj;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.download.app.PPSAppDownloadManager;
import com.huawei.openalliance.ad.download.app.g;
import com.huawei.openalliance.ad.download.app.j;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.ap;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.x;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.a;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class AppDownloadButton extends AppDownBtnContainer implements ll, com.huawei.openalliance.ad.download.g {
    private AppInfo D;
    private l F;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f6963a;
    private f b;
    private d c;
    private AppStatus d;
    private AppStatus e;
    private int f;
    private AdContentData g;
    private boolean h;
    private int i;
    private final int j;
    private List<TextState> k;
    private lr l;
    private final boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private mf q;
    private boolean r;
    private int s;
    private MaterialClickInfo t;
    private boolean u;
    private boolean v;
    private boolean w;
    private kh x;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[AppStatus.values().length];
            Code = iArr;
            try {
                iArr[AppStatus.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[AppStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[AppStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[AppStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[AppStatus.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[AppStatus.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements View.OnClickListener {
        private WeakReference<AppDownloadButton> Code;

        public b(AppDownloadButton appDownloadButton) {
            this.Code = new WeakReference<>(appDownloadButton);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppDownloadButton appDownloadButton = this.Code.get();
            if (appDownloadButton == null) {
                return;
            }
            fh.V(((AppDownBtnContainer) appDownloadButton).V, "on cancel btn click.");
            appDownloadButton.Code();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements g.a {
        private WeakReference<AppDownloadButton> Code;

        public c(AppDownloadButton appDownloadButton) {
            this.Code = new WeakReference<>(appDownloadButton);
        }

        @Override // com.huawei.openalliance.ad.download.app.g.a
        public void Code(boolean z, String str) {
            final AppDownloadButton appDownloadButton = this.Code.get();
            if (!z || appDownloadButton == null) {
                return;
            }
            if (!TextUtils.isEmpty(str) && appDownloadButton.D != null) {
                appDownloadButton.D.V(str);
            }
            fh.V(((AppDownBtnContainer) appDownloadButton).V, "cancelTask success");
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.c.1
                @Override // java.lang.Runnable
                public void run() {
                    PPSAppDownloadManager.V(appDownloadButton.getContext(), appDownloadButton.D);
                    if (appDownloadButton.f6963a != null) {
                        appDownloadButton.f6963a.Code(appDownloadButton.D);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        CharSequence Code(CharSequence charSequence, AppStatus appStatus);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void Code(AppStatus appStatus);

        void Code(AppInfo appInfo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        boolean Code(AppInfo appInfo, long j);
    }

    public AppDownloadButton(Context context) {
        super(context);
        this.f = -1;
        this.h = true;
        this.i = 1;
        this.j = 2;
        this.m = true;
        this.o = true;
        this.p = false;
        this.r = true;
        this.s = -1;
        this.u = false;
        this.w = false;
        Code(context, (AttributeSet) null, -1, -1);
    }

    private boolean D() {
        String str;
        String str2;
        if (f()) {
            str = ((AppDownBtnContainer) this).V;
            str2 = "open harmony service";
        } else {
            if (this.d == AppStatus.INSTALLED) {
                i();
                return true;
            }
            if (L()) {
                return c();
            }
            if (e()) {
                str = ((AppDownBtnContainer) this).V;
                str2 = "open Ag detail";
            } else if (g()) {
                str = ((AppDownBtnContainer) this).V;
                str2 = "open Ag mini detail";
            } else {
                if (!h()) {
                    return false;
                }
                str = ((AppDownBtnContainer) this).V;
                str2 = "open Gp detail";
            }
        }
        fh.V(str, str2);
        return true;
    }

    private boolean L() {
        AppInfo appInfo;
        if (a()) {
            return true;
        }
        if (this.i != 1 || (appInfo = this.D) == null) {
            return false;
        }
        return "21".equalsIgnoreCase(appInfo.T());
    }

    private boolean S() {
        AppInfo appInfo = this.D;
        return appInfo != null && "11".equals(appInfo.i());
    }

    private boolean a() {
        AdContentData adContentData = this.g;
        return (adContentData == null || this.D == null || adContentData.j() != 7 || com.huawei.openalliance.ad.utils.h.Code(getContext(), this.D.Code())) ? false : true;
    }

    private boolean c() {
        if (this.g == null) {
            return false;
        }
        l lVar = this.F;
        kl klVar = new kl(getContext(), this.g, true, lVar != null ? lVar.au() : null);
        klVar.Code(this.x);
        boolean zCode = klVar.Code();
        if (zCode) {
            fh.V(((AppDownBtnContainer) this).V, "list page btn openLandingPage");
            V(v.B, this.i);
        }
        klVar.V(zCode);
        return zCode;
    }

    private boolean d() {
        if (this.D == null) {
            m();
            fh.V(((AppDownBtnContainer) this).V, "appInfo is empty");
            return false;
        }
        if (this.d == AppStatus.INSTALLED || S() || this.D.w()) {
            return true;
        }
        String strZ = this.D.z();
        if (!TextUtils.isEmpty(strZ)) {
            if (strZ.equals("7") && !TextUtils.isEmpty(this.D.j())) {
                return true;
            }
            if (strZ.equals("9") && !TextUtils.isEmpty(this.D.Code()) && !TextUtils.isEmpty(this.D.A())) {
                return true;
            }
        }
        if (!TextUtils.isEmpty(this.D.Z())) {
            return true;
        }
        m();
        return false;
    }

    private boolean e() {
        String strZ = this.D.z();
        if (TextUtils.isEmpty(strZ) || TextUtils.isEmpty(this.D.j()) || !strZ.equals("7")) {
            return false;
        }
        kc kcVar = new kc(getContext(), this.g);
        kcVar.Code(this.x);
        boolean zCode = kcVar.Code();
        kcVar.V(zCode);
        if (!zCode) {
            m();
            return false;
        }
        V(v.Code, this.i);
        o();
        return true;
    }

    private boolean f() {
        if (!"9".equals(this.D.z()) || TextUtils.isEmpty(this.D.Code()) || TextUtils.isEmpty(this.D.A())) {
            return false;
        }
        kj kjVar = new kj(getContext(), this.g);
        kjVar.Code(this.x);
        boolean zCode = kjVar.Code();
        kjVar.V(zCode);
        if (!zCode) {
            m();
            return false;
        }
        V(kjVar.Z(), this.i);
        o();
        return true;
    }

    private boolean g() {
        String strZ = this.D.z();
        if (TextUtils.isEmpty(strZ) || TextUtils.isEmpty(this.D.Code()) || !strZ.equals("6")) {
            return false;
        }
        kn knVar = new kn(getContext(), this.g);
        knVar.Code(this.i);
        knVar.Code();
        knVar.Code(this.x);
        knVar.V(true);
        V(v.F, this.i);
        o();
        return true;
    }

    private String getAdTag() {
        lr lrVar = this.l;
        if (lrVar != null) {
            return lrVar.getAdTag();
        }
        return null;
    }

    private long getLeftSize() {
        if (this.D == null) {
            return 0L;
        }
        AppDownloadTask task = getTask();
        long jB = this.D.B();
        if (task == null) {
            return jB;
        }
        long jB2 = this.D.B() - task.Z();
        return jB2 <= 0 ? jB : jB2;
    }

    private AppDownloadTask getTask() {
        AdContentData adContentData;
        AppDownloadTask appDownloadTaskCode = com.huawei.openalliance.ad.download.app.g.I().Code(this.D);
        if (appDownloadTaskCode != null && (adContentData = this.g) != null) {
            appDownloadTaskCode.Z(adContentData.L());
            appDownloadTaskCode.B(this.g.w());
            appDownloadTaskCode.C(this.g.a());
            appDownloadTaskCode.I(this.g.D());
            appDownloadTaskCode.S(this.g.at());
            appDownloadTaskCode.F(this.g.au());
            appDownloadTaskCode.D(this.g.M());
            appDownloadTaskCode.C(this.g.aF());
            appDownloadTaskCode.b(this.g.aE());
        }
        return appDownloadTaskCode;
    }

    private boolean h() {
        List<Integer> listE;
        if (this.D != null && z.B(getContext()) && (listE = this.D.E()) != null && listE.contains(14)) {
            ez.Code(getContext()).Code();
            kr krVarCode = ke.Code(getContext(), this.g, this.F.au(), listE);
            krVarCode.Code(this.x);
            boolean zCode = krVarCode.Code();
            krVarCode.V(zCode);
            if (zCode) {
                V(v.B, this.i);
                o();
                return true;
            }
            m();
        }
        return false;
    }

    private void i() {
        AppDownloadTask task;
        fh.Code(((AppDownBtnContainer) this).V, "doClickAction, status:" + this.d);
        int i = AnonymousClass5.Code[this.d.ordinal()];
        if (i == 1) {
            if (!com.huawei.openalliance.ad.utils.h.Code() && p()) {
                fh.V(((AppDownBtnContainer) this).V, "not allowed");
                return;
            } else {
                Code(true);
                V(S() ? "restore" : "download", this.i);
                return;
            }
        }
        if (i == 2) {
            Code(false);
            return;
        }
        if (i == 3) {
            com.huawei.openalliance.ad.download.app.g.I().V(getTask());
            return;
        }
        if (i == 4) {
            j();
        } else if (i == 5 && (task = getTask()) != null) {
            Z(task);
        }
    }

    private void j() {
        if (!l() || this.s == 1) {
            p();
        } else {
            k();
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.7
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.p();
                }
            }, 600L);
        }
    }

    private void k() {
        Context context = getContext();
        AppDownloadTask appDownloadTaskU = u();
        if (context == null || appDownloadTaskU == null) {
            return;
        }
        com.huawei.openalliance.ad.download.app.b.Code(context).Code(appDownloadTaskU);
    }

    private boolean l() {
        return jg.b(this.g.v()) && com.huawei.hms.ads.utils.a.Code(this.D);
    }

    private void m() {
        mf mfVar = this.q;
        if (mfVar != null) {
            mfVar.Code(this);
        }
    }

    private void n() {
        mf mfVar = this.q;
        if (mfVar != null) {
            mfVar.V(this);
        }
    }

    private void o() {
        mf mfVar = this.q;
        if (mfVar != null) {
            mfVar.I(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        if (this.g == null) {
            return false;
        }
        Context context = getContext();
        String strCode = this.D.Code();
        boolean zV = x.Code(context, strCode) ? V(context) : false;
        return !zV ? Code(context, strCode) : zV;
    }

    private void q() {
        if (this.t == null) {
            return;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.t.B("ad_download_btn_dynamic");
        this.t.C(Integer.valueOf(iArr[0]));
        this.t.S(Integer.valueOf(iArr[1]));
        this.t.F(Integer.valueOf(getWidth()));
        this.t.D(Integer.valueOf(getHeight()));
        this.t.L(0);
        this.t.a(0);
        this.t.b(0);
        this.t.c(0);
        this.t.d(Integer.valueOf(com.huawei.openalliance.ad.utils.d.C(getContext()).widthPixels));
        this.t.e(Integer.valueOf(com.huawei.openalliance.ad.utils.d.C(getContext()).heightPixels));
    }

    private void r() {
        lr lrVar = this.l;
        if (lrVar != null) {
            lrVar.Code(2, true);
        }
    }

    private void s() {
        lr lrVar = this.l;
        if (lrVar != null) {
            lrVar.D();
        }
    }

    private boolean t() {
        AppInfo appInfo = this.D;
        return appInfo != null && appInfo.w() && com.huawei.openalliance.ad.utils.h.I(getContext(), com.huawei.openalliance.ad.constant.x.ad) >= 100300300;
    }

    private AppDownloadTask u() {
        AppDownloadTask appDownloadTaskCode = new AppDownloadTask.a().Code(this.L).Code(this.D).Code();
        if (appDownloadTaskCode == null) {
            return null;
        }
        appDownloadTaskCode.Code(Integer.valueOf(this.i));
        appDownloadTaskCode.I((Integer) 2);
        appDownloadTaskCode.Code(this.g);
        AdContentData adContentData = this.g;
        if (adContentData != null) {
            appDownloadTaskCode.B(adContentData.w());
            appDownloadTaskCode.Z(this.g.L());
            appDownloadTaskCode.C(this.g.a());
            appDownloadTaskCode.I(this.g.D());
            appDownloadTaskCode.S(this.g.at());
            appDownloadTaskCode.F(this.g.au());
            appDownloadTaskCode.D(this.g.M());
            appDownloadTaskCode.b(this.g.aE());
            appDownloadTaskCode.C(this.g.aF());
        }
        return appDownloadTaskCode;
    }

    public void C() {
        if (fh.Code()) {
            fh.Code(((AppDownBtnContainer) this).V, "downloadApp, status:%s", this.d);
        }
        AppStatus appStatus = this.d;
        if ((appStatus == AppStatus.DOWNLOAD || appStatus == AppStatus.PAUSE) && this.D != null) {
            AppDownloadTask task = getTask();
            if (task == null) {
                com.huawei.openalliance.ad.download.app.g.I().Code(u());
                return;
            }
            task.Code(Integer.valueOf(this.i));
            task.I((Integer) 2);
            task.Code(this.L);
            com.huawei.openalliance.ad.download.app.g.I().I(task);
        }
    }

    public void I() {
        fh.Code(((AppDownBtnContainer) this).V, "downloadInMobileData");
        if (t()) {
            Z();
            return;
        }
        fh.Code(((AppDownBtnContainer) this).V, "not useAgMobileDataTipsDialog");
        dr drVar = new dr(getContext());
        drVar.Code(new dn.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.9
            @Override // com.huawei.hms.ads.dn.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setAllowedNonWifiNetwork(true);
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.Z();
            }

            @Override // com.huawei.hms.ads.dn.a
            public void V(AppInfo appInfo) {
            }
        });
        drVar.Code(this.D, this.g, getLeftSize());
    }

    public AppStatus V() {
        AppStatus appStatusCode = AppStatus.DOWNLOAD;
        AppInfo appInfo = this.D;
        AppDownloadTask task = null;
        String str = null;
        if (appInfo == null) {
            this.e = this.d;
            this.d = appStatusCode;
            I((AppDownloadTask) null);
        } else {
            String strCode = appInfo.Code();
            if (com.huawei.openalliance.ad.utils.h.V(getContext(), this.D.Code()) != null) {
                appStatusCode = AppStatus.INSTALLED;
            } else {
                task = getTask();
                if (task != null) {
                    appStatusCode = Code(task, strCode, false);
                }
            }
            this.e = this.d;
            this.d = appStatusCode;
            I(task);
            str = strCode;
        }
        fh.Code(((AppDownBtnContainer) this).V, "refreshStatus, status:%s, pkg:%s", this.d, str);
        return this.d;
    }

    public void cancel() {
        Code((g.a) null);
    }

    public void continueDownload() {
        q();
        if (!d()) {
            fh.V(((AppDownBtnContainer) this).V, "click action invalid.");
            return;
        }
        n();
        if (D()) {
            return;
        }
        C();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSafeRelativeLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.t.f(Integer.valueOf((int) motionEvent.getRawX()));
                    this.t.g(Integer.valueOf((int) motionEvent.getRawY()));
                }
            } catch (Throwable th) {
                fh.I(getTAG(), "check touch ex: %s", th.getClass().getSimpleName());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AppInfo getAppInfo() {
        return this.D;
    }

    public mf getClickActionListener() {
        return this.q;
    }

    @Override // com.huawei.openalliance.ad.views.AppDownBtnContainer, com.huawei.hms.ads.uiengine.common.IProgressButton
    public AppStatus getStatus() {
        return this.d;
    }

    public com.huawei.openalliance.ad.views.a getStyle() {
        return this.I;
    }

    @Override // com.huawei.openalliance.ad.views.PPSSafeRelativeLayout
    public String getTAG() {
        return ((AppDownBtnContainer) this).V;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w = true;
        if (this.g != null) {
            super.b();
        }
        try {
            if (fh.Code()) {
                String str = ((AppDownBtnContainer) this).V;
                Object[] objArr = new Object[1];
                AppInfo appInfo = this.D;
                objArr[0] = appInfo == null ? null : appInfo.Code();
                fh.Code(str, "attach, pkg:%s", objArr);
            } else {
                fh.V(((AppDownBtnContainer) this).V, "attach appinfo is " + bc.V(this.D));
            }
            com.huawei.openalliance.ad.download.app.g.I().Code(this.D, this);
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.1
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.V();
                    if (AppDownloadButton.this.f6963a != null) {
                        AppDownloadButton.this.f6963a.Code(AppDownloadButton.this.d);
                    }
                }
            });
        } catch (RuntimeException | Exception unused) {
            fh.I(((AppDownBtnContainer) this).V, "attach ex");
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownBtnContainer, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        fh.V(((AppDownBtnContainer) this).V, "onClick");
        q();
        if (isFastClick()) {
            str = ((AppDownBtnContainer) this).V;
            str2 = "fast click";
        } else {
            if (d()) {
                n();
                if (D()) {
                    return;
                }
                i();
                return;
            }
            str = ((AppDownBtnContainer) this).V;
            str2 = "click action invalid.";
        }
        fh.V(str, str2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.w = true;
        try {
            if (fh.Code()) {
                String str = ((AppDownBtnContainer) this).V;
                Object[] objArr = new Object[1];
                AppInfo appInfo = this.D;
                objArr[0] = appInfo == null ? null : appInfo.Code();
                fh.Code(str, "detach, pkg:%s", objArr);
            } else {
                fh.V(((AppDownBtnContainer) this).V, "detach appinfo is " + bc.V(this.D));
            }
            com.huawei.openalliance.ad.download.app.g.I().V(this.D, this);
            ez.Code(getContext()).V();
        } catch (RuntimeException | Exception unused) {
            fh.I(((AppDownBtnContainer) this).V, "detach ex");
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        fh.V(((AppDownBtnContainer) this).V, "onVisibilityChanged, status:" + this.d);
        super.onVisibilityChanged(view, i);
        this.v = i == 0;
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.6
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.V();
            }
        });
    }

    public void setAfDlBtnText(String str) {
        if (this.D == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.D.S(str);
    }

    public void setAllowedNonWifiNetwork(boolean z) {
        this.L = z;
    }

    public void setAppDownloadButtonStyle(com.huawei.openalliance.ad.views.a aVar) {
        this.I = aVar;
    }

    public void setAppInfo(AppInfo appInfo) {
        fh.V(((AppDownBtnContainer) this).V, "setAppInfo appInfo is " + bc.V(appInfo));
        this.D = appInfo;
        if (appInfo != null) {
            com.huawei.openalliance.ad.download.app.g.I().Code(appInfo, this);
        }
    }

    public void setBfDlBtnTxt(String str) {
        AppInfo appInfo = this.D;
        if (appInfo != null) {
            appInfo.C(str);
        }
    }

    public void setButtonTextWatcherInner(d dVar) {
        this.c = dVar;
    }

    @Override // com.huawei.hms.ads.ll
    public void setClickActionListener(mf mfVar) {
        this.q = mfVar;
    }

    @Override // com.huawei.hms.ads.ll
    public void setHandleUrlCallBack(kh khVar) {
        this.x = khVar;
    }

    public void setIsSetProgressDrawable(boolean z) {
        this.r = z;
    }

    public void setNeedAppendProgress(boolean z) {
        this.u = z;
    }

    public void setNeedShowConfirmDialog(boolean z) {
        this.o = z;
    }

    public void setOnDownloadStatusChangedListener(e eVar) {
        this.f6963a = eVar;
    }

    public void setOnNonWifiDownloadListener(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.Code(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.V(i, i2, i3, i4);
    }

    @Override // com.huawei.hms.ads.ll
    public void setPpsNativeView(lr lrVar) {
        this.l = lrVar;
    }

    public void setRemoteAfDlBtnText(String str) {
        AppInfo appInfo = this.D;
        if (appInfo != null) {
            appInfo.D(str);
        }
    }

    public void setRemoteBfDlBtnTxt(String str) {
        AppInfo appInfo = this.D;
        if (appInfo != null) {
            appInfo.F(str);
        }
    }

    public void setShowPermissionDialog(boolean z) {
        this.h = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        super.setVisibilityInner(i);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = -1;
        this.h = true;
        this.i = 1;
        this.j = 2;
        this.m = true;
        this.o = true;
        this.p = false;
        this.r = true;
        this.s = -1;
        this.u = false;
        this.w = false;
        Code(context, attributeSet, -1, -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0045, code lost:
    
        if (r6 > 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r6 <= 0) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AppStatus Code(AppDownloadTask appDownloadTask, String str, boolean z) {
        AppStatus appStatus;
        int iB = appDownloadTask.B();
        fh.Code(((AppDownBtnContainer) this).V, "refreshStatus, dwnStatus:%s, pkg:%s", Integer.valueOf(iB), str);
        switch (iB) {
            case 0:
                int iD = appDownloadTask.D();
                int iS = appDownloadTask.S();
                this.f = iS;
                if (iD == 0) {
                }
                return AppStatus.PAUSE;
            case 1:
            case 2:
                appStatus = AppStatus.DOWNLOADING;
                this.f = appDownloadTask.S();
                return appStatus;
            case 3:
                return AppStatus.INSTALL;
            case 4:
                int iS2 = appDownloadTask.S();
                this.f = iS2;
                break;
            case 5:
                appStatus = AppStatus.INSTALLING;
                this.f = appDownloadTask.S();
                return appStatus;
            case 6:
                if (z) {
                    return AppStatus.INSTALLED;
                }
                AppStatus appStatus2 = AppStatus.DOWNLOAD;
                fh.Code(((AppDownBtnContainer) this).V, " hasInstalled=%s", Boolean.valueOf(z));
                com.huawei.openalliance.ad.download.app.g.I().I(appDownloadTask);
                return appStatus2;
            default:
                return AppStatus.DOWNLOAD;
        }
    }

    private void I(AppDownloadTask appDownloadTask) {
        int i;
        AppStatus appStatus;
        if (fh.Code()) {
            String str = ((AppDownBtnContainer) this).V;
            Object[] objArr = new Object[3];
            objArr[0] = this.d;
            objArr[1] = this.e;
            AppInfo appInfo = this.D;
            objArr[2] = appInfo == null ? null : appInfo.Code();
            fh.Code(str, "processStatus, status:%s, preStatus:%s, packageName:%s", objArr);
        }
        Context context = getContext();
        AppStatus appStatus2 = this.d;
        if (appStatus2 == null) {
            appStatus2 = AppStatus.DOWNLOAD;
        }
        Code(appStatus2);
        a.C0459a c0459aCode = this.I.Code(getContext(), this.d);
        setTextColor(c0459aCode.V);
        if (this.r) {
            int i2 = this.f;
            Drawable drawable = c0459aCode.Code;
            if (i2 != -1) {
                setProgressDrawable(drawable, i2);
            } else {
                setProgressDrawable(drawable);
            }
        }
        V(this.d);
        switch (AnonymousClass5.Code[this.d.ordinal()]) {
            case 1:
                Code(context, this.i, AppStatus.DOWNLOAD);
                return;
            case 2:
                i = this.i;
                appStatus = AppStatus.PAUSE;
                break;
            case 3:
                i = this.i;
                appStatus = AppStatus.DOWNLOADING;
                break;
            case 4:
                Code(context);
                return;
            case 5:
                Code(appDownloadTask, context);
                return;
            case 6:
                V(appDownloadTask, context);
                return;
            default:
                return;
        }
        Code(context, i, appStatus);
        setProgress(this.f);
    }

    public void Z() {
        Context context = getContext();
        boolean z = this.n && this.o;
        if (!(context instanceof Activity) || getStatus() != AppStatus.DOWNLOAD || !z) {
            C();
            return;
        }
        Cdo cdo = new Cdo(context);
        cdo.Code(new dn.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.10
            @Override // com.huawei.hms.ads.dn.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.C();
            }

            @Override // com.huawei.hms.ads.dn.a
            public void V(AppInfo appInfo) {
            }
        });
        this.p = true;
        cdo.Code(this.D, this.g, getLeftSize());
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = -1;
        this.h = true;
        this.i = 1;
        this.j = 2;
        this.m = true;
        this.o = true;
        this.p = false;
        this.r = true;
        this.s = -1;
        this.u = false;
        this.w = false;
        Code(context, attributeSet, i, -1);
    }

    private void Z(AppDownloadTask appDownloadTask) {
        if (this.D == null || this.g == null) {
            fh.I(((AppDownBtnContainer) this).V, "installApk, appinfo or content record is null");
        } else {
            com.huawei.openalliance.ad.download.app.g.I().Code(appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void I(String str) {
        V(str);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(AppDownloadTask appDownloadTask) {
        String str = ((AppDownBtnContainer) this).V;
        StringBuilder sb = new StringBuilder();
        sb.append("onStatusChanged, taskId:");
        sb.append(appDownloadTask.F());
        sb.append(", packageName");
        AppInfo appInfo = this.D;
        sb.append(appInfo == null ? null : appInfo.Code());
        sb.append(", status:");
        sb.append(appDownloadTask.B());
        fh.V(str, sb.toString());
        AppInfo appInfo2 = this.D;
        if (appInfo2 == null || !appInfo2.Code().equals(appDownloadTask.F())) {
            return;
        }
        if (appDownloadTask.o() != 7) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.12
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.V();
                    if (AppDownloadButton.this.f6963a != null) {
                        AppDownloadButton.this.f6963a.Code(AppDownloadButton.this.d);
                    }
                }
            });
            return;
        }
        if (!this.v) {
            fh.Code(((AppDownBtnContainer) this).V, "not visible");
        } else {
            if (appDownloadTask.B() != 4) {
                return;
            }
            appDownloadTask.Code(1);
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.11
                @Override // java.lang.Runnable
                public void run() {
                    fh.Code(((AppDownBtnContainer) AppDownloadButton.this).V, "start next install way");
                    AppDownloadButton.this.d = AppStatus.DOWNLOAD;
                    AppDownloadButton.this.setNeedShowConfirmDialog(false);
                    AppDownloadButton.this.Code(false);
                }
            });
        }
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f = -1;
        this.h = true;
        this.i = 1;
        this.j = 2;
        this.m = true;
        this.o = true;
        this.p = false;
        this.r = true;
        this.s = -1;
        this.u = false;
        this.w = false;
        Code(context, attributeSet, i, i2);
    }

    private void V(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.i, AppStatus.INSTALLING);
        }
    }

    @Override // com.huawei.hms.ads.ll
    public void Z(String str) {
        AdContentData adContentData = this.g;
        if (adContentData != null) {
            adContentData.I(str);
        }
    }

    public AppDownloadButton(Context context, Boolean bool) {
        super(context, bool);
        this.f = -1;
        this.h = true;
        this.i = 1;
        this.j = 2;
        this.m = true;
        this.o = true;
        this.p = false;
        this.r = true;
        this.s = -1;
        this.u = false;
        this.w = false;
        Code(context, (AttributeSet) null, -1, -1);
    }

    private String Code(int i, AppStatus appStatus) {
        String strZ = null;
        if (S() || ag.Code(this.k)) {
            return null;
        }
        int i2 = 1 == i ? 2 : 1;
        int iCode = TextState.Code(appStatus);
        String strV = com.huawei.openalliance.ad.utils.d.V();
        Iterator<TextState> it = this.k.iterator();
        String strZ2 = null;
        String strZ3 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TextState next = it.next();
            if (next != null && i2 == next.Code()) {
                if (iCode == next.V()) {
                    if (strV.equalsIgnoreCase(new Locale(next.I()).getLanguage())) {
                        strZ = next.Z();
                        break;
                    }
                    if (1 == next.B()) {
                        strZ2 = next.Z();
                    }
                }
                if (next.V() == 0) {
                    strZ3 = next.Z();
                }
            }
        }
        if (!TextUtils.isEmpty(strZ)) {
            strZ2 = strZ;
        }
        if (!TextUtils.isEmpty(strZ2)) {
            strZ3 = strZ2;
        }
        return bc.V(strZ3);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(String str) {
        AppInfo appInfo = this.D;
        if (appInfo == null || str == null || !str.equals(appInfo.Code())) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.3
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.V();
                if (AppDownloadButton.this.f6963a != null) {
                    AppDownloadButton.this.f6963a.Code(AppDownloadButton.this.d);
                }
            }
        });
    }

    public AppDownloadButton(Context context, Boolean bool, IProgressButton iProgressButton) {
        super(context, bool, iProgressButton);
        this.f = -1;
        this.h = true;
        this.i = 1;
        this.j = 2;
        this.m = true;
        this.o = true;
        this.p = false;
        this.r = true;
        this.s = -1;
        this.u = false;
        this.w = false;
        Code(context, (AttributeSet) null, -1, -1);
    }

    private String Code(Context context, AppStatus appStatus) {
        int i;
        if (context == null || appStatus == null) {
            return "";
        }
        switch (AnonymousClass5.Code[appStatus.ordinal()]) {
            case 1:
                return com.huawei.hms.ads.utils.a.Code(context, this.D);
            case 2:
                i = R.string.hiad_download_resume;
                break;
            case 3:
                return NumberFormat.getPercentInstance().format((this.f * 1.0f) / 100.0f);
            case 4:
                return com.huawei.hms.ads.utils.a.Code(context, this.D, this.s);
            case 5:
                i = R.string.hiad_download_install;
                break;
            case 6:
                i = R.string.hiad_download_installing;
                break;
            default:
                return null;
        }
        return context.getString(i);
    }

    public void V(String str, int i) {
        if (this.g != null) {
            r();
            if (i == 1 || this.g.Z() == 7 || this.g.Z() == 12) {
                ji jiVar = new ji();
                jiVar.B(getAdTag());
                jk.Code(getContext(), this.g, 0, 0, str, Integer.valueOf(i), this.t, com.huawei.openalliance.ad.utils.b.Code(getContext()), bg.V((View) this), jiVar);
                this.t = null;
                s();
            }
        }
    }

    public AppDownloadButton(Context context, Boolean bool, IProgressButton iProgressButton, ImageView imageView) {
        super(context, bool, iProgressButton, imageView);
        this.f = -1;
        this.h = true;
        this.i = 1;
        this.j = 2;
        this.m = true;
        this.o = true;
        this.p = false;
        this.r = true;
        this.s = -1;
        this.u = false;
        this.w = false;
        Code(context, (AttributeSet) null, -1, -1);
    }

    private boolean V(Context context) {
        ki kiVar = new ki(context, this.g);
        boolean zCode = kiVar.Code();
        kiVar.Code(this.x);
        kiVar.V(zCode);
        if (zCode) {
            PPSAppDownloadManager.Code(context, this.D);
            r();
            ji jiVar = new ji();
            jiVar.B(getAdTag());
            jk.Code(context, this.g, 0, 0, v.Z, Integer.valueOf(this.i), this.t, com.huawei.openalliance.ad.utils.b.Code(getContext()), bg.V((View) this), jiVar);
            this.t = null;
            s();
        }
        return zCode;
    }

    public void Code() {
        Code(new c(this));
    }

    @Override // com.huawei.hms.ads.ll
    public void Code(long j) {
        AdContentData adContentData = this.g;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    private void Code(Context context) {
        Code(context, this.i, AppStatus.INSTALLED);
    }

    private void Code(Context context, int i, AppStatus appStatus) {
        if (a()) {
            super.setText(context.getString(R.string.hiad_learn_more));
            return;
        }
        String strCode = Code(i, appStatus);
        if (TextUtils.isEmpty(strCode)) {
            Code((CharSequence) Code(context, appStatus), true, appStatus);
            return;
        }
        if (this.u && i == 1 && appStatus == AppStatus.DOWNLOADING) {
            strCode = strCode + NumberFormat.getPercentInstance().format((this.f * 1.0f) / 100.0f);
        }
        Code((CharSequence) strCode, false, appStatus);
    }

    public void Code(Context context, AttributeSet attributeSet, int i, int i2) {
        this.I = new com.huawei.openalliance.ad.views.a(context);
        super.setPadding(0, 0, 0, 0);
        setOnClickListener(this);
        setCancelBtnClickListener(new b(this));
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(AppDownloadTask appDownloadTask) {
        AppInfo appInfo = this.D;
        if (appInfo == null || !appInfo.Code().equals(appDownloadTask.F())) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.2
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.V();
                if (AppDownloadButton.this.f6963a == null || AppDownloadButton.this.e == AppDownloadButton.this.d) {
                    return;
                }
                AppDownloadButton.this.f6963a.Code(AppDownloadButton.this.d);
            }
        });
    }

    private void Code(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.i, AppStatus.INSTALL);
        }
    }

    private void Code(AppStatus appStatus) {
        Drawable drawable;
        int i;
        if (appStatus == AppStatus.DOWNLOAD && (i = this.f) != 0) {
            fh.Code(((AppDownBtnContainer) this).V, "status:DOWNLOAD, progress: %s, change to 0", Integer.valueOf(i));
            this.f = 0;
        }
        a.C0459a c0459aV = this.I.V();
        if (this.f != 0 || c0459aV == null || (drawable = c0459aV.Code) == null || drawable.getLevel() == 0) {
            return;
        }
        fh.V(((AppDownBtnContainer) this).V, "downloadingStyle.level is: %s, change to 0", Integer.valueOf(c0459aV.Code.getLevel()));
        c0459aV.Code.setLevel(0);
    }

    private void Code(g.a aVar) {
        com.huawei.openalliance.ad.download.app.g.I().Code(this.D, aVar);
        V();
        setOnNonWifiDownloadListener(null);
        setNeedShowConfirmDialog(true);
    }

    public void Code(MaterialClickInfo materialClickInfo) {
        this.t = materialClickInfo;
    }

    public void Code(CharSequence charSequence, boolean z, AppStatus appStatus) {
        d dVar = this.c;
        if (dVar != null && z) {
            charSequence = dVar.Code(charSequence, appStatus);
        }
        super.setText(charSequence);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(String str) {
        if (fh.Code()) {
            String str2 = ((AppDownBtnContainer) this).V;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            AppInfo appInfo = this.D;
            objArr[1] = appInfo == null ? null : appInfo.Code();
            fh.Code(str2, "onStatusChanged, packageName:%s, packageName %s", objArr);
        }
        AppInfo appInfo2 = this.D;
        if (appInfo2 == null || !appInfo2.Code().equals(str)) {
            return;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.13
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.V();
                if (AppDownloadButton.this.f6963a == null || AppDownloadButton.this.e == AppDownloadButton.this.d) {
                    return;
                }
                AppDownloadButton.this.f6963a.Code(AppDownloadButton.this.d);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.download.f
    public void Code(String str, final int i) {
        if (fh.Code()) {
            fh.Code(((AppDownBtnContainer) this).V, "status %s, packageName:%s", Integer.valueOf(i), str);
        }
        if (com.huawei.hms.ads.utils.a.Code(this.D)) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.4
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.s = i;
                    AppDownloadButton.this.V();
                }
            });
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public View getProgressBtn() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        fh.V(((AppDownBtnContainer) this).V, "processDownload, needShowPermissionDialog = %s", Boolean.valueOf(z));
        if (!ap.Z(getContext())) {
            Toast.makeText(getContext(), R.string.hiad_network_no_available, 0).show();
            return;
        }
        if (this.D.v() && this.h && z) {
            com.huawei.openalliance.ad.download.app.j.Code(getContext(), this.D, new j.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.8
                @Override // com.huawei.openalliance.ad.download.app.j.a
                public void Code() {
                    AppDownloadButton.this.setNeedShowConfirmDialog(false);
                    AppDownloadButton.this.Code(false);
                }
            });
            return;
        }
        if (!S() && !ap.I(getContext())) {
            long leftSize = getLeftSize();
            f fVar = this.b;
            if (fVar == null) {
                I();
                return;
            } else if (!fVar.Code(this.D, leftSize)) {
                return;
            }
        }
        Z();
    }

    private void Code(boolean z, int i) {
        if (this.x == null) {
            return;
        }
        ej ejVar = new ej();
        ejVar.V("clickActionType", i);
        ejVar.V("handleUrlResult", z);
        this.x.Code(ejVar.Code());
    }

    private boolean Code(Context context, String str) {
        int i;
        kw.a aVar = new kw.a();
        aVar.Code(this.D).Code(this.g).I(str);
        boolean zCode = com.huawei.openalliance.ad.utils.h.Code(context, str, this.D.D(), aVar.Code());
        ji jiVar = new ji();
        jiVar.B(getAdTag());
        int iV = com.huawei.hms.ads.utils.a.V(this.D.Code(), this.D);
        String strCode = com.huawei.hms.ads.utils.a.Code(this.D.Code(), this.D);
        if (!zCode) {
            fh.V(((AppDownBtnContainer) this).V, "handClick, openAppIntent fail");
            jk.Code(getContext(), this.g, aj.D, Integer.valueOf(iV), Integer.valueOf(com.huawei.openalliance.ad.utils.h.Code(context, str) ? 2 : 1));
            zCode = com.huawei.openalliance.ad.utils.h.Code(context, str, aVar.Code());
            if (zCode) {
                r();
                jk.Code(context, this.F.q(), (Integer) 1);
                PPSAppDownloadManager.Code(context, this.D);
                jk.Code(context, this.g, 0, 0, strCode, Integer.valueOf(this.i), this.t, com.huawei.openalliance.ad.utils.b.Code(getContext()), bg.V((View) this), jiVar);
                this.t = null;
                s();
                i = 6;
            } else {
                fh.V(((AppDownBtnContainer) this).V, "handClick, openAppMainPage fail");
                return zCode;
            }
        } else {
            PPSAppDownloadManager.Code(context, this.D);
            r();
            jk.Code(context, this.g, "intentSuccess", Integer.valueOf(iV), (Integer) null);
            jk.Code(context, this.g, 0, 0, strCode, Integer.valueOf(this.i), this.t, com.huawei.openalliance.ad.utils.b.Code(getContext()), bg.V((View) this), jiVar);
            this.t = null;
            s();
            i = 3;
        }
        Code(true, i);
        return zCode;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public int getCancelBtnHeight(int i) {
        return i;
    }

    @Deprecated
    public void setButtonTextWatcher(a aVar) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setCancelBtnHeight(int i) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setResetListener(IProgressButton.ProgressButtonResetListener progressButtonResetListener) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setShowCancelBtn(boolean z) {
    }

    @Override // com.huawei.hms.ads.ll
    public boolean Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (gVar == null) {
            setAppInfo(null);
            this.g = null;
            this.F = null;
            return false;
        }
        if (gVar instanceof l) {
            this.F = (l) gVar;
        }
        try {
            this.i = 1;
            AdContentData adContentDataQ = this.F.q();
            this.g = adContentDataQ;
            super.setAdData(adContentDataQ);
            if (this.w) {
                super.b();
            }
            AppInfo appInfoE = gVar.E();
            setAppInfo(appInfoE);
            l lVar = this.F;
            if (lVar != null) {
                MetaData metaDataI_ = lVar.i_();
                if (metaDataI_ != null) {
                    this.k = metaDataI_.i();
                }
                this.n = jg.B(this.F.K());
            }
            if (appInfoE != null) {
                setShowPermissionDialog(appInfoE.c());
                return true;
            }
        } catch (RuntimeException | Exception unused) {
            fh.Z(((AppDownBtnContainer) this).V, "setNativeAd ex");
        }
        return false;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextInner(CharSequence charSequence, boolean z) {
    }
}
