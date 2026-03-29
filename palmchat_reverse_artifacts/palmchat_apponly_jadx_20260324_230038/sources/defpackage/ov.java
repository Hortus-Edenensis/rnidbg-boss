package defpackage;

import android.text.TextUtils;
import defpackage.i02;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ov {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements i02.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19880a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public a(String str, long j, String str2) {
            this.f19880a = str;
            this.b = j;
            this.c = str2;
        }

        @Override // i02.a
        public jq a() {
            return new bf1(this.f19880a, this.b, this.c);
        }
    }

    public static synchronized void a(long j, String str, ey1<String, String> ey1Var) {
        if (j != 0) {
            if (!TextUtils.isEmpty(str)) {
                String strB = b(j);
                ((bf1) i02.b().a(strB, new a(strB, j, str))).k(ey1Var);
                return;
            }
        }
        ey1Var.b("param is null");
    }

    public static String b(long j) {
        return "DownloadGift_" + j;
    }
}
