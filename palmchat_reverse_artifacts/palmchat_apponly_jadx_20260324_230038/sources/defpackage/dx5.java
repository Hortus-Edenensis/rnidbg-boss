package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dx5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f17178a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_threads");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_threads( _id INTEGER PRIMARY KEY,icon_url TEXT ,title TEXT ,latest_message TEXT ,latest_message_mime_type int default 1,latest_message_time_stamp INTEGER ,contact_relate TEXT , user_flag TEXT ,chat_type int default 0 ,unread_message_count INTEGER,thread_background TEXT ,thread_nodisturb int default 0 ,thread_blacklist int default 0 ,thread_focus int default 0 ,thread_active int default 0 ,thread_draft TEXT ,thread_message_mid TEXT ,thread_message_status int default 0 ,thread_latest_unread_message_time int default 0 ,thread_latest_unread_message_primary_key_id int default 0 ,thread_priority int default 0, thread_has_remind int default 0, thread_draft_remind_uids TEXT, latest_message_read INTEGER default 1, thread_show_members_nick_name int default 0, thread_draft_time int default 0,thread_contact_ready int default 1, thread_biz_type int default 0, thread_biz_extension TEXT, is_super_greetings int default 0, super_greetings_time_stamp INTEGER, pin_gift_message int default 0, pin_gift_message_last_time_stamp INTEGER, has_unread_gift_message int default 0);";
    }
}
