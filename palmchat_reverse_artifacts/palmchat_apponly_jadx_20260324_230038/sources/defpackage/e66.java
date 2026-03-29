package defpackage;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import com.igexin.push.core.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class e66 {
    public static volatile e66 b;
    public static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Long, String> f17224a = new HashMap();

    public static e66 b() {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new e66();
                }
            }
        }
        return b;
    }

    public final String a(Context context, String str, String str2) {
        String str3 = (String) lg5.c(context, zz2.l(str));
        if (!TextUtils.isEmpty(str2) && !str2.equals(str3)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("need not ");
        sb.append(str);
        sb.append(" userctrl,newest version:");
        if (TextUtils.isEmpty(str2)) {
            str2 = b.m;
        }
        sb.append(str2);
        k63.j("UserCtrlHelper", sb.toString());
        return "";
    }

    public void c(Context context) {
        if (context == null) {
            k63.l("UserCtrlHelper", "handleUserCtrl failed,context is null");
            return;
        }
        HashMap<String, JDispatchAction> map = zd1.c;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, JDispatchAction> entry : map.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                String strA = a(context, entry.getKey(), value.getSdkVersion(entry.getKey()));
                if (!TextUtils.isEmpty(strA)) {
                    h(context, value.getUserCtrlProperty(entry.getKey()), strA, entry.getKey());
                }
            }
        }
    }

    public boolean d(Context context) {
        if (context == null) {
            k63.n("UserCtrlHelper", "get isNeedUserCtrl failed,context is null");
            return false;
        }
        HashMap<String, JDispatchAction> map = zd1.c;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, JDispatchAction> entry : map.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(a(context, entry.getKey(), value.getSdkVersion(entry.getKey())))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void e(Context context, long j, int i) {
        String strRemove = this.f17224a.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(strRemove)) {
            k63.a("UserCtrlHelper", "onUserCtrlFailed but not found rid:" + j);
            return;
        }
        k63.a("UserCtrlHelper", "onUserCtrlFailed rid:" + j + ",sdkType:" + strRemove + ",errorCode:" + i);
        if (TextUtils.isEmpty(zd1.e().m(strRemove, ""))) {
            k63.a("UserCtrlHelper", "onUserCtrlFailed but not found sdkversion by sdkType:" + strRemove);
        }
    }

    public void f(Context context, long j) {
        String strRemove = this.f17224a.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(strRemove)) {
            k63.a("UserCtrlHelper", "userCtrlSuccess but not found rid:" + j);
        } else {
            k63.a("UserCtrlHelper", "userCtrlSuccess rid:" + j + ",sdkType:" + strRemove);
            String strM = zd1.e().m(strRemove, "");
            if (TextUtils.isEmpty(strM)) {
                k63.a("UserCtrlHelper", "userCtrlSuccess but not found sdkversion by sdkType:" + strRemove);
            } else {
                lg5.h(context, zz2.l(strRemove).a0(strM));
            }
        }
        Map<Long, String> map = this.f17224a;
        if (map == null || !map.isEmpty() || gv2.a().b(context)) {
            return;
        }
        tt5.u().r(context, "tcp_a21", null);
    }

    public void g(Context context, long j) {
        k63.a("UserCtrlHelper", "onUserCtrlTimeout rid:" + j);
        this.f17224a.remove(Long.valueOf(j));
    }

    public final void h(Context context, short s, String str, String str2) {
        k63.a("UserCtrlHelper", "sendUserCtrlInfo sdkType:" + str2 + ",property:" + ((int) s) + ",verInfo:" + str);
        long jA = wt5.a();
        bw2.o(context, "JCore", 26, 0, jA, 10000L, cw2.l(s, (short) 1, str));
        this.f17224a.put(Long.valueOf(jA), str2);
    }
}
