package com.amap.api.col.p0002sl;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class hy extends fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f2881a;
    protected gd b;
    protected byte[] c;

    public hy(Context context, gd gdVar) {
        if (context != null) {
            this.f2881a = context.getApplicationContext();
        }
        this.b = gdVar;
        t();
    }

    private static byte[] C() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(ge.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                ha.a(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    ha.a(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ha.a(th3, "bre", "gbh");
                }
            }
        }
    }

    private byte[] D() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (k()) {
                Context context = this.f2881a;
                boolean zM = m();
                gd gdVar = this.b;
                byte[] bArrA = fu.a(context, zM, gdVar != null && "navi".equals(gdVar.a()));
                byteArrayOutputStream.write(a(bArrA));
                byteArrayOutputStream.write(bArrA);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] bArrA2 = ge.a(i());
            if (bArrA2 == null || bArrA2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(bArrA2));
                byteArrayOutputStream.write(bArrA2);
            }
            byte[] bArrA3 = ge.a(l());
            if (bArrA3 == null || bArrA3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(bArrA3));
                byteArrayOutputStream.write(bArrA3);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                ha.a(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    ha.a(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ha.a(th3, "bre", "gred");
                }
            }
        }
    }

    private byte[] E() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArrB = b();
            if (bArrB != null && bArrB.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(a(bArrB));
                byteArrayOutputStream.write(bArrB);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ha.a(th, "bre", "grrd");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                ha.a(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ha.a(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    ha.a(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] F() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArrG = g();
            if (bArrG != null && bArrG.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] bArrA = fu.a(bArrG);
                byteArrayOutputStream.write(a(bArrA));
                byteArrayOutputStream.write(bArrA);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ha.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                ha.a(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ha.a(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    ha.a(th4, "bre", "gred");
                }
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        return ge.a(bArr.length);
    }

    public abstract byte[] b();

    @Override // com.amap.api.col.p0002sl.id
    public Map<String, String> e() {
        String strF = fr.f(this.f2881a);
        String strA = fu.a();
        String strA2 = fu.a(this.f2881a, strA, "key=".concat(String.valueOf(strF)));
        HashMap map = new HashMap();
        map.put("ts", strA);
        map.put("key", strF);
        map.put("scode", strA2);
        return map;
    }

    public abstract byte[] g();

    @Override // com.amap.api.col.p0002sl.id
    public final byte[] h() {
        byte[] bArr = this.c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(C());
            byteArrayOutputStream.write(D());
            byteArrayOutputStream.write(E());
            byteArrayOutputStream.write(F());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.c = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                ha.a(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    ha.a(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    ha.a(th3, "bre", "geb");
                }
            }
        }
    }

    public String i() {
        return "2.1";
    }

    public boolean k() {
        return true;
    }

    public String l() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.c(), this.b.a());
    }

    public boolean m() {
        return false;
    }
}
