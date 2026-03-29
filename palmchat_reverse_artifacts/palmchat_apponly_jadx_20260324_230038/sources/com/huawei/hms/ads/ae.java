package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface ae {
    Context Code(Context context);

    i.a Code();

    Object Code(Context context, String str);

    void Code(Activity activity);

    void Code(String str);

    void V(String str);

    void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);
}
