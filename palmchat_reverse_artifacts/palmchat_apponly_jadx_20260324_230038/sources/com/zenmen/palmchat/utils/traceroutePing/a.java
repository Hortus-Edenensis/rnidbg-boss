package com.zenmen.palmchat.utils.traceroutePing;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.utils.traceroutePing.ReportVo;
import defpackage.az2;
import defpackage.go2;
import defpackage.hc2;
import defpackage.ir5;
import defpackage.it0;
import defpackage.k86;
import defpackage.sw4;
import defpackage.te1;
import defpackage.u93;
import defpackage.vs0;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f15773a = 50;
    public static int b = 30;
    public static HashMap<String, Boolean> c = new C1125a();
    public static List<String> d = new b();

    /* JADX INFO: renamed from: com.zenmen.palmchat.utils.traceroutePing.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1125a extends HashMap<String, Boolean> {
        public C1125a() {
            Boolean bool = Boolean.TRUE;
            put("short.lianxinapp.com", bool);
            Boolean bool2 = Boolean.FALSE;
            put("static.lianxinapp.com", bool2);
            put("storage.lianxinapp.com", bool2);
            put("fmedia.lianxinapp.com", bool2);
            put("log.lianxinapp.com", bool2);
            put("dn.lianxinapp.com", bool2);
            put("dp.lianxinapp.com", bool2);
            put("repositorycdn.lx0.cn", bool2);
            put("h5.lianxinapp.com", bool2);
            put("rescdn.lx0.cn", bool2);
            put("www.baidu.com", bool2);
            put("www.taobao.com", bool2);
            put("palmchat.cdn.lianxinapp.com", bool);
            put("assets.cdn.lianxinapp.com", bool);
            put("albumcdn.lx0.cn", bool);
            put("squarecdn.lx0.cn", bool);
            put("avatar.cdn.lianxinapp.com", bool);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ArrayList<String> {
        public b() {
            add("https://www.baidu.com/favicon.ico");
            add("https://www.taobao.com/favicon.ico");
            add("https://storage.lianxinapp.com/mdc/res/v5/1/1lvg0qpvf9c-9-2-c8a05f872b244bcca017c4af363d908e-slt5ja");
            add("https://storage.lianxinapp.com/mdc/res/v5/3/1v594cenk74-12-2-5b50c60e46e44bc187eb436d9adb3b11-sycugd");
            add("https://avatar.cdn.lianxinapp.com/avatar2/u/c/2025/7/31/a/p/2314cy7y9kw-1-2-aeb1bc26ddcf4aa7a57bcef004a418e6-t08v3z_small.jpg");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f15774a;

        public d(e eVar) {
            this.f15774a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15774a.onProgress(0);
            List<ReportVo.PingResult> listH = a.h(this.f15774a);
            List<ReportVo.DownloadResResult> listF = a.f(this.f15774a);
            String strI = a.i(this.f15774a);
            if (this.f15774a.b()) {
                return;
            }
            this.f15774a.a(listH, listF, strI);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(List<ReportVo.PingResult> list, List<ReportVo.DownloadResResult> list2, String str);

        boolean b();

        void onProgress(int i);
    }

    public static Runnable d(e eVar) {
        return new d(eVar);
    }

    public static ReportVo.DownloadResResult e(String str) {
        ReportVo.DownloadResResult downloadResResult = new ReportVo.DownloadResResult();
        downloadResResult.url = str;
        downloadResResult.success = false;
        downloadResResult.costTime = 0L;
        long jB = ir5.b();
        LogUtil.i("NetDetectManager", "downloadImage start");
        FutureTarget<Drawable> futureTargetSubmit = hc2.a(AppContext.getContext()).load(k86.p(str)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).submit();
        try {
            LogUtil.i("NetDetectManager", "downloadImage success drawable=" + futureTargetSubmit.get());
            hc2.a(AppContext.getContext()).clear(futureTargetSubmit);
            downloadResResult.success = true;
            downloadResResult.costTime = ir5.e(jB);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogUtil.i("NetDetectManager", "downloadImage end");
        return downloadResResult;
    }

    public static List<ReportVo.DownloadResResult> f(e eVar) {
        ArrayList arrayList = new ArrayList();
        LogUtil.i("NetDetectManager", "downloadList start");
        List<String> listG = g();
        int size = b / listG.size();
        int i = f15773a;
        for (String str : listG) {
            if (eVar.b()) {
                break;
            }
            arrayList.add(e(str));
            i += size;
            eVar.onProgress(i);
        }
        LogUtil.i("NetDetectManager", "downloadList end" + az2.c(arrayList));
        return arrayList;
    }

    public static List<String> g() {
        JSONArray jSONArrayOptJSONArray;
        List<String> list = d;
        JSONObject config = vs0.a().getConfig("clientNetDetect");
        if (config == null || (jSONArrayOptJSONArray = config.optJSONArray("imgUrls")) == null || jSONArrayOptJSONArray.length() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.optString(i));
        }
        return arrayList.size() > 0 ? arrayList : list;
    }

    public static List<ReportVo.PingResult> h(e eVar) {
        Pair<te1, DNSNode> pairL;
        ArrayList arrayList = new ArrayList();
        LogUtil.i("NetDetectManager", "pingList start");
        int size = f15773a / c.size();
        int i = 0;
        for (Map.Entry<String, Boolean> entry : c.entrySet()) {
            if (eVar.b()) {
                break;
            }
            String key = entry.getKey();
            boolean zBooleanValue = entry.getValue().booleanValue();
            arrayList.add(com.zenmen.palmchat.utils.traceroutePing.b.d(key));
            if (zBooleanValue && (pairL = it0.k().l(key)) != null) {
                arrayList.add(com.zenmen.palmchat.utils.traceroutePing.b.d(((DNSNode) pairL.second).host));
            }
            i += size;
            eVar.onProgress(i);
        }
        LogUtil.i("NetDetectManager", "pingList end" + az2.c(arrayList));
        return arrayList;
    }

    public static String i(e eVar) {
        JSONObject jSONObject;
        ir5.b();
        LogUtil.i("NetDetectManager", "requestClientIp start");
        String string = "";
        if (!eVar.b()) {
            try {
                LXBaseNetBean lXBaseNetBeanK = zw4.k(new c());
                if (lXBaseNetBeanK != null && (jSONObject = lXBaseNetBeanK.originData) != null) {
                    string = jSONObject.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        eVar.onProgress(100);
        LogUtil.i("NetDetectManager", "requestClientIp end");
        return string;
    }

    public static void j(e eVar) {
        u93.e(d(eVar));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<String>> {
        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            sw4 sw4VarB = sw4.b(0, "https://openapi-ipv6.lianxinapp.com/outerchannel/requestInfo", new HashMap());
            sw4VarB.h = false;
            sw4VarB.g = true;
            return sw4VarB;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
        }
    }
}
