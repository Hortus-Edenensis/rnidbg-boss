package com.opos.cmn.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.an.b.b;
import com.opos.cmn.an.f.a.b;
import com.opos.cmn.an.f.a.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static void a() {
        com.opos.cmn.an.f.a.b();
    }

    public static void b() {
        com.opos.cmn.an.f.a.a(new c.a().a(true).a("ad_mob").a(), new com.opos.cmn.an.f.a.a() { // from class: com.opos.cmn.c.a.1
            @Override // com.opos.cmn.an.f.a.a
            public void onDontNeedUpload(String str) {
                com.opos.cmn.an.f.a.a("lc", "onDontNeedUpload " + str);
            }

            @Override // com.opos.cmn.an.f.a.a
            public void onUploaderFailed(String str) {
                com.opos.cmn.an.f.a.a("lc", "onUploaderFailed " + str);
            }

            @Override // com.opos.cmn.an.f.a.a
            public void onUploaderSuccess() {
                com.opos.cmn.an.f.a.a("lc", "onUploaderSuccess ");
            }
        });
    }

    public static final boolean c() {
        String strA = b.a("Y29tLmhleXRhcC5tc3AubW9iYWQuYQ==");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        try {
            Class.forName(strA);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, boolean z, String str, boolean z2) {
        if (context == null) {
            return;
        }
        if (z) {
            com.opos.cmn.an.f.a.a();
        }
        b.a aVarA = new b.a().b(c() ? 1 : 4).c(7).a("mob_ad");
        aVarA.a(1);
        if (!TextUtils.isEmpty(str)) {
            aVarA.b(str);
        }
        com.opos.cmn.an.f.a.b bVarA = aVarA.a(context);
        com.opos.cmn.an.f.a.a(context, z2);
        com.opos.cmn.an.f.a.a(bVarA);
    }

    public static void a(Context context, boolean z, boolean z2) {
        if (context == null) {
            return;
        }
        a(context, z, context.getPackageName(), z2);
    }
}
