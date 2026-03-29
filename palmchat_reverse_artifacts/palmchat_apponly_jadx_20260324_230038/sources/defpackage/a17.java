package defpackage;

import android.os.Build;
import com.bytedance.sdk.component.jk.b.fx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a17 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends fx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Process f1138a;
        public long c;

        public a(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.f1138a = process;
            this.c = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.c);
            } catch (InterruptedException unused) {
            }
            Process process = this.f1138a;
            if (process != null) {
                process.destroy();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends fx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f1139a;
        public List<String> c;

        public b(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.f1139a = inputStream;
            this.c = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1139a));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("---------")) {
                            length -= line.getBytes("UTF-8").length;
                            if (length < 0) {
                                break;
                            } else {
                                this.c.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    return;
                } finally {
                    xe7.a(bufferedReader);
                }
            }
        }
    }

    public static String a(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }

    public static List<String> b(int i, int i2) {
        Process processExec;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"logcat", "-t", String.valueOf(i), a(i2)});
        } catch (Throwable unused) {
            processExec = null;
        }
        try {
            new b(processExec.getInputStream(), copyOnWriteArrayList).start();
            new b(processExec.getErrorStream(), copyOnWriteArrayList).start();
            new a(processExec, 3000L).start();
            if (Build.VERSION.SDK_INT >= 26) {
                processExec.waitFor(3000L, TimeUnit.MILLISECONDS);
            } else {
                processExec.waitFor();
            }
        } catch (Throwable unused2) {
            if (processExec != null) {
            }
            return copyOnWriteArrayList;
        }
        processExec.destroy();
        return copyOnWriteArrayList;
    }
}
