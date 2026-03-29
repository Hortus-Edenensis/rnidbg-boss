package defpackage;

import defpackage.jy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i86 {
    public static String b(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i / 60;
        if (i2 < 10) {
            sb.append("0");
            sb.append(i2);
        } else {
            sb.append(i2);
        }
        sb.append(":");
        int i3 = i % 60;
        if (i3 < 10) {
            sb.append("0");
            sb.append(i3);
        } else {
            sb.append(i3);
        }
        return sb.toString();
    }

    public static String c(int i, String... strArr) {
        return fh.a().getString(i, strArr);
    }

    public static /* synthetic */ void d(jy jyVar, boolean z, Object obj) {
        jyVar.a(new jy.a(z, obj));
    }

    public static <T> void e(final T t, final boolean z, final jy jyVar) {
        if (jyVar == null) {
            return;
        }
        rg.a(new Runnable() { // from class: w76
            @Override // java.lang.Runnable
            public final void run() {
                i86.d(jyVar, z, t);
            }
        });
    }
}
