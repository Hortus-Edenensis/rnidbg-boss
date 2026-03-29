package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.iz;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.bytedance.sdk.openadsdk.mediation.u.nr;
import defpackage.wc7;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationInitConfig {
    private static String u = "MEDIATION_LOG";
    private ValueSet b;
    private ValueSet fx;
    private ValueSet nr;

    private MediationInitConfig(ValueSet valueSet) {
        this.nr = valueSet;
        if (valueSet != null) {
            this.b = wc7.k((SparseArray) valueSet.objectValue(8457, SparseArray.class)).a();
            this.fx = wc7.k((SparseArray) this.nr.objectValue(8475, SparseArray.class)).a();
        }
        u();
    }

    private void b() {
        iz.fx(u, "---------  sdk 隐私设置 start ----");
        iz.fx(u, "isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            iz.fx(u, "getLocation getLatitude：" + location.getLatitude());
            iz.fx(u, "getLocation getLongitude：" + location.getLongitude());
        } else {
            iz.fx(u, "getLocation is null");
        }
        iz.fx(u, "appList：" + appList());
        iz.fx(u, "isCanUsePhoneState：" + isCanUsePhoneState());
        iz.fx(u, "isLimitPersonalAds：" + isLimitPersonalAds());
        iz.fx(u, "getDevImei：" + getDevImei());
        iz.fx(u, "isCanUseWifiState：" + isCanUseWifiState());
        iz.fx(u, "getMacAddress：" + getMacAddress());
        iz.fx(u, "isCanUseWriteExternal：" + isCanUseWriteExternal());
        iz.fx(u, "isCanUseAndroidId：" + isCanUseAndroidId());
        iz.fx(u, "getAndroidId：" + getAndroidId());
        iz.fx(u, "isCanUseMessage：" + isCanUseMessage());
        List<String> appList = getAppList();
        iz.fx(u, "getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                iz.fx(u, "getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        iz.fx(u, "getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                iz.fx(u, "getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        iz.fx(u, "getDevOaid：" + getDevOaid());
        iz.fx(u, "isCanUseOaid：" + isCanUseOaid());
        iz.fx(u, "isCanUseMacAddress：" + isCanUseMacAddress());
        iz.fx(u, "isProgrammaticRecommend：" + isProgrammaticRecommend());
        iz.fx(u, "isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        iz.fx(u, "---------  sdk 隐私设置 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    private void fx() {
        iz.fx(u, "---------  sdk 初始化信息 start ----");
        iz.fx(u, "isDebug：" + isDebug());
        iz.fx(u, "getClassName：" + getClassName());
        iz.fx(u, "getAppId：" + getAppId());
        iz.fx(u, "getAppName：" + getAppName());
        iz.fx(u, "getADNName：" + getADNName());
        iz.fx(u, "getAppKey：" + getAppKey());
        iz.fx(u, "getInitCallback：" + getInitCallback());
        iz.fx(u, "getAgeGroup：" + getAgeGroup());
        iz.fx(u, "isCustom：" + isCustom());
        iz.fx(u, "getCustomInitConfig：" + getCustomInitConfig());
        iz.fx(u, "getCustomInitMap：" + getCustomInitMap());
        iz.fx(u, "getCustomGMConfiguration：" + getCustomGMConfiguration());
        iz.fx(u, "getKsAdapterVersion：" + getKsAdapterVersion());
        iz.fx(u, "getGromoreVersion：" + getGromoreVersion());
        iz.fx(u, "getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        iz.fx(u, "getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        iz.fx(u, "getGdtAdapterVersion：" + getGdtAdapterVersion());
        iz.fx(u, "getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        iz.fx(u, "getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        iz.fx(u, "getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        iz.fx(u, "getUnityAdapterVersion：" + getUnityAdapterVersion());
        iz.fx(u, "getMap：" + getInitAdnMap());
        iz.fx(u, "---------  sdk 初始化信息 end ----");
    }

    private void nr() {
        iz.fx(u, "---------  sdk 聚合信息 start ----");
        iz.fx(u, "getHttps：" + getHttps());
        iz.fx(u, "getWxAppId：" + getWxAppId());
        iz.fx(u, "getPublisherDid：" + getPublisherDid());
        iz.fx(u, "isOpenAdnTest：" + isOpenAdnTest());
        iz.fx(u, "getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        iz.fx(u, "getLocalExtra：" + getLocalExtra());
        iz.fx(u, "getCustomLocalConfig：" + getCustomLocalConfig());
        iz.fx(u, "getOpensdkVer：" + getOpensdkVer());
        iz.fx(u, "isWxInstalled：" + isWxInstalled());
        iz.fx(u, "isSupportH265：" + isSupportH265());
        iz.fx(u, "isSupportSplashZoomout：" + isSupportSplashZoomout());
        iz.fx(u, "---------  sdk 聚合信息 end ----");
    }

    private boolean pn() {
        ValueSet valueSet = this.nr;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private void u() {
        fx();
        b();
        nr();
    }

    public boolean appList() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        return pn() ? this.nr.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getAdapterManagerClassName() {
        ValueSet valueSet = this.nr;
        if (valueSet != null) {
            return valueSet.stringValue(8560);
        }
        return null;
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public int getAgeGroup() {
        if (pn()) {
            return this.nr.intValue(7);
        }
        return 0;
    }

    public String getAndroidId() {
        ValueSet valueSet = this.fx;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public String getAppId() {
        if (pn()) {
            return this.nr.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        return pn() ? this.nr.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> functionU;
        ValueSet valueSet = this.fx;
        if (valueSet != null && (functionU = nr.u(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionU instanceof Supplier ? ((Supplier) functionU).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAppName() {
        return pn() ? this.nr.stringValue(8) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getClassName() {
        return pn() ? this.nr.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Function getCustomGMConfiguration() {
        if (pn()) {
            return nr.u(this.nr.objectValue(8401, Object.class));
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (pn()) {
            return (MediationCustomInitConfig) this.nr.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (pn()) {
            return wc7.k((SparseArray) this.nr.objectValue(8545, SparseArray.class)).a();
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (pn()) {
            return (Map) this.nr.objectValue(8400, Map.class);
        }
        return null;
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.fx;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> functionU;
        ValueSet valueSet = this.fx;
        if (valueSet != null && (functionU = nr.u(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionU instanceof Supplier ? ((Supplier) functionU).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.fx;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? (Map) valueSet.objectValue(8425, Map.class) : new HashMap();
    }

    public Function getInitCallback() {
        if (pn()) {
            return nr.u(this.nr.objectValue(8300, Object.class));
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.b;
        return valueSet != null ? (Map) valueSet.objectValue(8462, Map.class) : new HashMap();
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> functionU;
        ValueSet valueSet = this.fx;
        if (valueSet != null && (functionU = nr.u(valueSet.objectValue(8312, Object.class))) != null) {
            Object obj = functionU instanceof Supplier ? ((Supplier) functionU).get() : null;
            if (obj instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) obj;
                final double dDoubleValue = ((Double) MediationValueUtil.objectValue(sparseArray.get(8481), Double.class, Double.valueOf(0.0d))).doubleValue();
                final double dDoubleValue2 = ((Double) MediationValueUtil.objectValue(sparseArray.get(8482), Double.class, Double.valueOf(0.0d))).doubleValue();
                return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLatitude() {
                        return dDoubleValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLongitude() {
                        return dDoubleValue2;
                    }
                };
            }
        }
        return null;
    }

    public String getMacAddress() {
        ValueSet valueSet = this.fx;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return nr.u(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.b;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.b;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.nr;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.nr;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.b;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseMessage() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8562);
        }
        return true;
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> functionU;
        ValueSet valueSet = this.fx;
        if (valueSet == null || (functionU = nr.u(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionU instanceof Supplier ? ((Supplier) functionU).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (pn()) {
            return this.nr.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.nr;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> functionU;
        ValueSet valueSet = this.fx;
        if (valueSet == null || (functionU = nr.u(valueSet.objectValue(8311, Object.class))) == null) {
            return false;
        }
        Object obj = functionU instanceof Supplier ? ((Supplier) functionU).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> functionU;
        ValueSet valueSet = this.fx;
        if (valueSet == null || (functionU = nr.u(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionU instanceof Supplier ? ((Supplier) functionU).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.fx = valueSet;
        b();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.fx;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }
}
