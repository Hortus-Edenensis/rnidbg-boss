package com.huawei.hms.ads;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.ads.dynamic.DynamicModule;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.d;
import com.huawei.openalliance.ad.inter.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h {
    private static volatile Context B = null;
    private static IRemoteCreator C = null;
    private static final String Code = "RemoteSdkInitializer";
    private static final List<String> D;
    private static d F = null;
    private static final String I = "com.huawei.hms.ads.common.inter.LoaderSpHandlerInter";
    private static String S = null;
    private static final String V = "adsuiengine";
    private static final String Z = "com.huawei.hms.ads.common.inter.LoaderCommonInter";

    static {
        ArrayList arrayList = new ArrayList();
        D = arrayList;
        arrayList.add(com.huawei.openalliance.ad.constant.x.cA);
    }

    public static synchronized IRemoteCreator Code(Context context) {
        Context contextV;
        fh.V(Code, "newCreator: ");
        if (C != null) {
            fh.V(Code, "newCreator: mRemoteCreator != null return");
            return C;
        }
        try {
            contextV = V(context);
        } catch (Throwable th) {
            fh.Z(Code, "newCreator failed " + th.getLocalizedMessage());
        }
        if (contextV == null) {
            Log.i(Code, "newCreator: remoteContext= null");
            return null;
        }
        IRemoteCreator iRemoteCreatorCode = IRemoteCreator.b.Code((IBinder) contextV.getClassLoader().loadClass("com.huawei.hms.ads.uiengine.remote.RemoteCreator").newInstance());
        C = iRemoteCreatorCode;
        S = iRemoteCreatorCode.getVersion();
        C.setGlobalUtil(e.Code(context));
        C.setSdkInfo(com.huawei.openalliance.ad.utils.d.d(context).intValue(), com.huawei.hms.ads.base.a.B, null);
        F = C.getUiEngineUtil();
        Log.i(Code, "newRemoteContext: mRemoteCreator :" + C);
        return C;
    }

    private static Integer I(Context context) {
        return Integer.valueOf(D.contains(context.getPackageName()) ? 2 : 1);
    }

    private static Context V(Context context) {
        fh.V(Code, "newRemoteContext: ");
        if (B != null) {
            return B;
        }
        try {
            if (com.huawei.openalliance.ad.utils.au.I(I)) {
                DynamicModule.setSpHandler(eg.Code(context));
            } else {
                fh.Z(Code, "LoaderSpHandler is not available");
            }
            if (com.huawei.openalliance.ad.utils.au.I(Z)) {
                DynamicModule.setCommonInter(ef.Code(context));
            } else {
                fh.Z(Code, "LoaderCommonHandler is not available");
            }
            B = DynamicModule.load(context, I(context), V, "").getModuleContext();
        } catch (Throwable th) {
            fh.Z(Code, "newRemoteContext failed: " + th.getLocalizedMessage());
        }
        return B;
    }

    public static synchronized String Code() {
        return S;
    }

    public static d V() {
        return F;
    }
}
