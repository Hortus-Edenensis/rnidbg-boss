package com.wifi.csj.ad;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.kuaishou.weapon.p0.g;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.sensitive.NestInfoChecker;
import com.wifi.ad.core.sensitive.NestInfoSupplier;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.NestPermissionUtils;
import com.wifi.ad.core.utils.SharePreferenceUtils;
import com.wifi.ad.core.utils.WifiLog;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/wifi/csj/ad/CsjCustomController;", "Lcom/bytedance/sdk/openadsdk/TTCustomController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TIME_24_HOUR", "", "getTIME_24_HOUR", "()J", "TIME_5_SECOND", "getTIME_5_SECOND", "getContext", "()Landroid/content/Context;", "setContext", "checkoutKeyTimeOut", "", "key", "", "time", "getDevImei", "getDevOaid", "getTTLocation", "Lcom/bytedance/sdk/openadsdk/TTLocation;", "isCanUseLocation", "isCanUsePhoneState", "isCanUseWifiState", "isCanUseWriteExternal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class CsjCustomController extends TTCustomController {
    private final long TIME_24_HOUR = 86400000;
    private final long TIME_5_SECOND = 5000;
    private Context context;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[NestInfoSupplier.WifiState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[NestInfoSupplier.WifiState.ALLOW_USE.ordinal()] = 1;
            iArr[NestInfoSupplier.WifiState.DENIED_USE.ordinal()] = 2;
            int[] iArr2 = new int[NestInfoSupplier.StorageState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[NestInfoSupplier.StorageState.ALLOW_USE.ordinal()] = 1;
            iArr2[NestInfoSupplier.StorageState.DENIED_USE.ordinal()] = 2;
            int[] iArr3 = new int[NestInfoSupplier.LocationState.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[NestInfoSupplier.LocationState.ALLOW_USE.ordinal()] = 1;
            iArr3[NestInfoSupplier.LocationState.DENIED_USE.ordinal()] = 2;
        }
    }

    public CsjCustomController(Context context) {
        this.context = context;
    }

    private final synchronized boolean checkoutKeyTimeOut(String key, long time) {
        boolean zCheckTimeMillisOutTime;
        zCheckTimeMillisOutTime = NestInfoChecker.INSTANCE.checkTimeMillisOutTime(key, this.context, time);
        if (zCheckTimeMillisOutTime) {
            SharePreferenceUtils.INSTANCE.setLong(key, System.currentTimeMillis(), this.context);
            WifiLog.d("CsjCustomController checkoutKeyTimeOut() key = " + key + "  time = " + time + " checkTimeMillisOutTime = " + zCheckTimeMillisOutTime);
        }
        return zCheckTimeMillisOutTime;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        StringBuilder sb = new StringBuilder();
        sb.append("CsjCustomController getDevImei() = ");
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        sb.append(nestInfoTaker.getMeID(this.context));
        WifiLog.d(sb.toString());
        String meID = nestInfoTaker.getMeID(this.context);
        return meID != null ? meID : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        StringBuilder sb = new StringBuilder();
        sb.append("CsjCustomController getDevOaid() = ");
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        sb.append(nestInfoTaker.getOaId());
        WifiLog.d(sb.toString());
        String oaId = nestInfoTaker.getOaId();
        return oaId != null ? oaId : "";
    }

    public final long getTIME_24_HOUR() {
        return this.TIME_24_HOUR;
    }

    public final long getTIME_5_SECOND() {
        return this.TIME_5_SECOND;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        int i = WhenMappings.$EnumSwitchMapping$2[nestInfoTaker.isCanUseLocationFreely().ordinal()];
        if (i == 1) {
            if (!checkoutKeyTimeOut(WifiNestConst.ThirdConst.SP_FILE_LAST_LOCATION_TIME, this.TIME_5_SECOND)) {
                return false;
            }
            WifiLog.d("CsjCustomController isCanUseLocation)()  = " + nestInfoTaker.isCanUseLocationFreely());
            NestPermissionUtils.INSTANCE.requestLocationPermission(this.context);
            return true;
        }
        if (i == 2) {
            WifiLog.d("CsjCustomController isCanUseLocation()  = " + nestInfoTaker.isCanUseLocationFreely());
            return false;
        }
        boolean z = ContextCompat.checkSelfPermission(this.context, g.g) == 0 || ContextCompat.checkSelfPermission(this.context, g.h) == 0;
        if (z) {
            WifiLog.d("CsjCustomController isCanUseLocation() permission granted = " + z);
            return true;
        }
        if (!checkoutKeyTimeOut(WifiNestConst.ThirdConst.SP_FILE_LAST_LOCATION_TIME, this.TIME_24_HOUR)) {
            WifiLog.d("CsjCustomController isCanUseLocation() in 24h");
            return false;
        }
        NestPermissionUtils.INSTANCE.requestLocationPermission(this.context);
        WifiLog.d("CsjCustomController isCanUseLocation() out 24h , save a new SP_FILE_LAST_LOCATION_TIME time = " + System.currentTimeMillis());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        StringBuilder sb = new StringBuilder();
        sb.append("CsjCustomController isCanUseWifiState() = ");
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        sb.append(nestInfoTaker.isCanUseWifiStateFreely());
        WifiLog.d(sb.toString());
        int i = WhenMappings.$EnumSwitchMapping$0[nestInfoTaker.isCanUseWifiStateFreely().ordinal()];
        return i == 1 || i != 2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        int i = WhenMappings.$EnumSwitchMapping$1[nestInfoTaker.isCanUseWriteExternalFreely().ordinal()];
        if (i == 1) {
            if (!checkoutKeyTimeOut(WifiNestConst.ThirdConst.SP_FILE_LAST_STORAGE_TIME, this.TIME_5_SECOND)) {
                return false;
            }
            WifiLog.d("CsjCustomController isCanUseWriteExternal()  = " + nestInfoTaker.isCanUseWriteExternalFreely());
            NestPermissionUtils.INSTANCE.requestStoragePermission(this.context);
            return true;
        }
        if (i == 2) {
            WifiLog.d("CsjCustomController isCanUseWriteExternal()  = " + nestInfoTaker.isCanUseWriteExternalFreely());
            return false;
        }
        boolean z = ContextCompat.checkSelfPermission(this.context, g.j) == 0;
        if (z) {
            WifiLog.d("CsjCustomController isCanUseWriteExternal() permission granted = " + z);
            return true;
        }
        if (!checkoutKeyTimeOut(WifiNestConst.ThirdConst.SP_FILE_LAST_STORAGE_TIME, this.TIME_24_HOUR)) {
            WifiLog.d("CsjCustomController isCanUseWriteExternal() in 24h");
            return false;
        }
        NestPermissionUtils.INSTANCE.requestStoragePermission(this.context);
        WifiLog.d("CsjCustomController isCanUseWriteExternal() out 24h , save a new SP_FILE_LAST_STORAGE_TIME time = " + System.currentTimeMillis());
        return true;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public TTLocation getTTLocation() {
        StringBuilder sb = new StringBuilder();
        sb.append("CsjCustomController getTTLocation() isCanUseLocation = ");
        sb.append(isCanUseLocation());
        sb.append(" out lat = ");
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        sb.append(nestInfoTaker.getLatitude());
        sb.append(" out lon = ");
        sb.append(nestInfoTaker.getLongitude());
        WifiLog.d(sb.toString());
        try {
            String latitude = nestInfoTaker.getLatitude();
            double d = latitude != null ? Double.parseDouble(latitude) : 0.0d;
            String longitude = nestInfoTaker.getLongitude();
            return new TTLocation(d, longitude != null ? Double.parseDouble(longitude) : 0.0d);
        } catch (Exception unused) {
            return new TTLocation(0.0d, 0.0d);
        }
    }
}
