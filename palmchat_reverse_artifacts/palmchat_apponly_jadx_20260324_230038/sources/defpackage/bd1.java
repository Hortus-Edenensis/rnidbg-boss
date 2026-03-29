package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class bd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f1687a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_dialog_message");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_dialog_message( _id INTEGER PRIMARY KEY,version TEXT UNIQUE,page_index INTEGER, dest TEXT, expired INTEGER DEFAULT 0 , style INTEGER ,extention TEXT);";
    }
}
