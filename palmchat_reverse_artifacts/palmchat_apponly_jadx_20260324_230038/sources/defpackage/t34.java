package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import defpackage.q05;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class t34 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20892a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ q05.d e;

        public a(String str, HashMap map, boolean z, Activity activity, q05.d dVar) {
            this.f20892a = str;
            this.b = map;
            this.c = z;
            this.d = activity;
            this.e = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f20892a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            iq5.j(false, new String[0]);
            if (q05.o(this.d)) {
                return;
            }
            if (z) {
                q05.d dVar = this.e;
                if (dVar != null) {
                    dVar.b(lXBaseNetBean);
                    return;
                }
                return;
            }
            q05.d dVar2 = this.e;
            if (dVar2 != null) {
                dVar2.a(exc);
            }
        }
    }

    public static void a(Activity activity, int i, q05.d<LXBaseNetBean<String>> dVar) {
        String str = q05.c() + "/user.update.extinfo";
        HashMap map = new HashMap();
        map.put("type", "chatNotifySwitch");
        map.put(ActionUtils.PAYMENT_AMOUNT, Integer.valueOf(i));
        zw4.e(new a(str, map, false, activity, dVar));
    }

    public static int b() {
        return ((Integer) q05.j("KEY_NOTIFY_CONFIG", 0)).intValue();
    }

    public static boolean c(int i, int i2) {
        if (com.zenmen.palmchat.utils.a.E().N()) {
            return d(i, i2);
        }
        return false;
    }

    public static boolean d(int i, int i2) {
        return (i & i2) == 0;
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return new JSONObject(str).optInt("chatNotifySwitch", 0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void f(int i) {
        q05.v("KEY_NOTIFY_CONFIG", Integer.valueOf(i));
    }

    public static int g(int i, boolean z, int i2) {
        return z ? i & (~i2) : i | i2;
    }
}
