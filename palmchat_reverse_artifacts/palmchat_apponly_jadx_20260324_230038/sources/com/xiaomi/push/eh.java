package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class eh implements ef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ef f11536a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static eh f11537a = new eh();
    }

    public static eh a() {
        return a.f11537a;
    }

    private eh() {
    }

    @Override // com.xiaomi.push.ef
    public void a(ee eeVar) {
        ef efVar = this.f11536a;
        if (efVar != null) {
            efVar.a(eeVar);
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(String str, Map<String, Object> map) {
        ef efVar = this.f11536a;
        if (efVar != null) {
            efVar.a(str, map);
        }
    }
}
