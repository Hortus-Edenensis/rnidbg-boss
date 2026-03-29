package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.b.fx;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pblb f19328a;

    /* JADX INFO: compiled from: SearchBox */
    public interface pblb {
        void u(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19329a;

        public pgla(Context context) {
            this.f19329a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2433a8", new byte[]{2, 5, 117, 116})).equals(pblk.e(pblk.this).toUpperCase())) {
                    new ms.bz.bd.c.Pgl.pgla(this.f19329a).a(pblk.this.f19328a);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "950e1d", new byte[]{0, 2, 98, 38, 43, 90})).equals(pblk.e(pblk.this).toUpperCase())) {
                    new pblp(this.f19329a).a(pblk.this.f19328a);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bc1e87", new byte[]{92, 81, 114, 62})).equals(pblk.e(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1b55b0", new byte[]{15, 78, 99, 113, 113, 18, 1})).equals(pblk.e(pblk.this).toUpperCase())) {
                    e1 e1Var = new e1(this.f19329a);
                    e1Var.c(pblk.this.f19328a);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fbf826", new byte[]{77, 84, 48})).equals(pblk.e(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "71fd2a", new byte[]{0, 22, 39, 34, 32, 83, 27, 35})).equals(pblk.e(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.g() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8f1bf2", new byte[]{26, 87, 119, Utf8.REPLACEMENT_BYTE})).equals(pblk.e(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.c() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "391df6", new byte[]{17, 26, 111, 35, 108, 15, 23})).equals(pblk.e(pblk.this).toUpperCase())) {
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "184454", new byte[]{12, TELogUtils.DEBUG_LEVEL_V, 105, 111, 60, 12})).equals(pblk.e(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d074bd", new byte[]{88, 29, 112, 111, 113, 92, 85, 48})).equals(pblk.e(pblk.this).toUpperCase())) {
                    pblt pbltVar = new pblt(this.f19329a);
                    pbltVar.a(pblk.this.f19328a);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public pblk(pblb pblbVar) {
        this.f19328a = pblbVar;
    }

    public static boolean c() {
        String strD = d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ba0d88", new byte[]{97, 108, dn.k, 3, 20, 58, 104, dn.l, 113, 38, 124, 103, 86, 19, 19}));
        return (TextUtils.isEmpty(strD) || strD.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "afbf7b", new byte[]{101, 106, 26, 28, 7, 98, 108}))) ? false : true;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dede76", new byte[]{116, 105, 19, 3, 7, 40, 99, 10, 58, 38, 59, 84, dn.l, 2, 28, 36, 106, 116, 39, 58, 101, 98, 5, 5, 1, 36, 116}));
            return (String) cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8b91c1", new byte[]{46, 101, 94}), String.class, String.class).invoke(cls, str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ecd370", new byte[]{97, 111, 28, 73, 7, 48, 104}));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String e(pblk pblkVar) {
        pblkVar.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean g() {
        String strD = d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "50047a", new byte[]{54, Base64.padSymbol, dn.k, 66, 29, ByteCompanionObject.MAX_VALUE, 58, 21, 47, 98, 54, 55, 70, 77, dn.k, 56, 58, 16, 99, 97, 40}));
        return !TextUtils.isEmpty(strD) && strD.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "20d55d", new byte[]{5, 0, 50, 100, 39, 86, 30, 34}));
    }

    public final void b(Context context) {
        new fx(new pgla(context), "bd/c/Pgl/pblk").start();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(Context context) {
        String strA;
        String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3ee3af", new byte[]{3, 84, 35, 116});
        String str2 = Build.MANUFACTURER;
        if (str.equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7d2176", new byte[]{dn.l, 83, 96, 114, 45, 8})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "82e212", new byte[]{5, 21, 56, 105, 56, 10})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d0f748", new byte[]{88, 29, 33, 108, 39, 0, 85, 48})).equals(str2.toUpperCase().toUpperCase())) {
            b(context);
            strA = null;
        } else {
            if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9b721b", new byte[]{5, 69, 109, 124, 59})).equals(str2.toUpperCase().toUpperCase())) {
                new a1(context).b(this.f19328a);
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "67a965", new byte[]{9, 0, 48, 100, 40})).equals(str2.toUpperCase().toUpperCase())) {
                strA = new c1(context).a();
            } else if (!((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e63f94", new byte[]{91, 4, 112, Base64.padSymbol})).equals(str2.toUpperCase().toUpperCase()) && !((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cadae5", new byte[]{65, 66, 58, 38, 111, 12, 71})).equals(str2.toUpperCase().toUpperCase())) {
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "32ce77", new byte[]{20, 25, 38, 62})).equals(str2.toUpperCase().toUpperCase())) {
                    strA = new z1(context).a();
                } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "78a66f", new byte[]{30, 19, 51, 109, 36, 88})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "671084", new byte[]{5, 25, 99, 103, 44, 16, 29, 55, 82, 75})).equals(str2.toUpperCase().toUpperCase())) {
                    strA = new a2(context).a();
                } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "63b562", new byte[]{8, TELogUtils.DEBUG_LEVEL_V, 52, 113, 37, 16, 6})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dd5ef4", new byte[]{79, 82, 99})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e15402", new byte[]{82, 22, 116, 114, 34, 0, 73, 35})).equals(str2.toUpperCase().toUpperCase()) || g() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "22829a", new byte[]{16, 3, 126, 111})).equals(str2.toUpperCase().toUpperCase()) || c()) {
                }
            }
            strA = null;
        }
        pblb pblbVar = this.f19328a;
        if (pblbVar != null) {
            pblbVar.u(strA);
        }
    }
}
