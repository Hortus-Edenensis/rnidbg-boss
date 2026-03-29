package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f18824a = Uri.parse("content://com.zenmen.palmchat.network.dnscache.provider/tb_dns_cache");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_dns_cache(_id INTEGER PRIMARY KEY, domain TEXT, ip_list TEXT, timestamp INTEGER, area TEXT);";
    }
}
