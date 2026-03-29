package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.media.roomchat.permission.PermissionRequestInterface;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ua6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21180a = "ua6";
    public static int b = -1;
    public static boolean c = false;
    public static PermissionRequestInterface d = new a();

    public static void a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("floatview", b);
            LogUtil.i(f21180a, "806 " + jSONObject.toString());
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "806", null, null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            jSONObject.put("floatview", b);
            LogUtil.i(f21180a, "805 " + jSONObject.toString());
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "805", null, null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int c(Context context) {
        if (context == null || !rg4.c(context)) {
            b = 0;
        } else {
            b = 1;
        }
        return b;
    }

    public static void d(Activity activity) {
        rg4.f(activity, d);
    }

    public static String e() {
        String strI = i();
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionTypes", "activity");
            jSONObject.put("actionBody", strI);
            string = jSONObject.toString();
            b();
            return string;
        } catch (Exception unused) {
            return string;
        }
    }

    public static void f(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message", "");
        contentValues.put("data1", (Integer) 1);
        contentValues.put("data2", str);
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
        contentValues.put("msg_type", (Integer) 10000);
        contentValues.put("type", (Integer) 1);
        contentValues.put("packet_id", xn3.a());
        contentValues.put("contact_relate", str2);
        contentValues.put("msg_extend", str2);
        contentValues.put("read", (Integer) 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message_values", contentValues);
        ContactInfoItem contactInfoItemL = bo0.r().l(str2);
        AppContext.getContext().getContentResolver().call(DBUriManager.b(ho3.class, contactInfoItemL), "insertRawMessage", DBUriManager.b(ho3.class, contactInfoItemL).toString(), bundle);
    }

    public static void g(Context context, String str) {
        try {
            if (bc1.b().toLowerCase().contains("huawei") && Build.VERSION.SDK_INT >= 26 && c(context) == 0) {
                String strC = rb3.c(str);
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.VOIP;
                int iF = sPUtil.f(scene, k86.a(strC), 0);
                if (iF < 1) {
                    f(e(), str);
                }
                sPUtil.t(scene, k86.a(strC), Integer.valueOf(iF + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void h(Activity activity) {
        if (activity == null || !c) {
            return;
        }
        c = false;
        c(activity);
        a();
    }

    public static String i() {
        return AppContext.getContext().getResources().getString(R.string.video_call_tips_floatview);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements PermissionRequestInterface {
        @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
        public void I() {
            ua6.c = true;
        }

        @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
        public void B0() {
        }

        @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
        public void g1() {
        }

        @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
        public void l() {
        }

        @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
        public void onCancel() {
        }

        @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
        public void p1() {
        }
    }
}
