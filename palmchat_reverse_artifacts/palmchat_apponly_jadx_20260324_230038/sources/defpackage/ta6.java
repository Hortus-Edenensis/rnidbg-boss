package defpackage;

import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ta6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f20944a = 10;
    public static HashMap<String, Integer> b;

    public static void a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(OapsKey.KEY_CALLER, AccountUtils.p(AppContext.getContext()));
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "804", null, null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(OapsKey.KEY_CALLER, AccountUtils.p(AppContext.getContext()));
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "803", null, null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String c() {
        String strG = g();
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionTypes", "activity");
            jSONObject.put("actionBody", strG);
            string = jSONObject.toString();
            b();
            return string;
        } catch (Exception unused) {
            return string;
        }
    }

    public static void d(String str, String str2) {
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

    public static void e(String str) {
        d(c(), str);
    }

    public static void f(int i, String str, int i2) {
        try {
            if (b == null) {
                b = new HashMap<>();
                f20944a = h();
            }
            if (f20944a <= 0) {
                return;
            }
            if (i == 0) {
                b.remove(str);
                return;
            }
            if (!b.containsKey(str)) {
                if (i < f20944a) {
                    b.put(str, 0);
                }
            } else {
                if (i < f20944a || b.get(str).intValue() == 1 || fu5.t(i2)) {
                    return;
                }
                e(str);
                b.put(str, 1);
            }
        } catch (Exception unused) {
        }
    }

    public static String g() {
        String string = AppContext.getContext().getResources().getString(R.string.video_call_tips_voice);
        try {
            String extra = rl0.h().d().getDynamicConfig(DynamicConfig.Type.VOIP).getExtra();
            if (!TextUtils.isEmpty(extra) && (string = new JSONObject(extra).getString("tips_string")) != null) {
                string.replace("语音聊天", "<a href=\"zenxin://activity?page=a0103\">语音聊天</a>");
            }
        } catch (JSONException unused) {
        }
        return string;
    }

    public static int h() {
        try {
            String extra = rl0.h().d().getDynamicConfig(DynamicConfig.Type.VOIP).getExtra();
            if (TextUtils.isEmpty(extra)) {
                return 10;
            }
            return new JSONObject(extra).getInt("tips_count");
        } catch (JSONException unused) {
            return 10;
        }
    }
}
