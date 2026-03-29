package defpackage;

import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class rd0 extends o71 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return vi0.d().b(message);
    }

    @Override // defpackage.o71, defpackage.ln2
    public void d(MessageProto.Message message) {
        super.d(message);
        vi0.d().e(message);
    }

    @Override // defpackage.o71, defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        super.e(arrayList);
        vi0.d().f(arrayList);
    }

    @Override // defpackage.o71
    public boolean h() {
        return false;
    }
}
