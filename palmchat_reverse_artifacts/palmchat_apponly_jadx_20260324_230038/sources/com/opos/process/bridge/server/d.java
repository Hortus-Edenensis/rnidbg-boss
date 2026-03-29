package com.opos.process.bridge.server;

import android.app.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f10388a = new d();
    private List<Service> b = Collections.synchronizedList(new ArrayList());

    private d() {
    }

    public static d a() {
        return f10388a;
    }

    public boolean b(Service service) {
        return this.b.remove(service);
    }

    public boolean a(Service service) {
        return this.b.add(service);
    }
}
