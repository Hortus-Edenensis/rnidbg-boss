package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumItem;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeShowNumItem;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeTabData;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hs3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f18042a = false;
    public static boolean b = false;
    public static int c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<SuperExposeShowNumItem>> {
        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            String strE = v4.e(c.b());
            if (!TextUtils.isEmpty(strE)) {
                map.put("lookGender", Integer.valueOf(hs3.d(dn0.a(strE))));
            }
            sw4 sw4VarF = sw4.b(1, nl0.z + "/lbs.square.super.show.count.v7", map).f(false);
            sw4VarF.o = aw.b(new JSONObject(map));
            return sw4VarF;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SuperExposeShowNumItem> lXBaseNetBean, Exception exc) {
            SuperExposeShowNumItem superExposeShowNumItem;
            hs3.b = false;
            if (!z || lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || (superExposeShowNumItem = lXBaseNetBean.data) == null) {
                return;
            }
            hs3.c = superExposeShowNumItem.count;
            LogUtil.d("", "MsgTabTaijiModelManager getShowCount mShowCount " + hs3.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SuperExposeTabData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18043a;
        public final /* synthetic */ int b;
        public final /* synthetic */ xo2 c;

        public b(int i, int i2, xo2 xo2Var) {
            this.f18043a = i;
            this.b = i2;
            this.c = xo2Var;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("tab", Integer.valueOf(this.f18043a));
            map.put("pageNo", Integer.valueOf(this.b));
            String strE = v4.e(c.b());
            if (!TextUtils.isEmpty(strE)) {
                map.put("lookGender", Integer.valueOf(hs3.d(dn0.a(strE))));
            }
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                map.put("latitude", locationExI.getLatitude() + "");
                map.put("longitude", locationExI.getLongitude() + "");
                map.put("cityCode", locationExI.getCityCode());
            }
            return sw4.b(1, nl0.z + "/lbs.square.super.show.list.v7", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SuperExposeTabData> lXBaseNetBean, Exception exc) {
            hs3.f18042a = false;
            if (!z || lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || lXBaseNetBean.data == null) {
                return;
            }
            try {
                LogUtil.d("", "MsgTabTaijiModelManager getAllTabData result " + az2.c(lXBaseNetBean));
                xo2 xo2Var = this.c;
                if (xo2Var != null) {
                    xo2Var.b(lXBaseNetBean.data);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(xo2 xo2Var, int i, int i2) {
        LogUtil.d("", "MsgTabTaijiModelManager getAllTabData tab " + i + " pageNo " + i2);
        if (f18042a) {
            return;
        }
        f18042a = true;
        zw4.e(new b(i, i2, xo2Var));
    }

    public static int d(ContactInfoItem contactInfoItem) {
        return (contactInfoItem == null || contactInfoItem.getGender() != 0) ? 0 : 1;
    }

    public static void e() {
        if (b) {
            return;
        }
        b = true;
        zw4.e(new a());
    }

    public static void f() {
        try {
            zn6.d("boost_message_allPeoplePage_buyButton", null, new JSONObject().toString());
        } catch (Exception unused) {
        }
    }

    public static void g(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showuid", str);
            jSONObject.put(EventParams.KEY_CT_SDK_POSITION, i);
            zn6.d("boost_message_allPeoplePage_click", null, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public static void h(List<SuperExposeNumItem> list, int i) {
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject jSONObject = new JSONObject();
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (!TextUtils.isEmpty(sb) && !sb.toString().endsWith(",")) {
                        sb.append(",");
                    }
                    sb.append(list.get(i2).uid);
                }
            }
            if (!TextUtils.isEmpty(sb)) {
                jSONObject.put("showuid", sb.toString());
            }
            if (i > 0) {
                jSONObject.put("curTab", i);
            }
            zn6.d("boost_message_allPeoplePage_show", null, jSONObject.toString());
        } catch (Exception unused) {
        }
    }
}
