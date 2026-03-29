package cn.fly.verify;

import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.fq;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2248a = new Object();
    private static final Object b = new Object();
    private volatile HashSet<String> c = new HashSet<>();
    private File d;
    private int e;
    private String f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str);

        boolean a(fq.b bVar);
    }

    public eo(String str, String str2, int i) {
        this.e = i;
        if (str2 == null) {
            str2 = com.igexin.push.core.b.m;
        } else if (TextUtils.isDigitsOnly(str2)) {
            str2 = str + str2;
        }
        this.f = str2;
        File fileB = fz.b(ax.f(), str);
        this.d = fileB;
        if (fileB.isDirectory()) {
            return;
        }
        this.d.mkdirs();
    }

    private File a(boolean z) {
        File file;
        File[] fileArrListFiles = this.d.listFiles();
        int i = 5;
        int i2 = 3;
        char c = 2;
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            file = new File(this.d, a(this.f, "_", 1, "_", 0));
        } else {
            int length = fileArrListFiles.length;
            int i3 = 0;
            int i4 = 1;
            while (i3 < length) {
                File file2 = fileArrListFiles[i3];
                String name = file2.getName();
                if (name.startsWith(this.f)) {
                    String[] strArrSplit = name.split("_");
                    if (!z && strArrSplit.length == i2) {
                        try {
                            int i5 = Integer.parseInt(strArrSplit[c]);
                            if (i5 < this.e && !b(name)) {
                                File file3 = this.d;
                                Object[] objArr = new Object[i];
                                objArr[0] = this.f;
                                objArr[1] = "_";
                                objArr[2] = Integer.valueOf(i4);
                                objArr[3] = "_";
                                objArr[4] = Integer.valueOf(i5 + 1);
                                File file4 = new File(file3, a(objArr));
                                return file2.renameTo(file4) ? file4 : file2;
                            }
                        } catch (Throwable th) {
                            en.a().a(th);
                        }
                    }
                    if (strArrSplit.length > 1) {
                        try {
                            if (Integer.parseInt(strArrSplit[1]) == i4) {
                                i4++;
                            }
                        } catch (Throwable th2) {
                            en.a().a(th2);
                        }
                    }
                }
                i3++;
                i = 5;
                i2 = 3;
                c = 2;
            }
            file = new File(this.d, a(this.f, "_", Integer.valueOf(i4), "_", 0));
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                return true;
            }
            this.c.add(str);
            return false;
        }
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }

    public void a(long j) {
        synchronized (b) {
            File[] fileArrListFiles = this.d.listFiles(new FilenameFilter() { // from class: cn.fly.verify.eo.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return !TextUtils.isEmpty(str) && str.startsWith(eo.this.f);
                }
            });
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                long length = 0;
                for (File file : fileArrListFiles) {
                    length += file.length();
                }
                if (length >= j) {
                    for (File file2 : fileArrListFiles) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public void a(final a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (b) {
            final File[] fileArrListFiles = this.d.listFiles(new FilenameFilter() { // from class: cn.fly.verify.eo.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return !TextUtils.isEmpty(str) && str.startsWith(eo.this.f);
                }
            });
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                fq.a(ax.g()).h().j().i().C().a(new fq.a() { // from class: cn.fly.verify.eo.2
                    @Override // cn.fly.verify.fq.a
                    public void a(fq.b bVar) {
                        BufferedReader bufferedReader;
                        for (File file : fileArrListFiles) {
                            String name = file.getName();
                            if (!eo.this.b(name)) {
                                FileReader fileReader = null;
                                try {
                                    FileReader fileReader2 = new FileReader(file);
                                    try {
                                        bufferedReader = new BufferedReader(fileReader2);
                                        while (true) {
                                            try {
                                                String line = bufferedReader.readLine();
                                                if (line == null) {
                                                    break;
                                                } else {
                                                    aVar.a(new String(Base64.decode(line, 2), "utf-8"));
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                fileReader = fileReader2;
                                                try {
                                                    en.a().a(th);
                                                    eg.a(bufferedReader, fileReader);
                                                } catch (Throwable th2) {
                                                    eg.a(bufferedReader, fileReader);
                                                    eo.this.c(name);
                                                    throw th2;
                                                }
                                            }
                                        }
                                        if (aVar.a(bVar)) {
                                            en.a().a("[LGSM] D l", new Object[0]);
                                            file.delete();
                                        }
                                        eg.a(bufferedReader, fileReader2);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedReader = null;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    bufferedReader = null;
                                }
                                eo.this.c(name);
                            }
                        }
                    }
                });
            }
        }
    }

    public void a(String str) throws Throwable {
        a(str, false);
    }

    public void a(String str, boolean z) throws Throwable {
        FileWriter fileWriter;
        String name;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strEncodeToString = Base64.encodeToString(str.getBytes("utf-8"), 2);
        if (TextUtils.isEmpty(strEncodeToString)) {
            return;
        }
        synchronized (f2248a) {
            File fileA = a(z);
            BufferedWriter bufferedWriter = null;
            try {
                fileWriter = new FileWriter(fileA, true);
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter2.newLine();
                        bufferedWriter2.write(strEncodeToString);
                        eg.a(bufferedWriter2, fileWriter);
                        name = fileA.getName();
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        try {
                            en.a().a(th);
                            eg.a(bufferedWriter, fileWriter);
                            name = fileA.getName();
                        } catch (Throwable th2) {
                            eg.a(bufferedWriter, fileWriter);
                            c(fileA.getName());
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                fileWriter = null;
            }
            c(name);
        }
    }
}
