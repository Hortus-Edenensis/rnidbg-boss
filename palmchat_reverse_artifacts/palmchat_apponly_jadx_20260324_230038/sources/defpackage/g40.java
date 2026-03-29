package defpackage;

import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class g40 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message != null && message.getType() == 70;
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        hb3.g().m(message);
    }
}
