package defpackage;

import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.palmchat.AppContext;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class t84 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements wk2 {
        @Override // defpackage.ln2
        public boolean a(MessageProto.Message message) {
            return t84.a(message);
        }

        @Override // defpackage.wk2
        public boolean b() {
            return false;
        }

        @Override // defpackage.ln2
        public void d(MessageProto.Message message) {
            t84.b(message);
        }

        @Override // defpackage.ln2
        public void e(ArrayList<MessageProto.Message> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            t84.b(arrayList.get(arrayList.size() - 1));
        }
    }

    public static boolean a(MessageProto.Message message) {
        return message.getType() == 300 && fu5.o(message) == 1;
    }

    public static void b(MessageProto.Message message) {
        if (message == null || TextUtils.isEmpty(message.getExtension()) || !fw5.b(message)) {
            return;
        }
        xa3.b("receive", message.getExtension(), "self");
        Intent intent = new Intent();
        intent.setAction(mo3.d);
        intent.putExtra("key_packet_extension", message.getExtension());
        intent.putExtra("key_mid", message.getMid());
        intent.putExtra("key_mimetype", message.getType());
        intent.putExtra("key_subtype", fu5.o(message));
        intent.putExtra("key_from", message.getFrom());
        intent.putExtra("key_body", message.getBody());
        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
    }
}
