package defpackage;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class l77 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18925a;

        public a(String str) {
            this.f18925a = str;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            if (!TextUtils.isEmpty(str)) {
                boolean z = str.endsWith(".dog3") || str.endsWith(".dog1") || str.endsWith(".dog2");
                boolean z2 = TextUtils.isEmpty(this.f18925a) || str.startsWith(this.f18925a);
                if (z && z2) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            return file.lastModified() <= file2.lastModified() ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(int i, File file);

        void a(int i, String str);
    }

    public static List<File> a(long j, long j2, String str, String str2) {
        long time;
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
        try {
            time = simpleDateFormat.parse(simpleDateFormat.format(new Date(j))).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            time = j;
        }
        File fileA = ae7.a(str);
        if (fileA != null && (fileArrListFiles = fileA.listFiles(new a(str2))) != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                try {
                    String[] strArrSplit = file.getName().split("\\.")[0].split("_");
                    long time2 = simpleDateFormat.parse(strArrSplit[strArrSplit.length - 4] + "-" + strArrSplit[strArrSplit.length - 3] + "-" + strArrSplit[strArrSplit.length - 2] + "-" + strArrSplit[strArrSplit.length - 1]).getTime();
                    if (j <= 0 || j2 <= 0 || (time2 >= time && time2 <= j2)) {
                        arrayList.add(file);
                    }
                } catch (Exception e2) {
                    if (k17.k()) {
                        e2.printStackTrace();
                    }
                }
            }
            Collections.sort(arrayList, new b());
        }
        return arrayList;
    }

    public static void b(long j, long j2, b37 b37Var, String str, String str2, c cVar) {
        List<File> listA = a(j, j2, b37Var.o(), b37Var.r());
        if (listA.size() == 0) {
            cVar.a(-101, "no match file");
            return;
        }
        e("opluslog_" + str2 + "_" + UUID.randomUUID() + ".zip", str, listA, cVar);
    }

    public static void c(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                c(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static void d(String str) {
        File fileA = ae7.a(str);
        if (fileA == null) {
            return;
        }
        c(fileA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a4, code lost:
    
        if (r14 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
    
        if (r11.length() <= 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
    
        r14.a(r4, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
    
        r14.a(-105, "zip file is empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ba, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(String str, String str2, List<File> list, c cVar) {
        FileInputStream fileInputStream;
        File fileA = ae7.a(str2);
        if (fileA == null || !fileA.isDirectory() || list == null || list.size() == 0) {
            if (cVar != null) {
                cVar.a(-102, "");
                return;
            }
            return;
        }
        File fileC = ae7.c(str2 + File.separator + str);
        if (fileC == null) {
            if (cVar != null) {
                cVar.a(-103, "");
                return;
            }
            return;
        }
        byte[] bArr = new byte[1024];
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileC);
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                try {
                    Iterator<File> it = list.iterator();
                    int i = 100;
                    long length = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File next = it.next();
                        length += next.length();
                        if (length >= 3145728) {
                            i = 101;
                            break;
                        }
                        try {
                            fileInputStream = new FileInputStream(next);
                        } catch (Exception unused) {
                            i = 102;
                        }
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(next.getName()));
                            while (true) {
                                int i2 = fileInputStream.read(bArr);
                                if (i2 <= 0) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, i2);
                                }
                            }
                            zipOutputStream.closeEntry();
                            fileInputStream.close();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            if (cVar != null) {
                cVar.a(-104, e.toString());
            }
        }
    }
}
