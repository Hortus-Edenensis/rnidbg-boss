package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f20660a = new ArrayList();

    public static String a(Context context, String str, File file) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String strB = b(applicationInfo.sourceDir, str, file);
        if (strB == null) {
            return null;
        }
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            for (String str2 : strArr) {
                strB = b(str2, str, file);
                if (strB == null) {
                    return null;
                }
            }
        }
        try {
            ClassLoader classLoader = s37.class.getClassLoader();
            while (!(classLoader instanceof BaseDexClassLoader) && classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
            }
            if (!(classLoader instanceof BaseDexClassLoader)) {
                return strB;
            }
            Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField2.setAccessible(true);
            for (String str3 : (String[]) declaredField2.get(obj)) {
                File file2 = new File(str3, System.mapLibraryName(str));
                if (file2.exists()) {
                    re7.i(file2, file);
                    wf7.b(file.getAbsolutePath(), 493);
                    return null;
                }
            }
            return "not_found";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static String b(String str, String str2, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        String str3;
        ZipEntry entry;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(new File(str), 1);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("lib/");
                str3 = Build.CPU_ABI;
                sb.append(str3);
                sb.append("/");
                sb.append(System.mapLibraryName(str2));
                entry = zipFile.getEntry(sb.toString());
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            zipFile = null;
        }
        if (entry == null) {
            int iIndexOf = str3.indexOf(45);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lib/");
            if (iIndexOf <= 0) {
                iIndexOf = str3.length();
            }
            sb2.append(str3.substring(0, iIndexOf));
            sb2.append("/");
            sb2.append(System.mapLibraryName(str2));
            String string = sb2.toString();
            ZipEntry entry2 = zipFile.getEntry(string);
            if (entry2 == null) {
                message = "Library entry not found:" + string;
                wf7.a(null);
                wf7.a(null);
                wf7.c(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th3) {
            inputStream = inputStream2;
            th = th3;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream2.read(bArr);
                if (i <= 0) {
                    wf7.b(file.getAbsolutePath(), 493);
                    wf7.a(fileOutputStream);
                    wf7.a(inputStream2);
                    wf7.c(zipFile);
                    return null;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th4) {
            fileOutputStream2 = fileOutputStream;
            inputStream = inputStream2;
            th = th4;
            try {
                message = th.getMessage();
                wf7.a(fileOutputStream2);
                wf7.a(inputStream);
                wf7.c(zipFile);
                return message;
            } catch (Throwable th5) {
                wf7.a(fileOutputStream2);
                wf7.a(inputStream);
                wf7.c(zipFile);
                throw th5;
            }
        }
    }
}
