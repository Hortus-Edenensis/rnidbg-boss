package defpackage;

import android.app.OplusNotificationManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.android.id.impl.IdProviderImpl;
import defpackage.e37;
import defpackage.kx6;
import defpackage.me7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class tz6 extends k27 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21100a;

        public a(Context context) {
            this.f21100a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            be7.a("2050");
            ArrayList arrayList = new ArrayList();
            arrayList.add("OUID");
            tz6.this.c(this.f21100a, arrayList, true);
            tz6.this.f18561a.remove("OUID");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final tz6 f21101a = new tz6();
    }

    @Override // defpackage.k27
    public void c(Context context, List<String> list, boolean z) {
        (this.b.equals("OP_APP") ? e37.b.f17209a : me7.b.f19204a).d(context, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // defpackage.k27
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, String> e(Context context, List<String> list) {
        String openid;
        OplusNotificationManager oplusNotificationManager;
        HashMap<String, String> map = new HashMap<>();
        if (this.b.equals("OP_APP")) {
            if (list.contains("OUID_STATUS") && !e37.b.f17209a.k) {
                map.put("OUID_STATUS", Settings.Secure.getInt(context.getContentResolver(), lx6.b.equals("phone") ? "openid_toggle" : "stdid_toggle", 1) != 1 ? "FALSE" : "TRUE");
                list.remove("OUID_STATUS");
                be7.a("2041");
            }
            if (list.contains("OUID")) {
                if (lx6.b.equals("phone")) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        kx6 kx6Var = kx6.a.f18852a;
                        IdProviderImpl idProviderImpl = kx6Var.f18851a;
                        if (idProviderImpl != null) {
                            try {
                                openid = idProviderImpl.getOpenid(context, "OUID");
                            } catch (Error | Exception e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("1086: ");
                                sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
                                Log.e("IDHelper", sb.toString());
                                oplusNotificationManager = kx6Var.b;
                                if (oplusNotificationManager == null) {
                                }
                                return map;
                            }
                            be7.a("2042");
                            if (TextUtils.isEmpty(openid)) {
                                Log.e("IDHelper", "1088");
                            } else {
                                map.put("OUID", openid);
                                list.remove("OUID");
                            }
                        } else {
                            oplusNotificationManager = kx6Var.b;
                            if (oplusNotificationManager == null) {
                                try {
                                    openid = oplusNotificationManager.getStdid(context.getPackageName(), Binder.getCallingUid(), "OUID");
                                } catch (Error | Exception e2) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("1087: ");
                                    sb2.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                                    Log.e("IDHelper", sb2.toString());
                                    openid = "";
                                }
                                be7.a("2042");
                                if (TextUtils.isEmpty(openid)) {
                                }
                            } else {
                                openid = "";
                                be7.a("2042");
                                if (TextUtils.isEmpty(openid)) {
                                }
                            }
                        }
                    } else if (e37.b.f17209a.j) {
                        be7.a("2046");
                        g(context, list, map);
                    }
                } else {
                    g(context, list, map);
                    be7.a("2052");
                }
            }
        } else if (this.b.equals("MCS_APP")) {
            if (list.contains("OUID_STATUS")) {
                map.put("OUID_STATUS", "TRUE");
                list.remove("OUID_STATUS");
                be7.a("2043");
            }
            if (list.contains("OUID")) {
                be7.a("2044");
                if (me7.b.f19204a.j) {
                    g(context, list, map);
                }
            }
        }
        return map;
    }

    public final void g(Context context, List<String> list, HashMap<String, String> map) {
        String string = Settings.Secure.getString(context.getContentResolver(), "oplus_omes_stdid_ouid");
        if (TextUtils.isEmpty(string)) {
            be7.a("2045");
            return;
        }
        map.put("OUID", string);
        list.remove("OUID");
        lx6.f19099a.execute(new a(context));
    }
}
