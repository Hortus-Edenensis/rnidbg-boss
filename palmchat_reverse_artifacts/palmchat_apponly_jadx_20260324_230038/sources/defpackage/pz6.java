package defpackage;

import com.oplus.tblplayer.Constants;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pz6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f20143a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20144a = false;
        public final /* synthetic */ String b;

        public a(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA;
            String str;
            pz6.h();
            if (pz6.j(this.b)) {
                return;
            }
            vi7.d("updateSo", this.b);
            File file = new File(pz6.b(this.b));
            file.getParentFile().mkdirs();
            if (file.exists()) {
                file.delete();
            }
            kj7.b("doUnpackLibrary: " + this.b);
            try {
                strA = s37.a(x97.m(), this.b, file);
            } catch (Throwable th) {
                vi7.d("updateSoError", this.b);
                n37.a();
                n37.b("NPTH_CATCH", th);
                strA = null;
            }
            if (strA == null) {
                pz6.f20143a.put(file.getName(), "0.0.1-rc.3");
                try {
                    re7.j(new File(pz6.i(this.b)), "0.0.1-rc.3", false);
                } catch (Throwable unused) {
                }
                str = "updateSoSuccess";
            } else {
                if (!this.f20144a) {
                    this.f20144a = true;
                    vi7.d("updateSoPostRetry", this.b);
                    ih7.b().f(this, 3000L);
                    return;
                }
                str = "updateSoFailed";
            }
            vi7.d(str, this.b);
        }
    }

    public static String a() {
        return x97.m().getFilesDir() + "/apmlite/selflib/";
    }

    public static String b(String str) {
        return x97.m().getFilesDir() + "/apmlite/selflib/" + Constants.LIBRARY_PREFIX + str + Constants.LIBRARY_SUFFIX;
    }

    public static void d(String str) {
        ih7.b().e(new a(str));
    }

    public static void h() {
        if (f20143a != null) {
            return;
        }
        f20143a = new HashMap<>();
        File file = new File(x97.m().getFilesDir(), "/apmlite/selflib/");
        String[] list = file.list();
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (str.endsWith(".ver")) {
                try {
                    f20143a.put(str.substring(0, str.length() - 4), re7.z(file.getAbsolutePath() + "/" + str));
                } catch (Throwable th) {
                    n37.a();
                    n37.b("NPTH_CATCH", th);
                }
            } else if (!str.endsWith(Constants.LIBRARY_SUFFIX)) {
                re7.r(new File(file, str));
            }
        }
    }

    public static String i(String str) {
        return x97.m().getFilesDir() + "/apmlite/selflib/" + str + ".ver";
    }

    public static boolean j(String str) {
        return "0.0.1-rc.3".equals(f20143a.get(str)) && new File(b(str)).exists();
    }
}
