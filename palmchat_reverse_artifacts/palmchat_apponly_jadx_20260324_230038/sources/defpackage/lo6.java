package defpackage;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lo6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f19048a = new HashMap<>();

    static {
        LogUtil.d("", "WkTaiXMUtil static start");
        f19048a.put("LX-29267", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-34097", ContentClassification.AD_CONTENT_CLASSIFICATION_J);
        f19048a.put("LX-24769", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-29497", WkAdxAdConfigMg.DSP_NAME_GDT);
        f19048a.put("LX-31425", ExifInterface.LONGITUDE_EAST);
        f19048a.put("LX-31249", WkAdxAdConfigMg.DSP_NAME_CSJ);
        f19048a.put("LX-35416", WkAdxAdConfigMg.DSP_NAME_CSJ);
        f19048a.put("LX-43408", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-44460", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-37924", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-39904", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-39895", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-39896", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-40038", WkAdxAdConfigMg.DSP_NAME_CSJ);
        f19048a.put("LX-44444", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-24115", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-20860", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-20444", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-24412", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-45094", "A");
        f19048a.put("LX-46021", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        f19048a.put("LX-45604", WkAdxAdConfigMg.DSP_NAME_BAIDU);
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && f19048a.containsKey(str);
    }

    public static String b(String str, String str2) {
        try {
            if (f19048a.containsKey(str)) {
                return ap3.a().n(str, f19048a.get(str));
            }
        } catch (Exception unused) {
        }
        return str2;
    }
}
