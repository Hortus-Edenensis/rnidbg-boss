package defpackage;

import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class rm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20506a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements Comparator<pl1> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(pl1 pl1Var, pl1 pl1Var2) {
            if (pl1Var.getStart() == pl1Var2.getStart()) {
                if (pl1Var.a() < pl1Var2.a()) {
                    return 1;
                }
                return pl1Var.a() == pl1Var2.a() ? 0 : -1;
            }
            if (pl1Var.getStart() < pl1Var2.getStart()) {
                return -1;
            }
            return pl1Var.getStart() == pl1Var2.getStart() ? 0 : 1;
        }
    }

    public static String a(String str, o16 o16Var, List<Object> list, String str2, b55 b55Var) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(oi4.d(str.charAt(i)));
            if (i != str.length() - 1) {
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }
}
