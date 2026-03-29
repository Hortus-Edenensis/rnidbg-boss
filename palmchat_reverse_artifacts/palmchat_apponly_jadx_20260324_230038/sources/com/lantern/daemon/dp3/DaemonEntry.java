package com.lantern.daemon.dp3;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.lantern.daemon.dp3.utils.EntryParam;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DaemonEntry {
    public int broadcastTransactCode;
    public int instrumentationTransactCode;
    public Parcel mBroadcastData;
    public Parcel mInstrumentationData;
    public IBinder mRemote;
    public Parcel mServiceData;
    public EntryParam param;
    public int serviceTransactCode;

    public DaemonEntry(EntryParam entryParam) {
        this.param = entryParam;
    }

    public static void main(String[] strArr) {
        EntryParam entryParamFromBase64;
        try {
            String str = strArr[0];
            if (TextUtils.isEmpty(str) || (entryParamFromBase64 = EntryParam.fromBase64(str)) == null) {
                return;
            } else {
                new DaemonEntry(entryParamFromBase64).doDaemon();
            }
        } catch (Exception unused) {
        }
        Process.killProcess(Process.myPid());
    }

    public final void doDaemon() {
        try {
            initTransact();
            int i = 1;
            while (true) {
                String[] strArr = this.param.files;
                if (i >= strArr.length) {
                    DaemonNative.naWaitOneFileLock(strArr[0]);
                    startInstrumentationByAmsBinder();
                    startServiceByAmsBinder();
                    startByAmsBinder();
                    return;
                }
                new ThreadWaitOneFileLock(this, i).start();
                i++;
            }
        } catch (Exception e) {
            Log.e("CoreDaemon", "fatal error: " + e);
        }
    }

    public final void initTransact() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Intent intent;
        ComponentName component;
        Intent intent2;
        this.mRemote = (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "activity");
        this.serviceTransactCode = transactCode("TRANSACTION_startService", "START_SERVICE_TRANSACTION");
        this.broadcastTransactCode = transactCode("TRANSACTION_broadcastIntent", "BROADCAST_INTENT_TRANSACTION");
        int iTransactCode = transactCode("TRANSACTION_startInstrumentation", "START_INSTRUMENTATION_TRANSACTION");
        this.instrumentationTransactCode = iTransactCode;
        if (this.serviceTransactCode == -1 && this.broadcastTransactCode == -1 && iTransactCode == -1) {
            throw new RuntimeException("all binder code get failed");
        }
        try {
            EntryParam entryParam = this.param;
            if (entryParam != null && (intent2 = entryParam.serviceIntent) != null && intent2.getComponent() != null) {
                Intent intent3 = this.param.serviceIntent;
                Parcel parcelObtain = Parcel.obtain();
                this.mServiceData = parcelObtain;
                parcelObtain.writeInterfaceToken("android.app.IActivityManager");
                this.mServiceData.writeStrongBinder(null);
                int i = Build.VERSION.SDK_INT;
                if (i >= 26) {
                    this.mServiceData.writeInt(1);
                }
                intent3.writeToParcel(this.mServiceData, 0);
                this.mServiceData.writeString(null);
                if (i >= 26) {
                    this.mServiceData.writeInt(0);
                }
                if (i > 22) {
                    this.mServiceData.writeString(intent3.getComponent().getPackageName());
                }
                this.mServiceData.writeInt(0);
            }
        } catch (Exception unused) {
        }
        try {
            EntryParam entryParam2 = this.param;
            if (entryParam2 != null && entryParam2.instrumentationIntent != null && entryParam2.serviceIntent.getComponent() != null && (component = this.param.instrumentationIntent.getComponent()) != null) {
                Parcel parcelObtain2 = Parcel.obtain();
                this.mInstrumentationData = parcelObtain2;
                parcelObtain2.writeInterfaceToken("android.app.IActivityManager");
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mInstrumentationData.writeInt(1);
                }
                component.writeToParcel(this.mInstrumentationData, 0);
                this.mInstrumentationData.writeString(null);
                this.mInstrumentationData.writeInt(0);
                this.mInstrumentationData.writeInt(0);
                this.mInstrumentationData.writeStrongBinder(null);
                this.mInstrumentationData.writeStrongBinder(null);
                this.mInstrumentationData.writeInt(0);
                this.mInstrumentationData.writeString(null);
            }
        } catch (Exception unused2) {
        }
        try {
            EntryParam entryParam3 = this.param;
            if (entryParam3 != null && (intent = entryParam3.broadcastIntent) != null) {
                intent.setFlags(32);
                Parcel parcelObtain3 = Parcel.obtain();
                this.mBroadcastData = parcelObtain3;
                parcelObtain3.writeInterfaceToken("android.app.IActivityManager");
                this.mBroadcastData.writeStrongBinder(null);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mBroadcastData.writeInt(1);
                }
                intent.writeToParcel(this.mBroadcastData, 0);
                this.mBroadcastData.writeString(null);
                this.mBroadcastData.writeStrongBinder(null);
                this.mBroadcastData.writeInt(-1);
                this.mBroadcastData.writeString(null);
                this.mBroadcastData.writeInt(0);
                this.mBroadcastData.writeStringArray(null);
                this.mBroadcastData.writeInt(-1);
                this.mBroadcastData.writeInt(0);
                this.mBroadcastData.writeInt(0);
                this.mBroadcastData.writeInt(0);
                this.mBroadcastData.writeInt(0);
            }
        } catch (Exception unused3) {
        }
        DaemonNative.naSetSid();
        try {
            Process.class.getDeclaredMethod("setArgV0", String.class).invoke(null, this.param.processName);
        } catch (Exception unused4) {
        }
    }

    public final void startByAmsBinder() {
        IBinder iBinder;
        Parcel parcel = this.mBroadcastData;
        if (parcel == null || (iBinder = this.mRemote) == null) {
            return;
        }
        try {
            iBinder.transact(this.broadcastTransactCode, parcel, null, 1);
        } catch (Exception unused) {
        }
    }

    public final void startInstrumentationByAmsBinder() {
        IBinder iBinder;
        Parcel parcel = this.mInstrumentationData;
        if (parcel == null || (iBinder = this.mRemote) == null) {
            return;
        }
        try {
            iBinder.transact(this.instrumentationTransactCode, parcel, null, 1);
        } catch (Exception unused) {
        }
    }

    public final void startServiceByAmsBinder() {
        IBinder iBinder;
        Parcel parcel = this.mServiceData;
        if (parcel == null || (iBinder = this.mRemote) == null) {
            return;
        }
        try {
            iBinder.transact(this.serviceTransactCode, parcel, null, 1);
        } catch (Exception unused) {
        }
    }

    public final int transactCode(String str, String str2) {
        try {
            try {
                Field declaredField = Class.forName("android.app.IActivityManager$Stub").getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.getInt(null);
            } catch (Exception unused) {
                return -1;
            }
        } catch (Exception unused2) {
            Field declaredField2 = Class.forName("android.app.IActivityManager").getDeclaredField(str2);
            declaredField2.setAccessible(true);
            return declaredField2.getInt(null);
        }
    }
}
