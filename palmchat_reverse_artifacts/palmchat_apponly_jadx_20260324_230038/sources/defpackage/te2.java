package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.GroupRedPacketVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class te2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends a41 {
        @Override // defpackage.ln2
        public boolean a(MessageProto.Message message) {
            return te2.b(message);
        }

        @Override // defpackage.a41, defpackage.ln2
        public void d(MessageProto.Message message) {
            te2.e(message);
        }
    }

    public static boolean b(MessageProto.Message message) {
        return message.getType() == 51 && fu5.o(message) == 2;
    }

    public static GroupRedPacketVo c(String str) {
        RichMsgVo richMsgVo;
        GroupRedPacketVo groupRedPacketVo;
        if (str != null) {
            String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, "key_group_redpacket_notice_item" + str, "");
            if (!TextUtils.isEmpty(strN) && (richMsgVo = (RichMsgVo) az2.a(strN, RichMsgVo.class)) != null && (groupRedPacketVo = richMsgVo.groupRedPacket) != null && str.equals(groupRedPacketVo.roomId)) {
                return richMsgVo.groupRedPacket;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        if (j > 0) {
            long jC = (j - ir5.c(true)) / 1000;
            if (jC > 0) {
                j3 = jC / 86400;
                j5 = (jC / 3600) - (24 * j3);
                j4 = (jC % 3600) / 60;
                j2 = jC % 60;
            } else {
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
            }
        }
        return j3 > 0 ? String.format("%d天 %02d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j2)) : String.format("%02d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j2));
    }

    public static void e(MessageProto.Message message) {
        f(message);
    }

    public static void f(MessageProto.Message message) {
        RichMsgVo richMsgVo;
        GroupRedPacketVo groupRedPacketVo;
        if (message == null || message.getExtension() == null || (richMsgVo = (RichMsgVo) az2.a(message.getExtension(), RichMsgVo.class)) == null || (groupRedPacketVo = richMsgVo.groupRedPacket) == null || TextUtils.isEmpty(groupRedPacketVo.roomId)) {
            return;
        }
        if (richMsgVo.groupRedPacket.display) {
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_group_redpacket_notice_item" + richMsgVo.groupRedPacket.roomId, message.getExtension());
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_group_redpacket_notice_item" + richMsgVo.groupRedPacket.roomId, "");
    }
}
