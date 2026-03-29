package com.wifi.csj.ad;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.LocationUtil;
import com.wifi.ad.core.utils.WifiLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BW\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020:H\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u0005H\u0016J\b\u0010A\u001a\u00020\u0005H\u0016J\b\u0010B\u001a\u00020\u0005H\u0016J\b\u0010C\u001a\u00020\u0005H\u0016J\b\u0010D\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0005H\u0016R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u001a\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013R\u001a\u00100\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\u001a\u00103\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013R\u001a\u00106\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0013¨\u0006F"}, d2 = {"Lcom/wifi/csj/ad/CsjDefaultController;", "Lcom/bytedance/sdk/openadsdk/TTCustomController;", "mContext", "Landroid/content/Context;", "canUseLocation", "", "alist", "phoneState", "androidID", "recordAudio", "writeExternal", "wifiState", "oaid", "macAddress", "(Landroid/content/Context;ZZZZZZZZZ)V", "mAlist", "getMAlist", "()Z", "setMAlist", "(Z)V", "mAndroidID", "getMAndroidID", "setMAndroidID", "mCanUseLocation", "getMCanUseLocation", "setMCanUseLocation", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mLatitude", "", "getMLatitude", "()D", "setMLatitude", "(D)V", "mLongitude", "getMLongitude", "setMLongitude", "mMacAddress", "getMMacAddress", "setMMacAddress", "mOaid", "getMOaid", "setMOaid", "mPhoneState", "getMPhoneState", "setMPhoneState", "mRecordAudio", "getMRecordAudio", "setMRecordAudio", "mWifiState", "getMWifiState", "setMWifiState", "mWriteExternal", "getMWriteExternal", "setMWriteExternal", "getAndroidId", "", "getDevImei", "getDevOaid", "getMacAddress", "getTTLocation", "Lcom/wifi/csj/ad/CsjDefaultLocationMode;", "isCanUseAndroidId", "isCanUseLocation", "isCanUsePermissionRecordAudio", "isCanUsePhoneState", "isCanUseWifiState", "isCanUseWriteExternal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class CsjDefaultController extends TTCustomController {
    private boolean mAlist;
    private boolean mAndroidID;
    private boolean mCanUseLocation;
    private Context mContext;
    private double mLatitude;
    private double mLongitude;
    private boolean mMacAddress;
    private boolean mOaid;
    private boolean mPhoneState;
    private boolean mRecordAudio;
    private boolean mWifiState;
    private boolean mWriteExternal;

    public CsjDefaultController(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.mContext = context;
        this.mAlist = z2;
        this.mCanUseLocation = z;
        this.mPhoneState = z3;
        this.mAndroidID = z4;
        this.mRecordAudio = z5;
        this.mWriteExternal = z6;
        this.mWifiState = z7;
        this.mOaid = z8;
        this.mMacAddress = z9;
        WifiLog.d("sdkPrivilegeController csjMananger isCanUseLocation " + this.mCanUseLocation + " isCanUseInstalledPackages " + this.mAlist + " isCanUseAndroidId " + this.mAndroidID + " isCanUsePhoneState " + this.mPhoneState + " isCanUseWifiState " + this.mWifiState + " isCanUseWriteExternal " + this.mWriteExternal + " isCanUsePermissionRecordAudio " + this.mRecordAudio + " mOaid " + this.mOaid + " mMacAddress " + this.mMacAddress);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    /* JADX INFO: renamed from: alist, reason: from getter */
    public boolean getMAlist() {
        return this.mAlist;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return this.mAndroidID ? Intrinsics.stringPlus(NestInfoTaker.INSTANCE.getAndroidId(), "") : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        String imEI1;
        return (!this.mPhoneState || (imEI1 = NestInfoTaker.INSTANCE.getImEI1(this.mContext)) == null) ? "" : imEI1;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        String oaId;
        return (!this.mOaid || (oaId = NestInfoTaker.INSTANCE.getOaId()) == null) ? "" : oaId;
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

    public final boolean getMOaid() {
        return this.mOaid;
    }

    public final boolean getMPhoneState() {
        return this.mPhoneState;
    }

    public final boolean getMRecordAudio() {
        return this.mRecordAudio;
    }

    public final boolean getMWifiState() {
        return this.mWifiState;
    }

    public final boolean getMWriteExternal() {
        return this.mWriteExternal;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return this.mMacAddress ? Intrinsics.stringPlus(NestInfoTaker.INSTANCE.getMacAddress(), "") : "";
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return this.mRecordAudio;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return this.mWifiState;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
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

    public final void setMOaid(boolean z) {
        this.mOaid = z;
    }

    public final void setMPhoneState(boolean z) {
        this.mPhoneState = z;
    }

    public final void setMRecordAudio(boolean z) {
        this.mRecordAudio = z;
    }

    public final void setMWifiState(boolean z) {
        this.mWifiState = z;
    }

    public final void setMWriteExternal(boolean z) {
        this.mWriteExternal = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public CsjDefaultLocationMode getTTLocation() {
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
        WifiLog.d("CsjDefaultController mLongitude = " + this.mLongitude + " , mLatitude = " + this.mLatitude);
        return new CsjDefaultLocationMode(this.mLongitude, this.mLatitude);
    }
}
