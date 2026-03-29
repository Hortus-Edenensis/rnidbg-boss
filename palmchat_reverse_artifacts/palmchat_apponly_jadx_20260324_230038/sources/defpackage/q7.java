package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.push.f.b.d;
import com.umeng.analytics.pro.dn;
import com.umeng.analytics.pro.f;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class q7 {
    public static volatile q7 c;
    public static final Object d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20191a;
    public Map<String, Set<String>> b = new HashMap();

    public static q7 c() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new q7();
                }
            }
        }
        return c;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals("active_launch")) {
                    b = 0;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    b = 1;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    b = 2;
                }
                break;
            case -1051289244:
                if (str.equals(f.L)) {
                    b = 3;
                }
                break;
            case -1039745817:
                if (str.equals(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL)) {
                    b = 4;
                }
                break;
            case -820729752:
                if (str.equals("active_terminate")) {
                    b = 5;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    b = 6;
                }
                break;
            case -295020531:
                if (str.equals("android_notification_state")) {
                    b = 7;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    b = 8;
                }
                break;
            case 96275:
                if (str.equals("aa3")) {
                    b = 9;
                }
                break;
            case 2986591:
                if (str.equals("aat3")) {
                    b = 10;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    b = 11;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    b = 12;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    b = dn.k;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    b = dn.l;
                }
                break;
        }
        switch (b) {
            case 0:
            case 3:
            case 5:
                return f.L;
            case 1:
            case 12:
            case 14:
                return "account";
            case 2:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
                return "awake";
            case 4:
                break;
            case 7:
                return "android_notification_state";
            default:
                if (this.b.containsKey(str)) {
                    return str;
                }
                break;
        }
        return PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
    }

    public String b(Set<String> set) {
        if (set != null) {
            try {
                if (!set.isEmpty()) {
                    Iterator<String> it = set.iterator();
                    String str = null;
                    while (it.hasNext()) {
                        String strA = a(it.next());
                        if (str == null) {
                            str = strA;
                        } else if (!str.equals(strA)) {
                            k63.l("AddressGroupManager", "Report JSONArray belong more than one space, using normal-space");
                            return PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
                        }
                    }
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        return PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
    }

    public Set<String> d(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return this.b.get(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
        }
        Iterator<String> it = set.iterator();
        Set<String> set2 = null;
        while (it.hasNext()) {
            Set<String> set3 = this.b.get(a(it.next()));
            if (set3 == null || set3.isEmpty()) {
                return this.b.get(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
            }
            if (set2 == null) {
                set2 = set3;
            } else {
                set2.retainAll(set3);
            }
            if (set2.isEmpty()) {
                return this.b.get(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
            }
        }
        return set2;
    }

    public q7 e(Context context) {
        try {
            long jLongValue = ((Long) lg5.c(context, zz2.t())).longValue();
            long j = this.f20191a;
            if (j == 0 || j != jLongValue) {
                this.f20191a = jLongValue;
                String str = (String) lg5.c(context, zz2.v());
                if (!TextUtils.isEmpty(str)) {
                    g(new JSONObject(str));
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public q7 f(Context context) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            e(context);
            long jLongValue = ((Long) lg5.c(context, zz2.w())).longValue();
            if (jLongValue < 0) {
                jLongValue = 3600000;
            } else if (jLongValue < 60000) {
                jLongValue = 60000;
            }
            if (jLongValue > d.b) {
                jLongValue = 604800000;
            }
            SimpleDateFormat simpleDateFormatA = hv0.a("yyyy-MM-dd HH:mm:ss");
            k63.a("AddressGroupManager", "lastUpdateTime=" + simpleDateFormatA.format(new Date(this.f20191a)) + " now=" + simpleDateFormatA.format(new Date(jCurrentTimeMillis)) + " expire=" + (jLongValue / 1000));
            long j = this.f20191a;
            if (j == 0 || j + jLongValue < jCurrentTimeMillis) {
                k63.a("AddressGroupManager", "cache invalid, fetch new urls");
                Map<String, Set<String>> map = this.b;
                mw4.d(context, map == null || map.isEmpty());
            }
        } catch (Throwable th) {
            k63.l("AddressGroupManager", "refresh e" + th);
        }
        return this;
    }

    public final void g(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        linkedHashSet.add(jSONArrayOptJSONArray.getString(i));
                    }
                }
                map.put(next, linkedHashSet);
            }
            if (map.isEmpty()) {
                return;
            }
            this.b = map;
        } catch (JSONException unused) {
        }
    }

    public void h(Context context, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sis_ips");
        long j = 3600000;
        try {
            long j2 = jSONObject.getLong(RemoteMessageConst.TTL);
            if (j2 >= 0) {
                j = j2;
            }
        } catch (JSONException unused) {
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ips");
        zz2[] zz2VarArr = new zz2[4];
        zz2VarArr[0] = zz2.u().a0(jSONArrayOptJSONArray.toString());
        zz2VarArr[1] = zz2.w().a0(Long.valueOf(j * 1000));
        zz2VarArr[2] = zz2.t().a0(Long.valueOf(System.currentTimeMillis()));
        zz2VarArr[3] = zz2.v().a0(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : "");
        lg5.h(context, zz2VarArr);
        g(jSONObjectOptJSONObject);
    }
}
