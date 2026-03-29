package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8270a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List<a> h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8271a;
        public final long b;
        public final long c;

        private a(int i, long j, long j2) {
            this.f8271a = i;
            this.b = j;
            this.c = j2;
        }

        public static a a(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f8271a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
        }

        public /* synthetic */ a(int i, long j, long j2, b bVar) {
            this(i, j, j2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    }

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.f8270a = j;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = j2;
        this.g = j3;
        this.h = Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j4;
        this.k = i;
        this.l = i2;
        this.m = i3;
    }

    public static SpliceInsertCommand a(p pVar, long j, w wVar) {
        List list;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int iH;
        int iG;
        int iG2;
        boolean z4;
        boolean z5;
        long jM;
        long jM2 = pVar.m();
        boolean z6 = (pVar.g() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z6) {
            list = listEmptyList;
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            iH = 0;
            iG = 0;
            iG2 = 0;
            z4 = false;
        } else {
            int iG3 = pVar.g();
            boolean z7 = (iG3 & 128) != 0;
            boolean z8 = (iG3 & 64) != 0;
            boolean z9 = (iG3 & 32) != 0;
            boolean z10 = (iG3 & 16) != 0;
            long jA = (!z8 || z10) ? -9223372036854775807L : TimeSignalCommand.a(pVar, j);
            if (!z8) {
                int iG4 = pVar.g();
                ArrayList arrayList = new ArrayList(iG4);
                for (int i = 0; i < iG4; i++) {
                    int iG5 = pVar.g();
                    long jA2 = !z10 ? TimeSignalCommand.a(pVar, j) : -9223372036854775807L;
                    arrayList.add(new a(iG5, jA2, wVar.d(jA2), null));
                }
                listEmptyList = arrayList;
            }
            if (z9) {
                long jG = pVar.g();
                boolean z11 = (128 & jG) != 0;
                jM = ((((jG & 1) << 32) | pVar.m()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                jM = -9223372036854775807L;
            }
            iH = pVar.h();
            z4 = z8;
            iG = pVar.g();
            iG2 = pVar.g();
            list = listEmptyList;
            long j4 = jA;
            z3 = z5;
            j3 = jM;
            z2 = z10;
            z = z7;
            j2 = j4;
        }
        return new SpliceInsertCommand(jM2, z6, z, z4, z2, j2, wVar.d(j2), list, z3, j3, iH, iG, iG2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f8270a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.h.get(i2).b(parcel);
        }
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f8270a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.e = parcel.readByte() == 1;
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(a.a(parcel));
        }
        this.h = Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, b bVar) {
        this(parcel);
    }
}
