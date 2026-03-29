package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class je2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f18392a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_group_members");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_group_members( _id INTEGER PRIMARY KEY,group_id TEXT ,name TEXT ,nick_name TEXT ,display_name TEXT ,head_icon_url TEXT ,is_owner INTEGER ,group_member_state INTEGER ,nick_name_all_pinyin TEXT ,nick_name_first_pinyin TEXT ,remark_name TEXT ,remark_name_all_pinyin TEXT ,remark_name_first_pinyin TEXT ,extra_data1 TEXT ,extra_data2 TEXT ,extra_json TEXT ,extra_data3 TEXT);";
    }
}
