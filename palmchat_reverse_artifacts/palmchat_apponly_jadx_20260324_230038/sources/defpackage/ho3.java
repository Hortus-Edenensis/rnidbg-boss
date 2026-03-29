package defpackage;

import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ho3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f18004a = {"_id", "packet_id", "src", "dest", "subject", "message", "language", "read", "type", "buddy_id", "contact_relate", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "msg_status", "msg_type", "msg_extend", "msg_chat_type"};

    public static String a(String str) {
        return "DROP INDEX IF EXISTS " + ("idx_contactrelate_" + str);
    }

    public static String b(String str) {
        return "CREATE TABLE IF NOT EXISTS " + (str + "( _id INTEGER PRIMARY KEY, packet_id text UNIQUE, src text , dest text , subject text , message text , language varchar(16) , read int default 0 , type int default 1, msg_chat_type int default 0, buddy_id long , contact_relate text , " + FFmpegMediaMetadataRetriever.METADATA_KEY_DATE + " LONG, msg_status varchar(16) , msg_type int default 0 , msg_extend varchar(256) ,attach_status int default 0 ,msg_sending_progress int default 0 ,user_flag text ,attachment_read int default 0 ,data1 text ,data2 text ,data3 text ,data4 text ,data5 text ,data6 text ,data7 text ,data8 text ,data9 text ,data10 text );");
    }

    public static String c(String str) {
        return "CREATE INDEX IF NOT EXISTS " + ("idx_contactrelate_" + str) + " ON " + str + " (contact_relate)";
    }
}
