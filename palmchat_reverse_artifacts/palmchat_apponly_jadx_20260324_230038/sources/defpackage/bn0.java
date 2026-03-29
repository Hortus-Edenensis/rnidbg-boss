package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.RecommendRequestSendActivity;
import com.zenmen.palmchat.contacts.recommend.EnhanceRecommendActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.MainFeedTopAlertView;
import defpackage.jn0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class bn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1755a = "bn0";
    public static boolean b = false;
    public static int c;
    public static Runnable d = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1756a;

        public a(boolean z) {
            this.f1756a = z;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (this.f1756a && i == 4 && keyEvent.getRepeatCount() == 0) {
                dialogInterface.dismiss();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("2p34", "1", null, jSONObject.toString());
                zn6.d("lx_client_app_2p34", null, jSONObject.toString());
                bn0.b = false;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f1757a;

        public b(q qVar) {
            this.f1757a = qVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            bn0.b = false;
            this.f1757a.a(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f1758a;
        public final /* synthetic */ Activity b;

        public c(Dialog dialog, Activity activity) {
            this.f1758a = dialog;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1758a.dismiss();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2p34", "1", null, jSONObject.toString());
            zn6.d("lx_client_app_2p34", null, jSONObject.toString());
            if (this.b.isFinishing()) {
                return;
            }
            bn0.b = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f1759a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(Activity activity, String str, String str2) {
            this.f1759a = activity;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sy5.f(this.f1759a, ao0.e(), 0).g();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bizAction", this.b);
                jSONObject.put("fuid", this.c);
                jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2p32", "1", null, jSONObject.toString());
            zn6.d("lx_client_app_2p32", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ch.s().I();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1763a;
        public final /* synthetic */ Activity b;

        public g(boolean z, Activity activity) {
            this.f1763a = z;
            this.b = activity;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (this.f1763a && i == 4 && keyEvent.getRepeatCount() == 0) {
                dialogInterface.dismiss();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("2p34", "1", null, jSONObject.toString());
                zn6.d("lx_client_app_2p34", null, jSONObject.toString());
                if (!this.b.isFinishing()) {
                    bn0.b = false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f1764a;

        public h(q qVar) {
            this.f1764a = qVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            bn0.b = false;
            this.f1764a.a(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1765a;
        public final /* synthetic */ String b;

        public i(String str, String str2) {
            this.f1765a = str;
            this.b = str2;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                dialogInterface.dismiss();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
                    jSONObject.put("bizAction", this.f1765a);
                    jSONObject.put("type", this.b);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("2p34", "1", null, jSONObject.toString());
                zn6.d("lx_client_app_2p34", null, jSONObject.toString());
                bn0.b = false;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f1766a;
        public final /* synthetic */ Dialog b;

        public j(FrameworkBaseActivity frameworkBaseActivity, Dialog dialog) {
            this.f1766a = frameworkBaseActivity;
            this.b = dialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameworkBaseActivity frameworkBaseActivity = this.f1766a;
            if (frameworkBaseActivity == null || frameworkBaseActivity.isFinishing() || this.f1766a.isDestroyed() || !this.b.isShowing()) {
                return;
            }
            this.b.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f1767a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Runnable c;

        public k(q qVar, TextView textView, Runnable runnable) {
            this.f1767a = qVar;
            this.b = textView;
            this.c = runnable;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            bn0.b = false;
            this.f1767a.a(false);
            this.b.removeCallbacks(this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements rn {
        @Override // defpackage.rn
        public void run(int i, String str, Object obj) {
            bn0.b = ((Integer) obj).intValue() == 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements jn0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f1768a;

        public m(q qVar) {
            this.f1768a = qVar;
        }

        @Override // jn0.a
        public void a(Context context, ContactInfoItem contactInfoItem) {
            LogUtil.d(bn0.f1755a, "showContactChatDialog,onConfirm");
            bn0.b = false;
            this.f1768a.a(false);
            Intent intent = new Intent();
            intent.setClass(context, ChatterActivity.class);
            intent.putExtra("chat_item", contactInfoItem);
            intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
            if (fu5.u(contactInfoItem)) {
                intent.putExtra("chat_need_back_to_main", false);
                intent.putExtra("chat_back_to_greet", false);
            }
            context.startActivity(intent);
            LogUtil.uploadInfoImmediate("pagechat_card_cli", null);
        }

        @Override // jn0.a
        public void onCancel() {
            LogUtil.d(bn0.f1755a, "showContactChatDialog,onCancel");
            bn0.b = false;
            this.f1768a.a(false);
            LogUtil.uploadInfoImmediate("pagechat_card_close", null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f1769a;

        public n(Dialog dialog) {
            this.f1769a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1769a.dismiss();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2p34", "1", null, jSONObject.toString());
            zn6.d("lx_client_app_2p34", null, jSONObject.toString());
            bn0.b = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1770a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Dialog h;

        public o(String str, int i, Activity activity, String str2, String str3, String str4, String str5, Dialog dialog) {
            this.f1770a = str;
            this.b = i;
            this.c = activity;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f1770a)) {
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(this.f1770a);
                contactInfoItem.setSourceType(this.b);
                if (this.b == 14) {
                    bn0.n(this.c, this.d, contactInfoItem, false);
                } else {
                    bn0.m(this.c, this.e, this.d, contactInfoItem, false, false, this.f, this.g);
                }
            }
            this.h.dismiss();
            bn0.b = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sourcetype", this.b);
                jSONObject.put("bizAction", this.g);
                jSONObject.put("fromid", this.f1770a);
                jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2p32", "1", null, jSONObject.toString());
            zn6.d("lx_client_app_2p32", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1771a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Dialog i;

        public p(String str, String str2, int i, Activity activity, String str3, String str4, String str5, String str6, Dialog dialog) {
            this.f1771a = str;
            this.b = str2;
            this.c = i;
            this.d = activity;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 1;
            if (!TextUtils.isEmpty(this.f1771a)) {
                if ("apply".equals(this.b)) {
                    ContactInfoItem contactInfoItem = new ContactInfoItem();
                    contactInfoItem.setUid(this.f1771a);
                    contactInfoItem.setSourceType(this.c);
                    if (this.c == 14) {
                        bn0.n(this.d, this.e, contactInfoItem, true);
                    } else {
                        bn0.m(this.d, this.f, this.e, contactInfoItem, true, false, this.g, this.b);
                    }
                } else if ("agree".equals(this.b)) {
                    ContactInfoItem contactInfoItemL = bo0.r().l(this.f1771a);
                    if (contactInfoItemL != null) {
                        Intent intent = new Intent(this.d, (Class<?>) ChatterActivity.class);
                        intent.putExtra("chat_item", contactInfoItemL);
                        intent.putExtra("chat_need_back_to_main", false);
                        k86.X(intent);
                        this.d.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent();
                        ContactInfoItem contactInfoItem2 = new ContactInfoItem();
                        contactInfoItem2.setUid(this.f1771a);
                        intent2.setClass(this.d, m66.c());
                        intent2.putExtra("user_item_info", contactInfoItem2);
                        intent2.putExtra("user_real_name", this.g);
                        this.d.startActivity(intent2);
                    }
                } else if ("add".equals(this.b) || "enter".equals(this.b)) {
                    ContactInfoItem contactInfoItem3 = new ContactInfoItem();
                    contactInfoItem3.setUid(this.f1771a);
                    contactInfoItem3.setNickName(this.h);
                    contactInfoItem3.setSourceType(this.c);
                    contactInfoItem3.setIdentifyCode(this.f);
                    if (jo6.q()) {
                        contactInfoItem3.setRequestType(this.c == 3 ? 126 : 226);
                        Intent intent3 = new Intent(this.d, (Class<?>) RecommendRequestSendActivity.class);
                        intent3.putExtra("uid_key", this.f1771a);
                        intent3.putExtra("user_item_info_key", contactInfoItem3);
                        intent3.putExtra("source_type_key", this.c);
                        intent3.putExtra("subtype_key", "enter".equals(this.b) ? 95 : 92);
                        intent3.putExtra("real_name", this.g);
                        intent3.putExtra("send_from_type", 2);
                        this.d.startActivity(intent3);
                    } else {
                        bn0.m(this.d, this.f, this.e, contactInfoItem3, false, true, this.g, this.b);
                    }
                }
            }
            this.i.dismiss();
            bn0.b = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sourcetype", this.c);
                jSONObject.put("bizAction", this.b);
                jSONObject.put("fromid", this.f1771a);
                if (!com.zenmen.palmchat.smallvideo.a.a()) {
                    i = 0;
                }
                jSONObject.put("dou", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2p33", "1", null, jSONObject.toString());
            zn6.d("lx_client_app_2p33", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface q {
        void a(boolean z);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00be A[Catch: Exception -> 0x00c2, TRY_LEAVE, TryCatch #1 {Exception -> 0x00c2, blocks: (B:6:0x0013, B:8:0x001a, B:10:0x0024, B:13:0x002d, B:15:0x0033, B:29:0x00b5, B:31:0x00be, B:17:0x0043, B:19:0x0062, B:20:0x0067, B:24:0x0085, B:28:0x0092, B:27:0x008f), top: B:38:0x0013, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(Activity activity, q qVar) {
        JSONObject jSONObjectK;
        boolean z = false;
        if (!activity.isFinishing() && (jSONObjectK = k()) != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONObjectK.optInt("type") == 3 || um1.b().c()) {
                if (jSONObjectK.optInt("type") == 3 && jSONObjectK.has(BaseConstants.EVENT_LABEL_EXTRA)) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectK.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                    jSONObjectOptJSONObject.put("bizAction", jSONObjectK.optString("bizAction"));
                    r(activity, jSONObjectOptJSONObject, qVar);
                } else {
                    if (Math.abs(System.currentTimeMillis() - SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_dialog_show_time"), 0L)) > io0.f()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("sourcetype", 0);
                            jSONObject.put("bizAction", jSONObjectK.optString("bizAction"));
                            jSONObject.put("fromid", "");
                            jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
                            jSONObject.put("type", "landpage");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        LogUtil.uploadInfoImmediate("2p31", "1", null, jSONObject.toString());
                        SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_dialog_show_time"), Long.valueOf(System.currentTimeMillis()));
                        EnhanceRecommendActivity.I1(activity);
                    } else {
                        bp4.c();
                        if (jo6.E()) {
                            bp4.f();
                        }
                    }
                    e2.printStackTrace();
                }
                z = true;
                bp4.c();
                if (jo6.E()) {
                }
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(FrameworkBaseActivity frameworkBaseActivity, q qVar) {
        boolean zS;
        JSONObject jSONObjectJ;
        LogUtil.d("ContactAlert", "isContactAlertShow " + l());
        boolean zE = false;
        if (!l() && hx3.m(frameworkBaseActivity)) {
            try {
                JSONObject jSONObjectI = i();
                LogUtil.d("ContactAlert", "alertObj " + jSONObjectI);
                boolean z = true;
                if (jSONObjectI != null && "top_alert".equals(jSONObjectI.optString("bizAction")) && (fc3.l().g() || "cna2023".equals(jSONObjectI.optString("type")))) {
                    int iG = g(jSONObjectI);
                    if (iG > 0) {
                        frameworkBaseActivity.getWindow().getDecorView().removeCallbacks(d);
                        frameworkBaseActivity.getWindow().getDecorView().postDelayed(d, ((long) iG) * 1000);
                        return false;
                    }
                    v(frameworkBaseActivity, jSONObjectI, qVar);
                    bp4.b();
                    if (jo6.E()) {
                        bp4.e();
                    } else {
                        bp4.c();
                    }
                    return true;
                }
                if (!jo6.E() || (jSONObjectJ = j()) == null) {
                    zS = false;
                } else {
                    zS = s(frameworkBaseActivity, jSONObjectJ, qVar);
                    try {
                        bp4.a();
                        bp4.d();
                    } catch (Exception e2) {
                        e = e2;
                        zE = zS;
                        e.printStackTrace();
                        if (zE) {
                        }
                        return zE;
                    }
                }
                if (zS || bp4.q()) {
                    zE = zS;
                } else {
                    JSONObject jSONObjectI2 = i();
                    if (jSONObjectI2 != null) {
                        if (io0.p(jSONObjectI2.optInt("sourceType"))) {
                            if (!jo6.E()) {
                                bp4.c();
                            }
                        } else if (e(frameworkBaseActivity, qVar)) {
                            zE = true;
                        }
                        if (zE) {
                            if (!jo6.E()) {
                                bp4.b();
                            }
                            z = zS;
                        } else {
                            if ("newuser".equals(jSONObjectI2.optString("bizAction"))) {
                                u(frameworkBaseActivity, jSONObjectI2, qVar);
                            } else {
                                r(frameworkBaseActivity, jSONObjectI2, qVar);
                            }
                            try {
                                bp4.b();
                                if (jo6.E()) {
                                    bp4.e();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                zE = true;
                                e.printStackTrace();
                            }
                        }
                        zE = z;
                    } else {
                        zE = e(frameworkBaseActivity, qVar);
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
        if (zE) {
            bp4.y();
        }
        return zE;
    }

    public static int g(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("showDelay");
        if (jSONObject.optBoolean("isDelayIng", false)) {
            return 0;
        }
        if (iOptInt > 0) {
            try {
                jSONObject.put("isDelayIng", true);
                SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_content_common", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return iOptInt;
    }

    public static int h(int i2, String str) {
        return ("enter".equals(str) || io0.p(i2)) ? R.layout.layout_dialog_contact_alert_style4 : R.layout.layout_dialog_contact_alert_style1;
    }

    public static JSONObject i() {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_content_common", "");
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strN);
            if (jSONObject.optLong("expireTime") > System.currentTimeMillis()) {
                return jSONObject;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject j() {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_content_chat_card", "");
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strN);
            if (jSONObject.optLong("expireTime") > System.currentTimeMillis()) {
                return jSONObject;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject k() {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.CONTACT, "key_pull_wake_content_enhanced", "");
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strN);
            if (jSONObject.optLong("expireTime") > System.currentTimeMillis()) {
                return jSONObject;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean l() {
        return b;
    }

    public static void m(Activity activity, String str, String str2, ContactInfoItem contactInfoItem, boolean z, boolean z2, String str3, String str4) {
        PhoneContactItem phoneContactItem;
        rn0.r(contactInfoItem.getUid());
        Intent intent = new Intent(activity, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItem);
        if (jo6.q()) {
            if (z) {
                intent.putExtra("from", 7);
            } else {
                intent.putExtra("from", 8);
                intent.putExtra("new_request_send_page", true);
                intent.putExtra("send_from_type", 2);
            }
        } else if (z) {
            intent.putExtra("from", 7);
        } else {
            intent.putExtra("from", 8);
        }
        intent.putExtra("rid", str2);
        intent.putExtra("isAccept", z);
        intent.putExtra("autoAdd", z2);
        if (z) {
            intent.putExtra("agree_subtype", 4);
        } else {
            intent.putExtra("subtype_key", "enter".equals(str4) ? 95 : 92);
        }
        intent.putExtra("extra_request_type", contactInfoItem.getRequestType());
        if (!TextUtils.isEmpty(str) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str)) != null) {
            intent.putExtra("user_detail_local_phone_number", phoneContactItem.y());
        }
        intent.putExtra("user_real_name", str3);
        activity.startActivity(intent);
    }

    public static void n(Activity activity, String str, ContactInfoItem contactInfoItem, boolean z) {
        if (TeenagersModeManager.a().d()) {
            zt5.c();
            return;
        }
        Intent intentC = st2.c();
        intentC.putExtra("fromType", 13);
        intentC.putExtra("user_item_info", contactInfoItem);
        intentC.putExtra("rid", str);
        intentC.putExtra("isAccept", z);
        activity.startActivity(intentC);
    }

    public static /* synthetic */ void o(FrameworkBaseActivity frameworkBaseActivity, String str, Dialog dialog, String str2, String str3, String str4, View view) {
        ve.s(frameworkBaseActivity, str, false);
        dialog.dismiss();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizAction", str2);
            jSONObject.put("fromid", str3);
            jSONObject.put("type", str4);
            jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("2p33", "1", null, jSONObject.toString());
        zn6.d("lx_client_app_2p33", null, jSONObject.toString());
    }

    public static /* synthetic */ void p(FrameworkBaseActivity frameworkBaseActivity, String str, Dialog dialog, String str2, String str3, String str4, View view) {
        ve.s(frameworkBaseActivity, str, false);
        dialog.dismiss();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizAction", str2);
            jSONObject.put("fromid", str3);
            jSONObject.put("type", str4);
            jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("2p32", "1", null, jSONObject.toString());
        zn6.d("lx_client_app_2p32", null, jSONObject.toString());
    }

    public static void q(FrameworkBaseActivity frameworkBaseActivity) {
        frameworkBaseActivity.getWindow().getDecorView().removeCallbacks(d);
        JSONObject jSONObjectI = i();
        if (jSONObjectI != null) {
            try {
                jSONObjectI.put("isDelayIng", false);
                SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, "key_pull_wake_content_common", jSONObjectI.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void r(Activity activity, JSONObject jSONObject, q qVar) {
        boolean zN;
        String str;
        String str2;
        Window window;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("title");
            String strOptString2 = jSONObject.optString("headIconUrl");
            String strOptString3 = jSONObject.optString("realname");
            String strOptString4 = jSONObject.optString("nickname");
            String strOptString5 = jSONObject.optString("text");
            String strOptString6 = jSONObject.optString("button");
            String strOptString7 = jSONObject.optString("bizAction");
            String strOptString8 = jSONObject.optString("rid");
            String strOptString9 = jSONObject.optString(DeviceInfoUtil.UID_TAG);
            int iOptInt = jSONObject.optInt("sourceType");
            String strOptString10 = jSONObject.optString("md5Phone");
            if (TextUtils.isEmpty(strOptString9)) {
                return;
            }
            if ((("apply".equals(strOptString7) || "add".equals(strOptString7) || "enter".equals(strOptString7)) && !bo0.r().w(strOptString9)) || "agree".equals(strOptString7)) {
                Dialog dialog = new Dialog(activity, R.style.dark_dialog);
                int iH = h(iOptInt, strOptString7);
                dialog.setContentView(iH);
                if (jo6.x() && iH == R.layout.layout_dialog_contact_alert_style4) {
                    zN = true;
                    dialog.setCanceledOnTouchOutside(true);
                } else {
                    dialog.setCanceledOnTouchOutside(false);
                    zN = io0.n();
                }
                dialog.setCancelable(zN);
                boolean z = zN;
                ((TextView) dialog.findViewById(R.id.title_text)).setText(strOptString);
                TextView textView = (TextView) dialog.findViewById(R.id.name_text);
                PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(strOptString10);
                if (phoneContactItem == null || TextUtils.isEmpty(phoneContactItem.m())) {
                    str = "enter";
                    if (TextUtils.isEmpty(strOptString3)) {
                        str2 = strOptString4;
                    } else {
                        str2 = strOptString4 + "（" + strOptString3 + "）";
                    }
                } else {
                    str = "enter";
                    str2 = strOptString4 + "（" + phoneContactItem.m() + "）";
                }
                textView.setText(str2);
                ((TextView) dialog.findViewById(R.id.apply_text)).setText(strOptString5);
                ((TextView) dialog.findViewById(R.id.btn_text)).setText(strOptString6);
                EffectiveShapeView effectiveShapeView = (EffectiveShapeView) dialog.findViewById(R.id.header_icon);
                effectiveShapeView.changeShapeType(3);
                effectiveShapeView.setDegreeForRoundRectangle(me1.b(activity, 6), me1.b(activity, 6));
                gr2.j().h(strOptString2, effectiveShapeView, bq6.s());
                if (iH == R.layout.layout_dialog_contact_alert_style4) {
                    ImageView imageView = (ImageView) dialog.findViewById(R.id.icon_add);
                    if ("add".equals(strOptString7) || "apply".equals(strOptString7) || str.equals(strOptString7)) {
                        imageView.setImageResource(R.drawable.icon_contact_alert_add);
                    } else {
                        imageView.setImageResource(R.drawable.icon_contact_alert_accept);
                    }
                }
                dialog.findViewById(R.id.btn_cancel).setOnClickListener(new n(dialog));
                dialog.findViewById(R.id.content_view).setOnClickListener(new o(strOptString9, iOptInt, activity, strOptString8, strOptString10, strOptString3, strOptString7, dialog));
                dialog.findViewById(R.id.btn_confirm).setOnClickListener(new p(strOptString9, strOptString7, iOptInt, activity, strOptString8, strOptString10, strOptString3, strOptString4, dialog));
                dialog.setOnKeyListener(new a(z));
                dialog.setOnDismissListener(new b(qVar));
                dialog.show();
                b = true;
                qVar.a(true);
                if (iH == R.layout.layout_dialog_contact_alert_style4 && (window = dialog.getWindow()) != null) {
                    window.getDecorView().setPadding(0, 0, 0, 0);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (attributes != null) {
                        attributes.height = -2;
                        attributes.width = -1;
                        attributes.gravity = 48;
                        window.setAttributes(attributes);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("sourcetype", iOptInt);
                    jSONObject2.put("bizAction", strOptString7);
                    jSONObject2.put("fromid", strOptString9);
                    jSONObject2.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("2p31", "1", null, jSONObject2.toString());
                zn6.d("lx_client_app_2p31", null, jSONObject2.toString());
            }
        }
    }

    public static boolean s(Activity activity, JSONObject jSONObject, q qVar) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("title", "他现在在线哦～");
            String strOptString2 = jSONObject.optString("digest", "现在聊天更容易得到回复哦～");
            String strOptString3 = jSONObject.optString("button", "去打招呼");
            int iOptInt = jSONObject.optInt("bizType");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(bd.m);
            if (jSONObjectOptJSONObject != null) {
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG));
                if (!bo0.r().w(contactInfoItem.getUid())) {
                    contactInfoItem.setBizType(iOptInt);
                }
                contactInfoItem.setGender(jSONObjectOptJSONObject.optInt("sex", -1));
                contactInfoItem.setNickName(jSONObjectOptJSONObject.optString("nickname"));
                contactInfoItem.setIconURL(jSONObjectOptJSONObject.optString("headIconUrl"));
                contactInfoItem.setBigIconURL(jSONObjectOptJSONObject.optString("headImgUrl"));
                contactInfoItem.setCityName(jSONObjectOptJSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY));
                jn0 jn0Var = new jn0(activity, contactInfoItem, strOptString, strOptString2, strOptString3);
                jn0Var.h(new m(qVar));
                jn0Var.show();
                qVar.a(true);
                b = true;
                LogUtil.uploadInfoImmediate("pagechat_half_card", null);
                return true;
            }
        }
        return false;
    }

    public static boolean t(FrameworkBaseActivity frameworkBaseActivity, JSONObject jSONObject) {
        FrameLayout frameLayout = (FrameLayout) frameworkBaseActivity.getWindow().getDecorView().findViewById(android.R.id.content);
        int i2 = c;
        MainFeedTopAlertView mainFeedTopAlertView = i2 != 0 ? (MainFeedTopAlertView) frameLayout.findViewById(i2) : null;
        if (mainFeedTopAlertView == null) {
            mainFeedTopAlertView = (MainFeedTopAlertView) LayoutInflater.from(frameworkBaseActivity).inflate(R.layout.layout_dialog_top_alert_v2, (ViewGroup) null);
            int iF = a46.f();
            c = iF;
            mainFeedTopAlertView.setId(iF);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = me1.h(mainFeedTopAlertView.getContext());
            frameLayout.addView(mainFeedTopAlertView, layoutParams);
        }
        mainFeedTopAlertView.setContentObject(jSONObject);
        b = true;
        mainFeedTopAlertView.setVisibleCallback(new l());
        return true;
    }

    public static void u(Activity activity, JSONObject jSONObject, q qVar) {
        boolean zN;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("title");
            String strOptString2 = jSONObject.optString("headIconUrl");
            String strOptString3 = jSONObject.optString("encryptPhone");
            String strOptString4 = jSONObject.optString("text");
            String strOptString5 = jSONObject.optString("button");
            String strOptString6 = jSONObject.optString("bizAction");
            String strOptString7 = jSONObject.optString("md5Phone");
            PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(strOptString7);
            if (phoneContactItem == null || TextUtils.isEmpty(phoneContactItem.m())) {
                return;
            }
            Dialog dialog = new Dialog(activity, R.style.dark_dialog);
            dialog.setContentView(R.layout.layout_dialog_contact_alert_style4);
            int i2 = 1;
            if (jo6.x()) {
                dialog.setCanceledOnTouchOutside(true);
                zN = true;
            } else {
                dialog.setCanceledOnTouchOutside(false);
                zN = io0.n();
            }
            dialog.setCancelable(zN);
            ((TextView) dialog.findViewById(R.id.title_text)).setText(strOptString);
            ((TextView) dialog.findViewById(R.id.name_text)).setText(phoneContactItem.m());
            ((TextView) dialog.findViewById(R.id.apply_text)).setText(strOptString4);
            ((TextView) dialog.findViewById(R.id.btn_text)).setText(strOptString5);
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) dialog.findViewById(R.id.header_icon);
            effectiveShapeView.changeShapeType(3);
            effectiveShapeView.setDegreeForRoundRectangle(me1.b(activity, 6), me1.b(activity, 6));
            gr2.j().h(strOptString2, effectiveShapeView, bq6.s());
            ((ImageView) dialog.findViewById(R.id.icon_add)).setImageResource(R.drawable.icon_contact_alert_add);
            dialog.findViewById(R.id.btn_cancel).setOnClickListener(new c(dialog, activity));
            dialog.findViewById(R.id.content_view).setOnClickListener(new d(activity, strOptString6, strOptString7));
            dialog.findViewById(R.id.btn_confirm).setOnClickListener(new f(activity, strOptString3, dialog, strOptString6, strOptString7));
            dialog.setOnKeyListener(new g(zN, activity));
            dialog.setOnDismissListener(new h(qVar));
            dialog.show();
            b = true;
            qVar.a(true);
            Window window = dialog.getWindow();
            if (window != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (attributes != null) {
                    attributes.height = -2;
                    attributes.width = -1;
                    attributes.gravity = 48;
                    window.setAttributes(attributes);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("bizAction", strOptString6);
                jSONObject2.put("fuid", strOptString7);
                if (!com.zenmen.palmchat.smallvideo.a.a()) {
                    i2 = 0;
                }
                jSONObject2.put("dou", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2p31", "1", null, jSONObject2.toString());
            zn6.d("lx_client_app_2p31", null, jSONObject2.toString());
        }
    }

    public static boolean v(final FrameworkBaseActivity frameworkBaseActivity, JSONObject jSONObject, q qVar) {
        if (jSONObject == null) {
            return false;
        }
        LogUtil.i(f1755a, "showTopAlertDialog content =" + jSONObject);
        final String strOptString = jSONObject.optString("type");
        if ("heartbeat_match".equals(strOptString)) {
            return p93.u(frameworkBaseActivity, jSONObject);
        }
        if ("cna2023".equals(strOptString)) {
            String strOptString2 = jSONObject.optString(TurnInfo.TYPE_DEEP_LINK);
            JSONObject config = vs0.a().getConfig("activity_push_url");
            String strE = t66.h().e("LX-65480", "A");
            if (config != null && !TextUtils.isEmpty(config.optString(strE))) {
                strOptString2 = config.optString(strE);
            }
            if (!TextUtils.isEmpty(strOptString2) && !frameworkBaseActivity.isFinishing()) {
                HashMap map = new HashMap();
                map.put("url", strOptString2);
                zn6.h("strongmind_deeplink", "view", map);
                try {
                    ve.s(frameworkBaseActivity, strOptString2, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return true;
        }
        if (TextUtils.equals("feednotice", strOptString)) {
            return t(frameworkBaseActivity, jSONObject);
        }
        final String strOptString3 = jSONObject.optString(DeviceInfoUtil.UID_TAG);
        String strOptString4 = jSONObject.optString("nickname");
        String strOptString5 = jSONObject.optString("headIconUrl");
        String strOptString6 = jSONObject.optString("text");
        String strOptString7 = jSONObject.optString("button");
        final String strOptString8 = jSONObject.optString("buttonActionUrl");
        final String strOptString9 = jSONObject.optString("panelActionUrl");
        final String strOptString10 = jSONObject.optString("bizAction");
        int iOptInt = jSONObject.optInt("showtime", 5);
        final Dialog dialog = new Dialog(frameworkBaseActivity, R.style.empty_dialog);
        dialog.setContentView(R.layout.layout_dialog_top_alert);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        gr2.j().h(strOptString5, (EffectiveShapeView) dialog.findViewById(R.id.header_icon), bq6.s());
        TextView textView = (TextView) dialog.findViewById(R.id.name);
        ContactInfoItem contactInfoItemL = bo0.r().l(strOptString3);
        if (contactInfoItemL != null) {
            textView.setText(contactInfoItemL.getNameForShow());
        } else {
            textView.setText(strOptString4);
        }
        ((TextView) dialog.findViewById(R.id.text)).setText(strOptString6);
        TextView textView2 = (TextView) dialog.findViewById(R.id.btn_text);
        textView2.setText(strOptString7);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: zm0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bn0.o(frameworkBaseActivity, strOptString8, dialog, strOptString10, strOptString3, strOptString, view);
            }
        });
        dialog.findViewById(R.id.content_view).setOnClickListener(new View.OnClickListener() { // from class: an0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bn0.p(frameworkBaseActivity, strOptString9, dialog, strOptString10, strOptString3, strOptString, view);
            }
        });
        dialog.setOnKeyListener(new i(strOptString10, strOptString));
        j jVar = new j(frameworkBaseActivity, dialog);
        textView2.postDelayed(jVar, iOptInt * 1000);
        dialog.setOnDismissListener(new k(qVar, textView2, jVar));
        dialog.show();
        b = true;
        qVar.a(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.height = -2;
                attributes.width = -1;
                attributes.gravity = 48;
                window.setAttributes(attributes);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("bizAction", strOptString10);
            jSONObject2.put("fromid", strOptString3);
            jSONObject2.put("type", strOptString);
            jSONObject2.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("2p31", "1", null, jSONObject2.toString());
        zn6.d("lx_client_app_2p31", null, jSONObject2.toString());
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f1760a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public f(Activity activity, String str, Dialog dialog, String str2, String str3) {
            this.f1760a = activity;
            this.b = str;
            this.c = dialog;
            this.d = str2;
            this.e = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (hx3.m(this.f1760a)) {
                try {
                    new pf5(new a(), new b()).o(this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sy5.e(this.f1760a, R.string.recommend_friends_high_node_invited, 0).g();
            } else {
                sy5.e(this.f1760a, R.string.send_failed, 0).g();
            }
            this.c.dismiss();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bizAction", this.d);
                jSONObject.put("fuid", this.e);
                jSONObject.put("dou", com.zenmen.palmchat.smallvideo.a.a() ? 1 : 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2p33", "1", null, jSONObject.toString());
            zn6.d("lx_client_app_2p33", null, jSONObject.toString());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.Listener<JSONObject> {
            public a() {
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.ErrorListener {
            public b() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
            }
        }
    }
}
