package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.IntimacyVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyChatTextGuideVo;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyFreeGiftVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.b;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hu2 {
    public static void a(MessageProto.Message message) {
        RichMsgVo richMsgVo;
        IntimacyVo intimacyVo;
        if (gu2.f() || message.getSubType() > 2) {
            IntimacyVo intimacyVo2 = null;
            if (TextUtils.isEmpty(message.getExtension())) {
                richMsgVo = null;
                intimacyVo = null;
            } else {
                richMsgVo = (RichMsgVo) az2.a(message.getExtension(), RichMsgVo.class);
                if (richMsgVo != null) {
                    intimacyVo2 = richMsgVo.intimate;
                    intimacyVo = richMsgVo.unFriendGift;
                } else {
                    intimacyVo = null;
                }
            }
            if (intimacyVo2 == null && intimacyVo == null) {
                return;
            }
            if (message.getSubType() == eu2.f17362a) {
                ju2.g(intimacyVo2.fuid, intimacyVo2.value, true);
                return;
            }
            if (message.getSubType() == eu2.b) {
                String body = message.getBody();
                int i = intimacyVo2.type;
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(intimacyVo2.fuid);
                if (a65.c(contactInfoItem)) {
                    return;
                }
                MessageVo messageVoG = u0.g(contactInfoItem);
                messageVoG.status = 2;
                messageVoG.mimeType = 200005;
                IntimacyChatTextGuideVo guideVo = IntimacyChatTextGuideVo.getGuideVo(i, body);
                messageVoG.text = body;
                if (richMsgVo != null) {
                    guideVo.actionBody = richMsgVo.actionBody;
                    guideVo.actionTypes = richMsgVo.actionTypes;
                }
                messageVoG.extention = az2.c(guideVo);
                b.t(messageVoG);
                return;
            }
            if (message.getSubType() == eu2.c) {
                ContactInfoItem contactInfoItem2 = new ContactInfoItem();
                contactInfoItem2.setUid(intimacyVo2.fuid);
                if (a65.c(contactInfoItem2)) {
                    return;
                }
                String body2 = message.getBody();
                IntimacyFreeGiftVo intimacyFreeGiftVo = new IntimacyFreeGiftVo();
                intimacyFreeGiftVo.text = body2;
                intimacyFreeGiftVo.giftVo = intimacyVo2.convert2QuickSendVo();
                MessageVo messageVoG2 = u0.g(contactInfoItem2);
                messageVoG2.status = 2;
                messageVoG2.mimeType = 200006;
                messageVoG2.text = body2;
                messageVoG2.extention = az2.c(intimacyFreeGiftVo);
                b.t(messageVoG2);
                return;
            }
            if (message.getSubType() == eu2.d) {
                ContactInfoItem contactInfoItem3 = new ContactInfoItem();
                contactInfoItem3.setUid(intimacyVo.fuid);
                String body3 = message.getBody();
                IntimacyFreeGiftVo intimacyFreeGiftVo2 = new IntimacyFreeGiftVo();
                intimacyFreeGiftVo2.text = body3;
                intimacyFreeGiftVo2.giftVo = intimacyVo.convert2QuickSendVo();
                intimacyFreeGiftVo2.giftLabel = intimacyVo.giftLabel;
                intimacyFreeGiftVo2.type = 1;
                MessageVo messageVoG3 = u0.g(contactInfoItem3);
                messageVoG3.status = 2;
                messageVoG3.mimeType = 200006;
                messageVoG3.text = body3;
                messageVoG3.extention = az2.c(intimacyFreeGiftVo2);
                messageVoG3.data1 = message.getMid();
                b.t(messageVoG3);
            }
        }
    }
}
