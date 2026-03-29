package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.ams.ad.Ginkgo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Hickory {
    public static final String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f10707a;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Hickory$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f10708a;
        public final /* synthetic */ Map b;

        public Cdo(Hickory hickory, Context context, Map map) {
            this.f10708a = context;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Hickory.a(this.f10708a, (Map<String, String>) this.b);
        }
    }

    static {
        StringBuilder sbA = Banana.a("turingfd_conf_");
        sbA.append(Carambola.f10673a);
        sbA.append("_");
        sbA.append("ad");
        b = sbA.toString();
    }

    public Hickory(Handler handler) {
        this.f10707a = handler;
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            int i = Damson.f10689a;
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i3])) << 4));
            }
            return Damson.a(Cstatic.a(bArr, Cstatic.a()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
        }
    }

    public Ginkgo a(Context context) {
        long jLongValue;
        try {
            String strB = b(context, "101");
            if (TextUtils.isEmpty(strB)) {
                return Ginkgo.a(1);
            }
            try {
                jLongValue = Long.valueOf(b(context, "102")).longValue();
            } catch (Throwable unused) {
                jLongValue = 0;
            }
            String strB2 = b(context, "104");
            String strB3 = b(context, "105");
            String strB4 = b(context, "106");
            String strB5 = b(context, "110");
            Ginkgo.Cdo cdo = new Ginkgo.Cdo(0);
            cdo.b = jLongValue;
            cdo.f10701a = strB;
            cdo.d = strB2;
            cdo.e = strB3;
            cdo.f = strB4;
            cdo.g = strB5;
            return new Ginkgo(cdo);
        } catch (Throwable unused2) {
            return Ginkgo.a(1);
        }
    }

    public void c(Context context, long j) {
        a(context, "503", "" + j, true);
    }

    public void b(Context context, long j) {
        HashMap map = new HashMap();
        map.put("902", "" + j);
        a(context, map);
    }

    public void a(Context context, long j) {
        if (j >= Long.MAX_VALUE) {
            j = Long.MAX_VALUE;
        }
        a(context, "401", "" + j, true);
    }

    public Gemini<Long> a(Context context, int i) {
        System.currentTimeMillis();
        Gemini<Long> gemini = new Gemini<>(i);
        for (String str : b(context, "402").split("_")) {
            try {
                gemini.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return gemini;
    }

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        try {
            sharedPreferences = context.getSharedPreferences(b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                editorEdit.putString(str, Damson.a(Cstatic.b(map.get(str).getBytes(), Cstatic.a())));
            } catch (Throwable unused2) {
            }
        }
        try {
            editorEdit.commit();
        } catch (Throwable unused3) {
        }
    }

    public final void a(Context context, String str, String str2, boolean z) {
        HashMap map = new HashMap();
        map.put(str, str2);
        a(context, map, z);
    }

    public final void a(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put(str, str2);
        a(context, (Map<String, String>) map, false);
    }

    public final void a(Context context, Map<String, String> map, boolean z) {
        if (z) {
            a(context, map);
        } else {
            this.f10707a.post(new Cdo(this, context, map));
        }
    }

    public final long a(Context context, String str) {
        try {
            return Long.valueOf(b(context, str)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
