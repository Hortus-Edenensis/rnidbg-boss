package com.opos.mobad.service.d;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.ad.e;
import com.opos.mobad.d.c.a;
import com.opos.mobad.service.c.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements e {
    private static volatile b i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f9214a;
    private boolean b;
    private Context c;
    private com.opos.mobad.d.c.a d;
    private volatile String e = null;
    private volatile String f = null;
    private volatile e.a g = null;
    private volatile com.opos.mobad.d.b.a h = null;

    private b() {
    }

    private e.a a(e.a aVar) {
        final double[] dArr = {0.0d, 0.0d};
        try {
            dArr[0] = ((long) (aVar.getLatitude() * 10000.0d)) / 10000.0d;
            dArr[1] = ((long) (aVar.getLongitude() * 10000.0d)) / 10000.0d;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "translateLocation", e);
        }
        return new e.a() { // from class: com.opos.mobad.service.d.b.3
            @Override // com.opos.mobad.ad.e.a
            public double getLatitude() {
                return dArr[0];
            }

            @Override // com.opos.mobad.ad.e.a
            public double getLongitude() {
                return dArr[1];
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e.a g() {
        if (isCanUseLocation()) {
            if (!com.opos.mobad.service.b.b()) {
                com.opos.mobad.service.b.a(this.c);
            }
            final double[] dArrC = com.opos.mobad.service.b.c();
            return new e.a() { // from class: com.opos.mobad.service.d.b.2
                @Override // com.opos.mobad.ad.e.a
                public double getLatitude() {
                    return dArrC[0];
                }

                @Override // com.opos.mobad.ad.e.a
                public double getLongitude() {
                    return dArrC[1];
                }
            };
        }
        e eVar = this.f9214a;
        if (eVar == null || eVar.getLocation() == null) {
            return null;
        }
        return a(eVar.getLocation());
    }

    @Override // com.opos.mobad.ad.e
    public boolean alist() {
        e eVar;
        if (this.b && (eVar = this.f9214a) != null) {
            return eVar.alist();
        }
        return false;
    }

    public com.opos.mobad.d.b.a c() {
        if (!isCanUseLocation()) {
            return new com.opos.mobad.d.b.a(0.0d, 0.0d, 0L, false);
        }
        if (!com.opos.mobad.service.b.b()) {
            com.opos.mobad.service.b.a(this.c);
        }
        return com.opos.mobad.service.b.d();
    }

    public String d() {
        if (isCanUseAndroidId()) {
            return com.opos.mobad.service.c.a.a().g();
        }
        e eVar = this.f9214a;
        if (eVar == null) {
            return "";
        }
        String androidId = eVar.getAndroidId();
        return TextUtils.isEmpty(androidId) ? "" : androidId;
    }

    public String e() {
        e eVar = this.f9214a;
        if (eVar == null) {
            return null;
        }
        String macAddress = eVar.getMacAddress();
        return TextUtils.isEmpty(macAddress) ? "" : macAddress;
    }

    public long f() {
        long j = isCanUsePhoneState() ? 1L : 0L;
        if (isCanUseLocation()) {
            j |= 2;
        }
        if (isCanUseAndroidId()) {
            j |= 4;
        }
        if (isCanUseWifiState()) {
            j |= 8;
        }
        if (isCanUseWriteExternal()) {
            j |= 16;
        }
        if (alist()) {
            j |= 32;
        }
        if (getMinorsMode() != 0) {
            j |= 128;
        }
        return getMinorsModeEnable() != 0 ? j | 256 : j;
    }

    @Override // com.opos.mobad.ad.e
    public String getAndroidId() {
        if (this.f == null) {
            this.f = d();
        } else {
            this.d.a();
        }
        return this.f;
    }

    @Override // com.opos.mobad.ad.e
    public String getDevImei() {
        a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
        return c0768aM != null ? c0768aM.f9210a : "";
    }

    @Override // com.opos.mobad.ad.e
    public e.a getLocation() {
        if (this.g == null) {
            this.g = g();
        } else {
            this.d.a();
        }
        return this.g;
    }

    @Override // com.opos.mobad.ad.e
    public String getMacAddress() {
        if (this.e == null) {
            this.e = e();
        } else {
            this.d.a();
        }
        return this.e;
    }

    @Override // com.opos.mobad.ad.e
    public int getMinorsMode() {
        e eVar = this.f9214a;
        if (eVar == null) {
            return 0;
        }
        return eVar.getMinorsMode();
    }

    @Override // com.opos.mobad.ad.e
    public int getMinorsModeAgeRange() {
        e eVar = this.f9214a;
        if (eVar == null) {
            return 0;
        }
        return eVar.getMinorsModeAgeRange();
    }

    @Override // com.opos.mobad.ad.e
    public int getMinorsModeEnable() {
        e eVar = this.f9214a;
        if (eVar == null) {
            return 0;
        }
        return eVar.getMinorsModeEnable();
    }

    @Override // com.opos.mobad.ad.e
    public boolean isCanUseAndroidId() {
        e eVar;
        if (this.b && (eVar = this.f9214a) != null) {
            return eVar.isCanUseAndroidId();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public boolean isCanUseLocation() {
        e eVar;
        if (this.b && (eVar = this.f9214a) != null) {
            return eVar.isCanUseLocation();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public boolean isCanUsePhoneState() {
        e eVar;
        if (this.b && (eVar = this.f9214a) != null) {
            return eVar.isCanUsePhoneState();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public boolean isCanUseWifiState() {
        e eVar;
        if (this.b && (eVar = this.f9214a) != null) {
            return eVar.isCanUseWifiState();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e
    public boolean isCanUseWriteExternal() {
        e eVar;
        if (this.b && (eVar = this.f9214a) != null) {
            return eVar.isCanUseWriteExternal();
        }
        return false;
    }

    public void b() {
        this.c = null;
        this.f9214a = null;
        this.b = false;
    }

    public static b a() {
        b bVar = i;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = i;
                if (bVar == null) {
                    bVar = new b();
                    i = bVar;
                }
            }
        }
        return bVar;
    }

    public void a(Context context, e eVar, boolean z) {
        this.c = context;
        this.f9214a = eVar;
        this.b = z;
        this.d = new com.opos.mobad.d.c.a(new a.c() { // from class: com.opos.mobad.service.d.b.1
            @Override // com.opos.mobad.d.c.a.c
            public void a(final a.InterfaceC0734a interfaceC0734a) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b bVar = b.this;
                            bVar.f = bVar.d();
                            b bVar2 = b.this;
                            bVar2.e = bVar2.e();
                            b bVar3 = b.this;
                            bVar3.g = bVar3.g();
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
                        }
                        interfaceC0734a.a();
                    }
                });
            }
        }, Integer.MAX_VALUE, 10000);
    }
}
