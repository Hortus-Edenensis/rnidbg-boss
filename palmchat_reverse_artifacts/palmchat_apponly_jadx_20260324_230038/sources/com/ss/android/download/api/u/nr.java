package com.ss.android.download.api.u;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.a;
import com.ss.android.download.api.config.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements a {
    private dw u;

    @Override // com.ss.android.download.api.config.a
    public void u(@NonNull Activity activity, @NonNull String[] strArr, dw dwVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.u = dwVar;
            activity.requestPermissions(strArr, 1);
        } else if (dwVar != null) {
            dwVar.u();
        }
    }

    @Override // com.ss.android.download.api.config.a
    public boolean u(@Nullable Context context, @NonNull String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // com.ss.android.download.api.config.a
    public void u(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        dw dwVar;
        if (iArr.length <= 0 || (dwVar = this.u) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            dwVar.u(strArr[0]);
        } else if (i2 == 0) {
            dwVar.u();
        }
    }
}
