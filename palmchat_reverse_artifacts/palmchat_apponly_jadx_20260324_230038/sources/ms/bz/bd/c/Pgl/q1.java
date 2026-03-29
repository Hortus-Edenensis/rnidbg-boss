package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import android.view.Display;
import com.ss.android.ttvecamera.TELogUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class q1 {
    public static q1 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19347a;
    public long b;
    public long c;
    public int d = 1;
    public long e;
    public String f;
    public String g;
    public String h;
    public boolean i;

    private q1() {
    }

    public static String c(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                StringBuilder sb2 = new StringBuilder();
                Object objG = g(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1f7d10", new byte[]{45, 64, 77, 3, 30, 43, 51, 94, 79, 58, 38, 107}));
                sb2.append(g(objG, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "136896", new byte[]{47, 38, 75, 73, 20, 17, 51, 17, 108, 105, 39, 52, 107, 77, 11, 36})));
                sb2.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "03a735", new byte[]{109}));
                sb2.append(g(objG, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0a68ec", new byte[]{39, 111, 68, 75, 73})));
                sb2.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c1d6e9", new byte[]{62}));
                sb2.append(g(objG, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c43546", new byte[]{124, 55, 77, 68})));
                sb2.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2983b6", new byte[]{111}));
                sb2.append(g(objG, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "422047", new byte[]{49, 41, 81, 65})));
                if (!sb.toString().contains(sb2.toString())) {
                    if (sb.length() > 0) {
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6100fc", new byte[]{124}));
                    }
                    sb.append((CharSequence) sb2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object g(Object obj, String str) {
        Field field;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8aaede", new byte[]{46, 102, 6, 53, 94, 113, 55, 65, 34, 48, 45, 69, 27, 20, 87, 118}), String.class);
            if (declaredMethod == null || (field = (Field) declaredMethod.invoke(obj.getClass(), str)) == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String h(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                Object objG = g(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "42f2f2", new byte[]{40, TELogUtils.DEBUG_LEVEL_V, 2, 72, 92, 55, 7, 18, 52, 105, 36, 55, 16, 104, 88, 40, 50}));
                if (objG != null && !sb.toString().contains(objG.toString())) {
                    sb.append(objG);
                    sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cff4f5", new byte[]{41}));
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static q1 i() {
        if (j == null) {
            j = new q1();
        }
        return j;
    }

    public final boolean a() {
        return this.f19347a > 0 || this.b > 0 || this.e > 0;
    }

    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8d9603", new byte[]{40, 114}), this.f19347a);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6ccb8", new byte[]{101, 32}), this.b);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7798d3", new byte[]{34, 56}), this.d);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "68d6b3", new byte[]{35, 46}), this.e);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "83542a", new byte[]{42, 48, 66}), this.i ? 1 : 0);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06b325", new byte[]{44, 48}), this.f);
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0ea960", new byte[]{49, 108}), this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "061fe1", new byte[]{37, Base64.padSymbol}), this.h);
            }
            this.c = System.currentTimeMillis();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "65f42c", new byte[]{36, 35}), this.c / 1000);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void d() {
        this.i = true;
    }

    public final void e(long j2) {
        this.b = j2;
        this.f = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4715e6", new byte[]{55, 48, 79, 78, 76, 36});
    }

    public final void f(String str) {
        this.h = str;
    }

    public final void j(int i) {
        if (this.d != i) {
            this.e = System.currentTimeMillis() / 1000;
        }
        this.d = i;
    }

    public final void k(long j2) {
        this.f19347a = j2;
        this.f = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3ac007", new byte[]{35, 103, 20});
    }

    public final void l(String str) {
        this.g = str;
    }
}
