package defpackage;

import android.content.ContentValues;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class ip extends o71 implements cs3 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        if (message != null) {
            try {
                if (message.getType() != 10000) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (message != null && message.getSubType() == 1 && message.hasExtension() && !il5.l(message.getExtension())) {
            return new JSONObject(message.getExtension()).optInt("chatGuidance") == 1;
        }
        return false;
    }

    @Override // defpackage.cs3
    public boolean c(ContentValues contentValues, MessageProto.Message message) {
        contentValues.put("msg_type", Integer.valueOf(message.getType()));
        return true;
    }

    @Override // defpackage.o71, defpackage.ln2
    public void d(MessageProto.Message message) {
        super.d(message);
        hp.j(hp.d(message));
    }

    @Override // defpackage.o71, defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        super.e(arrayList);
        hp.k(hp.e(arrayList));
    }

    @Override // defpackage.o71
    public boolean h() {
        return false;
    }
}
