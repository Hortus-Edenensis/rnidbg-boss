package defpackage;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.opos.mobad.activity.VideoActivity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.circle.bean.BlackUser;
import com.zenmen.palmchat.circle.bean.CircleApplyGroupType;
import com.zenmen.palmchat.circle.bean.CircleCateItem;
import com.zenmen.palmchat.circle.bean.CircleFirstCateList;
import com.zenmen.palmchat.circle.bean.CircleGrabRedPacketBean;
import com.zenmen.palmchat.circle.bean.CircleItem;
import com.zenmen.palmchat.circle.bean.CircleLoopBean;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bean.CircleRedPacketInfoBean;
import com.zenmen.palmchat.circle.bean.CircleSharePosterBean;
import com.zenmen.palmchat.circle.bean.CircleTagItem;
import com.zenmen.palmchat.circle.bean.ExpandFirstLevelData;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.coupon.info.CircleCouponInfoResult;
import com.zenmen.palmchat.circle.label.bean.CircleLabelResponse;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import defpackage.n54;
import defpackage.pw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c70 {
    public static c70 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dn2 f1902a;
    public en2 b;
    public bm2 c;
    public ml2 d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wi0 f1903a;

        public a(wi0 wi0Var) {
            this.f1903a = wi0Var;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0 || baseResponse.getResultCode() == 4001) {
                c70.this.E0(this.f1903a, baseResponse);
            } else {
                this.f1903a.a(baseResponse);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wi0 f1904a;
        public final /* synthetic */ BaseResponse b;

        public b(wi0 wi0Var, BaseResponse baseResponse) {
            this.f1904a = wi0Var;
            this.b = baseResponse;
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object[] objArr) {
            return Boolean.valueOf(c70.R().C0(true, new String[0]));
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            wi0 wi0Var = this.f1904a;
            if (wi0Var != null) {
                wi0Var.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AsyncTask<String, GroupInfoItem, GroupInfoItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1905a;
        public final /* synthetic */ wi0 b;

        public c(String str, wi0 wi0Var) {
            this.f1905a = str;
            this.b = wi0Var;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupInfoItem doInBackground(String... strArr) {
            c70.this.C0(true, new String[0]);
            return ze2.a(this.f1905a, 0);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(GroupInfoItem groupInfoItem) {
            super.onPostExecute(groupInfoItem);
            BaseResponse baseResponse = new BaseResponse(0, "");
            baseResponse.setData(groupInfoItem);
            this.b.a(baseResponse);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<CircleGrabRedPacketBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wi0 f1906a;

        public d(wi0 wi0Var) {
            this.f1906a = wi0Var;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleGrabRedPacketBean> baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                c70.this.E0(this.f1906a, baseResponse);
            } else {
                this.f1906a.a(baseResponse);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wi0 f1907a;

        public e(wi0 wi0Var) {
            this.f1907a = wi0Var;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                c70.R().E0(this.f1907a, baseResponse);
            } else {
                this.f1907a.a(baseResponse);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse<DatingGroupToolBeans>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wi0 f1908a;

        public f(wi0 wi0Var) {
            this.f1908a = wi0Var;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DatingGroupToolBeans> baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                c70.R().E0(this.f1908a, baseResponse);
            } else {
                this.f1908a.a(baseResponse);
            }
        }
    }

    public static synchronized c70 R() {
        if (e == null) {
            c70 c70Var = new c70();
            e = c70Var;
            c70Var.c0();
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(String str, sm5 sm5Var) {
        GroupInfoItem groupInfoItemD = this.d.d(str);
        if (groupInfoItemD == null) {
            sm5Var.onError(new Throwable());
        } else {
            sm5Var.onNext(groupInfoItemD);
            sm5Var.onCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(String str, sm5 sm5Var) {
        List<ContactInfoItem> listB = this.d.b(str);
        if (listB == null) {
            sm5Var.onError(new Throwable());
        } else {
            sm5Var.onNext(listB);
            sm5Var.onCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(String str, int i, sm5 sm5Var) {
        List<ContactInfoItem> listA = this.d.a(str, i);
        if (listA == null) {
            sm5Var.onError(new Throwable());
        } else {
            sm5Var.onNext(listA);
            sm5Var.onCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(String str, String str2, sm5 sm5Var) {
        sm5Var.onNext(this.d.c(str, str2));
        sm5Var.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(String str, sm5 sm5Var) {
        List<ContactInfoItem> listE = this.d.e(str);
        if (listE == null) {
            sm5Var.onError(new Throwable());
        } else {
            sm5Var.onNext(listE);
            sm5Var.onCompleted();
        }
    }

    public static /* synthetic */ void i0(String str, sm5 sm5Var) {
        ArrayList<CircleNoticeItem> latestCircleNotes = CircleNoticeItem.getLatestCircleNotes(str);
        if (latestCircleNotes == null) {
            sm5Var.onError(new Throwable());
        } else {
            sm5Var.onNext(latestCircleNotes);
            sm5Var.onCompleted();
        }
    }

    public static /* synthetic */ void j0(String str, sm5 sm5Var) {
        ArrayList<VoucherRedPacketVo> arrayListUngrabbedVoucherRedPackets = VoucherRedPacketVo.ungrabbedVoucherRedPackets(str);
        if (arrayListUngrabbedVoucherRedPackets == null) {
            sm5Var.onError(new Throwable());
        } else {
            sm5Var.onNext(arrayListUngrabbedVoucherRedPackets);
            sm5Var.onCompleted();
        }
    }

    public void A(String str, String str2, String str3, String str4, String str5, String str6, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/keep/finishAction").a("type", str).a("actionId", str2).a("lessonId", str3).a("planId", str4).a("week", str5).a("day", str6).b(), wi0Var);
    }

    public void A0(String str, int i, wi0<BaseResponse<HashMap<String, String>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/recmd/update").a("roomId", str).a("versionFlag", 1).a("recmdStatus", Integer.valueOf(i)).b(), wi0Var);
    }

    public void B(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/keep/finishAction").a("type", str).a("actionId", str2).b(), wi0Var);
    }

    public void B0(String str, boolean z, wi0<BaseResponse<Boolean>> wi0Var) {
        BaseResponse baseResponse = new BaseResponse(0, "");
        baseResponse.setData(Boolean.TRUE);
        wi0Var.a(baseResponse);
    }

    public void C(String str, wi0<BaseResponse<CircleApplyGroupType>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/addMode/query").a("roomId", str).b(), wi0Var);
    }

    public boolean C0(boolean z, String... strArr) {
        return this.f1902a.b(z, strArr);
    }

    public void D(int i, wi0<BaseResponse<List<CircleRecommendItem>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/myroom/list").a("roomListType", Integer.valueOf(i)).b(), wi0Var);
    }

    public void D0(String str, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/newcommerMsg/query").a("roomId", str).b(), wi0Var);
    }

    public void E(wi0<BaseResponse<ArrayList<CircleFirstCateList>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/recommend/cate").b(), wi0Var);
    }

    public void E0(wi0 wi0Var, BaseResponse baseResponse) {
        new b(wi0Var, baseResponse).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public void F(String str, wi0<BaseResponse<CircleRecommendItem>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/get/info").a("roomId", str).b(), wi0Var);
    }

    public void F0(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/cate/desc/update").a("roomId", str).a("otherDesc", str2).b(), wi0Var);
    }

    public void G(String str, wi0<BaseResponse<CircleSharePosterBean>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/get/poster").a("roomId", str).b(), wi0Var);
    }

    public void G0(long j, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/upgrade/multi2high").a("roomId", Long.valueOf(j)).b(), wi0Var);
    }

    public void H(String str, long j, int i, wi0<BaseResponse<List<CircleRecommendItem>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/query/name").a("name", str).a("startId", Long.valueOf(j)).a("pageSize", Integer.valueOf(i)).b(), wi0Var);
    }

    public void H0(String str, j56 j56Var) {
        this.c.b(str, j56Var);
    }

    public void I(String str, String str2, int i, int i2, Long l, wi0<BaseResponse<CircleCouponInfoResult>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/coupon/detail").a("couponId", str).a("pageNum", Integer.valueOf(i)).a(RedirectRespWrapper.KEY_VERCODE, str2).a("pageSize", Integer.valueOf(i2)).a("detailId", l).b(), wi0Var);
    }

    public void J(String str, wi0<BaseResponse<DatingGroupToolBeans>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tool/query").a("roomId", str).b(), wi0Var);
    }

    public void K(final String str, dv0<GroupInfoItem> dv0Var) {
        uz4.c(new n54.a() { // from class: v60
            @Override // defpackage.c5
            public final void call(Object obj) {
                this.f21363a.d0(str, (sm5) obj);
            }
        }, dv0Var);
    }

    public void L(final String str, final int i, dv0<List<ContactInfoItem>> dv0Var) {
        uz4.c(new n54.a() { // from class: b70
            @Override // defpackage.c5
            public final void call(Object obj) {
                this.f1659a.f0(str, i, (sm5) obj);
            }
        }, dv0Var);
    }

    public void M(final String str, dv0<List<ContactInfoItem>> dv0Var) {
        uz4.c(new n54.a() { // from class: a70
            @Override // defpackage.c5
            public final void call(Object obj) {
                this.f1164a.e0(str, (sm5) obj);
            }
        }, dv0Var);
    }

    public void N(final String str, final String str2, dv0<ContactInfoItem> dv0Var) {
        uz4.c(new n54.a() { // from class: y60
            @Override // defpackage.c5
            public final void call(Object obj) {
                this.f22129a.g0(str, str2, (sm5) obj);
            }
        }, dv0Var);
    }

    public void O(final String str, dv0<List<ContactInfoItem>> dv0Var) {
        uz4.c(new n54.a() { // from class: x60
            @Override // defpackage.c5
            public final void call(Object obj) {
                this.f21888a.h0(str, (sm5) obj);
            }
        }, dv0Var);
    }

    public void P(String str, wi0<BaseResponse<ArrayList<ContactInfoItem>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/member/mute/list").a("roomId", str).b(), wi0Var);
    }

    public void Q(wi0<BaseResponse<List<String>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/hotwords/list").b(), wi0Var);
    }

    public void S(String str, wi0<BaseResponse<GroupInfoItem>> wi0Var) {
        new c(str, wi0Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void T(final String str, dv0<ArrayList<CircleNoticeItem>> dv0Var) {
        uz4.c(new n54.a() { // from class: z60
            @Override // defpackage.c5
            public final void call(Object obj) {
                c70.i0(str, (sm5) obj);
            }
        }, dv0Var);
    }

    public void U(wi0<BaseResponse<CircleLoopBean>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/actbit/list").b(), wi0Var);
    }

    public void V(String str, wi0<BaseResponse<List<CircleRecommendItem>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/query/myroom/name").a("name", str).b(), wi0Var);
    }

    public void W(int i, int i2, double d2, double d3, String str, String str2, wi0<BaseResponse<List<CircleRecommendItem>>> wi0Var) {
        pw4.a aVarA = new pw4.a().c("/room/v5/near/search").a("pageNo", Integer.valueOf(i)).a("pageSize", Integer.valueOf(i2)).a(com.umeng.analytics.pro.f.D, Double.valueOf(d2)).a(com.umeng.analytics.pro.f.C, Double.valueOf(d3)).a("topCateId", str);
        if (!TextUtils.isEmpty(str2)) {
            aVarA.a("cateId", str2);
        }
        this.c.a(rj2.f20490a, aVarA.b(), wi0Var);
    }

    public void X(int i, int i2, long j, String str, String str2, wi0<BaseResponse<List<CircleRecommendItem>>> wi0Var) {
        pw4.a aVarA = new pw4.a().c("/room/v5/recommend/rooms").a("pageNo", Integer.valueOf(i)).a("pageSize", Integer.valueOf(i2)).a("startId", Long.valueOf(j)).a("topCateId", str);
        if (!TextUtils.isEmpty(str2)) {
            aVarA.a("cateId", str2);
        }
        this.c.a(rj2.f20490a, aVarA.b(), wi0Var);
    }

    public void Y(String str, String str2, wi0<BaseResponse<CircleRedPacketInfoBean>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/coupon/info").a("couponId", str).a(RedirectRespWrapper.KEY_VERCODE, str2).b(), wi0Var);
    }

    public void Z(final String str, dv0<ArrayList<VoucherRedPacketVo>> dv0Var) {
        uz4.c(new n54.a() { // from class: w60
            @Override // defpackage.c5
            public final void call(Object obj) {
                c70.j0(str, (sm5) obj);
            }
        }, dv0Var);
    }

    public void a0(String str, String str2, boolean z, wi0<BaseResponse<CircleGrabRedPacketBean>> wi0Var) {
        pw4 pw4VarB = new pw4.a().c("/room/v5/coupon/receive").a("couponId", str).a(RedirectRespWrapper.KEY_VERCODE, str2).a("type", Integer.valueOf(z ? 1 : 2)).b();
        if (z) {
            this.c.a(rj2.f20490a, pw4VarB, new d(wi0Var));
        } else {
            this.c.a(rj2.f20490a, pw4VarB, wi0Var);
        }
    }

    public void b0(String str, String str2, String str3, String str4, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/greet").a("roomId", str).a("fromUid", str2).a("toUid", str3).a("mid", str4).b(), wi0Var);
    }

    public void c0() {
        this.d = new r03();
        this.c = new s03();
        this.f1902a = new w03();
        m();
    }

    public void h(String str, String str2, wi0<BaseResponse<Map<String, Long>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tag/create").a("roomId", str).a("tagName", str2).b(), wi0Var);
    }

    public void i(String str, String str2, String str3, String str4, String str5, String str6, wi0<BaseResponse<String>> wi0Var) {
        pw4.a aVarC = new pw4.a().c("/room/v5/tool/addToolConf");
        if (!TextUtils.isEmpty(str)) {
            aVarC.a("roomId", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVarC.a("id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            aVarC.a("icon", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            aVarC.a("toolName", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            aVarC.a("description", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            aVarC.a("toolPage", str6);
        }
        this.c.a(rj2.f20490a, aVarC.b(), wi0Var);
    }

    public void j(String str, int i, String str2, String str3, wi0<BaseResponse> wi0Var) {
        pw4.a aVarA = new pw4.a().c("/room/v5/member/add").a("roomId", str).a("applyType", Integer.valueOf(i)).a("checkAnswer", str2);
        if (!TextUtils.isEmpty(str3)) {
            aVarA.a("applyContent", str3);
        }
        this.c.a(rj2.f20490a, aVarA.b(), new a(wi0Var));
    }

    public void k(String str, wi0<BaseResponse<CircleRecommendItem>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/applyRecord/count").a("roomId", str).b(), wi0Var);
    }

    public void k0(String str, wi0<BaseResponse<CircleItem>> wi0Var) {
        CircleItem circleItem = new CircleItem();
        GroupInfoItem groupInfoItem = new GroupInfoItem();
        circleItem.oldInfo = groupInfoItem;
        groupInfoItem.setGroupId("31031851");
        circleItem.oldInfo.setGroupName("花花同学会");
        circleItem.oldInfo.setGroupExInfo("欢迎进入花花同学会，花花的世界欢迎你");
        circleItem.onLineInfo = "在线12人，成员180人";
        circleItem.oldInfo.setGroupHeadImgUrl("http://short2.lx-qa.com/da/muc/31031851/e6b70121e1c8dc705e0d0816652b0171/a");
        circleItem.tags.add("游戏");
        circleItem.tags.add("二次元");
        circleItem.tags.add("同学聚会");
        BaseResponse baseResponse = new BaseResponse(0, "");
        baseResponse.setData(circleItem);
        wi0Var.a(baseResponse);
    }

    public void l(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v3/category").a("roomId", str).a(x.cw, str2).b(), wi0Var);
    }

    public void l0(String str, wi0<BaseResponse<ArrayList<BlackUser>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/blackList/query").a("roomId", str).a("blackType", 1).b(), wi0Var);
    }

    public final void m() {
        if (this.b == null) {
            this.b = this.f1902a.a(AppContext.getContext());
        }
        if (this.b.b()) {
            return;
        }
        this.b.a();
    }

    public void m0(String str, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/roomName/queryPermission").a("roomId", str).b(), wi0Var);
    }

    public void n(String str, String str2, int i, wi0<BaseResponse<DatingGroupToolBeans>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tool/setup").a("roomId", str).a("toolId", str2).a(VideoActivity.EXTRA_KEY_ACTION_TYPE, Integer.valueOf(i)).b(), new f(wi0Var));
    }

    public void n0(String str, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/newcommerMsgSwitch/query").a("roomId", str).b(), wi0Var);
    }

    public void o(String str, List<String> list, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tool/sort").a("roomId", str).a("toolIdList", list).b(), new e(wi0Var));
    }

    public void o0(String str, wi0<BaseResponse<CircleLabelResponse>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tag/query").a("roomId", str).b(), wi0Var);
    }

    public void p(String str, int i, int i2, int i3, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/addMode/set").a("roomId", str).a("addType", Integer.valueOf(i)).a("memberInviteFlag", Integer.valueOf(i2)).a("adminVerifyFlag", Integer.valueOf(i3)).a("checkType", 1).a("checkQuestion", "").a("checkAnswer", "").b(), wi0Var);
    }

    public void p0(List<Long> list, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/blackList/remove").a("idList", list).b(), wi0Var);
    }

    public void q(String str, int i, int i2, int i3, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/addMode/set").a("roomId", str).a("addType", Integer.valueOf(i)).a("memberInviteFlag", Integer.valueOf(i2)).a("adminVerifyFlag", Integer.valueOf(i3)).a("checkType", 1).a("checkQuestion", "").a("checkAnswer", "").b(), wi0Var);
    }

    public void q0(String str, List<RoomTag> list, wi0<BaseResponse> wi0Var) {
        ArrayList arrayList = new ArrayList();
        for (RoomTag roomTag : list) {
            HashMap map = new HashMap();
            map.put("tagName", roomTag.tagName);
            arrayList.add(map);
        }
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tag/save").a("roomId", str).a("tagList", arrayList).b(), wi0Var);
    }

    public void r(String str, int i, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/addMode/set").a("roomId", str).a("addType", Integer.valueOf(i)).b(), wi0Var);
    }

    public void r0(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/newcommerMsg/revokeMsg").a("roomId", str).a("mid", str2).b(), wi0Var);
    }

    public void s(String str, int i, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/addMode/set").a("roomId", str).a("addType", Integer.valueOf(i)).a("checkType", 1).a("memberInviteFlag", 1).a("adminVerifyFlag", 0).a("checkQuestion", "").a("checkAnswer", "").b(), wi0Var);
    }

    public void s0(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/himg/update").a("roomId", str).a("himg", str2).b(), wi0Var);
    }

    public void t(String str, boolean z, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/roomName/setPermission").a("roomId", str).a("permissionType", Integer.valueOf(z ? 1 : 0)).b(), wi0Var);
    }

    public void t0(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/cover/update").a("roomId", str).a("cover", str2).b(), wi0Var);
    }

    public void u(String str, String str2, String str3, String str4, wi0<BaseResponse> wi0Var) {
        pw4.a aVarA = new pw4.a().c("/room/v5/recmd/open").a("roomId", str);
        if (!TextUtils.isEmpty(str2)) {
            aVarA.a("himg", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            aVarA.a("name", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            aVarA.a(x.cw, str4);
        }
        this.c.a(rj2.f20490a, aVarA.b(), wi0Var);
    }

    public void u0(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/intro/update").a("roomId", str).a("intro", str2).b(), wi0Var);
    }

    public void v(String str, String str2, wi0<BaseResponse<CircleCateItem>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/cate/create").a("roomId", str).a("cateName", str2).b(), wi0Var);
    }

    public void v0(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v3/name/update").a("roomId", str).a("name", str2).b(), wi0Var);
    }

    public void w(String str, String str2, wi0<BaseResponse<Boolean>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tag/delete").a("roomId", str).a("tagId", str2).b(), wi0Var);
    }

    public void w0(String str, String str2, String str3, String str4, String str5, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/place/update").a("roomId", str).a("place", str2).a("coorType", str3).a("longitude", str4).a("latitude", str5).b(), wi0Var);
    }

    public void x(String str, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tool/delToolConf").a("id", str).b(), wi0Var);
    }

    public void x0(String str, String str2, String str3, String str4, String str5, String str6, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/place/update").a("roomId", str).a("place", str2).a("coorType", str4).a("longitude", str5).a("latitude", str6).a("placeName", str3).b(), wi0Var);
    }

    public void y(wi0<BaseResponse<ArrayList<ExpandFirstLevelData>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/cate/list").a("cateStyle", 1).b(), wi0Var);
    }

    public void y0(String str, String str2, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/remark/update").a("roomId", str).a("roomRemark", str2).b(), wi0Var);
    }

    public void z(String str, wi0<BaseResponse<ArrayList<CircleTagItem>>> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/tag/list").a("roomId", str).b(), wi0Var);
    }

    public void z0(String str, String str2, List<String> list, wi0<BaseResponse> wi0Var) {
        this.c.a(rj2.f20490a, new pw4.a().c("/room/v5/welcome/set").a("roomId", str).a("welContent", str2).a("welImgList", list).b(), wi0Var);
    }
}
