package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import defpackage.rh4;
import defpackage.sh4;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bz.bd.c.Pgl.pblz;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f19346a = false;
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static CopyOnWriteArraySet c = new CopyOnWriteArraySet();

    /* JADX INFO: compiled from: SearchBox */
    public interface pgla {
        Map<String, String> a(String str, byte[] bArr);

        void b(String str);

        void c(String str);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5a48e0", new byte[]{43, 109, 117, 73, 74, 40, 36, 84, 67, 97, 42, 106, 84, 68, 26, 51, 57, 75, 96, 102, 100, 46, 10, 1, 26});
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
    }

    public static synchronized p0 b(String str) {
        if (str == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "24be69", new byte[]{34, 38, 1, 56, 45, 110, 60, 0, 32, 33, 99, 52, 20, 81, 26, 43, 37}));
        }
        if (!f19346a) {
            return null;
        }
        SparseArray<pblz.pgla> sparseArray = pblz.f19343a;
        Object objA = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, null);
        if (objA == null) {
            return null;
        }
        pblv pblvVar = (pblv) b.get(str);
        if (pblvVar == null) {
            return null;
        }
        return new p0(pblvVar, pblw.b().a(), ((Long) objA).longValue());
    }

    public static synchronized void c(Context context) {
        if (!f19346a) {
            Context applicationContext = context.getApplicationContext();
            pblw.b().c(applicationContext);
            h1.a(applicationContext);
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "55b3d6", new byte[]{106, 58, 2});
            pblz.b(16777218, new k());
            pblz.b(16777217, new v());
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b10081", new byte[]{Base64.padSymbol, 62, 71});
            pblz.b(16777219, new g0());
            pblz.b(16777221, new j0());
            pblz.b(16777222, new k0());
            pblz.b(16777223, new l0());
            pblz.b(16777224, new m0());
            pblz.b(16777225, new n0());
            pblz.b(16777226, new o0());
            pblz.b(16777228, new a());
            pblz.b(InputDeviceCompat.SOURCE_JOYSTICK, new b());
            pblz.b(16777233, new c());
            pblz.b(16777235, new d());
            pblz.b(16777238, new e());
            pblz.b(16777239, new f());
            pblz.b(16777241, new g());
            pblz.b(16777242, new h());
            pblz.b(16777243, new i());
            pblz.b(16777244, new j());
            pblz.b(16777245, new l());
            pblz.b(16777246, new m());
            pblz.b(16777247, new n());
            pblz.b(16777248, new o());
            pblz.b(16777249, new p());
            pblz.b(16777250, new q());
            pblz.b(16777251, new r());
            pblz.b(16777240, new s());
            pblz.b(16777252, new t());
            pblz.b(16777253, new u());
            pblz.b(16777254, new w());
            pblz.b(16777255, new x());
            pblz.b(16777256, new y());
            pblz.b(16777257, new z());
            pblz.b(16777317, new a0());
            pblz.b(16777318, new b0());
            pblz.b(16777261, new c0());
            pblz.b(16777266, new d0());
            pblz.b(16777319, new e0());
            pblz.b(16777259, new f0());
            pblz.b(16777262, new h0());
            pblz.b(33554435, new i0());
            y0.b();
            z0.a();
            com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, applicationContext);
            f19346a = true;
        }
    }

    public static synchronized void d(String str) {
        if (pblw.b().a() != null) {
            pblv pblvVar = (pblv) b.get(str);
            if (b(str) != null && pblvVar != null) {
                c.addAll(pblvVar.p);
                rh4 rh4VarA = sh4.a(str);
                if (rh4VarA != null) {
                    rh4VarA.b((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4f2e03", new byte[]{26, 109, 79, 24, 27, 27, 37, 66, 115, 58, 55, 112}));
                }
            }
        }
    }

    public static synchronized boolean e(Context context, pblv pblvVar) {
        if (context == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a65f32", new byte[]{115, 59, 72, 6, 9, Base64.padSymbol, 118, 87, 103, 57, 101, 56, 66, 82, 2, 42, 118, 87, 102, 51, 48, 58, 83, 30, 0}));
        }
        if (pblvVar == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e77742", new byte[]{119, 58, 74, 69, 2, 34, 38, 21, 105, 114, 120, 49, 4, 77, 4, 49, 38, 20, 99, 39, 122, 32, 72, 79}));
        }
        String str = pblvVar.f19339a;
        String str2 = (str == null || str.length() <= 0) ? pblvVar.g : pblvVar.f19339a;
        if (str2 == null || str2.length() <= 0) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7e8ad4", new byte[]{39, 119, 91, 60, ByteCompanionObject.MAX_VALUE, 99, 57, 81, 122, 37, 102, 101, 78, 85, 72, 38, 32}));
        }
        if (!f19346a) {
            synchronized (q0.class) {
                if (!f19346a) {
                    c(context);
                    f19346a = true;
                }
            }
        }
        if (b.containsKey(str2)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(pblv.a(pblvVar.f19339a));
        jSONArray.put(pblv.a(pblvVar.h));
        jSONArray.put(pblv.a(pblvVar.g));
        jSONArray.put(pblv.a(pblvVar.i));
        jSONArray.put(pblv.a(s1.a()));
        jSONArray.put(pblv.a(pblvVar.b));
        jSONArray.put(pblv.a(pblvVar.c));
        jSONArray.put(pblv.a(pblvVar.d));
        jSONArray.put(pblv.a(pblvVar.e));
        jSONArray.put(pblv.a(pblvVar.f));
        jSONArray.put(String.valueOf(pblvVar.k));
        jSONArray.put(String.valueOf(pblvVar.l));
        jSONArray.put(String.valueOf(pblvVar.m));
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, String> entry : pblvVar.n.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                jSONArray2.put(pblv.a(entry.getKey()));
                jSONArray2.put(pblv.a(entry.getValue()));
            }
        }
        jSONArray.put(jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (Map.Entry entry2 : pblvVar.o.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                if (((String) entry2.getKey()).equals("kOA1") && TextUtils.equals((CharSequence) entry2.getValue(), "1")) {
                    d1.c = false;
                    d1.d = pblvVar.j;
                }
                jSONArray3.put(pblv.a(entry2.getKey()));
                jSONArray3.put(pblv.a(entry2.getValue()));
            }
        }
        jSONArray.put(jSONArray3);
        String string = jSONArray.toString();
        SparseArray<pblz.pgla> sparseArray = pblz.f19343a;
        if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, string, null)).booleanValue()) {
            return false;
        }
        b.put(str2, pblvVar);
        r1.f(context).g();
        return true;
    }
}
