package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class nw5 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends jk2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zh.a f19632a;

        public a(zh.a aVar) {
            this.f19632a = aVar;
        }

        @Override // defpackage.jk2
        public void c(int i, Cursor cursor) {
            super.c(i, cursor);
            if (i == 100) {
                ThreadChatItem cursor2 = null;
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                cursor2 = ThreadChatItem.parseCursor(cursor);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } finally {
                        cursor.close();
                    }
                }
                this.f19632a.a(cursor2);
            }
        }
    }

    public static void a(ChatItem chatItem, int i) {
        long j;
        long jQ;
        Cursor cursorQuery;
        String chatId = chatItem.getChatId();
        String[] strArr = {DomainHelper.l(chatItem)};
        if (i != 1 || (cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, "contact_relate=?", strArr, null)) == null) {
            j = 0;
            jQ = 0;
        } else {
            try {
                if (cursorQuery.moveToNext()) {
                    j = cursorQuery.getLong(cursorQuery.getColumnIndex("latest_message_time_stamp"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("thread_message_mid"));
                    jQ = !TextUtils.isEmpty(string) ? b.q(string, chatItem) : 0L;
                } else {
                    j = 0;
                    jQ = 0;
                }
            } finally {
                cursorQuery.close();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_message_count", Integer.valueOf(i));
        if (i == 0) {
            contentValues.put("thread_has_remind", (Integer) 0);
            contentValues.put("is_super_greetings", (Integer) 0);
            contentValues.put("has_unread_gift_message", (Integer) 0);
            CircleNoticeItem.circleThreadHasNoticeStatus(chatId, 0);
            VoucherRedPacketVo.circleThreadHasVoucherStatus(chatId, 0);
        }
        if (i <= 0) {
            j = 0;
        }
        contentValues.put("thread_latest_unread_message_time", Long.valueOf(j));
        contentValues.put("thread_latest_unread_message_primary_key_id", Long.valueOf(i > 0 ? jQ : 0L));
        AppContext.getContext().getContentResolver().update(dx5.f17178a, contentValues, "contact_relate=?", strArr);
        if (i == 0) {
            f46.l(ch.s().u(), chatItem);
        }
    }

    public static void b() {
        AppContext.getContext().getContentResolver().delete(dx5.f17178a, null, null);
    }

    public static void c(int i) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("thread_active");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("thread_blacklist");
        sb.append("=? and ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_contact_ready");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        ThreadFolderManager.b(sb, arrayList, i, true);
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null);
        ArrayList arrayList2 = new ArrayList();
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("contact_relate"));
                if (!TextUtils.isEmpty(string)) {
                    arrayList2.add(string);
                }
            }
            cursorQuery.close();
            if (arrayList2.size() > 0) {
                b.l(arrayList2, i);
            }
        }
        AppContext.getContext().getContentResolver().delete(dx5.f17178a, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public static void d(String str) {
        AppContext.getContext().getContentResolver().delete(dx5.f17178a, "contact_relate=? ", new String[]{str});
    }

    public static List<String> e() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("contact_relate"));
                LogUtil.d("", "getAllThreadDbUids uid " + string);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                }
            }
            cursorQuery.close();
        }
        return arrayList;
    }

    public static ThreadChatItem f(String str) {
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, "contact_relate=?", new String[]{str}, null);
        ThreadChatItem cursor = null;
        if (cursorQuery != null) {
            try {
                try {
                    if (cursorQuery.moveToNext()) {
                        cursor = ThreadChatItem.parseCursor(cursorQuery);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                cursorQuery.close();
            }
        }
        return cursor;
    }

    public static void g(String str, zh.a<ThreadChatItem> aVar) {
        zh.k(AppContext.getContext().getContentResolver()).i(100, new a(aVar), dx5.f17178a, null, "contact_relate=?", new String[]{str}, null);
    }

    public static boolean h(String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("thread_active=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("thread_contact_ready=? and (");
        arrayList.add(String.valueOf(1));
        sb.append("contact_relate=? ");
        arrayList.add(str);
        fu5.c(sb, arrayList, str);
        sb.append(")");
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, sb.toString(), (String[]) arrayList.toArray(new String[0]), null);
        if (cursorQuery == null) {
            return false;
        }
        boolean z = cursorQuery.getCount() > 0;
        cursorQuery.close();
        return z;
    }

    public static void i() {
        try {
            String[] strArr = {String.valueOf(1)};
            ContentValues contentValues = new ContentValues();
            contentValues.put("thread_focus", (Integer) 0);
            AppContext.getContext().getContentResolver().update(dx5.f17178a, contentValues, "thread_focus=?", strArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
