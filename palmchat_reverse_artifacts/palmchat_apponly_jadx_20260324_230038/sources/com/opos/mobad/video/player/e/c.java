package com.opos.mobad.video.player.e;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.constant.bq;
import com.opos.mobad.ad.d.e;
import com.opos.mobad.ad.g;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.InteractiveData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.template.a;
import com.opos.mobad.video.player.e.a;
import com.opos.mobad.video.player.e.b;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f10327a;
    private final com.opos.mobad.b b;
    private com.opos.mobad.video.player.g.e c;
    private com.opos.mobad.video.player.e.a d;
    private int e;
    private int f;
    private boolean g;
    private com.opos.mobad.cmn.func.a h;
    private com.opos.mobad.video.player.c i;
    private com.opos.mobad.p.a j;
    private com.opos.mobad.cmn.func.adhandler.f k;
    private AdItemData l;
    private MaterialData m;
    private c.b n = new c.b() { // from class: com.opos.mobad.video.player.e.c.5
        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("AdShower", "install pkgName=" + str);
            if (c.this.d != null) {
                c.this.d.b(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void b(AdItemData adItemData, String str) {
            if (c.this.d != null) {
                c.this.d.a(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void c(AdItemData adItemData, String str) {
            if (c.this.d != null) {
                c.this.d.a(adItemData, str);
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.opos.mobad.video.player.c.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InteractiveData f10336a;

        public a(InteractiveData interactiveData) {
            this.f10336a = interactiveData;
        }

        @Override // com.opos.mobad.video.player.c.a.b
        public String a() {
            return this.f10336a.f;
        }

        @Override // com.opos.mobad.video.player.c.a.b
        public String b() {
            return this.f10336a.g;
        }
    }

    public c(com.opos.mobad.b bVar) {
        this.b = bVar.c();
    }

    private int e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.mobad.video.player.g.e eVar = this.c;
        if (eVar != null) {
            eVar.a(-1, "Unknown error. ");
        }
    }

    public void a() {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void b() {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void c() {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.video.player.g.e eVar = this.c;
        if (eVar != null) {
            eVar.a((c.b) null);
        }
        this.f10327a = null;
        this.c = null;
        this.j = null;
        this.i = null;
        this.k = null;
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.video.player.e.c.4
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = c.this.f10327a;
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    com.opos.cmn.an.f.a.b("AdShower", "vip result but destroy");
                } else if (c.this.d != null) {
                    c.this.d.d(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final String str, final Map<String, String> map) {
        if (this.g) {
            return;
        }
        this.g = true;
        try {
            this.c.a(new com.opos.mobad.l.c() { // from class: com.opos.mobad.video.player.e.c.6
                @Override // com.opos.mobad.l.c
                public void a(final AdHelper.AdHelperData adHelperData) {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Object[] objArr = new Object[2];
                            objArr[0] = "tryShowFallbackAd fallbackData=";
                            objArr[1] = Boolean.valueOf(adHelperData != null);
                            com.opos.cmn.an.f.a.b("AdShower", objArr);
                            AdHelper.AdHelperData adHelperData2 = adHelperData;
                            if (adHelperData2 == null) {
                                if (c.this.d != null) {
                                    c.this.d.b(map);
                                    return;
                                }
                                return;
                            }
                            c cVar = c.this;
                            boolean zA = cVar.a(adHelperData2, cVar.f, c.this.h, c.this.c, c.this.i, c.this.j, c.this.k, true);
                            com.opos.cmn.an.f.a.b("AdShower", "tryShowFallbackAd showResult=", Boolean.valueOf(zA));
                            c cVar2 = c.this;
                            if (zA) {
                                com.opos.mobad.video.player.e.a aVar = cVar2.d;
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                aVar.a(i, str, c.this.l, c.this.m, map);
                            } else if (cVar2.d != null) {
                                c.this.d.b(map);
                            } else {
                                c.this.d();
                            }
                        }
                    });
                }

                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return null;
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdShower", "tryShowFallback", e);
            com.opos.mobad.video.player.e.a aVar = this.d;
            if (aVar != null) {
                aVar.b(map);
            } else {
                d();
            }
        }
    }

    private void a(Activity activity) {
        int iJ = com.opos.cmn.an.h.f.a.j(activity);
        int i = 0;
        if (iJ != 0 && iJ != 90 && (iJ == 180 || iJ == 270)) {
            i = 8;
        }
        activity.setRequestedOrientation(i);
    }

    private void a(Activity activity, AdItemData adItemData) {
        if (adItemData != null) {
            int iL = adItemData.L();
            if (iL == 1) {
                a(activity);
            } else {
                if (iL != 2) {
                    return;
                }
                activity.setRequestedOrientation(1);
            }
        }
    }

    private void a(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.getDecorView().setBackgroundColor(1711276032);
        int i = Build.VERSION.SDK_INT;
        window.setStatusBarColor(0);
        window.addFlags(Integer.MIN_VALUE);
        if (i >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (z) {
            com.opos.cmn.an.f.a.b("AdShower", "isFullScreen");
            activity.getTheme().applyStyle(R.style.Theme.Translucent.NoTitleBar.Fullscreen, true);
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(1024 | window.getDecorView().getSystemUiVisibility() | 256 | 4 | 4096);
        }
    }

    public void a(Configuration configuration) {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    private void a(final Window window) {
        window.setBackgroundDrawable(new ColorDrawable(-16777216));
        window.setFlags(1024, 1024);
        window.addFlags(128);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.getDecorView().setSystemUiVisibility(5894);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.video.player.e.c.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (2 == (i & 2) && 4 == (i & 4)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("AdShower", "reset system ui");
                window.getDecorView().setSystemUiVisibility(5894);
            }
        });
    }

    public void a(String str) {
        final FutureTask<Integer> futureTaskA = this.b.j().a(this.b.b(), str);
        if (futureTaskA == null) {
            a(1);
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.e.c.3
                @Override // java.lang.Runnable
                public void run() {
                    int iA;
                    try {
                        iA = ((Integer) futureTaskA.get(c.this.b.n().k(), TimeUnit.MILLISECONDS)).intValue();
                    } catch (Exception unused) {
                        iA = c.this.b.j().a();
                    }
                    c.this.a(iA);
                }
            });
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        com.opos.mobad.video.player.e.a aVar = this.d;
        return aVar != null && aVar.a(i, keyEvent);
    }

    private boolean a(int i, com.opos.mobad.cmn.func.a aVar) {
        String str;
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            str = "checkValidAndSetData false, actionType error";
        } else {
            if (aVar != null) {
                return true;
            }
            str = "checkValidAndSetData false, interactor is null";
        }
        com.opos.cmn.an.f.a.a("AdShower", str);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:4:0x0009, B:7:0x0011, B:19:0x0076, B:20:0x0079, B:16:0x004c, B:17:0x005f, B:22:0x007c), top: B:27:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:4:0x0009, B:7:0x0011, B:19:0x0076, B:20:0x0079, B:16:0x004c, B:17:0x005f, B:22:0x007c), top: B:27:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Activity activity, AdHelper.a aVar, int i, int i2, boolean z, com.opos.mobad.video.player.g.e eVar, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.c cVar, com.opos.mobad.p.a aVar3, com.opos.mobad.cmn.func.adhandler.f fVar) {
        boolean zA;
        if (aVar != null) {
            try {
                if (a(i, aVar2)) {
                    this.f10327a = activity;
                    this.e = i;
                    this.l = aVar.c;
                    this.m = aVar.d;
                    this.f = i2;
                    this.h = aVar2;
                    this.i = cVar;
                    this.j = aVar3;
                    this.k = fVar;
                    com.opos.mobad.video.player.g.b bVar = new com.opos.mobad.video.player.g.b(eVar);
                    this.c = bVar;
                    bVar.a(this.n);
                    if (i == 1) {
                        zA = a(aVar, i2, aVar2, this.c, cVar, aVar3, fVar, false);
                    } else if (i == 2) {
                        zA = a(aVar, i2, z, aVar2, this.c, cVar, fVar);
                    } else if (i != 3) {
                        if (i != 4) {
                            zA = false;
                        }
                    }
                    if (!zA) {
                        d();
                    }
                    this.g = false;
                    return zA;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdShower", bq.b.V, e);
                d();
                return false;
            }
        }
        d();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdHelper.a aVar, int i, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.g.e eVar, com.opos.mobad.video.player.c cVar, com.opos.mobad.p.a aVar3, com.opos.mobad.cmn.func.adhandler.f fVar, boolean z) {
        com.opos.cmn.an.f.a.b("AdShower", "showVideo isFallbackAd=", Boolean.valueOf(z));
        if (this.f10327a == null || aVar == null) {
            return false;
        }
        MaterialData materialData = aVar.d;
        if (materialData != null) {
            com.opos.cmn.an.f.a.b("AdShower", "showVideo templateId=", Integer.valueOf(materialData.b()));
        }
        a(this.f10327a.getWindow());
        this.f10327a.setVolumeControlStream(3);
        a(this.f10327a, aVar.c);
        boolean z2 = aVar.c.w() != 0;
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.mediaplayer.b.d.a(aVar.c.W());
        com.opos.mobad.ui.c.b bVarA = com.opos.mobad.ui.c.b.a();
        Context contextB = this.b.b();
        MaterialData materialData2 = aVar.d;
        com.opos.mobad.template.a aVarA2 = z2 ? bVarA.a(contextB, materialData2, aVarA, (a.InterfaceC0778a) null) : bVarA.b(contextB, materialData2, aVarA, null);
        if (aVarA2 == null || !a(aVar, i, aVar2, eVar, cVar, aVar3, aVarA2, true, false, fVar)) {
            return false;
        }
        if (z2) {
            a(aVar.c.g());
        }
        return true;
    }

    private boolean a(AdHelper.a aVar, int i, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.g.e eVar, com.opos.mobad.video.player.c cVar, com.opos.mobad.p.a aVar3, com.opos.mobad.template.a aVar4, boolean z, boolean z2, com.opos.mobad.cmn.func.adhandler.f fVar) {
        com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar5;
        com.opos.mobad.video.player.c.a aVar6;
        AdItemData adItemData = aVar.c;
        MaterialData materialData = aVar.d;
        String strG = adItemData.g();
        com.opos.mobad.cmn.func.adhandler.a aVar7 = new com.opos.mobad.cmn.func.adhandler.a(this.b, strG, aVar2, fVar);
        if (eVar instanceof g) {
            aVar7.a((g) eVar);
        }
        com.opos.mobad.template.a aVarA = null;
        com.opos.mobad.template.a aVarA2 = com.opos.mobad.video.player.h.b.b.a().a(this.f10327a, materialData, null);
        String strV = adItemData.V();
        com.opos.mobad.ui.feedback.a aVar8 = new com.opos.mobad.ui.feedback.a(this.b.b(), null);
        aVar8.a(strV);
        com.opos.mobad.template.a aVarA3 = com.opos.mobad.video.player.h.b.a.a().a(this.b.b(), adItemData, (a.InterfaceC0778a) null);
        b.a aVarB = new b.a(aVar4, new com.opos.mobad.video.player.b(this.f10327a), aVar8).a(aVarA3).a(z).b(z2).b(aVarA2);
        InteractiveData interactiveDataAd = materialData.ad();
        if (interactiveDataAd != null && interactiveDataAd.h == 0) {
            com.opos.mobad.video.player.c.a aVar9 = new com.opos.mobad.video.player.c.a(this.b, aVar, materialData.ad());
            aVarB.a(aVar9);
            aVar6 = aVar9;
            aVar5 = null;
        } else if (interactiveDataAd != null && interactiveDataAd.h == 1 && adItemData.aj() == 1017) {
            com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVarA4 = com.opos.mobad.video.player.c.a.c.a(this.f10327a);
            aVarA4.a(new a(interactiveDataAd));
            aVarB.a(aVarA4);
            aVar5 = aVarA4;
            aVar6 = null;
        } else {
            aVar5 = null;
            aVar6 = null;
        }
        if (com.opos.mobad.model.utils.e.a(adItemData, materialData)) {
            aVarA = com.opos.mobad.video.player.h.b.c.a().a(this.f10327a, materialData, null);
            aVarB.c(aVarA);
        }
        com.opos.mobad.template.a aVar10 = aVarA;
        d dVar = new d(this.f10327a, this.b, strG, aVar7, aVarB.a(), eVar, aVar3, this.e);
        this.d = com.opos.mobad.video.player.g.c.a(this.e) ? new com.opos.mobad.video.player.e.a.a(dVar) : new com.opos.mobad.video.player.e.a(dVar);
        if (!this.g && com.opos.mobad.video.player.g.c.a(this.e)) {
            this.d.a(new a.InterfaceC0815a() { // from class: com.opos.mobad.video.player.e.c.1
                @Override // com.opos.mobad.video.player.e.a.InterfaceC0815a
                public void a(final int i2, final String str, final Map<String, String> map) {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.e.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(i2, str, map);
                        }
                    });
                }
            });
        }
        this.d.a(adItemData, materialData, i, cVar);
        FrameLayout frameLayout = new FrameLayout(this.b.b());
        frameLayout.addView(aVar4.c());
        if (aVarA3 != null && aVarA3.c() != null) {
            View viewC = aVarA3.c();
            viewC.setVisibility(8);
            frameLayout.addView(viewC);
        }
        if (aVarA2 != null && aVarA2.c() != null) {
            View viewC2 = aVarA2.c();
            viewC2.setVisibility(8);
            frameLayout.addView(viewC2);
        }
        if (aVar10 != null && aVar10.c() != null) {
            View viewC3 = aVar10.c();
            viewC3.setVisibility(0);
            frameLayout.addView(viewC3);
        }
        if (aVar6 != null) {
            View viewA = aVar6.a();
            viewA.setVisibility(8);
            frameLayout.addView(viewA, new ViewGroup.LayoutParams(-1, -1));
        } else if (aVar5 != null && aVar5.a() != null) {
            frameLayout.addView(aVar5.a(), new ViewGroup.LayoutParams(-1, -1));
        }
        this.f10327a.setContentView(frameLayout);
        return true;
    }

    private boolean a(AdHelper.a aVar, int i, boolean z, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.g.e eVar, com.opos.mobad.video.player.c cVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        Activity activity = this.f10327a;
        if (activity == null) {
            com.opos.cmn.an.f.a.b("AdShower", "activity is null");
            return false;
        }
        a(activity, z);
        aVar.c.g();
        Bundle bundle = new Bundle();
        if (e() == 4) {
            bundle.putInt("interstitial_scene", e.b.INSTANT_EXIT.ordinal());
        }
        com.opos.mobad.template.a aVarA = com.opos.mobad.video.player.d.a.a(this.f10327a, aVar.c, aVar.d, bundle, null);
        return aVarA != null && a(aVar, i, aVar2, eVar, cVar, (com.opos.mobad.p.a) null, aVarA, false, true, fVar);
    }
}
