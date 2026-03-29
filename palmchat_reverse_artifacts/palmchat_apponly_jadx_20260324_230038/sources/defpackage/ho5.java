package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.VolleyError;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTabInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTagCItemModel;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ho5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18006a;
    public bo5 e;
    public boolean b = false;
    public SuperExposeMsgTabInfo c = null;
    public SuperExposeInfo d = null;
    public long f = 0;
    public String g = "";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18007a;

        public a(String str) {
            this.f18007a = str;
            put("requestId", str);
            put(EventParams.KEY_CT_SDK_POSITION, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SuperExposeMsgTabInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ io5 f18008a;
        public final /* synthetic */ String b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("requestId", b.this.b);
                put(EventParams.KEY_CT_SDK_POSITION, 3);
                put("show_uid", ho5.this.g);
                put("useCache", 0);
                put("initialRequestId", "");
            }
        }

        /* JADX INFO: renamed from: ho5$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1207b extends HashMap<String, Object> {
            public C1207b() {
                put("requestId", b.this.b);
                put(EventParams.KEY_CT_SDK_POSITION, 3);
                put("show_uid", ho5.this.g);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LXBaseNetBean f18011a;

            public c(LXBaseNetBean lXBaseNetBean) {
                this.f18011a = lXBaseNetBean;
                put("requestId", b.this.b);
                put(EventParams.KEY_CT_SDK_POSITION, 3);
                put("failCode", Integer.valueOf(lXBaseNetBean.resultCode));
                put("failReason", lXBaseNetBean.errorMsg);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Pair f18012a;

            public d(Pair pair) {
                this.f18012a = pair;
                put("requestId", b.this.b);
                put(EventParams.KEY_CT_SDK_POSITION, 3);
                put("failCode", pair.first);
                put("failReason", pair.second);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Pair f18013a;

            public e(Pair pair) {
                this.f18013a = pair;
                put("requestId", b.this.b);
                put(EventParams.KEY_CT_SDK_POSITION, 3);
                put("failCode", pair.first);
                put("failReason", pair.second);
            }
        }

        public b(io5 io5Var, String str) {
            this.f18008a = io5Var;
            this.b = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            String strE = v4.e(com.zenmen.palmchat.c.b());
            if (!TextUtils.isEmpty(strE)) {
                map.put(DeviceInfoUtil.UID_TAG, strE);
                ContactInfoItem contactInfoItemA = dn0.a(strE);
                if (contactInfoItemA != null) {
                    map.put("gender", Integer.valueOf(contactInfoItemA.getGender()));
                    map.put("age", Integer.valueOf(contactInfoItemA.getAgeInt()));
                }
            }
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
            if (locationExI != null) {
                map.put("latitude", locationExI.getLatitude() + "");
                map.put("longitude", locationExI.getLongitude() + "");
                map.put("cityCode", locationExI.getCityCode());
            }
            if (gk4.d()) {
                map.put("hitLx68239", Boolean.TRUE);
            }
            return sw4.b(1, nl0.z + "/lbs.square.super.show.for.msg.tab.v1", map).f(false);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x012e A[Catch: Exception -> 0x012c, TryCatch #0 {Exception -> 0x012c, blocks: (B:9:0x0042, B:11:0x0046, B:13:0x004a, B:15:0x007c, B:17:0x008a, B:18:0x00ab, B:20:0x00b9, B:22:0x00f0, B:23:0x010a, B:24:0x010d, B:26:0x0119, B:32:0x013c, B:34:0x0140, B:36:0x014d, B:38:0x0158, B:27:0x0124, B:30:0x012e), top: B:47:0x0042 }] */
        @Override // defpackage.io2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(boolean z, LXBaseNetBean<SuperExposeMsgTabInfo> lXBaseNetBean, Exception exc) {
            SuperExposeMsgTabInfo superExposeMsgTabInfo;
            LogUtil.i("SuperExposeMsgTab", "requestMsgTabInfo SuperExpose7TaiJi info onResult=" + az2.c(lXBaseNetBean));
            ho5.this.b = false;
            io5 io5Var = new io5();
            io5 io5Var2 = this.f18008a;
            if (io5Var2 != null && !TextUtils.isEmpty(io5Var2.c())) {
                io5Var.g(this.f18008a.c());
            }
            if (lXBaseNetBean != null) {
                try {
                    if (lXBaseNetBean.resultCode != 0 || (superExposeMsgTabInfo = lXBaseNetBean.data) == null) {
                        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel requestMsgTabInfo TT7777——2 新接口返回失败 ");
                        ho5.this.p(io5Var, this.b);
                    } else {
                        ho5.this.c = superExposeMsgTabInfo;
                        ho5.this.c.requestId = this.b;
                        ho5.this.c.initialRequestId = this.b;
                        ho5.this.c.useCache = 0;
                        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel requestMsgTabInfo TT7777——1 新接口返回成功 ");
                        if (ho5.this.c.dataList == null || ho5.this.c.dataList.size() <= 0) {
                            ho5.this.p(io5Var, this.b);
                        } else {
                            io5Var.e(1);
                            SPUtil sPUtil = SPUtil.f14322a;
                            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
                            sPUtil.t(scene, "key_boost_msg_tab_request_failed_cache_content", az2.c(ho5.this.c));
                            sPUtil.t(scene, "key_boost_msg_tab_request_failed_cache_time", 3);
                            for (int i = 0; i < ho5.this.c.dataList.size(); i++) {
                                StringBuilder sb = new StringBuilder();
                                ho5 ho5Var = ho5.this;
                                sb.append(ho5Var.g);
                                sb.append(ho5.this.c.dataList.get(i).uid);
                                ho5Var.g = sb.toString();
                                if (i != ho5.this.c.dataList.size() - 1) {
                                    StringBuilder sb2 = new StringBuilder();
                                    ho5 ho5Var2 = ho5.this;
                                    sb2.append(ho5Var2.g);
                                    sb2.append(",");
                                    ho5Var2.g = sb2.toString();
                                }
                            }
                            if (!TextUtils.isEmpty(ho5.this.g)) {
                                zn6.j("boost_buyer_show", null, new a());
                            }
                        }
                    }
                    if (lXBaseNetBean != null && lXBaseNetBean.resultCode == 0) {
                        zn6.j("boost_buyer_request_success", null, new C1207b());
                    } else if (lXBaseNetBean != null) {
                        zn6.j("boost_buyer_request_fail", null, new c(lXBaseNetBean));
                    } else if (exc != null) {
                        zn6.j("boost_buyer_request_fail", null, new d(VolleyError.getExceptionCodeAndMessage(exc)));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel requestMsgTabInfo TT7777——3 新接口返回失败 ");
                    ho5.this.p(io5Var, this.b);
                    zn6.j("boost_buyer_request_fail", null, new e(VolleyError.getExceptionCodeAndMessage(e2)));
                }
            }
            LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel 所有接口结束开始判断样式 TT8888 mExposeInfo " + ho5.this.d);
            if (ho5.this.d != null) {
                ho5 ho5Var3 = ho5.this;
                io5Var = ho5Var3.m(ho5Var3.d, io5Var);
            } else {
                io5Var.f(0);
            }
            fo5.c(io5Var, true, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18014a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.f18014a = str;
            this.b = str2;
            put("requestId", str);
            put(EventParams.KEY_CT_SDK_POSITION, 3);
            put("show_uid", str2);
            put("useCache", 1);
            put("initialRequestId", ho5.this.c.initialRequestId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<SuperExposeInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18015a;

        public d(boolean z) {
            this.f18015a = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            ContactInfoItem contactInfoItemA;
            HashMap map = new HashMap();
            String strE = v4.e(com.zenmen.palmchat.c.b());
            if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
                map.put("gender", Integer.valueOf(contactInfoItemA.getGender()));
            }
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
            if (locationExI != null) {
                map.put("latitude", locationExI.getLatitude() + "");
                map.put("longitude", locationExI.getLongitude() + "");
            }
            map.put("scene", 1);
            map.put("requestTab", 1);
            return sw4.b(1, ap3.d(), map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SuperExposeInfo> lXBaseNetBean, Exception exc) {
            fo5.g = lXBaseNetBean;
            ho5.this.s(lXBaseNetBean, this.f18015a);
        }
    }

    public ho5(Context context, bo5 bo5Var) {
        this.f18006a = null;
        this.e = null;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel start");
        this.f18006a = context;
        this.e = bo5Var;
    }

    public final void j(io5 io5Var, boolean z, boolean z2) {
        ArrayList<SuperExposeMsgTagCItemModel> arrayList;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel SuperExposeMsgTabViewT SuperExpose7TaiJi checkRequestMsgTabInfo TT4444 老接口结束后开始判断 mMsgTabInfo " + this.c + " allowRequestInfo " + z2);
        SuperExposeMsgTabInfo superExposeMsgTabInfo = this.c;
        if (superExposeMsgTabInfo == null || (arrayList = superExposeMsgTabInfo.dataList) == null || arrayList.size() <= 0) {
            if (z2) {
                r(z, io5Var);
                return;
            } else {
                io5Var.e(0);
                fo5.c(io5Var, z2, false);
                return;
            }
        }
        io5Var.e(1);
        fo5.c(io5Var, z2, false);
        if (z2) {
            r(z, io5Var);
        }
    }

    public SuperExposeInfo k() {
        return this.d;
    }

    public SuperExposeMsgTabInfo l() {
        return this.c;
    }

    public final io5 m(SuperExposeInfo superExposeInfo, io5 io5Var) {
        if (io5Var != null && superExposeInfo != null) {
            if (superExposeInfo.showEntrance) {
                io5Var.f(1);
            } else {
                io5Var.f(0);
            }
            if (superExposeInfo.status == 1) {
                io5Var.h(1);
            } else {
                io5Var.h(0);
            }
        }
        return io5Var;
    }

    public void n(LXBaseNetBean<SuperExposeInfo> lXBaseNetBean, boolean z, boolean z2, boolean z3) {
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabViewT SuperExposeMsgTabModel 老接口返回 TT3333 ");
        if (lXBaseNetBean != null) {
            try {
                if (lXBaseNetBean.resultCode == 0 && lXBaseNetBean.data != null) {
                    io5 io5Var = new io5();
                    this.d = lXBaseNetBean.data;
                    LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabViewT SuperExposeMsgTabModel 老接口成功 TT3333——1 result:" + az2.c(lXBaseNetBean));
                    io5 io5VarM = m(this.d, io5Var);
                    if (z2) {
                        io5VarM.g(WkAdxAdConfigMg.DSP_NAME_CSJ);
                    }
                    j(io5VarM, z, z3);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel 老接口失败 TT3333——3");
                o(z, z2, z3);
                return;
            }
        }
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabViewT SuperExposeMsgTabModel 老接口失败 TT3333——2");
        o(z, z2, z3);
    }

    public final void o(boolean z, boolean z2, boolean z3) {
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel 老接口失败判断 mExposeInfo " + this.d);
        io5 io5Var = new io5();
        SuperExposeInfo superExposeInfo = this.d;
        if (superExposeInfo != null) {
            io5Var = m(superExposeInfo, io5Var);
        } else {
            io5Var.f(0);
            io5Var.h(0);
        }
        if (z2) {
            io5Var.g(WkAdxAdConfigMg.DSP_NAME_CSJ);
        }
        j(io5Var, z, z3);
    }

    public final void p(io5 io5Var, String str) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        int iF = sPUtil.f(scene, "key_boost_msg_tab_request_failed_cache_time", -1);
        b05.d("readCacheRequest()=====》剩余次数：" + iF);
        String str2 = "";
        if (iF > 0) {
            try {
                if (fo5.h.equals(BuildConfig.USE_CLOUD_CONFIG)) {
                    SuperExposeMsgTabInfo superExposeMsgTabInfo = (SuperExposeMsgTabInfo) az2.a(sPUtil.n(scene, "key_boost_msg_tab_request_failed_cache_content", ""), SuperExposeMsgTabInfo.class);
                    this.c = superExposeMsgTabInfo;
                    superExposeMsgTabInfo.requestId = str;
                    superExposeMsgTabInfo.useCache = 1;
                    sPUtil.t(scene, "key_boost_msg_tab_request_failed_cache_content", az2.c(superExposeMsgTabInfo));
                    int i = iF - 1;
                    sPUtil.t(scene, "key_boost_msg_tab_request_failed_cache_time", Integer.valueOf(i));
                    io5Var.e(1);
                    b05.d("readCacheRequest()=====》设置剩余缓存的数量是" + i);
                    b05.d("readCacheRequest()=====》读取缓存数据结束");
                    for (int i2 = 0; i2 < this.c.dataList.size(); i2++) {
                        String str3 = str2 + this.c.dataList.get(i2).uid;
                        if (i2 != this.c.dataList.size() - 1) {
                            str3 = str3 + ",";
                        }
                        str2 = str3;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    zn6.j("boost_buyer_show", null, new c(str, str2));
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        b05.d("readCacheRequest()=====》未读取缓存数据-直接结束");
        this.c = null;
        io5Var.e(0);
    }

    public void q(boolean z) {
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel requestMagTabAllSuperExpose TT1111 mIsRequesting " + this.b);
        if (this.b) {
            return;
        }
        this.b = true;
        if (!z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - fo5.e;
            long j2 = fo5.d;
            if (j2 == -1 || j < j2) {
                LogUtil.d("", "mRequestStatusLastTime requestMagTabAllSuperExpose time not allow");
                s(fo5.g, z);
                return;
            }
            fo5.e = jCurrentTimeMillis;
        }
        LogUtil.d("SuperExposeMsgTab", "mRequestStatusLastTime SuperExposeMsgTabModel 开始请求老接口 TT2222");
        zw4.e(new d(z));
    }

    public final void r(boolean z, io5 io5Var) {
        ArrayList<SuperExposeMsgTagCItemModel> arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.f;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel SuperExpose7TaiJi requestMsgTabInfo TT5555 新接口请求 duratime " + j);
        if (!z) {
            long j2 = fo5.c;
            if (j2 == -1 || j < j2) {
                this.b = false;
                SuperExposeMsgTabInfo superExposeMsgTabInfo = this.c;
                if (superExposeMsgTabInfo == null || (arrayList = superExposeMsgTabInfo.dataList) == null || arrayList.size() <= 0) {
                    io5Var.e(0);
                } else {
                    io5Var.e(1);
                }
                fo5.c(io5Var, true, false);
                LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel SuperExpose7TaiJi requestMsgTabInfo time not allow");
                return;
            }
        }
        this.f = jCurrentTimeMillis;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabModel SuperExpose7TaiJi requestMsgTabInfo TT6666 新接口允许请求 ");
        String strA = xn3.a();
        this.g = "";
        zn6.j("boost_buyer_request_start", null, new a(strA));
        zw4.e(new b(io5Var, strA));
    }

    public final void s(LXBaseNetBean<SuperExposeInfo> lXBaseNetBean, boolean z) {
        SuperExposeInfo superExposeInfo;
        this.b = false;
        if (lXBaseNetBean != null && (superExposeInfo = lXBaseNetBean.data) != null) {
            com.zenmen.palmchat.paidservices.superexpose.b.x = superExposeInfo.superShowType;
            fo5.f17568a = superExposeInfo.status;
            LogUtil.i("", "statusOnResult 397 exposeStatus =" + fo5.f17568a);
        }
        t(lXBaseNetBean, z, true);
    }

    public void t(LXBaseNetBean<SuperExposeInfo> lXBaseNetBean, boolean z, boolean z2) {
        LogUtil.d("", "SuperExposeMsgTabViewT superExposeInfoDataSuccess allowRequestInfo " + z2 + " value " + tn5.b());
        u(lXBaseNetBean, z, z2);
    }

    public final void u(LXBaseNetBean<SuperExposeInfo> lXBaseNetBean, boolean z, boolean z2) {
        if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || lXBaseNetBean.data == null) {
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        long jI = sPUtil.i(scene, "key_threadnewmessage_cache_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = iv0.a(jI, "yyyy-MM-dd");
        String strA2 = iv0.a(jCurrentTimeMillis, "yyyy-MM-dd");
        sPUtil.t(scene, "key_threadnewmessage_cache_time", Long.valueOf(jCurrentTimeMillis));
        LogUtil.d("", "SuperExpose7TaiJi SuperExposeMsgTabViewT superMsgBUi start date " + jI + " lastDate " + strA + " curDate " + strA2);
        io5 io5Var = new io5();
        SuperExposeInfo superExposeInfo = lXBaseNetBean.data;
        this.d = superExposeInfo;
        io5 io5VarM = m(superExposeInfo, io5Var);
        io5VarM.g(WkAdxAdConfigMg.DSP_NAME_BAIDU);
        if (jI != 0 && strA2.equals(strA)) {
            n(lXBaseNetBean, z, true, z2);
        } else {
            io5VarM.e(0);
            fo5.c(io5VarM, z2, true);
        }
    }
}
