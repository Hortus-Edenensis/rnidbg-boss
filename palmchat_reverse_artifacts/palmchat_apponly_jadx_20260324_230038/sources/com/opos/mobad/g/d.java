package com.opos.mobad.g;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.d.e;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.template.a;
import com.opos.mobad.video.player.e.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.video.player.b.b f8910a;
    private com.opos.mobad.video.player.e.a b;
    private com.opos.mobad.video.player.b.c c;
    private com.opos.mobad.template.a d;
    private AdHelper.AdHelperData e;
    private int f;
    private FrameLayout g;
    private boolean h = false;
    private com.opos.mobad.ui.feedback.a i;
    private Bundle j;
    private final com.opos.mobad.video.player.g.a k;

    public d(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.video.player.b.b bVar2, com.opos.mobad.video.player.b.c cVar, AdHelper.AdHelperData adHelperData, int i, Bundle bundle) {
        com.opos.mobad.video.player.g.a aVar2 = new com.opos.mobad.video.player.g.a() { // from class: com.opos.mobad.g.d.2
            @Override // com.opos.mobad.video.player.g.a, com.opos.mobad.ad.c.a
            public void a() {
                if (d.this.c instanceof com.opos.mobad.ad.c.a) {
                    ((com.opos.mobad.ad.c.a) d.this.c).a();
                }
            }

            @Override // com.opos.mobad.j.d.a
            public void c() {
                if (d.this.c != null) {
                    d.this.c.c();
                }
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                if (d.this.c != null) {
                    d.this.c.d();
                }
            }

            @Override // com.opos.mobad.j.a.InterfaceC0748a
            public void g_() {
                if (d.this.c != null) {
                    d.this.c.g_();
                }
            }

            @Override // com.opos.mobad.ad.m.b
            public void onAdClick(long j) {
                if (d.this.c != null) {
                    d.this.c.onAdClick(j);
                }
            }

            @Override // com.opos.mobad.ad.m.b
            public void onAdShow(String str2) {
                if (d.this.c != null) {
                    d.this.c.onAdShow(str2);
                }
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i2, String str2) {
                if (d.this.c != null) {
                    d.this.c.a(i2, str2);
                }
            }

            @Override // com.opos.mobad.j.d.a
            public void a(long j) {
            }

            @Override // com.opos.mobad.video.player.g.e
            public void a(com.opos.mobad.l.c cVar2) {
            }

            @Override // com.opos.mobad.j.d.a
            public void a(String str2) {
                if (d.this.c != null) {
                    d.this.c.a(-1, str2);
                }
            }

            @Override // com.opos.mobad.j.d.a
            public void b() {
            }

            @Override // com.opos.mobad.video.player.g.e
            public void e() {
            }

            @Override // com.opos.mobad.ad.k
            public void onReward(Object... objArr) {
            }
        };
        this.k = aVar2;
        this.f8910a = bVar2;
        this.c = cVar;
        this.e = adHelperData;
        this.f = i;
        this.i = new com.opos.mobad.ui.feedback.a(activity, null);
        this.j = bundle;
        this.d = com.opos.mobad.video.player.d.a.a(activity, adHelperData.c, adHelperData.d, bundle, null);
        com.opos.mobad.template.a aVarA = com.opos.mobad.video.player.h.b.a.a().a(activity.getApplicationContext(), adHelperData.c, (a.InterfaceC0778a) null);
        com.opos.mobad.template.a aVarA2 = com.opos.mobad.video.player.h.b.b.a().a(activity, adHelperData.d, null);
        this.b = new com.opos.mobad.video.player.e.a(new com.opos.mobad.video.player.e.d(activity, bVar, str, aVar, new b.a(this.d, new com.opos.mobad.video.player.b(activity), this.i).a(aVarA).b(aVarA2).a(), new com.opos.mobad.video.player.g.b(aVar2), null, b()));
        FrameLayout frameLayout = new FrameLayout(activity.getApplicationContext());
        this.g = frameLayout;
        frameLayout.addView(this.d.c());
        if (aVarA != null && aVarA.c() != null) {
            View viewC = aVarA.c();
            viewC.setVisibility(8);
            this.g.addView(viewC);
        }
        if (aVarA2 != null && aVarA2.c() != null) {
            View viewC2 = aVarA2.c();
            viewC2.setVisibility(8);
            this.g.addView(viewC2);
        }
        this.f8910a.a(new com.opos.mobad.video.player.b.a() { // from class: com.opos.mobad.g.d.1
            @Override // com.opos.mobad.video.player.b.a
            public void a() {
                d.this.b.e();
            }
        });
    }

    private int b() {
        Bundle bundle = this.j;
        return (bundle == null || bundle.getInt("interstitial_scene") != e.b.INSTANT_EXIT.ordinal()) ? 2 : 4;
    }

    @Override // com.opos.mobad.g.a
    public void a() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.f8910a.a();
        this.b.b();
    }

    @Override // com.opos.mobad.g.a
    public boolean a(Activity activity, String str) {
        com.opos.mobad.video.player.e.a aVar = this.b;
        AdHelper.AdHelperData adHelperData = this.e;
        boolean zA = aVar.a(adHelperData.c, adHelperData.d, this.f, (com.opos.mobad.video.player.c) null);
        if (zA) {
            this.f8910a.a(activity, this.g);
            AdItemData adItemData = this.e.c;
            if (adItemData != null && adItemData.V() != null) {
                this.i.a(this.e.c.V());
            }
        }
        return zA;
    }
}
