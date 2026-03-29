package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class cp4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile cp4 f16895a;

    public static cp4 a() {
        if (f16895a == null) {
            synchronized (cp4.class) {
                if (f16895a == null) {
                    f16895a = new cp4();
                }
            }
        }
        return f16895a;
    }

    public void b(List<MessageProto.Message> list) {
        for (MessageProto.Message message : list) {
            int type = message.getType();
            if (type == 47 && (fu5.o(message) == 11 || fu5.o(message) == 12 || fu5.o(message) == 13 || fu5.o(message) == 41 || fu5.o(message) == 32)) {
                type = 45;
            }
            String extension = message.getExtension();
            LogUtil.d("PullWakeProcessor", "type = " + type + ",ext = " + extension);
            bp4.v(type, fu5.o(message), extension);
        }
    }
}
