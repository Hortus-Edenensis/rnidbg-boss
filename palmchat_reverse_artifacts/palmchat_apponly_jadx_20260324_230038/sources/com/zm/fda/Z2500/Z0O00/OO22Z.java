package com.zm.fda.Z2500.Z0O00;

import android.content.Context;
import android.text.TextUtils;
import com.zm.fda.O52OZ.Z25O0;
import com.zm.fda.Z0O00.Z2500.ZZ00Z;
import com.zm.fda.Z2500.Z0O00.OO22Z;
import com.zm.fda.Z2500.Z200O.O022Z;
import com.zm.fda.utils.EventLog;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public static final String k = "fda_crash_CStore";
    public File e;
    public File f;
    public File g;
    public File h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16686a = O022Z.g;
    public final String b = "FDA-EXCEPTION";
    public final String c = "exception_";
    public final String d = "LOG-";
    public FilenameFilter i = new FilenameFilter() { // from class: t44
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return this.f20901a.a(file, str);
        }
    };
    public Comparator<File> j = new Comparator() { // from class: x44
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return OO22Z.a((File) obj, (File) obj2);
        }
    };

    public OO22Z(Context context) {
        if (context != null) {
            this.e = context.getFilesDir();
        }
        if (this.e != null) {
            this.f = new File(this.e, "FDA-EXCEPTION");
            this.g = new File(this.e, O022Z.g);
            if (!this.f.exists()) {
                this.f.mkdir();
            }
            if (this.g.exists()) {
                return;
            }
            this.g.mkdir();
        }
    }

    private String b() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", new Locale("en")).format(calendar.getTime());
            EventLog.d("currentTimeString", "str:", str);
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public synchronized File[] c() {
        File file = this.g;
        if (file == null) {
            return null;
        }
        try {
            File[] fileArrListFiles = file.listFiles(this.i);
            if (fileArrListFiles != null) {
                Arrays.sort(fileArrListFiles, this.j);
            }
            return fileArrListFiles;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized File[] d() {
        File file = this.f;
        if (file == null) {
            return null;
        }
        try {
            File[] fileArrListFiles = file.listFiles(this.i);
            if (fileArrListFiles != null) {
                Arrays.sort(fileArrListFiles, this.j);
            }
            return fileArrListFiles;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized File[] e() {
        a();
        File file = this.h;
        if (file == null) {
            return null;
        }
        try {
            File[] fileArrListFiles = file.listFiles(this.i);
            if (fileArrListFiles != null) {
                Arrays.sort(fileArrListFiles, this.j);
            }
            return fileArrListFiles;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(File file, String str) {
        return str.startsWith("LOG-");
    }

    public static /* synthetic */ int a(File file, File file2) {
        if (file.lastModified() > file2.lastModified()) {
            return -1;
        }
        return file.lastModified() == file2.lastModified() ? 0 : 1;
    }

    public synchronized boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            return file.delete();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public synchronized void a(ZZ00Z zz00z, int i) {
        File file;
        EventLog.d(k, "storeCrashInfoByBean");
        if (zz00z == null) {
            return;
        }
        a();
        String str = (i != 1 || (file = this.h) == null) ? null : String.format("%s%s%s%s", file.getAbsolutePath(), File.separator, "LOG-", b());
        JSONObject jSONObjectA = zz00z.a();
        if (jSONObjectA != null && str != null) {
            Z25O0.a(str, com.zm.fda.OOZ20.Z0225.O022Z.c(jSONObjectA.toString().getBytes()));
            EventLog.d(k, "fda: write file type:", Integer.valueOf(i), " path:", str, " msg:", jSONObjectA);
        }
    }

    public synchronized void a(byte[] bArr, int i) {
        File file;
        File file2;
        EventLog.d(k, "storeCrashInfo");
        if (bArr == null) {
            return;
        }
        String absolutePath = "";
        if (i == 1 && (file2 = this.f) != null) {
            absolutePath = file2.getAbsolutePath();
        } else if (i == 2 && (file = this.g) != null) {
            absolutePath = file.getAbsolutePath();
        }
        if (TextUtils.isEmpty(absolutePath)) {
            return;
        }
        String str = String.format("%s%s%s%s", absolutePath, File.separator, "LOG-", b());
        Z25O0.a(str, bArr);
        EventLog.d(k, "tianping : write file type:", Integer.valueOf(i), " path:", str);
    }

    private void a() {
        if (this.e != null) {
            File file = new File(this.e, "exception_");
            this.h = file;
            if (file.exists()) {
                return;
            }
            this.h.mkdir();
        }
    }
}
