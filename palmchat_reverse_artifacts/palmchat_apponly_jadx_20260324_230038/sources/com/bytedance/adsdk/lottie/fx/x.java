package com.bytedance.adsdk.lottie.fx;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class x {
    private final pn u;

    public x(pn pnVar) {
        this.u = pnVar;
    }

    private File nr(String str) throws FileNotFoundException {
        File file = new File(u(), u(str, fx.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(u(), u(str, fx.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    @WorkerThread
    public Pair<fx, InputStream> u(String str) {
        try {
            File fileNr = nr(str);
            if (fileNr == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileNr);
            fx fxVar = fileNr.getAbsolutePath().endsWith(".zip") ? fx.ZIP : fx.JSON;
            com.bytedance.adsdk.lottie.pn.pn.u("Cache hit for " + str + " at " + fileNr.getAbsolutePath());
            return new Pair<>(fxVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File u(String str, InputStream inputStream, fx fxVar) throws IOException {
        File file = new File(u(), u(str, fxVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    public void u(String str, fx fxVar) {
        File file = new File(u(), u(str, fxVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.pn.pn.u("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.pn.pn.nr("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private File u() {
        File fileU = this.u.u();
        if (fileU.isFile()) {
            fileU.delete();
        }
        if (!fileU.exists()) {
            fileU.mkdirs();
        }
        return fileU;
    }

    private static String u(String str, fx fxVar, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fxVar.u() : fxVar.fx);
        return sb.toString();
    }
}
