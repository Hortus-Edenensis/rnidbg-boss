package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements Parcelable {
    public static final Parcelable.Creator<nr> CREATOR = new Parcelable.Creator<nr>() { // from class: com.ss.android.socialbase.downloader.model.nr.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public nr createFromParcel(Parcel parcel) {
            return new nr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public nr[] newArray(int i) {
            return new nr[i];
        }
    };
    private static final String u = "nr";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10620a;
    private AtomicLong b;
    private long fx;
    private long iz;
    private List<nr> jk;
    private com.ss.android.socialbase.downloader.a.nr k;
    private int l;
    private boolean mv;
    private AtomicInteger n;
    private int nr;
    private long pn;
    private AtomicBoolean s;
    private nr t;
    private int x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private long b;
        private long fx;
        private int iz;
        private nr n;
        private long nr;
        private long pn;
        private int u;
        private long x;

        public u(int i) {
            this.u = i;
        }

        public u b(long j) {
            this.pn = j;
            return this;
        }

        public u fx(long j) {
            this.b = j;
            return this;
        }

        public u nr(long j) {
            this.fx = j;
            return this;
        }

        public u pn(long j) {
            this.x = j;
            return this;
        }

        public u u(long j) {
            this.nr = j;
            return this;
        }

        public u u(int i) {
            this.iz = i;
            return this;
        }

        public u u(nr nrVar) {
            this.n = nrVar;
            return this;
        }

        public nr u() {
            return new nr(this);
        }
    }

    public boolean a() {
        long j = this.fx;
        if (b()) {
            long j2 = this.f10620a;
            if (j2 > this.fx) {
                j = j2;
            }
        }
        return s() - j >= this.iz;
    }

    public boolean b() {
        return nr() == -1;
    }

    public int bg() {
        return this.x;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean fx() {
        AtomicBoolean atomicBoolean = this.s;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean iz() {
        List<nr> list = this.jk;
        return list != null && list.size() > 0;
    }

    public long jk() {
        nr nrVar = this.t;
        if (nrVar != null && nrVar.x() != null) {
            int iIndexOf = this.t.x().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.t.x().size(); i++) {
                nr nrVar2 = this.t.x().get(i);
                if (nrVar2 != null) {
                    if (z) {
                        return nrVar2.s();
                    }
                    if (iIndexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public long k() {
        long jS = s() - this.fx;
        if (iz()) {
            jS = 0;
            for (int i = 0; i < this.jk.size(); i++) {
                nr nrVar = this.jk.get(i);
                if (nrVar != null) {
                    jS += nrVar.s() - nrVar.l();
                }
            }
        }
        return jS;
    }

    public long l() {
        return this.fx;
    }

    public long mv() {
        AtomicLong atomicLong = this.b;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long my() {
        return this.pn;
    }

    public boolean n() {
        nr nrVar = this.t;
        if (nrVar == null) {
            return true;
        }
        if (!nrVar.iz()) {
            return false;
        }
        for (int i = 0; i < this.t.x().size(); i++) {
            nr nrVar2 = this.t.x().get(i);
            if (nrVar2 != null) {
                int iIndexOf = this.t.x().indexOf(this);
                if (iIndexOf > i && !nrVar2.a()) {
                    return false;
                }
                if (iIndexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public int nr() {
        AtomicInteger atomicInteger = this.n;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public long o() {
        return this.iz;
    }

    public nr pn() {
        nr nrVar = !b() ? this.t : this;
        if (nrVar == null || !nrVar.iz()) {
            return null;
        }
        return nrVar.x().get(0);
    }

    public long s() {
        if (!b() || !iz()) {
            return mv();
        }
        long jMv = 0;
        for (int i = 0; i < this.jk.size(); i++) {
            nr nrVar = this.jk.get(i);
            if (nrVar != null) {
                if (!nrVar.a()) {
                    return nrVar.mv();
                }
                if (jMv < nrVar.mv()) {
                    jMv = nrVar.mv();
                }
            }
        }
        return jMv;
    }

    public void sx() {
        this.f10620a = s();
    }

    public int t() {
        return this.nr;
    }

    public ContentValues u() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.nr));
        contentValues.put("chunkIndex", Integer.valueOf(this.x));
        contentValues.put("startOffset", Long.valueOf(this.fx));
        contentValues.put("curOffset", Long.valueOf(s()));
        contentValues.put("endOffset", Long.valueOf(this.pn));
        contentValues.put("chunkContentLen", Long.valueOf(this.iz));
        contentValues.put("hostChunkIndex", Integer.valueOf(nr()));
        return contentValues;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.nr);
        parcel.writeLong(this.fx);
        AtomicLong atomicLong = this.b;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.pn);
        parcel.writeLong(this.iz);
        parcel.writeInt(this.x);
        AtomicInteger atomicInteger = this.n;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public List<nr> x() {
        return this.jk;
    }

    private nr(u uVar) {
        if (uVar == null) {
            return;
        }
        this.nr = uVar.u;
        this.fx = uVar.nr;
        this.b = new AtomicLong(uVar.fx);
        this.pn = uVar.b;
        this.iz = uVar.pn;
        this.x = uVar.iz;
        this.f10620a = uVar.x;
        this.n = new AtomicInteger(-1);
        u(uVar.n);
        this.s = new AtomicBoolean(false);
    }

    public void fx(int i) {
        this.x = i;
    }

    public void nr(boolean z) {
        this.mv = z;
    }

    public long fx(boolean z) {
        long jS = s();
        long j = this.iz;
        long j2 = this.f10620a;
        long j3 = j - (jS - j2);
        if (!z && jS == j2) {
            j3 = j - (jS - this.fx);
        }
        com.ss.android.socialbase.downloader.fx.u.nr("DownloadChunk", "contentLength:" + this.iz + " curOffset:" + s() + " oldOffset:" + this.f10620a + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void nr(int i) {
        this.nr = i;
    }

    public void nr(long j) {
        AtomicLong atomicLong = this.b;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.b = new AtomicLong(j);
        }
    }

    public void u(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.l = 0;
        sQLiteStatement.clearBindings();
        int i = this.l + 1;
        this.l = i;
        sQLiteStatement.bindLong(i, this.nr);
        int i2 = this.l + 1;
        this.l = i2;
        sQLiteStatement.bindLong(i2, this.x);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.fx);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, s());
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, this.pn);
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.iz);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, nr());
    }

    public nr(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.nr = cursor.getInt(cursor.getColumnIndex("_id"));
        this.x = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.fx = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.b = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.b = new AtomicLong(0L);
        }
        this.pn = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.n = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.n = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.iz = cursor.getLong(columnIndex3);
        }
        this.s = new AtomicBoolean(false);
    }

    public void u(int i) {
        AtomicInteger atomicInteger = this.n;
        if (atomicInteger == null) {
            this.n = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public void u(com.ss.android.socialbase.downloader.a.nr nrVar) {
        this.k = nrVar;
        sx();
    }

    public void u(boolean z) {
        AtomicBoolean atomicBoolean = this.s;
        if (atomicBoolean == null) {
            this.s = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.k = null;
    }

    public nr(Parcel parcel) {
        this.nr = parcel.readInt();
        this.fx = parcel.readLong();
        this.b = new AtomicLong(parcel.readLong());
        this.pn = parcel.readLong();
        this.iz = parcel.readLong();
        this.x = parcel.readInt();
        this.n = new AtomicInteger(parcel.readInt());
    }

    public void u(nr nrVar) {
        this.t = nrVar;
        if (nrVar != null) {
            u(nrVar.bg());
        }
    }

    public void u(List<nr> list) {
        this.jk = list;
    }

    public void u(long j) {
        this.iz = j;
    }

    public List<nr> u(int i, long j) {
        nr nrVar;
        long jMy;
        long jL;
        long j2;
        long j3;
        nr nrVar2 = this;
        int i2 = i;
        if (!b() || iz()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jMv = mv();
        long jFx = nrVar2.fx(true);
        long j4 = jFx / ((long) i2);
        com.ss.android.socialbase.downloader.fx.u.nr(u, "retainLen:" + jFx + " divideChunkForReuse chunkSize:" + j4 + " current host downloadChunk index:" + nrVar2.x);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                jL = l();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long jMy2 = my();
                    j2 = jMy2;
                    j3 = jMy2 > jMv ? (jMy2 - jMv) + 1 : jFx - (((long) i4) * j4);
                    jL = jMv;
                    long j5 = jFx;
                    long j6 = j3;
                    nr nrVarU = new u(nrVar2.nr).u((-i3) - 1).u(jL).nr(jMv).pn(jMv).fx(j2).b(j6).u(nrVar2).u();
                    com.ss.android.socialbase.downloader.fx.u.nr(u, "divide sub chunk : " + i3 + " startOffset:" + jL + " curOffset:" + jMv + " endOffset:" + j2 + " contentLen:" + j6);
                    arrayList.add(nrVarU);
                    jMv += j4;
                    i3++;
                    nrVar2 = this;
                    i2 = i;
                    jFx = j5;
                } else {
                    jL = jMv;
                }
            }
            j2 = (jMv + j4) - 1;
            j3 = j4;
            long j52 = jFx;
            long j62 = j3;
            nr nrVarU2 = new u(nrVar2.nr).u((-i3) - 1).u(jL).nr(jMv).pn(jMv).fx(j2).b(j62).u(nrVar2).u();
            com.ss.android.socialbase.downloader.fx.u.nr(u, "divide sub chunk : " + i3 + " startOffset:" + jL + " curOffset:" + jMv + " endOffset:" + j2 + " contentLen:" + j62);
            arrayList.add(nrVarU2);
            jMv += j4;
            i3++;
            nrVar2 = this;
            i2 = i;
            jFx = j52;
        }
        long jO = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            nr nrVar3 = arrayList.get(size);
            if (nrVar3 != null) {
                jO += nrVar3.o();
            }
        }
        com.ss.android.socialbase.downloader.fx.u.nr(u, "reuseChunkContentLen:".concat(String.valueOf(jO)));
        nr nrVar4 = arrayList.get(0);
        if (nrVar4 != null) {
            if (my() == 0) {
                jMy = j - l();
            } else {
                jMy = (my() - l()) + 1;
            }
            nrVar4.u(jMy - jO);
            nrVar = this;
            nrVar4.fx(nrVar.x);
            com.ss.android.socialbase.downloader.a.nr nrVar5 = nrVar.k;
            if (nrVar5 != null) {
                nrVar5.u(nrVar4.my(), o() - jO);
            }
        } else {
            nrVar = this;
        }
        nrVar.u(arrayList);
        return arrayList;
    }
}
