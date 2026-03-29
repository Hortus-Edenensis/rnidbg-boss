package com.bytedance.pangle.iz;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends File {
        public u(File file, String str) {
            super(file, str);
        }
    }

    private static int nr(String str, int i) {
        return u((str + "-" + i) + ".dex.number");
    }

    public static void u(File file, String str, int i) throws Throwable {
        String str2 = ".dex";
        String str3 = "classes";
        if (!file.exists() || str == null) {
            throw new IOException("Could not check apk info " + file.getAbsolutePath());
        }
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ArrayList arrayList = new ArrayList();
                File file2 = new File(com.bytedance.pangle.pn.fx.a(str, i));
                u(file2);
                int i2 = 1;
                int i3 = 1;
                while (true) {
                    StringBuilder sb = new StringBuilder(str3);
                    Object objValueOf = "";
                    sb.append(i3 == i2 ? "" : Integer.valueOf(i3));
                    sb.append(str2);
                    ZipEntry entry = zipFile2.getEntry(sb.toString());
                    if (entry == null) {
                        u(str, i, file.getName(), arrayList);
                        com.bytedance.pangle.util.x.u(zipFile2);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    if (i3 != i2) {
                        objValueOf = Integer.valueOf(i3);
                    }
                    sb2.append(objValueOf);
                    sb2.append(str2);
                    u uVar = new u(file2, sb2.toString());
                    int i4 = 0;
                    boolean z = false;
                    while (i4 < 3 && !z) {
                        try {
                            u(zipFile2, entry, uVar, str3);
                            z = true;
                        } catch (IOException e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + uVar.getAbsolutePath(), e);
                        }
                        i4++;
                        StringBuilder sb3 = new StringBuilder("Plugin-MultiDex Extraction ");
                        sb3.append(z ? "succeeded" : "failed");
                        sb3.append(" '");
                        sb3.append(uVar.getAbsolutePath());
                        sb3.append("': length ");
                        String str4 = str2;
                        String str5 = str3;
                        sb3.append(uVar.length());
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb3.toString());
                        if (!z) {
                            uVar.delete();
                            if (uVar.exists()) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + uVar.getPath() + "'");
                            }
                        }
                        str2 = str4;
                        str3 = str5;
                    }
                    String str6 = str2;
                    String str7 = str3;
                    if (!z) {
                        throw new IOException("Could not create zip file " + uVar.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                    }
                    arrayList.add(uVar);
                    i3++;
                    str2 = str6;
                    str3 = str7;
                    i2 = 1;
                }
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                com.bytedance.pangle.util.x.u(zipFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String u(String str, int i) {
        int iNr = nr(str, i);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 <= iNr; i2++) {
            sb.append(new u(new File(com.bytedance.pangle.pn.fx.a(str, i)), i2 == 1 ? "classes.dex" : "classes" + i2 + ".dex").getAbsolutePath());
            sb.append(":");
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void u(ZipFile zipFile, ZipEntry zipEntry, u uVar, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".dex", uVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (fileCreateTempFile.setReadOnly()) {
                    if (fileCreateTempFile.renameTo(uVar)) {
                        return;
                    }
                    throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + uVar.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + uVar.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } finally {
            u(inputStream);
            fileCreateTempFile.delete();
        }
    }

    private static void u(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    private static void u(File file) {
        File[] fileArrListFiles;
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void u(String str, int i, String str2, List<u> list) {
        String str3 = str + "-" + i;
        SharedPreferences.Editor editorEdit = u().edit();
        editorEdit.putInt(str3 + ".dex.number", list.size());
        editorEdit.commit();
    }

    private static SharedPreferences u() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static int u(String str) {
        return u().getInt(str, 0);
    }
}
