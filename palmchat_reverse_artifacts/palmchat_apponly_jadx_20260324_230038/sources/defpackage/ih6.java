package defpackage;

import com.zenmen.palmchat.Vo.AudioMatchCmdVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class ih6 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message.getType() == 64;
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        AudioMatchCmdVo audioMatchCmdVo;
        RoomSDKInfo roomSDKInfoC;
        String str;
        try {
            RichMsgVo richMsgVo = (RichMsgVo) az2.a(message.getExtension(), RichMsgVo.class);
            boolean z = false;
            if (richMsgVo != null) {
                audioMatchCmdVo = richMsgVo.audioMatchingCmd;
                if (audioMatchCmdVo != null && (roomSDKInfoC = LxVoipManager.b().c()) != null && (str = roomSDKInfoC.roomId) != null && str.equals(audioMatchCmdVo.roomId)) {
                    z = true;
                }
            } else {
                audioMatchCmdVo = null;
            }
            if (message.getSubType() == 1) {
                if (LxVoipManager.b().g()) {
                    return;
                }
                lh6.V().m0(audioMatchCmdVo);
                return;
            }
            if (message.getSubType() == 2) {
                lh6.V().I0(audioMatchCmdVo);
                return;
            }
            if (message.getSubType() == 3) {
                if (z) {
                    lh6.V().o0(audioMatchCmdVo.isTimeoutOpenID, message.getBody());
                    return;
                }
                return;
            }
            if (message.getSubType() == 4) {
                if (z) {
                    lh6.V().p0();
                    return;
                }
                return;
            }
            if (message.getSubType() == 5) {
                if (z) {
                    lh6.V().t0(message.getBody());
                    return;
                }
                return;
            }
            if (message.getSubType() == 6) {
                if (z) {
                    lh6.V().r0();
                }
            } else if (message.getSubType() == 7) {
                if (z) {
                    lh6.V().s0();
                }
            } else if (message.getSubType() == 9) {
                lh6.V().q0(audioMatchCmdVo);
            } else if (message.getSubType() == 8) {
                lh6.V().K0();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
