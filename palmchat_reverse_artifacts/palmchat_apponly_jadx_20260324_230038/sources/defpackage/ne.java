package defpackage;

import android.content.Context;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ne {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f19496a;
    public FilenameFilter b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("log-");
        }
    }

    public ne(Context context, String str) {
        if (str != null) {
            this.f19496a = new File(context.getFilesDir(), "anr_" + str);
        } else {
            this.f19496a = new File(context.getFilesDir(), LogType.ANR_TYPE);
        }
        if (this.f19496a.exists()) {
            return;
        }
        this.f19496a.mkdir();
    }

    public static /* synthetic */ int d(File file, File file2) {
        if (file.lastModified() > file2.lastModified()) {
            return -1;
        }
        return file.lastModified() == file2.lastModified() ? 0 : 1;
    }

    public synchronized boolean b(String str) {
        return un.c(String.format("%s%s%s%s", this.f19496a.getAbsolutePath(), File.separator, "log-", sn.b("yyyyMMdd-HHmmss")), str, "UTF-8");
    }

    public synchronized File[] c() {
        File[] fileArrListFiles;
        fileArrListFiles = this.f19496a.listFiles(this.b);
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: me
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ne.d((File) obj, (File) obj2);
                }
            });
        }
        return fileArrListFiles;
    }

    public synchronized boolean e(String str) {
        return new File(this.f19496a, str).delete();
    }
}
