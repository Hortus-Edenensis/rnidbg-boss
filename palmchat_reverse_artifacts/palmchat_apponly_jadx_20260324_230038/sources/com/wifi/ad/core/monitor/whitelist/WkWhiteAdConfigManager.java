package com.wifi.ad.core.monitor.whitelist;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.constants.WifiNestConst;
import com.wifi.ad.core.data.WhiteFilterConfigBean;
import com.wifi.ad.core.monitor.IWkConfigCallBack;
import com.wifi.ad.core.monitor.WkConfigHttp;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.Async;
import com.wifi.ad.core.utils.DeviceUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkWhiteAdConfigManager implements IWkConfigCallBack<WkWhiteAdConfigResponse.SdkWhiteResponse> {
    public static final String FILTER_CONFIG_ENABLE = "adsdk_filter_enable";
    private static final String FILTER_CONFIG_UPDATE_INTERVAL = "adsdk_filter_update_interval";
    public static final String FILTER_CONFIG_WHITELIST = "adsdk_filter_white_list";
    public static WhiteFilterConfigBean filterWhiteConfigBean = null;
    private static final String mSpName = "wkadsdk_white_config_adx";
    private Context mContext;
    private SharedPreferences mSp;
    private final String mSpDiDKey = "adsdk_did_key";
    private final String mSpLastUpdateKey = "wkadsdk_last_update_key";
    private final String FILTER_CONFIG_VERSION = "adsdk_update_version";
    private final String FILTER_CONFIG_UPDATE_TYPE = "adsdk_filter_update_type";
    private long mUpDateTime = 0;

    public WkWhiteAdConfigManager(Context context) {
        this.mSp = null;
        this.mContext = context;
        this.mSp = context.getSharedPreferences(mSpName, 0);
    }

    private void addPkgs(List<String> list, Set<String> set) {
        if (isListNull(list)) {
            return;
        }
        try {
            if (set == null) {
                new HashSet().addAll(list);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (!TextUtils.isEmpty(list.get(i))) {
                    set.add(list.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Set<String> changeWhiteList(List<String> list, List<String> list2) {
        String whiteListFromSp = getWhiteListFromSp(this.mSp);
        Set<String> listFromStr = !TextUtils.isEmpty(whiteListFromSp) ? getListFromStr(whiteListFromSp) : null;
        if (isListNull(list) && isListNull(list2)) {
            return listFromStr;
        }
        addPkgs(list, listFromStr);
        removePkgs(list2, listFromStr);
        saveWhiteListToSp(this.mSp, getListToStr(listFromStr));
        return listFromStr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDid() {
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        return DeviceUtils.getAesRes(nestInfoTaker.getImEI1(this.mContext), "", nestInfoTaker.getAndroidId(), nestInfoTaker.getOaId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDidBySp() {
        return this.mSp.getString("adsdk_did_key", "");
    }

    private static Set<String> getListFromStr(String str) {
        HashSet hashSet = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            List listAsList = Arrays.asList(strArr);
            HashSet hashSet2 = new HashSet();
            try {
                hashSet2.addAll(listAsList);
                return hashSet2;
            } catch (Exception e) {
                e = e;
                hashSet = hashSet2;
                e.printStackTrace();
                return hashSet;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private String getListToStr(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            try {
                String[] strArr = (String[]) set.toArray(new String[set.size()]);
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(str);
                }
                return jSONArray.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static WhiteFilterConfigBean getLocalFilterConfig(Context context) {
        WhiteFilterConfigBean whiteFilterConfigBean = filterWhiteConfigBean;
        if (whiteFilterConfigBean != null) {
            return whiteFilterConfigBean;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(mSpName, 0);
        String string = sharedPreferences.getString(FILTER_CONFIG_WHITELIST, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        getWhiteConfigBean(sharedPreferences.getInt(FILTER_CONFIG_ENABLE, 0), sharedPreferences.getInt(FILTER_CONFIG_UPDATE_INTERVAL, 0), getListFromStr(string));
        return filterWhiteConfigBean;
    }

    private int getUpdateType(WkWhiteAdConfigResponse.Data data) {
        return data.getUpdateType().getNumber();
    }

    private static void getWhiteConfigBean(int i, int i2, Set<String> set) {
        if (isHashSetNull(set)) {
            filterWhiteConfigBean = null;
            return;
        }
        WhiteFilterConfigBean whiteFilterConfigBean = new WhiteFilterConfigBean();
        filterWhiteConfigBean = whiteFilterConfigBean;
        whiteFilterConfigBean.setUpdate_interval(i2);
        filterWhiteConfigBean.setEnbale(i);
        filterWhiteConfigBean.setFullList(set);
    }

    private String getWhiteListFromSp(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(FILTER_CONFIG_WHITELIST, null);
    }

    private String getWhiteListVersion(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("adsdk_update_version", "");
    }

    private static boolean isHashSetNull(Set<String> set) {
        return set == null || set.isEmpty();
    }

    private static boolean isListNull(List<String> list) {
        return list == null || list.isEmpty();
    }

    private void onEventWhiteListFail(String str, String str2) {
        WifiNestAd.reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_WHITELIST_FAIL, new EventParams.Builder().setErrorCode(str + ":" + str2).build(), new HashMap());
    }

    private void removePkgs(List<String> list, Set<String> set) {
        if (isHashSetNull(set) || isListNull(list)) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                if (!TextUtils.isEmpty(list.get(i))) {
                    set.remove(list.get(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAdHttp(int i, String str, String str2, String str3) {
        WkConfigHttp.postWhiteResponseData(this.mContext, str, i, str3, str2, this, getWhiteListVersion(this.mSp));
    }

    private void saveConfig(WkWhiteAdConfigResponse.Data data, String str, int i) {
        this.mSp.edit().putInt(FILTER_CONFIG_ENABLE, data.getEnable()).apply();
        this.mSp.edit().putString("adsdk_update_version", data.getVersion()).apply();
        this.mSp.edit().putInt("adsdk_filter_update_type", i).apply();
        this.mSp.edit().putInt(FILTER_CONFIG_UPDATE_INTERVAL, data.getUpdateInterval()).apply();
        this.mSp.edit().putLong("wkadsdk_last_update_key" + str, System.currentTimeMillis()).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveDidSp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSp.edit().putString("adsdk_did_key", str).apply();
    }

    private void saveSuccess(WkWhiteAdConfigResponse.Data data, String str) {
        String listToStr;
        int updateType = getUpdateType(data);
        saveConfig(data, str, updateType);
        Set<String> listFromStr = null;
        if (updateType == 0) {
            String whiteListFromSp = getWhiteListFromSp(this.mSp);
            if (!TextUtils.isEmpty(whiteListFromSp)) {
                listFromStr = getListFromStr(whiteListFromSp);
            }
        } else if (updateType == 1) {
            if (isListNull(data.getFullListList())) {
                listToStr = "";
            } else {
                listFromStr = new HashSet<>();
                listFromStr.addAll(data.getFullListList());
                listToStr = getListToStr(listFromStr);
            }
            saveWhiteListToSp(this.mSp, listToStr);
        } else if (updateType == 2) {
            listFromStr = changeWhiteList(data.getAddedListList(), data.getRemovedListList());
        }
        getWhiteConfigBean(data.getEnable(), data.getUpdateInterval(), listFromStr);
    }

    private void saveWhiteListToSp(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().putString(FILTER_CONFIG_WHITELIST, str).apply();
    }

    @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
    public void dataError(String str) {
        onEventWhiteListFail("-3", str);
    }

    public void requestConfig(final int i, final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.mSp.getLong("wkadsdk_last_update_key" + i, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        WhiteFilterConfigBean localFilterConfig = getLocalFilterConfig(this.mContext);
        filterWhiteConfigBean = localFilterConfig;
        if (localFilterConfig != null) {
            this.mUpDateTime = localFilterConfig.getUpdate_interval();
        }
        if (jCurrentTimeMillis - j >= this.mUpDateTime * 60 * 60 * 1000) {
            Async.INSTANCE.getCache().execute(new Runnable() { // from class: com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigManager.1
                @Override // java.lang.Runnable
                public void run() {
                    String didBySp = WkWhiteAdConfigManager.this.getDidBySp();
                    if (TextUtils.isEmpty(didBySp)) {
                        didBySp = WkWhiteAdConfigManager.this.getDid();
                        if (!TextUtils.isEmpty(didBySp)) {
                            WkWhiteAdConfigManager.this.saveDidSp(didBySp);
                        }
                    }
                    WkWhiteAdConfigManager.this.requestAdHttp(i, str, didBySp, str2);
                }
            });
        }
    }

    @Override // com.wifi.ad.core.monitor.IWkConfigCallBack
    public void dataSuccess(WkWhiteAdConfigResponse.SdkWhiteResponse sdkWhiteResponse, int i, String str) {
        if (sdkWhiteResponse == null) {
            onEventWhiteListFail("-1", null);
            return;
        }
        if (sdkWhiteResponse.getCode() != 0) {
            onEventWhiteListFail(sdkWhiteResponse.getCode() + "", sdkWhiteResponse.getMsg());
            return;
        }
        WkWhiteAdConfigResponse.Data data = sdkWhiteResponse.getData();
        if (data == null) {
            onEventWhiteListFail("-2", null);
            return;
        }
        saveSuccess(data, i + "");
    }
}
