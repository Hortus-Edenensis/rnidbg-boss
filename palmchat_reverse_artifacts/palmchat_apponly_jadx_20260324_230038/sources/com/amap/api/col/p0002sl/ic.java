package com.amap.api.col.p0002sl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p0002sl.id;
import com.amap.api.maps2d.AMapException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ic extends hx {
    private static ic f;
    private Handler g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Handler {
        public /* synthetic */ a(Looper looper, byte b) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    private ic() {
        try {
            if (Looper.myLooper() == null) {
                this.g = new a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.g = new a();
            }
        } catch (Throwable th) {
            hd.c(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    private static ie a(id idVar, id.b bVar, int i) throws fq {
        try {
            hx.f(idVar);
            idVar.a(bVar);
            idVar.c(i);
            return new ia().a(idVar);
        } catch (fq e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fq(AMapException.ERROR_UNKNOWN);
        }
    }

    public static ic b() {
        return c();
    }

    private static synchronized ic c() {
        try {
        } finally {
        }
        if (f == null) {
            f = new ic();
        }
        return f;
    }

    @Deprecated
    private static ie e(id idVar, boolean z) throws fq {
        byte[] bArr;
        hx.f(idVar);
        idVar.a(z ? id.c.HTTPS : id.c.HTTP);
        ie ieVarA = null;
        long jElapsedRealtime = 0;
        boolean z2 = false;
        if (hx.d(idVar)) {
            boolean zE = hx.e(idVar);
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                ieVarA = a(idVar, hx.b(idVar, zE), hx.d(idVar, zE));
            } catch (fq e) {
                if ((e.f() == 21 && idVar.r() == id.a.INTERRUPT_IO) || !zE) {
                    throw e;
                }
                z2 = true;
            }
        }
        return (ieVarA == null || (bArr = ieVarA.f2902a) == null || bArr.length <= 0) ? a(idVar, hx.c(idVar, z2), hx.a(idVar, jElapsedRealtime)) : ieVarA;
    }

    @Deprecated
    public static byte[] g(id idVar) throws fq {
        try {
            ie ieVarE = e(idVar, false);
            if (ieVarE != null) {
                return ieVarE.f2902a;
            }
            return null;
        } catch (fq e) {
            throw e;
        }
    }

    @Deprecated
    public static byte[] h(id idVar) throws fq {
        try {
            ie ieVarE = e(idVar, true);
            if (ieVarE != null) {
                return ieVarE.f2902a;
            }
            return null;
        } catch (fq e) {
            throw e;
        }
    }

    public static ie i(id idVar) throws fq {
        return e(idVar, idVar.u());
    }

    @Override // com.amap.api.col.p0002sl.hx
    @Deprecated
    public final byte[] b(id idVar) throws fq {
        try {
            ie ieVarA = hx.a(idVar, false);
            if (ieVarA != null) {
                return ieVarA.f2902a;
            }
            return null;
        } catch (fq e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            hd.d().b(th, "NetManager", "makeSyncPostRequest");
            throw new fq(AMapException.ERROR_UNKNOWN);
        }
    }
}
