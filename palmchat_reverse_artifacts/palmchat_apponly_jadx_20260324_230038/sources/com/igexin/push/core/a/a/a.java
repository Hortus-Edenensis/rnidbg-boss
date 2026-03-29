package com.igexin.push.core.a.a;

import com.igexin.push.core.j;
import com.igexin.push.d.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a extends com.igexin.push.core.a.a {
    private static final String b = "HeartbeatAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (!(obj instanceof com.igexin.push.d.c.f)) {
            return true;
        }
        c.b.f7311a.d();
        com.igexin.c.a.c.a.a("heartbeatRsp", new Object[0]);
        j.a().a(j.a.f7288a);
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }
}
