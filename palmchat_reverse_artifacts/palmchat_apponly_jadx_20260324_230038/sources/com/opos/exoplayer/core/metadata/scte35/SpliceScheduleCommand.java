package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.util.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f8272a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8273a;
        public final long b;

        private a(int i, long j) {
            this.f8273a = i;
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeInt(this.f8273a);
            parcel.writeLong(this.b);
        }

        public /* synthetic */ a(int i, long j, c cVar) {
            this(i, j);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8274a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final List<a> f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        private b(long j, boolean z, boolean z2, boolean z3, List<a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.f8274a = j;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.f = Collections.unmodifiableList(list);
            this.e = j2;
            this.g = z4;
            this.h = j3;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(p pVar) {
            ArrayList arrayList;
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i;
            int i2;
            int iG;
            boolean z3;
            boolean z4;
            long jM;
            long jM2 = pVar.m();
            boolean z5 = (pVar.g() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z5) {
                arrayList = arrayList2;
                z = false;
                j = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                iG = 0;
                z3 = false;
            } else {
                int iG2 = pVar.g();
                boolean z6 = (iG2 & 128) != 0;
                boolean z7 = (iG2 & 64) != 0;
                boolean z8 = (iG2 & 32) != 0;
                long jM3 = z7 ? pVar.m() : -9223372036854775807L;
                if (!z7) {
                    int iG3 = pVar.g();
                    ArrayList arrayList3 = new ArrayList(iG3);
                    for (int i3 = 0; i3 < iG3; i3++) {
                        arrayList3.add(new a(pVar.g(), pVar.m(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long jG = pVar.g();
                    boolean z9 = (128 & jG) != 0;
                    jM = ((((jG & 1) << 32) | pVar.m()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    jM = -9223372036854775807L;
                }
                int iH = pVar.h();
                int iG4 = pVar.g();
                z3 = z7;
                iG = pVar.g();
                j2 = jM;
                arrayList = arrayList2;
                long j3 = jM3;
                i = iH;
                i2 = iG4;
                j = j3;
                boolean z10 = z6;
                z2 = z4;
                z = z10;
            }
            return new b(jM2, z5, z, z3, arrayList, j, z2, j2, i, i2, iG);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel);
        }

        private b(Parcel parcel) {
            this.f8274a = parcel.readLong();
            this.b = parcel.readByte() == 1;
            this.c = parcel.readByte() == 1;
            this.d = parcel.readByte() == 1;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(a.b(parcel));
            }
            this.f = Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Parcel parcel) {
            parcel.writeLong(this.f8274a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            int size = this.f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.f.get(i).c(parcel);
            }
            parcel.writeLong(this.e);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(b.c(parcel));
        }
        this.f8272a = Collections.unmodifiableList(arrayList);
    }

    public static SpliceScheduleCommand a(p pVar) {
        int iG = pVar.g();
        ArrayList arrayList = new ArrayList(iG);
        for (int i = 0; i < iG; i++) {
            arrayList.add(b.b(pVar));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f8272a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f8272a.get(i2).b(parcel);
        }
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, c cVar) {
        this(parcel);
    }

    private SpliceScheduleCommand(List<b> list) {
        this.f8272a = Collections.unmodifiableList(list);
    }
}
