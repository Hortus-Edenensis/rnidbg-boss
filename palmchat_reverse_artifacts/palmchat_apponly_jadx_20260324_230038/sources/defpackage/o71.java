package defpackage;

import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.palmchat.AppContext;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public abstract class o71 implements ln2 {
    @Override // defpackage.ln2
    public void d(MessageProto.Message message) {
        f(message);
    }

    public void f(MessageProto.Message message) {
        if (h()) {
            g(message);
        }
    }

    public void g(MessageProto.Message message) {
        Intent intent = new Intent();
        intent.setAction(mo3.d);
        intent.putExtra("key_packet_extension", message.getExtension());
        intent.putExtra("key_mid", message.getMid());
        intent.putExtra("key_mimetype", message.getType());
        intent.putExtra("key_subtype", fu5.o(message));
        intent.putExtra("key_from", message.getFrom());
        intent.putExtra("key_body", message.getBody());
        if (message.getType() == 10001) {
            String strA = wn3.a(message);
            if (!TextUtils.isEmpty(strA)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(strA);
                intent.putExtra("key_message_recall_list", arrayList);
            }
        }
        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
        a65.g(message, "socket");
    }

    public abstract boolean h();

    @Override // defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
    }
}
