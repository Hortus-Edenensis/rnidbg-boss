package com.opos.cmn.an.f.b.a;

import android.util.Log;
import com.opos.cmn.an.f.c.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.f.a.b f7751a;
    private int b = -1;

    @Override // com.opos.cmn.an.f.b.a.b
    public void a() {
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(int i) {
        if (f.b() || f.j()) {
            i = 1;
        }
        this.b = i;
    }

    private void a(int i, String str, String str2) {
        if (i == 1) {
            Log.v(str, str2);
            return;
        }
        if (i == 2) {
            Log.d(str, str2);
            return;
        }
        if (i == 3) {
            Log.i(str, str2);
        } else if (i == 4) {
            Log.w(str, str2);
        } else {
            if (i != 5) {
                return;
            }
            Log.e(str, str2);
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.a.b bVar) {
        int i;
        this.f7751a = bVar;
        try {
            f.a();
            f.c(bVar.g);
            if (f.b() || f.j()) {
                com.opos.cmn.an.f.b.c.a();
                f.c();
                i = 1;
            } else {
                i = this.f7751a.c;
            }
            this.b = i;
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
        if (aVar != null) {
            aVar.onDontNeedUpload("basicLog cannot support upload log!");
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.b.b.d dVar) {
        int i;
        if (dVar == null || dVar.b == null || dVar.f7761a == null) {
            return;
        }
        int i2 = dVar.d;
        try {
            if (!com.opos.cmn.an.f.b.c.b() || (i = this.b) == -1 || i2 < i) {
                return;
            }
            String strA = f.a(dVar);
            if (strA.length() <= 3072) {
                a(i2, this.f7751a.f7744a, strA);
                return;
            }
            int length = strA.length();
            int i3 = 0;
            while (length > i3) {
                int i4 = i3 + 3072;
                if (length <= i4) {
                    i4 = length;
                }
                a(i2, this.f7751a.f7744a, strA.substring(i3, i4));
                i3 = i4;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(boolean z) {
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void b(int i) {
    }
}
