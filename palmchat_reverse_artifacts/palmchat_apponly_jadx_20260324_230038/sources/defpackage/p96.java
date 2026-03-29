package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.venus.bean.VenusRoomShareCard;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class p96 extends o71 implements cs3 {
    public static VenusRoomShareCard i(String str) {
        RichMsgVo richMsgVo;
        if (TextUtils.isEmpty(str) || (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) == null) {
            return null;
        }
        return richMsgVo.venusShareRoom;
    }

    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message != null && message.getType() == 37 && message.getExType() == 1;
    }

    @Override // defpackage.cs3
    public boolean c(ContentValues contentValues, MessageProto.Message message) {
        contentValues.put("msg_type", Integer.valueOf(message.getType()));
        contentValues.put("data1", Integer.valueOf(message.getExType()));
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
