package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.bb;
import com.xiaomi.push.bl;
import com.xiaomi.push.h;
import com.xiaomi.push.w;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class a implements IEventProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f11343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f24a;

    public a(Context context) {
        a(context);
    }

    public void a(Context context) {
        this.f11343a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() throws Throwable {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map = this.f24a;
        if (map == null) {
            return;
        }
        if (map.size() > 0) {
            Iterator<String> it = this.f24a.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f24a.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m87a(aVarArr);
                }
            }
        }
        this.f24a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] bArrA;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.f11343a).m83a().isEventEncrypted()) {
                return bb.b(bArr);
            }
            String strA = bl.a(this.f11343a);
            if (!TextUtils.isEmpty(strA) && (bArrA = bl.a(strA)) != null && bArrA.length > 0) {
                try {
                    return bb.b(Base64.decode(h.a(bArrA, bArr), 2));
                } catch (InvalidAlgorithmParameterException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                } catch (InvalidKeyException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                } catch (NoSuchAlgorithmException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                } catch (BadPaddingException e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                } catch (IllegalBlockSizeException e5) {
                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                } catch (NoSuchPaddingException e6) {
                    com.xiaomi.channel.commonutils.logger.b.a(e6);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map) {
        this.f24a = map;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] bArrA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.a(this.f11343a).m83a().isEventEncrypted()) {
            return bb.m202a(str);
        }
        String strA = bl.a(this.f11343a);
        byte[] bArrM202a = bb.m202a(str);
        if (!TextUtils.isEmpty(strA) && bArrM202a != null && bArrM202a.length > 1 && (bArrA = bl.a(strA)) != null) {
            try {
                if (bArrA.length > 1) {
                    return h.b(bArrA, Base64.encode(bArrM202a, 2));
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return null;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    public void a(List<String> list) {
        bl.a(this.f11343a, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037 A[PHI: r2 r3 r4
      0x0037: PHI (r2v11 java.nio.channels.FileLock) = (r2v4 java.nio.channels.FileLock), (r2v2 java.nio.channels.FileLock), (r2v2 java.nio.channels.FileLock) binds: [B:65:0x0109, B:32:0x0092, B:19:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0037: PHI (r3v15 java.io.RandomAccessFile) = (r3v4 java.io.RandomAccessFile), (r3v2 java.io.RandomAccessFile), (r3v2 java.io.RandomAccessFile) binds: [B:65:0x0109, B:32:0x0092, B:19:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0037: PHI (r4v9 java.io.File) = (r4v3 java.io.File), (r4v1 java.io.File), (r4v1 java.io.File) binds: [B:65:0x0109, B:32:0x0092, B:19:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.xiaomi.clientreport.processor.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() throws Throwable {
        RandomAccessFile randomAccessFile;
        bl.a(this.f11343a, "event", "eventUploading");
        File[] fileArrM210a = bl.m210a(this.f11343a, "eventUploading");
        if (fileArrM210a == null || fileArrM210a.length <= 0) {
            return;
        }
        FileLock fileLockLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        for (File file2 : fileArrM210a) {
            if (file2 == null) {
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                w.a(randomAccessFile2);
                if (file != null) {
                    file.delete();
                }
            } else {
                try {
                    try {
                        if (file2.length() > 5242880) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                            a(file2.getName(), Formatter.formatFileSize(this.f11343a, file2.length()));
                            file2.delete();
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                }
                            }
                            w.a(randomAccessFile2);
                            if (file != null) {
                            }
                        } else {
                            String absolutePath = file2.getAbsolutePath();
                            File file3 = new File(absolutePath + ".lock");
                            try {
                                w.m789a(file3);
                                randomAccessFile = new RandomAccessFile(file3, "rw");
                            } catch (Exception e3) {
                                e = e3;
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                fileLockLock = randomAccessFile.getChannel().lock();
                                a(a(absolutePath));
                                file2.delete();
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e4) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                }
                                w.a(randomAccessFile);
                                file3.delete();
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                            } catch (Exception e5) {
                                e = e5;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e6) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e6);
                                    }
                                }
                                w.a(randomAccessFile2);
                                if (file != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e7) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e7);
                                    }
                                }
                                w.a(randomAccessFile2);
                                if (file != null) {
                                    file.delete();
                                    throw th;
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            }
        }
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File file = new File(this.f11343a.getFilesDir(), "event");
        String str = file.getAbsolutePath() + File.separator + a(aVar);
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (bl.m209a(this.f11343a, str2)) {
                return str2;
            }
        }
        return null;
    }

    private void a(String str, String str2) {
        EventClientReport eventClientReportA = com.xiaomi.clientreport.manager.a.a(this.f11343a).a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventClientReportA.toJsonString());
        a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> a(String str) throws Throwable {
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                while (true) {
                    try {
                        int i = fileInputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        if (i != 4) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        if (y.a(bArr) != -573785174) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        int i2 = fileInputStream2.read(bArr2);
                        if (i2 == -1) {
                            break;
                        }
                        if (i2 != 4) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer error");
                            break;
                        }
                        int iA = y.a(bArr2);
                        if (iA < 1 || iA > 4096) {
                            break;
                        }
                        byte[] bArr3 = new byte[iA];
                        if (fileInputStream2.read(bArr3) != iA) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause buffer size not equal length");
                            break;
                        }
                        String strBytesToString = bytesToString(bArr3);
                        if (!TextUtils.isEmpty(strBytesToString)) {
                            arrayList.add(strBytesToString);
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        w.a((Closeable) fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        w.a((Closeable) fileInputStream);
                        throw th;
                    }
                }
                w.a((Closeable) fileInputStream2);
            } catch (Exception e2) {
                e = e2;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m87a(com.xiaomi.clientreport.data.a[] aVarArr) throws Throwable {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0) {
                return;
            }
        } while (aVarArr[0] != null);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) throws Throwable {
        FileLock fileLockLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        int i;
        int i2;
        String strB = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            File file = new File(strB + ".lock");
            w.m789a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
            } catch (Exception e) {
                e = e;
                fileLockLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileLockLock = null;
            }
        } catch (Exception e2) {
            e = e2;
            fileLockLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileLockLock = null;
            randomAccessFile = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(strB), true));
            try {
                try {
                    i2 = 0;
                } catch (Exception e3) {
                    e = e3;
                    com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                w.a(bufferedOutputStream2);
                a(randomAccessFile, fileLockLock);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            w.a(bufferedOutputStream2);
            a(randomAccessFile, fileLockLock);
            throw th;
        }
        for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
            if (aVar != null) {
                byte[] bArrStringToBytes = stringToBytes(aVar.toJsonString());
                if (bArrStringToBytes != null && bArrStringToBytes.length >= 1 && bArrStringToBytes.length <= 4096) {
                    if (!bl.m209a(this.f11343a, strB)) {
                        int length = aVarArr.length - i2;
                        com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                        System.arraycopy(aVarArr, i2, aVarArr2, 0, length);
                        w.a(bufferedOutputStream);
                        a(randomAccessFile, fileLockLock);
                        return aVarArr2;
                    }
                    bufferedOutputStream.write(y.a(-573785174));
                    bufferedOutputStream.write(y.a(bArrStringToBytes.length));
                    bufferedOutputStream.write(bArrStringToBytes);
                    bufferedOutputStream.flush();
                    i2++;
                    w.a(bufferedOutputStream);
                    a(randomAccessFile, fileLockLock);
                    return null;
                }
                com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
            }
        }
        w.a(bufferedOutputStream);
        a(randomAccessFile, fileLockLock);
        return null;
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        w.a(randomAccessFile);
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo86a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f24a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String strA = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f24a.get(strA);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f24a.put(strA, arrayList);
        }
    }
}
