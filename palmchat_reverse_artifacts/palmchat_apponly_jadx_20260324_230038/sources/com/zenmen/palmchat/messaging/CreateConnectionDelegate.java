package com.zenmen.palmchat.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.volley.AuthFailureError;
import com.android.volley.LXRequestHelper;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.GlobalConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.messaging.smack.ManualException;
import com.zenmen.palmchat.messaging.smack.SessionInvalidException;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.bx4;
import defpackage.g9;
import defpackage.ir5;
import defpackage.k86;
import defpackage.ko1;
import defpackage.lb4;
import defpackage.lm0;
import defpackage.mo3;
import defpackage.nl0;
import defpackage.nm0;
import defpackage.r75;
import defpackage.rl0;
import defpackage.s34;
import defpackage.wt4;
import defpackage.xo6;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class CreateConnectionDelegate implements Runnable {
    public static final String d = "CreateConnectionDelegate";
    public static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f14672a;
    public k b;
    public AssetManager c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f14673a;
        public final /* synthetic */ JSONObject b;

        public a(Exception exc, JSONObject jSONObject) {
            this.f14673a = exc;
            this.b = jSONObject;
            put("action", "msg_dispatch");
            put("status", "fail");
            put("error", exc.toString());
            put("detail", jSONObject == null ? "" : jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONArray f14674a;
        public final /* synthetic */ long b;

        public b(JSONArray jSONArray, long j) {
            this.f14674a = jSONArray;
            this.b = j;
            put("action", "msg_dispatch");
            put("status", "success");
            put("detail", jSONArray);
            put("duration", Long.valueOf(ir5.e(j)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("action", "link_connect");
            put("status", "start");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f14676a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public d(Exception exc, String str, int i) {
            this.f14676a = exc;
            this.b = str;
            this.c = i;
            put("action", "msg_connect");
            put("status", "fail");
            put("error", exc.toString());
            put(LogUtil.KEY_IP_ADDRESS, str + ":" + i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "link_connect");
            put("status", "end");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements nm0 {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "msg_connect");
                put("status", "connectionClosed");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "msg_connect");
                put("status", "connectionClosedOnError");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("action", "msg_connect");
                put("status", "reconnectionSuccessful");
            }
        }

        public f() {
        }

        @Override // defpackage.nm0
        public void a(Exception exc) {
            LogUtil.i(CreateConnectionDelegate.d, 3, new b(), exc);
            com.zenmen.palmchat.messaging.b.d().c().w(exc != null && (exc instanceof ManualException), "STASRT_REASON_CONNECTION_ERROR");
        }

        @Override // defpackage.nm0
        public void b() {
            LogUtil.i(CreateConnectionDelegate.d, 3, new c(), (Throwable) null);
        }

        @Override // defpackage.nm0
        public void c() {
            LogUtil.i(CreateConnectionDelegate.d, 3, new a(), (Throwable) null);
            com.zenmen.palmchat.messaging.b.d().c().w(false, "STASRT_REASON_CONNECTION_CLOSE");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TokenInValidateException f14682a;

        public g(TokenInValidateException tokenInValidateException) {
            this.f14682a = tokenInValidateException;
            put("action", "link_connect");
            put("status", "fail");
            put("error", "TokenInValidateException:" + tokenInValidateException.getMessage());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionInvalidException f14683a;

        public h(SessionInvalidException sessionInvalidException) {
            this.f14683a = sessionInvalidException;
            put("action", "link_connect");
            put("status", "fail");
            put("error", "SessionInvalidException:" + sessionInvalidException.getMessage());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f14684a;

        public i(Exception exc) {
            this.f14684a = exc;
            put("action", "link_connect");
            put("status", "fail");
            put("error", "Exception:" + exc.getMessage());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UnsatisfiedLinkError f14685a;

        public j(UnsatisfiedLinkError unsatisfiedLinkError) {
            this.f14685a = unsatisfiedLinkError;
            put("action", "link_connect");
            put("status", "fail");
            put("error", "UnsatisfiedLinkError:" + unsatisfiedLinkError.getMessage());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface k {
        void a(boolean z);
    }

    public CreateConnectionDelegate(Context context, k kVar) {
        this.f14672a = context;
        this.b = kVar;
        this.c = context.getAssets();
    }

    private native JSONObject refreshServerKey(String str, String str2, String str3, String str4, String str5, String str6, AssetManager assetManager, String str7, boolean z);

    public final String b(String str) throws UnsupportedEncodingException {
        return k86.Z(nl0.r + "/one/ax/dispatch.select.v4") + "&username=" + str + "&version=public_1.1.0";
    }

    public final JSONArray c(String str) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("uid is null");
        }
        RequestQueue requestQueue = VolleyNetwork.getRequestQueue();
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        requestQueue.add(new JsonObjectRequest(0, b(str), null, requestFutureNewFuture, requestFutureNewFuture));
        try {
            jSONObject = (JSONObject) requestFutureNewFuture.get(50L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
        }
        try {
            if (jSONObject.getInt("resultCode") != 0 || (jSONObject2 = jSONObject.getJSONObject("data")) == null) {
                return null;
            }
            return jSONObject2.getJSONArray("cms");
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            LogUtil.i(d, 3, new a(e, jSONObject), e);
            if (e.getCause() == null) {
                return null;
            }
            if (!(e.getCause().getCause() instanceof JSONException) && !(e.getCause() instanceof AuthFailureError)) {
                return null;
            }
            Intent intent = new Intent();
            intent.setAction(EncryptedJsonRequest.JSON_PARSE_ERROR);
            LocalBroadcastManager.getInstance(this.f14672a).sendBroadcast(intent);
            return null;
        }
    }

    public final long d(int i2) {
        long j2 = i2 * 3;
        GlobalConfig globalConfigE = rl0.h().e();
        if (globalConfigE == null) {
            return j2;
        }
        long jE = globalConfigE.e();
        return jE > j2 ? jE : j2;
    }

    public void e(String str, String str2, String str3) throws Exception {
        JSONObject jSONObjectRefreshServerKey;
        LogUtil.i("CreateConnectionDelegate_LXSK", "refreshServerKey start" + Thread.currentThread());
        if (TextUtils.isEmpty(str)) {
            throw new Exception("uid is null");
        }
        synchronized (e) {
            if (AppContext.getSecretKey(false) == null) {
                LogUtil.i("CreateConnectionDelegate_LXSK", "refreshServerKey 1111111=====");
                String str4 = nl0.z + "/token.ak.v12";
                boolean zD = g9.d();
                if (zD) {
                    str4 = nl0.z + "/token.ak.v13";
                }
                String strB0 = k86.b0(str4 + "?did=" + Uri.encode(ac1.o, null), str, str2);
                try {
                    try {
                        if (zD) {
                            jSONObjectRefreshServerKey = refreshServerKey(str2, str3, ac1.v(), EncryptUtils.getCkVersion(), g9.c(true), g9.c(false), this.c, strB0, nl0.k());
                            g9.f(jSONObjectRefreshServerKey);
                        } else {
                            jSONObjectRefreshServerKey = refreshServerKey(str2, str3, ac1.v(), EncryptUtils.getCkVersion(), null, null, this.c, strB0, nl0.k());
                        }
                        LXRequestHelper.getInstance().notifyOnTokenReady();
                        LogUtil.i("CreateConnectionDelegate_LXSK", "refreshServerKey finish=====");
                        ko1.d(jSONObjectRefreshServerKey, AccountUtils.j(AppContext.getContext()));
                        Intent intent = new Intent();
                        intent.setAction(mo3.k);
                        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
                        LogUtil.i("ACTION_NOTIFY_RECIEVE_TOKEN", "refreshServerKey, sendbroadcast token receive");
                        LogUtil.i("CreateConnectionDelegate_LXSK", "refreshServerKey 222222=====");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        throw e2;
                    }
                } catch (Throwable th) {
                    LXRequestHelper.getInstance().notifyOnTokenReady();
                    throw th;
                }
            }
        }
        LogUtil.i("CreateConnectionDelegate_LXSK", "refreshServerKey end ");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        k kVar;
        String str;
        long jB;
        String strP;
        JSONArray jSONArrayC;
        int i2;
        String str2;
        lm0 lm0Var;
        int iD;
        boolean z = true;
        if (!com.zenmen.palmchat.messaging.b.d().c().m()) {
            try {
                try {
                    str = d;
                    LogUtil.i(str, "msg_reconnect startCreateConnectionDelegate");
                    jB = ir5.b();
                    strP = AccountUtils.p(AppContext.getContext());
                    jSONArrayC = c(strP);
                } catch (UnsatisfiedLinkError e2) {
                    LogUtil.i(d, LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new j(e2), (Throwable) null);
                    e2.printStackTrace();
                    z = false;
                    kVar = this.b;
                    if (kVar == null) {
                    }
                }
            } catch (TokenInValidateException e3) {
                LogUtil.i(d, LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new g(e3), (Throwable) null);
                LogUtil.d(MessagingService.c, "start startConnectXNetwork on TokenInValidateException ", e3, 3);
                try {
                    MessagingService.setSecretKeys(null, null);
                    try {
                        com.zenmen.palmchat.messaging.b.d().c().w(false, "STASRT_REASON_TOKEN_INVALIDE");
                    } catch (UnsatisfiedLinkError unused) {
                        e3.printStackTrace();
                    }
                } catch (UnsatisfiedLinkError unused2) {
                }
            } catch (SessionInvalidException e4) {
                LogUtil.i(d, LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new h(e4), (Throwable) null);
                LogUtil.d(MessagingService.c, "start startConnectXNetwork on SessionInvalidException ", e4, 3);
                r75.s(true);
                LocalBroadcastManager.getInstance(this.f14672a).sendBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_KICKOUT));
            } catch (Exception e5) {
                LogUtil.i(d, LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new i(e5), (Throwable) null);
                e5.printStackTrace();
                com.zenmen.palmchat.messaging.b.d().c().t(null);
                LogUtil.d(MessagingService.c, "start startConnectXNetwork on Exception ", e5, 3);
                com.zenmen.palmchat.messaging.b.d().c().w(false, "STASRT_REASON_CONNECT_EXCEPTION");
            }
            if (jSONArrayC == null) {
                com.zenmen.palmchat.messaging.b.d().c().w(false, "STASRT_REASON_DISPATCH_FAIL");
                z = false;
            } else {
                LogUtil.i(str, 3, new b(jSONArrayC, jB), (Throwable) null);
                e(strP, AccountUtils.o(this.f14672a.getApplicationContext()), AccountUtils.m(this.f14672a.getApplicationContext()));
                LogUtil.i(str, "window.onTokenReady sent");
                LocalBroadcastManager.getInstance(this.f14672a).sendBroadcast(new Intent("sk_ready"));
                int i3 = 0;
                while (i3 < jSONArrayC.length()) {
                    JSONObject jSONObject = jSONArrayC.getJSONObject(i3);
                    String string = jSONObject.getString("host");
                    int i4 = jSONObject.getInt(ReportItem.RequestKeyPort);
                    try {
                        str2 = d;
                        LogUtil.i(str2, LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new c(), (Throwable) null);
                        lm0Var = new lm0(string, i4);
                        iD = MessagingService.d();
                        i2 = i3;
                    } catch (Exception e6) {
                        e = e6;
                        i2 = i3;
                    }
                    try {
                        lm0Var.h(iD, d(iD));
                        LogUtil.i(str2, "createConnect_config" + lm0Var.b() + " " + lm0Var.c());
                        com.zenmen.palmchat.messaging.b.d().c().t(new xo6(lm0Var));
                        com.zenmen.palmchat.messaging.b.d().c().g().m();
                        bx4.a(strP, "msg_login");
                        com.zenmen.palmchat.messaging.b.d().c().g().v(strP, null, "android");
                        break;
                    } catch (Exception e7) {
                        e = e7;
                        if (com.zenmen.palmchat.messaging.b.d().c().g() != null) {
                            com.zenmen.palmchat.messaging.b.d().c().g().l();
                        }
                        LogUtil.i(d, 3, new d(e, string, i4), (Throwable) null);
                        if ((e instanceof TokenInValidateException) || (e instanceof SessionInvalidException)) {
                            throw e;
                        }
                        int i5 = i2;
                        if (i5 == jSONArrayC.length() - 1) {
                            throw e;
                        }
                        i3 = i5 + 1;
                    }
                }
                com.zenmen.palmchat.messaging.b.d().c().g().x();
                com.zenmen.palmchat.messaging.b.d().c().u(true);
                com.zenmen.palmchat.messaging.b.d().c().o();
                s34.l();
                LogUtil.i(d, LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new e(), (Throwable) null);
                com.zenmen.palmchat.messaging.b.d().c().g().a(new f());
                com.zenmen.palmchat.messaging.b.d().c().g().b(new wt4(), new lb4(MessageProto.Message.class));
            }
        }
        kVar = this.b;
        if (kVar == null) {
            kVar.a(z);
        }
    }

    public CreateConnectionDelegate() {
        this.c = AppContext.getContext().getAssets();
    }
}
