package com.opos.mobad.video.player.h.b;

import android.app.Activity;
import com.opos.mobad.d.a;
import com.opos.mobad.downloader.f;
import com.opos.mobad.mediaplayer.b.d;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.a;
import com.opos.mobad.template.f.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static volatile b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.d.a f10374a = new com.opos.mobad.d.a() { // from class: com.opos.mobad.video.player.h.b.b.1
        @Override // com.opos.mobad.d.a
        public void a(String str, String str2, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
            f.a().a(str, str2, i, i2, interfaceC0732a);
        }

        @Override // com.opos.mobad.d.a
        public void a(String str, String str2, a.InterfaceC0732a interfaceC0732a) {
            f.a().a(str, str2, interfaceC0732a);
        }
    };

    private b() {
    }

    public com.opos.mobad.template.a a(Activity activity, MaterialData materialData, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.d.d.a aVarA = d.a(activity, null);
        m mVarB = a(activity, materialData) ? m.b(activity, aVarA, b.f10374a, -10007) : m.a(activity, aVarA, b.f10374a, -10008);
        mVarB.a(interfaceC0778a);
        return mVarB;
    }

    public static b a() {
        b bVar = b;
        if (bVar == null) {
            synchronized (a.class) {
                bVar = b;
                if (bVar == null) {
                    bVar = new b();
                    b = bVar;
                }
            }
        }
        return bVar;
    }

    private boolean a(Activity activity, MaterialData materialData) {
        if (materialData == null) {
            return false;
        }
        int iB = materialData.b();
        return iB == 7 || iB == 12 || iB == 14 || iB == 2007;
    }
}
