package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class l30 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message != null && message.getType() == 66 && (message.getSubType() == 1 || message.getSubType() == 2 || message.getSubType() == 3);
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        if (message != null) {
            try {
                if (o30.s()) {
                    LogUtil.d("ChatMateGiftManagerTAG", "ChatMateCmdProcessor process ext " + message.getExtension());
                    if (message.getSubType() == 1) {
                        if (!TextUtils.isEmpty(message.getExtension())) {
                            o30.o(new JSONObject(message.getExtension()));
                        }
                    } else if (message.getSubType() == 2) {
                        if (!TextUtils.isEmpty(message.getExtension())) {
                            o30.A(new JSONObject(message.getExtension()));
                        }
                    } else if (message.getSubType() == 3 && !TextUtils.isEmpty(message.getExtension())) {
                        o30.f(new JSONObject(message.getExtension()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
