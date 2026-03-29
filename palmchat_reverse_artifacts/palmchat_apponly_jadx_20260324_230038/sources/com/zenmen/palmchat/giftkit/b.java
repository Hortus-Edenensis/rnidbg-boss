package com.zenmen.palmchat.giftkit;

import android.content.Context;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.reflect.TypeToken;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.giftkit.bean.ActivityItem;
import com.zenmen.palmchat.giftkit.bean.GiftPanelBean;
import com.zenmen.palmchat.giftkit.bean.GiftPanelItem;
import com.zenmen.palmchat.giftkit.bean.PackPanelItem;
import com.zenmen.palmchat.giftkit.event.BalanceUpdateEvent;
import com.zenmen.palmchat.giftkit.event.GiftMsgEvent;
import com.zenmen.palmchat.giftkit.event.GiftPanelUpdateEvent;
import com.zenmen.palmchat.giftkit.event.GiftSendResultEvent;
import com.zenmen.palmchat.giftkit.event.PackPanelUpdateEvent;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.b05;
import defpackage.ds0;
import defpackage.hx3;
import defpackage.k86;
import defpackage.sd3;
import defpackage.v4;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.z92;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static b k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<GiftPanelItem> f14073a = new ArrayList();
    public List<GiftPanelItem> b = new ArrayList();
    public List<PackPanelItem> c = new ArrayList();
    public List<PackPanelItem> d = new ArrayList();
    public List<GiftPanelItem> e = new ArrayList();
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<ArrayList<PackPanelItem>> {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.giftkit.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1056b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f14075a;

        public C1056b(long j) {
            this.f14075a = j;
            put("giftid", Long.valueOf(j));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f14076a;
        public final /* synthetic */ long b;
        public final /* synthetic */ m c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("giftid", Long.valueOf(c.this.b));
            }
        }

        public c(m mVar, long j, m mVar2) {
            this.f14076a = mVar;
            this.b = j;
            this.c = mVar2;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            m mVar = this.c;
            if (mVar != null) {
                mVar.call();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (this.f14076a != null) {
                zn6.j("gift_secondconfirm", "click", new a());
                this.f14076a.call();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14080a;

        public f(int i) {
            this.f14080a = i;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            ds0.a().b(new PackPanelUpdateEvent(this.f14080a, true, b.this.f));
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            LogUtil.json("GiftPanelManager", jSONObject, "GiftDao.queryPackPanel");
            if (yy2Var == null || !yy2Var.f22300a || (jSONObject2 = yy2Var.d) == null) {
                ds0.a().b(new PackPanelUpdateEvent(this.f14080a, false, b.this.f));
                return;
            }
            b.this.f = jSONObject2.optLong("lxbAmount");
            b.this.p(this.f14080a, yy2Var.d.optString("items"));
            ds0.a().b(new PackPanelUpdateEvent(this.f14080a, false, b.this.f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14081a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long d;
        public final /* synthetic */ List e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;
        public final /* synthetic */ SendGiftInfo h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        public g(int i, int i2, boolean z, long j, List list, int i3, long j2, SendGiftInfo sendGiftInfo, String str, String str2) {
            this.f14081a = i;
            this.b = i2;
            this.c = z;
            this.d = j;
            this.e = list;
            this.f = i3;
            this.g = j2;
            this.h = sendGiftInfo;
            this.i = str;
            this.j = str2;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            ds0.a().b(new GiftSendResultEvent(this.f14081a, this.b, true, this.c, this.d, b.this.f, this.e.size(), this.f, this.g, -1, "网络好像有点问题，稍后再试", this.h));
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            LogUtil.json("GiftPanelManager", jSONObject, "GiftDao.guideMid");
            if (yy2Var != null) {
                ds0.a().b(new GiftSendResultEvent(this.f14081a, this.b, true, this.c, this.d, b.this.f, this.e.size(), this.f, this.g, yy2Var.b, yy2Var.c, this.h));
                if (yy2Var.f22300a && (jSONObject2 = yy2Var.d) != null && jSONObject2.has("bizData")) {
                    ds0.a().b(new GiftMsgEvent(this.f14081a, this.i, this.e, yy2Var.d.optString("bizData"), this.j));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14082a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long d;
        public final /* synthetic */ List e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;
        public final /* synthetic */ SendGiftInfo h;
        public final /* synthetic */ String i;

        public h(int i, int i2, boolean z, long j, List list, int i3, long j2, SendGiftInfo sendGiftInfo, String str) {
            this.f14082a = i;
            this.b = i2;
            this.c = z;
            this.d = j;
            this.e = list;
            this.f = i3;
            this.g = j2;
            this.h = sendGiftInfo;
            this.i = str;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            ds0.a().b(new GiftSendResultEvent(this.f14082a, this.b, true, this.c, this.d, b.this.f, this.e.size(), this.f, this.g, -1, "网络好像有点问题，稍后再试", this.h));
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            LogUtil.json("GiftPanelManager", jSONObject, "GiftDao.sendPackGift");
            if (yy2Var != null) {
                ds0.a().b(new GiftSendResultEvent(this.f14082a, this.b, true, this.c, this.d, b.this.f, this.e.size(), this.f, this.g, yy2Var.b, yy2Var.c, this.h));
                if (yy2Var.f22300a && (jSONObject2 = yy2Var.d) != null && jSONObject2.has("bizData")) {
                    ds0.a().b(new GiftMsgEvent(this.f14082a, this.i, this.e, yy2Var.d.optString("bizData"), null));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f14083a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ long e;
        public final /* synthetic */ List f;
        public final /* synthetic */ int g;
        public final /* synthetic */ long h;
        public final /* synthetic */ SendGiftInfo i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public i(long j, int i, int i2, boolean z, long j2, List list, int i3, long j3, SendGiftInfo sendGiftInfo, String str, String str2) {
            this.f14083a = j;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = j2;
            this.f = list;
            this.g = i3;
            this.h = j3;
            this.i = sendGiftInfo;
            this.j = str;
            this.k = str2;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            b05.d("GiftDao.sendGift_onFail_GiftSendResultEvent");
            ds0.a().b(new GiftSendResultEvent(this.b, this.c, false, this.d, this.e, b.this.f, this.f.size(), this.g, this.h, -1, "网络好像有点问题，稍后再试", this.i));
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            LogUtil.json("GiftPanelManager", jSONObject, "GiftDao.sendGift");
            b05.d("GiftDao.sendGift");
            if (yy2Var != null) {
                JSONObject jSONObject3 = yy2Var.d;
                if (jSONObject3 != null && jSONObject3.has("lxbAmount")) {
                    long j = b.this.g;
                    long j2 = this.f14083a;
                    if (j > j2) {
                        return;
                    }
                    b.this.g = j2;
                    b.this.f = yy2Var.d.optLong("lxbAmount");
                }
                b05.d("GiftDao.sendGift_onSuccess_GiftSendResultEvent");
                ds0.a().b(new GiftSendResultEvent(this.b, this.c, false, this.d, this.e, b.this.f, this.f.size(), this.g, this.h, yy2Var.b, yy2Var.c, this.i));
                if (yy2Var.f22300a && (jSONObject2 = yy2Var.d) != null && jSONObject2.has("bizData")) {
                    ds0.a().b(new GiftMsgEvent(this.b, this.j, this.f, yy2Var.d.optString("bizData"), this.k));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends TypeToken<ArrayList<GiftPanelItem>> {
        public j() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends TypeToken<ArrayList<GiftPanelItem>> {
        public k() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends TypeToken<ArrayList<GiftPanelItem>> {
        public l() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface m {
        void call();
    }

    public b() {
        m();
    }

    public static b j() {
        if (k == null) {
            synchronized (b.class) {
                if (k == null) {
                    k = new b();
                }
            }
        }
        return k;
    }

    public long g() {
        return this.f;
    }

    public final List<GiftPanelItem> h(List<GiftPanelItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (GiftPanelItem giftPanelItem : list) {
                int i2 = giftPanelItem.itemType;
                if (i2 == 0 || i2 == 1 || i2 == 11) {
                    arrayList.add(giftPanelItem);
                }
            }
        }
        return arrayList;
    }

    public List<GiftPanelItem> i(int i2) {
        return h(i2 == 201 ? this.f14073a : i2 == 301 ? this.b : i2 == 801 ? this.e : null);
    }

    public List<PackPanelItem> k(int i2) {
        if (i2 == 201) {
            return this.c;
        }
        if (i2 == 301) {
            return this.d;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(int i2, int i3, String str, boolean z, long j2, int i4, boolean z2, String str2, List<String> list, String str3, long j3, long j4, String str4, boolean z3, String str5) {
        JSONObject jSONObject;
        SendGiftInfo sendGiftInfo = new SendGiftInfo(i2, i3, str, z, j2, i4, z2, str2, list, str3, j3, j4, str4, z3, str5);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("relatedId", str2);
            try {
                jSONObject2.put("panelId", i2);
                try {
                    jSONObject2.put("toUser", TextUtils.join(",", list));
                } catch (JSONException e2) {
                    e = e2;
                }
                try {
                    jSONObject2.put("itemId", j2);
                    try {
                        jSONObject2.put("count", i4);
                        try {
                            jSONObject2.put("roomId", str);
                            jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject = new JSONObject(str3);
                            }
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (z3) {
                    }
                }
            } catch (JSONException e6) {
                e = e6;
                e.printStackTrace();
                if (z3) {
                }
            }
        } catch (JSONException e7) {
            e = e7;
        }
        try {
            jSONObject.put("fastlane", i3);
            jSONObject2.put("bizExt", jSONObject.toString());
        } catch (JSONException e8) {
            e = e8;
            e.printStackTrace();
        }
        if (z3) {
            LogUtil.json("GiftPanelManager", jSONObject2, "GiftDao.guideMid");
            z92.f(jSONObject2, new g(i2, i3, z2, j2, list, i4, j4, sendGiftInfo, str, str4));
        } else {
            if (!z) {
                z92.e(jSONObject2, new i(j3, i2, i3, z2, j2, list, i4, j4, sendGiftInfo, str, str4));
                if (this.g > j3) {
                    this.g = 0L;
                    return;
                }
                return;
            }
            LogUtil.json("GiftPanelManager", jSONObject2, "GiftDao.sendPackGift");
            z92.g(jSONObject2, new h(i2, i3, z2, j2, list, i4, j4, sendGiftInfo, str));
        }
    }

    public final void m() {
        try {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.GIFT_PANEL;
            this.f = sPUtil.i(scene, k86.a("key_gift_panel_balance"), 0L);
            String strN = sPUtil.n(scene, "key_gift_panel_list201", "");
            if (!TextUtils.isEmpty(strN)) {
                this.f14073a = (List) az2.b(strN, new j().getType());
            }
            String strN2 = sPUtil.n(scene, "key_gift_panel_list301", "");
            if (!TextUtils.isEmpty(strN2)) {
                this.b = (List) az2.b(strN2, new k().getType());
            }
            String strN3 = sPUtil.n(scene, "key_gift_panel_list801", "");
            if (TextUtils.isEmpty(strN3)) {
                return;
            }
            this.e = (List) az2.b(strN3, new l().getType());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean n(int i2) {
        if (i2 == 201) {
            List<GiftPanelItem> list = this.f14073a;
            return list == null || list.isEmpty() || Math.abs(System.currentTimeMillis() - this.h) > 600000;
        }
        if (i2 == 301) {
            List<GiftPanelItem> list2 = this.b;
            return list2 == null || list2.isEmpty() || Math.abs(System.currentTimeMillis() - this.i) > 600000;
        }
        if (i2 != 801) {
            return false;
        }
        List<GiftPanelItem> list3 = this.e;
        return list3 == null || list3.isEmpty() || Math.abs(System.currentTimeMillis() - this.j) > 600000;
    }

    public final void o(int i2, String str) {
        List<GiftPanelItem> list;
        try {
            GiftPanelBean giftPanelBean = (GiftPanelBean) az2.a(str, GiftPanelBean.class);
            if (giftPanelBean == null || (list = giftPanelBean.itemList) == null || list.isEmpty()) {
                return;
            }
            List<ActivityItem> list2 = giftPanelBean.activityList;
            if (list2 != null && !list2.isEmpty()) {
                for (ActivityItem activityItem : giftPanelBean.activityList) {
                    if (activityItem.showPosition > 0 && !TextUtils.isEmpty(activityItem.activityUrl)) {
                        int size = giftPanelBean.itemList.size();
                        int i3 = activityItem.showPosition;
                        if (size >= i3) {
                            giftPanelBean.itemList.remove(i3);
                            GiftPanelItem giftPanelItem = new GiftPanelItem();
                            giftPanelItem.itemId = activityItem.id;
                            giftPanelItem.itemName = activityItem.activityName;
                            giftPanelItem.iconUrl = activityItem.activityIcon;
                            giftPanelItem.itemType = 0;
                            giftPanelItem.activityUrl = activityItem.activityUrl;
                            giftPanelBean.itemList.add(activityItem.showPosition, giftPanelItem);
                        }
                    }
                }
            }
            if (i2 == 201) {
                this.f14073a = giftPanelBean.itemList;
            } else if (i2 == 301) {
                this.b = giftPanelBean.itemList;
            } else if (i2 == 801) {
                this.e = giftPanelBean.itemList;
            }
            SPUtil.f14322a.t(SPUtil.SCENE.GIFT_PANEL, "key_gift_panel_list" + i2, az2.c(giftPanelBean.itemList));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void p(int i2, String str) {
        try {
            List<PackPanelItem> list = (List) az2.b(str, new a().getType());
            if (list != null) {
                if (i2 == 201) {
                    this.c = list;
                } else if (i2 == 301) {
                    this.d = list;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void q() {
        r(null);
    }

    public void r(m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(com.zenmen.palmchat.c.b()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        z92.c(jSONObject, new e(mVar));
    }

    public void s(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("panelId", i2);
            jSONObject.put("lxd", true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        z92.b(jSONObject, new f(i2));
    }

    public void t() {
        SPUtil.f14322a.t(SPUtil.SCENE.GIFT_PANEL, k86.a("key_gift_panel_balance"), Long.valueOf(this.f));
    }

    public final void u(int i2) {
        if (i2 == 201) {
            this.h = System.currentTimeMillis();
        }
        if (i2 == 301) {
            this.i = System.currentTimeMillis();
        }
        if (i2 == 801) {
            this.j = System.currentTimeMillis();
        }
    }

    public void v(Context context, long j2, String str, String str2, m mVar) {
        w(context, j2, str, str2, mVar, null);
    }

    public void w(Context context, long j2, String str, String str2, m mVar, m mVar2) {
        if (context == null) {
            return;
        }
        zn6.j("gift_secondconfirm", "view", new C1056b(j2));
        new sd3(context).k("是否继续购买“" + str + "“（" + str2 + "连信豆）？").P("确定").L("放弃").f(new c(mVar, j2, mVar2)).e().show();
    }

    public void x(int i2, boolean z) {
        if (hx3.m(com.zenmen.palmchat.c.b())) {
            if (z || n(i2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("panelId", i2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                z92.a(jSONObject, new d(i2));
                u(i2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14078a;

        public d(int i) {
            this.f14078a = i;
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.json("GiftPanelManager", jSONObject, "GiftDao.getGiftList");
            if (yy2Var == null || !yy2Var.f22300a) {
                return;
            }
            b.this.o(this.f14078a, jSONObject.optString("data"));
            ds0.a().b(new GiftPanelUpdateEvent(this.f14078a));
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f14079a;

        public e(m mVar) {
            this.f14079a = mVar;
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            LogUtil.json("GiftPanelManager", jSONObject, "GiftDao.queryBalance");
            if (yy2Var == null || !yy2Var.f22300a || (jSONObject2 = yy2Var.d) == null) {
                return;
            }
            b.this.f = jSONObject2.optLong("count");
            ds0.a().b(new BalanceUpdateEvent(b.this.f));
            m mVar = this.f14079a;
            if (mVar != null) {
                mVar.call();
            }
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
        }
    }
}
