package com.opos.mobad.j;

import android.view.View;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8942a;
    private com.opos.mobad.b b;
    private String c;
    private AdItemData d;
    private MaterialData e;
    private long h;
    private int k;
    private long f = -1;
    private boolean g = false;
    private boolean i = false;
    private boolean j = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(long j);

        void a(String str);

        void b();

        void c();
    }

    public d(com.opos.mobad.b bVar, String str, a aVar) {
        this.f8942a = aVar;
        this.b = bVar;
        this.c = str;
    }

    private float b(long j, long j2) {
        if (0 != j) {
            return j2 / (j * 1.0f);
        }
        return 0.0f;
    }

    private long c(long j) {
        return j > 0 ? j : this.h;
    }

    private void b() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f8942a != null) {
                    d.this.f8942a.b();
                }
            }
        });
    }

    public void a() {
        this.g = true;
    }

    private void b(long j) {
        try {
            if (this.g) {
                return;
            }
            b.b(this.b, this.c, this.d, this.e, true, j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(final int i, String str, Map<String, String> map) {
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "onPlayError code=", Integer.valueOf(i), ", msg=", str, "extra=", map);
        try {
            if (this.g) {
                return;
            }
            com.opos.mobad.cmn.func.b.e.a(this.b, this.c, this.d, this.e, true, String.valueOf(this.k), com.opos.mobad.cmn.func.b.e.a(i, str, map));
            final String strA = com.opos.mobad.ad.a.a(i);
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.g || d.this.f8942a == null) {
                        return;
                    }
                    a aVar = d.this.f8942a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("code=");
                    sb.append(i);
                    sb.append(",msg=");
                    String str2 = strA;
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append(str2);
                    aVar.a(sb.toString());
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("VideoPlayPresenter", "onPlayError", e);
        }
    }

    public void a(long j) {
        try {
            if (this.g) {
                return;
            }
            if (this.i) {
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "video has complete");
                return;
            }
            b.a(this.b, this.c, this.d, this.e, true, c(j));
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f8942a != null) {
                        d.this.f8942a.c();
                    }
                }
            });
            this.i = true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(long j, long j2) {
        MaterialData materialData;
        com.opos.mobad.b bVar;
        String str;
        AdItemData adItemData;
        MaterialData materialData2;
        boolean z;
        String str2;
        try {
            if (this.g) {
                return;
            }
            if (this.i) {
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "onProcess but has completed");
                return;
            }
            if (j2 <= 0) {
                j2 = this.h;
            } else if (!this.j && (materialData = this.e) != null && materialData.D() != null && this.e.D().size() > 0 && Math.abs(this.e.s() - j2) >= 2000) {
                this.j = true;
                this.b.i().a(this.e.X(), this.e.D().get(0).a(), this.e.s(), j2);
            }
            long j3 = j2;
            if (this.f == -1) {
                b();
            }
            if (a(j3, j, 0.25f)) {
                bVar = this.b;
                str = this.c;
                adItemData = this.d;
                materialData2 = this.e;
                z = true;
                str2 = "25";
            } else if (a(j3, j, 0.5f)) {
                bVar = this.b;
                str = this.c;
                adItemData = this.d;
                materialData2 = this.e;
                z = true;
                str2 = "50";
            } else if (!a(j3, j, 0.75f)) {
                if (this.f == -1) {
                    b(j3);
                }
                this.f = j;
            } else {
                bVar = this.b;
                str = this.c;
                adItemData = this.d;
                materialData2 = this.e;
                z = true;
                str2 = "75";
            }
            b.a(bVar, str, adItemData, materialData2, z, str2, (int) j, j3);
            this.f = j;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(View view, int[] iArr, final long j) {
        try {
            if (this.g) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.g || d.this.f8942a == null) {
                        return;
                    }
                    d.this.f8942a.a(j);
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i) {
        this.d = adItemData;
        this.e = materialData;
        this.f = -1L;
        this.i = false;
        if (j <= 0) {
            this.h = materialData.s();
        } else {
            this.h = j;
        }
        this.j = false;
        this.k = i;
    }

    private boolean a(long j, long j2, float f) {
        float fB;
        boolean z;
        float fB2;
        float f2 = 0.0f;
        if (0 != j) {
            try {
                fB = b(j, this.f);
            } catch (Exception e) {
                e = e;
                fB = 0.0f;
            }
            try {
                fB2 = b(j, j2);
            } catch (Exception e2) {
                e = e2;
                com.opos.cmn.an.f.a.c("VideoPlayPresenter", "meetVideoPercent() fail", e);
                z = false;
            }
            if (fB < f && fB2 >= f) {
                f2 = fB;
                z = true;
                fB = f2;
                f2 = fB2;
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "meetVideoPercent()", Float.valueOf(fB), Float.valueOf(f2), "p=", Float.valueOf(f), "result=", Boolean.valueOf(z));
                return z;
            }
            f2 = fB;
        } else {
            fB2 = 0.0f;
        }
        z = false;
        fB = f2;
        f2 = fB2;
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "meetVideoPercent()", Float.valueOf(fB), Float.valueOf(f2), "p=", Float.valueOf(f), "result=", Boolean.valueOf(z));
        return z;
    }
}
