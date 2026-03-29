package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f22186a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_download");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_download( _id INTEGER PRIMARY KEY,source_url TEXT ,state int default 0 ,progress int default 0 ,file_size LONG,file_path TEXT, file_name TEXT, identity int );";
    }
}
