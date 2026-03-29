package defpackage;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pm4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Executor f20053a = vw5.c(6, pm4.class.getSimpleName());

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20054a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(String str, String str2, String str3) {
            this.f20054a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> mapA = m44.a();
            mapA.put("thirdAppId", this.f20054a);
            mapA.put("bt", this.b);
            mapA.put("sid", this.c);
            String strI = wn.i(n44.l("00500102"), ja5.c("00500102", mapA, "lxf48f512f7d6a47c2", "b25a6fa5cad0420e8cb9c6776f8c323e"));
            if (TextUtils.isEmpty(strI)) {
                ma3.g("thirdAppId:%s event:%s sid:%s// post game event failed net error", this.f20054a, this.b, this.c);
            } else {
                ma3.a("thirdAppId:%s event:%s sid:%s// %s", this.f20054a, this.b, strI, this.c);
            }
        }
    }

    public static String a(long j) {
        String str = j + "";
        if (j >= 10) {
            return str;
        }
        return "0" + str;
    }

    public static String b(long j) {
        long j2 = j - ((j / 86400000) * 86400000);
        long j3 = j2 / 3600000;
        String strA = a(j3);
        long j4 = j2 - (j3 * 3600000);
        long j5 = j4 / 60000;
        return strA + ":" + a(j5) + ":" + a((j4 - (j5 * 60000)) / 1000);
    }

    public static void c(String str, String str2, String str3) {
        f20053a.execute(new a(str2, str, str3));
    }
}
