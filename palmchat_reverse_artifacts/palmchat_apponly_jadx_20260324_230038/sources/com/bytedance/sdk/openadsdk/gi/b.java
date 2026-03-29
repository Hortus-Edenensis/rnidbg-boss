package com.bytedance.sdk.openadsdk.gi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static void fx(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                nr(file2);
            }
        }
    }

    public static void nr(File file) {
        if (file.isDirectory()) {
            fx(file);
        } else {
            file.delete();
        }
    }

    public static void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static File u(File file, String str) throws Throwable {
        File file2;
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file2 = new File(file.getParentFile(), str);
                try {
                    if (file.exists() && file.isDirectory()) {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                        try {
                            for (File file3 : file.listFiles()) {
                                zipOutputStream2.putNextEntry(new ZipEntry(file3.getName()));
                                u(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            u(zipOutputStream);
                            throw th;
                        }
                        zipOutputStream = zipOutputStream2;
                    }
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused3) {
            file2 = null;
        }
        u(zipOutputStream);
        return file2;
    }

    public static void u(String str, File file) throws Throwable {
        BufferedWriter bufferedWriter = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter2.write(str);
                u(bufferedWriter2);
            } catch (FileNotFoundException unused) {
                bufferedWriter = bufferedWriter2;
                u(bufferedWriter);
            } catch (IOException unused2) {
                bufferedWriter = bufferedWriter2;
                u(bufferedWriter);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                u(bufferedWriter);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String u(File file) {
        BufferedReader bufferedReader;
        StringBuilder sb;
        if (file != null && file.exists() && file.isFile()) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                try {
                    sb = new StringBuilder();
                } finally {
                }
            } catch (Exception unused) {
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - System.lineSeparator().length());
            }
            String strTrim = sb.toString().trim();
            bufferedReader.close();
            return strTrim;
        }
        return null;
    }

    public static void u(OutputStream outputStream, File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = fileInputStream2.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        u(fileInputStream2);
                        return;
                    }
                }
            } catch (FileNotFoundException unused) {
                fileInputStream = fileInputStream2;
                u(fileInputStream);
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                u(fileInputStream);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                u(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
