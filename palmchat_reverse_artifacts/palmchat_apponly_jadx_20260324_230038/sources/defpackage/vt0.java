package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static vt0 f21520a = null;
    public static int b = 1;
    public static JSONObject c = new JSONObject();
    public static int d = 1800000;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            vt0.b = 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f21522a;
        public final /* synthetic */ boolean b;

        public b(Uri uri, boolean z) {
            this.f21522a = uri;
            this.b = z;
            put("url", uri.toString());
            put("isFromWifi", String.valueOf(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, String> {
        public c() {
            put("dm_wakeupType", bp4.j());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, String> {
        public d() {
            put("dm_notifyCount", String.valueOf(com.zenmen.palmchat.utils.a.E().C()));
        }
    }

    public static vt0 d() {
        if (f21520a == null) {
            f21520a = new vt0();
            try {
                c.put("dm_sessionId", (e() + AppContext.getContext().hashCode()).hashCode());
                c.put("dm_source", MapController.DEFAULT_LAYER_TAG);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return f21520a;
    }

    public static String e() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public final void b(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectC = c(c, jSONObject);
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_KEEPALIVE, null, "appactive", null, null, jSONObjectC.toString());
            zn6.d("lx_appactive", null, jSONObjectC.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject3.put(next, jSONObject2.optString(next));
        }
        return jSONObject3;
    }

    public void f() {
        new Handler().postDelayed(new a(), 1000L);
    }

    public final void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dm_net", str);
            jSONObject.put("dm_type", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b(jSONObject);
    }

    public void h(int i) {
        i(i, null);
    }

    public void i(int i, String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("dm_openstyle", String.valueOf(i));
            jSONObject.put("dm_type", 3);
            b(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void j(int i, Map map) {
        if (map == null) {
            return;
        }
        try {
            i(i, new JSONObject(map).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        i(i, jSONObject.toString());
    }

    public void l(Intent intent, boolean z) {
        if (intent == null || z) {
            return;
        }
        Uri data = intent.getData();
        Set<String> categories = intent.getCategories();
        boolean z2 = categories != null && categories.contains("android.intent.category.LAUNCHER");
        boolean z3 = 2 == intent.getIntExtra("key_from", 0);
        if (data != null && data.toString().contains("zenxin://activity/init")) {
            String stringExtra = intent.getStringExtra("dp_src");
            j(5, new b(data, stringExtra != null && stringExtra.contains("com.snda.wifilocating")));
        } else if (z3) {
            j(4, new c());
        } else if (z2) {
            j(1, new d());
        } else {
            h(100);
        }
    }

    public void m() {
        long jQ = e13.q(AppContext.getContext());
        if (jQ > System.currentTimeMillis()) {
            jQ = 0;
        }
        if (System.currentTimeMillis() - jQ > d) {
            if (ao.b(AppContext.getContext())) {
                g(RXScreenCaptureService.KEY_WIDTH);
            } else if (ao.a(AppContext.getContext())) {
                g("g");
            } else {
                g("n");
            }
            e13.r(AppContext.getContext(), System.currentTimeMillis());
        }
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (b == 1) {
                c.put("dm_source", str);
            } else {
                jSONObject.put("dm_source", str);
            }
            jSONObject.put("dm_proState", b);
            jSONObject.put("dm_type", 2);
            b(jSONObject);
            b = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
