package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ho0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f18003a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_contacts");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_contacts( _id INTEGER PRIMARY KEY,uid TEXT UNIQUE,nick_name TEXT ,remark_name TEXT ,signature TEXT ,birthday TEXT ,hobby TEXT ,age TEXT ,head_img_url TEXT ,big_head_img_url TEXT ,mobile TEXT ,email TEXT ,gender TEXT ,country TEXT ,province TEXT ,city TEXT ,act TEXT ,rank TEXT, first_pinyin TEXT, all_pinyin TEXT, remark_first_pinyin TEXT, remark_all_pinyin TEXT, source_type int default -1 ,chat_config int default 0 ,update_time TEXT ,remark_tel TEXT, description TEXT, data1 TEXT, data2 TEXT, account_type int default 0 ,data3 TEXT, data4 TEXT, data5 TEXT);";
    }
}
