package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.MotionEventCompat;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2611a;
    private String c;
    private bj b = null;
    private final int d = 128;

    public ad(Context context, boolean z, aw awVar) {
        boolean zExists;
        this.c = "/sdcard/Amap/RMap";
        this.f2611a = context;
        if (awVar == null) {
            return;
        }
        if (z) {
            this.c = context.getFilesDir().getPath();
        } else {
            String str = awVar.m;
            if (str == null || str.equals("")) {
                zExists = false;
            } else {
                File file = new File(awVar.m);
                zExists = file.exists();
                zExists = zExists ? zExists : file.mkdirs();
                this.c = awVar.m;
            }
            if (!zExists) {
                this.c = a(this.f2611a, awVar);
            }
        }
        bp.a();
        bp.a("cache_path", this.c);
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)};
    }

    private static int b(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[2] << 16) & 16711680);
    }

    private static boolean c(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    private static boolean d(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            boolean zD = true;
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (!fileArrListFiles[i].isFile()) {
                    zD = d(fileArrListFiles[i].getAbsolutePath());
                    if (!zD) {
                        break;
                    }
                } else {
                    zD = c(fileArrListFiles[i].getAbsolutePath());
                    if (!zD) {
                        break;
                    }
                }
            }
            if (zD && file.delete()) {
                return true;
            }
        }
        return false;
    }

    private static String a(Context context, aw awVar) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getFilesDir().getPath();
        }
        File file = new File(ct.b(context), awVar.b);
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + "/";
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return c(str);
        }
        return d(str);
    }

    private String[] a(cb cbVar, boolean z) {
        int i = (cbVar.b / 128) / 10;
        int i2 = (cbVar.c / 128) / 10;
        String[] strArr = new String[2];
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append("/");
            sb.append(cbVar.d);
            sb.append("/");
            sb.append(i);
            sb.append("/");
            sb.append(i2);
            sb.append("/");
            if (!z) {
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            sb.append(cbVar.b());
            strArr[0] = sb.toString() + ".idx";
            strArr[1] = sb.toString() + ".dat";
        } catch (Throwable th) {
            ct.a(th, "CachManager", "getCachFileName");
        }
        return strArr;
    }

    public final void a(bj bjVar) {
        this.b = bjVar;
    }

    private static void a(byte[] bArr) {
        if (bArr == null || bArr.length != 4) {
            return;
        }
        byte b = bArr[0];
        bArr[0] = bArr[3];
        bArr[3] = b;
        byte b2 = bArr[1];
        bArr[1] = bArr[2];
        bArr[2] = b2;
    }

    private static int a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    public final int a(cb cbVar) {
        String[] strArrA;
        int iA;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        try {
            strArrA = a(cbVar, true);
        } catch (Throwable th) {
            ct.a(th, "CachManager", "getTileFromCach");
            return -1;
        }
        if (!strArrA[0].equals("") && !Arrays.equals(strArrA, new String[2])) {
            File file = new File(strArrA[0]);
            if (!file.exists() || (iA = a(cbVar.b, cbVar.c)) < 0) {
                return -1;
            }
            try {
                randomAccessFile = new RandomAccessFile(file, t.k);
            } catch (FileNotFoundException e) {
                ct.a(e, "CachManager", "getTileFromCach");
                randomAccessFile = null;
            }
            if (randomAccessFile == null) {
                return -1;
            }
            try {
                randomAccessFile.seek(iA * 4);
            } catch (IOException e2) {
                ct.a(e2, "CachManager", "getTileFromCach");
            }
            byte[] bArr2 = new byte[4];
            try {
                randomAccessFile.read(bArr2, 0, 4);
            } catch (IOException e3) {
                ct.a(e3, "CachManager", "getTileFromCach");
            }
            a(bArr2);
            int iB = b(bArr2);
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                ct.a(th2, "CachManager", "getTileFromCach");
            }
            if (iB < 0) {
                return -1;
            }
            File file2 = new File(strArrA[1]);
            if (!file2.exists()) {
                return -1;
            }
            try {
                randomAccessFile2 = new RandomAccessFile(file2, t.k);
            } catch (FileNotFoundException e4) {
                ct.a(e4, "CachManager", "getTileFromCach");
                randomAccessFile2 = null;
            }
            if (randomAccessFile2 == null) {
                return -1;
            }
            try {
                randomAccessFile2.seek(iB);
            } catch (IOException e5) {
                ct.a(e5, "CachManager", "getTileFromCach");
            }
            try {
                randomAccessFile2.read(bArr2, 0, 4);
            } catch (IOException e6) {
                ct.a(e6, "CachManager", "getTileFromCach");
            }
            a(bArr2);
            int iB2 = b(bArr2);
            if (iB2 > 0 && iB2 <= 204800) {
                try {
                    bArr = new byte[iB2];
                    try {
                        randomAccessFile2.read(bArr, 0, iB2);
                    } catch (Throwable th3) {
                        th = th3;
                        ct.a(th, "CachManager", "getTileFromCach");
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bArr = null;
                }
                try {
                    randomAccessFile2.close();
                } catch (IOException e7) {
                    ct.a(e7, "CachManager", "getTileFromCach");
                }
                bj bjVar = this.b;
                if (bjVar == null) {
                    return -1;
                }
                return bjVar.a(bArr, null, true, cbVar.b());
            }
            try {
                randomAccessFile2.close();
            } catch (IOException e8) {
                ct.a(e8, "CachManager", "getTileFromCach");
            }
            ct.a(th, "CachManager", "getTileFromCach");
            return -1;
        }
        return -1;
    }

    public final synchronized boolean a(byte[] bArr, cb cbVar) {
        String[] strArrA;
        boolean zCreateNewFile;
        RandomAccessFile randomAccessFile;
        long length;
        long length2;
        boolean zCreateNewFile2;
        if (bArr == null) {
            return false;
        }
        int length3 = bArr.length;
        if (length3 <= 0) {
            return false;
        }
        try {
            strArrA = a(cbVar, false);
        } catch (Throwable th) {
            ct.a(th, "CachManager", "addDataToCach");
        }
        if (!strArrA[0].equals("") && !Arrays.equals(strArrA, new String[2])) {
            File file = new File(strArrA[1]);
            if (!file.exists()) {
                try {
                    zCreateNewFile = file.createNewFile();
                } catch (Throwable th2) {
                    ct.a(th2, "CachManager", "addDataToCach");
                    zCreateNewFile = false;
                }
                if (!zCreateNewFile) {
                    return false;
                }
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "rws");
            } catch (Throwable th3) {
                ct.a(th3, "CachManager", "addDataToCach");
                randomAccessFile = null;
            }
            if (randomAccessFile == null) {
                return false;
            }
            byte[] bArrA = a(length3);
            a(bArrA);
            try {
                length = randomAccessFile.length();
            } catch (Throwable th4) {
                ct.a(th4, "CachManager", "addDataToCach");
                length = 0;
            }
            try {
                randomAccessFile.seek(length);
            } catch (Throwable th5) {
                ct.a(th5, "CachManager", "addDataToCach");
            }
            try {
                randomAccessFile.write(bArrA);
            } catch (Throwable th6) {
                ct.a(th6, "CachManager", "addDataToCach");
            }
            try {
                randomAccessFile.write(bArr);
            } catch (Throwable th7) {
                ct.a(th7, "CachManager", "addDataToCach");
            }
            try {
                randomAccessFile.close();
            } catch (Throwable th8) {
                ct.a(th8, "CachManager", "addDataToCach");
            }
            File file2 = new File(strArrA[0]);
            if (!file2.exists()) {
                try {
                    zCreateNewFile2 = file2.createNewFile();
                } catch (IOException e) {
                    ct.a(e, "CachManager", "addDataToCach");
                    zCreateNewFile2 = false;
                }
                if (!zCreateNewFile2) {
                    return false;
                }
            }
            try {
                randomAccessFile2 = new RandomAccessFile(file2, "rws");
            } catch (Throwable th9) {
                ct.a(th9, "CachManager", "addDataToCach");
            }
            if (randomAccessFile2 == null) {
                return false;
            }
            try {
                length2 = randomAccessFile2.length();
            } catch (Throwable th10) {
                ct.a(th10, "CachManager", "addDataToCach");
                length2 = 0;
            }
            if (length2 == 0) {
                byte[] bArr2 = new byte[65536];
                Arrays.fill(bArr2, (byte) -1);
                try {
                    randomAccessFile2.write(bArr2);
                } catch (Throwable th11) {
                    ct.a(th11, "CachManager", "addDataToCach");
                }
            }
            if (a(cbVar.b, cbVar.c) < 0) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th12) {
                    ct.a(th12, "CachManager", "addDataToCach");
                }
                return false;
            }
            try {
                randomAccessFile2.seek(r14 * 4);
            } catch (Throwable th13) {
                ct.a(th13, "CachManager", "addDataToCach");
            }
            byte[] bArrA2 = a((int) length);
            a(bArrA2);
            try {
                randomAccessFile2.write(bArrA2);
            } catch (Throwable th14) {
                ct.a(th14, "CachManager", "addDataToCach");
            }
            try {
                randomAccessFile2.close();
            } catch (Throwable th15) {
                ct.a(th15, "CachManager", "addDataToCach");
            }
            return true;
        }
        return false;
    }

    public static void a(final String str) {
        new Thread(new Runnable() { // from class: com.amap.api.col.2sl.ad.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ad.b(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).start();
    }
}
