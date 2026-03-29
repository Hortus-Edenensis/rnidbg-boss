package defpackage;

import android.database.Cursor;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.groupchat.GroupInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ze2 {
    public static GroupInfoItem a(String str, int i) {
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ye2.class, i), null, "group_id=?", new String[]{str}, null);
        if (cursorQuery != null) {
            itemFromCursor = cursorQuery.moveToNext() ? GroupInfoItem.getItemFromCursor(cursorQuery, i) : null;
            cursorQuery.close();
        }
        return itemFromCursor;
    }

    public static int b(ChatItem chatItem) {
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.b(ye2.class, chatItem), null, "group_id=?", new String[]{chatItem.getChatId()}, null);
        if (cursorQuery != null) {
            i = cursorQuery.moveToNext() ? cursorQuery.getInt(cursorQuery.getColumnIndex("group_member_count")) : 0;
            cursorQuery.close();
        }
        return i;
    }
}
