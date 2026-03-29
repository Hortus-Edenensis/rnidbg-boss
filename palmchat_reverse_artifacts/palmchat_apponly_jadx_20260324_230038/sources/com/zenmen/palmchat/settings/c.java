package com.zenmen.palmchat.settings;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.notification.NotificationChannelManager;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.dm1;
import defpackage.eq3;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.jo6;
import defpackage.k86;
import defpackage.rl0;
import defpackage.sd3;
import defpackage.yg4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f15275a = Boolean.TRUE;
    public static c b;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f15277a;
        public final /* synthetic */ Activity b;

        public b(ChatItem chatItem, Activity activity) {
            this.f15277a = chatItem;
            this.b = activity;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
            sPUtil.t(scene, "key_refuse_count", Integer.valueOf(sPUtil.f(scene, "key_refuse_count", 0) + 1));
            LogUtil.onImmediateClickEvent("pug12", null, c.this.d(this.f15277a, -1));
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            int i = 0;
            if (!(!yg4.a(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), 256))) {
                c.this.l(this.f15277a, true);
                i = 1;
            }
            if (!com.zenmen.palmchat.utils.a.E().N()) {
                com.zenmen.palmchat.utils.a.E().y0(this.b);
                i += 2;
            }
            LogUtil.onImmediateClickEvent("pug11", null, c.this.d(this.f15277a, i));
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.settings.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1104c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f15278a;

        public C1104c(ChatItem chatItem) {
            this.f15278a = chatItem;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            iq5.j(false, new String[0]);
            LogUtil.onImmediateClickEvent("43181", null, c.this.d(this.f15278a, -1));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatItem f15279a;

        public d(ChatItem chatItem) {
            this.f15279a = chatItem;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.onImmediateClickEvent("43182", null, c.this.d(this.f15279a, -1));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15280a;
        public long b = 259200000;
        public long c = com.igexin.push.f.b.d.b;
        public boolean d;
    }

    public static c f() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public static boolean h() {
        if (!dm1.d() || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return jo6.a("LX-13343", false);
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public void b(ChatItem chatItem, Activity activity) {
        LogUtil.i("NotificationPerGuideHelper", "checkAndShowGuideDialog" + chatItem);
        if (k(chatItem)) {
            m(chatItem, activity);
        } else if (h() && com.zenmen.palmchat.utils.a.E().X() && i()) {
            n(chatItem, activity);
        }
    }

    public void c() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
        sPUtil.t(scene, "key_last_show_time", 0L);
        sPUtil.t(scene, "key_refuse_count", 0);
    }

    public final String d(ChatItem chatItem, int i) {
        JSONObject jSONObject = new JSONObject();
        if (chatItem != null) {
            try {
                jSONObject.put("pushguidetype", chatItem.getChatId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (i != -1) {
            jSONObject.put("putontype", i);
        }
        return jSONObject.toString();
    }

    public e e() {
        e eVar = new e();
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NOTIFYGUIDE);
        eVar.f15280a = dynamicConfig.isEnable();
        String extra = dynamicConfig.getExtra();
        LogUtil.i("NotificationPerGuideHelper", "getGuideConfig extra=" + extra);
        if (!TextUtils.isEmpty(extra)) {
            try {
                JSONObject jSONObject = new JSONObject(extra);
                eVar.b = ((long) (jSONObject.optInt("FirstGuideTime", 3) * 24 * 60 * 60)) * 1000;
                eVar.c = ((long) (jSONObject.optInt("GuideInterval", 7) * 24 * 60 * 60)) * 1000;
                boolean z = true;
                if (jSONObject.optInt("MesaagePush", 1) != 0) {
                    z = false;
                }
                eVar.d = z;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return eVar;
    }

    public boolean g() {
        e eVarE = e();
        boolean zA = (eVarE.f15280a && eVarE.d) ? true : true ^ yg4.a(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), 256);
        LogUtil.i("NotificationPerGuideHelper", "getNotificationStatus=" + zA);
        return zA;
    }

    public boolean i() {
        NotificationManager notificationManager;
        NotificationChannel notificationChannel;
        int importance;
        return Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) AppContext.getContext().getSystemService("notification")) != null && (notificationChannel = notificationManager.getNotificationChannel(NotificationChannelManager.MessageType.MSG.getNotificationChannel())) != null && (importance = notificationChannel.getImportance()) < 4 && importance > 0;
    }

    public final boolean k(ChatItem chatItem) {
        if (chatItem == null || !a65.e(chatItem) || com.zenmen.palmchat.utils.a.E().X()) {
            return false;
        }
        e eVarE = e();
        if (!eVarE.f15280a) {
            return false;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
        return Math.abs(sPUtil.i(scene, "key_last_show_time", 0L) - ir5.b()) > eVarE.c && sPUtil.f(scene, "key_refuse_count", 0) < 2;
    }

    public void l(ChatItem chatItem, boolean z) {
        LogUtil.i("NotificationPerGuideHelper", "setNotificationStatus=" + z);
        int iB = yg4.b(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), z ^ true, 256);
        AppContext.getContext().getTrayPreferences().f(k86.w(), iB);
        HashMap map = new HashMap();
        map.put("privacyConfig", Integer.valueOf(iB));
        try {
            new eq3(new C1104c(chatItem), new d(chatItem)).n(map);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void m(ChatItem chatItem, Activity activity) {
        SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "key_last_show_time", Long.valueOf(ir5.b()));
        LogUtil.onImmediateClickEvent("pug1", null, d(chatItem, -1));
        new sd3(activity).T(R.string.notify_guide_dialog_title).j(R.string.notify_guide_dialog_content).O(R.string.notify_guide_dialog_ok).K(R.string.notify_guide_dialog_cancle).f(new b(chatItem, activity)).h(false).Q();
    }

    public final void n(ChatItem chatItem, Activity activity) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
        if (sPUtil.a(scene, "key_hw_float", false)) {
            return;
        }
        sPUtil.t(scene, "key_hw_float", Boolean.TRUE);
        LogUtil.onImmediateClickEvent("fln1", null, null);
        new sd3(activity).T(R.string.notify_guide_dialog_title_float).j(R.string.notify_guide_dialog_content_float).O(R.string.notify_guide_dialog_ok).K(R.string.notify_guide_dialog_cancle).f(new a(activity)).h(true).Q();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f15276a;

        public a(Activity activity) {
            this.f15276a = activity;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            LogUtil.onImmediateClickEvent("fln11", null, null);
            com.zenmen.palmchat.utils.a.E().j0(this.f15276a, NotificationChannelManager.MessageType.MSG.getNotificationChannel());
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
        }
    }
}
