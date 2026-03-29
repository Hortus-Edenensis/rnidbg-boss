package defpackage;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.protobuf.GeneratedMessageLite;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mb4 extends kb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19184a = "mb4";
    public static final String[] b = {"members/revoke", "friend/add", "message/revoke", "activity", "friend/apply", "red/info", "members-qr/revoke", "red/send", "mp", "coupon/info", "webapp"};

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19185a;

        public a(String str) {
            this.f19185a = str;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "dealWithReplyPacket");
            put("detail", "replyPacket null");
            put("mid", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19186a;

        public b(String str) {
            this.f19186a = str;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "dealWithReplyPacket");
            put("detail", "replyPacket received success");
            put("mid", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageProto.Message f19187a;
        public final /* synthetic */ String b;

        public c(MessageProto.Message message, String str) {
            this.f19187a = message;
            this.b = str;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "dealWithReplyPacket");
            put("detail", "replyPacket status" + message.getStatus());
            put("mid", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19188a;

        public d(String str) {
            this.f19188a = str;
            put("action", LogUtil.VALUE_MSG_SEND);
            put("status", "dealWithReplyPacket");
            put("detail", "replyPacket type is not MessageProto.Message");
            put("mid", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19189a;
        public final /* synthetic */ String b;

        public e(String str, String str2) {
            this.f19189a = str;
            this.b = str2;
            put("action", "sync");
            put("status", "start");
            put("reason", str);
            put("mid", str2);
        }
    }

    public static MessageProto.Message d(JSONObject jSONObject) {
        MessageProto.Message.Builder builderNewBuilder = MessageProto.Message.newBuilder();
        try {
            builderNewBuilder.setCreateTime(jSONObject.getLong("createTime"));
            builderNewBuilder.setTo(jSONObject.getString(RemoteMessageConst.TO));
            builderNewBuilder.setBody(jSONObject.optString("body"));
            builderNewBuilder.setSyncKey(jSONObject.optString("syncKey"));
            builderNewBuilder.setStatus(jSONObject.getInt("status"));
            builderNewBuilder.setFrom(jSONObject.getString("from"));
            builderNewBuilder.setType(jSONObject.getInt("type"));
            builderNewBuilder.setExType(jSONObject.optInt("exType"));
            builderNewBuilder.setVersion(jSONObject.optLong("version"));
            builderNewBuilder.setSubType(jSONObject.getInt(SharePluginInfo.ISSUE_SUB_TYPE));
            builderNewBuilder.setMid(jSONObject.getString("mid"));
            builderNewBuilder.setExType(jSONObject.optInt("exType"));
            builderNewBuilder.setExtension(jSONObject.optString("extension"));
            builderNewBuilder.setFlag(jSONObject.optInt("flag"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("media");
            if (jSONObjectOptJSONObject != null) {
                MessageProto.Message.Media.Builder builderNewBuilder2 = MessageProto.Message.Media.newBuilder();
                builderNewBuilder2.setThumbUrl(jSONObjectOptJSONObject.optString("thumbUrl"));
                builderNewBuilder2.setUrl(jSONObjectOptJSONObject.optString("url"));
                builderNewBuilder2.setPlayLength(jSONObjectOptJSONObject.optInt("playLength"));
                builderNewBuilder2.setSize(jSONObjectOptJSONObject.optInt("size"));
                builderNewBuilder2.setExtension(jSONObjectOptJSONObject.optString("extension"));
                builderNewBuilder2.setMimeType(jSONObjectOptJSONObject.optString("mimeType"));
                builderNewBuilder2.setMediaId(jSONObjectOptJSONObject.optString("mediaId"));
                builderNewBuilder2.setName(jSONObjectOptJSONObject.optString("name"));
                builderNewBuilder.setMedia(builderNewBuilder2.build());
            }
            return builderNewBuilder.build();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean e(MessageProto.Message message, String str, String str2) {
        if (gq5.a(message.getSyncKey(), message.getVersion())) {
            return false;
        }
        iq5.d().h(false, false, message.getVersion(), "3");
        LogUtil.i(f19184a, 3, new e(str2, str), (Throwable) null);
        return true;
    }

    public static void f(MessageVo messageVo, GeneratedMessageLite generatedMessageLite, String str, String str2, String str3) {
        String str4 = messageVo.mid;
        int i = messageVo.mimeType;
        if (generatedMessageLite == null) {
            if (com.zenmen.palmchat.database.b.P(messageVo, null)) {
                l(messageVo);
                LogUtil.i(f19184a, 3, new a(str4), (Throwable) null);
                return;
            }
            return;
        }
        if (!(generatedMessageLite instanceof MessageProto.Message)) {
            if (com.zenmen.palmchat.database.b.P(messageVo, null)) {
                l(messageVo);
                LogUtil.i(f19184a, 3, new d(str4), (Throwable) null);
                return;
            }
            return;
        }
        MessageProto.Message message = (MessageProto.Message) generatedMessageLite;
        if (message.getType() != 5) {
            return;
        }
        if (message.getStatus() != 10) {
            if (i == 16 || i == 17) {
                com.zenmen.palmchat.database.b.Q(messageVo, message);
                return;
            } else {
                if (com.zenmen.palmchat.database.b.P(messageVo, message)) {
                    l(messageVo);
                    LogUtil.i(f19184a, 3, new c(message, str4), (Throwable) null);
                    return;
                }
                return;
            }
        }
        LogUtil.i(f19184a, 3, new b(str4), (Throwable) null);
        if (i == 2 || i == 14) {
            com.zenmen.palmchat.database.b.H(messageVo, str, str2, str3, message.getVersion());
        } else if (i == 3) {
            com.zenmen.palmchat.database.b.V(messageVo, str, message.getVersion());
        } else if (i == 4) {
            com.zenmen.palmchat.database.b.U(messageVo, str2, str, str3, message.getVersion());
        } else {
            com.zenmen.palmchat.database.b.Q(messageVo, message);
        }
        if (e(message, str4, "send_sync")) {
            return;
        }
        gq5.b(message.getSyncKey(), message.getVersion());
    }

    public static Pair<Integer, ContentValues> g(String str) {
        String lowerCase;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = Uri.parse(str);
        try {
            lowerCase = uri.getScheme().toLowerCase();
        } catch (Exception e2) {
            e2.printStackTrace();
            lowerCase = "";
        }
        if (!lowerCase.equals("zenxin")) {
            if (!lowerCase.equals(HttpHost.DEFAULT_SCHEME_NAME) && !lowerCase.equals(BaseConstants.SCHEME_HTTPS)) {
                return null;
            }
            Uri uri2 = Uri.parse(Uri.encode(str, "/:?&="));
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", str);
            for (String str2 : uri2.getQueryParameterNames()) {
                contentValues.put(str2, uri2.getQueryParameter(str2));
            }
            return new Pair<>(-1, contentValues);
        }
        String str3 = uri.getHost().toLowerCase() + uri.getPath().toLowerCase();
        int i = 0;
        while (true) {
            String[] strArr = b;
            if (i >= strArr.length) {
                return null;
            }
            if (str3.equals(strArr[i])) {
                ContentValues contentValues2 = new ContentValues();
                for (String str4 : uri.getQueryParameterNames()) {
                    contentValues2.put(str4, uri.getQueryParameter(str4));
                }
                contentValues2.put("lxOriginSchemeUrl", str);
                return new Pair<>(Integer.valueOf(i), contentValues2);
            }
            i++;
        }
    }

    public static boolean h(int i) {
        return i == 16 || i == 22 || i == 17;
    }

    public static boolean i(int i, int i2) {
        return (i == 28 && i2 == 1) || i == 300 || 103 == i;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("gbCfg");
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optBoolean("unknownDiscard", false);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean k(String str) {
        String[] strArrSplit;
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
            int i = 0;
            for (String str2 : strArrSplit) {
                int i2 = 0;
                while (true) {
                    String[] strArr = b;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if (str2.equals(strArr[i2])) {
                        i++;
                        break;
                    }
                    i2++;
                }
            }
            if (i == strArrSplit.length) {
                return true;
            }
        }
        return false;
    }

    public static void l(MessageVo messageVo) {
        Intent intent = new Intent();
        intent.setAction(mo3.c);
        intent.putExtra("key_messagevo", messageVo);
        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
    }

    public static void m(MessageProto.Message message) {
        if (message == null || TextUtils.isEmpty(message.getExtension()) || !fw5.b(message)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(mo3.d);
        intent.putExtra("key_packet_extension", message.getExtension());
        intent.putExtra("key_mid", message.getMid());
        intent.putExtra("key_mimetype", message.getType());
        intent.putExtra("key_subtype", fu5.o(message));
        intent.putExtra("key_from", message.getFrom());
        intent.putExtra("key_body", message.getBody());
        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
    }
}
