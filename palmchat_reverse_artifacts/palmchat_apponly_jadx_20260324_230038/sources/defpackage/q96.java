package defpackage;

import com.zenmen.palmchat.Vo.MessageVo;
import defpackage.kn2;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class q96 extends u0 {
    @Override // defpackage.zi0
    public boolean a(MessageVo messageVo) {
        return false;
    }

    @Override // defpackage.mn2
    public boolean c(MessageVo messageVo) {
        return messageVo.mimeType == 37 && messageVo.getExTypeForSend() == 1;
    }

    @Override // defpackage.zi0
    public kn2 d(MessageVo messageVo, kn2.a aVar) {
        return null;
    }

    @Override // defpackage.u0
    public MessageProto.Message i(MessageVo messageVo) {
        return super.i(messageVo);
    }
}
