package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class yg extends jd5 {
    @Nullable
    public static Metadata c(fc4 fc4Var) {
        fc4Var.r(12);
        int iD = (fc4Var.d() + fc4Var.h(12)) - 4;
        fc4Var.r(44);
        fc4Var.s(fc4Var.h(12));
        fc4Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strL = null;
            if (fc4Var.d() >= iD) {
                break;
            }
            fc4Var.r(48);
            int iH = fc4Var.h(8);
            fc4Var.r(4);
            int iD2 = fc4Var.d() + fc4Var.h(12);
            String strL2 = null;
            while (fc4Var.d() < iD2) {
                int iH2 = fc4Var.h(8);
                int iH3 = fc4Var.h(8);
                int iD3 = fc4Var.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = fc4Var.h(16);
                    fc4Var.r(8);
                    if (iH4 == 3) {
                        while (fc4Var.d() < iD3) {
                            strL = fc4Var.l(fc4Var.h(8), f10.f17407a);
                            int iH5 = fc4Var.h(8);
                            for (int i = 0; i < iH5; i++) {
                                fc4Var.s(fc4Var.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strL2 = fc4Var.l(iH3, f10.f17407a);
                }
                fc4Var.p(iD3 * 8);
            }
            fc4Var.p(iD2 * 8);
            if (strL != null && strL2 != null) {
                arrayList.add(new AppInfoTable(iH, strL + strL2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // defpackage.jd5
    @Nullable
    public Metadata b(so3 so3Var, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new fc4(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
