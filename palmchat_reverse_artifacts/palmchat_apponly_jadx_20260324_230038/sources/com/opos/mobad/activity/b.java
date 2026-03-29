package com.opos.mobad.activity;

import android.os.RemoteException;
import com.opos.mobad.p.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends a.AbstractBinderC0760a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.p.a f8472a;

    public b(com.opos.mobad.p.a aVar) {
        this.f8472a = aVar;
    }

    @Override // com.opos.mobad.p.a
    public void a() throws RemoteException {
        com.opos.mobad.p.a aVar = this.f8472a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b() {
        this.f8472a = null;
    }

    @Override // com.opos.mobad.p.a
    public void a(com.opos.mobad.p.b bVar) throws RemoteException {
        com.opos.mobad.p.a aVar = this.f8472a;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    @Override // com.opos.mobad.p.a
    public void a(Map map) throws RemoteException {
        com.opos.mobad.p.a aVar = this.f8472a;
        if (aVar != null) {
            aVar.a(map);
        }
    }
}
