package com.opos.mobad.i.a;

import android.content.Context;
import com.opos.mobad.i.a;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static com.opos.mobad.i.a a(String str, String str2) {
        try {
            return new a.C0747a().a(str).b("").c(str2).a(0).a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("DownloadUtils", "createDownloadRequest() fail", e);
            return null;
        }
    }

    public static File b(Context context, com.opos.mobad.i.a aVar) {
        if (context != null && aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return new File(aVar.d + ".tmp");
            }
            if (i == 1) {
                return new File(context.getFilesDir(), aVar.g + ".tmp");
            }
            if (i == 2) {
                return new File(context.getDir(aVar.f, aVar.e), aVar.g + ".tmp");
            }
        }
        return null;
    }

    public static File c(Context context, com.opos.mobad.i.a aVar) {
        if (context != null && aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return new File(aVar.d + ".pos");
            }
            if (i == 1) {
                return new File(context.getFilesDir(), aVar.g + ".pos");
            }
            if (i == 2) {
                return new File(context.getDir(aVar.f, aVar.e), aVar.g + ".pos");
            }
        }
        return null;
    }

    public static File a(Context context, com.opos.mobad.i.a aVar) {
        if (context != null && aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return new File(aVar.d);
            }
            if (i == 1) {
                return new File(context.getFilesDir(), aVar.g);
            }
            if (i == 2) {
                return new File(context.getDir(aVar.f, 0), aVar.g);
            }
        }
        return null;
    }
}
