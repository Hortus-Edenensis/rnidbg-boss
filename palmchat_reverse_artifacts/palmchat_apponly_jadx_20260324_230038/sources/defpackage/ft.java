package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ft {
    public static et a(List<qr1> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).d() == null) {
            size--;
        }
        et etVar = new et(size * 12);
        int i = 0;
        int iB = list.get(0).d().b();
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & iB) != 0) {
                etVar.p(i);
            }
            i++;
        }
        for (int i3 = 1; i3 < list.size(); i3++) {
            qr1 qr1Var = list.get(i3);
            int iB2 = qr1Var.c().b();
            for (int i4 = 11; i4 >= 0; i4--) {
                if (((1 << i4) & iB2) != 0) {
                    etVar.p(i);
                }
                i++;
            }
            if (qr1Var.d() != null) {
                int iB3 = qr1Var.d().b();
                for (int i5 = 11; i5 >= 0; i5--) {
                    if (((1 << i5) & iB3) != 0) {
                        etVar.p(i);
                    }
                    i++;
                }
            }
        }
        return etVar;
    }
}
