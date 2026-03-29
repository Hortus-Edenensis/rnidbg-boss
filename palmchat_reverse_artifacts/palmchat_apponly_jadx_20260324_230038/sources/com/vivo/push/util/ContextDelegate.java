package com.vivo.push.util;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ContextDelegate {
    private static final String TAG = "ContextDelegate";
    private static Context mContext = null;
    private static volatile Method mCreateCredentialProtectedStorageContext = null;
    private static volatile Method mCreateDeviceProtectedStorageContext = null;
    private static boolean mDelegateEnable = false;
    private static volatile Boolean mIsFbeProject;
    private static volatile Boolean mIsFdeProject;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ContextDelegate f11290a = new ContextDelegate();
    }

    private static synchronized Context createCredentialProtectedStorageContext(Context context) {
        try {
            if (mCreateCredentialProtectedStorageContext == null) {
                mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return context;
        }
        return (Context) mCreateCredentialProtectedStorageContext.invoke(context, new Object[0]);
    }

    private static synchronized Context createDeviceProtectedStorageContext(Context context) {
        try {
            if (mCreateDeviceProtectedStorageContext == null) {
                mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return context;
        }
        return (Context) mCreateDeviceProtectedStorageContext.invoke(context, new Object[0]);
    }

    public static Context getContext(Context context) {
        if ((!isFBEProject() && !isFDEProject()) || context == null) {
            return context;
        }
        Context context2 = mContext;
        if (context2 != null) {
            return context2;
        }
        setContext(context);
        return mContext;
    }

    public static ContextDelegate getInstance() {
        return a.f11290a;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: all -> 0x0061, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0008, B:11:0x001b, B:15:0x0053, B:19:0x0059, B:14:0x003c), top: B:25:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean isFBEProject() {
        if (mIsFbeProject == null) {
            try {
                mIsFbeProject = Boolean.valueOf("file".equals(m.a("ro.crypto.type", "unknow")));
                t.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
            } catch (Exception e) {
                t.a(TAG, "mIsFbeProject = " + e.getMessage());
            }
            if (mIsFbeProject != null) {
                return false;
            }
            return mIsFbeProject.booleanValue();
        }
        if (mIsFbeProject != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: all -> 0x0061, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0008, B:11:0x001b, B:15:0x0053, B:19:0x0059, B:14:0x003c), top: B:25:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized boolean isFDEProject() {
        if (mIsFdeProject == null) {
            try {
                mIsFdeProject = Boolean.valueOf("block".equals(m.a("ro.crypto.type", "unknow")));
                t.b(TAG, "mIsFdeProject = " + mIsFdeProject.toString());
            } catch (Exception e) {
                t.a(TAG, "mIsFdeProject = " + e.getMessage());
            }
            if (mIsFdeProject != null) {
                return false;
            }
            return mIsFdeProject.booleanValue();
        }
        if (mIsFdeProject != null) {
        }
    }

    private static void setAppContext() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    private static void setContext(Context context) {
        if (mDelegateEnable) {
            mContext = createDeviceProtectedStorageContext(context);
        } else {
            mContext = createCredentialProtectedStorageContext(context);
        }
    }

    public static void setEnable(boolean z) {
        mDelegateEnable = z;
        setAppContext();
    }
}
