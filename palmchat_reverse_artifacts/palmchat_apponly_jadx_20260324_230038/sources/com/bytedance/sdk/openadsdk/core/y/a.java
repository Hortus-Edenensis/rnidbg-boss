package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import com.umeng.analytics.pro.bt;
import j$.util.function.Function$CC;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a implements com.bytedance.sdk.component.b.u.u, Function {
    public String a() {
        return com.bytedance.sdk.openadsdk.core.sx.o();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return getAndroidId();
            case 2:
            case 6:
            case 19:
            case 22:
            case 23:
            case 24:
            case 27:
            case 28:
            default:
                return null;
            case 3:
                return Integer.valueOf(u());
            case 4:
                return getDeviceModel();
            case 5:
                return nr();
            case 7:
                return fx();
            case 8:
                return getLocalLanguage();
            case 9:
                return getMcc();
            case 10:
                return getMnc();
            case 11:
                return Integer.valueOf(b());
            case 12:
                return pn();
            case 13:
                return iz();
            case 14:
                return getTotalMem();
            case 15:
                return getTotalSpace();
            case 16:
                return x();
            case 17:
                return n();
            case 18:
                return a();
            case 20:
                return getIP();
            case 21:
                return getUUId();
            case 25:
                return getCompilingTime();
            case 26:
                return getBuildSerial();
            case 29:
                return jk();
            case 30:
                return getRom();
            case 31:
                return Integer.valueOf(getTimeZoneInt());
            case 32:
                return t();
            case 33:
                return Integer.valueOf(getDeviceType(((Boolean) sparseArray.get(1)).booleanValue()));
            case 34:
                return getWebViewUA();
            case 35:
                return getNewIpAddrs(((Boolean) sparseArray.get(1)).booleanValue());
            case 36:
                return getWifiMac((Boolean) sparseArray.get(1));
            case 37:
                com.bytedance.sdk.component.b.u.fx location = getLocation();
                return location != null ? new com.bytedance.sdk.component.b.u.b(location) : location;
            case 38:
                return getImei((Boolean) sparseArray.get(1));
            case 39:
                return getMacAddress((Boolean) sparseArray.get(1));
            case 40:
                return getSSID((Boolean) sparseArray.get(1));
            case 41:
                return getImsi((Boolean) sparseArray.get(1));
            case 42:
                return getOAID(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return getAppLogDid();
            case 44:
                return getIpv6();
        }
    }

    public int b() {
        return 1;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public String fx() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getAndroidId() {
        return com.bytedance.sdk.openadsdk.core.sx.iz();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getAppLogDid() {
        return com.bytedance.sdk.openadsdk.core.iz.u().fx();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getBuildSerial() {
        return com.bytedance.sdk.openadsdk.core.sx.n();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getCompilingTime() {
        return com.bytedance.sdk.openadsdk.core.sx.b();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getDeviceModel() {
        return com.bytedance.sdk.openadsdk.core.sx.sx();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public int getDeviceType(boolean z) {
        return t.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), z);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getIP() {
        return sx.fx();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getImei(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.sx.u(bool);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getImsi(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.sx.nr(bool);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getIpv6() {
        return sx.b();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getLocalLanguage() {
        return t.iz();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public com.bytedance.sdk.component.b.u.fx getLocation() {
        return b.u(com.bytedance.sdk.openadsdk.core.dw.getContext());
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getMacAddress(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.sx.pn(bool);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getMcc() {
        return com.bytedance.sdk.openadsdk.core.sx.mv();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getMnc() {
        return com.bytedance.sdk.openadsdk.core.sx.k();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String[] getNewIpAddrs(boolean z) {
        return sx.nr(z);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getOAID(boolean z) {
        return qq.u(z);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getRom() {
        return com.bytedance.sdk.openadsdk.core.qq.u.t();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getSSID(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.sx.fx(bool);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public int getTimeZoneInt() {
        return com.bytedance.sdk.openadsdk.core.qq.u.l();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getTotalMem() {
        return String.valueOf(Long.parseLong(jp.l()) * 1024);
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getTotalSpace() {
        return String.valueOf(jp.o());
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getUUId() {
        return com.bytedance.sdk.openadsdk.core.fx.u.fx();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getWebViewUA() {
        return jp.x();
    }

    @Override // com.bytedance.sdk.component.b.u.u
    public String getWifiMac(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.sx.b(bool);
    }

    public String iz() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public String jk() {
        return jp.iz();
    }

    public String n() {
        String string;
        double dCurrentTimeMillis = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d;
        try {
            string = new Formatter().format("%.6f", Double.valueOf(dCurrentTimeMillis)).toString();
        } catch (Exception unused) {
            string = "";
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return new DecimalFormat("#0.000000").format(dCurrentTimeMillis);
        } catch (Exception unused2) {
            return string;
        }
    }

    public String nr() {
        Context context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        return context == null ? "" : Settings.Global.getString(context.getContentResolver(), bt.J);
    }

    public String pn() {
        return Build.VERSION.RELEASE;
    }

    public String t() {
        return com.bytedance.sdk.openadsdk.core.qq.u.u(y.n(com.bytedance.sdk.openadsdk.core.dw.getContext()));
    }

    public int u() {
        return com.bytedance.sdk.component.utils.o.fx(com.bytedance.sdk.openadsdk.core.dw.getContext());
    }

    public String x() {
        return Build.MANUFACTURER;
    }
}
