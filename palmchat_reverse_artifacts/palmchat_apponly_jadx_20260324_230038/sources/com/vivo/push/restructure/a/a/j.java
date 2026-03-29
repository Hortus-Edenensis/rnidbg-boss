package com.vivo.push.restructure.a.a;

import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class j implements i<com.vivo.push.restructure.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11265a;
    private n b;
    private k c;
    private com.vivo.push.restructure.c.a d;

    public j(n nVar, k kVar, com.vivo.push.restructure.c.a aVar) {
        this.b = nVar;
        this.c = kVar;
        this.d = aVar;
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* synthetic */ void a(a aVar, com.vivo.push.restructure.a.a aVar2, int i) {
        com.vivo.push.restructure.a.a aVar3 = aVar2;
        if (aVar3 == null) {
            t.a("onNodeError() receivedMsg is null ");
            return;
        }
        t.a("onNodeError() , msgID = " + aVar3.a() + ", nodeName = " + aVar.b());
        com.vivo.push.restructure.c.a aVar4 = this.d;
        if (aVar4 != null) {
            aVar4.a(i, aVar3.a());
        }
        a2(aVar3);
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* bridge */ /* synthetic */ void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.a.a aVar2 = aVar;
        if (aVar2 == null) {
            t.a("onAllNodeExecuteComplete, receivedMsg is null");
        } else if (this.f11265a == null) {
            t.a("onAllNodeExecuteComplete, mFirstNode is null");
        } else {
            a2(aVar2);
        }
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final void a(a aVar) {
        this.f11265a = aVar;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.vivo.push.restructure.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!aVar.e()) {
            t.a("core is not support monitor report");
            return;
        }
        t.a("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + aVar.f());
        if (aVar.f()) {
            n nVar = this.b;
            if (nVar != null) {
                nVar.a(aVar, this.f11265a);
            }
            k kVar = this.c;
            if (kVar != null) {
                kVar.a(aVar, this.f11265a.c().toString());
                t.a("reportNodeMonitorInfo() , report client NodeInfo！！！");
            } else {
                t.a("onNodeError , mReporter is null， can not report");
            }
        }
    }
}
