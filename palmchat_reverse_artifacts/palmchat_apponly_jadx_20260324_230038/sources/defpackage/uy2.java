package defpackage;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class uy2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f21323a;
    public FilenameFilter b = new FilenameFilter() { // from class: ty2
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return uy2.e(file, str);
        }
    };

    public uy2(Context context, String str) {
        if (str != null) {
            this.f21323a = new File(context.getFilesDir(), "jscrash_" + str);
        } else {
            this.f21323a = new File(context.getFilesDir(), "jscrash");
        }
        if (this.f21323a.exists()) {
            return;
        }
        this.f21323a.mkdir();
    }

    public static /* synthetic */ int d(File file, File file2) {
        if (file.lastModified() > file2.lastModified()) {
            return -1;
        }
        return file.lastModified() == file2.lastModified() ? 0 : 1;
    }

    public static /* synthetic */ boolean e(File file, String str) {
        return str.startsWith("log-");
    }

    public synchronized File[] c() {
        File[] fileArrListFiles;
        fileArrListFiles = this.f21323a.listFiles(this.b);
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: sy2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return uy2.d((File) obj, (File) obj2);
                }
            });
        }
        return fileArrListFiles;
    }

    public synchronized boolean f(String str) {
        return new File(this.f21323a, str).delete();
    }
}
