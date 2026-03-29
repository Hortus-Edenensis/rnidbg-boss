package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import com.umeng.analytics.pro.dn;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pbln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19332a;

    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "790069", new byte[]{29, 103, 2, 26, 52});
        f19332a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "081559", new byte[]{53, 46, 125, 79, dn.l});
    }

    public static synchronized String a(Context context) {
        String strC;
        String str;
        String string;
        String strC2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(nr.u(context).getAbsolutePath());
            sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fd48d6", new byte[]{56}));
            str = f19332a;
            sb.append(str);
            string = sb.toString();
        } catch (Throwable unused) {
            strC = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa4eae", new byte[]{39, 88, 27, 80, 0, 79, 64, 120, 70, 16, 71, 87, 110, 62, 112, 73, 57, 1, 59, 8});
        }
        if (new File(string).exists() && (strC2 = c(string)) != null && strC2.length() > 0) {
            return strC2;
        }
        InputStream inputStreamOpen = context.getResources().getAssets().open(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStreamOpen.read(bArr, 0, 4096);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(string);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.close();
        c(((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dd7274", new byte[]{118, 110, 73, 73, 12, 99, 48, 18, 49, 34})) + string);
        strC = c(string);
        if (strC != null && strC.length() != 0) {
            if (strC != null) {
            }
            strC = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3548e3", new byte[]{114, 12, 27, dn.k, 4, 25, 21, 38, 87, 71, 16, 12, 27, dn.k, 4, 25});
            return strC;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(string, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fb953b", new byte[]{101, 119}));
        randomAccessFile.seek(16L);
        randomAccessFile.write(new byte[]{2});
        randomAccessFile.close();
        strC = c(string);
        if (strC != null || strC.length() == 0) {
            strC = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3548e3", new byte[]{114, 12, 27, dn.k, 4, 25, 21, 38, 87, 71, 16, 12, 27, dn.k, 4, 25});
        }
        return strC;
    }

    public static String b(BufferedInputStream bufferedInputStream) {
        int i;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c2d488", new byte[]{119, 57, 20});
            }
        } while (i >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str) throws Throwable {
        Process processExec;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedOutputStream2 = null;
        str = null;
        String str2 = null;
        try {
            processExec = Runtime.getRuntime().exec((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a61df2", new byte[]{99, 60}));
            try {
                bufferedOutputStream = new BufferedOutputStream(processExec.getOutputStream());
                try {
                    bufferedInputStream = new BufferedInputStream(processExec.getInputStream());
                    try {
                        bufferedOutputStream.write(str.getBytes());
                        bufferedOutputStream.write(10);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        processExec.waitFor();
                        String strB = b(bufferedInputStream);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "30670e", new byte[]{39, 59, 70, 124, 10});
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a968c8", new byte[]{117, 50, 70, 115, 89});
                        }
                        str2 = strB;
                    } catch (Exception unused3) {
                        try {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e40b4", new byte[]{33, 110, 68, 123, 88});
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused4) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "255bf5", new byte[]{38, 62, 69, 41, 92});
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException unused5) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "88d87d", new byte[]{44, 51, 20, 115, dn.k});
                                }
                            }
                            if (processExec != null) {
                            }
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused6) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c0634", new byte[]{36, 104, 64, 125, 9});
                                }
                            }
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException unused7) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8a2d23", new byte[]{44, 106, 66, 47, 8});
                                }
                            }
                            if (processExec != null) {
                                throw th;
                            }
                            processExec.destroy();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedOutputStream != null) {
                        }
                        if (bufferedInputStream2 != null) {
                        }
                        if (processExec != null) {
                        }
                    }
                } catch (Exception unused8) {
                    bufferedInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream2 != null) {
                    }
                    if (processExec != null) {
                    }
                }
            } catch (Exception unused9) {
                bufferedOutputStream = null;
                bufferedInputStream = null;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e40b4", new byte[]{33, 110, 68, 123, 88});
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (processExec != null) {
                    processExec.destroy();
                }
                return str2;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream2 != null) {
                }
                if (processExec != null) {
                }
            }
        } catch (Exception unused10) {
            processExec = null;
        } catch (Throwable th5) {
            th = th5;
            processExec = null;
            bufferedInputStream = null;
        }
        processExec.destroy();
        return str2;
    }
}
