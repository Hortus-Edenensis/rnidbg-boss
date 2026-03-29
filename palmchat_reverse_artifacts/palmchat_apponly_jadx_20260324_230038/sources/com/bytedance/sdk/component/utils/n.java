package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.n$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            return jLastModified < 0 ? -1 : 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u implements Comparator<File> {
        private u() {
        }

        public /* synthetic */ u(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int u(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return u(file.lastModified(), file2.lastModified());
        }
    }

    public static byte[] b(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long lValueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    private static String fx(Context context) {
        File fileNr;
        if (context == null || (fileNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context)) == null) {
            return null;
        }
        return fileNr.getPath();
    }

    private static void iz(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    public static File nr(Context context, boolean z, String str, String str2) {
        String strFx = fx(context);
        if (z) {
            str = u(context) + "-" + str;
        }
        if (strFx != null) {
            String str3 = File.separator;
            if (!strFx.endsWith(str3)) {
                strFx = strFx + str3;
            }
        }
        String str4 = strFx + str;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    private static void pn(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            iz(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile.seek(j);
                byte b = randomAccessFile.readByte();
                randomAccessFile.seek(j);
                randomAccessFile.write(b);
                randomAccessFile.close();
            } catch (Throwable unused) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File u(Context context, boolean z, String str, String str2) {
        String strConcat;
        String str3;
        String strNr = nr(context);
        if (z) {
            strConcat = u(context) + "-" + str;
        } else {
            strConcat = "/".concat(String.valueOf(str));
        }
        if (strNr != null) {
            String str4 = File.separator;
            if (strNr.endsWith(str4)) {
                str3 = "";
            } else {
                str3 = strNr + str4;
            }
        }
        String str5 = str3 + strConcat;
        File file = new File(str5);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str5, str2);
    }

    public static void fx(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            try {
                file.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    fx(file2);
                } else {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        try {
            file.delete();
        } catch (Throwable unused3) {
        }
    }

    public static File nr(Context context, boolean z, String str) {
        String absolutePath = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context).getAbsolutePath();
        if (z) {
            str = u(context) + "-" + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = absolutePath + str2;
            }
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File u(Context context, boolean z, String str) {
        String str2;
        String strNr = nr(context);
        if (z) {
            str = u(context) + "-" + str;
        }
        if (strNr != null) {
            String str3 = File.separator;
            if (strNr.endsWith(str3)) {
                str2 = "";
            } else {
                str2 = strNr + str3;
            }
        }
        File file = new File(str2 + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String nr(Context context) {
        File fileFx;
        if (context == null) {
            return null;
        }
        boolean z = false;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (!Environment.isExternalStorageRemovable()) {
                    z = true;
                }
            }
        } catch (Throwable unused) {
        }
        if (z) {
            try {
                fileFx = com.bytedance.sdk.openadsdk.api.plugin.nr.fx(context);
            } catch (Throwable unused2) {
                fileFx = null;
            }
        } else {
            fileFx = null;
        }
        if (fileFx == null) {
            try {
                fileFx = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context);
            } catch (Throwable unused3) {
            }
        }
        if (fileFx == null) {
            return null;
        }
        return fileFx.getPath();
    }

    public static List<File> u(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new u(null));
        return listAsList;
    }

    public static void nr(File file) throws IOException {
        if (file.exists()) {
            k.nr("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            pn(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                new Date(file.lastModified());
                file.getAbsolutePath();
            }
        }
    }

    public static String u(Context context) {
        String strU = dw.u(context);
        return (TextUtils.isEmpty(strU) || !strU.contains(":")) ? strU : strU.replace(":", "-");
    }
}
