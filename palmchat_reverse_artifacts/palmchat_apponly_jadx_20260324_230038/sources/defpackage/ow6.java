package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.heytap.mcssdk.constant.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ow6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f19891a = Uri.parse("content://com.oplus.atom.db_sys/atom_delegate");

    public static /* synthetic */ String b(u17 u17Var, Context context) {
        return "AtomAgent add Task error -- bean or context is null--" + u17Var + "," + context;
    }

    public static void c(Context context, pw6 pw6Var) {
        d(context, pw6Var);
    }

    public static void d(final Context context, final u17 u17Var) {
        if (u17Var == null || context == null) {
            n87.e("AtomAgent", new la7() { // from class: jt6
                @Override // defpackage.la7
                public final Object get() {
                    return ow6.b(u17Var, context);
                }
            });
            return;
        }
        pw6 pw6Var = (pw6) u17Var;
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Integer.valueOf(pw6Var.p()));
        contentValues.put(b.e, x17.d(context));
        contentValues.put("logTag", pw6Var.m());
        contentValues.put("eventID", pw6Var.b());
        contentValues.put("logMap", pw6Var.o());
        try {
            context.getContentResolver().insert(f19891a, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
