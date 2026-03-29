package defpackage;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class te6 implements f {
    public static final te6 e = new te6(0, 0);
    public static final String f = g86.w0(0);
    public static final String g = g86.w0(1);
    public static final String h = g86.w0(2);
    public static final String i = g86.w0(3);
    public static final f.a<te6> j = new f.a() { // from class: se6
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return te6.b(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IntRange(from = 0)
    public final int f20973a;

    @IntRange(from = 0)
    public final int b;

    @IntRange(from = 0, to = 359)
    public final int c;

    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float d;

    public te6(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        this(i2, i3, 0, 1.0f);
    }

    public static /* synthetic */ te6 b(Bundle bundle) {
        return new te6(bundle.getInt(f, 0), bundle.getInt(g, 0), bundle.getInt(h, 0), bundle.getFloat(i, 1.0f));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof te6)) {
            return false;
        }
        te6 te6Var = (te6) obj;
        return this.f20973a == te6Var.f20973a && this.b == te6Var.b && this.c == te6Var.c && this.d == te6Var.d;
    }

    public int hashCode() {
        return ((((((217 + this.f20973a) * 31) + this.b) * 31) + this.c) * 31) + Float.floatToRawIntBits(this.d);
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(f, this.f20973a);
        bundle.putInt(g, this.b);
        bundle.putInt(h, this.c);
        bundle.putFloat(i, this.d);
        return bundle;
    }

    public te6(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0, to = 359) int i4, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this.f20973a = i2;
        this.b = i3;
        this.c = i4;
        this.d = f2;
    }
}
