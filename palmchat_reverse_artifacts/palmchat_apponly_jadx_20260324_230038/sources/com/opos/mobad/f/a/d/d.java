package com.opos.mobad.f.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.ads.AdsInfoManager;
import com.opos.mobad.ads.AdsModel;
import com.opos.mobad.ads.IErrorHandler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {
    private static volatile d b;
    private Context d;
    private AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IErrorHandler f8851a = new IErrorHandler() { // from class: com.opos.mobad.f.a.d.d.1
    };
    private a c = new a();

    private d() {
    }

    public int a(String str) {
        if (this.e.get()) {
            return 4;
        }
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (!com.opos.mobad.c.b.a().c(str)) {
            a("not support ads", str);
            return 6;
        }
        if (!AdsInfoManager.getInstance().isSupportAdsVer()) {
            a("ads found fail", str);
            return 3;
        }
        if (com.opos.mobad.service.d.a.a(com.opos.mobad.c.b.j().k())) {
            a("fail child ad", str);
            return 2;
        }
        if (this.c.a()) {
            this.e.compareAndSet(false, true);
            a("fail ads ad intercept", str);
            return 4;
        }
        int coreVerCode = AdsModel.getInstance().getCoreVerCode();
        if (a(910004, coreVerCode)) {
            return 0;
        }
        com.opos.cmn.an.f.a.b("Ads-Selector", "fail ads ad compare = ", 910004, Integer.valueOf(coreVerCode));
        return 5;
    }

    public int b() {
        return AdsModel.getInstance().getCoreVerCode();
    }

    public void c() {
        this.c = new a();
        this.e.set(false);
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public void a(Context context) {
        this.d = context.getApplicationContext();
    }

    private void a(String str, String str2) {
        com.opos.cmn.an.f.a.b("Ads-Selector", str, str2);
    }

    public static boolean a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        int i3 = i / 1000;
        int i4 = i2 / 1000;
        return i3 > 0 && i4 > 0 && i4 >= i3;
    }
}
