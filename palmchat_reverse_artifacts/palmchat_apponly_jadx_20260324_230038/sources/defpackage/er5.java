package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class er5 {
    public static String a(String str, String str2) {
        Object objC = ho.c("android.os.SystemProperties", "get", str, str2);
        return objC instanceof String ? (String) objC : str2;
    }
}
