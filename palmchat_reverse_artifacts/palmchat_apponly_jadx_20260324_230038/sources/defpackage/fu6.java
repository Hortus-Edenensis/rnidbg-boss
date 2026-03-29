package defpackage;

import android.text.TextUtils;
import defpackage.vt6;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17605a = "";
    public static final vt6.b b;
    public static final vt6.b c;
    public static List<vt6.b> d;

    static {
        vt6.b bVar = new vt6.b("com.eg.android.AlipayGphone", 73, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649");
        b = bVar;
        c = new vt6.b("hk.alipay.wallet", 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
        d = Collections.singletonList(bVar);
    }

    public static String a() {
        return f17605a;
    }

    public static void b(String str) {
        f17605a = str;
        str.hashCode();
        if (str.equals("hk")) {
            d = Collections.singletonList(c);
        } else {
            d = Collections.singletonList(b);
        }
    }

    public static boolean c() {
        return TextUtils.isEmpty(f17605a) || TextUtils.equals("cn", f17605a);
    }
}
