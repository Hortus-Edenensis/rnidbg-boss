package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AssetsLoadUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3956a = true;

    private static String a(String str, String str2, Context context) throws Throwable {
        ZipFile zipFile;
        File file;
        File file2;
        StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
        ZipFile zipFile2 = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(f3956a ? context.getPackageCodePath() : "");
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            int iLastIndexOf = str2.lastIndexOf("/");
            if (iLastIndexOf > 0) {
                file = new File(context.getFilesDir().getAbsolutePath());
                String strSubstring = str2.substring(0, iLastIndexOf);
                file2 = new File(file.getAbsolutePath() + "/" + strSubstring, str2.substring(iLastIndexOf + 1, str2.length()));
            } else {
                file = new File(context.getFilesDir(), "assets");
                file2 = new File(file.getAbsolutePath(), str2);
            }
            file.mkdirs();
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null) {
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                }
                return null;
            }
            a(zipFile.getInputStream(entry), new FileOutputStream(file2));
            sb.append("/");
            sb.append(str);
            zipFile.close();
        } catch (Exception e2) {
            e = e2;
            zipFile2 = zipFile;
            Log.e(AssetsLoadUtil.class.getSimpleName(), "copyAssetsError", e);
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
        return sb.toString();
    }

    public static void copyFileFromAsset(String str, String str2, Context context) throws Throwable {
        InputStream inputStreamOpen;
        byte[] bArr;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open(str);
                if (inputStreamOpen != null) {
                    try {
                        bArr = new byte[inputStreamOpen.available()];
                        inputStreamOpen.read(bArr);
                        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception unused) {
                    }
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception unused2) {
                        fileOutputStream2 = fileOutputStream;
                        a("assets/" + str, str2, context);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                }
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpen = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0071 A[Catch: IOException -> 0x006d, TRY_LEAVE, TryCatch #7 {IOException -> 0x006d, blocks: (B:29:0x0069, B:33:0x0071), top: B:58:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097 A[Catch: IOException -> 0x0093, TRY_LEAVE, TryCatch #2 {IOException -> 0x0093, blocks: (B:41:0x008f, B:45:0x0097), top: B:53:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAssetsFilePath(Context context, String str) throws Throwable {
        InputStream inputStreamOpen;
        String absolutePath;
        FileOutputStream fileOutputStream;
        IOException e;
        byte[] bArr;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            try {
                try {
                    bArr = new byte[inputStreamOpen.available()];
                    inputStreamOpen.read(bArr);
                    absolutePath = context.getFilesDir().getAbsolutePath();
                } catch (IOException e2) {
                    e = e2;
                    absolutePath = null;
                }
                try {
                    File file = new File(absolutePath + "/" + str);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = null;
                    e = e;
                    e.printStackTrace();
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return absolutePath + "/" + str;
                }
            } catch (Throwable th) {
                th = th;
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            try {
                try {
                    fileOutputStream.write(bArr);
                    try {
                        inputStreamOpen.close();
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (inputStreamOpen != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (inputStreamOpen != null) {
                }
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            absolutePath = null;
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpen = null;
        }
        return absolutePath + "/" + str;
    }

    public static Bitmap loadAssetsFile(String str, Context context) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            if (inputStreamOpen != null) {
                return BitmapFactory.decodeStream(inputStreamOpen);
            }
            return null;
        } catch (Exception unused) {
            return BitmapFactory.decodeFile(a("assets/" + str, str, context));
        }
    }

    private static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused2) {
        }
    }
}
