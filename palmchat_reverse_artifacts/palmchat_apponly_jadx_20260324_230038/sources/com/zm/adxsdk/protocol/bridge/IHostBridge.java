package com.zm.adxsdk.protocol.bridge;

import android.content.Context;
import android.net.Uri;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import com.zm.adxsdk.protocol.lifecycle.IActivityLifecycle;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IHostBridge {
    IActivityLifecycle getActivityLifecycle();

    Context getContext();

    String getFlavor();

    IWfReporter getReporter();

    int getSdkVersionCode();

    String getSdkVersionName();

    Uri getUriForFile(Context context, File file);

    WfConfig getWfConfig();
}
