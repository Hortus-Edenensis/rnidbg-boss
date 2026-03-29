package com.bytedance.embedapplog;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.ky;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class jf implements ky {
    private static final ob<Boolean> u = new ob<Boolean>() { // from class: com.bytedance.embedapplog.jf.1
        @Override // com.bytedance.embedapplog.ob
        /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
        public Boolean u(Object... objArr) {
            return Boolean.valueOf("1".equals(jf.nr("persist.sys.identifierid.supported", "0")));
        }
    };

    public jf(Context context) {
    }

    @Override // com.bytedance.embedapplog.ky
    public ky.u nr(Context context) {
        ky.u uVar = new ky.u();
        uVar.nr = u(context, 0, null);
        return uVar;
    }

    public static boolean u() {
        return u.nr(new Object[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String nr(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // com.bytedance.embedapplog.ky
    public boolean u(Context context) {
        return u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Nullable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String u(@NonNull Context context, int i, String str) throws Throwable {
        Uri uri;
        Uri uri2;
        String string = null;
        string = null;
        string = null;
        string = null;
        ?? r0 = 0;
        try {
            if (i == 0) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
            } else if (i == 1) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_".concat(String.valueOf(str)));
            } else {
                if (i != 2) {
                    uri2 = null;
                    if (uri2 != null) {
                        try {
                            context = context.getContentResolver().query(uri2, null, null, null, null);
                        } catch (Exception e) {
                            e = e;
                            context = 0;
                        } catch (Throwable th) {
                            th = th;
                            gb.u((Cursor) r0);
                            throw th;
                        }
                        if (context != 0) {
                            try {
                                boolean zMoveToNext = context.moveToNext();
                                context = context;
                                if (zMoveToNext) {
                                    string = context.getString(context.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                                    context = context;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                ti.u(e);
                                context = context;
                            }
                        }
                        gb.u((Cursor) context);
                    }
                    return string;
                }
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_".concat(String.valueOf(str)));
            }
            if (uri2 != null) {
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            r0 = context;
        }
        uri2 = uri;
    }
}
