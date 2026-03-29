package defpackage;

import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class a41 implements wk2 {
    @Override // defpackage.wk2
    public boolean b() {
        return true;
    }

    @Override // defpackage.ln2
    public void d(MessageProto.Message message) {
        throw null;
    }

    @Override // defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        if (arrayList.size() > 0) {
            Iterator<MessageProto.Message> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }
}
