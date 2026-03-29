package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.peoplenearby.GreetingsThreadsActivity;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity;
import com.zenmen.palmchat.settings.AppSettingsActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zs1;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20904a = "t5";
    public static t5 b;
    public static final HashMap<Class, String> c = new a();
    public static CopyOnWriteArrayList<b> d = new CopyOnWriteArrayList<>();
    public static Set<String> e = new LinkedHashSet();
    public static Class f = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<Class, String> {
        public a() {
            put(GreetingsThreadsActivity.class, "11p");
            put(ChatterActivity.class, "12p");
            put(PeopleNearbyActivity.class, "31p");
            put(AppSettingsActivity.class, "43p");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Class f20905a;
        public int b;
        public HashMap c;

        public b(Class cls, int i) {
            this.f20905a = cls;
            this.b = i;
        }

        public Class e() {
            return this.f20905a;
        }

        public int f() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements zs1.a {
        @Override // zs1.a
        public String formatStackForLog() {
            return t5.f().b();
        }

        @Override // zs1.a
        public int getPageId() {
            return -1;
        }

        @Override // zs1.a
        public void updateCurrentPageInfo(Activity activity, HashMap map) {
            t5.f().o(activity, map);
        }
    }

    public static int d() {
        return wa6.a(j());
    }

    public static String e() {
        b bVarK = k();
        if (bVarK != null) {
            int iH = bVarK.b;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("platform", "android");
                if (iH != -1) {
                    if (iH == 0) {
                        iH = bn0.l() ? 204 : h();
                    }
                    jSONObject.put("function", iH);
                    int iD = d();
                    if (iD != -1) {
                        jSONObject.put("floatview", iD);
                    }
                    HashMap map = bVarK.c;
                    if (map != null) {
                        for (Map.Entry entry : map.entrySet()) {
                            String str = (String) entry.getKey();
                            Object value = entry.getValue();
                            if (str != null && value != null) {
                                jSONObject.put(str, value);
                            }
                        }
                    }
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static t5 f() {
        if (b == null) {
            synchronized (t5.class) {
                if (b == null) {
                    b = new t5();
                }
            }
        }
        return b;
    }

    public static int h() {
        return MainTabsActivity.x2();
    }

    public static int i() {
        if (AppContext.getContext().isBackground()) {
            return -2;
        }
        b bVarK = k();
        if (bVarK == null) {
            return -1;
        }
        int i = bVarK.b;
        return (i == -1 || i != 0) ? i : h();
    }

    public static Class j() {
        try {
            if (d.size() <= 0) {
                return null;
            }
            return d.get(r1.size() - 1).e();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static b k() {
        try {
            if (d.size() <= 0) {
                return null;
            }
            return d.get(r1.size() - 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean m() {
        return e.size() == 2 && e.contains(MainTabsActivity.class.getSimpleName()) && e.contains(InitActivity.class.getSimpleName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Activity activity) {
        Class<?> cls = activity.getClass();
        int pageId = activity instanceof zs1.a ? ((zs1.a) activity).getPageId() : -1;
        LogUtil.i(f20904a, "add" + activity.getClass().getSimpleName() + " pageId=" + pageId);
        d.add(new b(cls, pageId));
        e.add(activity.getClass().getSimpleName());
    }

    public String b() {
        String string;
        if (d.size() <= 0 || d.size() > 2) {
            string = null;
        } else {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < d.size(); i++) {
                    sb.append(c(d.get(i).e()));
                    if (i != d.size() - 1) {
                        sb.append("-");
                    }
                }
                string = sb.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                string = null;
            }
        }
        LogUtil.i(f20904a, "formatStackForLog =" + string);
        return string;
    }

    public String c(Class cls) {
        String str;
        if (cls == null) {
            return "X";
        }
        if (cls.equals(MainTabsActivity.class)) {
            String strY2 = MainTabsActivity.y2();
            strY2.hashCode();
            switch (strY2) {
                case "tab_discover":
                    str = "2p";
                    break;
                case "tab_msg":
                    str = "1p";
                    break;
                case "tab_mine":
                    str = "4p";
                    break;
                default:
                    return "X";
            }
        } else {
            str = c.get(cls);
            if (str == null) {
                return "X";
            }
        }
        return str;
    }

    public Class g() {
        return f;
    }

    public boolean l(Class cls) {
        return d.contains(cls);
    }

    public void n(Activity activity) {
        LogUtil.i(f20904a, "remove" + activity.getClass().getSimpleName());
        for (int size = d.size() + (-1); size >= 0; size--) {
            if (d.get(size).e().equals(activity.getClass())) {
                d.remove(size);
                return;
            }
        }
    }

    public void o(Activity activity, HashMap map) {
        if (d.size() > 0) {
            b bVar = d.get(r0.size() - 1);
            if (bVar.f20905a.equals(activity.getClass())) {
                bVar.c = map;
            }
        }
    }

    public void p(Activity activity) {
        f = activity.getClass();
    }
}
