package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class k45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static yp3 f18571a;
    public static String[] b;
    public static String[] c;

    static {
        yp3 yp3Var = new yp3("Message Section", 3);
        f18571a = yp3Var;
        b = new String[4];
        c = new String[4];
        yp3Var.e(3);
        f18571a.f(true);
        f18571a.a(0, "qd");
        f18571a.a(1, "an");
        f18571a.a(2, "au");
        f18571a.a(3, "ad");
        String[] strArr = b;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = c;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i) {
        return f18571a.c(i);
    }
}
