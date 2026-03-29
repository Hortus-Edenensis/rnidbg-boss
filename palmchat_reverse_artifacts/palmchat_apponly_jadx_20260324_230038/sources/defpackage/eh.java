package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.zenmen.palmchat.c;
import java.io.File;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray<Long> f17300a = new SparseArray<>(6);
    public static int b = 500;

    public static String a() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? c.b().getResources().getConfiguration().getLocales().get(0) : c.b().getResources().getConfiguration().locale;
        Locale locale2 = Locale.getDefault();
        if (locale == null || locale2 == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale2.getCountry();
    }

    public static String b(Context context, String str) {
        File file = new File(str);
        if (!file.exists()) {
            return "安装时文件不存在";
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT < 24) {
                intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
            } else {
                intent.setDataAndType(FileProvider.getUriForFile(context, "com.zenmen.palmchat.webplatform.file.provider", file), AdBaseConstants.MIME_APK);
                intent.addFlags(3);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void c(Context context, File file) {
        b(context, file.getAbsolutePath());
    }

    public static boolean d(int i, long j) {
        if (i > 0 && j > 0) {
            Long l = f17300a.get(i);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (l != null && l.longValue() > 0) {
                if (jCurrentTimeMillis - l.longValue() < j) {
                    return true;
                }
                if (f17300a.size() >= 6) {
                    f17300a.removeAt(0);
                }
                f17300a.put(i, Long.valueOf(jCurrentTimeMillis));
                return false;
            }
            if (f17300a.size() >= 6) {
                f17300a.removeAt(0);
            }
            f17300a.put(i, Long.valueOf(jCurrentTimeMillis));
        }
        return false;
    }
}
