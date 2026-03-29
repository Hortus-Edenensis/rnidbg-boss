package com.bytedance.sdk.component.u;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.bytedance.sdk.component.u.t;
import com.wifi.ad.core.config.EventParams;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class dw {
    private final String b;
    private final t.u fx;
    private final LruCache<String, fx> nr;
    private final Map<String, List<nr>> u = new ConcurrentHashMap();
    private volatile boolean pn = false;

    /* JADX INFO: compiled from: SearchBox */
    public static final class fx {
        q u = q.PUBLIC;
        Set<String> nr = new HashSet();
        Set<String> fx = new HashSet();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr {
        List<String> b;
        List<String> fx;
        q nr;
        Pattern u;

        private nr() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends IllegalStateException {
        public u(String str) {
            super(str);
        }
    }

    @WorkerThread
    public dw(String str, int i, t.u uVar, final Executor executor, JSONObject jSONObject) {
        this.b = str;
        if (i <= 0) {
            this.nr = new LruCache<>(16);
        } else {
            this.nr = new LruCache<>(i);
        }
        this.fx = uVar;
        if (jSONObject != null) {
            update(jSONObject);
        } else {
            b(str);
            new Object() { // from class: com.bytedance.sdk.component.u.dw.1
            };
        }
    }

    private static String b(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    private List<nr> fx(String str) throws u {
        if (this.pn) {
            return this.u.get(str);
        }
        throw new u("Permission config is outdated!");
    }

    private static String nr(String str) {
        String[] strArrSplit;
        int length;
        if (str == null || (length = (strArrSplit = str.split("[.]")).length) < 2) {
            return null;
        }
        if (length == 2) {
            return str;
        }
        return strArrSplit[length - 2] + "." + strArrSplit[length - 1];
    }

    public fx u(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        fx fxVar = new fx();
        if (authority == null || authority.isEmpty()) {
            fxVar.u = q.PUBLIC;
            return fxVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(".".concat(String.valueOf(str2)))) {
                fxVar.u = q.PRIVATE;
                return fxVar;
            }
        }
        fx fxVar2 = this.nr.get(string);
        return fxVar2 != null ? fxVar2 : u(string);
    }

    public void update(JSONObject jSONObject) {
        u(jSONObject);
        b(this.b);
    }

    @WorkerThread
    private static nr nr(JSONObject jSONObject) throws JSONException {
        nr nrVar = new nr();
        nrVar.u = Pattern.compile(jSONObject.getString("pattern"));
        nrVar.nr = q.u(jSONObject.getString(EventParams.KEY_GROUP));
        nrVar.fx = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                nrVar.fx.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        nrVar.b = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                nrVar.b.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return nrVar;
    }

    @WorkerThread
    private void u(JSONObject jSONObject) {
        this.u.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.u.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(nr(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            a.nr("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.pn = true;
    }

    private fx u(String str) throws u {
        fx fxVar = new fx();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strNr = nr(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && strNr != null) {
            List<nr> listFx = fx(strNr);
            if (listFx == null) {
                return fxVar;
            }
            for (nr nrVar : listFx) {
                if (nrVar.u.matcher(str).find()) {
                    if (nrVar.nr.compareTo(fxVar.u) >= 0) {
                        fxVar.u = nrVar.nr;
                    }
                    fxVar.nr.addAll(nrVar.fx);
                    fxVar.fx.addAll(nrVar.b);
                }
            }
            this.nr.put(str, fxVar);
            return fxVar;
        }
        fxVar.u = q.PUBLIC;
        return fxVar;
    }
}
