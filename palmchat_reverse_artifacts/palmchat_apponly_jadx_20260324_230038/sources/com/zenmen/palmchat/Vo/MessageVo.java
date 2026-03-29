package com.zenmen.palmchat.Vo;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.photoview.PhotoObject;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.media.AudioObject;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.RedPacketVo;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.transfer.bean.TransferVo;
import defpackage.az2;
import defpackage.bo0;
import defpackage.f33;
import defpackage.fu5;
import defpackage.g53;
import defpackage.il5;
import defpackage.ir5;
import defpackage.m40;
import defpackage.nn0;
import defpackage.o86;
import defpackage.or2;
import defpackage.pt1;
import defpackage.rb3;
import defpackage.sd1;
import defpackage.xn3;
import defpackage.xt;
import defpackage.zv3;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MessageVo extends BaseVo implements Cloneable {
    public static final Parcelable.Creator<MessageVo> CREATOR = new Parcelable.Creator<MessageVo>() { // from class: com.zenmen.palmchat.Vo.MessageVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageVo createFromParcel(Parcel parcel) {
            MessageVo messageVo = new MessageVo();
            messageVo.isSend = parcel.readByte() != 0;
            messageVo.nickName = parcel.readString();
            messageVo.status = parcel.readInt();
            messageVo.mid = parcel.readString();
            messageVo._id = parcel.readLong();
            messageVo.versionId = parcel.readLong();
            messageVo.mimeType = parcel.readInt();
            messageVo.time = parcel.readLong();
            messageVo.attachStatus = parcel.readInt();
            messageVo.attachPlaying = parcel.readInt();
            messageVo.isRead = parcel.readByte() != 0;
            messageVo.sendingProgress = parcel.readInt();
            messageVo.extention = parcel.readString();
            messageVo.text = parcel.readString();
            messageVo.data1 = parcel.readString();
            messageVo.data2 = parcel.readString();
            messageVo.data3 = parcel.readString();
            messageVo.data4 = parcel.readString();
            messageVo.data5 = parcel.readString();
            messageVo.data6 = parcel.readString();
            messageVo.sendFlag = parcel.readString();
            messageVo.hdFlag = parcel.readString();
            messageVo.data9 = parcel.readString();
            messageVo.contactRelate = parcel.readString();
            messageVo.to = parcel.readString();
            messageVo.from = parcel.readString();
            messageVo.bizType = parcel.readInt();
            messageVo.bizExtension = parcel.readString();
            messageVo.data10 = parcel.readString();
            messageVo.logExtension = parcel.readString();
            return messageVo;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageVo[] newArray(int i) {
            return new MessageVo[i];
        }
    };
    public long _id;
    public int adType;
    public int attachPlaying;
    public int attachStatus;
    public String bizExtension;
    public int bizType;
    public String contactRelate;
    public String data1;
    public String data10;
    public String data2;
    public String data3;
    public String data4;
    public String data5;
    public String data6;
    public String data9;
    public String extention;
    public String from;
    public String hdFlag;
    public boolean isRead;
    public boolean isSend;
    public String logExtension;
    public String mid;
    public int mimeType;
    public NestAdData nestAdData;
    public String nickName;
    public String sendFlag;
    public int sendingProgress;
    public int status;
    public String text;
    public long time;
    public String to;
    public long versionId;

    public static boolean appendImageNoticeMessage(MessageVo messageVo, String str) {
        if (messageVo == null || messageVo.mimeType != 2) {
            return false;
        }
        ImageExtensionVo imageExtensionVo = new ImageExtensionVo();
        imageExtensionVo.setExtraType(1);
        imageExtensionVo.setExtraTitle(str);
        String strC = az2.c(imageExtensionVo);
        if (!TextUtils.isEmpty(messageVo.extention)) {
            strC = mergeJsonStrings(strC, messageVo.extention);
        }
        messageVo.extention = strC;
        return true;
    }

    public static MessageVo buildAdMessage(int i) {
        NestAdData nestAdData = i == 0 ? zv3.d : i == 1 ? zv3.f : i == 2 ? zv3.e : null;
        if (nestAdData == null) {
            return null;
        }
        MessageVo messageVo = new MessageVo();
        messageVo.time = ir5.b();
        messageVo.from = AccountUtils.p(AppContext.getContext());
        messageVo.mimeType = 36;
        messageVo.isRead = true;
        messageVo.isSend = false;
        messageVo.status = 1;
        messageVo.nestAdData = nestAdData;
        messageVo.adType = i;
        return messageVo;
    }

    public static MessageVo buildAudioMessage(AudioObject audioObject, int i) {
        return buildAudioMessage(audioObject, i, ir5.b());
    }

    public static MessageVo buildExpressionMessage(String str, String str2, ExpressionObject expressionObject, int i) {
        return buildExpressionMessage(str, str2, expressionObject, i, ir5.b());
    }

    public static ExpressionObject buildExpressionMessageSend(MessageVo messageVo) {
        String path = messageVo.data1;
        String str = messageVo.data2;
        String str2 = messageVo.data3;
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String strOptString = !TextUtils.isEmpty(messageVo.data4) ? new JSONObject(messageVo.data4).optString("hdUrl") : null;
        if (!o86.k(path)) {
            File fileB = sd1.b(str);
            File fileB2 = sd1.b(str2);
            File fileB3 = sd1.b(strOptString);
            path = (fileB3 == null || !o86.k(fileB3.getPath())) ? (fileB2 == null || !o86.k(fileB2.getPath())) ? (fileB == null || !o86.k(fileB.getPath())) ? null : fileB.getPath() : fileB2.getPath() : fileB3.getPath();
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        ExpressionObject expressionObject = new ExpressionObject();
        expressionObject.path = path;
        return expressionObject;
    }

    public static MessageVo buildFileMessage(String str, String str2, String str3, int i) {
        return buildFileMessage(str, str2, str3, i, ir5.b());
    }

    public static MessageVo buildForwardExpressionMessage(String str, String str2, ExpressionObject expressionObject, int i) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = ir5.b();
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getResources().getString(R.string.string_message_type_expression);
        messageVo.mimeType = 14;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = "";
        messageVo.attachStatus = 2;
        messageVo.data1 = expressionObject.path;
        messageVo.data2 = expressionObject.thumbUrl;
        messageVo.data3 = expressionObject.url;
        messageVo.data4 = expressionObject.extension;
        return messageVo;
    }

    public static MessageVo buildForwardFileMessage(String str, String str2, MessageVo messageVo, int i) {
        String str3 = messageVo.data1;
        String str4 = messageVo.data2;
        MessageVo messageVo2 = new MessageVo();
        messageVo2.mid = str;
        messageVo2.time = ir5.b();
        messageVo2.contactRelate = str2;
        messageVo2.to = str2;
        messageVo2.text = AppContext.getContext().getResources().getString(R.string.message_type_file);
        messageVo2.mimeType = 6;
        messageVo2.isRead = true;
        messageVo2.isSend = true;
        messageVo2.status = 1;
        messageVo2.sendFlag = String.valueOf(i);
        messageVo2.extention = "";
        messageVo2.attachStatus = 2;
        messageVo2.data1 = str3;
        messageVo2.data2 = str4;
        File file = new File(str3);
        if (file.exists()) {
            messageVo2.data3 = il5.l(messageVo.data3) ? file.getName() : messageVo.data3;
            messageVo2.data4 = il5.l(messageVo.data4) ? String.valueOf(file.length()) : messageVo.data4;
            messageVo2.data5 = il5.l(messageVo.data5) ? rb3.b(file) : messageVo.data5;
        } else {
            if (TextUtils.isEmpty(messageVo.data3)) {
                messageVo2.data3 = Constants.STRING_VALUE_UNSET;
            } else {
                messageVo2.data3 = messageVo.data3;
            }
            if (TextUtils.isEmpty(messageVo.data4)) {
                messageVo2.data4 = String.valueOf(0);
            } else {
                messageVo2.data4 = messageVo.data4;
            }
            if (TextUtils.isEmpty(messageVo.data5)) {
                messageVo2.data5 = "";
            } else {
                messageVo2.data5 = messageVo.data5;
            }
        }
        messageVo2.sendingProgress = 0;
        return messageVo2;
    }

    public static MessageVo buildForwardImageMessage(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, boolean z) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = ir5.b();
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = str7;
        if (z) {
            messageVo.data5 = String.valueOf(1);
            messageVo.text = str7;
        }
        messageVo.mimeType = 2;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.data1 = str3;
        messageVo.data2 = str5;
        messageVo.data3 = str4;
        messageVo.data4 = str6;
        messageVo.extention = "";
        messageVo.attachStatus = 2;
        return messageVo;
    }

    public static ArrayList<MessageVo> buildForwardLinkMessage(String str, MessageVo messageVo, String str2, int i) {
        ArrayList<RichMsgExItemVo> arrayList;
        int i2;
        ArrayList<MessageVo> arrayList2 = new ArrayList<>();
        RichMsgExVo richMsgExVoG = g.g(str2);
        if (richMsgExVoG != null && (arrayList = richMsgExVoG.items) != null) {
            for (RichMsgExItemVo richMsgExItemVo : arrayList) {
                MessageVo messageVo2 = new MessageVo();
                messageVo2.mid = xn3.a();
                messageVo2.time = ir5.b();
                messageVo2.contactRelate = str;
                messageVo2.from = AccountUtils.p(AppContext.getContext());
                messageVo2.to = str;
                messageVo2.text = g.e(richMsgExItemVo, g.l(messageVo));
                messageVo2.mimeType = 28;
                messageVo2.isRead = true;
                messageVo2.isSend = true;
                messageVo2.status = 1;
                messageVo2.sendFlag = String.valueOf(i);
                messageVo2.attachStatus = 2;
                if (richMsgExVoG.items.size() == 1 && ((i2 = richMsgExItemVo.showType) == 0 || i2 == 6 || ((i2 == 11 && !richMsgExItemVo.matchParent) || i2 == 12 || i2 == 14 || i2 == 15 || i2 == 13))) {
                    messageVo2.data1 = str2;
                } else if (richMsgExVoG.items.size() == 1 && richMsgExItemVo.showType == 11 && richMsgExItemVo.matchParent) {
                    RichMsgExVo richMsgExVo = new RichMsgExVo();
                    ArrayList<RichMsgExItemVo> arrayList3 = new ArrayList<>();
                    richMsgExVo.items = arrayList3;
                    richMsgExVo.source = richMsgExVoG.source;
                    richMsgExItemVo.matchParent = false;
                    arrayList3.add(richMsgExItemVo);
                    RichMsgVo richMsgVo = new RichMsgVo();
                    richMsgVo.appMsg = richMsgExVo;
                    messageVo2.data1 = az2.c(richMsgVo);
                } else {
                    RichMsgExVo richMsgExVo2 = new RichMsgExVo();
                    richMsgExVo2.items = new ArrayList<>();
                    richMsgExVo2.source = richMsgExVoG.source;
                    RichMsgExItemVo richMsgExItemVo2 = new RichMsgExItemVo();
                    richMsgExItemVo2.showType = richMsgExItemVo.showType;
                    richMsgExItemVo2.url = richMsgExItemVo.url;
                    richMsgExItemVo2.cover = richMsgExItemVo.cover;
                    richMsgExItemVo2.title = richMsgExItemVo.title;
                    richMsgExItemVo2.digest = richMsgExItemVo.digest;
                    richMsgExVo2.items.add(richMsgExItemVo2);
                    RichMsgVo richMsgVo2 = new RichMsgVo();
                    richMsgVo2.appMsg = richMsgExVo2;
                    messageVo2.data1 = az2.c(richMsgVo2);
                }
                int iL = g.l(messageVo);
                if (richMsgExItemVo.showType == 6 && iL != 5) {
                    iL = g.k() ? 3 : 2;
                }
                messageVo2.data2 = String.valueOf(iL);
                int iH = f33.f().h(messageVo.data3);
                if (iH == -1 || iH == -2) {
                    messageVo2.data3 = String.valueOf(-1);
                }
                int i3 = richMsgExItemVo.showType;
                if (i3 == 0 || i3 == 12 || i3 == 14 || i3 == 15 || i3 == 13) {
                    messageVo2.data4 = messageVo.data4;
                }
                arrayList2.add(messageVo2);
            }
        }
        return arrayList2;
    }

    public static MessageVo buildForwardLocationMessage(String str, String str2, String str3, String str4, int i) {
        return buildForwardLocationMessage(str, str2, str3, str4, i, ir5.b());
    }

    public static MessageVo buildForwardVideoMessage(String str, String str2, MessageVo messageVo, int i) {
        MessageVo messageVo2 = new MessageVo();
        messageVo2.mid = str;
        messageVo2.time = ir5.b();
        messageVo2.contactRelate = str2;
        messageVo2.to = str2;
        messageVo2.text = AppContext.getContext().getResources().getString(R.string.message_type_sight);
        messageVo2.mimeType = 4;
        messageVo2.isRead = true;
        messageVo2.isSend = true;
        messageVo2.status = 1;
        messageVo2.sendFlag = String.valueOf(i);
        messageVo2.attachStatus = 2;
        messageVo2.extention = "";
        messageVo2.data1 = messageVo.data1;
        messageVo2.data2 = messageVo.data2;
        messageVo2.data3 = messageVo.data3;
        messageVo2.data4 = messageVo.data4;
        messageVo2.data5 = messageVo.data5;
        messageVo2.data6 = messageVo.data6;
        messageVo2.data10 = messageVo.data10;
        messageVo2.sendingProgress = messageVo.sendingProgress;
        return messageVo2;
    }

    public static MessageVo buildFromCursor(Cursor cursor) {
        MessageVo messageVo = new MessageVo();
        int i = cursor.getInt(cursor.getColumnIndex("type"));
        messageVo.status = cursor.getInt(cursor.getColumnIndex("msg_status"));
        messageVo.isSend = i == 2;
        messageVo.mid = cursor.getString(cursor.getColumnIndex("packet_id"));
        messageVo._id = cursor.getLong(cursor.getColumnIndex("_id"));
        messageVo.versionId = cursor.getLong(cursor.getColumnIndex("buddy_id"));
        messageVo.mimeType = cursor.getInt(cursor.getColumnIndex("msg_type"));
        messageVo.time = cursor.getLong(cursor.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
        messageVo.extention = cursor.getString(cursor.getColumnIndex("msg_extend"));
        messageVo.text = cursor.getString(cursor.getColumnIndex("message"));
        messageVo.attachStatus = cursor.getInt(cursor.getColumnIndex("attach_status"));
        messageVo.attachPlaying = cursor.getInt(cursor.getColumnIndex("attachment_read"));
        messageVo.data1 = cursor.getString(cursor.getColumnIndex("data1"));
        messageVo.data2 = cursor.getString(cursor.getColumnIndex("data2"));
        messageVo.data3 = cursor.getString(cursor.getColumnIndex("data3"));
        messageVo.data4 = cursor.getString(cursor.getColumnIndex("data4"));
        messageVo.data5 = cursor.getString(cursor.getColumnIndex("data5"));
        messageVo.data6 = cursor.getString(cursor.getColumnIndex("data6"));
        messageVo.sendFlag = cursor.getString(cursor.getColumnIndex("data7"));
        messageVo.hdFlag = cursor.getString(cursor.getColumnIndex("data8"));
        messageVo.data9 = cursor.getString(cursor.getColumnIndex("data9"));
        messageVo.data10 = cursor.getString(cursor.getColumnIndex("data10"));
        messageVo.isRead = cursor.getInt(cursor.getColumnIndex("read")) == 1;
        messageVo.sendingProgress = cursor.getInt(cursor.getColumnIndex("msg_sending_progress"));
        messageVo.contactRelate = cursor.getString(cursor.getColumnIndex("contact_relate"));
        messageVo.to = cursor.getString(cursor.getColumnIndex("dest"));
        messageVo.from = cursor.getString(cursor.getColumnIndex("src"));
        return messageVo;
    }

    public static MessageVo buildFromMessageProtoForTmpUse(MessageProto.Message message) {
        MessageVo messageVo = new MessageVo();
        if (message != null) {
            messageVo.mimeType = message.getType();
            messageVo.mid = message.getMid();
            String strT = DomainHelper.t(message.getFrom());
            String strT2 = DomainHelper.t(message.getTo());
            messageVo.to = strT2;
            messageVo.from = strT;
            messageVo.text = message.getBody();
            if (DomainHelper.q(strT).equals(AccountUtils.p(AppContext.getContext()))) {
                messageVo.isSend = true;
                messageVo.contactRelate = DomainHelper.k(strT2);
            } else {
                messageVo.isSend = false;
                messageVo.contactRelate = DomainHelper.k(strT);
            }
        }
        return messageVo;
    }

    public static MessageVo buildGifExpressionMessage(String str, String str2, ExpressionObject expressionObject, int i) {
        MessageVo messageVoBuildExpressionMessage = buildExpressionMessage(str, str2, expressionObject, i, ir5.b());
        messageVoBuildExpressionMessage.data6 = Integer.toString(1);
        return messageVoBuildExpressionMessage;
    }

    public static MessageVo buildImageMessage(String str, String str2, PhotoObject photoObject, boolean z, int i, String str3) {
        return buildImageMessage(str, str2, photoObject, z, i, ir5.b(), str3);
    }

    public static PhotoObject buildImageMessageSend(MessageVo messageVo) {
        String path = messageVo.data1;
        String str = messageVo.data2;
        String str2 = messageVo.data3;
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String strOptString = !TextUtils.isEmpty(messageVo.data4) ? new JSONObject(messageVo.data4).optString("hdUrl") : null;
        boolean z = false;
        boolean z2 = Boolean.valueOf(messageVo.hdFlag).booleanValue() || !TextUtils.isEmpty(strOptString);
        if (o86.k(path)) {
            z = z2;
        } else {
            File fileB = sd1.b(str);
            File fileB2 = sd1.b(str2);
            File fileB3 = sd1.b(strOptString);
            if (fileB3 != null && o86.k(fileB3.getPath())) {
                path = fileB3.getPath();
                z = z2;
            } else if (fileB2 != null && o86.k(fileB2.getPath())) {
                path = fileB2.getPath();
            } else if (fileB == null || !o86.k(fileB.getPath())) {
                z = z2;
                path = null;
            } else {
                path = fileB.getPath();
            }
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        PhotoObject photoObject = new PhotoObject();
        photoObject.path = path;
        photoObject.isOriImage = z;
        return photoObject;
    }

    public static MessageVo buildInputStatusMessage(String str, int i) {
        MessageVo messageVo = new MessageVo();
        messageVo.time = ir5.b();
        messageVo.contactRelate = str;
        messageVo.to = str;
        messageVo.mimeType = 19;
        messageVo.status = i;
        return messageVo;
    }

    public static MessageVo buildLinkMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = ir5.b();
        messageVo.contactRelate = str2;
        messageVo.from = AccountUtils.p(AppContext.getContext());
        messageVo.to = str2;
        messageVo.mimeType = 28;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.attachStatus = 2;
        RichMsgExVo richMsgExVo = new RichMsgExVo();
        richMsgExVo.items = new ArrayList<>();
        RichMsgExItemVo richMsgExItemVo = new RichMsgExItemVo();
        richMsgExItemVo.showType = 0;
        richMsgExItemVo.url = str5;
        richMsgExItemVo.cover = str6;
        richMsgExItemVo.title = str3;
        richMsgExItemVo.digest = str4;
        richMsgExVo.items.add(richMsgExItemVo);
        if (str7 != null) {
            AdditionItem additionItem = new AdditionItem();
            try {
                JSONObject jSONObject = new JSONObject(str7);
                additionItem.icon = jSONObject.optString("icon");
                additionItem.id = jSONObject.optString("id");
                additionItem.name = jSONObject.optString("name");
                richMsgExVo.source = additionItem;
            } catch (JSONException unused) {
            }
        }
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.appMsg = richMsgExVo;
        messageVo.data1 = az2.c(richMsgVo);
        messageVo.data2 = String.valueOf(2);
        messageVo.text = g.e(richMsgExItemVo, 2);
        return messageVo;
    }

    public static MessageVo buildLocationMessage(String str, String str2, LocationEx locationEx, int i, String str3) {
        return buildLocationMessage(str, str2, locationEx, i, ir5.b(), str3);
    }

    public static MessageVo buildNameCardMessage(String str, String str2, ContactInfoItem contactInfoItem, int i) {
        return buildNameCardMessage(str, str2, contactInfoItem, i, ir5.b());
    }

    public static MessageVo buildReadStatusMessage(String str) {
        MessageVo messageVo = new MessageVo();
        messageVo.time = ir5.b();
        messageVo.contactRelate = str;
        String str2 = AccountUtils.p(AppContext.getContext()) + DomainHelper.Domains.DOMAIN_SINGLECHAT.domain;
        messageVo.to = str + "@cmd.youni";
        messageVo.from = str2;
        messageVo.mimeType = 15000;
        messageVo.mid = xn3.a();
        RichMsgVo richMsgVo = new RichMsgVo();
        ReadState readState = new ReadState();
        richMsgVo.readState = readState;
        readState.fromUid = AccountUtils.p(AppContext.getContext());
        messageVo.extention = az2.c(richMsgVo);
        return messageVo;
    }

    public static MessageVo buildRedPacketMessage(String str, String str2, RedPacketVo redPacketVo, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(R.string.text_redpacket_content) + redPacketVo.remark;
        messageVo.mimeType = 16;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = redPacketVo.buildExtForSend();
        messageVo.data1 = String.valueOf(0);
        return messageVo;
    }

    public static MessageVo buildResendLinkMessage(String str, String str2, MessageVo messageVo, int i) {
        MessageVo messageVo2 = new MessageVo();
        messageVo2.mid = str;
        messageVo2.time = ir5.b();
        messageVo2.contactRelate = str2;
        messageVo2.from = AccountUtils.p(AppContext.getContext());
        messageVo2.to = str2;
        messageVo2.text = messageVo.text;
        messageVo2.mimeType = 28;
        messageVo2.isRead = true;
        messageVo2.isSend = true;
        messageVo2.status = 1;
        messageVo2.sendFlag = String.valueOf(i);
        messageVo2.attachStatus = 2;
        messageVo2.data1 = messageVo.data1;
        messageVo2.data2 = messageVo.data2;
        int iH = f33.f().h(messageVo.data3);
        if (iH == -1 || iH == -2) {
            messageVo2.data3 = String.valueOf(-1);
        }
        return messageVo2;
    }

    public static MessageVo buildSmallVideoNameCardMessage(String str, String str2, ContactInfoItem contactInfoItem, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getResources().getString(R.string.message_type_name_card);
        messageVo.mimeType = 9;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = nn0.f(contactInfoItem);
        messageVo.attachStatus = 2;
        messageVo.from = AccountUtils.p(AppContext.getContext());
        return messageVo;
    }

    public static MessageVo buildTextMessage(String str, String str2, String str3, String[] strArr, int i) {
        return buildTextMessage(str, str2, str3, strArr, i, ir5.b(), "");
    }

    public static MessageVo buildTransferMessage(String str, String str2, String str3, TransferVo transferVo, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str3;
        messageVo.to = str3;
        messageVo.text = AppContext.getContext().getString(R.string.lx_transfer_inner) + transferVo.remark;
        messageVo.mimeType = 17;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = transferVo.buildExtForSend();
        messageVo.data1 = transferVo.status + "";
        messageVo.data2 = transferVo.transferId + "";
        messageVo.data3 = str2;
        return messageVo;
    }

    public static MessageVo buildVideoMessage(String str, String str2, String str3, String str4, long j, int i) {
        return buildVideoMessage(str, str2, str3, str4, i, ir5.b(), j);
    }

    public static MessageVo buildVoucherRedPacketMessage(String str, String str2, VoucherRedPacketVo voucherRedPacketVo, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(R.string.text_voucher_redpacket_content) + voucherRedPacketVo.remark;
        messageVo.mimeType = 22;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = voucherRedPacketVo.buildExtForSend();
        messageVo.data1 = String.valueOf(0);
        return messageVo;
    }

    public static String getVideoThumbOnForwardMsg(MessageVo messageVo) {
        String str = messageVo.data2;
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(messageVo.data4)) {
            return str;
        }
        File fileB = sd1.b(messageVo.data4);
        if (fileB != null && o86.k(fileB.getPath())) {
            return fileB.getPath();
        }
        String strE = h.e(messageVo.data1);
        return strE != null ? strE : str;
    }

    public static String mergeJsonStrings(String... strArr) {
        if (strArr.length <= 1) {
            if (strArr.length == 1) {
                return strArr[0];
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    JSONObject jSONObject2 = new JSONObject(strArr[i]);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObject2.get(next));
                    }
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ChatItem parseChatItemFromNameCardString(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("roomInfo");
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("userInfo");
                return (jSONObjectOptJSONObject2 == null || TextUtils.isEmpty(jSONObjectOptJSONObject2.optString(DeviceInfoUtil.UID_TAG))) ? (jSONObjectOptJSONObject == null || TextUtils.isEmpty(jSONObjectOptJSONObject.optString("id"))) ? new ContactInfoItem() : GroupInfoItem.parseFromNameCardString(str) : nn0.e(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ChatPay getChatPayInfo() {
        RichMsgVo richMsgVo;
        if (TextUtils.isEmpty(this.extention) || (richMsgVo = (RichMsgVo) az2.a(this.extention, RichMsgVo.class)) == null) {
            return null;
        }
        return richMsgVo.pay;
    }

    public int getExTypeForSend() {
        int i = this.mimeType;
        if (i != 34 && i != 37) {
            return 0;
        }
        try {
            return Integer.parseInt(this.data1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getSubTypeForSend() {
        if (!fu5.t(this.bizType)) {
            return this.bizType;
        }
        if (fu5.q(this.bizType)) {
            return fu5.x(this.bizType, 0);
        }
        return 0;
    }

    public long get_id() {
        return this._id;
    }

    public boolean isNetworkError() {
        if (TextUtils.isEmpty(this.data9)) {
            return false;
        }
        return !Boolean.valueOf(this.data9).booleanValue();
    }

    public MessageVo setSendNetStatus(String str) {
        this.data9 = str;
        return this;
    }

    public MessageVo setThreadBizType(Context context, int i) {
        ContactInfoItem contactInfoItemL;
        this.bizType = i;
        if ((i == 13 || i == 14 || i == 17 || fu5.t(i)) && (contactInfoItemL = bo0.r().l(AccountUtils.p(context))) != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headIconUrl", contactInfoItemL.getIconURL());
                jSONObject.put("nickname", contactInfoItemL.getNickName());
                jSONObject.put(bd.h, contactInfoItemL.getExid());
                this.bizExtension = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void set_id(long j) {
        this._id = j;
    }

    @Override // com.zenmen.palmchat.Vo.BaseVo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isSend ? (byte) 1 : (byte) 0);
        parcel.writeString(this.nickName);
        parcel.writeInt(this.status);
        parcel.writeString(this.mid);
        parcel.writeLong(this._id);
        parcel.writeLong(this.versionId);
        parcel.writeInt(this.mimeType);
        parcel.writeLong(this.time);
        parcel.writeInt(this.attachStatus);
        parcel.writeInt(this.attachPlaying);
        parcel.writeByte(this.isRead ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.sendingProgress);
        parcel.writeString(this.extention);
        parcel.writeString(this.text);
        parcel.writeString(this.data1);
        parcel.writeString(this.data2);
        parcel.writeString(this.data3);
        parcel.writeString(this.data4);
        parcel.writeString(this.data5);
        parcel.writeString(this.data6);
        parcel.writeString(this.sendFlag);
        parcel.writeString(this.hdFlag);
        parcel.writeString(this.data9);
        parcel.writeString(this.contactRelate);
        parcel.writeString(this.to);
        parcel.writeString(this.from);
        parcel.writeInt(this.bizType);
        parcel.writeString(this.bizExtension);
        parcel.writeString(this.data10);
        parcel.writeString(this.logExtension);
    }

    public static MessageVo buildAudioMessage(AudioObject audioObject, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = audioObject.getMessageId();
        messageVo.time = j;
        messageVo.contactRelate = audioObject.getTarget();
        messageVo.to = audioObject.getTarget();
        messageVo.text = AppContext.getContext().getString(R.string.message_type_audio);
        messageVo.mimeType = 3;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.data1 = String.valueOf(audioObject.getDuration());
        messageVo.data2 = audioObject.getPath();
        messageVo.data4 = rb3.b(new File(audioObject.getPath()));
        return messageVo;
    }

    public static MessageVo buildExpressionMessage(String str, String str2, ExpressionObject expressionObject, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getResources().getString(R.string.string_message_type_expression);
        messageVo.mimeType = 14;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = "";
        messageVo.attachStatus = 2;
        messageVo.sendingProgress = 0;
        String str3 = expressionObject.tag;
        if (str3 == null || !(str3.startsWith("jsb") || expressionObject.tag.startsWith("dice"))) {
            String str4 = expressionObject.path;
            messageVo.data1 = str4;
            messageVo.data2 = expressionObject.thumbUrl;
            messageVo.data3 = expressionObject.url;
            messageVo.data4 = expressionObject.extension;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str4, options);
                boolean zR = xt.r(str4);
                if (options.outWidth != 0 && options.outHeight != 0) {
                    JSONObject jSONObject = new JSONObject();
                    or2 or2VarN = xt.n(options.outWidth, options.outHeight);
                    jSONObject.put("width", zR ? or2VarN.a() : or2VarN.b());
                    jSONObject.put("height", zR ? or2VarN.b() : or2VarN.a());
                    messageVo.data4 = jSONObject.toString();
                }
            } catch (Exception unused) {
            }
        } else {
            messageVo.data5 = pt1.a(expressionObject.tag);
        }
        return messageVo;
    }

    public static MessageVo buildFileMessage(String str, String str2, String str3, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getResources().getString(R.string.message_type_file);
        messageVo.mimeType = 6;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = "";
        messageVo.attachStatus = 2;
        messageVo.data1 = str3;
        File file = new File(str3);
        if (file.exists()) {
            messageVo.data3 = file.getName();
            messageVo.data4 = String.valueOf(file.length());
            messageVo.data5 = rb3.b(file);
        }
        messageVo.sendingProgress = 0;
        return messageVo;
    }

    public static MessageVo buildForwardLocationMessage(String str, String str2, String str3, String str4, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(R.string.message_type_location);
        messageVo.mimeType = 7;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.data1 = str3;
        messageVo.data2 = str4;
        messageVo.sendFlag = String.valueOf(i);
        return messageVo;
    }

    public static MessageVo buildImageMessage(String str, String str2, PhotoObject photoObject, boolean z, int i, long j, String str3) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(R.string.message_type_pic);
        messageVo.mimeType = 2;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.hdFlag = String.valueOf(z);
        String str4 = photoObject.path;
        messageVo.data1 = str4;
        messageVo.data2 = photoObject.thumbUrl;
        messageVo.data3 = photoObject.url;
        messageVo.data4 = photoObject.extension;
        messageVo.extention = "";
        messageVo.attachStatus = 2;
        messageVo.sendingProgress = 0;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str4, options);
            boolean zR = xt.r(str4);
            if (options.outWidth != 0 && options.outHeight != 0) {
                JSONObject jSONObject = new JSONObject();
                or2 or2VarN = xt.n(options.outWidth, options.outHeight);
                jSONObject.put("width", zR ? or2VarN.a() : or2VarN.b());
                jSONObject.put("height", zR ? or2VarN.b() : or2VarN.a());
                if (z) {
                    jSONObject.put("hdSize", new File(str4).length());
                }
                if (str3 != null) {
                    jSONObject.put(az.at, new JSONObject(str3));
                }
                messageVo.data4 = jSONObject.toString();
            }
        } catch (Exception unused) {
        }
        return messageVo;
    }

    public static MessageVo buildLocationMessage(String str, String str2, LocationEx locationEx, int i, long j, String str3) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(R.string.message_type_location);
        messageVo.mimeType = 7;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.data1 = g53.c(locationEx, str3);
        messageVo.data2 = locationEx.getStaticMapImageUrl();
        return messageVo;
    }

    public static MessageVo buildNameCardMessage(String str, String str2, ContactInfoItem contactInfoItem, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getResources().getString(R.string.message_type_name_card);
        messageVo.mimeType = 9;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = nn0.f(contactInfoItem);
        messageVo.attachStatus = 2;
        messageVo.from = AccountUtils.p(AppContext.getContext());
        if (m40.b(str2) == 1) {
            messageVo.from = str2 + "/" + AccountUtils.p(AppContext.getContext());
        } else {
            messageVo.from = AccountUtils.p(AppContext.getContext());
        }
        return messageVo;
    }

    public static MessageVo buildTextMessage(String str, String str2, String str3, String[] strArr, int i, String str4) {
        return buildTextMessage(str, str2, str3, strArr, i, ir5.b(), str4);
    }

    public static MessageVo buildVideoMessage(String str, String str2, String str3, String str4, int i, long j, long j2) {
        return buildVideoMessage(str, str2, str3, str4, null, i, j, j2);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MessageVo m791clone() {
        try {
            return (MessageVo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MessageVo buildTextMessage(String str, String str2, String str3, String[] strArr, int i, long j) {
        return buildTextMessage(str, str2, str3, strArr, i, j, "");
    }

    public static MessageVo buildVideoMessage(String str, String str2, String str3, String str4, String str5, int i, long j, long j2) {
        File file = new File(str3);
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getResources().getString(R.string.message_type_sight);
        messageVo.mimeType = 4;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = "";
        messageVo.data1 = str3;
        messageVo.data2 = str4;
        messageVo.data6 = String.valueOf(j2);
        messageVo.data10 = String.valueOf(file.length());
        messageVo.sendingProgress = -1;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (str4 != null && new File(str4).exists()) {
                BitmapFactory.decodeFile(str4, options);
                boolean zR = xt.r(str4);
                if (options.outWidth != 0 && options.outHeight != 0) {
                    JSONObject jSONObject = new JSONObject();
                    or2 or2VarN = xt.n(options.outWidth, options.outHeight);
                    jSONObject.put("width", zR ? or2VarN.a() : or2VarN.b());
                    jSONObject.put("height", zR ? or2VarN.b() : or2VarN.a());
                    messageVo.hdFlag = jSONObject.toString();
                }
            } else if (str5 != null) {
                messageVo.hdFlag = str5;
            }
        } catch (Exception unused) {
        }
        return messageVo;
    }

    public static MessageVo buildTextMessage(String str, String str2, String str3, String[] strArr, int i, long j, String str4) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = str3;
        messageVo.mimeType = 1;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 4;
        messageVo.sendFlag = String.valueOf(i);
        if (m40.b(str2) == 1 && strArr != null && strArr.length > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str5 : strArr) {
                    jSONArray.put(Long.valueOf(str5));
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("remindUids", jSONArray);
                String strValueOf = String.valueOf(11);
                String string = jSONObject.toString();
                messageVo.data1 = strValueOf;
                messageVo.data2 = string;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (str4 == null) {
            str4 = "";
        }
        messageVo.extention = str4;
        messageVo.attachStatus = 2;
        messageVo.from = AccountUtils.p(AppContext.getContext());
        return messageVo;
    }

    public static MessageVo buildNameCardMessage(String str, String str2, GroupInfoItem groupInfoItem, int i, long j) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getResources().getString(R.string.message_type_name_circle_card);
        messageVo.mimeType = 9;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.extention = nn0.g(groupInfoItem);
        messageVo.attachStatus = 2;
        messageVo.from = AccountUtils.p(AppContext.getContext());
        if (m40.b(str2) == 1) {
            messageVo.from = str2 + "/" + AccountUtils.p(AppContext.getContext());
        } else {
            messageVo.from = AccountUtils.p(AppContext.getContext());
        }
        return messageVo;
    }

    public static MessageVo buildImageMessage(String str, String str2, String str3, boolean z, int i, boolean z2, String str4) {
        return buildImageMessage(str, str2, str3, z, i, ir5.b(), z2, str4);
    }

    public void buildExtensionPartForSend() {
    }

    public void buildMediaPartForSend() {
    }

    public static MessageVo buildImageMessage(String str, String str2, String str3, boolean z, int i, long j, boolean z2, String str4) {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = str;
        messageVo.time = j;
        messageVo.contactRelate = str2;
        messageVo.to = str2;
        messageVo.text = AppContext.getContext().getString(R.string.message_type_pic);
        messageVo.mimeType = 2;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(i);
        messageVo.hdFlag = String.valueOf(z);
        messageVo.data1 = str3;
        messageVo.extention = "";
        messageVo.attachStatus = 2;
        messageVo.sendingProgress = 0;
        if (z2) {
            messageVo.data5 = String.valueOf(1);
            messageVo.text = str4;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str3, options);
            boolean zR = xt.r(str3);
            if (options.outWidth != 0 && options.outHeight != 0) {
                JSONObject jSONObject = new JSONObject();
                or2 or2VarN = xt.n(options.outWidth, options.outHeight);
                jSONObject.put("width", zR ? or2VarN.a() : or2VarN.b());
                jSONObject.put("height", zR ? or2VarN.b() : or2VarN.a());
                if (z) {
                    jSONObject.put("hdSize", new File(str3).length());
                }
                messageVo.data4 = jSONObject.toString();
            }
        } catch (Exception unused) {
        }
        return messageVo;
    }
}
