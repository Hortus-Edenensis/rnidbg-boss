package defpackage;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.chat.fragment.SimpleChatFragment;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class g20 extends AsyncQueryHandler {
    public static final String c = "g20";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleChatFragment f17637a;
    public final Set<String> b;

    public g20(SimpleChatFragment simpleChatFragment, ContentResolver contentResolver) {
        super(contentResolver);
        this.b = new HashSet();
        this.f17637a = simpleChatFragment;
    }

    public void a(int i, String str, Set<String> set) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_message_count", (Integer) 0);
        contentValues.put("thread_latest_unread_message_time", (Integer) 0);
        contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
        contentValues.put("thread_has_remind", (Integer) 0);
        contentValues.put("is_super_greetings", (Integer) 0);
        contentValues.put("has_unread_gift_message", (Integer) 0);
        CircleNoticeItem.circleThreadHasNoticeStatus(this.f17637a.L0().getChatId(), 0);
        VoucherRedPacketVo.circleThreadHasVoucherStatus(this.f17637a.L0().getChatId(), 0);
        contentValues.put("thread_focus", Integer.valueOf(i));
        boolean zC = c(str);
        contentValues.put("thread_draft", zC ? str : "");
        if (zC) {
            contentValues.put("thread_active", (Integer) 1);
            if (str != this.f17637a.K0() && !str.equals(this.f17637a.K0())) {
                contentValues.put("thread_draft_time", Long.valueOf(ir5.b()));
            }
        } else {
            contentValues.put("thread_draft_time", (Integer) 0);
        }
        if (set != null && !set.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            contentValues.put("thread_draft_remind_uids", jSONArray.toString());
        }
        startUpdate(4, null, dx5.f17178a, contentValues, "contact_relate=?", new String[]{DomainHelper.l(this.f17637a.L0())});
    }

    public void b() {
        startQuery(1, null, dx5.f17178a, null, "contact_relate=?", new String[]{DomainHelper.l(this.f17637a.L0())}, null);
    }

    public final boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_relate", DomainHelper.l(this.f17637a.L0()));
        contentValues.put("unread_message_count", (Integer) 0);
        contentValues.put("thread_latest_unread_message_time", (Integer) 0);
        contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
        contentValues.put("thread_focus", (Integer) 1);
        contentValues.put("thread_active", (Integer) 0);
        contentValues.put("thread_biz_type", Integer.valueOf(this.f17637a.c1()));
        contentValues.put("chat_type", Integer.valueOf(this.f17637a.L0().getChatType()));
        contentValues.put("icon_url", this.f17637a.L0().getIconURL());
        contentValues.put("title", this.f17637a.L0().getChatName());
        contentValues.put("thread_contact_ready", Boolean.TRUE);
        contentValues.put("thread_priority", Integer.valueOf(jw5.j(this.f17637a.L0().getSessionConfig()) ? 100 : 0));
        contentValues.put("thread_nodisturb", Boolean.valueOf(jw5.g(this.f17637a.L0().getSessionConfig())));
        contentValues.put("thread_blacklist", Boolean.valueOf(jw5.e(this.f17637a.L0().getSessionConfig())));
        contentValues.put("thread_action_type", "ACTION_TYPE_REQUEST_FOCUS");
        startInsert(7, null, dx5.f17178a, contentValues);
    }

    public void e() {
        startQuery(15, null, DBUriManager.b(ho3.class, this.f17637a.L0()), null, "contact_relate=? and type=? and read=? and msg_type=? and data1=? and data2=?", new String[]{DomainHelper.l(this.f17637a.L0()), String.valueOf(1), String.valueOf(0), String.valueOf(35), String.valueOf(1), String.valueOf(1)}, "_id ASC");
    }

    public final void f() {
        String[] strArr = {DomainHelper.l(this.f17637a.L0()), String.valueOf(1), String.valueOf(0), String.valueOf(35), String.valueOf(1), String.valueOf(1)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("read", (Integer) 1);
        startUpdate(16, null, DBUriManager.b(ho3.class, this.f17637a.L0()), contentValues, "contact_relate=? and type=? and read=? and msg_type=? and data1=? and data2=?", strArr);
    }

    public void g() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("thread_focus", (Integer) 0);
        startUpdate(6, null, dx5.f17178a, contentValues, null, null);
    }

    public final void h() {
        String[] strArr = {DomainHelper.l(this.f17637a.L0())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_message_count", (Integer) 0);
        contentValues.put("thread_latest_unread_message_time", (Integer) 0);
        contentValues.put("thread_latest_unread_message_primary_key_id", (Integer) 0);
        contentValues.put("thread_has_remind", (Integer) 0);
        CircleNoticeItem.circleThreadHasNoticeStatus(this.f17637a.L0().getChatId(), 0);
        VoucherRedPacketVo.circleThreadHasVoucherStatus(this.f17637a.L0().getChatId(), 0);
        startUpdate(5, null, dx5.f17178a, contentValues, "contact_relate=?", strArr);
    }

    @Override // android.content.AsyncQueryHandler
    public void onDeleteComplete(int i, Object obj, int i2) {
        super.onDeleteComplete(i, obj, i2);
    }

    @Override // android.content.AsyncQueryHandler
    public void onInsertComplete(int i, Object obj, Uri uri) {
        super.onInsertComplete(i, obj, uri);
        LogUtil.i(c, "onInsertComplete" + i);
    }

    @Override // android.content.AsyncQueryHandler
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        ChatGiftMessageExtensionBean chatGiftMessageExtensionBeanQ;
        super.onQueryComplete(i, obj, cursor);
        LogUtil.i(c, "onQueryComplete" + i);
        if (i == 0) {
            return;
        }
        if (i == 1) {
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    a(1, this.f17637a.K0(), null);
                } else {
                    d();
                }
                return;
            }
            return;
        }
        boolean z = false;
        if (i == 2) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        if (cursor.getInt(cursor.getColumnIndex("unread_message_count")) > 0) {
                            z = true;
                        }
                    } finally {
                        cursor.close();
                    }
                }
            }
            if (z) {
                h();
                return;
            }
            return;
        }
        if (i == 8 || i == 10 || i == 9 || i != 15 || cursor == null) {
            return;
        }
        if (cursor.getCount() > 0) {
            f();
        }
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("msg_extend"));
            String string2 = cursor.getString(cursor.getColumnIndex("packet_id"));
            if (TextUtils.isEmpty(string2) || !this.b.contains(string2)) {
                if (!TextUtils.isEmpty(string) && (chatGiftMessageExtensionBeanQ = GiftMessageHelper.Q(string)) != null) {
                    this.b.add(string2);
                    ds0.a().b(new fb2(chatGiftMessageExtensionBeanQ, false));
                }
            }
        }
    }

    @Override // android.content.AsyncQueryHandler
    public void onUpdateComplete(int i, Object obj, int i2) {
        super.onUpdateComplete(i, obj, i2);
        LogUtil.i(c, "onUpdateComplete" + i + " result " + i2);
    }
}
