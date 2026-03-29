package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.groupvideochat.vo.RoomInfo;
import com.zenmen.palmchat.chat.groupvideochat.vo.UserInfo;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmd;
import com.zenmen.palmchat.chat.groupvideochat.vo.VoiceCmdExt;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.rtc.bean.VoipCmdMsg;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class qh6 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message.getType() == 110;
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    public final List<UserInfo> c(ArrayList<RoomUserInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            for (RoomUserInfo roomUserInfo : arrayList) {
                UserInfo userInfo = new UserInfo();
                userInfo.uid = roomUserInfo.uid;
                userInfo.icon = roomUserInfo.headImg;
                userInfo.status = roomUserInfo.status;
                arrayList2.add(userInfo);
            }
        }
        return arrayList2;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        try {
            g(message);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("RTC", "process", e);
        }
    }

    public final VoipCmdMsg f(MessageProto.Message message) {
        int exType = message.getExType();
        int subType = message.getSubType();
        VoipCmdMsg voipCmdMsg = null;
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(message.getExtension()).optJSONObject("voipCmd");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            VoipCmdMsg voipCmdMsg2 = (VoipCmdMsg) az2.a(jSONObjectOptJSONObject.toString(), VoipCmdMsg.class);
            if (voipCmdMsg2 != null) {
                try {
                    voipCmdMsg2.exType = exType;
                    voipCmdMsg2.subType = subType;
                    voipCmdMsg2.createTime = message.getCreateTime();
                    if ("0".equals(voipCmdMsg2.groupId)) {
                        voipCmdMsg2.groupId = null;
                    }
                } catch (Exception e) {
                    e = e;
                    voipCmdMsg = voipCmdMsg2;
                }
            }
            return voipCmdMsg2;
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return voipCmdMsg;
    }

    public final void g(MessageProto.Message message) {
        LogUtil.i("RTC", "process " + message);
        VoipCmdMsg voipCmdMsgF = f(message);
        if (voipCmdMsgF != null) {
            LxVoipManager.b().k(voipCmdMsgF);
            cx.c(voipCmdMsgF);
            if (voipCmdMsgF.subType == 7) {
                MessageVo messageVo = new MessageVo();
                messageVo.mimeType = 49;
                messageVo.mid = message.getMid();
                messageVo.time = ir5.b();
                String strT = DomainHelper.t(message.getFrom());
                messageVo.to = strT;
                int iM = b.m(message);
                messageVo.bizType = iM;
                messageVo.contactRelate = DomainHelper.c(DomainHelper.k(strT), iM);
                messageVo.text = message.getBody();
                messageVo.isRead = true;
                messageVo.isSend = true;
                messageVo.status = 2;
                messageVo.sendFlag = String.valueOf(0);
                messageVo.attachStatus = 2;
                messageVo.from = AccountUtils.p(AppContext.getContext());
                messageVo.data1 = voipCmdMsgF.groupId;
                VoiceCmdExt voiceCmdExt = new VoiceCmdExt();
                VoiceCmd voiceCmd = new VoiceCmd();
                voiceCmd.groupId = voipCmdMsgF.groupId;
                voiceCmd.msgType = voipCmdMsgF.roomStatus != 1 ? 1 : 0;
                voiceCmd.roomId = voipCmdMsgF.roomId;
                voiceCmd.roomToken = voipCmdMsgF.roomToken;
                RoomInfo roomInfo = new RoomInfo();
                roomInfo.userList = c(voipCmdMsgF.userList);
                voiceCmd.roomInfo = roomInfo;
                RoomUserInfo roomUserInfo = voipCmdMsgF.caller;
                if (roomUserInfo != null) {
                    voiceCmd.creatorId = roomUserInfo.uid;
                }
                voiceCmd.expire = 1000;
                voiceCmd.type = 1;
                voiceCmdExt.voiceCmd = voiceCmd;
                messageVo.extention = az2.c(voiceCmdExt);
                b.t(messageVo);
            }
        }
    }
}
