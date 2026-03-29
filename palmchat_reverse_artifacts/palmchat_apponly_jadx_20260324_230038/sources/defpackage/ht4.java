package defpackage;

import android.content.Context;
import android.util.Log;
import com.oplus.tblplayer.Constants;
import defpackage.gt4;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import pl.droidsonroids.relinker.MissingLibraryException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ht4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f18048a;
    public final gt4.b b;
    public final gt4.a c;
    public boolean d;
    public boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18049a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(Context context, String str, String str2, gt4.c cVar) {
            this.f18049a = context;
            this.b = str;
            this.c = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            try {
                ht4.this.g(this.f18049a, this.b, this.c);
                throw null;
            } catch (UnsatisfiedLinkError unused) {
                throw null;
            } catch (MissingLibraryException unused2) {
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18050a;

        public b(String str) {
            this.f18050a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f18050a);
        }
    }

    public ht4() {
        this(new dr5(), new qe());
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.b.d(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir(Constants.LIBRARY_PREFIX, 0);
    }

    public File d(Context context, String str, String str2) {
        String strD = this.b.d(str);
        if (iv5.a(str2)) {
            return new File(c(context), strD);
        }
        return new File(c(context), strD + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, gt4.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (iv5.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        i("Beginning load of %s...", str);
        if (cVar == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, cVar)).start();
        }
    }

    public final void g(Context context, String str, String str2) throws Throwable {
        if (this.f18048a.contains(str) && !this.d) {
            i("%s already loaded previously!", str);
            return;
        }
        try {
            this.b.loadLibrary(str);
            this.f18048a.add(str);
            i("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e));
            i("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.d) {
                if (this.d) {
                    i("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.c.a(context, this.b.b(), this.b.d(str), fileD, this);
            }
            try {
                if (this.e) {
                    nl1 nl1Var = null;
                    try {
                        nl1 nl1Var2 = new nl1(fileD);
                        try {
                            List<String> listD = nl1Var2.d();
                            nl1Var2.close();
                            Iterator<String> it = listD.iterator();
                            while (it.hasNext()) {
                                e(context, this.b.a(it.next()));
                            }
                        } catch (Throwable th) {
                            th = th;
                            nl1Var = nl1Var2;
                            nl1Var.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException unused) {
            }
            this.b.c(fileD.getAbsolutePath());
            this.f18048a.add(str);
            i("%s (%s) was re-linked!", str, str2);
        }
    }

    public void i(String str, Object... objArr) {
        h(String.format(Locale.US, str, objArr));
    }

    public ht4(gt4.b bVar, gt4.a aVar) {
        this.f18048a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.b = bVar;
        this.c = aVar;
    }

    public void h(String str) {
    }
}
