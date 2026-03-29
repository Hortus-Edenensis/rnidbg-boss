package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ue6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f21200a = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_video");

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS tb_video(_id INTEGER PRIMARY KEY, video_path TEXT, video_thumbnail TEXT, video_type INTEGER, video_modify_time INTEGER DEFAULT 0 , video_play_length INTEGER DEFAULT 0);";
    }
}
