package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dn extends ae.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.ah f270a;

    public dn(Context context) {
        this.f11510a = context;
        this.f269a = context.getSharedPreferences("mipush_extra", 0);
        this.f270a = com.xiaomi.push.service.ah.a(context);
    }

    private boolean b() {
        if (!this.f270a.a(gk.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f269a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f270a.a(gk.Upload3GFrequency.a(), 432000)));
    }

    private boolean c() {
        if (!this.f270a.a(gk.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f269a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f270a.a(gk.Upload4GFrequency.a(), 259200)));
    }

    @Override // com.xiaomi.push.ae.a
    /* JADX INFO: renamed from: a */
    public String mo207a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f11510a.getFilesDir(), "push_cdata.data");
        if (!au.c(this.f11510a)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!m298a() && file.exists()) {
            List<gn> listA = a(file);
            if (!z.a(listA)) {
                int size = listA.size();
                if (size > 4000) {
                    listA = listA.subList(size - 4000, size);
                }
                gy gyVar = new gy();
                gyVar.a(listA);
                byte[] bArrA = w.a(hp.a(gyVar));
                he heVar = new he("-1", false);
                heVar.c(gp.DataCollection.f535a);
                heVar.a(bArrA);
                df dfVarM293a = dg.a().m293a();
                if (dfVarM293a != null) {
                    dfVarM293a.a(heVar, gf.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m298a() {
        if (au.d(this.f11510a)) {
            return false;
        }
        if ((au.f(this.f11510a) || au.e(this.f11510a)) && !c()) {
            return true;
        }
        return (au.g(this.f11510a) && !b()) || au.h(this.f11510a);
    }

    private void a() {
        SharedPreferences.Editor editorEdit = this.f269a.edit();
        editorEdit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        editorEdit.commit();
    }

    private List<gn> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        df dfVarM293a = dg.a().m293a();
        String strA = dfVarM293a == null ? "" : dfVarM293a.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dj.f11506a) {
            try {
                File file2 = new File(this.f11510a.getFilesDir(), "push_cdata.lock");
                w.m789a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock fileLockLock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int iA = y.a(bArr);
                                byte[] bArr2 = new byte[iA];
                                if (fileInputStream.read(bArr2) != iA) {
                                    break;
                                }
                                byte[] bArrA = di.a(strA, bArr2);
                                if (bArrA != null && bArrA.length != 0) {
                                    gn gnVar = new gn();
                                    hp.a(gnVar, bArrA);
                                    arrayList.add(gnVar);
                                    a(gnVar);
                                }
                            } catch (Exception unused) {
                                fileLock = fileLockLock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                w.a((Closeable) fileInputStream);
                            } catch (Throwable th) {
                                th = th;
                                fileLock = fileLockLock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                w.a((Closeable) fileInputStream);
                                w.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        w.a((Closeable) fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            w.a(randomAccessFile);
        }
        return arrayList;
    }

    private void a(gn gnVar) {
        if (gnVar.f526a != gh.AppInstallList || gnVar.f527a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f269a.edit();
        editorEdit.putLong("dc_job_result_time_4", gnVar.f525a);
        editorEdit.putString("dc_job_result_4", bb.a(gnVar.f527a));
        editorEdit.commit();
    }
}
