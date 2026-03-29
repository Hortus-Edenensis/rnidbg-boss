package com.wifi.oppo.ad;

import android.content.Context;
import com.heytap.msp.mobad.api.MobCustomController;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.LocationUtil;
import com.wifi.ad.core.utils.WifiLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.jssdk.general.Action;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u000202H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011¨\u0006<"}, d2 = {"Lcom/wifi/oppo/ad/OppoDefaultController;", "Lcom/heytap/msp/mobad/api/MobCustomController;", "mContext", "Landroid/content/Context;", "canUseLocation", "", "alist", "phoneState", "androidID", "writeExternal", "wifiState", "macAddress", "(Landroid/content/Context;ZZZZZZZ)V", "mAlist", "getMAlist", "()Z", "setMAlist", "(Z)V", "mAndroidID", "getMAndroidID", "setMAndroidID", "mCanUseLocation", "getMCanUseLocation", "setMCanUseLocation", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mLatitude", "", "getMLatitude", "()D", "setMLatitude", "(D)V", "mLongitude", "getMLongitude", "setMLongitude", "mMacAddress", "getMMacAddress", "setMMacAddress", "mPhoneState", "getMPhoneState", "setMPhoneState", "mWifiState", "getMWifiState", "setMWifiState", "mWriteExternal", "getMWriteExternal", "setMWriteExternal", "getAndroidId", "", "getDevImei", Action.ACTION_GET_LOCATION, "Lcom/heytap/msp/mobad/api/MobCustomController$LocationProvider;", "getMacAddress", "isCanUseAndroidId", "isCanUseLocation", "isCanUsePhoneState", "isCanUseWifiState", "isCanUseWriteExternal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class OppoDefaultController extends MobCustomController {
    private boolean mAlist;
    private boolean mAndroidID;
    private boolean mCanUseLocation;
    private Context mContext;
    private double mLatitude;
    private double mLongitude;
    private boolean mMacAddress;
    private boolean mPhoneState;
    private boolean mWifiState;
    private boolean mWriteExternal;

    public OppoDefaultController(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.mContext = context;
        this.mAlist = z2;
        this.mCanUseLocation = z;
        this.mPhoneState = z3;
        this.mAndroidID = z4;
        this.mWriteExternal = z5;
        this.mWifiState = z6;
        this.mMacAddress = z7;
        WifiLog.d("sdkPrivilegeController oppoMananger isCanUseLocation " + this.mCanUseLocation + " isCanUseInstalledPackages " + this.mAlist + " isCanUseAndroidId " + this.mAndroidID + " isCanUsePhoneState " + this.mPhoneState + " isCanUseWifiState " + this.mWifiState + " isCanUseWriteExternal " + this.mWriteExternal + " mMacAddress " + this.mMacAddress);
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    /* JADX INFO: renamed from: alist, reason: from getter */
    public boolean getMAlist() {
        return this.mAlist;
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public String getAndroidId() {
        return this.mAndroidID ? Intrinsics.stringPlus(NestInfoTaker.INSTANCE.getAndroidId(), "") : "";
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public String getDevImei() {
        String imEI1;
        return (!this.mPhoneState || (imEI1 = NestInfoTaker.INSTANCE.getImEI1(this.mContext)) == null) ? "" : imEI1;
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public MobCustomController.LocationProvider getLocation() {
        if (!this.mCanUseLocation) {
            return null;
        }
        try {
            Context context = this.mContext;
            if (context != null) {
                LocationUtil locationUtil = LocationUtil.INSTANCE;
                String longitude = locationUtil.getLongitude(context);
                if (!(longitude == null || longitude.length() == 0)) {
                    String longitude2 = locationUtil.getLongitude(this.mContext);
                    if (longitude2 == null) {
                        Intrinsics.throwNpe();
                    }
                    this.mLongitude = Double.parseDouble(longitude2);
                }
                String latitude = locationUtil.getLatitude(this.mContext);
                if (!(latitude == null || latitude.length() == 0)) {
                    String latitude2 = locationUtil.getLatitude(this.mContext);
                    if (latitude2 == null) {
                        Intrinsics.throwNpe();
                    }
                    this.mLatitude = Double.parseDouble(latitude2);
                }
            }
        } catch (Exception unused) {
        }
        WifiLog.d("OppoDefaultLocationMode mLongitude = " + this.mLongitude + " , mLatitude = " + this.mLatitude);
        return new OppoDefaultLocationMode(this.mLongitude, this.mLatitude);
    }

    public final boolean getMAlist() {
        return this.mAlist;
    }

    public final boolean getMAndroidID() {
        return this.mAndroidID;
    }

    public final boolean getMCanUseLocation() {
        return this.mCanUseLocation;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final double getMLatitude() {
        return this.mLatitude;
    }

    public final double getMLongitude() {
        return this.mLongitude;
    }

    public final boolean getMMacAddress() {
        return this.mMacAddress;
    }

    public final boolean getMPhoneState() {
        return this.mPhoneState;
    }

    public final boolean getMWifiState() {
        return this.mWifiState;
    }

    public final boolean getMWriteExternal() {
        return this.mWriteExternal;
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public String getMacAddress() {
        return this.mMacAddress ? Intrinsics.stringPlus(NestInfoTaker.INSTANCE.getMacAddress(), "") : "";
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public boolean isCanUseAndroidId() {
        return false;
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public boolean isCanUseLocation() {
        return false;
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public boolean isCanUsePhoneState() {
        return false;
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public boolean isCanUseWifiState() {
        return this.mWifiState;
    }

    @Override // com.heytap.msp.mobad.api.MobCustomController
    public boolean isCanUseWriteExternal() {
        return this.mWriteExternal;
    }

    public final void setMAlist(boolean z) {
        this.mAlist = z;
    }

    public final void setMAndroidID(boolean z) {
        this.mAndroidID = z;
    }

    public final void setMCanUseLocation(boolean z) {
        this.mCanUseLocation = z;
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }

    public final void setMLatitude(double d) {
        this.mLatitude = d;
    }

    public final void setMLongitude(double d) {
        this.mLongitude = d;
    }

    public final void setMMacAddress(boolean z) {
        this.mMacAddress = z;
    }

    public final void setMPhoneState(boolean z) {
        this.mPhoneState = z;
    }

    public final void setMWifiState(boolean z) {
        this.mWifiState = z;
    }

    public final void setMWriteExternal(boolean z) {
        this.mWriteExternal = z;
    }
}
