package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0003\u001a\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "", "a", "", "processName", t.l, "Ljava/io/File;", "file", "d", "", "deleted", "c", "zx-compat_release"}, k = 2, mv = {1, 4, 0})
public final class zj6 {
    public static final void a(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            File dataDir = context.getDataDir();
            Intrinsics.checkExpressionValueIsNotNull(dataDir, "context.dataDir");
            String absolutePath = dataDir.getAbsolutePath();
            String strA = hn4.a(context);
            if (!Intrinsics.areEqual(context.getPackageName(), strA)) {
                if (strA == null) {
                    strA = context.getPackageName();
                    Intrinsics.checkExpressionValueIsNotNull(strA, "context.packageName");
                }
                WebView.setDataDirectorySuffix(strA);
                String str = "_" + strA;
                linkedHashSet.add(absolutePath + "/app_webview" + str + "/webview_data.lock");
                linkedHashSet.add(absolutePath + "/app_hws_webview" + str + "/webview_data.lock");
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                sb.append("/app_webview");
                sb.append("/webview_data.lock");
                linkedHashSet.add(sb.toString());
                linkedHashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
            } else {
                String str2 = "_" + strA;
                linkedHashSet.add(absolutePath + "/app_webview" + str2 + "/webview_data.lock");
                linkedHashSet.add(absolutePath + "/app_hws_webview" + str2 + "/webview_data.lock");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath);
                sb2.append("/app_webview");
                sb2.append("/webview_data.lock");
                linkedHashSet.add(sb2.toString());
                linkedHashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
            }
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                File file = new File((String) it.next());
                if (file.exists()) {
                    d(file);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            File dataDir = context.getDataDir();
            Intrinsics.checkExpressionValueIsNotNull(dataDir, "context.dataDir");
            String absolutePath = dataDir.getAbsolutePath();
            if (!Intrinsics.areEqual(context.getPackageName(), str)) {
                if (str == null) {
                    str = context.getPackageName();
                    Intrinsics.checkExpressionValueIsNotNull(str, "context.packageName");
                }
                WebView.setDataDirectorySuffix(str);
                String str2 = "_" + str;
                linkedHashSet.add(absolutePath + "/app_webview" + str2 + "/webview_data.lock");
                linkedHashSet.add(absolutePath + "/app_hws_webview" + str2 + "/webview_data.lock");
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                sb.append("/app_webview");
                sb.append("/webview_data.lock");
                linkedHashSet.add(sb.toString());
                linkedHashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
            } else {
                String str3 = "_" + str;
                linkedHashSet.add(absolutePath + "/app_webview" + str3 + "/webview_data.lock");
                linkedHashSet.add(absolutePath + "/app_hws_webview" + str3 + "/webview_data.lock");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath);
                sb2.append("/app_webview");
                sb2.append("/webview_data.lock");
                linkedHashSet.add(sb2.toString());
                linkedHashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
            }
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                File file = new File((String) it.next());
                if (file.exists()) {
                    d(file);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void c(File file, boolean z) {
        if (z) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @TargetApi(28)
    public static final void d(File file) {
        try {
            FileLock fileLockTryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (fileLockTryLock != null) {
                fileLockTryLock.close();
            } else {
                c(file, file.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
            c(file, file.exists() ? file.delete() : false);
        }
    }
}
