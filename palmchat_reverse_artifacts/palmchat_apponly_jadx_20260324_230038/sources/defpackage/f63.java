package defpackage;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.kuaishou.weapon.p0.g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class f63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17465a = ".jpush";
    public static String b;
    public static String c;
    public static final SimpleDateFormat d;
    public static ArrayList<String> e;
    public static boolean f;
    public static boolean g;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends xw2 {
        public final /* synthetic */ ArrayList c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ArrayList arrayList) {
            super(str);
            this.c = arrayList;
        }

        @Override // defpackage.xw2
        public void a() {
            BufferedWriter bufferedWriter;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    String str = f63.c + "-" + hv0.b() + "_1.txt";
                    File file = new File(str);
                    file.getParentFile().mkdirs();
                    int i = 2;
                    while (true) {
                        if (!file.exists()) {
                            break;
                        }
                        str = f63.c + "-" + hv0.b() + "_" + i + ".txt";
                        file = new File(str);
                        if (i > 10) {
                            k63.l("Logger", "Unexpected error here, so many existed error file.");
                            break;
                        }
                        i++;
                    }
                    k63.j("Logger", "Write log file: " + file.getName());
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    bufferedWriter = new BufferedWriter(new FileWriter(str));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Iterator it = this.c.iterator();
                    while (it.hasNext()) {
                        bufferedWriter.write(((String) it.next()) + "\n");
                    }
                    f63.e.clear();
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    bufferedWriter2 = bufferedWriter;
                    th = th2;
                    try {
                        k63.m("Logger", "write logs to file error", th);
                        f63.e.clear();
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                    } catch (Throwable th3) {
                        try {
                            f63.e.clear();
                            if (bufferedWriter2 != null) {
                                bufferedWriter2.close();
                            }
                        } catch (Throwable th4) {
                            k63.d("Logger", "close file stream error", th4);
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th5) {
                k63.d("Logger", "close file stream error", th5);
            }
            f63.f();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(f17465a);
        sb.append(str);
        b = sb.toString();
        c = b + f17465a;
        d = new SimpleDateFormat("MM.dd_HH:mm:ss_SSS", Locale.ENGLISH);
        e = new ArrayList<>();
        f = false;
        g = false;
    }

    public static void d(String str, String str2, String str3, Throwable th) {
        if (str2 == null || str2.trim().equals("")) {
            str2 = "Logger";
        }
        if (str3 == null) {
            return;
        }
        try {
            String str4 = d.format(new Date());
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str3), 256);
            String strC = nl5.c("[" + str2 + "]", 24);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    e(((Object) str4) + " " + nl5.c(str, 5) + " " + strC + " " + line);
                } catch (IOException e2) {
                    k63.c("Logger", e2.getMessage());
                }
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                e(((Object) str4) + " " + str + stringWriter.toString());
            }
        } catch (Throwable th2) {
            Log.w("Logger", "logtofile call failed:" + th2.getMessage());
        }
    }

    public static void e(String str) {
        if (g) {
            return;
        }
        try {
            e.add(str);
            if (e.size() == 500) {
                ArrayList<String> arrayList = e;
                e = new ArrayList<>();
                boolean zS = ad.s(tv2.p, g.j);
                f = zS;
                if (zS) {
                    k63.j("Logger", "have writable external storage, write log file");
                    g(arrayList);
                } else {
                    k63.j("Logger", "no writable external storage");
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            e = new ArrayList<>();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void f() {
        try {
            File file = new File(b);
            if (file.exists()) {
                int length = f17465a.length() + 1;
                int length2 = hv0.c.length() + length;
                if (file.listFiles() != null) {
                    for (File file2 : file.listFiles()) {
                        if (hv0.d(hv0.e(file2.getName().substring(length, length2)), 2)) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            k63.c("Logger", th.getMessage());
        }
    }

    public static void g(ArrayList<String> arrayList) {
        try {
            Context context = tv2.p;
            if (context == null || ad.s(context, g.j)) {
                wz4.a("NORMAL_TASK", new a("LogToFile#saveLogs", arrayList));
            } else {
                k63.l("Logger", "WRITE_EXTERNAL_STORAGE not get");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
