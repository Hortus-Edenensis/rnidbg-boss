package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import com.bytedance.sdk.openadsdk.gi.iz;
import com.oplus.tblplayer.Constants;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import ms.bz.bd.c.Pgl.h1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f19315a = new HashSet();
    public final h1.pblb b;
    public final h1.pgla c;

    public j1(h1.pblb pblbVar, pbld pbldVar) {
        this.b = pblbVar;
        this.c = pbldVar;
    }

    public final void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        b(context, "Pglbizssdk_ml", null);
    }

    public final void b(Context context, String str, String str2) {
        if (this.f19315a.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((x1) this.b).getClass();
            iz.u(str);
            this.f19315a.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((x1) this.b).getClass();
            String strMapLibraryName = (str.startsWith(Constants.LIBRARY_PREFIX) && str.endsWith(Constants.LIBRARY_SUFFIX)) ? str : System.mapLibraryName(str);
            File file = str2 == null || str2.length() == 0 ? new File(nr.u(context, Constants.LIBRARY_PREFIX, 0), strMapLibraryName) : new File(nr.u(context, Constants.LIBRARY_PREFIX, 0), strMapLibraryName + "." + str2);
            if (!file.exists()) {
                File fileU = nr.u(context, Constants.LIBRARY_PREFIX, 0);
                ((x1) this.b).getClass();
                String strMapLibraryName2 = (str.startsWith(Constants.LIBRARY_PREFIX) && str.endsWith(Constants.LIBRARY_SUFFIX)) ? str : System.mapLibraryName(str);
                File file2 = str2 == null || str2.length() == 0 ? new File(nr.u(context, Constants.LIBRARY_PREFIX, 0), strMapLibraryName2) : new File(nr.u(context, Constants.LIBRARY_PREFIX, 0), strMapLibraryName2 + "." + str2);
                ((x1) this.b).getClass();
                File[] fileArrListFiles = fileU.listFiles(new i1((str.startsWith(Constants.LIBRARY_PREFIX) && str.endsWith(Constants.LIBRARY_SUFFIX)) ? str : System.mapLibraryName(str)));
                if (fileArrListFiles != null) {
                    for (File file3 : fileArrListFiles) {
                        if (!file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file3.delete();
                        }
                    }
                }
                h1.pgla pglaVar = this.c;
                String[] strArrA = ((x1) this.b).a();
                ((x1) this.b).getClass();
                ((pbld) pglaVar).b(context, strArrA, (str.startsWith(Constants.LIBRARY_PREFIX) && str.endsWith(Constants.LIBRARY_SUFFIX)) ? str : System.mapLibraryName(str), file, this);
            }
            h1.pblb pblbVar = this.b;
            String absolutePath = file.getAbsolutePath();
            ((x1) pblbVar).getClass();
            System.load(absolutePath);
            this.f19315a.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }
}
