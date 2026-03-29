package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class gt4 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, ht4 ht4Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        String a(String str);

        String[] b();

        void c(String str);

        String d(String str);

        void loadLibrary(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, c cVar) {
        new ht4().f(context, str, str2, cVar);
    }
}
