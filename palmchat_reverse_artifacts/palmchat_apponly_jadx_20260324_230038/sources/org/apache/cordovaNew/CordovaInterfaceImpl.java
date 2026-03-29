package org.apache.cordovaNew;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.m.x.d;
import com.huawei.openalliance.ad.constant.az;
import com.kuaishou.weapon.p0.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.cordovaNew.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaInterfaceImpl implements CordovaInterface {
    private static final String TAG = "CordovaInterfaceImpl";
    protected Activity activity;
    protected CordovaPlugin activityResultCallback;
    protected int activityResultRequestCode;
    protected boolean activityWasDestroyed;
    protected String initCallbackService;
    private Dialog permissionDescriptionDialogOnSysProcessing;
    protected CallbackMap permissionResultCallbacks;
    protected PluginManager pluginManager;
    protected Bundle savedPluginState;
    protected ActivityResultHolder savedResult;
    protected ExecutorService threadPool;

    /* JADX INFO: compiled from: SearchBox */
    public static class ActivityResultHolder {
        private Intent intent;
        private int requestCode;
        private int resultCode;

        public ActivityResultHolder(int i, int i2, Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.intent = intent;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public DefaultThreadFactory(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = str + "-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public CordovaInterfaceImpl(Activity activity) {
        this(activity, Executors.newCachedThreadPool(new DefaultThreadFactory("poolCached-CordovaInterfaceImpl")));
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public Activity getActivity() {
        return this.activity;
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public Context getContext() {
        return this.activity;
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public boolean hasPermission(String str) {
        return Build.VERSION.SDK_INT < 23 || this.activity.checkSelfPermission(str) == 0;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        CordovaPlugin plugin = this.activityResultCallback;
        if (plugin == null && this.initCallbackService != null) {
            this.savedResult = new ActivityResultHolder(i, i2, intent);
            PluginManager pluginManager = this.pluginManager;
            if (pluginManager != null && (plugin = pluginManager.getPlugin(this.initCallbackService)) != null) {
                plugin.onRestoreStateForActivityResult(this.savedPluginState.getBundle(plugin.getServiceName()), new ResumeCallback(plugin.getServiceName(), this.pluginManager));
            }
        }
        this.activityResultCallback = null;
        if (plugin != null) {
            LOG.d(TAG, "Sending activity result to plugin");
            this.initCallbackService = null;
            this.savedResult = null;
            plugin.onActivityResult(i, i2, intent);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Got an activity result, but no plugin was registered to receive it");
        sb.append(this.savedResult != null ? " yet!" : ".");
        LOG.w(TAG, sb.toString());
        return false;
    }

    public void onCordovaInit(PluginManager pluginManager) {
        CoreAndroid coreAndroid;
        this.pluginManager = pluginManager;
        ActivityResultHolder activityResultHolder = this.savedResult;
        if (activityResultHolder != null) {
            onActivityResult(activityResultHolder.requestCode, this.savedResult.resultCode, this.savedResult.intent);
            return;
        }
        if (this.activityWasDestroyed) {
            this.activityWasDestroyed = false;
            if (pluginManager == null || (coreAndroid = (CoreAndroid) pluginManager.getPlugin(CoreAndroid.PLUGIN_NAME)) == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", az.ag);
            } catch (JSONException e) {
                LOG.e(TAG, "Failed to create event message", e);
            }
            coreAndroid.sendResumeEvent(new PluginResult(PluginResult.Status.OK, jSONObject));
        }
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public Object onMessage(String str, Object obj) {
        if (!d.z.equals(str)) {
            return null;
        }
        this.activity.finish();
        return null;
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        Pair<CordovaPlugin, Integer> andRemoveCallback = this.permissionResultCallbacks.getAndRemoveCallback(i);
        if (andRemoveCallback != null) {
            ((CordovaPlugin) andRemoveCallback.first).onRequestPermissionResult(((Integer) andRemoveCallback.second).intValue(), strArr, iArr);
        }
        Dialog dialog = this.permissionDescriptionDialogOnSysProcessing;
        if (dialog != null && dialog.isShowing()) {
            this.permissionDescriptionDialogOnSysProcessing.dismiss();
            this.permissionDescriptionDialogOnSysProcessing = null;
        }
        if (strArr != null) {
            for (String str : strArr) {
                String str2 = "firstCheckRationale" + str;
                if (PermissionDialogUtil.getBooleanValue(getActivity(), str2, true)) {
                    PermissionDialogUtil.putBooleanValue(getActivity(), str2, false);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        CordovaPlugin cordovaPlugin = this.activityResultCallback;
        if (cordovaPlugin != null) {
            bundle.putString("callbackService", cordovaPlugin.getServiceName());
        }
        PluginManager pluginManager = this.pluginManager;
        if (pluginManager != null) {
            bundle.putBundle("plugin", pluginManager.onSaveInstanceState());
        }
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public void requestPermission(CordovaPlugin cordovaPlugin, int i, String str) {
        requestPermissions(cordovaPlugin, i, new String[]{str});
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    @SuppressLint({"NewApi"})
    public void requestPermissions(CordovaPlugin cordovaPlugin, int i, String[] strArr) {
        if (!PermissionDialogUtil.hasSelfPermissions(getContext(), strArr) && strArr.length == 1 && TextUtils.equals(strArr[0], g.g) && PermissionDialogUtil.shouldShowSysPermissionDialog(getActivity(), strArr)) {
            this.permissionDescriptionDialogOnSysProcessing = PermissionDialogUtil.showPermissionDesDialogOnSysProcessing2(getContext(), R.string.per_usage_h5_location, strArr);
        }
        getActivity().requestPermissions(strArr, this.permissionResultCallbacks.registerCallback(cordovaPlugin, i));
    }

    public void restoreInstanceState(Bundle bundle) {
        this.initCallbackService = bundle.getString("callbackService");
        this.savedPluginState = bundle.getBundle("plugin");
        this.activityWasDestroyed = true;
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
        CordovaPlugin cordovaPlugin2 = this.activityResultCallback;
        if (cordovaPlugin2 != null) {
            cordovaPlugin2.onActivityResult(this.activityResultRequestCode, 0, null);
        }
        this.activityResultCallback = cordovaPlugin;
    }

    public void setActivityResultRequestCode(int i) {
        this.activityResultRequestCode = i;
    }

    @Override // org.apache.cordovaNew.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
        setActivityResultCallback(cordovaPlugin);
        try {
            this.activity.startActivityForResult(intent, i);
        } catch (RuntimeException e) {
            this.activityResultCallback = null;
            throw e;
        }
    }

    public CordovaInterfaceImpl(Activity activity, ExecutorService executorService) {
        this.activityWasDestroyed = false;
        this.permissionDescriptionDialogOnSysProcessing = null;
        this.activity = activity;
        this.threadPool = executorService;
        this.permissionResultCallbacks = new CallbackMap();
    }
}
