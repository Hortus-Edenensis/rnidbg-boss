package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mo5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19282a = false;

    public static String a() {
        try {
            JSONObject jSONObjectW = ts0.o().w();
            if (jSONObjectW == null) {
                return "收到的打招呼";
            }
            String string = jSONObjectW.getString("privatechat");
            return !TextUtils.isEmpty(string) ? string : "收到的打招呼";
        } catch (JSONException e) {
            e.printStackTrace();
            return "收到的打招呼";
        }
    }

    public static long b() {
        try {
            JSONObject jSONObjectW = ts0.o().w();
            if (jSONObjectW == null) {
                return 86400000L;
            }
            if (jSONObjectW.getInt("superchattime") > 0) {
                return r2 * 1000 * 60 * 60;
            }
            return 86400000L;
        } catch (JSONException e) {
            e.printStackTrace();
            return 86400000L;
        }
    }

    public static String c() {
        String string = AppContext.getContext().getString(R.string.private_chat_guide_tip_text);
        try {
            JSONObject jSONObjectW = ts0.o().w();
            if (jSONObjectW == null) {
                return string;
            }
            String string2 = jSONObjectW.getString("foldexplain");
            return !TextUtils.isEmpty(string2) ? string2 : string;
        } catch (JSONException e) {
            e.printStackTrace();
            return string;
        }
    }

    public static long d() {
        try {
            JSONObject jSONObjectW = ts0.o().w();
            if (jSONObjectW == null) {
                return 86400000L;
            }
            if (jSONObjectW.getInt("privatechatpackuptime") > 0) {
                return r2 * 1000 * 60 * 60;
            }
            return 86400000L;
        } catch (JSONException e) {
            e.printStackTrace();
            return 86400000L;
        }
    }

    public static void e(boolean z) {
        if (z && f19282a) {
            return;
        }
        f19282a = true;
        try {
            g();
            GiftMessageHelper.C0();
            f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f() {
        ThreadFolderManager.FolderType folderType = ThreadFolderManager.FolderType.TYPE_SQUARE_GREETINGS;
        if (folderType.enable()) {
            Integer[] numArr = folderType.bizTypes;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numArr.length; i++) {
                if (i == numArr.length - 1) {
                    sb.append(numArr[i]);
                } else {
                    sb.append(numArr[i]);
                    sb.append(",");
                }
            }
            String str = "thread_biz_type in (" + sb.toString() + ") and thread_active=?";
            String[] strArr = {String.valueOf(1)};
            ContentValues contentValues = new ContentValues();
            contentValues.put("thread_active", (Integer) 1);
            zh.k(AppContext.getContext().getContentResolver()).j(0, null, dx5.f17178a, contentValues, str, strArr);
        }
    }

    public static void g() {
        String[] strArr = {String.valueOf(1), String.valueOf(System.currentTimeMillis() - b())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_super_greetings", (Integer) 0);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, dx5.f17178a, contentValues, "is_super_greetings=? and super_greetings_time_stamp>0 and super_greetings_time_stamp<?", strArr);
    }
}
