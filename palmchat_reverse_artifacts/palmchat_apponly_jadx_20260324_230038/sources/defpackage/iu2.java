package defpackage;

import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.fu2;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class iu2 {
    public static void a(ChatItem chatItem, fu2.b bVar) {
        HashMap map = new HashMap();
        if (chatItem != null && bVar != null) {
            map.put("resultcode", Integer.valueOf(bVar.f17599a ? bVar.b ? 3 : 2 : 1));
            map.put("type", Integer.valueOf(bVar.d));
            map.put("target_uid", chatItem.getChatId());
        }
        zn6.j("intimacy_pageclick", "click", map);
    }

    public static void b(boolean z, ContactInfoItem contactInfoItem) {
        HashMap map = new HashMap();
        if (contactInfoItem != null) {
            map.put("intimacy_value", Float.valueOf(contactInfoItem.getIntimacyScore()));
            map.put("friend_type", Integer.valueOf(contactInfoItem.getIsStranger() ? 2 : 1));
            map.put("target_uid", contactInfoItem.getUid());
        }
        zn6.j("chatwindow_intimacy", z ? "click" : "view", map);
    }
}
