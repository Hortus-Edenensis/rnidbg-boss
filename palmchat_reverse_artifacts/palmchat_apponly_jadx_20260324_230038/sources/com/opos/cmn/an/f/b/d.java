package com.opos.cmn.an.f.b;

import android.text.TextUtils;
import android.util.Log;
import defpackage.k17;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.f.b.a.b f7768a;
    private e b = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7769a;
        final /* synthetic */ int b;

        public a(Object obj, int i) {
            this.f7769a = obj;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(this.f7769a, this.b);
        }
    }

    private void a(com.opos.cmn.an.f.b.b.c cVar) {
        if (cVar.f7759a.e == 2 && a()) {
            this.f7768a = new com.opos.cmn.an.f.b.a.d();
            if (c.b()) {
                Log.d("LogHandler", "use NearLogImpl");
            }
        }
        if (this.f7768a == null) {
            this.f7768a = new com.opos.cmn.an.f.b.a.a();
            if (c.b()) {
                Log.d("LogHandler", "use BasicLogImpl");
            }
        }
    }

    public void b(Object obj, int i) {
        if (obj != null) {
            try {
                switch (i) {
                    case 1:
                        com.opos.cmn.an.f.b.b.c cVar = (com.opos.cmn.an.f.b.b.c) obj;
                        a(cVar);
                        this.f7768a.a(cVar.f7759a);
                        break;
                    case 2:
                        com.opos.cmn.an.f.b.a.b bVar = this.f7768a;
                        if (bVar != null) {
                            bVar.a((com.opos.cmn.an.f.b.b.d) obj);
                        }
                        break;
                    case 3:
                        com.opos.cmn.an.f.b.a.b bVar2 = this.f7768a;
                        if (bVar2 != null) {
                            com.opos.cmn.an.f.b.b.g gVar = (com.opos.cmn.an.f.b.b.g) obj;
                            bVar2.a(gVar.f7765a, gVar.b);
                        }
                        break;
                    case 4:
                        com.opos.cmn.an.f.b.a.b bVar3 = this.f7768a;
                        if (bVar3 != null) {
                            bVar3.a(((com.opos.cmn.an.f.b.b.b) obj).f7758a);
                        }
                        break;
                    case 5:
                        com.opos.cmn.an.f.b.a.b bVar4 = this.f7768a;
                        if (bVar4 != null) {
                            bVar4.a();
                        }
                        break;
                    case 6:
                        com.opos.cmn.an.f.b.a.b bVar5 = this.f7768a;
                        if (bVar5 != null) {
                            bVar5.a(((com.opos.cmn.an.f.b.b.e) obj).f7763a);
                        }
                        break;
                    case 7:
                        com.opos.cmn.an.f.b.a.b bVar6 = this.f7768a;
                        if (bVar6 != null) {
                            bVar6.b(((com.opos.cmn.an.f.b.b.f) obj).f7764a);
                        }
                        break;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, int i) {
        this.b.a(new a(obj, i));
    }

    private boolean a() {
        try {
            String canonicalName = k17.class.getCanonicalName();
            if (TextUtils.isEmpty(canonicalName) || !c.b()) {
                return true;
            }
            Log.d("LogHandler", canonicalName + " exits");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
