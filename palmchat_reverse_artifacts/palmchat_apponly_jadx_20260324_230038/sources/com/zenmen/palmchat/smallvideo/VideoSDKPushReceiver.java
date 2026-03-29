package com.zenmen.palmchat.smallvideo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.af6;
import defpackage.dm1;
import defpackage.ds0;
import defpackage.fu5;
import defpackage.fw5;
import defpackage.nx3;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VideoSDKPushReceiver {
    public static final String TAG = "VideoSDKPushReceiver";
    private static CopyOnWriteArrayList<String> mids = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class PushMsg {

        @Keep
        public int subType;

        @Keep
        public int type;

        public static PushMsg convert(MessageProto.Message message) {
            if (message == null) {
                return null;
            }
            PushMsg pushMsg = new PushMsg();
            pushMsg.type = message.getType();
            pushMsg.subType = fu5.o(message);
            return pushMsg;
        }

        public String toString() {
            return "PushMsg" + this.type + " " + this.subType;
        }
    }

    private static boolean hasProcessed(String str) {
        if (str != null) {
            if (mids.contains(str)) {
                return true;
            }
            mids.add(str);
        }
        return false;
    }

    public static boolean isVideoSDKPushMsg(int i) {
        return i == 120 || i == 121 || i == 122 || i == 123 || i == 124 || i == 125;
    }

    public static boolean notifySyncedMsg() {
        return dm1.d();
    }

    public static void onMsg(ArrayList<MessageProto.Message> arrayList) {
        if (arrayList.size() > 0) {
            MessageProto.Message message = null;
            MessageProto.Message message2 = null;
            MessageProto.Message message3 = null;
            for (MessageProto.Message message4 : arrayList) {
                if (message4.getType() == 120 || message4.getType() == 121) {
                    message = message4;
                } else if (message4.getType() == 123) {
                    message2 = message4;
                } else if (message4.getType() == 124 || message4.getType() == 125) {
                    message3 = message4;
                }
            }
            if (message != null) {
                onMsg(message, true);
            }
            if (message2 != null) {
                onMsg(message2, true);
            }
            if (message3 != null) {
                onMsg(message3, true);
            }
        }
    }

    private static void processMsg(MessageProto.Message message, boolean z) {
        if (message.getType() == 123) {
            nx3.f("key_new_small_video_new_dot", true);
            return;
        }
        if (message.getType() != 124) {
            message.getType();
            return;
        }
        if (fw5.b(message)) {
            if ((!z || notifySyncedMsg()) && af6.b()) {
                com.zenmen.palmchat.utils.a.E().v0(message);
            }
        }
    }

    private static boolean onMsg(MessageProto.Message message, boolean z) {
        boolean zIsVideoSDKPushMsg = isVideoSDKPushMsg(message.getType());
        if (zIsVideoSDKPushMsg && !hasProcessed(message.getMid())) {
            processMsg(message, z);
            PushMsg pushMsgConvert = PushMsg.convert(message);
            ds0.a().b(VideoPushEvent.produceEvent(pushMsgConvert));
            LogUtil.i(TAG, "onMsg" + pushMsgConvert);
        }
        return zIsVideoSDKPushMsg;
    }

    public static boolean onMsg(MessageProto.Message message) {
        return onMsg(message, false);
    }
}
