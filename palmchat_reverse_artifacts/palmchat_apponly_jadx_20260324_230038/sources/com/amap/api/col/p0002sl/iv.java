package com.amap.api.col.p0002sl;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class iv extends iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2917a;
    private String b;

    public iv(String str, iz izVar) {
        super(izVar);
        this.f2917a = 30;
        this.b = str;
    }

    @Override // com.amap.api.col.p0002sl.iz
    public final boolean a() {
        return a(this.b) >= this.f2917a;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            hd.c(th, "fus", "gfn");
            return 0;
        }
    }
}
