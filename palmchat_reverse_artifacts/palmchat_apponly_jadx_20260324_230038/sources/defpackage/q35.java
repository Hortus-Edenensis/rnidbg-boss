package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baidu.platform.comapi.map.MapController;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class q35 {
    public static final String c = "q35";
    public static q35 d;
    public static final String e = nl0.b + "/appcfg/screenConfig/get?dhid=%s&resolution=%s&version=%d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f20170a = null;
    public JSONObject b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20171a;

        public a(Context context) {
            this.f20171a = context;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            Log.i(q35.c, "update = " + jSONObject.toString());
            synchronized (q35.this) {
                q35.this.b = jSONObject;
            }
            SharedPreferences.Editor editorEdit = this.f20171a.getSharedPreferences("lx_screen_config", 0).edit();
            editorEdit.putString(com.igexin.push.core.b.Y, jSONObject.toString());
            editorEdit.apply();
            w84.h();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            volleyError.printStackTrace();
            LogUtil.i(q35.c, "onErrorResponse:" + volleyError.getMessage());
        }
    }

    public static q35 b() {
        if (d == null) {
            synchronized (q35.class) {
                if (d == null) {
                    d = new q35();
                }
            }
        }
        return d;
    }

    public synchronized String c() {
        JSONObject jSONObject;
        jSONObject = this.b;
        return jSONObject != null ? jSONObject.optString("openScreenBottomUrl") : null;
    }

    public synchronized int d() {
        JSONObject jSONObject;
        jSONObject = this.b;
        return jSONObject != null ? jSONObject.optInt("openScreenDuration", 0) : 0;
    }

    public synchronized String e() {
        JSONObject jSONObject;
        jSONObject = this.b;
        return jSONObject != null ? jSONObject.optString("openScreenUrl") : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x001b, B:9:0x001f, B:12:0x002f, B:14:0x0039, B:16:0x0041, B:19:0x004d, B:20:0x0050), top: B:26:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int f() {
        JSONObject jSONObject;
        String strOptString;
        if (this.f20170a == null) {
            this.f20170a = Integer.valueOf(Color.parseColor("#009687"));
            if (!ts0.o().M() || (jSONObject = this.b) == null || jSONObject.optLong("expireTime", 0L) <= System.currentTimeMillis()) {
                LogUtil.i(c, "getToolBarColor " + this.f20170a);
            } else {
                try {
                    strOptString = this.b.optString("topBarColor");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (strOptString != null && !strOptString.equals(MapController.DEFAULT_LAYER_TAG)) {
                    this.f20170a = Integer.valueOf(Color.parseColor(strOptString));
                    LogUtil.i(c, "getToolBarColor " + this.f20170a);
                }
            }
        }
        return this.f20170a.intValue();
    }

    public void g(Context context) {
        try {
            String string = context.getSharedPreferences("lx_screen_config", 0).getString(com.igexin.push.core.b.Y, "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.b = new JSONObject(string);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public synchronized boolean h() {
        boolean z;
        long jOptLong;
        int iOptInt;
        long jB = ir5.b();
        JSONObject jSONObject = this.b;
        z = false;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("openScreen", 0);
            jOptLong = this.b.optLong("expireTime", 0L);
            jOptLong = jo6.a("LX-33007", false) ? this.b.optLong("startTime", 0L) : 0L;
        } else {
            jOptLong = 0;
            iOptInt = 0;
        }
        if (iOptInt == 2 && jOptLong > jB && jOptLong <= jB) {
            z = true;
        }
        return z;
    }

    public boolean i(Context context) {
        long jOptLong;
        synchronized (this) {
            JSONObject jSONObject = this.b;
            jOptLong = jSONObject != null ? jSONObject.optLong("currentVersion", 0L) : 0L;
        }
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        String str = String.format(e, ac1.h, me1.g() + "-" + me1.f(), Long.valueOf(jOptLong));
        LogUtil.i(c, "update url:" + str);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(0, str, null, new a(context), new b());
        jsonObjectRequest.addHeader(Request.HEADER_RUN_IN_THREAD, "1");
        normalRequestQueue.add(jsonObjectRequest);
        return true;
    }
}
