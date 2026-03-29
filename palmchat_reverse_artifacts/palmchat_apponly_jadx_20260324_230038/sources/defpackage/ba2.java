package defpackage;

import android.content.Context;
import android.net.http.HttpResponseCache;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ba2 {
    public static void a(Context context, boolean z) {
        c15.INSTANCE.b().w(context);
        b15.c.c(z);
        try {
            HttpResponseCache.install(new File(context.getApplicationContext().getCacheDir(), "svgaCache"), 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
