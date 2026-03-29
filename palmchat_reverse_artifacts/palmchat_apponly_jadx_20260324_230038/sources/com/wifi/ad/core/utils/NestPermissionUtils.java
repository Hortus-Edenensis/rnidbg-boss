package com.wifi.ad.core.utils;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.delegate.NestDelegateActivity;
import com.wifi.ad.core.utils.PermissionObservable;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/wifi/ad/core/utils/NestPermissionUtils;", "Ljava/util/Observer;", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/wifi/ad/core/utils/NestPermissionUtils$OnPermissionResult;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "setMap", "(Ljava/util/HashMap;)V", "requestLocationPermission", "", "context", "Landroid/content/Context;", "requestPhoneStatePermission", bq.f.s, "requestStoragePermission", "startActivitySafely", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "update", "o", "Ljava/util/Observable;", "arg", "", "OnPermissionResult", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NestPermissionUtils implements Observer {
    public static final NestPermissionUtils INSTANCE;
    private static HashMap<Integer, OnPermissionResult> map;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wifi/ad/core/utils/NestPermissionUtils$OnPermissionResult;", "", "onResult", "", "granted", "", "core_release"}, k = 1, mv = {1, 1, 16})
    public interface OnPermissionResult {
        void onResult(boolean granted);
    }

    static {
        NestPermissionUtils nestPermissionUtils = new NestPermissionUtils();
        INSTANCE = nestPermissionUtils;
        PermissionObservable.getInstance().addObserver(nestPermissionUtils);
        map = new HashMap<>();
    }

    private NestPermissionUtils() {
    }

    private final void startActivitySafely(Context context, Intent intent) {
        if (context != null) {
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                WifiLog.d("NestPermissionUtils startActivitySafely " + e.toString());
            }
        }
    }

    public final HashMap<Integer, OnPermissionResult> getMap() {
        return map;
    }

    public final void requestLocationPermission(Context context) {
        WifiLog.d("NestPermissionUtils requestLocation");
        NestDelegateActivity.Companion companion = NestDelegateActivity.INSTANCE;
        startActivitySafely(context, companion.getIntentDate(context, companion.getPERMISSION_LOCATION()));
    }

    public final void requestPhoneStatePermission(Context context) {
        WifiLog.d("NestPermissionUtils requestPhoneState");
        NestDelegateActivity.Companion companion = NestDelegateActivity.INSTANCE;
        startActivitySafely(context, companion.getIntentDate(context, companion.getPERMISSION_PHONE_STATE()));
    }

    public final void requestStoragePermission(Context context) {
        WifiLog.d("NestPermissionUtils requestStorage");
        NestDelegateActivity.Companion companion = NestDelegateActivity.INSTANCE;
        startActivitySafely(context, companion.getIntentDate(context, companion.getPERMISSION_STORAGE()));
    }

    public final void setMap(HashMap<Integer, OnPermissionResult> map2) {
        map = map2;
    }

    @Override // java.util.Observer
    public void update(Observable o, Object arg) {
        WifiLog.d("NestPermissionUtils update " + String.valueOf(o) + ' ' + String.valueOf(arg));
        if (arg instanceof PermissionObservable.PermissionMsg) {
            PermissionObservable.PermissionMsg permissionMsg = (PermissionObservable.PermissionMsg) arg;
            OnPermissionResult onPermissionResult = map.get(Integer.valueOf(permissionMsg.type));
            WifiLog.d("NestPermissionUtils update type = " + permissionMsg.type + " granted = " + permissionMsg.granted);
            if (onPermissionResult != null) {
                onPermissionResult.onResult(permissionMsg.granted);
            }
        }
    }

    public final synchronized void requestPhoneStatePermission(Context context, OnPermissionResult listener) {
        WifiLog.d("NestPermissionUtils requestPhoneState");
        NestDelegateActivity.Companion companion = NestDelegateActivity.INSTANCE;
        startActivitySafely(context, companion.getIntentDate(context, companion.getPERMISSION_PHONE_STATE()));
        map.put(Integer.valueOf(companion.getPERMISSION_PHONE_STATE()), listener);
    }
}
