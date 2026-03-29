package defpackage;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class wj2 extends uo {
    public boolean b = true;

    @Override // defpackage.uo
    public void c(Context context, int i) {
        LogUtil.d("HuaweiBadgeOperator", "updateBadgeCountImp: " + i);
        if (this.b) {
            try {
                e(context, i);
            } catch (Exception unused) {
                this.b = false;
            }
        }
    }

    public final void e(Context context, int i) {
        ComponentName componentNameA = t93.a(context);
        Uri uri = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
        if (TextUtils.isEmpty(context.getContentResolver().getType(uri))) {
            uri = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
            if (TextUtils.isEmpty(context.getContentResolver().getType(uri))) {
                uri = null;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("package", componentNameA.getPackageName());
        bundle.putString("class", componentNameA.getClassName());
        bundle.putInt("badgenumber", i);
        if (uri != null) {
            context.getContentResolver().call(uri, "change_badge", (String) null, bundle);
        }
    }

    @Override // defpackage.uo
    public void d(Context context, Notification notification, int i) {
    }
}
