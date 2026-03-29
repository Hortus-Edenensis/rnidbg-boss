package defpackage;

import com.google.android.exoplayer2.source.p;
import defpackage.z50;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class hr implements z50.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f18032a;
    public final p[] b;

    public hr(int[] iArr, p[] pVarArr) {
        this.f18032a = iArr;
        this.b = pVarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.b.length];
        int i = 0;
        while (true) {
            p[] pVarArr = this.b;
            if (i >= pVarArr.length) {
                return iArr;
            }
            iArr[i] = pVarArr[i].G();
            i++;
        }
    }

    public void b(long j) {
        for (p pVar : this.b) {
            pVar.a0(j);
        }
    }

    @Override // z50.b
    public c06 track(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f18032a;
            if (i3 >= iArr.length) {
                y53.c("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new pi1();
            }
            if (i2 == iArr[i3]) {
                return this.b[i3];
            }
            i3++;
        }
    }
}
