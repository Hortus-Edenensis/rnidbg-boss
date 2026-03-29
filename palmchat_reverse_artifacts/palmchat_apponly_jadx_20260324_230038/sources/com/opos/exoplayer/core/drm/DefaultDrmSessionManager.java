package com.opos.exoplayer.core.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.opos.exoplayer.core.C;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.drm.DrmSession;
import com.opos.exoplayer.core.drm.a;
import com.opos.exoplayer.core.drm.c;
import com.opos.exoplayer.core.util.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(18)
public class DefaultDrmSessionManager<T extends com.opos.exoplayer.core.drm.c> implements a.InterfaceC0686a<T>, com.opos.exoplayer.core.drm.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile DefaultDrmSessionManager<T>.d f8138a;
    private final UUID b;
    private final com.opos.exoplayer.core.drm.d<T> c;
    private final g d;
    private final HashMap<String, String> e;
    private final Handler f;
    private final a g;
    private final boolean h;
    private final int i;
    private final List<com.opos.exoplayer.core.drm.a<T>> j;
    private final List<com.opos.exoplayer.core.drm.a<T>> k;
    private Looper l;
    private int m;
    private byte[] n;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(Exception exc);

        void b();

        void c();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.opos.exoplayer.core.util.b {
        private b(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }

        @Override // com.opos.exoplayer.core.util.b
        public String a() {
            return "MissingSchemeDataException";
        }

        public /* synthetic */ b(UUID uuid, c cVar) {
            this(uuid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8139a;

        public c(b bVar) {
            this.f8139a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultDrmSessionManager.this.g.a(this.f8139a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (com.opos.exoplayer.core.drm.a aVar : DefaultDrmSessionManager.this.j) {
                if (aVar.b(bArr)) {
                    aVar.a(message.what);
                    return;
                }
            }
        }
    }

    private static String b(DrmInitData.SchemeData schemeData, UUID uuid) {
        String str = schemeData.f8142a;
        return (y.f8407a >= 26 || !C.d.equals(uuid)) ? str : ("video/mp4".equals(str) || "audio/mp4".equals(str)) ? "cenc" : str;
    }

    private static DrmInitData.SchemeData a(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.b);
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= drmInitData.b) {
                break;
            }
            DrmInitData.SchemeData schemeDataA = drmInitData.a(i);
            if (!schemeDataA.a(uuid) && (!C.d.equals(uuid) || !schemeDataA.a(C.c))) {
                z2 = false;
            }
            if (z2 && (schemeDataA.b != null || z)) {
                arrayList.add(schemeDataA);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (C.e.equals(uuid)) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) arrayList.get(i2);
                int iB = schemeData.a() ? com.opos.exoplayer.core.extractor.mp4.b.b(schemeData.b) : -1;
                int i3 = y.f8407a;
                if (i3 < 23 && iB == 0) {
                    return schemeData;
                }
                if (i3 >= 23 && iB == 1) {
                    return schemeData;
                }
            }
        }
        return (DrmInitData.SchemeData) arrayList.get(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.opos.exoplayer.core.drm.DefaultDrmSessionManager$c] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.opos.exoplayer.core.drm.a] */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // com.opos.exoplayer.core.drm.b
    public DrmSession<T> a(Looper looper, DrmInitData drmInitData) {
        byte[] bArr;
        String strB;
        com.opos.exoplayer.core.drm.a<T> next;
        Looper looper2 = this.l;
        com.opos.exoplayer.core.util.a.b(looper2 == null || looper2 == looper);
        if (this.j.isEmpty()) {
            this.l = looper;
            if (this.f8138a == null) {
                this.f8138a = new d(looper);
            }
        }
        ?? r2 = 0;
        r2 = 0;
        if (this.n == null) {
            DrmInitData.SchemeData schemeDataA = a(drmInitData, this.b, false);
            if (schemeDataA == null) {
                b bVar = new b(this.b, r2);
                Handler handler = this.f;
                if (handler != null && this.g != null) {
                    handler.post(new c(bVar));
                }
                return new j(new DrmSession.a(bVar));
            }
            byte[] bArrA = a(schemeDataA, this.b);
            strB = b(schemeDataA, this.b);
            bArr = bArrA;
        } else {
            bArr = null;
            strB = null;
        }
        if (!this.h) {
            if (!this.j.isEmpty()) {
                r2 = this.j.get(0);
            }
        } else {
            Iterator<com.opos.exoplayer.core.drm.a<T>> it = this.j.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next.a(bArr)) {
                    break;
                }
            }
        }
        next = (DrmSession<T>) r2;
        if (next == null) {
            com.opos.exoplayer.core.drm.a<T> aVar = new com.opos.exoplayer.core.drm.a<>(this.b, this.c, this, bArr, strB, this.m, this.n, this.e, this.d, looper, this.f, this.g, this.i);
            this.j.add(aVar);
            next = aVar;
        }
        next.a();
        return next;
    }

    @Override // com.opos.exoplayer.core.drm.a.InterfaceC0686a
    public void a() {
        Iterator<com.opos.exoplayer.core.drm.a<T>> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.k.clear();
    }

    @Override // com.opos.exoplayer.core.drm.b
    public void a(DrmSession<T> drmSession) {
        if (drmSession instanceof j) {
            return;
        }
        com.opos.exoplayer.core.drm.a<T> aVar = (com.opos.exoplayer.core.drm.a) drmSession;
        if (aVar.b()) {
            this.j.remove(aVar);
            if (this.k.size() > 1 && this.k.get(0) == aVar) {
                this.k.get(1).c();
            }
            this.k.remove(aVar);
        }
    }

    @Override // com.opos.exoplayer.core.drm.a.InterfaceC0686a
    public void a(com.opos.exoplayer.core.drm.a<T> aVar) {
        this.k.add(aVar);
        if (this.k.size() == 1) {
            aVar.c();
        }
    }

    @Override // com.opos.exoplayer.core.drm.a.InterfaceC0686a
    public void a(Exception exc) {
        Iterator<com.opos.exoplayer.core.drm.a<T>> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().a(exc);
        }
        this.k.clear();
    }

    @Override // com.opos.exoplayer.core.drm.b
    public boolean a(@NonNull DrmInitData drmInitData) {
        if (this.n != null) {
            return true;
        }
        if (a(drmInitData, this.b, true) == null) {
            if (drmInitData.b != 1 || !drmInitData.a(0).a(C.c)) {
                return false;
            }
            com.opos.cmn.an.f.a.c("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.b);
        }
        String str = drmInitData.f8141a;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return !("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) || y.f8407a >= 24;
    }

    private static byte[] a(DrmInitData.SchemeData schemeData, UUID uuid) {
        byte[] bArrA;
        byte[] bArr = schemeData.b;
        return (y.f8407a >= 21 || (bArrA = com.opos.exoplayer.core.extractor.mp4.b.a(bArr, uuid)) == null) ? bArr : bArrA;
    }
}
