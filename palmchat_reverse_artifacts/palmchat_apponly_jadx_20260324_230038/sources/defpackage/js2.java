package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class js2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f18489a = false;
    public static boolean b = false;
    public static b c = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f18490a;

        public a(Dialog dialog) {
            this.f18490a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18490a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18491a = "完善资料，";
        public String b = "奖励+0.5元(可提现)";
        public String c = "让更多人认识你，";
        public String d = "发首贴+5元(可提现)";
        public String e = "收到首个礼物，";
        public String f = "额外奖励+0.5元(可提现)";
        public String g = "";
        public String h = "完善基本资料+0.5元(可提现)";
        public String i = "完善基本资料+0.5元(可提现)";

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("[");
            stringBuffer.append("detail_profile_part1=" + this.f18491a);
            stringBuffer.append("detail_profile_part2=" + this.b);
            stringBuffer.append("detail_album_part1=" + this.c);
            stringBuffer.append("detail_album_part2=" + this.d);
            stringBuffer.append("detail_gift_part1=" + this.e);
            stringBuffer.append("detail_gift_part2=" + this.f);
            stringBuffer.append("detail_dialog_url=" + this.g);
            stringBuffer.append("guide_profile=" + this.h);
            stringBuffer.append("guide_squarefeed=" + this.i);
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String strOptString = jSONObject.optString("detail_profile_part1", bVar.f18491a);
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = bVar.f18491a;
        }
        bVar.f18491a = strOptString;
        String strOptString2 = jSONObject.optString("detail_profile_part2", bVar.b);
        if (TextUtils.isEmpty(strOptString2)) {
            strOptString2 = bVar.b;
        }
        bVar.b = strOptString2;
        String strOptString3 = jSONObject.optString("detail_album_part1", bVar.c);
        if (TextUtils.isEmpty(strOptString3)) {
            strOptString3 = bVar.c;
        }
        bVar.c = strOptString3;
        String strOptString4 = jSONObject.optString("detail_album_part2", bVar.d);
        if (TextUtils.isEmpty(strOptString4)) {
            strOptString4 = bVar.d;
        }
        bVar.d = strOptString4;
        String strOptString5 = jSONObject.optString("detail_gift_part1", bVar.e);
        if (TextUtils.isEmpty(strOptString5)) {
            strOptString5 = bVar.e;
        }
        bVar.e = strOptString5;
        String strOptString6 = jSONObject.optString("detail_gift_part2", bVar.f);
        if (TextUtils.isEmpty(strOptString6)) {
            strOptString6 = bVar.f;
        }
        bVar.f = strOptString6;
        String strOptString7 = jSONObject.optString("detail_dialog_url", bVar.g);
        if (TextUtils.isEmpty(strOptString7)) {
            strOptString7 = bVar.g;
        }
        bVar.g = strOptString7;
        String strOptString8 = jSONObject.optString("guide_profile", bVar.h);
        if (TextUtils.isEmpty(strOptString8)) {
            strOptString8 = bVar.h;
        }
        bVar.h = strOptString8;
        String strOptString9 = jSONObject.optString("guide_squarefeed", bVar.i);
        if (TextUtils.isEmpty(strOptString9)) {
            strOptString9 = bVar.i;
        }
        bVar.i = strOptString9;
        return bVar;
    }

    public static int b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("detail_feed_click", null, jSONObject.toString());
    }

    public static void d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("detail_feed_show", null, jSONObject.toString());
    }

    public static void e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("detail_gift_click", null, jSONObject.toString());
    }

    public static void f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("detail_gift_show", null, jSONObject.toString());
    }

    public static void g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("detail_profile_click", null, jSONObject.toString());
    }

    public static void h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("detail_profile_show", null, jSONObject.toString());
    }

    public static void i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("mine_task_icon_show", null, jSONObject.toString());
    }

    public static void j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceId", ac1.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("income_task_dialog_show", null, jSONObject.toString());
    }

    public static b k() {
        return c;
    }

    public static boolean l() {
        return b;
    }

    public static boolean m() {
        return f18489a;
    }

    public static void n(String str) {
        WifiLog.d("IncomeTaskManager loadConfig");
        c = new b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c = a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void o(boolean z) {
        f18489a = z;
    }

    public static void p(boolean z) {
        b = z;
    }

    public static void q(Activity activity) {
        if (activity == null || activity.isFinishing() || !m()) {
            return;
        }
        String str = k().g;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = k86.a("key_detail_income_task_dialog_shown");
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.USER_DETAIL;
        if (sPUtil.a(scene, strA, false)) {
            return;
        }
        Dialog dialog = new Dialog(activity);
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        ImageView imageView = new ImageView(dialog.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int iB = b(activity, 30.0f);
        imageView.setPadding(iB, 0, iB, 0);
        dialog.setContentView(imageView);
        imageView.setOnClickListener(new a(dialog));
        gr2.j().g(str, imageView);
        dialog.show();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = b(activity, 440.0f);
        window.setAttributes(attributes);
        j();
        sPUtil.t(scene, strA, Boolean.TRUE);
    }

    public static void r(String str) {
        WifiLog.d("IncomeTaskManager  updateConfig");
        c = new b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c = a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
