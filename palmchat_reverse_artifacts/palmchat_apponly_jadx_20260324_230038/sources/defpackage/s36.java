package defpackage;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class s36 {
    public static final int[] c = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q36 f20659a = new q36();
    public final r36 b = new r36();

    public qx4 a(int i, et etVar, int i2) throws NotFoundException {
        int[] iArrM = t36.m(etVar, i2, false, c);
        try {
            return this.b.b(i, etVar, iArrM);
        } catch (ReaderException unused) {
            return this.f20659a.b(i, etVar, iArrM);
        }
    }
}
