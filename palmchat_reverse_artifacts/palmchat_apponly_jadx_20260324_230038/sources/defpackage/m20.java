package defpackage;

import android.content.ContentValues;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class m20 extends o71 implements cs3 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message != null && 35 == message.getType() && 1 == fu5.o(message) && (1 == message.getExType() || 2 == message.getExType() || 3 == message.getExType());
    }

    @Override // defpackage.cs3
    public boolean c(ContentValues contentValues, MessageProto.Message message) {
        List<String> list = ChatGiftConfig.getChatGiftConfig().gift_thxtext;
        String str = (list == null || list.isEmpty()) ? "" : list.get(new Random().nextInt(list.size()));
        contentValues.put("msg_type", Integer.valueOf(message.getType()));
        contentValues.put("data1", Integer.valueOf(fu5.o(message)));
        contentValues.put("data2", Integer.valueOf(message.getExType()));
        contentValues.put("data3", str);
        return true;
    }

    @Override // defpackage.o71, defpackage.ln2
    public void d(MessageProto.Message message) {
        super.d(message);
        o30.D(message);
    }

    @Override // defpackage.o71, defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        super.e(arrayList);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            o30.D(arrayList.get(i));
        }
    }

    @Override // defpackage.o71
    public boolean h() {
        return true;
    }
}
