package com.wifi.beizi.ad;

import android.content.Context;
import com.beizi.fusion.BeiZiCustomController;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.WifiLog;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006'"}, d2 = {"Lcom/wifi/beizi/ad/BeiziDefaultController;", "Lcom/beizi/fusion/BeiZiCustomController;", "mContext", "Landroid/content/Context;", "canUseLocation", "", "gaid", "phoneState", "oaid", "wifiState", "(Landroid/content/Context;ZZZZZ)V", "mCanUseLocation", "getMCanUseLocation", "()Z", "setMCanUseLocation", "(Z)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mGaid", "getMGaid", "setMGaid", "mOaid", "getMOaid", "setMOaid", "mPhoneState", "getMPhoneState", "setMPhoneState", "mWifiState", "getMWifiState", "setMWifiState", "getDevOaid", "", "isCanUseGaid", "isCanUseLocation", "isCanUseOaid", "isCanUsePhoneState", "isCanUseWifiState", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class BeiziDefaultController extends BeiZiCustomController {
    private boolean mCanUseLocation;
    private Context mContext;
    private boolean mGaid;
    private boolean mOaid;
    private boolean mPhoneState;
    private boolean mWifiState;

    public BeiziDefaultController(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.mContext = context;
        this.mGaid = z2;
        this.mCanUseLocation = z;
        this.mPhoneState = z3;
        this.mOaid = z4;
        this.mWifiState = z5;
        WifiLog.d("sdkPrivilegeController beiziMananger isCanUseLocation " + this.mCanUseLocation + "  isCanUsePhoneState " + this.mPhoneState + " isCanUseWifiState " + this.mWifiState + " isOaid " + this.mOaid + " isGaid " + this.mGaid);
    }

    @Override // com.beizi.fusion.BeiZiCustomController
    public String getDevOaid() {
        String oaId;
        return (!this.mOaid || (oaId = NestInfoTaker.INSTANCE.getOaId()) == null) ? "" : oaId;
    }

    public final boolean getMCanUseLocation() {
        return this.mCanUseLocation;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final boolean getMGaid() {
        return this.mGaid;
    }

    public final boolean getMOaid() {
        return this.mOaid;
    }

    public final boolean getMPhoneState() {
        return this.mPhoneState;
    }

    public final boolean getMWifiState() {
        return this.mWifiState;
    }

    @Override // com.beizi.fusion.BeiZiCustomController
    public boolean isCanUseGaid() {
        return this.mGaid;
    }

    @Override // com.beizi.fusion.BeiZiCustomController
    public boolean isCanUseLocation() {
        return this.mCanUseLocation;
    }

    @Override // com.beizi.fusion.BeiZiCustomController
    public boolean isCanUseOaid() {
        return false;
    }

    @Override // com.beizi.fusion.BeiZiCustomController
    public boolean isCanUsePhoneState() {
        return this.mPhoneState;
    }

    @Override // com.beizi.fusion.BeiZiCustomController
    public boolean isCanUseWifiState() {
        return this.mWifiState;
    }

    public final void setMCanUseLocation(boolean z) {
        this.mCanUseLocation = z;
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }

    public final void setMGaid(boolean z) {
        this.mGaid = z;
    }

    public final void setMOaid(boolean z) {
        this.mOaid = z;
    }

    public final void setMPhoneState(boolean z) {
        this.mPhoneState = z;
    }

    public final void setMWifiState(boolean z) {
        this.mWifiState = z;
    }
}
