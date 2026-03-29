package defpackage;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iv1 {
    public static boolean a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            Log.d("FileUtils", "copyAssetFile failed srcName:" + str + ",msg:" + e.getLocalizedMessage(), e);
            return false;
        }
    }
}
