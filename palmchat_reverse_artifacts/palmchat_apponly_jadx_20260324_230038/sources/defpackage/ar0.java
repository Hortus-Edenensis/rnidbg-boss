package defpackage;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ar0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f1559a;
    public FilenameFilter b = new FilenameFilter() { // from class: yq0
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return ar0.f(file, str);
        }
    };

    public ar0(Context context, String str) {
        if (str != null) {
            this.f1559a = new File(context.getFilesDir(), "crash_" + str);
        } else {
            this.f1559a = new File(context.getFilesDir(), "crash");
        }
        if (this.f1559a.exists()) {
            return;
        }
        this.f1559a.mkdir();
    }

    public static /* synthetic */ int e(File file, File file2) {
        if (file.lastModified() > file2.lastModified()) {
            return -1;
        }
        return file.lastModified() == file2.lastModified() ? 0 : 1;
    }

    public static /* synthetic */ boolean f(File file, String str) {
        return str.startsWith("log-");
    }

    public synchronized boolean c(String str) {
        return un.c(String.format("%s%s%s%s", this.f1559a.getAbsolutePath(), File.separator, "log-", sn.b("yyyyMMdd-HHmmss")), str, "UTF-8");
    }

    public synchronized File[] d() {
        File[] fileArrListFiles;
        fileArrListFiles = this.f1559a.listFiles(this.b);
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: zq0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ar0.e((File) obj, (File) obj2);
                }
            });
        }
        return fileArrListFiles;
    }

    public synchronized boolean g(String str) {
        return new File(this.f1559a, str).delete();
    }
}
