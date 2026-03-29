package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17406a;

    public f07(Context context) {
        this.f17406a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, String str) {
        Uri uri;
        Uri uri2;
        Cursor cursorQuery;
        if (i == 0) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i == 2) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else {
            if (i != 4) {
                uri2 = null;
                cursorQuery = this.f17406a.getContentResolver().query(uri2, null, null, null, null);
                if (cursorQuery == null) {
                    string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)) : null;
                    cursorQuery.close();
                } else {
                    Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
                }
                return string;
            }
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        }
        uri2 = uri;
        cursorQuery = this.f17406a.getContentResolver().query(uri2, null, null, null, null);
        if (cursorQuery == null) {
        }
        return string;
    }
}
