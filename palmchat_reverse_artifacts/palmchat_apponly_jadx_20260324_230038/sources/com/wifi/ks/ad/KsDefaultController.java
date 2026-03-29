package com.wifi.ks.ad;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.kwad.sdk.api.KsCustomController;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.LocationUtil;
import com.wifi.ad.core.utils.WifiLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.jssdk.general.Action;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020=H\u0016J\n\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010@H\u0016J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020=H\u0016J\b\u0010D\u001a\u00020=H\u0016R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\u001a\u0010,\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012R\u001a\u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u001a\u00102\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012¨\u0006E"}, d2 = {"Lcom/wifi/ks/ad/KsDefaultController;", "Lcom/kwad/sdk/api/KsCustomController;", "mContext", "Landroid/content/Context;", "canUseLocation", "", "alist", "phoneState", "macAddress", "oaid", "wifiState", "storagePermission", "androidID", "(Landroid/content/Context;ZZZZZZZZ)V", "mAlist", "getMAlist", "()Z", "setMAlist", "(Z)V", "mAndroidID", "getMAndroidID", "setMAndroidID", "mCanUseLocation", "getMCanUseLocation", "setMCanUseLocation", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mLatitude", "", "getMLatitude", "()D", "setMLatitude", "(D)V", "mLongitude", "getMLongitude", "setMLongitude", "mMacAddress", "getMMacAddress", "setMMacAddress", "mOaid", "getMOaid", "setMOaid", "mPhoneState", "getMPhoneState", "setMPhoneState", "mStoragePermission", "getMStoragePermission", "setMStoragePermission", "mWifiState", "getMWifiState", "setMWifiState", "canReadInstalledPackages", "canReadLocation", "canUseMacAddress", "canUseNetworkState", "canUseOaid", "canUsePhoneState", "canUseStoragePermission", "getAndroidId", "", "getImei", "getInstalledPackages", "", Action.ACTION_GET_LOCATION, "Landroid/location/Location;", "getMacAddress", "getOaid", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class KsDefaultController extends KsCustomController {
    private boolean mAlist;
    private boolean mAndroidID;
    private boolean mCanUseLocation;
    private Context mContext;
    private double mLatitude;
    private double mLongitude;
    private boolean mMacAddress;
    private boolean mOaid;
    private boolean mPhoneState;
    private boolean mStoragePermission;
    private boolean mWifiState;

    public KsDefaultController(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.mContext = context;
        this.mAlist = z2;
        this.mCanUseLocation = z;
        this.mPhoneState = z3;
        this.mMacAddress = z4;
        this.mOaid = z5;
        this.mWifiState = z6;
        this.mStoragePermission = z7;
        this.mAndroidID = z8;
        WifiLog.d("sdkPrivilegeController ksMananger isCanUseLocation " + this.mCanUseLocation + " isCanUseInstalledPackages " + this.mAlist + " isCanUsePhoneState " + this.mPhoneState + "  isCanUseWifiState " + this.mWifiState + " isCanUseMacAddress " + this.mMacAddress + " isCanUseOaid " + this.mOaid + " iscanUseStoragePermission " + this.mStoragePermission + " mAndroidID " + this.mAndroidID);
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canReadInstalledPackages() {
        return false;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canReadLocation() {
        return false;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUseMacAddress() {
        return false;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    /* JADX INFO: renamed from: canUseNetworkState, reason: from getter */
    public boolean getMWifiState() {
        return this.mWifiState;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUseOaid() {
        return false;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public boolean canUsePhoneState() {
        return false;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    /* JADX INFO: renamed from: canUseStoragePermission, reason: from getter */
    public boolean getMStoragePermission() {
        return this.mStoragePermission;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public String getAndroidId() {
        String androidId;
        return (!this.mAndroidID || (androidId = NestInfoTaker.INSTANCE.getAndroidId()) == null) ? "" : androidId;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public String getImei() {
        if (!this.mPhoneState) {
            return null;
        }
        String imEI1 = NestInfoTaker.INSTANCE.getImEI1(this.mContext);
        if (TextUtils.isEmpty(imEI1)) {
            return null;
        }
        return imEI1;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public List<String> getInstalledPackages() {
        if (this.mAlist) {
            return NestInfoTaker.INSTANCE.getInstalledPackages();
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public Location getLocation() {
        if (!this.mCanUseLocation) {
            return null;
        }
        Location location = new Location("ks_provider");
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
            if (this.mLatitude == 0.0d && this.mLongitude == 0.0d) {
                return null;
            }
            WifiLog.d("KsDefaultController mLongitude = " + this.mLongitude + " , mLatitude = " + this.mLatitude);
            location.setLongitude(this.mLongitude);
            location.setLatitude(this.mLatitude);
        } catch (Exception unused) {
        }
        return location;
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

    public final boolean getMStoragePermission() {
        return this.mStoragePermission;
    }

    public final boolean getMWifiState() {
        return this.mWifiState;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public String getMacAddress() {
        String macAddress;
        return (!this.mMacAddress || (macAddress = NestInfoTaker.INSTANCE.getMacAddress()) == null) ? "" : macAddress;
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public String getOaid() {
        String oaId;
        return (!this.mOaid || (oaId = NestInfoTaker.INSTANCE.getOaId()) == null) ? "" : oaId;
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

    public final void setMStoragePermission(boolean z) {
        this.mStoragePermission = z;
    }

    public final void setMWifiState(boolean z) {
        this.mWifiState = z;
    }
}
