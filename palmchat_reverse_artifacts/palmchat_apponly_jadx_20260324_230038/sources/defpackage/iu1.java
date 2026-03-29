package defpackage;

import android.content.Context;
import com.zenmen.palmchat.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class iu1 {
    public static volatile iu1 d;
    public static final boolean e = c.c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStreamWriter f18263a;
    public be1 b;
    public File c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18264a;

        public a(String str) {
            this.f18264a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                iu1.c().f18263a.write(this.f18264a);
                iu1.c().f18263a.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public iu1() {
        this.f18263a = null;
        this.b = null;
        this.c = null;
        if (e) {
            try {
                if (c.b().getExternalFilesDir(null) == null) {
                    return;
                }
                File file = new File(pu1.i);
                file.mkdirs();
                this.c = new File(file, b(c.b()) + com.zenmen.palmchat.utils.log.a.j().i().format(ir5.b()) + ".txt");
                this.b = new be1("logQueue");
                this.c.createNewFile();
                this.f18263a = new OutputStreamWriter(new FileOutputStream(this.c));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String b(Context context) {
        return k86.m(context);
    }

    public static iu1 c() {
        iu1 iu1Var = d;
        if (iu1Var == null) {
            synchronized (iu1.class) {
                iu1Var = d;
                if (iu1Var == null) {
                    iu1Var = new iu1();
                    d = iu1Var;
                }
            }
        }
        return iu1Var;
    }

    public static void d(String str) {
        if (e && c().f18263a != null) {
            c().b.a(new a(str));
        }
    }
}
