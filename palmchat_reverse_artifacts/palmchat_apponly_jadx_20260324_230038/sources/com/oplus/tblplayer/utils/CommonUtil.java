package com.oplus.tblplayer.utils;

import android.os.Build;
import android.text.TextUtils;
import com.oplus.tblplayer.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CommonUtil {
    private CommonUtil() {
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static boolean isQualcommHardware() {
        String str = Build.HARDWARE;
        return !TextUtils.isEmpty(str) && str.matches("qcom");
    }

    public static boolean isSlowMotionHsr(String str) {
        return !TextUtils.isEmpty(str) && str.contains(Constants.SLOW_MOTION_HSR_HEAD);
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }
}
