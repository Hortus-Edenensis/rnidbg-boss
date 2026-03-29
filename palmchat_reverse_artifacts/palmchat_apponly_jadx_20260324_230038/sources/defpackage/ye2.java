package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ye2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f22183a = 1;
    public static int b = 1;
    public static int c;

    public static String a(String str) {
        return "CREATE TABLE IF NOT EXISTS " + (str + "( _id INTEGER PRIMARY KEY,group_id TEXT UNIQUE,name TEXT ,owner TEXT ,headImgUrl TEXT ,local_name TEXT ,type INTEGER ,group_member_count int default 0 ,group_config int default 0 ,group_state INTEGER ,group_extra_info TEXT ,group_categoryId TEXT );");
    }
}
