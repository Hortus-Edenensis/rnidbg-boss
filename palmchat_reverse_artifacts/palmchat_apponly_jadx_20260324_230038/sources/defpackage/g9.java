package defpackage;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.p0002sl.hb;
import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17681a = false;
    public static Boolean b;
    public static String[] c = {"a", t.l, "c", "d", "e", "f", "g", "h", "i", hb.j, t.f7496a, "l", "m", "n", "o", "p", "q", t.k, "s", "t", "u", "v", RXScreenCaptureService.KEY_WIDTH, "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "D", ExifInterface.LONGITUDE_EAST, "F", WkAdxAdConfigMg.DSP_NAME_GDT, "H", "I", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z"};

    public static String a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(ir5.b());
        for (int i = 0; i < 8; i++) {
            sb.append(c[random.nextInt(c.length)]);
        }
        LogUtil.i("AkDoubleKeyHelper", "genKey " + sb.toString());
        return sb.toString();
    }

    public static String b(String str) {
        return SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, str, "");
    }

    public static String c(boolean z) {
        String strA;
        String str = z ? "key_ak_double_k1" : "key_ak_double_k2";
        String strB = b(str);
        if (TextUtils.isEmpty(strB)) {
            strA = a();
            g(str, strA);
        } else {
            strA = strB;
        }
        LogUtil.i("AkDoubleKeyHelper", "getKey " + z + " savekey =" + strB + " result=" + strA);
        return strA;
    }

    public static boolean d() {
        if (b == null) {
            b = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_ak_token_double_key", false));
        }
        LogUtil.d("AkDoubleKeyHelper", "isEnable = " + b);
        return b.booleanValue() || f17681a;
    }

    public static boolean e() {
        boolean zF = t66.h().f("LX-61093", false);
        LogUtil.i("AkDoubleKeyHelper", "isAkAxTokenEnable " + zF);
        return zF;
    }

    public static void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("k2");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            g("key_ak_double_k1", strOptString);
            g("key_ak_double_k2", a());
        }
    }

    public static void g(String str, String str2) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, str, str2);
    }

    public static void h() {
        boolean zE = e();
        LogUtil.i("AkDoubleKeyHelper", "updateEnable isTaichiEnable=" + zE);
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_ak_token_double_key", Boolean.valueOf(zE));
        b = Boolean.valueOf(zE);
    }
}
