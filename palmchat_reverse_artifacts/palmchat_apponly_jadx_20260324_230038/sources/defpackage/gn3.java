package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gn3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17757a;
    public String b;

    public gn3(Context context) {
        this.b = "";
        this.f17757a = context;
        this.b = rv2.h("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO");
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cursor cursorQuery = this.f17757a.getContentResolver().query(Uri.parse(this.b), null, null, new String[]{str}, null);
            if (cursorQuery != null) {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)) : null;
                cursorQuery.close();
            } else {
                p63.a("MeizuDB", "return cursor is null,return");
            }
        } catch (Exception e) {
            p63.f("MeizuDB", "getId error: " + e.getMessage());
        }
        return string;
    }
}
