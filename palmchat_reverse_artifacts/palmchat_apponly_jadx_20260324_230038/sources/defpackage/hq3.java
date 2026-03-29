package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f18029a = Uri.parse("content://com.zenmen.palmchat.webplatform.provider/modules");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS modules (_id INTEGER PRIMARY KEY AUTOINCREMENT, web_name TEXT, web_id TEXT, version INTEGER, icon TEXT, package_info TEXT, uid TEXT, timestamp INTEGER, description TEXT, extra TEXT, type INTEGER DEFAULT 0)";
    }
}
