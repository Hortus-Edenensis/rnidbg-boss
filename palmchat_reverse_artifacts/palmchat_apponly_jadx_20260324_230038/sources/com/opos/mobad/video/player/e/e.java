package com.opos.mobad.video.player.e;

import android.text.TextUtils;
import com.opos.mobad.template.a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f10338a = new AtomicInteger(15);
    private Runnable b = new Runnable() { // from class: com.opos.mobad.video.player.e.e.1
        @Override // java.lang.Runnable
        public void run() {
            e.this.h();
        }
    };
    private boolean c = false;

    public CharSequence a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "前往“" + str + "”";
        }
        return str2 + "浏览" + this.f10338a.get() + "秒可立即领取奖励。确认放弃直接拿奖励吗？";
    }

    public void b() {
        a(true);
    }

    public long c() {
        return this.f10338a.get();
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.f10338a.get() <= 0;
    }

    public CharSequence f() {
        return "放弃";
    }

    public CharSequence g() {
        return "直接拿奖励";
    }

    public void h() {
        try {
            if (this.f10338a.get() <= 0) {
                com.opos.cmn.an.f.a.b("ECommerceDialogPresenter", "startTiming(), currentTime <= 0");
                a(false);
            } else {
                this.f10338a.decrementAndGet();
                a(false);
                com.opos.mobad.d.c.c.a(this.b, 1000L);
                com.opos.cmn.an.f.a.b("ECommerceDialogPresenter", "startTiming(), currentTime=", Integer.valueOf(this.f10338a.get()));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ECommerceDialogPresenter", "startTiming() fail", e);
        }
    }

    public void i() {
        a(false);
    }

    public void a() {
        this.c = false;
        a(true);
    }

    public void a(a.b bVar, Map<String, String> map) {
        if (bVar == a.b.E_COMMERCE_DIALOG_SHOW) {
            this.c = true;
            com.opos.cmn.an.f.a.b("ECommerceDialogPresenter", "onStatusChange() isShowingECommerceDialog=true");
        } else if (bVar == a.b.E_COMMERCE_DIALOG_CLOSE) {
            this.c = false;
            com.opos.cmn.an.f.a.b("ECommerceDialogPresenter", "onStatusChange() isShowingECommerceDialog=false");
        }
    }

    public void a(boolean z) {
        try {
            com.opos.mobad.d.c.c.b(this.b);
            if (z) {
                this.f10338a.set(15);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ECommerceDialogPresenter", "stopTiming() fail", e);
        }
    }

    public static boolean a(int i) {
        return i == 2160 || i == 2161;
    }
}
