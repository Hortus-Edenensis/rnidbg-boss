package a.a.c.a.d;

import a.a.c.a.b.c;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class k implements a.a.c.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.a.c.a.e.c<Boolean> f1115a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends a.a.c.a.e.c<Boolean> {
        @Override // a.a.c.a.e.c
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf("1".equals(k.a("persist.sys.identifierid.supported", "0")));
        }
    }

    public static String a(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        return f1115a.b(new Object[0]).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    @Override // a.a.c.a.b.c
    public c.a a(Context context) throws Throwable {
        Cursor cursorQuery;
        c.a aVar = new c.a();
        Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        ?? r1 = 0;
        string = null;
        try {
            try {
                if (uri != null) {
                    try {
                        cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToNext()) {
                                    string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                                }
                            } catch (Exception e) {
                                e = e;
                                e.getMessage();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursorQuery = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception e3) {
                                e3.getMessage();
                            }
                        }
                        throw th;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Exception e4) {
                e4.getMessage();
            }
            aVar.f1105a = string;
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            r1 = context;
        }
    }
}
