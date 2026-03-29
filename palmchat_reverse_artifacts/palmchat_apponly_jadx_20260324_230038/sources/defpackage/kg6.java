package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class kg6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18686a;

    public kg6(Context context) {
        this.f18686a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c A[Catch: Exception -> 0x0079, TryCatch #0 {Exception -> 0x0079, blocks: (B:13:0x004c, B:15:0x005c, B:17:0x0062, B:18:0x006e, B:19:0x0072, B:9:0x000d, B:10:0x0027, B:11:0x0041), top: B:24:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[Catch: Exception -> 0x0079, TRY_LEAVE, TryCatch #0 {Exception -> 0x0079, blocks: (B:13:0x004c, B:15:0x005c, B:17:0x0062, B:18:0x006e, B:19:0x0072, B:9:0x000d, B:10:0x0027, B:11:0x0041), top: B:24:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, String str) {
        Uri uri;
        Uri uri2;
        Cursor cursorQuery;
        try {
        } catch (Exception e) {
            p63.f("VivoDB", "get id error: " + e.getMessage());
        }
        if (i == 0) {
            uri = Uri.parse(rv2.h("HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1zTqeaHqknpahXd0Fww8QTTjy7MHX7/1f2JKNuxQ9omA=="));
        } else if (i == 1) {
            uri = Uri.parse(rv2.h("HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1mRRRjMzvkebo9eb3zqoVhCi2GjcOItUY/+C68T3lxGg==") + str);
        } else {
            if (i != 2) {
                uri2 = null;
                cursorQuery = this.f18686a.getContentResolver().query(uri2, null, null, null, null);
                if (cursorQuery == null) {
                    string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)) : null;
                    cursorQuery.close();
                } else {
                    p63.a("VivoDB", "return cursor is null,return");
                }
                return string;
            }
            uri = Uri.parse(rv2.h("HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1FXRr9EgPkoDQnyVgIu2tARnCHNUAAn6DU1ZkzxwPHKA==") + str);
        }
        uri2 = uri;
        cursorQuery = this.f18686a.getContentResolver().query(uri2, null, null, null, null);
        if (cursorQuery == null) {
        }
        return string;
    }
}
