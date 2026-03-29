package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f11792a = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private RandomAccessFile f1040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f1041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private FileLock f1042a;

    private t(Context context) {
        this.f1039a = context;
    }

    public static t a(Context context, File file) throws IOException {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = f11792a;
        if (!set.add(str)) {
            throw new IOException("abtain lock failure");
        }
        t tVar = new t(context);
        tVar.f1041a = str;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            tVar.f1040a = randomAccessFile;
            tVar.f1042a = randomAccessFile.getChannel().lock();
            com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + tVar.f1042a);
            if (tVar.f1042a == null) {
                RandomAccessFile randomAccessFile2 = tVar.f1040a;
                if (randomAccessFile2 != null) {
                    w.a(randomAccessFile2);
                }
                set.remove(tVar.f1041a);
            }
            return tVar;
        } catch (Throwable th) {
            if (tVar.f1042a == null) {
                RandomAccessFile randomAccessFile3 = tVar.f1040a;
                if (randomAccessFile3 != null) {
                    w.a(randomAccessFile3);
                }
                f11792a.remove(tVar.f1041a);
            }
            throw th;
        }
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1042a);
        FileLock fileLock = this.f1042a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f1042a.release();
            } catch (IOException unused) {
            }
            this.f1042a = null;
        }
        RandomAccessFile randomAccessFile = this.f1040a;
        if (randomAccessFile != null) {
            w.a(randomAccessFile);
        }
        f11792a.remove(this.f1041a);
    }
}
