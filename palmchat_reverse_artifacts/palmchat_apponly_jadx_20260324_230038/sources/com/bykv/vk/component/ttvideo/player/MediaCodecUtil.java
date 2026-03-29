package com.bykv.vk.component.ttvideo.player;

import android.util.Pair;
import com.huawei.hms.ads.dynamic.a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";

    static {
        HashMap map = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = map;
        map.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1);
        map.put(a.t, 2);
        map.put("03", 4);
        map.put("04", 8);
        map.put("05", 16);
        map.put("06", 32);
        map.put("07", 64);
        map.put("08", 128);
        map.put("09", 256);
        HashMap map2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = map2;
        map2.put("00", 1);
        map2.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 2);
        map2.put(a.t, 4);
        map2.put("03", 8);
        map2.put("04", 16);
        map2.put("05", 32);
        map2.put("06", 64);
        map2.put("07", 128);
        map2.put("08", 256);
        map2.put("09", 512);
    }

    public static String getDolbyCodecs(int i, int i2) {
        String str;
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        return str + ".0" + i + ".0" + i2;
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            return null;
        }
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(matcher.group(1));
        if (num == null) {
            return null;
        }
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(strArr[2]);
        if (num2 == null) {
            return null;
        }
        return new Pair<>(num, num2);
    }
}
