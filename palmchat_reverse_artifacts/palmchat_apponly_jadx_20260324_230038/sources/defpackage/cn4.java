package defpackage;

import android.content.ContentValues;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class cn4 extends o71 implements cs3 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message != null && 35 == message.getType() && fu5.o(message) == 0 && message.getExType() == 0;
    }

    @Override // defpackage.cs3
    public boolean c(ContentValues contentValues, MessageProto.Message message) {
        contentValues.put("msg_type", Integer.valueOf(message.getType()));
        contentValues.put("data1", Integer.valueOf(fu5.o(message)));
        contentValues.put("data2", Integer.valueOf(message.getExType()));
        contentValues.put("data3", "0");
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
        return true;
    }
}
