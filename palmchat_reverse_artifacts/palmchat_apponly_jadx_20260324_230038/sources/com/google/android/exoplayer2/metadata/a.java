package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import defpackage.f12;
import defpackage.g86;
import defpackage.qo3;
import defpackage.qv4;
import defpackage.ro3;
import defpackage.so3;
import defpackage.to3;
import defpackage.vh;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a extends e implements Handler.Callback {
    public final ro3 p;
    public final to3 q;

    @Nullable
    public final Handler r;
    public final so3 s;
    public final boolean t;

    @Nullable
    public qo3 u;
    public boolean v;
    public boolean w;
    public long x;

    @Nullable
    public Metadata y;
    public long z;

    public a(to3 to3Var, @Nullable Looper looper) {
        this(to3Var, looper, ro3.f20517a);
    }

    public final void A(Metadata metadata, List<Metadata.Entry> list) {
        for (int i = 0; i < metadata.length(); i++) {
            m wrappedMetadataFormat = metadata.get(i).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.p.a(wrappedMetadataFormat)) {
                list.add(metadata.get(i));
            } else {
                qo3 qo3VarB = this.p.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) vh.e(metadata.get(i).getWrappedMetadataBytes());
                this.s.b();
                this.s.m(bArr.length);
                ((ByteBuffer) g86.j(this.s.c)).put(bArr);
                this.s.n();
                Metadata metadataA = qo3VarB.a(this.s);
                if (metadataA != null) {
                    A(metadataA, list);
                }
            }
        }
    }

    public final long B(long j) {
        vh.g(j != -9223372036854775807L);
        vh.g(this.z != -9223372036854775807L);
        return j - this.z;
    }

    public final void C(Metadata metadata) {
        Handler handler = this.r;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            D(metadata);
        }
    }

    public final void D(Metadata metadata) {
        this.q.f(metadata);
    }

    public final boolean E(long j) {
        boolean z;
        Metadata metadata = this.y;
        if (metadata == null || (!this.t && metadata.presentationTimeUs > B(j))) {
            z = false;
        } else {
            C(this.y);
            this.y = null;
            z = true;
        }
        if (this.v && this.y == null) {
            this.w = true;
        }
        return z;
    }

    public final void F() {
        if (this.v || this.y != null) {
            return;
        }
        this.s.b();
        f12 f12VarJ = j();
        int iX = x(f12VarJ, this.s, 0);
        if (iX != -4) {
            if (iX == -5) {
                this.x = ((m) vh.e(f12VarJ.b)).p;
            }
        } else {
            if (this.s.g()) {
                this.v = true;
                return;
            }
            so3 so3Var = this.s;
            so3Var.i = this.x;
            so3Var.n();
            Metadata metadataA = ((qo3) g86.j(this.u)).a(this.s);
            if (metadataA != null) {
                ArrayList arrayList = new ArrayList(metadataA.length());
                A(metadataA, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.y = new Metadata(B(this.s.e), arrayList);
            }
        }
    }

    @Override // com.google.android.exoplayer2.a0
    public int a(m mVar) {
        if (this.p.a(mVar)) {
            return qv4.a(mVar.H == 0 ? 4 : 2);
        }
        return qv4.a(0);
    }

    @Override // com.google.android.exoplayer2.z, com.google.android.exoplayer2.a0
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        D((Metadata) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isEnded() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e
    public void o() {
        this.y = null;
        this.u = null;
        this.z = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.e
    public void q(long j, boolean z) {
        this.y = null;
        this.v = false;
        this.w = false;
    }

    @Override // com.google.android.exoplayer2.z
    public void render(long j, long j2) {
        boolean zE = true;
        while (zE) {
            F();
            zE = E(j);
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void w(m[] mVarArr, long j, long j2) {
        this.u = this.p.b(mVarArr[0]);
        Metadata metadata = this.y;
        if (metadata != null) {
            this.y = metadata.copyWithPresentationTimeUs((metadata.presentationTimeUs + this.z) - j2);
        }
        this.z = j2;
    }

    public a(to3 to3Var, @Nullable Looper looper, ro3 ro3Var) {
        this(to3Var, looper, ro3Var, false);
    }

    public a(to3 to3Var, @Nullable Looper looper, ro3 ro3Var, boolean z) {
        super(5);
        this.q = (to3) vh.e(to3Var);
        this.r = looper == null ? null : g86.v(looper, this);
        this.p = (ro3) vh.e(ro3Var);
        this.t = z;
        this.s = new so3();
        this.z = -9223372036854775807L;
    }
}
