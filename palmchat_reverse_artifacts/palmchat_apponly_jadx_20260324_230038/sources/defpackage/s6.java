package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import defpackage.s6;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class s6 implements f {
    public static final s6 g = new s6(null, new a[0], 0, -9223372036854775807L, 0);
    public static final a h = new a(0).k(0);
    public static final String i = g86.w0(1);
    public static final String j = g86.w0(2);
    public static final String k = g86.w0(3);
    public static final String l = g86.w0(4);
    public static final f.a<s6> m = new f.a() { // from class: q6
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return s6.b(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f20671a;
    public final int b;
    public final long c;
    public final long d;
    public final int e;
    public final a[] f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements f {
        public static final String i = g86.w0(0);
        public static final String j = g86.w0(1);
        public static final String k = g86.w0(2);
        public static final String l = g86.w0(3);
        public static final String m = g86.w0(4);
        public static final String n = g86.w0(5);
        public static final String o = g86.w0(6);
        public static final String p = g86.w0(7);
        public static final f.a<a> q = new f.a() { // from class: r6
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return s6.a.e(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f20672a;
        public final int b;
        public final int c;
        public final Uri[] d;
        public final int[] e;
        public final long[] f;
        public final long g;
        public final boolean h;

        public a(long j2) {
            this(j2, -1, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        @CheckResult
        public static long[] c(long[] jArr, int i2) {
            int length = jArr.length;
            int iMax = Math.max(i2, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        @CheckResult
        public static int[] d(int[] iArr, int i2) {
            int length = iArr.length;
            int iMax = Math.max(i2, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public static a e(Bundle bundle) {
            long j2 = bundle.getLong(i);
            int i2 = bundle.getInt(j);
            int i3 = bundle.getInt(p);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(k);
            int[] intArray = bundle.getIntArray(l);
            long[] longArray = bundle.getLongArray(m);
            long j3 = bundle.getLong(n);
            boolean z = bundle.getBoolean(o);
            if (intArray == null) {
                intArray = new int[0];
            }
            return new a(j2, i2, i3, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j3, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f20672a == aVar.f20672a && this.b == aVar.b && this.c == aVar.c && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e) && Arrays.equals(this.f, aVar.f) && this.g == aVar.g && this.h == aVar.h;
        }

        public int f() {
            return g(-1);
        }

        public int g(@IntRange(from = -1) int i2) {
            int i3;
            int i4 = i2 + 1;
            while (true) {
                int[] iArr = this.e;
                if (i4 >= iArr.length || this.h || (i3 = iArr[i4]) == 0 || i3 == 1) {
                    break;
                }
                i4++;
            }
            return i4;
        }

        public boolean h() {
            if (this.b == -1) {
                return true;
            }
            for (int i2 = 0; i2 < this.b; i2++) {
                int i3 = this.e[i2];
                if (i3 == 0 || i3 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.b * 31) + this.c) * 31;
            long j2 = this.f20672a;
            int iHashCode = (((((((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f)) * 31;
            long j3 = this.g;
            return ((iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.h ? 1 : 0);
        }

        public final boolean i() {
            return this.h && this.f20672a == Long.MIN_VALUE && this.b == -1;
        }

        public boolean j() {
            return this.b == -1 || f() < this.b;
        }

        @CheckResult
        public a k(int i2) {
            int[] iArrD = d(this.e, i2);
            long[] jArrC = c(this.f, i2);
            return new a(this.f20672a, i2, this.c, iArrD, (Uri[]) Arrays.copyOf(this.d, i2), jArrC, this.g, this.h);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(i, this.f20672a);
            bundle.putInt(j, this.b);
            bundle.putInt(p, this.c);
            bundle.putParcelableArrayList(k, new ArrayList<>(Arrays.asList(this.d)));
            bundle.putIntArray(l, this.e);
            bundle.putLongArray(m, this.f);
            bundle.putLong(n, this.g);
            bundle.putBoolean(o, this.h);
            return bundle;
        }

        public a(long j2, int i2, int i3, int[] iArr, Uri[] uriArr, long[] jArr, long j3, boolean z) {
            vh.a(iArr.length == uriArr.length);
            this.f20672a = j2;
            this.b = i2;
            this.c = i3;
            this.e = iArr;
            this.d = uriArr;
            this.f = jArr;
            this.g = j3;
            this.h = z;
        }
    }

    public s6(@Nullable Object obj, a[] aVarArr, long j2, long j3, int i2) {
        this.f20671a = obj;
        this.c = j2;
        this.d = j3;
        this.b = aVarArr.length + i2;
        this.f = aVarArr;
        this.e = i2;
    }

    public static s6 b(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(i);
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                aVarArr2[i2] = (a) a.q.fromBundle((Bundle) parcelableArrayList.get(i2));
            }
            aVarArr = aVarArr2;
        }
        String str = j;
        s6 s6Var = g;
        return new s6(null, aVarArr, bundle.getLong(str, s6Var.c), bundle.getLong(k, s6Var.d), bundle.getInt(l, s6Var.e));
    }

    public a c(@IntRange(from = 0) int i2) {
        int i3 = this.e;
        return i2 < i3 ? h : this.f[i2 - i3];
    }

    public int d(long j2, long j3) {
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j3 != -9223372036854775807L && j2 >= j3) {
            return -1;
        }
        int i2 = this.e;
        while (i2 < this.b && ((c(i2).f20672a != Long.MIN_VALUE && c(i2).f20672a <= j2) || !c(i2).j())) {
            i2++;
        }
        if (i2 < this.b) {
            return i2;
        }
        return -1;
    }

    public int e(long j2, long j3) {
        int i2 = this.b - 1;
        int i3 = i2 - (f(i2) ? 1 : 0);
        while (i3 >= 0 && g(j2, j3, i3)) {
            i3--;
        }
        if (i3 < 0 || !c(i3).h()) {
            return -1;
        }
        return i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s6.class != obj.getClass()) {
            return false;
        }
        s6 s6Var = (s6) obj;
        return g86.c(this.f20671a, s6Var.f20671a) && this.b == s6Var.b && this.c == s6Var.c && this.d == s6Var.d && this.e == s6Var.e && Arrays.equals(this.f, s6Var.f);
    }

    public boolean f(int i2) {
        return i2 == this.b - 1 && c(i2).i();
    }

    public final boolean g(long j2, long j3, int i2) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        a aVarC = c(i2);
        long j4 = aVarC.f20672a;
        return j4 == Long.MIN_VALUE ? j3 == -9223372036854775807L || (aVarC.h && aVarC.b == -1) || j2 < j3 : j2 < j4;
    }

    public int hashCode() {
        int i2 = this.b * 31;
        Object obj = this.f20671a;
        return ((((((((i2 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + this.e) * 31) + Arrays.hashCode(this.f);
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (a aVar : this.f) {
            arrayList.add(aVar.toBundle());
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(i, arrayList);
        }
        long j2 = this.c;
        s6 s6Var = g;
        if (j2 != s6Var.c) {
            bundle.putLong(j, j2);
        }
        long j3 = this.d;
        if (j3 != s6Var.d) {
            bundle.putLong(k, j3);
        }
        int i2 = this.e;
        if (i2 != s6Var.e) {
            bundle.putInt(l, i2);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f20671a);
        sb.append(", adResumePositionUs=");
        sb.append(this.c);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.f.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f[i2].f20672a);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.f[i2].e.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.f[i2].e[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f[i2].f[i3]);
                sb.append(')');
                if (i3 < this.f[i2].e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
