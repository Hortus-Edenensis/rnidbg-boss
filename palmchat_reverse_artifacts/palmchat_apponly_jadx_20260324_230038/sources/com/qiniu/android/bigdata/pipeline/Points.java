package com.qiniu.android.bigdata.pipeline;

import com.huawei.hms.framework.common.ContainerUtils;
import com.qiniu.android.utils.FastDatePrinter;
import com.qiniu.android.utils.Json;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Points {

    /* JADX INFO: compiled from: SearchBox */
    public static class LazyHolder {
        private static final FastDatePrinter INSTANCE = new FastDatePrinter("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Calendar.getInstance().getTimeZone(), Locale.getDefault());

        private LazyHolder() {
        }
    }

    private static String buildString(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Boolean)) ? obj.toString() : obj instanceof String ? ((String) obj).replace("\n", "\\n").replace("\t", "\\t") : obj instanceof Collection ? Json.encodeList((Collection) obj) : obj instanceof Map ? Json.encodeMap((Map) obj) : obj instanceof Date ? LazyHolder.INSTANCE.format((Date) obj) : obj.toString();
    }

    public static <V> StringBuilder formatPoint(Map<String, V> map, StringBuilder sb) {
        for (Map.Entry<String, V> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(buildString(entry.getValue()));
            sb.append("\t");
        }
        sb.replace(sb.length() - 1, sb.length(), "\n");
        return sb;
    }

    public static <V> StringBuilder formatPoints(Map<String, V>[] mapArr) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, V> map : mapArr) {
            formatPoint((Map) map, sb);
        }
        return sb;
    }

    public static <V> StringBuilder formatPointsObjects(List<V> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<V> it = list.iterator();
        while (it.hasNext()) {
            formatPoint(it.next(), sb);
        }
        return sb;
    }

    public static StringBuilder formatPoint(Object obj, StringBuilder sb) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        new Points();
        HashMap map = new HashMap();
        for (Field field : declaredFields) {
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException unused) {
            }
        }
        return formatPoint((Map) map, sb);
    }

    public static StringBuilder formatPoints(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            formatPoint(obj, sb);
        }
        return sb;
    }

    public static <V> StringBuilder formatPoints(List<Map<String, V>> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map<String, V>> it = list.iterator();
        while (it.hasNext()) {
            formatPoint((Map) it.next(), sb);
        }
        return sb;
    }
}
