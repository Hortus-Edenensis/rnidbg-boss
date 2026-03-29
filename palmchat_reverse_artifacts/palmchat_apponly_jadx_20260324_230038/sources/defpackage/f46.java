package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.RemoteException;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class f46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17432a = true;

    public static MessageVo a(int i, int i2, String str) {
        MessageVo messageVo = new MessageVo();
        String strP = AccountUtils.p(AppContext.getContext());
        String str2 = strP + "@cmd.youni";
        String str3 = strP + DomainHelper.Domains.DOMAIN_SINGLECHAT.domain;
        messageVo.to = str2;
        messageVo.from = str3;
        messageVo.mid = xn3.a();
        messageVo.time = ir5.b();
        messageVo.mimeType = 42;
        messageVo.data1 = String.valueOf(i);
        messageVo.data2 = String.valueOf(i2);
        messageVo.extention = b(str);
        return messageVo;
    }

    public static String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("rdCmd", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("unknownDiscard", true);
            jSONObject.put("gbCfg", jSONObject3);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("rdCmd");
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optString("id");
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean d() {
        return f17432a;
    }

    public static boolean e(MessageProto.Message message) {
        return d() && message != null && message.getType() == 42 && fu5.o(message) == 4;
    }

    public static boolean f(MessageProto.Message message) {
        return d() && message != null && message.getType() == 42 && fu5.o(message) == 5;
    }

    public static boolean g(MessageProto.Message message) {
        return d() && message != null && message.getType() == 42 && fu5.o(message) == 6;
    }

    public static void h(MessageProto.Message message) {
        LogUtil.i("UnReadStatusSyncManager", "processClearMomentCmd message=" + message);
        if (d()) {
            if (g(message)) {
                LogUtil.i("UnReadStatusSyncManager", "processClearMomentCmd setMomentMsgToRead");
                sq3.o().G(AppContext.getContext());
            } else if (f(message)) {
                LogUtil.i("UnReadStatusSyncManager", "processClearMomentCmd setMomentsPostToRead");
                sq3.o().H(AppContext.getContext());
            }
        }
    }

    public static boolean i(SQLiteDatabase sQLiteDatabase, String str, int i, int i2) {
        LogUtil.i("UnReadStatusSyncManager", "processThreadUnreadClearCmd ext=" + str + " type=" + i);
        if (!d()) {
            return false;
        }
        String strC = c(str);
        if (i == 0 || i == 1) {
            if (strC == null) {
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("unread_message_count", (Integer) 0);
            contentValues.put("thread_latest_unread_message_time", (Integer) 0);
            contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
            contentValues.put("thread_has_remind", (Integer) 0);
            CircleNoticeItem.circleThreadHasNoticeStatus(strC, 0);
            VoucherRedPacketVo.circleThreadHasVoucherStatus(strC, 0);
            sQLiteDatabase.update("tb_threads", contentValues, "contact_relate=?", new String[]{DomainHelper.c(strC, i2)});
            return false;
        }
        if (i == 7) {
            String[] strArr = {String.valueOf(0L), String.valueOf(4), String.valueOf(34), String.valueOf(14)};
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("read_status", (Long) 1L);
            contentValues2.put("readTime", Long.valueOf(System.currentTimeMillis()));
            if (sQLiteDatabase.update("tb_contact_requests", contentValues2, "read_status=? and (source_type=? or source_type=? or source_type=?)", strArr) <= 0) {
                return false;
            }
        } else {
            if (i != 8) {
                return false;
            }
            String[] strArr2 = {String.valueOf(0L), String.valueOf(4), String.valueOf(28)};
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("read_status", (Long) 1L);
            contentValues3.put("readTime", Long.valueOf(System.currentTimeMillis()));
            if (sQLiteDatabase.update("tb_contact_requests", contentValues3, "read_status=? and (source_type=? or source_type=?)", strArr2) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void j(fn2 fn2Var, int i, int i2, String str) {
        if (d()) {
            LogUtil.i("UnReadStatusSyncManager", "sendClearMsg messagingServiceInterface=" + fn2Var + "type=" + i + "contactUid= " + str);
            if (fn2Var != null) {
                try {
                    fn2Var.r(a(i, i2, str));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void k(fn2 fn2Var, int i, String str) {
        j(fn2Var, i, 1, str);
    }

    public static void l(fn2 fn2Var, ChatItem chatItem) {
        m(fn2Var, chatItem, 1);
    }

    public static void m(fn2 fn2Var, ChatItem chatItem, int i) {
        if (chatItem != null) {
            int i2 = 0;
            if (chatItem.getBizType() == 0 && chatItem.getChatType() != 0) {
                i2 = 1;
            }
            j(fn2Var, i2, i, chatItem.getChatId());
        }
    }
}
