package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.oplus.tblplayer.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xl1 {
    public static Properties f;
    public static File g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Spannable.Factory f21997a = Spannable.Factory.getInstance();
    public static final Map<Pattern, Integer> b = new HashMap();
    public static final List<String> c = new ArrayList();
    public static Map<String, Long> d = new TreeMap();
    public static String[] e = {"\\", "\\/", "*", ".", Constants.STRING_VALUE_UNSET, "+", "$", "^", "[", "]", "(", ")", "{", "}", HiAnalyticsConstant.REPORT_VAL_SEPARATOR};
    public static boolean h = false;
    public static boolean i = false;
    public static long j = System.currentTimeMillis();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<Map.Entry<String, Long>> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            if (entry.getValue().longValue() > entry2.getValue().longValue()) {
                return -1;
            }
            return entry.getValue().longValue() < entry2.getValue().longValue() ? 1 : 0;
        }
    }

    public static boolean a(Context context, int i2, int i3, Spannable spannable) {
        boolean z;
        boolean z2 = false;
        for (Map.Entry<Pattern, Integer> entry : b.entrySet()) {
            Matcher matcher = entry.getKey().matcher(spannable);
            while (matcher.find()) {
                for (wl1 wl1Var : (wl1[]) spannable.getSpans(matcher.start(), matcher.end(), wl1.class)) {
                    if (spannable.getSpanStart(wl1Var) < matcher.start() || spannable.getSpanEnd(wl1Var) > matcher.end()) {
                        z = false;
                        break;
                    }
                    spannable.removeSpan(wl1Var);
                }
                z = true;
                if (z) {
                    if (i2 <= 0) {
                        spannable.setSpan(new wl1(context, entry.getValue().intValue(), i3), matcher.start(), matcher.end(), 33);
                    } else {
                        Drawable drawable = context.getResources().getDrawable(entry.getValue().intValue());
                        if (drawable != null) {
                            drawable.setBounds(0, 0, i2, i2);
                            spannable.setSpan(new wl1(drawable, i3), matcher.start(), matcher.end(), 33);
                        }
                    }
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public static boolean b(String str) {
        Iterator<Map.Entry<Pattern, Integer>> it = b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public static synchronized int c(String str) {
        for (Map.Entry<Pattern, Integer> entry : b.entrySet()) {
            if (entry.getKey().matcher(str).find()) {
                return entry.getValue().intValue();
            }
        }
        return -1;
    }

    public static List<String> d() {
        return c;
    }

    public static void e(Context context) {
        if (context == null || h) {
            return;
        }
        if (i) {
            File file = new File(context.getFilesDir(), "squaresdkemoji.txt");
            g = file;
            try {
                if (!file.exists()) {
                    g.createNewFile();
                }
                Properties properties = new Properties();
                f = properties;
                properties.load(new FileInputStream(g));
            } catch (Throwable unused) {
            }
        }
        b.clear();
        c.clear();
        if (vl1.f() != null) {
            Iterator<Map.Entry<String, String>> it = vl1.f().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!vl1.n.equals(key)) {
                    c.add(key);
                }
            }
        }
        if (vl1.e() != null) {
            for (Map.Entry<String, String> entry : vl1.f().entrySet()) {
                String key2 = entry.getKey();
                int identifier = context.getResources().getIdentifier(entry.getValue(), "drawable", context.getPackageName());
                Pattern patternCompile = Pattern.compile(Pattern.quote(key2));
                Map<Pattern, Integer> map = b;
                if (!map.containsKey(patternCompile)) {
                    map.put(patternCompile, Integer.valueOf(identifier));
                }
            }
        }
        h = true;
    }

    public static boolean f() {
        return true;
    }

    public static void g(String str) {
        Properties properties;
        if (TextUtils.isEmpty(str) || (properties = f) == null) {
            return;
        }
        long jCurrentTimeMillis = TextUtils.isEmpty(properties.getProperty(str)) ? 0L : System.currentTimeMillis();
        d.put(str, Long.valueOf(jCurrentTimeMillis));
        f.setProperty(str, String.valueOf(jCurrentTimeMillis));
    }

    public static List<Map.Entry<String, Long>> h() {
        ArrayList arrayList = new ArrayList(d.entrySet());
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public static void i() throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (f == null || !g.exists()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(g);
                try {
                    f.store(fileOutputStream, "storeEmoji");
                    fileOutputStream.close();
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 == null) {
                    } else {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }
}
