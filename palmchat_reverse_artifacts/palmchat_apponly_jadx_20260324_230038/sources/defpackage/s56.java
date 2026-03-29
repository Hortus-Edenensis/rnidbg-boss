package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s56 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f20670a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_uploaded_contact");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_uploaded_contact( _id INTEGER PRIMARY KEY, phone_number TEXT, number_md5 TEXT, phone_label TEXT, phone_id TEXT, display_name TEXT, given_name TEXT, family_name TEXT, prefix TEXT, middle_name TEXT, suffix TEXT, email TEXT, company TEXT, title TEXT, note TEXT, address TEXT, event TEXT, im_data TEXT, website TEXT, relation TEXT, data1 TEXT, data2 TEXT, data3 TEXT, data4 TEXT, data5 TEXT, data6 TEXT);";
    }
}
