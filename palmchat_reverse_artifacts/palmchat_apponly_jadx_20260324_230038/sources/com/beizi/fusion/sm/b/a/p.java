package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.qq.gdt.action.ActionUtils;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class p implements com.beizi.fusion.sm.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4692a;

    public p(Context context) {
        this.f4692a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.beizi.fusion.sm.b.f.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f4692a == null || bVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f4692a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                if (string != null && string.length() != 0) {
                    com.beizi.fusion.sm.b.e.a("OAID query success: " + string);
                    bVar.a(string);
                    cursorQuery.close();
                    return;
                }
                throw new com.beizi.fusion.sm.b.d("OAID query failed");
            } finally {
            }
        } catch (Exception e) {
            com.beizi.fusion.sm.b.e.a(e);
            bVar.a(e);
        }
    }
}
