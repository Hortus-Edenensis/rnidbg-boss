package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f20317a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_favorite_expression");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_favorite_expression( _id INTEGER PRIMARY KEY, type int default 0 , exp_index int default 0 , md5 TEXT, local_path TEXT, local_path_cover TEXT, package_name TEXT, description TEXT, data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT, data6 TEXT);";
    }
}
