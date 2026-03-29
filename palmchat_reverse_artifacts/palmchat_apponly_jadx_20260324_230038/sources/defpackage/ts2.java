package defpackage;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lantern.auth.server.WkParams;
import com.ss.android.download.api.constant.BaseConstants;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.NoticeBarStyle;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.NewContactActivity;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.login.LogInWithLastUserInfoActivity;
import com.zenmen.palmchat.loginnew.AuthLoginActivity;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyVo;
import com.zenmen.palmchat.smallvideo.EnterScene;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.c;
import defpackage.x84;
import defpackage.zm4;
import java.util.HashMap;
import org.apache.cordova.jssdk.general.Action;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ts2 {
    public static final String v = "ts2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f21052a;
    public InitActivity b;
    public boolean c;
    public xs2 i;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public String q;
    public boolean r;
    public int t;
    public boolean u;
    public boolean d = true;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public String h = null;
    public boolean j = false;
    public boolean k = false;
    public boolean s = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21053a;

        public a(String str) {
            this.f21053a = str;
            put("host", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AccountUtils.d(AppContext.getContext());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements x84.b {
        public c() {
        }

        @Override // x84.b
        public void a() {
            if (ts2.this.b == null || ts2.this.b.isFinishing()) {
                return;
            }
            ts2.this.b.C1();
        }

        @Override // x84.b
        public void b(View view) {
            ts2.this.b.findViewById(R.id.root_view).setVisibility(0);
            ts2.this.f21052a.setVisibility(0);
            ts2.this.f21052a.removeAllViews();
            ts2.this.f21052a.addView(view);
            if (dw3.y().equals("A")) {
                return;
            }
            x6.a().d(true);
            x6.a().e();
            LogUtil.d(ts2.v, "isSHowOpenScreen setOpenscreen ");
        }

        @Override // x84.b
        public void onError(String str) {
            if (ts2.this.b == null || ts2.this.b.isFinishing()) {
                return;
            }
            ts2.this.b.C1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends zm4.h {
        public d() {
        }

        @Override // zm4.h
        public void a(Dialog dialog) {
            super.a(dialog);
            ts2.i(ts2.this.b);
        }

        @Override // zm4.h
        public void b(Dialog dialog) {
            super.b(dialog);
            r75.t();
            AppContext.getContext().initGroupSDKWithPrivacyCheck();
            ch.s().Z();
            LogUtil.uploadInfoImmediate("lx_client_login_popagree", x63.d());
            zn6.j("lx_client_login_popagree", "click", x63.d());
            ts2.this.b.C1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ts2.this.b.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ts2.this.p();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements c.e {
            public b() {
            }

            @Override // c.e
            public void onFinish() {
                synchronized (this) {
                    if (!ts2.this.k) {
                        ts2.this.k = true;
                    }
                }
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u93.b(2000, new a());
            if (defpackage.c.j().i() == 0) {
                defpackage.c.j().p(new b());
            }
        }
    }

    public ts2(InitActivity initActivity) {
        boolean z = true;
        this.b = initActivity;
        this.q = initActivity.x;
        this.r = initActivity.w;
        this.t = initActivity.E1();
        String strP = AccountUtils.p(AppContext.getContext());
        String strO = AccountUtils.o(AppContext.getContext());
        if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strO)) {
            z = false;
        }
        this.c = z;
    }

    public static String g(String str, String str2) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("widgetType", String.valueOf(str2));
        return builderBuildUpon.build().toString();
    }

    public static String h(String str) {
        Uri uri;
        if (str != null && str.startsWith("zenxin") && (uri = Uri.parse(str)) != null) {
            String queryParameter = uri.getQueryParameter("widgetType");
            LogUtil.i(v, "checkClickEvent" + queryParameter);
            if (!TextUtils.isEmpty(queryParameter)) {
                HashMap map = new HashMap();
                map.put("type", String.valueOf(queryParameter));
                zn6.h("widget_window", "click", map);
                return queryParameter;
            }
        }
        return null;
    }

    public static void i(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", tj2.C());
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putBoolean("hide_toolbar", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtra("needCheckAccount", false);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public final String A(Uri uri) {
        if (uri != null) {
            return uri.getQueryParameter(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    public final String B(Uri uri) {
        if (uri != null) {
            return uri.getQueryParameter("pushType");
        }
        return null;
    }

    public final String C(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optString("from");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void D(Intent intent) {
        boolean booleanExtra;
        NoticeBarStyle fromMsgExtension;
        Pair<Integer, ContentValues> pairG;
        Object obj;
        String scheme;
        if (intent != null) {
            try {
                String str = v;
                LogUtil.i(str, "intent: " + intent.toString());
                LogUtil.i(str, "intent action: " + intent.getAction());
                this.n = intent.getStringExtra("key_push_extension");
                this.p = intent.getIntExtra("key_mime_type", 0);
                LogUtil.i(str, "intent mExtension: " + this.n);
                if (intent.getAction() != null && intent.getExtras() != null && intent.getAction().equals("com.coloros.push.internal")) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("action");
                    if (!TextUtils.isEmpty(string)) {
                        this.g = true;
                        this.h = "oppo";
                        this.l = string;
                    }
                    String string2 = extras.getString(BaseConstants.EVENT_LABEL_EXTRA);
                    LogUtil.i(str, "intent extra: " + string2);
                    if (!TextUtils.isEmpty(string2)) {
                        this.o = string2;
                        this.m = C(string2);
                        n();
                    }
                }
                LogUtil.e(str, "action是:" + intent.toUri(1));
                try {
                    MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushMessageHelper.KEY_MESSAGE);
                    if (miPushMessage != null) {
                        JSONObject jSONObject = new JSONObject(miPushMessage.getExtra());
                        LogUtil.i(str, "msgContent = " + jSONObject);
                        String strOptString = jSONObject.optString("scheme");
                        if (strOptString != null && strOptString.equals("thirdpush")) {
                            String strOptString2 = jSONObject.optString(RemoteMessageConst.MessageBody.PARAM);
                            this.g = true;
                            this.h = "xiaomi";
                            this.l = strOptString2;
                            this.m = jSONObject.optString("from");
                            this.o = jSONObject.toString();
                            n();
                        }
                    }
                } catch (NoClassDefFoundError unused) {
                }
                Uri data = intent.getData();
                if (data != null && (scheme = data.getScheme()) != null && scheme.equals("thirdpush")) {
                    String strA = A(data);
                    String str2 = v;
                    LogUtil.i(str2, "intent geturi: " + data.toString());
                    this.g = true;
                    this.h = "vivo";
                    String strB = B(data);
                    if (!TextUtils.isEmpty(strB)) {
                        this.h = strB;
                    }
                    this.l = strA;
                    String strZ = z(data);
                    LogUtil.i(str2, "intent extra: " + strZ);
                    if (!TextUtils.isEmpty(strZ)) {
                        this.o = strZ;
                        this.m = C(strZ);
                        n();
                    }
                }
                booleanExtra = intent.getBooleanExtra("key_from_push", false);
                this.f = booleanExtra;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!booleanExtra) {
                this.d = !intent.getBooleanExtra("login.ispwd", false);
                this.e = intent.getBooleanExtra("self_logout", false);
                this.i = x(intent);
                Uri data2 = intent.getData();
                if (data2 != null) {
                    String scheme2 = data2.getScheme();
                    String host = data2.getHost();
                    String path = data2.getPath();
                    if (scheme2 != null) {
                        if (scheme2.equals("nearby")) {
                            this.j = true;
                            return;
                        }
                        if (scheme2.equals("zenxin")) {
                            if (host == null || !host.equals("activity")) {
                                return;
                            }
                            if (path != null && path.equals("/init")) {
                                this.i = w(data2);
                                return;
                            } else {
                                if (path == null || !path.equals("/wfinit")) {
                                    return;
                                }
                                this.i = y(data2);
                                return;
                            }
                        }
                        if (scheme2.equals("push")) {
                            LogUtil.i("pushTag", "extra: " + intent.getExtras().toString());
                            return;
                        }
                        if ((HttpHost.DEFAULT_SCHEME_NAME.equals(scheme2) || BaseConstants.SCHEME_HTTPS.equals(scheme2)) && host != null) {
                            if ("short2.lx-qa.com".equals(host) || "lx1.cn".equals(host) || "lx0.cn".equals(host)) {
                                LogUtil.i("appLinks", "scheme:" + scheme2 + " host:" + host + " path:" + path);
                                LogUtil.uploadInfoImmediate("recallopen0817", new a(host));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            String stringExtra = intent.getStringExtra("key_push_param");
            this.l = stringExtra;
            String strH = h(stringExtra);
            if (!TextUtils.isEmpty(strH)) {
                if (strH.equals("pop")) {
                    zn6.b("keepalive_pop_success");
                    return;
                }
                if (strH.equals("pop_notice")) {
                    zn6.c("keepalive_notice", "click");
                    return;
                }
                HashMap map = new HashMap();
                map.put("widgetType", strH);
                map.put("url", this.l);
                vt0.d().k(7, new JSONObject(map));
                hs.d("update_click", strH);
                return;
            }
            String stringExtra2 = intent.getStringExtra("chat_from");
            String stringExtra3 = intent.getStringExtra("key_notification_style_type");
            if (stringExtra2 != null && stringExtra2.equals("CHAT_FROM_NOTIFICATION")) {
                String stringExtra4 = intent.getStringExtra("chat_notification_mid");
                String stringExtra5 = intent.getStringExtra("key_push_chatitem_id");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("mid", stringExtra4);
                    jSONObject2.put("style", stringExtra3);
                    if (stringExtra5 != null) {
                        jSONObject2.put("fromuid", stringExtra5);
                        if (h05.c(stringExtra5)) {
                            jSONObject2.put("type", "H-feedpush");
                        }
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("msg_cli", "1", null, jSONObject2.toString());
                vt0.d().i(3, jSONObject2.toString());
                return;
            }
            String stringExtra6 = intent.getStringExtra("key_push_mid");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("style", stringExtra3);
                if (stringExtra6 == null) {
                    stringExtra6 = "";
                }
                jSONObject3.put("mid", stringExtra6);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("p3", null, null, jSONObject3.toString());
            if (this.p == 103) {
                if (!TextUtils.isEmpty(this.n) && (fromMsgExtension = NoticeBarStyle.parseFromMsgExtension(this.n)) != null && (pairG = mb4.g(fromMsgExtension.url)) != null && (obj = pairG.second) != null) {
                    for (String str3 : ((ContentValues) obj).keySet()) {
                        jSONObject3.put(str3, ((ContentValues) pairG.second).get(str3));
                    }
                }
                jSONObject3.put("from", "square");
                LogUtil.uploadInfoImmediate("msg_cli", "1", null, jSONObject3.toString());
            }
            vt0.d().i(3, jSONObject3.toString());
            return;
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x02db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E() throws JSONException {
        String stringExtra;
        ContactInfoItem contactInfoItem;
        Intent intent;
        JSONObject jSONObject;
        PeopleNearbyVo peopleNearbyVo;
        PeopleNearbyVo peopleNearbyVo2;
        if (this.j) {
            LogUtil.onClickEvent("002", null, null);
            Intent intentE = st2.e(true, true);
            intentE.addFlags(67108864);
            this.b.startActivity(intentE);
            this.b.finish();
            return;
        }
        if (this.f || this.g) {
            if (TextUtils.isEmpty(this.l)) {
                this.b.startActivity(new Intent(this.b, (Class<?>) MainTabsActivity.class));
                this.b.finish();
                return;
            }
            if (TextUtils.isEmpty(this.l)) {
                return;
            }
            xa3.b("click", this.n, this.g ? "vendor" : "self");
            if (d73.c(this.b, this.l)) {
                this.b.finish();
                return;
            }
            Pair<Integer, ContentValues> pairG = mb4.g(this.l);
            if (pairG == null) {
                k();
                return;
            }
            try {
                if (!this.g) {
                    try {
                        stringExtra = this.b.getIntent().getStringExtra("key_push_chatitem_id");
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (stringExtra != null) {
                        contactInfoItem = new ContactInfoItem();
                        contactInfoItem.setUid(stringExtra);
                    } else {
                        contactInfoItem = null;
                    }
                }
                if (contactInfoItem == null && !TextUtils.isEmpty(this.m) && a65.f(this.m)) {
                    contactInfoItem = new ContactInfoItem();
                    contactInfoItem.setUid(this.m);
                }
                if (!d73.e(this.b, this.g, ((Integer) pairG.first).intValue(), (ContentValues) pairG.second, this.l, !a65.e(contactInfoItem) ? null : contactInfoItem)) {
                    k();
                    return;
                } else if (d73.f(this.l)) {
                    this.b.y.postDelayed(new e(), 5000L);
                    return;
                } else {
                    this.b.finish();
                    return;
                }
            } catch (Exception unused) {
                k();
                return;
            }
        }
        String strP = AccountUtils.p(AppContext.getContext());
        xs2 xs2Var = this.i;
        if (xs2Var != null && !TextUtils.isEmpty(xs2Var.b) && !strP.equals(this.i.b)) {
            sy5.e(this.b, R.string.wifi_jump_account_diff, 1).g();
            this.b.startActivity(new Intent(this.b, (Class<?>) MainTabsActivity.class));
            this.b.finish();
            return;
        }
        xs2 xs2Var2 = this.i;
        if (xs2Var2 != null && Action.ACTION_ADD_FRIEND.equals(xs2Var2.f22041a)) {
            Intent intentB = NewContactActivity.h.b(this.b);
            intentB.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
            intentB.addFlags(67108864);
            this.b.startActivity(intentB);
            this.b.finish();
            return;
        }
        xs2 xs2Var3 = this.i;
        if (xs2Var3 != null && Action.ACTION_SENDMSG.equals(xs2Var3.f22041a) && (peopleNearbyVo2 = this.i.d) != null) {
            UserDetailActivity.p3(this.b, 11, peopleNearbyVo2, true);
            this.b.finish();
            return;
        }
        xs2 xs2Var4 = this.i;
        if (xs2Var4 != null && "editProfile".equals(xs2Var4.f22041a)) {
            Intent intentA = nn4.a(this.b, 10);
            intentA.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
            intentA.addFlags(67108864);
            this.b.startActivity(intentA);
            this.b.finish();
            return;
        }
        xs2 xs2Var5 = this.i;
        if (xs2Var5 != null && "userDetail".equals(xs2Var5.f22041a) && (peopleNearbyVo = this.i.d) != null) {
            ig4.h(this.b, peopleNearbyVo, true);
            this.b.finish();
            return;
        }
        xs2 xs2Var6 = this.i;
        if (xs2Var6 != null && "sendGroupMsg".equals(xs2Var6.f22041a) && (jSONObject = this.i.e) != null) {
            this.b.K1(jSONObject);
            this.b.finish();
            return;
        }
        xs2 xs2Var7 = this.i;
        if (xs2Var7 != null && "nearby".equals(xs2Var7.f22041a)) {
            Intent intentD = st2.d(true);
            intentD.addFlags(67108864);
            this.b.startActivity(intentD);
            this.b.finish();
            return;
        }
        xs2 xs2Var8 = this.i;
        if (xs2Var8 != null && "tabFriend".equals(xs2Var8.f22041a)) {
            this.b.startActivity(new Intent(this.b, (Class<?>) MainTabsActivity.class));
            this.b.finish();
            return;
        }
        xs2 xs2Var9 = this.i;
        if (xs2Var9 != null && "friendCycle".equals(xs2Var9.f22041a)) {
            n5.f(this.b, new Bundle());
            return;
        }
        xs2 xs2Var10 = this.i;
        if (xs2Var10 != null && "pushUrl".equals(xs2Var10.f22041a)) {
            try {
                ContactInfoItem contactInfoItemA = dn0.a(this.i.f);
                if (!TextUtils.isEmpty(this.i.g)) {
                    intent = new Intent(this.b, (Class<?>) CordovaWebActivity.class);
                    intent.putExtra("web_url", this.i.g);
                    intent.putExtra("back_jump_chatItem", contactInfoItemA);
                    intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
                } else if (contactInfoItemA != null) {
                    intent = new Intent(this.b, (Class<?>) ChatterActivity.class);
                    intent.putExtra("chat_item", contactInfoItemA);
                    intent.putExtra("chat_need_back_to_main", true);
                    intent.putExtra("chat_back_to_greet", false);
                } else {
                    intent = new Intent(this.b, (Class<?>) MainTabsActivity.class);
                }
                intent.addFlags(67108864);
                this.b.startActivity(intent);
                this.b.finish();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        xs2 xs2Var11 = this.i;
        if (xs2Var11 != null && "smallVideoPlay".equals(xs2Var11.f22041a)) {
            SmallVideoEntranceController.l(this.b, this.i.i, EnterScene.H5, null);
            this.b.finish();
            return;
        }
        xs2 xs2Var12 = this.i;
        if (xs2Var12 != null && "smallVideoScheme".equals(xs2Var12.f22041a)) {
            SmallVideoEntranceController.i(this.b, this.i.g, EnterScene.H5, null);
            this.b.finish();
            return;
        }
        xs2 xs2Var13 = this.i;
        if (xs2Var13 != null && "appUrl".equals(xs2Var13.f22041a)) {
            ve.o(this.b, this.i.g, false);
            this.b.finish();
            return;
        }
        kc3.c().l();
        try {
            Intent intent2 = new Intent(this.b, (Class<?>) MainTabsActivity.class);
            if (this.t == 1) {
                intent2.putExtra("from_daemon", true);
            }
            this.b.startActivity(intent2);
            this.b.finish();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void F() {
        m();
        ch.s().q0(new f(), 400L);
    }

    public final void G() {
        InitActivity initActivity = this.b;
        if (initActivity == null || initActivity.F1()) {
            return;
        }
        zm4.g(this.b, false, new d());
    }

    public final void H() {
        boolean z = !this.e && ts0.o().M();
        if (this.c || z) {
            this.b.setContentView(R.layout.layout_activity_init);
            this.f21052a = (FrameLayout) this.b.findViewById(R.id.splash_container);
        }
        if (!r75.l()) {
            G();
            return;
        }
        if (!z || this.f21052a == null) {
            this.b.C1();
            return;
        }
        if ("A".equals(dw3.y()) || !x6.a().c()) {
            w84.c().a(this.b, new c());
            return;
        }
        InitActivity initActivity = this.b;
        if (initActivity != null && !initActivity.isFinishing()) {
            this.b.C1();
        }
        LogUtil.d(v, "isSHowOpenScreen return ");
    }

    public final void j() {
        InitActivity initActivity = this.b;
        AuthLoginActivity.k2(initActivity, initActivity.v, initActivity.w);
        JSONObject jSONObjectG = x63.g();
        try {
            if (this.r) {
                jSONObjectG.put("from", "wblx1");
                String str = this.q;
                if (str != null) {
                    jSONObjectG.put("appid", str);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("9", null, jSONObjectG.toString());
        zn6.d("lx_client_login_9", null, jSONObjectG.toString());
    }

    public final void k() {
        this.b.startActivity(new Intent(this.b, (Class<?>) MainTabsActivity.class));
        this.b.finish();
    }

    public final void l(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null || !data.toString().contains("zenxin://activity/init")) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("dp_ack");
            String stringExtra2 = intent.getStringExtra("dp_src");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                Intent intent2 = new Intent();
                intent2.setAction("com.appara.deeplink.ack");
                intent2.setPackage(stringExtra2);
                intent2.putExtra("dp_ack", stringExtra);
                this.b.sendBroadcast(intent2);
            }
            JSONObject jSONObject = new JSONObject();
            if (stringExtra2 != null && stringExtra2.contains("com.snda.wifilocating")) {
                jSONObject.put("type", 1);
            }
            if (!TextUtils.isEmpty(data.getQueryParameter("channel"))) {
                jSONObject.put("channel", data.getQueryParameter("channel"));
            }
            if (!TextUtils.isEmpty(data.getQueryParameter("agent"))) {
                jSONObject.put("agent", data.getQueryParameter("agent"));
            }
            if (!TextUtils.isEmpty(data.getQueryParameter("referer"))) {
                jSONObject.put("referer", data.getQueryParameter("referer"));
            }
            if (!TextUtils.isEmpty(data.getQueryParameter("pushid"))) {
                jSONObject.put("pushid", data.getQueryParameter("pushid"));
            }
            if (!TextUtils.isEmpty(data.getQueryParameter("openURL"))) {
                jSONObject.put("openURL", data.getQueryParameter("openURL"));
            }
            jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
            LogUtil.uploadInfoImmediate(HiAnalyticsConstant.KeyAndValue.NUMBER_01, null, null, jSONObject.toString());
            String str = "";
            String encodedQuery = data.getEncodedQuery();
            if (!TextUtils.isEmpty(encodedQuery)) {
                for (String str2 : encodedQuery.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] strArrSplit = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (strArrSplit != null && strArrSplit.length == 2 && strArrSplit[0].equals("type")) {
                        str = strArrSplit[1];
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", str);
            LogUtil.uploadInfoImmediate(com.huawei.hms.ads.dynamic.a.t, null, null, jSONObject2.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m() {
        if (!this.c) {
            u93.e(new b());
            this.s = true;
        } else if (r75.l()) {
            if (this.d) {
                j();
            } else {
                this.b.startActivity(new Intent(this.b, (Class<?>) LogInWithLastUserInfoActivity.class));
            }
            this.b.finish();
        }
    }

    public final void n() {
        Pair<Integer, ContentValues> pairG;
        Object obj;
        NoticeBarStyle fromString;
        Pair<Integer, ContentValues> pairG2;
        Object obj2;
        Pair<Integer, ContentValues> pairG3;
        Object obj3;
        NoticeBarStyle fromString2;
        Pair<Integer, ContentValues> pairG4;
        Object obj4;
        if (TextUtils.isEmpty(this.o)) {
            return;
        }
        try {
            String strH = h(this.l);
            if (!TextUtils.isEmpty(strH)) {
                if (strH.equals("pop")) {
                    zn6.b("keepalive_pop_success");
                    return;
                }
                if (strH.equals("pop_notice")) {
                    zn6.c("keepalive_notice", "click");
                    return;
                }
                HashMap map = new HashMap();
                map.put("widgetType", strH);
                map.put("url", this.l);
                vt0.d().k(7, new JSONObject(map));
                return;
            }
            JSONObject jSONObject = new JSONObject(this.o);
            String strOptString = jSONObject.optString("from");
            if (h05.c(strOptString)) {
                jSONObject.put("type", "H-feedpush");
            }
            if (MediationConstant.RIT_TYPE_FEED.equals(strOptString) && !TextUtils.isEmpty(this.l) && (pairG3 = mb4.g(this.l)) != null && (obj3 = pairG3.second) != null && (fromString2 = NoticeBarStyle.parseFromString(((ContentValues) obj3).getAsString("noticeBar"))) != null && (pairG4 = mb4.g(fromString2.url)) != null && (obj4 = pairG4.second) != null) {
                Integer asInteger = ((ContentValues) obj4).getAsInteger("noticeType");
                if (asInteger != null && asInteger.intValue() == 0) {
                    jSONObject.put("type", 113);
                } else if (asInteger != null && asInteger.intValue() == 1) {
                    jSONObject.put("type", 114);
                }
                Integer asInteger2 = ((ContentValues) pairG4.second).getAsInteger("commentType");
                if (asInteger2 != null && asInteger2.intValue() == 11) {
                    jSONObject.put("action", 111);
                } else if (asInteger2 != null && asInteger2.intValue() == 12) {
                    jSONObject.put("action", 112);
                }
            }
            if (!TextUtils.isEmpty(this.l) && (pairG = mb4.g(this.l)) != null && (obj = pairG.second) != null && (fromString = NoticeBarStyle.parseFromString(((ContentValues) obj).getAsString("noticeBar"))) != null && (pairG2 = mb4.g(fromString.url)) != null && (obj2 = pairG2.second) != null) {
                for (String str : ((ContentValues) obj2).keySet()) {
                    jSONObject.put(str, ((ContentValues) pairG2.second).get(str));
                }
            }
            jSONObject.put("thirdPushType", this.h);
            LogUtil.uploadInfoImmediate("008", null, null, jSONObject.toString());
            vt0.d().i(3, jSONObject.toString());
            LogUtil.i(v, "THIRD_PUSH_CLICK: " + this.o);
        } catch (Exception unused) {
        }
    }

    public final void o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("dhid", ac1.y());
            jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
            jSONObject.put("hwMarketInfo", zj2.a(AppContext.getContext(), AppContext.getContext().getPackageName()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("init_hw_info", "1", null, jSONObject.toString());
    }

    public final boolean p() {
        int i = 0;
        if (!r75.d(AppContext.getContext(), "is_first_shortcut", true)) {
            return false;
        }
        r75.o(AppContext.getContext(), "is_first_shortcut", false);
        s75.a(this.b, R.drawable.ic_launcher, R.string.app_name);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("dhid", ac1.y());
            jSONObject.put("manufacturer", ac1.f1194a);
            jSONObject.put("deviceName", Build.MODEL);
            if (!hx3.m(this.b)) {
                i = 1;
            }
            jSONObject.put("wnet", i);
            jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
            if (this.r) {
                jSONObject.put("from", "wblx1");
                String str = this.q;
                if (str != null) {
                    jSONObject.put("appid", str);
                }
            }
            jSONObject.put("uainfo", ac1.x(AppContext.getContext()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("0", "1", null, jSONObject.toString());
        zn6.d("lx_client_login_0", null, jSONObject.toString());
        LogUtil.i(MdidSdkConfigHelper.TAG, "onAppInit");
        o();
        return true;
    }

    public boolean q() {
        return false;
    }

    public void r(Intent intent) {
        l(intent);
        D(intent);
        if (!this.c) {
            m();
        }
        vt0.d().l(intent, this.g | this.f);
        H();
    }

    public void s() {
        if (this.s) {
            E();
        } else if (this.c) {
            cl6.l();
            F();
        }
    }

    public void t(Intent intent) {
        l(intent);
        D(intent);
        if (this.c) {
            return;
        }
        m();
    }

    public void u() {
        this.u = false;
    }

    public void v() {
        this.u = true;
    }

    public final xs2 w(Uri uri) {
        String queryParameter = uri.getQueryParameter("referer");
        if (queryParameter == null) {
            return null;
        }
        if (queryParameter.equals("addfriend")) {
            return new xs2(Action.ACTION_ADD_FRIEND);
        }
        if (queryParameter.equals("nearby")) {
            return new xs2("nearby");
        }
        if (queryParameter.equals("peoplematch")) {
            return new xs2("peopleMatch");
        }
        if (queryParameter.equals("friendcycle")) {
            return new xs2("friendCycle");
        }
        if (queryParameter.equals("pushURL")) {
            xs2 xs2Var = new xs2("pushUrl");
            xs2Var.f = uri.getQueryParameter("pushid");
            xs2Var.g = uri.getQueryParameter("openURL");
            return xs2Var;
        }
        if (queryParameter.equals("smallVideoPlay")) {
            xs2 xs2Var2 = new xs2("smallVideoPlay");
            xs2Var2.h = uri.getQueryParameter("wid");
            xs2Var2.i = uri.getQueryParameter("wineFeedId");
            return xs2Var2;
        }
        if (queryParameter.equals("smallVideoScheme")) {
            xs2 xs2Var3 = new xs2("smallVideoScheme");
            xs2Var3.g = uri.getQueryParameter("url");
            return xs2Var3;
        }
        if (!queryParameter.equals("appUrl")) {
            return null;
        }
        xs2 xs2Var4 = new xs2("appUrl");
        xs2Var4.g = uri.getQueryParameter("scheme");
        return xs2Var4;
    }

    public final xs2 x(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    return xs2.a(new JSONObject(stringExtra));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final xs2 y(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("userstatus");
            String queryParameter2 = uri.getQueryParameter("action");
            if (!TextUtils.isEmpty(queryParameter2)) {
                xs2 xs2Var = new xs2();
                xs2Var.f22041a = queryParameter2;
                xs2Var.c = Boolean.parseBoolean(queryParameter);
                return xs2Var;
            }
        }
        return null;
    }

    public final String z(Uri uri) {
        if (uri != null) {
            return uri.getQueryParameter(BaseConstants.EVENT_LABEL_EXTRA);
        }
        return null;
    }
}
