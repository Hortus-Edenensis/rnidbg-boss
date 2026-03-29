package com.beizi.fusion.d.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class j {
    private Context b;
    private boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f4638a = null;

    public j(Context context) {
        this.b = context;
    }

    public String a() {
        Cursor cursorQuery = this.b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)) : null;
            cursorQuery.close();
        }
        return string;
    }
}
