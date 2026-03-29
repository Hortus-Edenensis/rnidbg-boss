package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f18030a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_synckey");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_synckey( _id INTEGER PRIMARY KEY,resource_type TEXT UNIQUE,resource_version long );";
    }
}
