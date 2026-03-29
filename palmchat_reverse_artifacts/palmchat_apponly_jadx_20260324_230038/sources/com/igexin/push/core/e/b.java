package com.igexin.push.core.e;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.g.p;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements a {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, byte[]> f7218a = new HashMap();

    private b() {
    }

    private static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private String a(byte[] bArr) {
        String strA;
        do {
            strA = p.a();
        } while (this.f7218a.containsKey(strA));
        this.f7218a.put(strA, bArr);
        return strA;
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    private synchronized byte[] a(String str) {
        byte[] bArr;
        bArr = this.f7218a.get(str);
        if (bArr != null) {
            this.f7218a.remove(str);
        }
        return bArr;
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
    }
}
