package com.qq.gdt.action.e;

import android.os.Environment;
import android.text.TextUtils;
import com.qq.gdt.action.j.o;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10490a;
    private String b;
    private RandomAccessFile c;
    private FileLock d;

    public h(String str, String str2) {
        this.f10490a = str;
        this.b = str2;
    }

    private boolean c() {
        return (TextUtils.isEmpty(this.f10490a) || TextUtils.isEmpty(this.b)) ? false : true;
    }

    public String a(int i) {
        RandomAccessFile randomAccessFile;
        if (c() && (randomAccessFile = this.c) != null && this.d != null) {
            try {
                if (randomAccessFile.length() <= i) {
                    i = Long.valueOf(this.c.length()).intValue();
                }
                if (i <= 0) {
                    return null;
                }
                byte[] bArr = new byte[i];
                if (this.c.read(bArr, 0, i) == i) {
                    return new String(bArr, 0, i, "UTF-8");
                }
                return null;
            } catch (Throwable th) {
                o.a("read", th);
            }
        }
        return null;
    }

    public void b() {
        try {
            FileLock fileLock = this.d;
            if (fileLock != null) {
                fileLock.release();
                this.d = null;
            }
        } catch (Throwable th) {
            o.a("close", th);
        }
        try {
            RandomAccessFile randomAccessFile = this.c;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.c = null;
            }
        } catch (Throwable th2) {
            o.a("close", th2);
        }
    }

    public boolean a() {
        if (c() && this.c == null && this.d == null) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), this.f10490a);
                File file2 = new File(file, this.b);
                if (!file.exists() && !file.mkdirs()) {
                    return false;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
                this.c = randomAccessFile;
                this.d = randomAccessFile.getChannel().lock();
                if (file2.isFile()) {
                    return true;
                }
                b();
                return false;
            } catch (Throwable th) {
                o.a("open", th);
                b();
            }
        }
        return false;
    }
}
