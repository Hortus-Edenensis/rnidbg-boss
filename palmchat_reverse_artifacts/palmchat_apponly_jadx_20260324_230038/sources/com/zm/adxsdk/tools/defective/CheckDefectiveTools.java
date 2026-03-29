package com.zm.adxsdk.tools.defective;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.zm.adxsdk.tools.defective.ui.DefectiveStatusActivity;
import com.zm.adxsdk.tools.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CheckDefectiveTools {
    private static final String TAG = "CheckDefectiveTools";

    public static void launcherDefective(Context context) {
        if (context == null) {
            Log.e(TAG, "context is null");
            return;
        }
        if (g.a().f16604a == null) {
            Log.e(TAG, "config toggle is close");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, DefectiveStatusActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
