package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.ky;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class uk implements ky {
    private ob<Boolean> u = new ob<Boolean>() { // from class: com.bytedance.embedapplog.uk.1
        @Override // com.bytedance.embedapplog.ob
        /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
        public Boolean u(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    @Override // com.bytedance.embedapplog.ky
    public ky.u nr(Context context) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                ky.u uVar = new ky.u();
                uVar.nr = u(cursorQuery);
                return uVar;
            } catch (Throwable th) {
                th = th;
                try {
                    ti.u(th);
                    return null;
                } finally {
                    gb.u(cursorQuery);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    @Override // com.bytedance.embedapplog.ky
    public boolean u(Context context) {
        if (context == null) {
            return false;
        }
        return this.u.nr(context).booleanValue();
    }

    private String u(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(ActionUtils.PAYMENT_AMOUNT);
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
