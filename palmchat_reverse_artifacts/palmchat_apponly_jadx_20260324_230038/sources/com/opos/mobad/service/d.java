package com.opos.mobad.service;

import android.content.Context;
import com.opos.cmn.an.custom.policy.PolicyConfig;
import com.opos.cmn.an.custom.policy.PolicyManager;
import com.opos.mobad.service.d.d;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f9211a = new d();
    private boolean b = false;
    private com.opos.mobad.service.a.a d = new com.opos.mobad.service.a.a();
    private f c = new f("");

    private d() {
    }

    public static final synchronized void a() {
        d dVar = f9211a;
        f9211a = new d();
        dVar.d();
    }

    public static final com.opos.mobad.service.a.a b() {
        return f9211a.d;
    }

    private static void c() {
        HashMap map = new HashMap();
        map.put(PolicyConfig.UserData.KEY_IMEI, Boolean.FALSE);
        PolicyManager.getInstance().setPolicyConfig(new PolicyConfig.Builder().setCanReadUserDataMap(map).build());
    }

    private void d() {
        b.a();
        com.opos.mobad.service.d.d.a().t();
        com.opos.cmn.c.a.a();
        com.opos.mobad.service.d.b.a().b();
    }

    private static void a(final Context context) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.func.a.a.b.a().a(context);
            }
        });
    }

    public static void a(Context context, d.InterfaceC0771d interfaceC0771d, d.g gVar, d.f fVar, d.e eVar, com.opos.mobad.ad.e eVar2) {
        if (!com.opos.cmn.an.f.a.b(context) && eVar2.isCanUseLocation()) {
            b.a(context);
        }
        com.opos.mobad.service.d.d.a().a(context, interfaceC0771d, gVar, fVar, eVar);
        com.opos.cmn.c.a.b();
        com.opos.mobad.downloader.f.a().a(context);
    }

    private static void a(final Context context, final boolean z, final boolean z2) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.opos.mobad.provider.init.a(context).a(z, z2, com.opos.cmn.biz.a.d.a(context));
                } catch (BridgeDispatchException | BridgeExecuteException e) {
                    com.opos.cmn.an.f.a.d("ServiceManager", "initContentProvider", e);
                }
            }
        });
    }

    public static void a(Context context, boolean z, boolean z2, String str) {
        c();
        com.opos.cmn.c.a.a(context, z, z2);
        a(context, z, z2);
        com.opos.cmn.a.a.a(z, str);
    }

    public static void a(Context context, boolean z, boolean z2, boolean z3, com.opos.mobad.ad.e eVar) {
        if (z3) {
            com.opos.cmn.a.a.c();
        }
        a(context);
        com.opos.mobad.service.c.a.a().a(context, z2, eVar);
        com.opos.mobad.service.c.a.a().a(z);
        com.opos.mobad.service.d.b.a().a(context, eVar, z);
    }
}
