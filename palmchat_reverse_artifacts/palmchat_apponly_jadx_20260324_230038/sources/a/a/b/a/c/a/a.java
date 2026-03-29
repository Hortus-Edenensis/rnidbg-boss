package a.a.b.a.c.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f1076a = new String[3];
    public static volatile boolean b = false;

    /* JADX WARN: Can't wrap try/catch for region: R(8:(4:192|78|190|79)|(1:81)(5:82|(0)(5:89|90|163|91|95)|129|(1:131)|132)|182|84|88|129|(0)|132) */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x011f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0120, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00df  */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r7v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) throws Throwable {
        String str;
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        Map<Integer, ByteBuffer> mapA;
        byte[][] bArr;
        String[] strArr;
        String[] strArr2;
        int length;
        ?? IsEmpty;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        byte[] bArr2;
        long length2;
        ApplicationInfo applicationInfo;
        if (!b) {
            int[] iArr = {-1721342362, 1903654775, 1903654776};
            ?? r5 = 0;
            str = null;
            str = null;
            str = null;
            str = null;
            str = null;
            String str2 = null;
            try {
                applicationInfo = context.getApplicationInfo();
            } catch (Throwable unused) {
            }
            if (applicationInfo != null) {
                str = applicationInfo.sourceDir;
                if (TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    try {
                        try {
                            randomAccessFile = new RandomAccessFile(file, t.k);
                            try {
                                channel = randomAccessFile.getChannel();
                            } catch (IOException unused2) {
                                channel = null;
                            } catch (Throwable th2) {
                                th = th2;
                                channel = null;
                            }
                        } catch (c unused3) {
                            mapA = null;
                            if (mapA != null) {
                            }
                            if (bArr == null) {
                            }
                            if (strArr == null) {
                            }
                            f1076a = strArr;
                            if (strArr.length >= 2) {
                                IsEmpty = TextUtils.isEmpty(f1076a[1]);
                                try {
                                    if (IsEmpty != 0) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r5 = IsEmpty;
                                }
                            }
                            strArr2 = f1076a;
                            if (strArr2.length >= 3) {
                                length = f1076a[2].length();
                                if (length <= 4) {
                                }
                            }
                            b = true;
                            if (!TextUtils.isEmpty(f1076a[0])) {
                            }
                        }
                    } catch (IOException unused4) {
                        randomAccessFile = null;
                        channel = null;
                    } catch (Throwable th4) {
                        th = th4;
                        randomAccessFile = null;
                        channel = null;
                    }
                    try {
                        mapA = a.a.a.a.a.a.k.b.a(a.a.a.a.a.a.k.b.a(channel).f1077a);
                        try {
                            try {
                                channel.close();
                            } catch (IOException unused5) {
                            }
                        } catch (c | IOException unused6) {
                        }
                    } catch (IOException unused7) {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException unused8) {
                            }
                        }
                        if (randomAccessFile != null) {
                            mapA = null;
                        }
                        mapA = null;
                        if (mapA != null) {
                        }
                        if (bArr == null) {
                        }
                        if (strArr == null) {
                        }
                        f1076a = strArr;
                        if (strArr.length >= 2) {
                        }
                        strArr2 = f1076a;
                        if (strArr2.length >= 3) {
                        }
                        b = true;
                        if (!TextUtils.isEmpty(f1076a[0])) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException unused9) {
                            }
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (IOException unused10) {
                            throw th;
                        }
                    }
                    randomAccessFile.close();
                    if (mapA != null) {
                        bArr = new byte[3][];
                        for (int i = 0; i < 3; i++) {
                            ByteBuffer byteBuffer = mapA.get(Integer.valueOf(iArr[i]));
                            if (byteBuffer != null) {
                                byte[] bArrArray = byteBuffer.array();
                                int iArrayOffset = byteBuffer.arrayOffset();
                                bArr[i] = Arrays.copyOfRange(bArrArray, byteBuffer.position() + iArrayOffset, iArrayOffset + byteBuffer.limit());
                            }
                        }
                    } else {
                        bArr = null;
                    }
                    if (bArr == null) {
                        strArr = null;
                    } else {
                        strArr = new String[3];
                        for (int i2 = 0; i2 < 3; i2++) {
                            try {
                                byte[] bArr3 = bArr[i2];
                                if (bArr3 != null) {
                                    strArr[i2] = new String(bArr3, "UTF-8");
                                } else {
                                    strArr[i2] = "";
                                }
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (strArr == null) {
                        strArr = f1076a;
                    }
                    f1076a = strArr;
                    if (strArr.length >= 2 && TextUtils.isEmpty(strArr[0])) {
                        IsEmpty = TextUtils.isEmpty(f1076a[1]);
                        if (IsEmpty != 0) {
                            try {
                                randomAccessFile2 = new RandomAccessFile(file, t.k);
                                try {
                                    long length3 = randomAccessFile2.length();
                                    byte[] bArr4 = a.a.b.a.c.a.d.a.f1078a;
                                    bArr2 = new byte[bArr4.length];
                                    length2 = length3 - ((long) bArr4.length);
                                    randomAccessFile2.seek(length2);
                                    randomAccessFile2.readFully(bArr2);
                                } catch (FileNotFoundException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    IsEmpty = randomAccessFile2;
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile3 = randomAccessFile2;
                                        try {
                                            randomAccessFile3.close();
                                            IsEmpty = randomAccessFile3;
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            IsEmpty = randomAccessFile3;
                                        }
                                    }
                                } catch (UnsupportedEncodingException e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    IsEmpty = randomAccessFile2;
                                    randomAccessFile3 = randomAccessFile2;
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile3.close();
                                        IsEmpty = randomAccessFile3;
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    IsEmpty = randomAccessFile2;
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile3 = randomAccessFile2;
                                        randomAccessFile3.close();
                                        IsEmpty = randomAccessFile3;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    e.printStackTrace();
                                    IsEmpty = randomAccessFile2;
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile3 = randomAccessFile2;
                                        randomAccessFile3.close();
                                        IsEmpty = randomAccessFile3;
                                    }
                                }
                            } catch (FileNotFoundException e7) {
                                e = e7;
                                randomAccessFile2 = null;
                            } catch (UnsupportedEncodingException e8) {
                                e = e8;
                                randomAccessFile2 = null;
                            } catch (IOException e9) {
                                e = e9;
                                randomAccessFile2 = null;
                            } catch (Exception e10) {
                                e = e10;
                                randomAccessFile2 = null;
                            } catch (Throwable th6) {
                                th = th6;
                                if (r5 != 0) {
                                    try {
                                        r5.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                            if (a.a.b.a.c.a.d.a.a(bArr2)) {
                                long j = length2 - 2;
                                randomAccessFile2.seek(j);
                                int iA = a.a.b.a.c.a.d.a.a(randomAccessFile2);
                                if (iA > 0) {
                                    randomAccessFile2.seek(j - ((long) iA));
                                    byte[] bArr5 = new byte[iA];
                                    randomAccessFile2.readFully(bArr5);
                                    String str3 = new String(bArr5, "UTF-8");
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                    str2 = str3;
                                    IsEmpty = randomAccessFile2;
                                }
                                String[] strArr3 = f1076a;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                strArr3[0] = str2;
                            }
                            randomAccessFile2.close();
                            str2 = "";
                            IsEmpty = randomAccessFile2;
                            String[] strArr32 = f1076a;
                            if (str2 == null) {
                            }
                            strArr32[0] = str2;
                        }
                    }
                    strArr2 = f1076a;
                    if (strArr2.length >= 3 && !TextUtils.isEmpty(strArr2[2])) {
                        length = f1076a[2].length();
                        if (length <= 4) {
                            String[] strArr4 = f1076a;
                            strArr4[2] = strArr4[2].substring(2, length - 2);
                        } else {
                            f1076a[2] = "";
                        }
                    }
                } else {
                    f1076a = new String[]{"", "", ""};
                }
                b = true;
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
            b = true;
        }
        return !TextUtils.isEmpty(f1076a[0]) ? f1076a[0] : !TextUtils.isEmpty(f1076a[1]) ? f1076a[1] : "";
    }
}
