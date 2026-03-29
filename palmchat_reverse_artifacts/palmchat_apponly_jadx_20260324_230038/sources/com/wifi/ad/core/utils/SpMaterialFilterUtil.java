package com.wifi.ad.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.spstrategy.SPMaterialModel;
import com.wifi.ad.core.spstrategy.SPTaiChiManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/wifi/ad/core/utils/SpMaterialFilterUtil;", "", "()V", "TIME_TWELVE_HOURS", "", "materialControlSpName", "", "spFrequencyTime", "spLastDeleteTime", "spLastShowTime", "spMaterialControlInfo", "spShowTimes", "materialFilter", "", "mContext", "Landroid/content/Context;", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "saveMaterialFrequencyInfo", "", "nestAdData", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SpMaterialFilterUtil {
    public static final SpMaterialFilterUtil INSTANCE = new SpMaterialFilterUtil();
    private static final String materialControlSpName = "material_control_sp";
    private static final String spMaterialControlInfo = "material_control_info_";
    private static final String spLastShowTime = "material_last_show_time";
    private static final String spShowTimes = "material_showed_times";
    private static final String spFrequencyTime = "material_frequency_time";
    private static final String spLastDeleteTime = "material_delete_times_";
    private static final int TIME_TWELVE_HOURS = 43200000;

    private SpMaterialFilterUtil() {
    }

    public final synchronized boolean materialFilter(Context mContext, NestAdData adData) {
        String coverUrl;
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        boolean z = true;
        if (!TextUtils.isEmpty(wifiNestAd.getTaiChikeys$core_release())) {
            String taiChikeys$core_release = wifiNestAd.getTaiChikeys$core_release();
            if (taiChikeys$core_release == null) {
                Intrinsics.throwNpe();
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) taiChikeys$core_release, (CharSequence) SPTaiChiManager.SP_KEY_MATERIAL_CONTROL_TAICHI, false, 2, (Object) null)) {
                if (mContext != null && adData.getMaterialModel() != null) {
                    SensitiveInfo sensitiveInfo = adData.getSensitiveInfo();
                    SPMaterialModel materialModel = adData.getMaterialModel();
                    if (materialModel == null) {
                        Intrinsics.throwNpe();
                    }
                    List<String> url_prefix = materialModel.getUrl_prefix();
                    if (sensitiveInfo == null || (TextUtils.isEmpty(sensitiveInfo.getVideoUrl()) && TextUtils.isEmpty(sensitiveInfo.getCoverUrl()))) {
                        return true;
                    }
                    SensitiveInfo sensitiveInfo2 = adData.getSensitiveInfo();
                    if (sensitiveInfo2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (TextUtils.isEmpty(sensitiveInfo2.getVideoUrl())) {
                        SensitiveInfo sensitiveInfo3 = adData.getSensitiveInfo();
                        if (sensitiveInfo3 == null) {
                            Intrinsics.throwNpe();
                        }
                        coverUrl = sensitiveInfo3.getCoverUrl();
                    } else {
                        SensitiveInfo sensitiveInfo4 = adData.getSensitiveInfo();
                        if (sensitiveInfo4 == null) {
                            Intrinsics.throwNpe();
                        }
                        coverUrl = sensitiveInfo4.getVideoUrl();
                    }
                    String string = coverUrl;
                    List<String> list = url_prefix;
                    if (!(list == null || list.isEmpty())) {
                        int size = url_prefix.size();
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                string = "";
                                break;
                            }
                            if (TextUtils.isEmpty(url_prefix.get(i)) || !StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) url_prefix.get(i), false, 2, (Object) null)) {
                                i++;
                            } else {
                                String strReplaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(string, url_prefix.get(i), "", false, 4, (Object) null);
                                if (strReplaceFirst$default == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                }
                                string = StringsKt__StringsKt.trim((CharSequence) strReplaceFirst$default).toString();
                            }
                        }
                    }
                    String md5 = MD5Util.toMD5(string);
                    Intrinsics.checkExpressionValueIsNotNull(md5, "MD5Util.toMD5(newMaterialUrl)");
                    WifiLog.d("md5url = " + md5);
                    SharedPreferences sharedPreferences = mContext.getSharedPreferences(materialControlSpName, 0);
                    Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "mContext!!.getSharedPref…me, Context.MODE_PRIVATE)");
                    int iCurrentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
                    SPMaterialModel materialModel2 = adData.getMaterialModel();
                    if (materialModel2 == null) {
                        Intrinsics.throwNpe();
                    }
                    int frequency_time = materialModel2.getFrequency_time();
                    SPMaterialModel materialModel3 = adData.getMaterialModel();
                    if (materialModel3 == null) {
                        Intrinsics.throwNpe();
                    }
                    int frequency_pv = materialModel3.getFrequency_pv();
                    String string2 = sharedPreferences.getString(spMaterialControlInfo + adData.getAdScene() + "_" + md5, "");
                    if (TextUtils.isEmpty(string2)) {
                        return true;
                    }
                    JSONObject jSONObject = new JSONObject(string2);
                    String str = spShowTimes;
                    int iOptInt = jSONObject.has(str) ? jSONObject.optInt(str) : 0;
                    String str2 = spLastShowTime;
                    if (iCurrentTimeMillis - (jSONObject.has(str2) ? jSONObject.getInt(str2) : iCurrentTimeMillis) <= frequency_time * 60) {
                        WifiLog.d("已经展示了 " + iOptInt + " 次，频控是 " + frequency_pv + " 次");
                        if (iOptInt >= frequency_pv) {
                            z = false;
                        }
                    } else {
                        WifiLog.d("已超过频控时间，不进行素材过滤");
                    }
                    return z;
                }
                return true;
            }
        }
        return true;
    }

    public final synchronized void saveMaterialFrequencyInfo(Context mContext, NestAdData nestAdData) {
        String coverUrl;
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (!TextUtils.isEmpty(wifiNestAd.getTaiChikeys$core_release())) {
            String taiChikeys$core_release = wifiNestAd.getTaiChikeys$core_release();
            if (taiChikeys$core_release == null) {
                Intrinsics.throwNpe();
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) taiChikeys$core_release, (CharSequence) SPTaiChiManager.SP_KEY_MATERIAL_CONTROL_TAICHI, false, 2, (Object) null)) {
                SensitiveInfo sensitiveInfo = nestAdData.getSensitiveInfo();
                if (TextUtils.isEmpty(sensitiveInfo != null ? sensitiveInfo.getVideoUrl() : null)) {
                    SensitiveInfo sensitiveInfo2 = nestAdData.getSensitiveInfo();
                    if (TextUtils.isEmpty(sensitiveInfo2 != null ? sensitiveInfo2.getCoverUrl() : null)) {
                        return;
                    }
                }
                if (mContext != null && nestAdData.getMaterialModel() != null) {
                    SPMaterialModel materialModel = nestAdData.getMaterialModel();
                    if (materialModel == null) {
                        Intrinsics.throwNpe();
                    }
                    List<String> url_prefix = materialModel.getUrl_prefix();
                    SensitiveInfo sensitiveInfo3 = nestAdData.getSensitiveInfo();
                    if (TextUtils.isEmpty(sensitiveInfo3 != null ? sensitiveInfo3.getVideoUrl() : null)) {
                        SensitiveInfo sensitiveInfo4 = nestAdData.getSensitiveInfo();
                        if (sensitiveInfo4 == null) {
                            Intrinsics.throwNpe();
                        }
                        coverUrl = sensitiveInfo4.getCoverUrl();
                    } else {
                        SensitiveInfo sensitiveInfo5 = nestAdData.getSensitiveInfo();
                        if (sensitiveInfo5 == null) {
                            Intrinsics.throwNpe();
                        }
                        coverUrl = sensitiveInfo5.getVideoUrl();
                    }
                    String string = coverUrl;
                    List<String> list = url_prefix;
                    if (!(list == null || list.isEmpty())) {
                        if (url_prefix == null) {
                            Intrinsics.throwNpe();
                        }
                        int size = url_prefix.size();
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                string = "";
                                break;
                            } else if (StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) url_prefix.get(i), false, 2, (Object) null)) {
                                String strReplaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(string, url_prefix.get(i), "", false, 4, (Object) null);
                                if (strReplaceFirst$default == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                }
                                string = StringsKt__StringsKt.trim((CharSequence) strReplaceFirst$default).toString();
                            } else {
                                i++;
                            }
                        }
                    }
                    String md5 = MD5Util.toMD5(string);
                    Intrinsics.checkExpressionValueIsNotNull(md5, "MD5Util.toMD5(newMaterialUrl)");
                    WifiLog.d("md5url = " + md5);
                    SharedPreferences sharedPreferences = mContext.getSharedPreferences(materialControlSpName, 0);
                    Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "mContext!!.getSharedPref…me, Context.MODE_PRIVATE)");
                    long j = (long) 1000;
                    int iCurrentTimeMillis = (int) (System.currentTimeMillis() / j);
                    SPMaterialModel materialModel2 = nestAdData.getMaterialModel();
                    if (materialModel2 == null) {
                        Intrinsics.throwNpe();
                    }
                    int frequency_time = materialModel2.getFrequency_time();
                    StringBuilder sb = new StringBuilder();
                    String str = spMaterialControlInfo;
                    sb.append(str);
                    sb.append(nestAdData.getAdScene());
                    sb.append("_");
                    sb.append(md5);
                    String string2 = sharedPreferences.getString(sb.toString(), "");
                    if (TextUtils.isEmpty(string2)) {
                        WifiLog.d("第一次展示");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(spLastShowTime, iCurrentTimeMillis);
                        jSONObject.put(spShowTimes, 1);
                        jSONObject.put(spFrequencyTime, frequency_time);
                        WifiLog.d("第一次展示时间是 " + iCurrentTimeMillis + ' ');
                        sharedPreferences.edit().putString(str + nestAdData.getAdScene() + "_" + md5, jSONObject.toString()).apply();
                    } else {
                        JSONObject jSONObject2 = new JSONObject(string2);
                        String str2 = spShowTimes;
                        int iOptInt = jSONObject2.has(str2) ? jSONObject2.optInt(str2) : 0;
                        String str3 = spLastShowTime;
                        int i2 = iCurrentTimeMillis - (jSONObject2.has(str3) ? jSONObject2.getInt(str3) : iCurrentTimeMillis) <= frequency_time * 60 ? iOptInt + 1 : 1;
                        WifiLog.d("已经展示了 " + i2 + " 次");
                        if (i2 == 1) {
                            jSONObject2.put(str3, iCurrentTimeMillis);
                            WifiLog.d("超过时间后，第一次展示时间是 " + iCurrentTimeMillis + ' ');
                        }
                        jSONObject2.put(str2, i2);
                        jSONObject2.put(spFrequencyTime, frequency_time);
                        sharedPreferences.edit().putString(str + nestAdData.getAdScene() + "_" + md5, jSONObject2.toString()).apply();
                    }
                    if (System.currentTimeMillis() - sharedPreferences.getLong(spLastDeleteTime, 0L) >= TIME_TWELVE_HOURS) {
                        Map<String, ?> all = sharedPreferences.getAll();
                        if (all == null || all.isEmpty()) {
                            return;
                        }
                        for (String str4 : all.keySet()) {
                            if (!TextUtils.isEmpty(str4) && sharedPreferences.contains(str4) && (!Intrinsics.areEqual(spLastDeleteTime, str4))) {
                                String string3 = sharedPreferences.getString(str4, "");
                                if (!TextUtils.isEmpty(string3)) {
                                    JSONObject jSONObject3 = new JSONObject(string3);
                                    String str5 = spLastShowTime;
                                    if (jSONObject3.has(str5)) {
                                        if (jSONObject3.has(spFrequencyTime)) {
                                            if ((System.currentTimeMillis() / j) - ((long) jSONObject3.optInt(str5)) > jSONObject3.optInt(r5) * 60) {
                                                WifiLog.d("删除的sp key是: " + str4 + ' ');
                                                sharedPreferences.edit().remove(str4).apply();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        sharedPreferences.edit().putLong(spLastDeleteTime, System.currentTimeMillis()).apply();
                    }
                }
            }
        }
    }
}
