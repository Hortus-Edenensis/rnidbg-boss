package defpackage;

import android.content.ContentValues;
import com.zenmen.palmchat.chat.ChatBreakHelper;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class pu extends o71 implements cs3 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        if (message != null) {
            try {
                if (message.getType() != 1) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (message != null && message.hasExtension() && !il5.l(message.getExtension())) {
            int iOptInt = new JSONObject(message.getExtension()).optInt("noChat");
            return iOptInt == 1 || iOptInt == 2;
        }
        return false;
    }

    @Override // defpackage.cs3
    public boolean c(ContentValues contentValues, MessageProto.Message message) {
        contentValues.put("msg_type", (Integer) 1);
        contentValues.put("data1", Integer.valueOf(fu5.o(message)));
        contentValues.put("data2", message.getExtension());
        return true;
    }

    @Override // defpackage.o71, defpackage.ln2
    public void d(MessageProto.Message message) {
        super.d(message);
        ChatBreakHelper.u(ChatBreakHelper.k(message));
    }

    @Override // defpackage.o71, defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        super.e(arrayList);
        ChatBreakHelper.v(ChatBreakHelper.l(arrayList));
    }

    @Override // defpackage.o71
    public boolean h() {
        return false;
    }
}
