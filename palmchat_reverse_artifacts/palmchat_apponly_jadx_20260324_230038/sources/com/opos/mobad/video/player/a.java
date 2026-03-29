package com.opos.mobad.video.player;

import android.os.RemoteException;
import com.opos.mobad.l.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends a.AbstractBinderC0751a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.l.a f10267a;

    public a(com.opos.mobad.l.a aVar) {
        this.f10267a = aVar;
    }

    @Override // com.opos.mobad.l.a
    public void a() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onReward");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.l.a
    public void b() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onRenderSuccess");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.l.a
    public void c() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onClose");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.opos.mobad.l.a
    public void d() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessStart");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.opos.mobad.l.a
    public void e() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessComplete");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.opos.mobad.l.a
    public void f() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onInstantExit");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void g() {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "destroy");
        this.f10267a = null;
    }

    @Override // com.opos.mobad.l.a
    public void a(int i, String str) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onShowFailed");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    @Override // com.opos.mobad.l.a
    public void a(long j) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onAdClick");
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a(j);
        }
    }

    @Override // com.opos.mobad.l.a
    public void a(long j, boolean z) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessClose currentPos=", Long.valueOf(j), ", isEnd=", Boolean.valueOf(z));
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a(j, z);
        }
    }

    @Override // com.opos.mobad.l.a
    public void a(com.opos.mobad.l.c cVar) throws RemoteException {
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a(cVar);
        }
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "getFallbackAd");
    }

    @Override // com.opos.mobad.l.a
    public void a(String str) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessError err=", str);
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.opos.mobad.l.a
    public void a(String str, com.opos.mobad.l.b bVar) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onAdShow transformData=", str);
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a(str, bVar);
        }
    }

    @Override // com.opos.mobad.l.a
    public void a(Map map) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onDlClick info=", map);
        com.opos.mobad.l.a aVar = this.f10267a;
        if (aVar != null) {
            aVar.a(map);
        }
    }
}
