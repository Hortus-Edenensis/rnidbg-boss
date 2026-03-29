package defpackage;

import android.content.ContentValues;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class s8 extends o71 implements cs3 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        boolean z = message != null && message.getType() == 65;
        if (z) {
            LogUtil.d("AiChatPeopleManagerTag", "AiChatGuardMsgReceiver filter result true");
        }
        return z;
    }

    @Override // defpackage.cs3
    public boolean c(ContentValues contentValues, MessageProto.Message message) {
        contentValues.put("msg_type", Integer.valueOf(message.getType()));
        return true;
    }

    @Override // defpackage.o71, defpackage.ln2
    public void d(MessageProto.Message message) {
        super.d(message);
    }

    @Override // defpackage.o71, defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        super.e(arrayList);
    }

    @Override // defpackage.o71
    public boolean h() {
        return false;
    }
}
