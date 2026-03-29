package defpackage;

import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.hp3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ax4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1599a = false;
    public static String b = v4.e(com.zenmen.palmchat.c.b());
    public static final String c = nl0.z + "/dynamic.data.board.v8";
    public static final String d = nl0.z + "/user.charm.level.v1";
    public static List<CellItem> e = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rn f1600a;

        public a(rn rnVar) {
            this.f1600a = rnVar;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            np3.o = false;
            LogUtil.d("RequestMineInfoManagers", "error: ");
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            np3.o = false;
            try {
                LogUtil.i("RequestMineInfoManagers", "onSuccess: " + yy2Var.toString());
                if (jSONObject.getInt("resultCode") == 0 && yy2Var.f22300a && (jSONObject2 = yy2Var.d) != null) {
                    try {
                        String string = jSONObject2.toString();
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        String strH = ax4.h();
                        ax4.f1599a = true;
                        if (string.equals(strH)) {
                            string = strH;
                        } else {
                            ax4.n(string);
                        }
                        ax4.d(string, this.f1600a);
                        ax4.k();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(int i, int i2, int i3, int i4);
    }

    public static void d(String str, rn rnVar) {
        try {
            hp3 hp3Var = new hp3();
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT);
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                hp3.b bVar = new hp3.b();
                bVar.b(jSONObject2.optString("lastTotal"));
                bVar.c(jSONObject2.optString("total"));
                hp3Var.k(bVar);
            }
            String strOptString2 = jSONObject.optString("friendFeeds");
            if (!TextUtils.isEmpty(strOptString2)) {
                JSONObject jSONObject3 = new JSONObject(strOptString2);
                hp3.c cVar = new hp3.c();
                cVar.a(jSONObject3.optString("lastTotal"));
                cVar.b(jSONObject3.optString("total"));
                hp3Var.l(cVar);
            }
            String strOptString3 = jSONObject.optString("myAttentionAnchor");
            if (!TextUtils.isEmpty(strOptString3)) {
                JSONObject jSONObject4 = new JSONObject(strOptString3);
                hp3.a aVar = new hp3.a();
                aVar.f18019a = jSONObject4.optString("total");
                hp3Var.r(aVar);
            }
            String strOptString4 = jSONObject.optString("like");
            if (!TextUtils.isEmpty(strOptString4)) {
                JSONObject jSONObject5 = new JSONObject(strOptString4);
                hp3.d dVar = new hp3.d();
                dVar.b(jSONObject5.optString("lastTotal"));
                dVar.c(jSONObject5.optString("total"));
                hp3Var.o(dVar);
            }
            try {
                String strOptString5 = jSONObject.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK);
                if (!TextUtils.isEmpty(strOptString5)) {
                    JSONObject jSONObject6 = new JSONObject(strOptString5);
                    hp3.h hVar = new hp3.h();
                    hVar.a(jSONObject6.optString("total"));
                    hVar.b(jSONObject6.optString("unreadCount"));
                    hp3Var.w(hVar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            hp3Var.v(jSONObject.optString("sproutCount"));
            int iOptInt = jSONObject.optInt("groupFunc");
            hp3Var.n(iOptInt);
            int iOptInt2 = jSONObject.optInt("redIcon");
            hp3Var.t(iOptInt2);
            js2.o(iOptInt == 1);
            js2.p(iOptInt2 == 1);
            String strOptString6 = jSONObject.optString("lookMes");
            if (!TextUtils.isEmpty(strOptString6)) {
                JSONObject jSONObject7 = new JSONObject(strOptString6);
                hp3.f fVar = new hp3.f();
                fVar.c(jSONObject7.optString("lastTotal"));
                fVar.d(jSONObject7.optString("total"));
                fVar.e(jSONObject7.optString("unreadCount"));
                hp3Var.q(fVar);
            }
            String strOptString7 = jSONObject.optString("recentUsed");
            if (!TextUtils.isEmpty(strOptString7)) {
                JSONObject jSONObject8 = new JSONObject(strOptString7);
                hp3.g gVar = new hp3.g();
                gVar.a(jSONObject8.optInt("count"));
                gVar.b(jSONObject8.optString("list"));
                hp3Var.s(gVar);
                e(jSONObject8.optString("list"));
            }
            hp3Var.m(jSONObject.optLong("giftCount"));
            try {
                String strOptString8 = jSONObject.optString("likeMes");
                if (!TextUtils.isEmpty(strOptString8)) {
                    JSONObject jSONObject9 = new JSONObject(strOptString8);
                    hp3.e eVar = new hp3.e();
                    eVar.c(jSONObject9.optString("lastTotal"));
                    eVar.d(jSONObject9.optString("total"));
                    eVar.e(jSONObject9.optString("unreadCount"));
                    hp3Var.p(eVar);
                    hp3Var.u(true);
                }
            } catch (Exception unused) {
            }
            if (rnVar != null) {
                rnVar.run(1, null, hp3Var);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void e(String str) {
        String str2 = "invisibleModel";
        String str3 = "id";
        String str4 = "appId";
        String str5 = "iosUrl";
        String str6 = "nameEn";
        String str7 = "tag";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str8 = "strikeType";
        try {
            String str9 = "order";
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                List<CellItem> list = e;
                if (list != null) {
                    list.clear();
                }
                e = new ArrayList();
            }
            JSONArray jSONArray2 = new JSONArray();
            String str10 = "noticeType";
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray jSONArray3 = jSONArray;
                JSONObject jSONObject2 = new JSONObject();
                int i2 = i;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("showMenu", jSONObject.optString("showMenu"));
                jSONObject3.put("type", TurnInfo.TYPE_DEEP_LINK);
                jSONObject3.put(str5, jSONObject.optString(str5));
                jSONObject3.put("url", jSONObject.optString("url"));
                jSONObject2.put(str4, jSONObject.optString(str4));
                jSONObject2.put(LxAdDLManager.ITEM_DESC, jSONObject.optString("intro"));
                jSONObject2.put("descEn", jSONObject.optString("descEn"));
                jSONObject2.put("icon", jSONObject.optString("icon"));
                jSONObject2.put(str3, jSONObject.optString(str3));
                jSONObject2.put(str2, jSONObject.optString(str2));
                jSONObject2.put("kitCode", jSONObject.optString("kitCode"));
                jSONObject2.put("name", jSONObject.optString("name"));
                str6 = str6;
                String str11 = str2;
                jSONObject2.put(str6, jSONObject.optString(str6));
                String str12 = str10;
                String str13 = str3;
                jSONObject2.put(str12, jSONObject.optString(str12));
                String str14 = str9;
                String str15 = str4;
                jSONObject2.put(str14, jSONObject.optString(str14));
                String str16 = str8;
                jSONObject2.put(str16, jSONObject.optString(str16));
                String str17 = str7;
                jSONObject2.put(str17, jSONObject.optString(str17));
                jSONObject2.put("turnInfo", jSONObject3.toString());
                JSONArray jSONArray4 = jSONArray2;
                jSONArray4.put(jSONObject2);
                jSONArray2 = jSONArray4;
                String str18 = str5;
                e.add(new CellItem(jSONObject2.optString("name"), jSONObject2.optString(str6), jSONObject2.optString("icon"), jSONObject2.optString(str17), jSONObject2.optString(LxAdDLManager.ITEM_DESC), jSONObject2.optString("descEn"), jSONObject2.optString("kitCode"), jSONObject2.optString(str12), new TurnInfo(jSONObject3.optString("type"), jSONObject3.optString("url"), jSONObject3.optBoolean("showMenu"))));
                i = i2 + 1;
                str4 = str15;
                jSONArray = jSONArray3;
                str5 = str18;
                str9 = str14;
                str8 = str16;
                str7 = str17;
                str3 = str13;
                str10 = str12;
                str2 = str11;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void f(rn rnVar) {
        LogUtil.i("RequestMineInfoManagers", "doGetData: ");
        l(new a(rnVar));
    }

    public static String g(List<CellItem> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (list != null) {
            Iterator<CellItem> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().tag);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String h() {
        return go.g("minerecentdata" + v4.e(com.zenmen.palmchat.c.b()), "");
    }

    public static List<CellItem> i() {
        if (e == null) {
            String strH = h();
            if (!TextUtils.isEmpty(strH)) {
                d(strH, null);
            }
            if (e == null) {
                e = new ArrayList();
            }
        }
        LogUtil.i("RequestMineInfoManagers", e.size() + "");
        return e;
    }

    public static boolean j(List<CellItem> list, List<CellItem> list2) {
        boolean z = !g(list).equals(g(list2));
        if (z || f1599a) {
            f1599a = false;
            return true;
        }
        if (b.equals(v4.e(com.zenmen.palmchat.c.b()))) {
            return z;
        }
        b = v4.e(com.zenmen.palmchat.c.b());
        return true;
    }

    public static void k() {
        ch.s().G0();
    }

    public static void l(yw4 yw4Var) {
        StringBuilder sb = new StringBuilder();
        sb.append("doGetData: ");
        String str = c;
        sb.append(str);
        LogUtil.i("RequestMineInfoManagers", sb.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("verCode", ac1.f);
            jSONObject.put("verName", ac1.g);
            jSONObject.put("dhid", ac1.h);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("chanId", ac1.m);
            zw4.f(str, 1, jSONObject, yw4Var);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void m(c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("url: ");
        String str = d;
        sb.append(str);
        LogUtil.i("queryUserLevel", sb.toString());
        try {
            zw4.f(str, 1, new JSONObject(), new b(cVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void n(String str) {
        go.o("minerecentdata" + v4.e(com.zenmen.palmchat.c.b()), str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1601a;

        public b(c cVar) {
            this.f1601a = cVar;
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i("queryUserLevel", "result: " + yy2Var);
            if (!yy2Var.f22300a || yy2Var.d == null) {
                return;
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.MYTAB;
            int iF = sPUtil.f(scene, k86.a("key_mine_rich_level"), 0);
            int iF2 = sPUtil.f(scene, k86.a("key_mine_charm_level"), 0);
            int iOptInt = yy2Var.d.optInt("richLevel", 1);
            int iOptInt2 = yy2Var.d.optInt("charmLevel", 1);
            if (iOptInt != iF) {
                sPUtil.t(scene, k86.a("key_mine_rich_level"), Integer.valueOf(iOptInt));
            }
            if (iF2 != iOptInt2) {
                sPUtil.t(scene, k86.a("key_mine_charm_level"), Integer.valueOf(iOptInt2));
            }
            this.f1601a.a(iF, iOptInt, iF2, iOptInt2);
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
        }
    }
}
