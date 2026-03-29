package defpackage;

import android.os.SystemClock;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.upstream.f;
import com.google.common.collect.ImmutableList;
import defpackage.bd3;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class l06 {
    public static f0 a(bd3.a aVar, e06[] e06VarArr) {
        List[] listArr = new List[e06VarArr.length];
        for (int i = 0; i < e06VarArr.length; i++) {
            e06 e06Var = e06VarArr[i];
            listArr[i] = e06Var != null ? ImmutableList.of(e06Var) : ImmutableList.of();
        }
        return b(aVar, listArr);
    }

    public static f0 b(bd3.a aVar, List<? extends e06>[] listArr) {
        boolean z;
        ImmutableList.a aVar2 = new ImmutableList.a();
        for (int i = 0; i < aVar.d(); i++) {
            vz5 vz5VarF = aVar.f(i);
            List<? extends e06> list = listArr[i];
            for (int i2 = 0; i2 < vz5VarF.f21565a; i2++) {
                qz5 qz5VarB = vz5VarF.b(i2);
                boolean z2 = aVar.a(i, i2, false) != 0;
                int i3 = qz5VarB.f20360a;
                int[] iArr = new int[i3];
                boolean[] zArr = new boolean[i3];
                for (int i4 = 0; i4 < qz5VarB.f20360a; i4++) {
                    iArr[i4] = aVar.g(i, i2, i4);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= list.size()) {
                            z = false;
                            break;
                        }
                        e06 e06Var = list.get(i5);
                        if (e06Var.getTrackGroup().equals(qz5VarB) && e06Var.indexOf(i4) != -1) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                    zArr[i4] = z;
                }
                aVar2.a(new f0.a(qz5VarB, z2, iArr, zArr));
            }
        }
        vz5 vz5VarH = aVar.h();
        for (int i6 = 0; i6 < vz5VarH.f21565a; i6++) {
            qz5 qz5VarB2 = vz5VarH.b(i6);
            int[] iArr2 = new int[qz5VarB2.f20360a];
            Arrays.fill(iArr2, 0);
            aVar2.a(new f0.a(qz5VarB2, false, iArr2, new boolean[qz5VarB2.f20360a]));
        }
        return new f0(aVar2.e());
    }

    public static f.a c(or1 or1Var) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = or1Var.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (or1Var.isTrackExcluded(i2, jElapsedRealtime)) {
                i++;
            }
        }
        return new f.a(1, 0, length, i);
    }
}
