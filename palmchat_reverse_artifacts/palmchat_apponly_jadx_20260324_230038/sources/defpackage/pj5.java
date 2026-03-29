package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.support.SquareSingleton;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class pj5 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        LogUtil.d("SquarePushProcessor", "get push msg " + message.getType() + " " + message.getExtension());
        return message.getType() == 132 || message.getType() == 103 || message.getType() == 134;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        LogUtil.d("SquarePushProcessor", "get square push " + message.getType() + " " + message.getExtension());
        if (message.getType() == 103) {
            if (fu5.o(message) == 10 || fu5.o(message) == 11) {
                mb4.m(message);
                return;
            }
            return;
        }
        if (message.getType() == 132) {
            int iO = fu5.o(message);
            if (iO == 2) {
                SquareSingleton.getInstance().reloadLookMeCount();
                return;
            }
            if (iO == 3 || iO == 5) {
                q42.e(vm0.f1);
                return;
            }
            if (iO == 4) {
                d20.m(true);
                return;
            }
            if (iO == 1) {
                SquareSingleton.getInstance().reloadPraiseCount();
                return;
            }
            if (iO == 6) {
                SquareSingleton.getInstance().setFriendFeedsRedDot(true);
            } else if (iO == 7) {
                q05.w("KEY_NEED_SHOW_SQUARE_INTERACT_DOT", Boolean.TRUE);
                ch.s().r().i(new wi5());
            }
        }
    }
}
