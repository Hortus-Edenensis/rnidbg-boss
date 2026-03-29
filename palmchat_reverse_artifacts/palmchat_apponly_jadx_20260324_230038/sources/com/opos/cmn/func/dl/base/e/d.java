package com.opos.cmn.func.dl.base.e;

import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f7989a;
    private File b;
    private volatile int c = 0;

    public d(File file, File file2) {
        this.f7989a = file;
        this.b = file2;
    }

    @Override // com.opos.cmn.func.dl.base.e.a
    public final synchronized List<c> a() {
        ArrayList arrayList;
        FileInputStream fileInputStream;
        ArrayList arrayList2;
        arrayList = null;
        closeable = null;
        closeable = null;
        closeable = null;
        Closeable closeable = null;
        arrayList = null;
        if (com.opos.cmn.an.e.b.a.a(this.f7989a) && com.opos.cmn.an.e.b.a.a(this.b)) {
            try {
                fileInputStream = new FileInputStream(this.f7989a);
                try {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                        try {
                            try {
                                int i = dataInputStream.readInt();
                                arrayList2 = new ArrayList(i);
                                for (int i2 = 0; i2 < i; i2++) {
                                    try {
                                        arrayList2.add(new c(i2, dataInputStream.readLong(), dataInputStream.readLong(), dataInputStream.readLong()));
                                    } catch (Exception unused) {
                                        closeable = dataInputStream;
                                        com.opos.cmn.an.f.a.c("ThreadStoreImpl", "read pos file error,delete pos file!");
                                        com.opos.cmn.an.e.b.a.e(this.b);
                                        com.opos.cmn.func.dl.base.i.a.a(closeable, fileInputStream);
                                        arrayList = arrayList2;
                                        return arrayList;
                                    }
                                }
                                com.opos.cmn.func.dl.base.i.a.a(dataInputStream, fileInputStream);
                            } catch (Throwable th) {
                                th = th;
                                closeable = dataInputStream;
                                com.opos.cmn.func.dl.base.i.a.a(closeable, fileInputStream);
                                throw th;
                            }
                        } catch (Exception unused2) {
                            arrayList2 = null;
                        }
                    } catch (Exception unused3) {
                        arrayList2 = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused4) {
                fileInputStream = null;
                arrayList2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    @Override // com.opos.cmn.func.dl.base.e.a
    public final synchronized void a(List<c> list) {
        OutputStream fileOutputStream;
        DataOutputStream dataOutputStream;
        int size;
        if (list != null) {
            if (list.size() > 0) {
                this.c++;
                if (this.c % 25 == 0) {
                    OutputStream outputStream = null;
                    try {
                        size = list.size();
                        com.opos.cmn.func.dl.base.i.a.a(this.f7989a);
                        fileOutputStream = new FileOutputStream(this.f7989a);
                    } catch (Exception e) {
                        e = e;
                        dataOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                    try {
                        dataOutputStream = new DataOutputStream(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        dataOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.opos.cmn.func.dl.base.i.a.a(outputStream, fileOutputStream);
                        throw th;
                    }
                    try {
                        dataOutputStream.writeInt(size);
                        for (int i = 0; i < size; i++) {
                            c cVar = list.get(i);
                            dataOutputStream.writeLong(cVar.b);
                            dataOutputStream.writeLong(cVar.d);
                            dataOutputStream.writeLong(cVar.c);
                        }
                        com.opos.cmn.func.dl.base.i.a.a(dataOutputStream, fileOutputStream);
                    } catch (Exception e3) {
                        e = e3;
                        outputStream = fileOutputStream;
                        try {
                            com.opos.cmn.an.f.a.c("ThreadStoreImpl", "saveThreadInfos ", e);
                            throw new DlException(1004, e);
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = outputStream;
                            outputStream = dataOutputStream;
                            com.opos.cmn.func.dl.base.i.a.a(outputStream, fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = dataOutputStream;
                        com.opos.cmn.func.dl.base.i.a.a(outputStream, fileOutputStream);
                        throw th;
                    }
                }
            }
        }
    }
}
