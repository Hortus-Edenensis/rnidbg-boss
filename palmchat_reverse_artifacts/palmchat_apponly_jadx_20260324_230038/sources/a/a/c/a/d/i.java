package a.a.c.a.d;

import a.a.c.a.b.c;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class i implements a.a.c.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.a.c.a.e.c<Boolean> f1114a = new a(this);

    /* JADX INFO: compiled from: SearchBox */
    public class a extends a.a.c.a.e.c<Boolean> {
        public a(i iVar) {
        }

        @Override // a.a.c.a.e.c
        public Boolean a(Object[] objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    @Override // a.a.c.a.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.a a(Context context) {
        Cursor cursorQuery;
        String string;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                c.a aVar = new c.a();
                if (cursorQuery.isClosed()) {
                    string = null;
                } else {
                    cursorQuery.moveToFirst();
                    int columnIndex = cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT);
                    if (columnIndex >= 0) {
                        string = cursorQuery.getString(columnIndex);
                    }
                }
                aVar.f1105a = string;
                cursorQuery.close();
                return aVar;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return this.f1114a.b(context).booleanValue();
    }
}
