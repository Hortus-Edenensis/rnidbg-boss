package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class gu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17806a;

    public gu0(Context context) {
        this.f17806a = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:4|(2:6|(2:8|(2:10|(2:12|(5:14|47|(1:23)(6:49|24|45|(2:26|(1:28))(1:29)|(1:31)|38)|(1:42)|43)(1:15))(1:16))(1:17))(1:18))(1:19))(1:20)|21|47|(0)(0)|(0)|43|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
    
        r1 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, String str) throws Throwable {
        Uri uri;
        Uri uri2;
        ?? Query;
        ?? r1 = 0;
        string = null;
        string = null;
        string = null;
        String string = null;
        if (i == 0) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i == 2) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i == 3) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/UDID");
        } else if (i == 4) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_" + str);
        } else {
            if (i != 5) {
                uri2 = null;
                Query = i;
                if (uri2 != null) {
                    return null;
                }
                try {
                    Query = this.f17806a.getContentResolver().query(uri2, null, null, null, null);
                    try {
                        if (Query == 0) {
                            Log.d("VMS_SDK_DB", "return cursor is null,return");
                        } else if (Query.moveToNext()) {
                            string = Query.getString(Query.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                        }
                    } catch (Exception unused) {
                        Log.e("VMS_SDK_DB", "return cursor is error");
                        if (Query != 0) {
                        }
                        return string;
                    }
                } catch (Exception unused2) {
                    Query = 0;
                } catch (Throwable th) {
                    th = th;
                }
                if (Query != 0) {
                    Query.close();
                }
                return string;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
            uri = Uri.parse("content://com.vivo.abe.exidentifier/guid");
        }
        uri2 = uri;
        Query = uri;
        if (uri2 != null) {
        }
        if (r1 != 0) {
        }
        throw th;
    }

    public boolean b(int i, String str, ContentValues[] contentValuesArr) {
        Uri uri;
        int iBulkInsert;
        if (i == 6) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i != 7) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            iBulkInsert = this.f17806a.getContentResolver().bulkInsert(uri, contentValuesArr);
            Log.d("VMS_SDK_DB", "insert:" + iBulkInsert);
        } catch (Exception unused) {
            Log.e("VMS_SDK_DB", "return insert is error");
        }
        return iBulkInsert != 0;
    }
}
