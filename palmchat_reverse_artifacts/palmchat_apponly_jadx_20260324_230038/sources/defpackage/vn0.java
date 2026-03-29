package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f21483a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_contact_requests");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_contact_requests( _id INTEGER PRIMARY KEY,mid TEXT ,from_uid TEXT ,from_nick_name TEXT ,from_signature TEXT ,from_head_img_url TEXT ,request_info TEXT ,user_info TEXT ,rid TEXT ,read_status LONG ,accept_status LONG ,request_type int default -1 ,identify_code TEXT ,source_type int default -1 ,send_time TEXT ,applyFriendTime TEXT ,blankTime TEXT ,expireTime TEXT ,operateTime TEXT ,deleteTime TEXT ,recommendTitle TEXT ,recommendText TEXT ,cycleTime TEXT ,commonFrds int default 0 ,applyTime LONG ,applyExpireSec LONG ,readTime LONG ,disShowTime LONG ,insert_date TEXT );";
    }
}
