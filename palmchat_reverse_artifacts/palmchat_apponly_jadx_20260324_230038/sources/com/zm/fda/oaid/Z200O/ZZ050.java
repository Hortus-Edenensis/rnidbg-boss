package com.zm.fda.oaid.Z200O;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import defpackage.nq6;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ050 extends com.zm.fda.oaid.ZZ00Z {
    public static final String b = "FDA_OAID_vivo";

    public ZZ050(Context context) {
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
        if (this.f16722a == null) {
            z25o0.a("");
        } else {
            d(new com.zm.fda.oaid.Z25O0() { // from class: qq6
                @Override // com.zm.fda.oaid.Z25O0
                public final void a(String str) {
                    this.f20306a.a(z25o0, str);
                }
            });
        }
    }

    @Override // com.zm.fda.oaid.O022Z
    public boolean isSupport() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.zm.fda.oaid.Z2500.Z0225.a(com.zm.fda.oaid.Z2500.OO22Z.a("cGVyc2lzdC5zeXMuaWRlbnRpZmllcmlkLnN1cHBvcnRlZA=="), "0").equals("1");
    }

    private void d(com.zm.fda.oaid.Z25O0 z25o0) {
        if (z25o0 == null) {
            return;
        }
        String string = "";
        if (!isSupport() || this.f16722a == null) {
            z25o0.a("");
            return;
        }
        try {
            Cursor cursorQuery = this.f16722a.getContentResolver().query(Uri.parse(com.zm.fda.oaid.Z2500.OO22Z.a("Y29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                string = cursorQuery.getString(cursorQuery.getColumnIndex(com.zm.fda.oaid.Z2500.OO22Z.a("dmFsdWU=")));
                com.zm.fda.oaid.Z2500.Z25O0.a(b, "getOaidBySelf oaid:" + string);
                cursorQuery.close();
            } finally {
            }
        } catch (Throwable th) {
            Log.e(b, "getOaidBySelf err", th);
        }
        z25o0.a(string);
    }
}
