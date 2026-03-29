package com.bykv.vk.openvk.component.video.u.u.u;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.sdk.component.b.x;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.s;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kuaishou.weapon.p0.t;
import com.wifi.ad.core.config.EventParams;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr implements fx {
    private static final HashMap<String, nr> u = new HashMap<>();
    private File b;
    private long iz;
    private RandomAccessFile jk;
    private nr l;
    private com.bykv.vk.openvk.component.video.api.fx.nr mv;
    private volatile long nr;
    private File pn;
    private final iz t;
    private final Object fx = new Object();
    private volatile long x = -1;
    private volatile boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f4975a = false;
    private AtomicBoolean s = new AtomicBoolean(false);

    public nr(Context context, com.bykv.vk.openvk.component.video.api.fx.nr nrVar, iz izVar) {
        this.nr = -2147483648L;
        this.iz = 0L;
        this.jk = null;
        this.t = izVar;
        this.mv = nrVar;
        try {
            this.b = com.bykv.vk.openvk.component.video.u.pn.fx.nr(izVar.pn(), izVar.o());
            this.pn = com.bykv.vk.openvk.component.video.u.pn.fx.fx(izVar.pn(), izVar.o());
            if (x()) {
                this.jk = new RandomAccessFile(this.pn, t.k);
            } else {
                this.jk = new RandomAccessFile(this.b, "rw");
            }
            if (x()) {
                return;
            }
            long length = this.b.length();
            this.iz = length;
            if (length == izVar.l() && this.iz != 0) {
                boolean zU = com.bykv.vk.openvk.component.video.api.iz.nr.u(com.bykv.vk.openvk.component.video.api.iz.nr.u(this.b), izVar.o());
                izVar.o();
                if (zU) {
                    u(this.iz);
                    this.nr = this.iz;
                    return;
                }
            }
            if (!b()) {
                pn();
                return;
            }
            synchronized (nr.class) {
                if (iz()) {
                    n();
                } else {
                    nr nrVar2 = this.l;
                    if (nrVar2 != null) {
                        this.nr = nrVar2.u();
                    }
                }
            }
        } catch (Throwable unused) {
            izVar.my();
        }
    }

    private long a() {
        return x() ? this.pn.length() : this.b.length();
    }

    private boolean b() {
        RandomAccessFile randomAccessFile = this.jk;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            if (fileLockTryLock == null) {
                if (fileLockTryLock != null) {
                    try {
                        fileLockTryLock.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            try {
                fileLockTryLock.close();
                return true;
            } catch (IOException unused2) {
                return true;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    private boolean iz() {
        String strPn = pn();
        synchronized (nr.class) {
            HashMap<String, nr> map = u;
            nr nrVar = map.get(strPn);
            this.l = nrVar;
            if (nrVar != null) {
                return false;
            }
            map.put(strPn, this);
            return true;
        }
    }

    private void n() {
        l.u uVarNr = com.bykv.vk.openvk.component.video.api.fx.fx() != null ? com.bykv.vk.openvk.component.video.api.fx.fx().nr() : new l.u("v_cache");
        long jBg = this.t.bg();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        uVarNr.u(jBg, timeUnit).nr(this.t.bq(), timeUnit).fx(this.t.dw(), timeUnit);
        l lVarU = uVarNr.u();
        this.t.o();
        lVarU.u(new s.u().u("RANGE", "bytes=" + this.iz + "-").u(this.t.my()).u().nr()).u(new com.bytedance.sdk.component.nr.u.fx() { // from class: com.bykv.vk.openvk.component.video.u.u.u.nr.1
            @Override // com.bytedance.sdk.component.nr.u.fx
            public void onFailure(com.bytedance.sdk.component.nr.u.nr nrVar, IOException iOException) {
                nr.this.f4975a = false;
                nr.this.nr = -1L;
                nr.this.u(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:100:0x01e1, code lost:
            
                r0 = r19.u;
                r0.u(r0.nr);
             */
            /* JADX WARN: Code restructure failed: missing block: B:101:0x01ea, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:203:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:204:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:205:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:206:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:91:0x01b4, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x01b7, code lost:
            
                if (r6 == null) goto L94;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x01b9, code lost:
            
                r6.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x01bc, code lost:
            
                r21.close();
                r2 = r19.u.b.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x01cf, code lost:
            
                if (r19.u.f4975a == false) goto L203;
             */
            /* JADX WARN: Code restructure failed: missing block: B:97:0x01d9, code lost:
            
                if (r2 != r19.u.nr) goto L204;
             */
            /* JADX WARN: Code restructure failed: missing block: B:99:0x01df, code lost:
            
                if (r2 <= 0) goto L205;
             */
            @Override // com.bytedance.sdk.component.nr.u.fx
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(com.bytedance.sdk.component.nr.u.nr nrVar, my myVar) throws IOException {
                o oVarIz;
                InputStream inputStream;
                nr nrVar2;
                if (myVar != null) {
                    InputStream inputStreamFx = null;
                    try {
                        try {
                            nr.this.f4975a = myVar.b();
                        } catch (Throwable unused) {
                            oVarIz = null;
                            inputStream = null;
                        }
                        if (nr.this.f4975a) {
                            oVarIz = myVar.iz();
                            try {
                                if (nr.this.f4975a && oVarIz != null) {
                                    nr.this.nr = oVarIz.u() + nr.this.iz;
                                    inputStreamFx = oVarIz.fx();
                                }
                                inputStream = inputStreamFx;
                            } catch (Throwable unused2) {
                                inputStream = null;
                            }
                            if (inputStream == null) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused3) {
                                        return;
                                    }
                                }
                                if (oVarIz != null) {
                                    oVarIz.close();
                                }
                                myVar.close();
                                long length = nr.this.b.length();
                                if (nr.this.f4975a && length == nr.this.nr && length > 0) {
                                    nr nrVar3 = nr.this;
                                    nrVar3.u(nrVar3.nr);
                                    return;
                                }
                                return;
                            }
                            try {
                                byte[] bArr = new byte[8192];
                                long j = nr.this.iz;
                                FileChannel channel = nr.this.jk.getChannel();
                                FileDescriptor fd = nr.this.jk.getFD();
                                if (!fd.valid()) {
                                    nr.this.t.o();
                                    try {
                                        inputStream.close();
                                        if (oVarIz != null) {
                                            oVarIz.close();
                                        }
                                        myVar.close();
                                        long length2 = nr.this.b.length();
                                        if (nr.this.f4975a && length2 == nr.this.nr && length2 > 0) {
                                            nr nrVar4 = nr.this;
                                            nrVar4.u(nrVar4.nr);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable unused4) {
                                        return;
                                    }
                                }
                                if (!channel.isOpen()) {
                                    try {
                                        inputStream.close();
                                        if (oVarIz != null) {
                                            oVarIz.close();
                                        }
                                        myVar.close();
                                        long length3 = nr.this.b.length();
                                        if (nr.this.f4975a && length3 == nr.this.nr && length3 > 0) {
                                            nr nrVar5 = nr.this;
                                            nrVar5.u(nrVar5.nr);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable unused5) {
                                        return;
                                    }
                                }
                                long j2 = 0;
                                loop0: while (true) {
                                    int i = 0;
                                    do {
                                        int i2 = inputStream.read(bArr, i, 8192 - i);
                                        if (i2 == -1) {
                                            long unused6 = nr.this.iz;
                                            long unused7 = nr.this.nr;
                                            int i3 = (j2 > (nr.this.nr - nr.this.iz) ? 1 : (j2 == (nr.this.nr - nr.this.iz) ? 0 : -1));
                                            nr.this.t.my();
                                            inputStreamFx = inputStream;
                                            break loop0;
                                        }
                                        i += i2;
                                        j2 += (long) i2;
                                    } while (!(j2 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j2 == nr.this.nr - nr.this.iz));
                                    synchronized (nr.this.fx) {
                                        if (nr.this.n) {
                                            nr.this.t.o();
                                        } else if (com.bykv.vk.openvk.component.video.u.pn.fx.u(nr.this.jk, bArr, j, i)) {
                                            j += (long) i;
                                        } else {
                                            nr.this.t.o();
                                            fd.valid();
                                            channel.isOpen();
                                        }
                                    }
                                    try {
                                        inputStream.close();
                                        if (oVarIz != null) {
                                            oVarIz.close();
                                        }
                                        myVar.close();
                                        long length4 = nr.this.b.length();
                                        if (nr.this.f4975a && length4 == nr.this.nr && length4 > 0) {
                                            nr nrVar6 = nr.this;
                                            nrVar6.u(nrVar6.nr);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable unused8) {
                                        return;
                                    }
                                }
                            } catch (Throwable unused9) {
                                try {
                                    nr.this.f4975a = false;
                                    nr nrVar7 = nr.this;
                                    nrVar7.nr = nrVar7.x;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (oVarIz != null) {
                                        oVarIz.close();
                                    }
                                    myVar.close();
                                    long length5 = nr.this.b.length();
                                    if (nr.this.f4975a && length5 == nr.this.nr && length5 > 0) {
                                        nrVar2 = nr.this;
                                    }
                                    nr.this.u(true);
                                } catch (Throwable th) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused10) {
                                            throw th;
                                        }
                                    }
                                    if (oVarIz != null) {
                                        oVarIz.close();
                                    }
                                    myVar.close();
                                    long length6 = nr.this.b.length();
                                    if (nr.this.f4975a && length6 == nr.this.nr && length6 > 0) {
                                        nr nrVar8 = nr.this;
                                        nrVar8.u(nrVar8.nr);
                                    }
                                    throw th;
                                }
                            }
                            nrVar2.u(nrVar2.nr);
                        } else {
                            nr.this.f4975a = false;
                            nr nrVar9 = nr.this;
                            nrVar9.nr = nrVar9.x;
                            oVarIz = null;
                        }
                        if (inputStreamFx != null) {
                            inputStreamFx.close();
                        }
                        if (oVarIz != null) {
                            oVarIz.close();
                        }
                        myVar.close();
                        long length7 = nr.this.b.length();
                        if (nr.this.f4975a && length7 == nr.this.nr && length7 > 0) {
                            nrVar2 = nr.this;
                            nrVar2.u(nrVar2.nr);
                        }
                    } catch (Throwable unused11) {
                    }
                } else {
                    nr.this.f4975a = false;
                    nr nrVar10 = nr.this;
                    nrVar10.nr = nrVar10.x;
                }
                nr.this.u(true);
            }
        });
    }

    private String pn() {
        iz izVar = this.t;
        return izVar == null ? "" : izVar.o();
    }

    private boolean x() {
        return this.pn.exists() && this.pn.length() > 0;
    }

    @Override // com.bykv.vk.openvk.component.video.u.u.u.fx
    public long fx() throws IOException {
        if (!x()) {
            synchronized (this.fx) {
                int i = 0;
                do {
                    if (this.nr == -2147483648L) {
                        try {
                            nr nrVar = this.l;
                            if (nrVar != null) {
                                this.nr = nrVar.u();
                            }
                            i += 15;
                            this.fx.wait(5L);
                        } catch (InterruptedException unused) {
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        this.nr = this.pn.length();
        return this.nr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        String strPn = pn();
        synchronized (nr.class) {
            if (z) {
                u.remove(strPn);
            } else {
                HashMap<String, nr> map = u;
                if (map.get(strPn) == this) {
                    map.remove(strPn);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.u.u.fx
    public void nr() {
        try {
            if (!this.n) {
                this.jk.close();
            }
            File file = this.b;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.pn;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
        u(false);
        synchronized (this.fx) {
            this.n = true;
        }
    }

    public long u() {
        return this.nr;
    }

    private void u(long j, long j2, long j3, long j4, boolean z, long j5) {
        x xVar;
        if ((z || this.s.compareAndSet(false, true)) && (xVar = (x) com.bytedance.sdk.openadsdk.ats.fx.u("event")) != null) {
            JSONObject jSONObject = new JSONObject();
            com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.mv;
            if (nrVar != null) {
                jSONObject = nrVar.u();
            }
            try {
                jSONObject.put("totalLength", j);
                jSONObject.put(EventParams.KEY_CT_SDK_POSITION, j2);
                jSONObject.put("cacheLength", j3);
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, j4);
                iz izVar = this.t;
                if (izVar != null) {
                    jSONObject.put("videoUrl", izVar.my());
                }
                jSONObject.put("startSaveLength", j5);
            } catch (Exception unused) {
            }
            xVar.onExceptionEvent("video_wait", jSONObject, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x006e A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:? -> B:36:0x0092). Please report as a decompilation issue!!! */
    @Override // com.bykv.vk.openvk.component.video.u.u.u.fx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int u(long j, byte[] bArr, int i, int i2) throws IOException {
        Object obj;
        try {
            if (j == this.nr) {
                return -1;
            }
            int i3 = 0;
            long j2 = -1;
            int i4 = 0;
            while (!this.n) {
                Object obj2 = this.fx;
                synchronized (obj2) {
                    try {
                        long jA = a();
                        long j3 = j2 == -1 ? jA : j2;
                        if (j < jA) {
                            this.jk.seek(j);
                            i4 = this.jk.read(bArr, i, i2);
                        } else {
                            i3 += 33;
                            this.fx.wait(33L);
                            if (i3 >= 4000) {
                                obj = obj2;
                                try {
                                    u(this.nr, j, jA, i3, false, j3);
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                            if (i4 <= 0) {
                                return i4;
                            }
                            if (i3 >= 10000) {
                                u(this.nr, j, a(), i3, true, j3);
                                throw new SocketTimeoutException();
                            }
                            j2 = j3;
                        }
                        obj = obj2;
                        if (i4 <= 0) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj2;
                        throw th;
                    }
                }
            }
            return -1;
        } catch (Throwable th3) {
            if (th3 instanceof IOException) {
                throw th3;
            }
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j) throws IOException {
        synchronized (this.fx) {
            if (this.pn.exists() && this.pn.length() >= j) {
                this.t.my();
                this.t.o();
                return;
            }
            if (this.b.renameTo(this.pn)) {
                RandomAccessFile randomAccessFile = this.jk;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (!this.n) {
                    this.jk = new RandomAccessFile(this.pn, "rw");
                }
                this.t.o();
                this.t.my();
                return;
            }
            throw new IOException("Error renaming file " + this.b + " to " + this.pn + " for completion!");
        }
    }
}
