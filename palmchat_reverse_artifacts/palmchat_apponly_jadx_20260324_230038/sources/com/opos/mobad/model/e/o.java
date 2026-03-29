package com.opos.mobad.model.e;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.opos.cmn.biz.web.a.b.a;
import com.opos.cmn.biz.web.a.b.b;
import com.opos.cmn.func.a.a.d;
import com.ss.android.download.api.constant.BaseConstants;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class o {
    private static final String a(String str) {
        if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith(BaseConstants.SCHEME_HTTPS)) {
            return str;
        }
        return "https://adsfs.heytapimage.com" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(String str, String str2) {
        if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith(BaseConstants.SCHEME_HTTPS)) {
            return str;
        }
        return str2 + "/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List<com.opos.cmn.biz.web.a.b.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.f.a.b("WebPrepare", "cache size:" + list.size());
        com.opos.cmn.biz.web.a.b.c.a().a(list);
    }

    private static final void a(final Context context, final String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.e.o.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URI uriCreate = URI.create(str);
                    String str2 = uriCreate.getScheme() + "://" + uriCreate.getHost();
                    if (uriCreate.getPort() > 0) {
                        str2 = str2 + ":" + uriCreate.getPort();
                    }
                    HashMap map = new HashMap();
                    map.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
                    com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(context, new d.a().a(map).a("GET").b(str).a());
                    com.opos.cmn.an.f.a.b("WebPrepare", "get code:" + eVarA.f7934a);
                    if (200 == eVarA.f7934a) {
                        String strA = com.opos.mobad.model.utils.c.a(eVarA.c);
                        com.opos.cmn.an.f.a.b("WebPrepare", "get data:" + strA);
                        JSONArray jSONArray = new JSONArray(strA);
                        if (jSONArray.length() > 0) {
                            ArrayList arrayList = new ArrayList(jSONArray.length());
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                arrayList.add(new a.C0660a().a(o.b(jSONObject.getString(OapsWrapper.KEY_PATH), str2)).b(jSONObject.getString("md5")).a());
                            }
                            o.b(arrayList);
                        }
                    }
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.b("WebPrepare", "get resouce fail:", th);
                }
            }
        });
    }

    public static final void a(Context context, String str, List<String> list) {
        ArrayList arrayList;
        com.opos.cmn.biz.web.a.b.c.a().a(context, new b.a().a());
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new a.C0660a().a(it.next()).a());
            }
        }
        b(arrayList);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, str);
    }

    public static final void a(Context context, List<String> list) {
        com.opos.cmn.biz.web.a.b.c.a().a(context, new b.a().a());
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a.C0660a().a(a(it.next())).a());
        }
        b(arrayList);
    }
}
