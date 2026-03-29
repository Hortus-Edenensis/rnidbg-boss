package defpackage;

import android.app.Activity;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f22502a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        String formatStackForLog();

        int getPageId();

        void updateCurrentPageInfo(Activity activity, HashMap map);
    }

    public static String a() {
        a aVar = f22502a;
        return aVar != null ? aVar.formatStackForLog() : "NULL";
    }

    public static Activity b() {
        System.currentTimeMillis();
        try {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
                if (arrayMap.size() < 1) {
                    return null;
                }
                for (Object obj : arrayMap.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        return (Activity) declaredField3.get(obj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } finally {
            System.currentTimeMillis();
        }
    }

    public static void c(a aVar) {
        f22502a = aVar;
    }

    public static void d(Activity activity, HashMap map) {
        f22502a.updateCurrentPageInfo(activity, map);
    }
}
