package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class zc3 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        LogUtil.d("TripNearByTag", "MapTripNearByCmdProcessor filter msg " + message);
        return message.getType() == 135 && fu5.o(message) == 0;
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        LogUtil.d("TripNearByTag", "MapTripNearByCmdProcessor process start msg " + message);
        ew1.U();
    }
}
