package com.qq.gdt.action.j;

import com.qq.gdt.action.ActionType;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f10526a = Pattern.compile("^([a-zA-Z][a-zA-Z\\d_]{0,63})$", 2);
    private static final Pattern b = Pattern.compile("^ams_reserved_(.*?)", 2);

    public static boolean a(String str) {
        String str2;
        if (v.a(str)) {
            str2 = "在logAction方法中，actionType参数不能为空！";
        } else {
            if (f10526a.matcher(str).matches()) {
                return true;
            }
            str2 = "在logAction方法中，actionType参数只能包含字母、数字和下划线，且只能以字母开头，长度不能超过64个字符！";
        }
        o.c(str2);
        return false;
    }

    public static String b(String str) {
        if (!"ACTIVATE_APP".equals(str)) {
            return str;
        }
        o.b("如果您想统计App的激活行为，只需要在调用logEvent方法时传入START_APP参数，SDK会自动识别本次行为是激活还是启动行为，并进行上报。");
        return ActionType.START_APP;
    }

    public static boolean a(JSONObject jSONObject) {
        String strA;
        int i;
        if (jSONObject == null) {
            return true;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (v.a(next)) {
                strA = "在logAction方法中，actionParam参数的key不能为空！";
            } else if (f10526a.matcher(next).matches()) {
                if (b.matcher(next).matches()) {
                    o.b("SDK内部预留参数的key均以'ams_reserved_'开头，该参数的值会被SDK内部覆盖，请不要使用！");
                }
                try {
                    Object obj = jSONObject.get(next);
                    if (!(obj instanceof String) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof JSONArray)) {
                        o.c(v.a("在logAction方法中，actionParam参数的value必须是String/Number/Boolean/JSONArray中的一种！[key=%s, value=%s]", next, obj.toString()));
                        return false;
                    }
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (!(obj2 instanceof String) && !(obj2 instanceof Number) && !(obj2 instanceof Boolean)) {
                                o.c(v.a("在logAction方法中，如果actionParam参数中的某个元素的value是JSONArray，那么这个JSONArray中的每个元素必须是String/Number/Boolean中的一种！[key=%s, value=%s, %nvalue的第%d个元素为%s]", next, obj.toString(), Integer.valueOf(i2), obj2.toString()));
                                return false;
                            }
                        }
                        if (jSONArray.length() >= 2) {
                            Object obj3 = jSONArray.get(0);
                            while (i < jSONArray.length()) {
                                Object obj4 = jSONArray.get(i);
                                i = (((obj4 instanceof String) && (obj3 instanceof String)) || ((obj4 instanceof Number) && (obj3 instanceof Number)) || ((obj4 instanceof Boolean) && (obj3 instanceof Boolean))) ? i + 1 : 1;
                                o.c("在logAction方法中，如果actionParam参数中的某个元素的value是JSONArray，那么这个JSONArray中所有元素的类型必须是同一种！");
                                return false;
                            }
                        }
                        continue;
                    }
                } catch (JSONException unused) {
                    strA = v.a("Unexpected action param key. [key='%s']", next);
                }
            } else {
                strA = "在logAction方法中，actionParam参数的key只能包含字母、数字和下划线，且不能以数字开头，长度不能超过64个字符！";
            }
            o.c(strA);
            return false;
        }
        return true;
    }
}
