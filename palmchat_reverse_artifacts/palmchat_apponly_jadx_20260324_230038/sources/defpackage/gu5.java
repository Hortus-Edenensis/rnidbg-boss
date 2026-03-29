package defpackage;

import com.zenmen.palmchat.chat.ThreadChatItem;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gu5 extends bx5 {
    public ArrayList<ThreadChatItem> b;

    public boolean a(ArrayList<ThreadChatItem> arrayList) {
        ArrayList<ThreadChatItem> arrayList2 = this.b;
        if (arrayList2 == null || arrayList == null || arrayList2.size() != arrayList.size()) {
            return true;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ThreadChatItem threadChatItem = this.b.get(i);
            ThreadChatItem threadChatItem2 = arrayList.get(i);
            if (threadChatItem != null && !threadChatItem.equal(threadChatItem2)) {
                return true;
            }
        }
        return false;
    }
}
