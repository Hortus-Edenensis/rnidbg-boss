package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f1152a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_account");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_account( _id INTEGER PRIMARY KEY,country_code TEXT, mobile TEXT, nick_name TEXT, session_id TEXT, refresh_key TEXT);";
    }
}
