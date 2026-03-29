package com.baidu.b.e;

import android.content.Context;
import com.baidu.b.c.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3337a;
    private C0060a b;

    /* JADX INFO: renamed from: com.baidu.b.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public final class C0060a {
        private File b;
        private String c;
        private C0060a d;
        private boolean e = true;

        public C0060a(File file) {
            this.b = file;
            this.c = file.getName();
        }

        public C0060a a(File file) {
            if (this.e) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0060a c0060aD = this;
            do {
                arrayList.add(c0060aD.c());
                c0060aD = c0060aD.d();
            } while (c0060aD != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return a.this.new C0060a(file);
        }

        public File b() {
            File file = this.b;
            if (file != null) {
                return file;
            }
            File file2 = this.d == null ? new File(a.this.a(), this.c) : new File(this.d.b(), this.c);
            this.b = file2;
            return file2;
        }

        public String c() {
            return this.c;
        }

        public C0060a d() {
            return this.d;
        }

        public C0060a(String str, C0060a c0060a) {
            this.c = str;
            this.d = c0060a;
        }

        public C0060a a(String str) {
            return a.this.new C0060a(str, this);
        }

        public String a(String str, boolean z) {
            return a.a(b(), str, "UTF-8", z);
        }

        public void a() {
            b().mkdirs();
        }

        public boolean a(String str, String str2, boolean z) {
            return a.a(b(), str, str2, "UTF-8", z);
        }
    }

    public a(Context context) {
        this.f3337a = context;
        c().mkdirs();
    }

    private File c() {
        return new File(a(), ".cesium");
    }

    public File a() {
        return new File(this.f3337a.getApplicationInfo().dataDir);
    }

    public synchronized C0060a b() {
        if (this.b == null) {
            this.b = new C0060a(".cesium", null);
        }
        return this.b;
    }

    public static String a(File file, String str, String str2, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        a(file);
        File file2 = new File(file, str);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                fileInputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                th = th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (z) {
                    byteArray = new c().b(byteArray);
                }
                String str3 = new String(byteArray, str2);
                com.baidu.b.f.c.a(fileInputStream);
                com.baidu.b.f.c.a(byteArrayOutputStream2);
                return str3;
            } catch (Exception unused2) {
                byteArrayOutputStream = byteArrayOutputStream2;
                com.baidu.b.f.c.a(fileInputStream);
                com.baidu.b.f.c.a(byteArrayOutputStream);
                return "";
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                com.baidu.b.f.c.a(fileInputStream);
                com.baidu.b.f.c.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void a(File file) {
        file.mkdirs();
    }

    public static boolean a(File file, String str, String str2, String str3, boolean z) throws Throwable {
        FileOutputStream fileOutputStream;
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (z) {
                fileOutputStream.write(new c().a(str2.getBytes()));
            } else {
                fileOutputStream.write(str2.getBytes(str3));
            }
            com.baidu.b.f.c.a(fileOutputStream);
            return true;
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            com.baidu.b.f.c.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.b.f.c.a(fileOutputStream2);
            throw th;
        }
    }
}
