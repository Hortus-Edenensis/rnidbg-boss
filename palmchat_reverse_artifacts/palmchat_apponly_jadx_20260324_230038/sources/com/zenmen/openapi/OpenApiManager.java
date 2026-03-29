package com.zenmen.openapi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.zenmen.openapi.e;
import com.zenmen.openapi.impl.OAAccountUtils;
import defpackage.e84;
import defpackage.k86;
import defpackage.ma3;
import defpackage.nl0;
import defpackage.v4;
import defpackage.we;
import defpackage.xg;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public enum OpenApiManager {
    mInstance;

    private static final int STATE_SERVICE_CONNECTED = 1;
    private static final int STATE_SERVICE_CONNECTING = 2;
    private static final int STATE_SERVICE_DISCONNECT = 0;
    private we appCache;
    private Context mContext;
    private e mImpl;
    private boolean mIsMainProcess = true;
    private AtomicInteger mBinderState = new AtomicInteger(0);
    private ServiceConnection mConnection = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ma3.a("IOpenApiService bind completed!", new Object[0]);
            OpenApiManager.this.mImpl = e.a.g(iBinder);
            OpenApiManager.this.mBinderState.set(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OpenApiManager.this.mBinderState.set(0);
        }
    }

    OpenApiManager() {
    }

    public static void configNativeApp(String str, String str2, e84 e84Var) {
        OpenApiManager openApiManager = mInstance;
        if (openApiManager.appCache == null) {
            openApiManager.appCache = new we();
        }
        openApiManager.appCache.b(str, str2, e84Var);
    }

    public static xg getAppInfoFromCache(String str) {
        we weVar = mInstance.appCache;
        if (weVar == null) {
            return null;
        }
        return weVar.c(str);
    }

    public static String getConfigString(String str) {
        if (isReady()) {
            try {
                return mInstance.mImpl.v().getConfig(str);
            } catch (RemoteException e) {
                ma3.c(e);
            }
        }
        ma3.d("get config but bind is not ready");
        return null;
    }

    public static Context getContext() {
        return mInstance.mContext;
    }

    public static String getDeviveInfo(String str) {
        if (!isReady()) {
            return null;
        }
        try {
            OpenApiManager openApiManager = mInstance;
            return (String) openApiManager.mImpl.m().getClass().getMethod(str, new Class[0]).invoke(openApiManager.mImpl.m(), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static OpenApiManager getInstance() {
        return mInstance;
    }

    public static String getUserInfo(String str) {
        OpenApiManager openApiManager = mInstance;
        if (openApiManager.mIsMainProcess) {
            if (OAAccountUtils.INFO_TYPE_SID.equals(str)) {
                return v4.c(openApiManager.mContext);
            }
            if (OAAccountUtils.INFO_TYPE_TOKEN.equals(str)) {
                return v4.d();
            }
            if (OAAccountUtils.INFO_TYPE_UID.equals(str)) {
                return v4.e(openApiManager.mContext);
            }
        }
        if (!isReady()) {
            return null;
        }
        try {
            return (String) openApiManager.mImpl.z().getClass().getMethod(str, new Class[0]).invoke(openApiManager.mImpl.z(), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isMainProcess() {
        return mInstance.mIsMainProcess;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isReady() {
        boolean z;
        OpenApiManager openApiManager = mInstance;
        if (openApiManager.mImpl != null) {
            z = openApiManager.mBinderState.get() == 1;
        }
        if (!z) {
            ma3.a("binder is not ready!!", new Object[0]);
        }
        return z;
    }

    public synchronized void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        String strM = k86.m(applicationContext);
        this.mIsMainProcess = TextUtils.isEmpty(strM) || strM.equals(this.mContext.getPackageName());
        if (this.mBinderState.get() == 0) {
            this.mBinderState.set(2);
            this.mContext.bindService(new Intent(this.mContext, (Class<?>) OpenApiService.class), this.mConnection, 1);
        }
        if (nl0.c().equals("release")) {
            ma3.h(2);
        } else {
            ma3.h(0);
        }
    }
}
