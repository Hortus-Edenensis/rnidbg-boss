package defpackage;

import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class jt4 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message.getType() == 15000 && (message.getSubType() == 1 || message.getSubType() == 2);
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        try {
            if (message.getSubType() == 1) {
                lt4.d().i(message);
            } else if (message.getSubType() == 2) {
                yk6.k().s(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
