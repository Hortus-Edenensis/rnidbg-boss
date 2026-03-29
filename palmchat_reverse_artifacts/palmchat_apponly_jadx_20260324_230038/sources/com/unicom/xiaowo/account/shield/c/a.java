package com.unicom.xiaowo.account.shield.c;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        for (File file2 : file.listFiles()) {
            a(file2);
        }
        file.delete();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:73|(4:67|3|77|4))|(3:5|(1:7)(1:80)|47)|8|68|9|63|13|47|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r6.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r6.printStackTrace();
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0066: MOVE (r5 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:49:0x0066 */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(InputStream inputStream) throws Throwable {
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream;
        FileNotFoundException e2;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        byteArray = null;
        byteArray = null;
        byteArray = null;
        byte[] byteArray = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(8192);
                    try {
                        bArr = new byte[8192];
                    } catch (FileNotFoundException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream3 == null) {
                        try {
                            byteArrayOutputStream3.close();
                            throw th;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                e2 = e9;
                byteArrayOutputStream = null;
            } catch (IOException e10) {
                e = e10;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                }
                if (byteArrayOutputStream3 == null) {
                }
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            return byteArray;
        }
        byteArrayOutputStream.flush();
        byteArray = byteArrayOutputStream.toByteArray();
        inputStream.close();
        byteArrayOutputStream.close();
        return byteArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0044 -> B:56:0x0047). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(byte[] bArr, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                fileOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (fileOutputStream == null) {
                    } else {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    fileOutputStream = fileOutputStream;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        } catch (Exception e8) {
            e = e8;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedOutputStream != null) {
            }
            if (fileOutputStream != null) {
            }
        }
    }
}
