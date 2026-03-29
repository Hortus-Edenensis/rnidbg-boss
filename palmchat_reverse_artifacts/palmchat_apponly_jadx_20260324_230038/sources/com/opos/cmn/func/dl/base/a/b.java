package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.c.d;
import com.opos.cmn.func.dl.base.e;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7965a;
    int b;
    public int c;
    String d;
    public String e;
    public String f;
    String g;
    public String h;
    public File i;
    public File j;
    public long k;
    public long l;
    public boolean m;
    boolean n;
    public boolean o;
    e p;
    public DownloadRequest q;
    public d.a r;
    public AtomicLong s = new AtomicLong();
    private File t;
    private int u;

    public b(DownloadRequest downloadRequest, e eVar) {
        this.q = downloadRequest;
        this.p = eVar;
        this.e = downloadRequest.f7955a;
        this.d = downloadRequest.e;
        this.b = downloadRequest.d;
        this.c = downloadRequest.f;
        this.h = downloadRequest.c;
        this.g = downloadRequest.b;
        this.o = downloadRequest.g;
        this.f7965a = eVar.e();
        this.r = eVar.h();
        this.u = eVar.a();
        String strA = com.opos.cmn.func.dl.base.i.a.a(this.e);
        this.i = new File(this.g, strA + ".cmn_v2_pos");
        this.j = new File(this.g, strA + ".cmn_v2_tmp");
    }

    public final File a() {
        File file = this.t;
        if (file != null) {
            return file;
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = com.opos.cmn.func.dl.base.i.a.d(this.e);
        }
        File file2 = new File(this.g, this.h);
        this.t = file2;
        return file2;
    }

    public final String toString() {
        return "DownloadInfo{mContext=" + this.f7965a + ", priority=" + this.b + ", downloadId=" + this.c + ", mMd5='" + this.d + "', mUrl='" + this.e + "', mRedrictUrl='" + this.f + "', mDirPath='" + this.g + "', mFileName='" + this.h + "', mPosFile=" + this.i + ", mTempFile=" + this.j + ", mTotalLength=" + this.k + ", mStartLenght=" + this.l + ", writeThreadCount=" + this.u + ", isAcceptRange=" + this.m + ", allowDownload=" + this.n + ", mManager=" + this.p + ", mRequest=" + this.q + ", mConnFactory=" + this.r + ", mCurrentLength=" + this.s + '}';
    }

    public final void a(long j) {
        this.s.set(j);
    }
}
