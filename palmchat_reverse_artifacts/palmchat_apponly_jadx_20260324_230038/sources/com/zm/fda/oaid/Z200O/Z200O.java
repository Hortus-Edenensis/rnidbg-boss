package com.zm.fda.oaid.Z200O;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import defpackage.nq6;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z200O extends com.zm.fda.oaid.ZZ00Z {
    public static final String b = "FDA_OAID_meizu";

    public Z200O(Context context) {
        this.f16722a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.zm.fda.oaid.Z25O0 z25o0, String str) {
        if (com.zm.fda.oaid.ZZ00Z.a(str)) {
            z25o0.a(str);
        } else {
            z25o0.getClass();
            super.a(new nq6(z25o0));
        }
    }

    @Override // com.zm.fda.oaid.ZZ00Z
    public void c(final com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        d(new com.zm.fda.oaid.Z25O0() { // from class: up6
            @Override // com.zm.fda.oaid.Z25O0
            public final void a(String str) {
                this.f21268a.a(z25o0, str);
            }
        });
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        Context context = this.f16722a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider(com.zm.fda.oaid.Z2500.OO22Z.a("Y29tLm1laXp1LmZseW1lLm9wZW5pZHNkaw=="), 0) != null;
        } catch (Exception unused) {
            Log.e(b, "meizu is not support");
            return false;
        }
    }

    private void d(com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        String string = "";
        try {
            Cursor cursorQuery = this.f16722a.getContentResolver().query(Uri.parse(com.zm.fda.oaid.Z2500.OO22Z.a("Y29udGVudDovL2NvbS5tZWl6dS5mbHltZS5vcGVuaWRzZGsv")), null, null, new String[]{com.zm.fda.oaid.Z2500.OO22Z.a("b2FpZA==")}, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                string = cursorQuery.getString(cursorQuery.getColumnIndex(com.zm.fda.oaid.Z2500.OO22Z.a("dmFsdWU=")));
                com.zm.fda.oaid.Z2500.Z25O0.a(b, "get oaid by ContentResolver:" + string);
                cursorQuery.close();
            } finally {
            }
        } catch (Throwable th) {
            Log.e(b, "get oaid by inner api err", th);
        }
        z25o0.a(string);
    }
}
