package com.zenmen.palmchat.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ChatBubbleVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatBubble;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmd;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmdExt;
import com.zenmen.palmchat.circle.app.dragon.DragonItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.transfer.bean.TransferVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.cs3;
import defpackage.d20;
import defpackage.ds3;
import defpackage.dv;
import defpackage.dx5;
import defpackage.eb6;
import defpackage.es3;
import defpackage.fu5;
import defpackage.g53;
import defpackage.ho0;
import defpackage.ho3;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.lg1;
import defpackage.lt4;
import defpackage.mb4;
import defpackage.me3;
import defpackage.oc0;
import defpackage.pu1;
import defpackage.xn3;
import defpackage.zh;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<BaseResponse<DragonItem>> {
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.database.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1045b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13886a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public C1045b(String str, String str2, String str3) {
            this.f13886a = str;
            this.b = str2;
            this.c = str3;
            put("action", "buildReceiveMessageContentValue");
            put("status", "uidisnull");
            put("from", str);
            put(RemoteMessageConst.TO, str2);
            put("mid", str3);
        }
    }

    public static boolean A(MessageVo messageVo) {
        boolean z = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.c(ho3.class, messageVo.contactRelate), null, "packet_id=?", new String[]{messageVo.mid}, null);
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(cursorQuery.getColumnIndex("msg_status")) == 3) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return z;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static boolean B(MessageProto.Message message) {
        if (message == null) {
            return false;
        }
        String strP = AccountUtils.p(AppContext.getContext());
        String strQ = DomainHelper.q(message.getFrom());
        return strQ == null || strQ.equals(strP);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034 A[PHI: r7
      0x0034: PHI (r7v3 android.database.Cursor) = (r7v2 android.database.Cursor), (r7v4 android.database.Cursor) binds: [B:15:0x0032, B:9:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean C(String str) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ho3.class, 0), null, "data3=? ", new String[]{str}, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String D(ChatItem chatItem, String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.b(ho3.class, chatItem), null, "packet_id=?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("message"));
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043 A[PHI: r8
      0x0043: PHI (r8v3 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:19:0x0041, B:12:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String E(MessageVo messageVo) {
        Cursor cursorQuery;
        ?? r7 = 0;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.c(ho3.class, messageVo.contactRelate), null, "packet_id=? ", new String[]{messageVo.mid}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("contact_relate"));
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                r7 = messageVo;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r7 != 0) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public static void F(DBUriManager.MsgSaveType msgSaveType, int i) {
        String str = "_id >=" + i + " AND msg_type" + ContainerUtils.KEY_VALUE_DELIMITER + "3 AND (attach_status=? or attach_status=?)";
        String[] strArr = {String.valueOf(1), String.valueOf(3)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("only_update_msg", Boolean.TRUE);
        contentValues.put("attach_status", (Integer) 0);
        AppContext.getContext().getContentResolver().update(DBUriManager.d(ho3.class, msgSaveType), contentValues, str, strArr);
    }

    public static void G(String[] strArr, ChatItem chatItem) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i = 0;
        while (i < strArr.length) {
            int iP = p(i, strArr) + i;
            String[] strArr2 = (String[]) Arrays.copyOfRange(strArr, i, iP);
            if (strArr2 == null || strArr2.length <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                if (i2 == strArr2.length - 1) {
                    sb.append("packet_id=?");
                } else {
                    sb.append("packet_id=? or ");
                }
            }
            String string = sb.toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put("attach_status", (Integer) 5);
            zh.k(AppContext.getContext().getContentResolver()).j(0, null, DBUriManager.b(ho3.class, chatItem), contentValues, string, strArr2);
            i = iP;
        }
    }

    public static void H(MessageVo messageVo, String str, String str2, String str3, long j) {
        String str4 = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        if (!A(messageVo)) {
            contentValues.put("msg_status", (Integer) 2);
        }
        contentValues.put("data2", str);
        contentValues.put("data3", str2);
        contentValues.put("data4", str3);
        contentValues.put("buddy_id", Long.valueOf(j));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str4});
    }

    public static void I(MessageVo messageVo, int i) {
        J(messageVo, i, null);
    }

    public static void J(MessageVo messageVo, int i, String str) {
        String str2 = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        if (str != null) {
            contentValues.put("data1", str);
        }
        contentValues.put("data3", Integer.valueOf(i));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str2});
    }

    public static void K(ChatItem chatItem, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("data1", str2);
        AppContext.getContext().getContentResolver().update(DBUriManager.b(ho3.class, chatItem), contentValues, "packet_id=?", new String[]{str});
    }

    public static void L(ChatItem chatItem, MessageVo messageVo, String str) {
        String str2 = messageVo.mid;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("data3", str);
        AppContext.getContext().getContentResolver().update(DBUriManager.b(ho3.class, chatItem), contentValues, "packet_id=?", new String[]{str2});
    }

    public static String M(MessageVo messageVo, MessageProto.Message message) {
        if (messageVo.mimeType != 1 || message == null || TextUtils.isEmpty(message.getExtension())) {
            return null;
        }
        return MessageVo.mergeJsonStrings(message.getExtension(), messageVo.extention);
    }

    public static boolean N(MessageVo messageVo) {
        String str = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_extend", messageVo.extention);
        return AppContext.getContext().getContentResolver().update(DBUriManager.a(ho3.class, 0), contentValues, "packet_id=? AND msg_status != ?", new String[]{str, messageVo.extention}) > 0;
    }

    public static void O(MessageVo messageVo, RichMsgVo richMsgVo) {
        String str = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_extend", az2.c(richMsgVo));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str});
    }

    public static boolean P(MessageVo messageVo, MessageProto.Message message) {
        String str = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        String strM = M(messageVo, message);
        if (!TextUtils.isEmpty(strM)) {
            messageVo.extention = strM;
            contentValues.put("msg_extend", strM);
        }
        contentValues.put("msg_status", (Integer) 3);
        return AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=? AND msg_status != ?", new String[]{str, String.valueOf(2)}) > 0;
    }

    public static void Q(MessageVo messageVo, MessageProto.Message message) {
        String str = messageVo.mid;
        if (A(messageVo)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        String strM = M(messageVo, message);
        if (!TextUtils.isEmpty(strM)) {
            contentValues.put("msg_extend", strM);
        }
        contentValues.put("msg_status", (Integer) 2);
        contentValues.put("buddy_id", Long.valueOf(message.getVersion()));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str});
    }

    public static void R(MessageVo messageVo, String str) {
        if (A(messageVo) || str == null) {
            return;
        }
        String str2 = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        contentValues.put("data5", str);
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str2});
    }

    public static void S(MessageVo messageVo, int i) {
        String str = messageVo.mid;
        if (A(messageVo)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("msg_sending_progress", Integer.valueOf(i));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str});
    }

    public static void T(MessageVo messageVo, int i) {
        String str = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        contentValues.put("data6", Integer.valueOf(i));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str});
    }

    public static void U(MessageVo messageVo, String str, String str2, String str3, long j) {
        String str4 = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        if (!A(messageVo)) {
            contentValues.put("msg_status", (Integer) 2);
        }
        contentValues.put("data1", messageVo.data1);
        if (messageVo.data1 != null) {
            File file = new File(messageVo.data1);
            if (file.exists()) {
                contentValues.put("data10", Long.valueOf(file.length()));
            }
        }
        contentValues.put("buddy_id", Long.valueOf(j));
        contentValues.put("data3", str);
        contentValues.put("data4", str2);
        contentValues.put("data8", str3);
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str4});
    }

    public static void V(MessageVo messageVo, String str, long j) {
        String str2 = messageVo.mid;
        ContentValues contentValues = new ContentValues();
        if (!A(messageVo)) {
            contentValues.put("msg_status", (Integer) 2);
        }
        contentValues.put("data3", str);
        contentValues.put("buddy_id", Long.valueOf(j));
        AppContext.getContext().getContentResolver().update(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValues, "packet_id=?", new String[]{str2});
    }

    public static void a(MessageVo messageVo) {
        ChatBubble chatBubbleE;
        if (messageVo == null || messageVo.mimeType == 30 || !messageVo.isSend || (chatBubbleE = d20.e()) == null) {
            return;
        }
        try {
            String strC = az2.c(ChatBubbleVo.fromResponse(chatBubbleE));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("chatBubble", new JSONObject(strC));
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(messageVo.extention)) {
                string = MessageVo.mergeJsonStrings(string, messageVo.extention);
            }
            messageVo.extention = string;
        } catch (Exception unused) {
        }
    }

    public static ContactInfoItem b(MessageProto.Message message) {
        if (B(message)) {
            try {
                String strJ = DomainHelper.j(message.getTo());
                JSONObject jSONObjectOptJSONObject = new JSONObject(message.getExtension()).optJSONObject("toUserInfo");
                String string = jSONObjectOptJSONObject.getString("headIconUrl");
                String string2 = jSONObjectOptJSONObject.getString("nickname");
                String strOptString = jSONObjectOptJSONObject.optString(bd.h);
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(strJ);
                contactInfoItem.setIconURL(string);
                contactInfoItem.setNickName(string2);
                contactInfoItem.setExid(strOptString);
                return contactInfoItem;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        try {
            String strJ2 = DomainHelper.j(message.getFrom());
            JSONObject jSONObject = new JSONObject(message.getExtension());
            String string3 = jSONObject.getString("headIconUrl");
            String string4 = jSONObject.getString("nickname");
            String strOptString2 = jSONObject.optString(bd.h);
            ContactInfoItem contactInfoItem2 = new ContactInfoItem();
            contactInfoItem2.setUid(strJ2);
            contactInfoItem2.setIconURL(string3);
            contactInfoItem2.setNickName(string4);
            contactInfoItem2.setExid(strOptString2);
            return contactInfoItem2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ContentValues c(MessageVo messageVo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("packet_id", messageVo.mid);
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(messageVo.time));
        contentValues.put("dest", messageVo.to);
        contentValues.put("message", messageVo.text);
        contentValues.put("msg_extend", messageVo.extention);
        contentValues.put("msg_type", Integer.valueOf(messageVo.mimeType));
        contentValues.put("read", Integer.valueOf(messageVo.isRead ? 1 : 0));
        contentValues.put("src", messageVo.from);
        contentValues.put("type", Integer.valueOf(messageVo.isSend ? 2 : 1));
        contentValues.put("contact_relate", messageVo.contactRelate);
        contentValues.put("msg_status", Integer.valueOf(messageVo.status));
        contentValues.put("attach_status", Integer.valueOf(messageVo.attachStatus));
        contentValues.put("data1", messageVo.data1);
        contentValues.put("data2", messageVo.data2);
        contentValues.put("data3", messageVo.data3);
        contentValues.put("data4", messageVo.data4);
        contentValues.put("data5", messageVo.data5);
        contentValues.put("data6", messageVo.data6);
        contentValues.put("data7", messageVo.sendFlag);
        contentValues.put("data8", messageVo.hdFlag);
        if (Integer.valueOf(messageVo.sendFlag).intValue() == 0) {
            contentValues.put("data9", String.valueOf(hx3.m(null)));
        }
        contentValues.put("data10", messageVo.data10);
        contentValues.put("buddy_id", Long.valueOf(messageVo.versionId));
        contentValues.put("msg_sending_progress", Integer.valueOf(messageVo.sendingProgress));
        contentValues.put("thread_biz_type", Integer.valueOf(messageVo.bizType));
        return contentValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MessageVo d(String str, ChatItem chatItem) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        messageVoBuildFromCursor = null;
        messageVoBuildFromCursor = null;
        messageVoBuildFromCursor = null;
        MessageVo messageVoBuildFromCursor = null;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.b(ho3.class, chatItem), null, "packet_id=? ", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToNext()) {
                            messageVoBuildFromCursor = MessageVo.buildFromCursor(cursorQuery);
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                        }
                        return messageVoBuildFromCursor;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return messageVoBuildFromCursor;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x06ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ContentValues e(MessageProto.Message message) {
        String str;
        int i;
        JSONObject jSONObjectOptJSONObject;
        VoiceCmd voiceCmd;
        String str2;
        BaseResponse baseResponse;
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject2;
        String strOptString3;
        String strOptString4;
        JSONObject jSONObjectOptJSONObject3;
        MessageProto.Message message2 = message;
        ContentValues contentValues = new ContentValues();
        String strT = DomainHelper.t(message.getFrom());
        String strT2 = DomainHelper.t(message.getTo());
        String mid = message.getMid();
        MessageProto.Message.Media mediaE = me3.e(message);
        if (message.getType() == 10000) {
            contentValues.put("msg_type", (Integer) 10000);
            if (fu5.o(message) == 1) {
                contentValues.put("data1", Integer.valueOf(fu5.o(message)));
                contentValues.put("data2", message.getExtension());
            }
            contentValues.put("data3", Integer.valueOf(message.getExType()));
        } else {
            if (message.getType() != 10002) {
                str = strT;
                if (message.getType() == 2) {
                    contentValues.put("data5", Integer.valueOf(message.getExType()));
                    if (mediaE == null || TextUtils.isEmpty(mediaE.getThumbUrl()) || TextUtils.isEmpty(mediaE.getUrl())) {
                        contentValues.put("msg_type", (Integer) 1);
                    } else {
                        contentValues.put("msg_type", (Integer) 2);
                        contentValues.put("data2", mediaE.getThumbUrl());
                        contentValues.put("data3", mediaE.getUrl());
                        if (!TextUtils.isEmpty(mediaE.getExtension())) {
                            contentValues.put("data4", mediaE.getExtension());
                        }
                    }
                } else {
                    if (message.getType() != 14) {
                        try {
                            if (message.getType() == 3) {
                                if (mediaE == null || TextUtils.isEmpty(mediaE.getUrl())) {
                                    contentValues.put("msg_type", (Integer) 1);
                                } else {
                                    contentValues.put("msg_type", (Integer) 3);
                                    contentValues.put("attach_status", (Integer) 3);
                                    contentValues.put("data3", mediaE.getUrl());
                                    contentValues.put("data1", Integer.valueOf(mediaE.getPlayLength()));
                                    contentValues.put("data4", new JSONObject(mediaE.getExtension()).getString("md5"));
                                }
                            } else if (message.getType() == 6) {
                                contentValues.put("msg_type", (Integer) 6);
                                if (mediaE != null && !TextUtils.isEmpty(mediaE.getUrl())) {
                                    contentValues.put("attach_status", (Integer) 0);
                                    contentValues.put("data2", mediaE.getUrl());
                                    contentValues.put("data3", mediaE.getName());
                                    contentValues.put("data4", Integer.valueOf(mediaE.getSize()));
                                    contentValues.put("data5", new JSONObject(mediaE.getExtension()).getString("md5"));
                                }
                            } else if (message.getType() == 7) {
                                String extension = message.getExtension();
                                contentValues.put("msg_type", (Integer) 7);
                                contentValues.put("data1", extension);
                                contentValues.put("data2", d.g().l(g53.a(extension)));
                            } else if (message.getType() == 16) {
                                contentValues.put("data1", String.valueOf(0));
                                contentValues.put("msg_type", (Integer) 1);
                            } else if (message.getType() == 22) {
                                try {
                                    jSONObjectOptJSONObject = new JSONObject(message.getExtension()).optJSONObject("couponInfo");
                                } catch (JSONException e) {
                                    e = e;
                                }
                                if (jSONObjectOptJSONObject != null) {
                                    try {
                                        int i2 = jSONObjectOptJSONObject.optInt("couponStatus", 0) == 1 ? 2 : 0;
                                        i = i2;
                                    } catch (JSONException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        i = 0;
                                    }
                                    contentValues.put("data1", String.valueOf(i));
                                    contentValues.put("msg_type", (Integer) 1);
                                }
                                i = i2;
                                contentValues.put("data1", String.valueOf(i));
                                contentValues.put("msg_type", (Integer) 1);
                            } else if (message.getType() == 17) {
                                TransferVo transferVoBuildFromJson = TransferVo.buildFromJson(message.getExtension());
                                if (transferVoBuildFromJson != null) {
                                    contentValues.put("data1", Integer.valueOf(transferVoBuildFromJson.status));
                                    contentValues.put("data2", transferVoBuildFromJson.transferId);
                                    contentValues.put("data3", Integer.valueOf(message.getExType()));
                                }
                                contentValues.put("msg_type", (Integer) 1);
                            } else if (message.getType() == 9) {
                                contentValues.put("msg_type", (Integer) 9);
                            } else if (message.getType() == 10001) {
                                contentValues.put("msg_type", (Integer) 10001);
                            } else if (message.getType() == 44) {
                                contentValues.put("msg_type", (Integer) 44);
                            } else if (message.getType() == 28 && g.s(message.getExType())) {
                                contentValues.put("msg_type", (Integer) 28);
                                contentValues.put("data1", message.getExtension());
                                contentValues.put("data2", Integer.valueOf(message.getExType()));
                            } else if (message.getType() == 10005) {
                                contentValues.put("msg_type", (Integer) 10005);
                                contentValues.put("data1", Integer.valueOf(fu5.o(message)));
                                contentValues.put("data2", Integer.valueOf(message.getExType()));
                                contentValues.put("data3", message.getExtension());
                            } else if (message.getType() == 52) {
                                String extension2 = message.getExtension();
                                try {
                                    baseResponse = (BaseResponse) new Gson().fromJson(extension2, new a().getType());
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                if (baseResponse == null || baseResponse.getData() == null) {
                                    JSONObject jSONObjectH = lg1.c().h(DomainHelper.q(str).equals(AccountUtils.p(AppContext.getContext())) ? DomainHelper.j(message.getTo()) : DomainHelper.j(message.getFrom()), new JSONObject(extension2).optJSONObject("jieLong").optString("jlId"));
                                    MessageProto.Message messageBuild = jSONObjectH.optInt("resultCode") == 0 ? message.toBuilder().setExtension(jSONObjectH.toString()).build() : message;
                                    contentValues.put("msg_type", (Integer) 52);
                                    contentValues.put("data1", Integer.valueOf(fu5.o(messageBuild)));
                                    contentValues.put("data2", Integer.valueOf(messageBuild.getExType()));
                                    contentValues.put("data3", messageBuild.getExtension());
                                    message2 = messageBuild;
                                }
                            } else if (message.getType() == 53) {
                                contentValues.put("msg_type", (Integer) 53);
                                contentValues.put("data1", Integer.valueOf(fu5.o(message)));
                                contentValues.put("data2", Integer.valueOf(message.getExType()));
                                contentValues.put("data3", message.getExtension());
                            } else if (message.getType() == 4) {
                                if (mediaE == null || TextUtils.isEmpty(mediaE.getUrl())) {
                                    contentValues.put("msg_type", (Integer) 1);
                                } else {
                                    contentValues.put("msg_type", (Integer) 4);
                                    contentValues.put("attach_status", (Integer) 0);
                                    contentValues.put("data3", mediaE.getUrl());
                                    contentValues.put("data4", mediaE.getThumbUrl());
                                    contentValues.put("data6", String.valueOf(mediaE.getPlayLength()));
                                    contentValues.put("data10", String.valueOf(mediaE.getSize()));
                                    String strF = eb6.e().f(mediaE.getUrl());
                                    if (!TextUtils.isEmpty(strF)) {
                                        String str3 = pu1.l + File.separator + strF + ".mp4";
                                        if (new File(str3).exists()) {
                                            contentValues.put("data1", str3);
                                            contentValues.put("data2", str3 + ".thumbnail");
                                            contentValues.put("msg_sending_progress", (Integer) 100);
                                            contentValues.put("attach_status", (Integer) 2);
                                        }
                                    }
                                    contentValues.put("data5", new JSONObject(mediaE.getExtension()).getString("md5"));
                                    contentValues.put("data8", mediaE.getExtension());
                                }
                            } else if (message.getType() == 102) {
                                contentValues.put("msg_type", (Integer) 102);
                            } else if (message.getType() == 50) {
                                contentValues.put("msg_type", (Integer) 50);
                            } else if (message.getType() == 42) {
                                contentValues.put("msg_type", (Integer) 42);
                                contentValues.put("data1", Integer.valueOf(fu5.o(message)));
                            } else if (message.getType() == 49) {
                                contentValues.put("msg_type", (Integer) 49);
                                VoiceCmdExt fromExt = VoiceCmdExt.parseFromExt(message.getExtension());
                                if (fromExt != null && (voiceCmd = fromExt.voiceCmd) != null && (str2 = voiceCmd.groupId) != null) {
                                    contentValues.put("data1", str2);
                                }
                            } else if (message.getType() == 24 && oc0.j(message)) {
                                contentValues.put("msg_type", (Integer) 24);
                                contentValues.put("data2", Integer.valueOf(fu5.o(message)));
                                contentValues.put("data3", Integer.valueOf(message.getExType()));
                            } else {
                                message2 = message;
                                cs3 cs3VarA = ds3.c().a(message2);
                                if (cs3VarA != null) {
                                    cs3VarA.c(contentValues, message2);
                                } else {
                                    contentValues.put("msg_type", (Integer) 1);
                                    contentValues.put("data1", Integer.valueOf(fu5.o(message)));
                                    contentValues.put("data2", message.getExtension());
                                    if (message.getFrom() != null && DomainHelper.r(message.getFrom())) {
                                        contentValues.put(CommonCode.MapKey.UPDATE_VERSION, Boolean.TRUE);
                                    }
                                }
                            }
                        } catch (JSONException | Exception unused) {
                        }
                        contentValues.put("msg_extend", message2.getExtension());
                        contentValues.put("packet_id", message2.getMid());
                        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(message2.getCreateTime()));
                        contentValues.put("dest", strT2);
                        if (message2.getType() == 14) {
                            contentValues.put("message", AppContext.getContext().getString(R.string.string_message_type_expression));
                        } else if (mb4.h(message2.getType())) {
                            contentValues.put("message", "[收到一个红包，因服务维护暂不可使用]");
                        } else if (TextUtils.isEmpty(message2.getBody())) {
                            contentValues.put("message", AppContext.getContext().getString(R.string.tab_threads));
                        } else if (TextUtils.isEmpty(contentValues.getAsString("message"))) {
                            contentValues.put("message", message2.getBody());
                        }
                        String str4 = str;
                        contentValues.put("src", str4);
                        String str5 = null;
                        if (TextUtils.isEmpty(AccountUtils.p(AppContext.getContext()))) {
                            LogUtil.i("buildReceiveMessageContentValue", 3, new C1045b(str4, strT2, mid), (Throwable) null);
                        }
                        int iM = m(message2);
                        contentValues.put("thread_biz_type", Integer.valueOf(iM));
                        if (B(message2)) {
                            contentValues.put("type", (Integer) 2);
                            contentValues.put("contact_relate", DomainHelper.c(DomainHelper.k(strT2), iM));
                            contentValues.put("read", (Integer) 1);
                        } else {
                            contentValues.put("type", (Integer) 1);
                            contentValues.put("contact_relate", DomainHelper.c(DomainHelper.k(str4), iM));
                            contentValues.put("read", (Integer) 0);
                        }
                        contentValues.put("msg_status", (Integer) 2);
                        if (message2.getType() != 3) {
                            contentValues.put("attach_status", (Integer) 0);
                        }
                        if (message2.getType() == 10001) {
                            String extension3 = message2.getExtension();
                            if (extension3 != null) {
                                try {
                                    jSONObjectOptJSONObject3 = new JSONObject(extension3).optJSONObject("revokeMsg");
                                } catch (JSONException e4) {
                                    e = e4;
                                    strOptString3 = null;
                                }
                                if (jSONObjectOptJSONObject3 != null) {
                                    strOptString3 = jSONObjectOptJSONObject3.optString("replaceMid");
                                    try {
                                        strOptString4 = jSONObjectOptJSONObject3.optString("replaceMsg");
                                    } catch (JSONException e5) {
                                        e = e5;
                                        e.printStackTrace();
                                        strOptString4 = null;
                                    }
                                    str5 = strOptString3;
                                    contentValues.put("packet_id", str5);
                                    contentValues.put("message", strOptString4);
                                }
                                strOptString4 = null;
                                contentValues.put("packet_id", str5);
                                contentValues.put("message", strOptString4);
                            } else {
                                strOptString4 = null;
                                contentValues.put("packet_id", str5);
                                contentValues.put("message", strOptString4);
                            }
                        } else if (message2.getType() == 44) {
                            String extension4 = message2.getExtension();
                            if (extension4 != null) {
                                try {
                                    jSONObjectOptJSONObject2 = new JSONObject(extension4).optJSONObject("thumbReplaceCmd");
                                } catch (JSONException e6) {
                                    e = e6;
                                    strOptString = null;
                                }
                                if (jSONObjectOptJSONObject2 != null) {
                                    strOptString = jSONObjectOptJSONObject2.optString("mid");
                                    try {
                                        strOptString2 = jSONObjectOptJSONObject2.optString("thumbUrl");
                                    } catch (JSONException e7) {
                                        e = e7;
                                        e.printStackTrace();
                                        strOptString2 = null;
                                    }
                                    str5 = strOptString;
                                    contentValues.put("packet_id", str5);
                                    contentValues.put("message", strOptString2);
                                }
                                strOptString2 = null;
                                contentValues.put("packet_id", str5);
                                contentValues.put("message", strOptString2);
                            } else {
                                strOptString2 = null;
                                contentValues.put("packet_id", str5);
                                contentValues.put("message", strOptString2);
                            }
                        }
                        contentValues.put("resource_type", message2.getSyncKey());
                        contentValues.put("resource_version", Long.valueOf(message2.getVersion()));
                        contentValues.put("buddy_id", Long.valueOf(message2.getVersion()));
                        return contentValues;
                    }
                    String extension5 = message.getExtension();
                    message.getExType();
                    if (mediaE != null && !TextUtils.isEmpty(mediaE.getThumbUrl()) && !TextUtils.isEmpty(mediaE.getUrl())) {
                        contentValues.put("msg_type", (Integer) 14);
                        contentValues.put("data2", mediaE.getThumbUrl());
                        contentValues.put("data3", mediaE.getUrl());
                        if (!TextUtils.isEmpty(mediaE.getExtension())) {
                            contentValues.put("data4", mediaE.getExtension());
                        }
                        if (message.getExType() == 1) {
                            contentValues.put("data6", Integer.valueOf(message.getExType()));
                        }
                    } else if (TextUtils.isEmpty(extension5)) {
                        contentValues.put("msg_type", (Integer) 1);
                    } else {
                        contentValues.put("msg_type", (Integer) 14);
                        contentValues.put("data5", extension5);
                    }
                }
                message2 = message;
                contentValues.put("msg_extend", message2.getExtension());
                contentValues.put("packet_id", message2.getMid());
                contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(message2.getCreateTime()));
                contentValues.put("dest", strT2);
                if (message2.getType() == 14) {
                }
                String str42 = str;
                contentValues.put("src", str42);
                String str52 = null;
                if (TextUtils.isEmpty(AccountUtils.p(AppContext.getContext()))) {
                }
                int iM2 = m(message2);
                contentValues.put("thread_biz_type", Integer.valueOf(iM2));
                if (B(message2)) {
                }
                contentValues.put("msg_status", (Integer) 2);
                if (message2.getType() != 3) {
                }
                if (message2.getType() == 10001) {
                }
                contentValues.put("resource_type", message2.getSyncKey());
                contentValues.put("resource_version", Long.valueOf(message2.getVersion()));
                contentValues.put("buddy_id", Long.valueOf(message2.getVersion()));
                return contentValues;
            }
            contentValues.put("msg_type", (Integer) 10002);
            contentValues.put("data1", Integer.valueOf(fu5.o(message)));
            contentValues.put("data2", message.getExtension());
            if (es3.c(message.getExtension(), message.getBody(), message.getType())) {
                contentValues.put(CommonCode.MapKey.UPDATE_VERSION, Boolean.TRUE);
            }
            message2 = message;
        }
        str = strT;
        contentValues.put("msg_extend", message2.getExtension());
        contentValues.put("packet_id", message2.getMid());
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(message2.getCreateTime()));
        contentValues.put("dest", strT2);
        if (message2.getType() == 14) {
        }
        String str422 = str;
        contentValues.put("src", str422);
        String str522 = null;
        if (TextUtils.isEmpty(AccountUtils.p(AppContext.getContext()))) {
        }
        int iM22 = m(message2);
        contentValues.put("thread_biz_type", Integer.valueOf(iM22));
        if (B(message2)) {
        }
        contentValues.put("msg_status", (Integer) 2);
        if (message2.getType() != 3) {
        }
        if (message2.getType() == 10001) {
        }
        contentValues.put("resource_type", message2.getSyncKey());
        contentValues.put("resource_version", Long.valueOf(message2.getVersion()));
        contentValues.put("buddy_id", Long.valueOf(message2.getVersion()));
        return contentValues;
    }

    public static ContentValues f(MessageProto.Message message) {
        ContactInfoItem contactInfoItemB;
        boolean z;
        String extension = message.getExtension();
        int iO = fu5.o(message);
        if (TextUtils.isEmpty(extension) || !fu5.w(message) || (contactInfoItemB = b(message)) == null) {
            return null;
        }
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(ho0.f18003a, null, "uid=? and data2 is ?", new String[]{contactInfoItemB.getUid(), String.valueOf(0)}, null);
        if (cursorQuery != null) {
            z = cursorQuery.getCount() > 0;
            cursorQuery.close();
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_operation", (Integer) 1);
        contentValues.put(DeviceInfoUtil.UID_TAG, contactInfoItemB.getUid());
        contentValues.put("head_img_url", contactInfoItemB.getIconURL());
        contentValues.put("nick_name", contactInfoItemB.getNickName());
        contentValues.put("data4", contactInfoItemB.getExid());
        if (iO == 16) {
            contentValues.put("data2", (Integer) 0);
            contentValues.put("account_type", (Integer) 1);
        } else {
            contentValues.put("data2", (Integer) 1);
        }
        return contentValues;
    }

    public static void g() {
        for (DBUriManager.MsgSaveType msgSaveType : DBUriManager.MsgSaveType.values()) {
            AppContext.getContext().getContentResolver().delete(DBUriManager.d(ho3.class, msgSaveType), null, null);
        }
    }

    public static void h(String str) {
        AppContext.getContext().getContentResolver().delete(dx5.f17178a, "thread_biz_type = ? and chat_type = ? and thread_biz_extension = ? ", new String[]{String.valueOf(22), String.valueOf(0), str});
    }

    public static void i(String str, ChatItem chatItem) {
        AppContext.getContext().getContentResolver().delete(DBUriManager.b(ho3.class, chatItem), "packet_id=? ", new String[]{str});
    }

    public static void j(ChatItem chatItem) {
        String[] strArr;
        String str;
        if (chatItem.getChatType() == 0) {
            strArr = new String[]{DomainHelper.a(chatItem, false)};
            str = "contact_relate=? ";
        } else if (chatItem.getChatType() == 1) {
            boolean zC = com.zenmen.palmchat.database.a.c();
            str = "contact_relate" + com.zenmen.palmchat.database.a.b(zC);
            strArr = new String[]{DomainHelper.e(chatItem) + com.zenmen.palmchat.database.a.a(zC)};
        } else {
            strArr = null;
            str = null;
        }
        AppContext.getContext().getContentResolver().delete(DBUriManager.b(ho3.class, chatItem), str, strArr);
    }

    public static void k(ChatItem chatItem) {
        AppContext.getContext().getContentResolver().delete(DBUriManager.b(ho3.class, chatItem), "contact_relate=? ", new String[]{chatItem.getChatId()});
    }

    public static void l(ArrayList<String> arrayList, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (i2 == arrayList.size() - 1) {
                sb.append("contact_relate= " + str);
            } else {
                sb.append("contact_relate= " + str + " or ");
            }
        }
        AppContext.getContext().getContentResolver().delete(DBUriManager.a(ho3.class, 0), sb.toString(), null);
    }

    public static int m(MessageProto.Message message) {
        DomainHelper.Domains domainsN = n(message);
        if (message == null) {
            return 0;
        }
        if (fu5.v(domainsN)) {
            return fu5.e(domainsN, message);
        }
        int iO = fu5.o(message);
        if (iO == 13) {
            return 13;
        }
        if (iO != 14) {
            return iO != 17 ? 0 : 17;
        }
        return 14;
    }

    public static DomainHelper.Domains n(MessageProto.Message message) {
        DomainHelper.Domains domains = DomainHelper.Domains.DOMAIN_SINGLECHAT;
        if (message != null) {
            return DomainHelper.n(B(message) ? message.getTo() : message.getFrom());
        }
        return domains;
    }

    public static long o(String str) {
        long jMax = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ho3.class, 0), null, "contact_relate=? and buddy_id>0", new String[]{str}, "buddy_id DESC limit 1");
                if (cursorQuery != null && cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    jMax = cursorQuery.getLong(cursorQuery.getColumnIndex("buddy_id"));
                    cursorQuery.close();
                }
                long jE = lt4.d().e(str);
                LogUtil.i("MsgDbOp", "getLastMsgVersion " + jMax + " readVersion=" + jE);
                jMax = Math.max(jE, jMax);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jMax + 1;
    }

    public static int p(int i, String[] strArr) {
        if (i + 50 > strArr.length) {
            return strArr.length - i;
        }
        return 50;
    }

    public static long q(String str, ChatItem chatItem) {
        long j = 0;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.b(ho3.class, chatItem), null, "packet_id=?", new String[]{str}, null);
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    j = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return j;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static int r(DBUriManager.MsgSaveType msgSaveType) {
        int i = 0;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.d(ho3.class, msgSaveType), new String[]{"_id"}, null, null, "_id DESC limit 1 ");
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    i = cursorQuery.getInt(0);
                    LogUtil.i("SocialContentProvider", "getTotalMsgCount =" + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return i;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static void s(ContactRequestsVO contactRequestsVO) {
        if (!TextUtils.isEmpty(contactRequestsVO.identifyCode)) {
            h(contactRequestsVO.identifyCode);
        }
        String strP = AccountUtils.p(AppContext.getContext());
        ContentValues contentValues = new ContentValues();
        contentValues.put("packet_id", xn3.a());
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(!TextUtils.isEmpty(contactRequestsVO.sendTime) ? Long.valueOf(contactRequestsVO.sendTime).longValue() : ir5.b()));
        contentValues.put("dest", strP);
        contentValues.put("message", contactRequestsVO.requestInfo);
        contentValues.put("msg_type", (Integer) 1);
        contentValues.put("data1", (Integer) 22);
        contentValues.put("read", (Integer) 0);
        contentValues.put("src", contactRequestsVO.fromUid);
        contentValues.put("type", (Integer) 1);
        contentValues.put("contact_relate", contactRequestsVO.fromUid);
        contentValues.put("msg_status", (Integer) 2);
        contentValues.put("msg_extend", contactRequestsVO.identifyCode);
        contentValues.put("thread_biz_type", (Integer) 22);
        contentValues.put("icon_url", contactRequestsVO.fromHeadIcon);
        contentValues.put("title", contactRequestsVO.fromNickName);
        AppContext.getContext().getContentResolver().insert(DBUriManager.a(ho3.class, 0), contentValues);
    }

    public static void t(MessageVo messageVo) {
        u(messageVo, true);
    }

    public static void u(MessageVo messageVo, boolean z) {
        a(messageVo);
        ContentValues contentValuesC = c(messageVo);
        try {
            if (z) {
                AppContext.getContext().getContentResolver().insert(DBUriManager.c(ho3.class, messageVo.contactRelate), contentValuesC);
            } else {
                zh.k(AppContext.getContext().getContentResolver()).h(0, null, DBUriManager.c(ho3.class, messageVo.contactRelate), contentValuesC);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void v(ChatItem chatItem, List<MessageVo> list) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<MessageVo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(c(it.next()));
            }
            dv.a("processMessagesInsert", DBUriManager.b(ho3.class, chatItem), (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void w(ChatItem chatItem, String str) {
        String strP = AccountUtils.p(AppContext.getContext());
        String strE = DomainHelper.e(chatItem);
        ContentValues contentValues = new ContentValues();
        contentValues.put("packet_id", xn3.a());
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, Long.valueOf(ir5.b()));
        contentValues.put("dest", strE);
        contentValues.put("message", str);
        contentValues.put("msg_type", (Integer) 10000);
        contentValues.put("read", (Integer) 1);
        contentValues.put("src", strP);
        contentValues.put("type", (Integer) 2);
        contentValues.put("contact_relate", strE);
        contentValues.put("msg_status", (Integer) 2);
        AppContext.getContext().getContentResolver().insert(DBUriManager.b(ho3.class, chatItem), contentValues);
    }

    public static void x(MessageProto.Message message) {
        ContentResolver contentResolver = AppContext.getContext().getContentResolver();
        ContentValues contentValuesF = f(message);
        if (contentValuesF != null) {
            contentResolver.insert(ho0.f18003a, contentValuesF);
        }
        contentResolver.insert(DBUriManager.c(ho3.class, message.getFrom()), e(message));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[PHI: r0
      0x0041: PHI (r0v5 android.database.Cursor) = (r0v4 android.database.Cursor), (r0v6 android.database.Cursor) binds: [B:20:0x003f, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean y(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ho3.class, 0), null, "contact_relate=? and data2=?", new String[]{str, str2}, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.close();
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static boolean z(String str, String str2) {
        boolean z = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.c(ho3.class, str), null, "packet_id=?", new String[]{str2}, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return z;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
