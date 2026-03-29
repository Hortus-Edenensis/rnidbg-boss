package com.zm.adxsdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.zm.fissionsdk.WVVzW;
import com.zm.fissionsdk.zV2WW;
import com.zm.fissionsdk.zZZ2W;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WfFileProvider extends FileProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16597a = ".zm.adx.WfFileProvider";
    public static AtomicBoolean b = new AtomicBoolean(false);

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        if (!b.compareAndSet(false, true)) {
            WVVzW.a("WfFileProvider", "already init");
            return;
        }
        WVVzW.a("WfFileProvider", "init");
        zV2WW.a().a(context);
        zZZ2W.b().a(context);
    }

    public static Uri b(Context context, File file) {
        if (context == null || file == null) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + f16597a, file);
        if (uriForFile == null) {
            return null;
        }
        return uriForFile;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        a(getContext());
        return super.onCreate();
    }

    public static Uri a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                return a(context, file);
            }
        }
        return null;
    }

    public static Uri a(Context context, File file) {
        if (context == null || file == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return b(context, file);
        }
        return Uri.fromFile(file);
    }
}
