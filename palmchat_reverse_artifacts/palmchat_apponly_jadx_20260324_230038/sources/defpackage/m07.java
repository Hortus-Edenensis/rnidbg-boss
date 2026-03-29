package defpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class m07 {
    /* JADX WARN: Can't wrap try/catch for region: R(2:(3:33|7|(1:9)(0))|27) */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        File file;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            file = new File(str, str2);
        } catch (IOException unused) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (!file.exists()) {
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                }
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                }
                return sb.toString();
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 == null) {
                    throw th;
                }
                try {
                    bufferedReader2.close();
                    throw th;
                } catch (Throwable unused3) {
                    throw th;
                }
            }
            break;
        }
        bufferedReader.close();
        return sb.toString();
        if (bufferedReader2 != null) {
            bufferedReader = bufferedReader2;
            break;
            bufferedReader.close();
        }
        return sb.toString();
    }
}
