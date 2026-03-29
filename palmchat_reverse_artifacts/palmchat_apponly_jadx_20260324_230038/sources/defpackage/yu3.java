package defpackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.wifi.ad.core.sensitive.NestInfoSupplier;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class yu3 extends NestInfoSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22281a;

    public yu3(Context context) {
        this.f22281a = context;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList<String> getInstalledPackages() {
        return PrivInfoManager.INSTANCE.getInstalledApplications();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public NestInfoSupplier.LocationState canSdkUseLocationState() {
        return NestInfoSupplier.LocationState.PARTIAL_USE;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public NestInfoSupplier.PhoneState canSdkUsePhoneState() {
        return NestInfoSupplier.PhoneState.PARTIAL_USE;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public NestInfoSupplier.StorageState canSdkUseSdCardState() {
        return NestInfoSupplier.StorageState.PARTIAL_USE;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getAdxUrl() {
        return o6.a();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public Integer getAge() {
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            try {
                return Integer.valueOf(Integer.parseInt(contactInfoItemF.getAge()));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getAndroidId() {
        return !TextUtils.isEmpty(ac1.p) ? ac1.p : "";
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getAppVer() {
        return ac1.f;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getAppVerName() {
        return ac1.g;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getChannel() {
        return ac1.m;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getConfigTai() {
        return tu3.p();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getDeviceId() {
        return ac1.h;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getDeviceInfo() {
        return ac1.q(this.f22281a);
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getDftConfig(int i) {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig("ad_spmodel_" + i);
        if (dynamicConfig != null) {
            return dynamicConfig.getExtra();
        }
        return null;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public Integer getGender() {
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            return Integer.valueOf(contactInfoItemF.getGender());
        }
        return 0;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getImei() {
        return ac1.i;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getImei1() {
        return ac1.i;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getImei2() {
        return ac1.i;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    @Nullable
    public String getLXUA() {
        return b13.d();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getLatitude() {
        return qu3.a();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getLongitude() {
        return qu3.b();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getLxCityCode() {
        LocationEx locationExI = q05.i();
        return (locationExI == null || TextUtils.isEmpty(locationExI.getCityCode())) ? "" : locationExI.getCityCode();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public boolean getLxVpnStatus() {
        return zh6.c().e();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getMacAddress() {
        return !TextUtils.isEmpty(ac1.k) ? ac1.k : "";
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getNativeConfig(int i) {
        if (i == 68) {
            return "{\"strategy_id\":\"247\",\"strategy_ver\":\"179\",\"update_interval\":10,\"timeout\":3500,\"material_control\":{},\"switch\":{\"whitelist\":1,\"blacklist\":1,\"strategy_type\":1,\"strategy_show\":1,\"debug\":0,\"response_strategy_optimize\":0,\"prime_rit_switch\":0},\"cache_cfg\":{\"queue_len\":3},\"pk_cfg\":[{\"price_tag\":\"default\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"G\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1},{\"dspname\":\"W\",\"weight\":1},{\"dspname\":\"B\",\"weight\":1}]},{\"price_tag\":\"20000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":100}]}],\"sdk_cfg\":[{\"dspname\":\"C\",\"dspid\":1,\"type\":3,\"timeout\":3500,\"cache_sec\":120}],\"group_cfg\":[{\"group_id\":1,\"slot_cfg\":[{\"dspname\":\"C\",\"slotid\":\"949547680\",\"ecpm\":20000,\"freezetime\":0,\"pre_request\":0}],\"group_minprice\":0,\"group_maxprice\":20000}]}";
        }
        if (i == 78) {
            return "{\"strategy_id\":\"725\",\"strategy_ver\":\"861\",\"update_interval\":60,\"timeout\":3500,\"material_control\":{},\"switch\":{\"whitelist\":1,\"blacklist\":1,\"strategy_type\":1,\"strategy_show\":1,\"debug\":0,\"response_strategy_optimize\":1,\"prime_rit_switch\":0,\"shake_switch\":0,\"maxprice_switch\":1},\"cache_cfg\":{\"queue_len\":3},\"pk_cfg\":[{\"price_tag\":\"default\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"W\",\"weight\":1},{\"dspname\":\"Z\",\"weight\":1},{\"dspname\":\"Q\",\"weight\":1},{\"dspname\":\"F\",\"weight\":1},{\"dspname\":\"D\",\"weight\":1},{\"dspname\":\"L\",\"weight\":1},{\"dspname\":\"B\",\"weight\":1},{\"dspname\":\"X\",\"weight\":1},{\"dspname\":\"Y\",\"weight\":1},{\"dspname\":\"E\",\"weight\":1},{\"dspname\":\"P\",\"weight\":1},{\"dspname\":\"A\",\"weight\":1},{\"dspname\":\"M\",\"weight\":1},{\"dspname\":\"G\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1},{\"dspname\":\"O\",\"weight\":1},{\"dspname\":\"H\",\"weight\":1},{\"dspname\":\"V\",\"weight\":1}]},{\"price_tag\":\"10000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"7000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"5000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"3000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"2000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"1000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"500\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"100\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1}]}],\"sdk_cfg\":[{\"dspname\":\"C\",\"dspid\":1,\"type\":2,\"timeout\":3500,\"cache_sec\":120},{\"dspname\":\"K\",\"dspid\":3,\"type\":4,\"timeout\":3500,\"cache_sec\":60}],\"group_cfg\":[{\"group_id\":1,\"slot_cfg\":[{\"dspname\":\"C\",\"slotid\":\"964978309\",\"ecpm\":10000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978313\",\"ecpm\":7000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978311\",\"ecpm\":5000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978308\",\"ecpm\":3000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978314\",\"ecpm\":2000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978310\",\"ecpm\":1000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978307\",\"ecpm\":500,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978312\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"K\",\"slotid\":\"5593001431\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0}],\"group_minprice\":0,\"group_maxprice\":999900,\"group_timeout\":-1}]}";
        }
        if (i == 83) {
            return "{\"strategy_id\":\"727\",\"strategy_ver\":\"861\",\"update_interval\":60,\"timeout\":3500,\"material_control\":{},\"switch\":{\"whitelist\":1,\"blacklist\":1,\"strategy_type\":1,\"strategy_show\":1,\"debug\":0,\"response_strategy_optimize\":1,\"prime_rit_switch\":0,\"shake_switch\":0,\"maxprice_switch\":1},\"cache_cfg\":{\"queue_len\":3},\"pk_cfg\":[{\"price_tag\":\"default\",\"dsp_weight\":[{\"dspname\":\"P\",\"weight\":1},{\"dspname\":\"L\",\"weight\":1},{\"dspname\":\"B\",\"weight\":1},{\"dspname\":\"X\",\"weight\":1},{\"dspname\":\"Y\",\"weight\":1},{\"dspname\":\"E\",\"weight\":1},{\"dspname\":\"V\",\"weight\":1},{\"dspname\":\"A\",\"weight\":1},{\"dspname\":\"M\",\"weight\":1},{\"dspname\":\"G\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1},{\"dspname\":\"O\",\"weight\":1},{\"dspname\":\"H\",\"weight\":1},{\"dspname\":\"F\",\"weight\":1},{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"W\",\"weight\":1},{\"dspname\":\"Z\",\"weight\":1},{\"dspname\":\"Q\",\"weight\":1},{\"dspname\":\"D\",\"weight\":1}]},{\"price_tag\":\"7000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"5000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"3000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"2000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"1500\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"1000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"500\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"100\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1}]}],\"sdk_cfg\":[{\"dspname\":\"C\",\"dspid\":1,\"type\":2,\"timeout\":3500,\"cache_sec\":120},{\"dspname\":\"K\",\"dspid\":3,\"type\":4,\"timeout\":3500,\"cache_sec\":60}],\"group_cfg\":[{\"group_id\":1,\"slot_cfg\":[{\"dspname\":\"C\",\"slotid\":\"964978809\",\"ecpm\":7000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978811\",\"ecpm\":5000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978813\",\"ecpm\":3000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978814\",\"ecpm\":2000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978812\",\"ecpm\":1500,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978810\",\"ecpm\":1000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978808\",\"ecpm\":500,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"964978815\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"K\",\"slotid\":\"5593001442\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0}],\"group_minprice\":0,\"group_maxprice\":999900,\"group_timeout\":-1}]}";
        }
        if (i == 59) {
            return "{\"strategy_id\":\"729\",\"strategy_ver\":\"861\",\"update_interval\":60,\"timeout\":3500,\"material_control\":{},\"switch\":{\"whitelist\":1,\"blacklist\":1,\"strategy_type\":1,\"strategy_show\":1,\"debug\":0,\"response_strategy_optimize\":1,\"prime_rit_switch\":0,\"shake_switch\":0,\"maxprice_switch\":1},\"cache_cfg\":{\"queue_len\":3},\"pk_cfg\":[{\"price_tag\":\"default\",\"dsp_weight\":[{\"dspname\":\"O\",\"weight\":1},{\"dspname\":\"H\",\"weight\":1},{\"dspname\":\"V\",\"weight\":1},{\"dspname\":\"A\",\"weight\":1},{\"dspname\":\"M\",\"weight\":1},{\"dspname\":\"G\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1},{\"dspname\":\"Z\",\"weight\":1},{\"dspname\":\"Q\",\"weight\":1},{\"dspname\":\"F\",\"weight\":1},{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"W\",\"weight\":1},{\"dspname\":\"D\",\"weight\":1},{\"dspname\":\"Y\",\"weight\":1},{\"dspname\":\"E\",\"weight\":1},{\"dspname\":\"P\",\"weight\":1},{\"dspname\":\"L\",\"weight\":1},{\"dspname\":\"B\",\"weight\":1},{\"dspname\":\"X\",\"weight\":1}]},{\"price_tag\":\"10000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"5000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"3000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"2000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"1500\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"1000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"500\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"100\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1}]},{\"price_tag\":\"50\",\"dsp_weight\":[{\"dspname\":\"H\",\"weight\":1}]},{\"price_tag\":\"30\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]}],\"sdk_cfg\":[{\"dspname\":\"C\",\"dspid\":1,\"type\":2,\"timeout\":3500,\"cache_sec\":120},{\"dspname\":\"K\",\"dspid\":3,\"type\":4,\"timeout\":3500,\"cache_sec\":60},{\"dspname\":\"H\",\"dspid\":10,\"type\":4,\"timeout\":3500,\"cache_sec\":60}],\"group_cfg\":[{\"group_id\":1,\"slot_cfg\":[{\"dspname\":\"C\",\"slotid\":\"965044475\",\"ecpm\":10000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044476\",\"ecpm\":5000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044471\",\"ecpm\":3000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044473\",\"ecpm\":2000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044478\",\"ecpm\":1500,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044477\",\"ecpm\":1000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044474\",\"ecpm\":500,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044479\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"K\",\"slotid\":\"5593001456\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"H\",\"slotid\":\"c1971be0rt\",\"ecpm\":50,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044472\",\"ecpm\":30,\"freezetime\":0,\"pre_request\":0,\"bidType\":3,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0}],\"group_minprice\":0,\"group_maxprice\":999900,\"group_timeout\":-1}]}";
        }
        if (i == 86) {
            return "{\"strategy_id\":\"728\",\"strategy_ver\":\"861\",\"update_interval\":60,\"timeout\":2000,\"material_control\":{},\"switch\":{\"whitelist\":1,\"blacklist\":1,\"strategy_type\":1,\"strategy_show\":1,\"debug\":0,\"response_strategy_optimize\":1,\"prime_rit_switch\":0,\"shake_switch\":0,\"maxprice_switch\":1},\"cache_cfg\":{\"queue_len\":3},\"pk_cfg\":[{\"price_tag\":\"default\",\"dsp_weight\":[{\"dspname\":\"W\",\"weight\":1},{\"dspname\":\"Z\",\"weight\":1},{\"dspname\":\"Q\",\"weight\":1},{\"dspname\":\"F\",\"weight\":1},{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"D\",\"weight\":1},{\"dspname\":\"X\",\"weight\":1},{\"dspname\":\"Y\",\"weight\":1},{\"dspname\":\"E\",\"weight\":1},{\"dspname\":\"P\",\"weight\":1},{\"dspname\":\"L\",\"weight\":1},{\"dspname\":\"B\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1},{\"dspname\":\"O\",\"weight\":1},{\"dspname\":\"H\",\"weight\":1},{\"dspname\":\"V\",\"weight\":1},{\"dspname\":\"A\",\"weight\":1},{\"dspname\":\"M\",\"weight\":1},{\"dspname\":\"G\",\"weight\":1}]},{\"price_tag\":\"10000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"7000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"5000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"3000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"2050\",\"dsp_weight\":[{\"dspname\":\"H\",\"weight\":1}]},{\"price_tag\":\"2000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"1550\",\"dsp_weight\":[{\"dspname\":\"H\",\"weight\":1}]},{\"price_tag\":\"1500\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"1025\",\"dsp_weight\":[{\"dspname\":\"H\",\"weight\":1}]},{\"price_tag\":\"1000\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"750\",\"dsp_weight\":[{\"dspname\":\"H\",\"weight\":1}]},{\"price_tag\":\"500\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]},{\"price_tag\":\"100\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"K\",\"weight\":1}]},{\"price_tag\":\"50\",\"dsp_weight\":[{\"dspname\":\"H\",\"weight\":1}]},{\"price_tag\":\"30\",\"dsp_weight\":[{\"dspname\":\"C\",\"weight\":1}]}],\"sdk_cfg\":[{\"dspname\":\"C\",\"dspid\":1,\"type\":2,\"timeout\":3500,\"cache_sec\":120},{\"dspname\":\"H\",\"dspid\":10,\"type\":2,\"timeout\":3500,\"cache_sec\":60},{\"dspname\":\"K\",\"dspid\":3,\"type\":4,\"timeout\":3500,\"cache_sec\":60}],\"group_cfg\":[{\"group_id\":1,\"slot_cfg\":[{\"dspname\":\"C\",\"slotid\":\"965044225\",\"ecpm\":10000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044227\",\"ecpm\":7000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044220\",\"ecpm\":5000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044229\",\"ecpm\":3000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"H\",\"slotid\":\"v1j0hr151c\",\"ecpm\":2050,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"C\",\"slotid\":\"965044221\",\"ecpm\":2000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"H\",\"slotid\":\"r601qbg7mu\",\"ecpm\":1550,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"C\",\"slotid\":\"965044226\",\"ecpm\":1500,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"H\",\"slotid\":\"n6x2rkv509\",\"ecpm\":1025,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"C\",\"slotid\":\"965044223\",\"ecpm\":1000,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"H\",\"slotid\":\"z2s8a0mz19\",\"ecpm\":750,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"C\",\"slotid\":\"965044224\",\"ecpm\":500,\"freezetime\":0,\"pre_request\":0,\"bidType\":2,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1},{\"dspname\":\"C\",\"slotid\":\"965044222\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"K\",\"slotid\":\"5593001453\",\"ecpm\":100,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"H\",\"slotid\":\"y4v91jla7a\",\"ecpm\":50,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":0},{\"dspname\":\"C\",\"slotid\":\"965044228\",\"ecpm\":30,\"freezetime\":0,\"pre_request\":0,\"bidType\":3,\"ecpmRatio\":1,\"ecpmLowPrice\":0,\"priceSwitch\":1}],\"group_minprice\":0,\"group_maxprice\":999900,\"group_timeout\":-1}]}";
        }
        if (i == 103) {
            return "{\"strategy_id\":\"660\",\"strategy_ver\":\"735\",\"update_interval\":60,\"timeout\":3500,\"material_control\":{},\"switch\":{\"whitelist\":1,\"blacklist\":1,\"strategy_type\":1,\"strategy_show\":1,\"debug\":0,\"response_strategy_optimize\":1,\"prime_rit_switch\":0,\"shake_switch\":0,\"maxprice_switch\":0},\"cache_cfg\":{\"queue_len\":3},\"pk_cfg\":[{\"price_tag\":\"default\",\"dsp_weight\":[{\"dspname\":\"K\",\"weight\":1},{\"dspname\":\"X\",\"weight\":1},{\"dspname\":\"A\",\"weight\":1},{\"dspname\":\"E\",\"weight\":1},{\"dspname\":\"P\",\"weight\":1},{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"W\",\"weight\":1},{\"dspname\":\"Z\",\"weight\":1},{\"dspname\":\"O\",\"weight\":1},{\"dspname\":\"B\",\"weight\":1},{\"dspname\":\"Q\",\"weight\":1},{\"dspname\":\"F\",\"weight\":1},{\"dspname\":\"M\",\"weight\":1},{\"dspname\":\"G\",\"weight\":1},{\"dspname\":\"Y\",\"weight\":1},{\"dspname\":\"H\",\"weight\":1},{\"dspname\":\"V\",\"weight\":1}]},{\"price_tag\":\"1\",\"dsp_weight\":[{\"dspname\":\"F\",\"weight\":100}]}],\"sdk_cfg\":[{\"dspname\":\"F\",\"dspid\":15,\"type\":4,\"timeout\":3500,\"cache_sec\":30}],\"group_cfg\":[{\"group_id\":1,\"slot_cfg\":[{\"dspname\":\"F\",\"slotid\":\"50255\",\"ecpm\":1,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":1}],\"group_minprice\":0,\"group_maxprice\":999900,\"group_timeout\":-1}]}";
        }
        if (i == 104) {
            return "{\"strategy_id\":\"661\",\"strategy_ver\":\"735\",\"update_interval\":60,\"timeout\":3500,\"material_control\":{},\"switch\":{\"whitelist\":1,\"blacklist\":1,\"strategy_type\":1,\"strategy_show\":1,\"debug\":0,\"response_strategy_optimize\":1,\"prime_rit_switch\":0,\"shake_switch\":0,\"maxprice_switch\":0},\"cache_cfg\":{\"queue_len\":3},\"pk_cfg\":[{\"price_tag\":\"default\",\"dsp_weight\":[{\"dspname\":\"K\",\"weight\":1},{\"dspname\":\"X\",\"weight\":1},{\"dspname\":\"A\",\"weight\":1},{\"dspname\":\"C\",\"weight\":1},{\"dspname\":\"W\",\"weight\":1},{\"dspname\":\"Z\",\"weight\":1},{\"dspname\":\"O\",\"weight\":1},{\"dspname\":\"E\",\"weight\":1},{\"dspname\":\"P\",\"weight\":1},{\"dspname\":\"B\",\"weight\":1},{\"dspname\":\"G\",\"weight\":1},{\"dspname\":\"Y\",\"weight\":1},{\"dspname\":\"H\",\"weight\":1},{\"dspname\":\"V\",\"weight\":1},{\"dspname\":\"Q\",\"weight\":1},{\"dspname\":\"F\",\"weight\":1},{\"dspname\":\"M\",\"weight\":1}]},{\"price_tag\":\"1\",\"dsp_weight\":[{\"dspname\":\"F\",\"weight\":100}]}],\"sdk_cfg\":[{\"dspname\":\"F\",\"dspid\":15,\"type\":4,\"timeout\":3500,\"cache_sec\":30}],\"group_cfg\":[{\"group_id\":1,\"slot_cfg\":[{\"dspname\":\"F\",\"slotid\":\"50256\",\"ecpm\":1,\"freezetime\":0,\"pre_request\":0,\"bidType\":4,\"ecpmRatio\":1,\"ecpmLowPrice\":1}],\"group_minprice\":0,\"group_maxprice\":999900,\"group_timeout\":-1}]}";
        }
        return null;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getOaId() {
        LogUtil.d("NestInfoSupplier", "getOaId = " + MdidSdkConfigHelper.getInstance().getOAID());
        return MdidSdkConfigHelper.getInstance().getOAID();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public int getOpenSdkVer() {
        return so6.a().b().getWXAppSupportAPI();
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    @Nullable
    public String getUA() {
        return ac1.x(this.f22281a);
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getUId() {
        return v4.b(c.b());
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public int getWxApiVer() {
        return 0;
    }

    @Override // com.wifi.ad.core.sensitive.NestInfoSupplier
    public String getWxAppId() {
        return "wxac389a401b5d4943";
    }
}
