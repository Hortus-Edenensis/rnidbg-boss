package defpackage;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.PageState;
import com.zenmen.listui.list.SquareLoadFooter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.R$string;
import com.zenmen.square.activity.SquareDetailHalfActivity;
import com.zenmen.square.fragment.FeedsFragment;
import com.zenmen.square.mvp.model.bean.DislikeResp;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import defpackage.bi5;
import defpackage.qj5;
import defpackage.ro2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zt1 extends zi5<FeedsFragment, yt1, SquareFeed> implements km2<SquareFeed> {
    public Map<Long, qj5.b> g;
    public boolean h;
    public Runnable i;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22507a;
        public final /* synthetic */ SquareFeed b;

        public a(int i, SquareFeed squareFeed) {
            this.f22507a = i;
            this.b = squareFeed;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            zt1.super.s(this.f22507a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements bi5.b<BaseNetBean<DislikeResp>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f22508a;

        public b(SquareFeed squareFeed) {
            this.f22508a = squareFeed;
        }

        @Override // bi5.b
        public void a(BaseNetBean<DislikeResp> baseNetBean) {
            if (baseNetBean != null) {
                if (!baseNetBean.isSuccess()) {
                    zt1.this.d(baseNetBean.getErrMsg());
                    return;
                }
                SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                squareFeedEvent.feed = this.f22508a;
                squareFeedEvent.eventType = 3;
                an1.c().l(squareFeedEvent);
                zt1.this.d(baseNetBean.data.toast);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zt1.this.U();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f22510a;
        public final /* synthetic */ SquareFeed b;

        public d(FrameworkBaseActivity frameworkBaseActivity, SquareFeed squareFeed) {
            this.f22510a = frameworkBaseActivity;
            this.b = squareFeed;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            FrameworkBaseActivity frameworkBaseActivity = this.f22510a;
            if (frameworkBaseActivity == null || frameworkBaseActivity.isFinishing()) {
                return;
            }
            this.f22510a.hideBaseProgressBar();
            if (contactInfoItem != null) {
                zt1.this.H(contactInfoItem, this.b);
            }
        }

        @Override // ro2.b
        public void onError(String str) {
            FrameworkBaseActivity frameworkBaseActivity = this.f22510a;
            if (frameworkBaseActivity == null || frameworkBaseActivity.isFinishing()) {
                return;
            }
            this.f22510a.hideBaseProgressBar();
            sy5.e(this.f22510a, R$string.get_user_info_failed, 0).g();
        }
    }

    public zt1(FeedsFragment feedsFragment, yt1 yt1Var) {
        super(feedsFragment, yt1Var);
        this.g = new HashMap();
        this.h = true;
        this.i = new c();
        yt1Var.R(this);
    }

    public void A(SquareFeed squareFeed) {
        ((yt1) this.b).A(squareFeed.id);
        qj5.a0(((FeedsFragment) this.f11844a).getSid(), ((FeedsFragment) this.f11844a).o(), squareFeed);
        if (this.g.containsKey(Long.valueOf(squareFeed.id))) {
            return;
        }
        qj5.b bVar = new qj5.b();
        bVar.f20265a = squareFeed;
        bVar.b = System.currentTimeMillis();
        bVar.c = ((FeedsFragment) this.f11844a).getSid();
        this.g.put(Long.valueOf(squareFeed.id), bVar);
        ((FeedsFragment) this.f11844a).mo794e().removeCallbacks(this.i);
        ((FeedsFragment) this.f11844a).mo794e().postDelayed(this.i, 50L);
    }

    public void B(int i, SquareFeed squareFeed, int i2) {
        ((yt1) this.b).D(i, squareFeed, i2, new b(squareFeed));
    }

    public void C(int i, SquareFeed squareFeed) {
        bj5.b().a().z(((FeedsFragment) this.f11844a).W(), 901, squareFeed.exid, 8, 7);
    }

    public void D(SquareFeed squareFeed) {
        NestTopicFeedsActivity.G1(((FeedsFragment) this.f11844a).W(), squareFeed.topicId, o());
    }

    public final boolean E() {
        return o() == 6 || o() == 7;
    }

    public void F(ContactInfoItem contactInfoItem, SquareFeed squareFeed) {
        if (contactInfoItem != null) {
            H(contactInfoItem, squareFeed);
            return;
        }
        FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) ((FeedsFragment) this.f11844a).getActivity();
        if (frameworkBaseActivity != null) {
            frameworkBaseActivity.showBaseProgressBar("", false);
        }
        bj5.b().a().q(squareFeed.exid, new d(frameworkBaseActivity, squareFeed));
    }

    public void G() {
        ap3.q(((FeedsFragment) this.f11844a).getActivity(), "6");
    }

    public final void H(ContactInfoItem contactInfoItem, SquareFeed squareFeed) {
        String strC = squareFeed != null ? az2.c(SquareFeedForChatCard.parse(squareFeed)) : "";
        if (squareFeed.superShowType != 0) {
            contactInfoItem.setBizType(bj5.b().a().l());
            contactInfoItem.setSourceType(90);
        }
        if (contactInfoItem.getIsStranger()) {
            bj5.b().a().r(((FeedsFragment) this.f11844a).getActivity(), contactInfoItem, strC);
        } else {
            bj5.b().a().B(((FeedsFragment) this.f11844a).getActivity(), contactInfoItem, strC);
        }
        if (o() == 1 || o() == 73 || (o() == 74 && contactInfoItem.getIsStranger())) {
            gi5.b = System.currentTimeMillis();
            SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, k86.a("key_square_sayhi_time"), Long.valueOf(gi5.b));
        }
    }

    public void I() {
        M m = this.b;
        if (m != 0) {
            ((yt1) m).N();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void J(SquareFeed squareFeed) {
        if (!squareFeed.liveFlag) {
            if (squareFeed.superShowType != 0) {
                z66.c(90, squareFeed.id, squareFeed.uid, squareFeed.exid, squareFeed, ((FeedsFragment) this.f11844a).W());
                return;
            } else {
                z66.c(((FeedsFragment) this.f11844a).o(), squareFeed.id, squareFeed.uid, squareFeed.exid, squareFeed, ((FeedsFragment) this.f11844a).W());
                return;
            }
        }
        HashMap map = new HashMap();
        map.put("channelId", squareFeed.channelId);
        map.put("sceneId", squareFeed.sceneId);
        map.put("channelType", Integer.valueOf(squareFeed.channelType));
        bj5.b().a().H(((FeedsFragment) p()).getActivity(), new JSONObject(map), 57);
        qj5.c(((FeedsFragment) this.f11844a).o(), squareFeed.id, squareFeed.exid, squareFeed.imprId, squareFeed);
    }

    public void K(int i, SquareFeed squareFeed) {
        ((FeedsFragment) this.f11844a).K0(i, squareFeed);
    }

    public void L(SquareFeed squareFeed) {
        if (squareFeed.feedType != 1) {
            Q(squareFeed, null);
        } else {
            qj5.u(((FeedsFragment) this.f11844a).o(), squareFeed);
            SquareDetailHalfActivity.C1(((FeedsFragment) this.f11844a).getActivity(), o(), squareFeed, new Bundle());
        }
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void c(int i, SquareFeed squareFeed) {
        t(i, squareFeed);
    }

    public void N(int i, SquareFeed squareFeed) {
        new sd3(((FeedsFragment) this.f11844a).W()).U("提示").k("确定删除吗？").N(R$color.gen_dialogPositiveColor).L("取消").P("删除").f(new a(i, squareFeed)).e().show();
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void b(int i, SquareFeed squareFeed) {
        ((FeedsFragment) this.f11844a).m0(i);
        V();
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void e(int i, SquareFeed squareFeed) {
        ((FeedsFragment) this.f11844a).j0(i, squareFeed);
        V();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Q(SquareFeed squareFeed, View view) {
        qj5.u(((FeedsFragment) this.f11844a).o(), squareFeed);
        int i = squareFeed.feedType;
        int i2 = 0;
        if (i == 8) {
            if (!squareFeed.liveFlag) {
                if (((FeedsFragment) this.f11844a).getActivity() instanceof FrameworkBaseActivity) {
                    bj5.b().a().c((FrameworkBaseActivity) ((FeedsFragment) this.f11844a).getActivity(), "zenxin://activity?page=a0460", false);
                    return;
                }
                return;
            } else {
                HashMap map = new HashMap();
                map.put("channelId", squareFeed.channelId);
                map.put("sceneId", squareFeed.sceneId);
                map.put("channelType", Integer.valueOf(squareFeed.channelType));
                bj5.b().a().H(((FeedsFragment) p()).getActivity(), new JSONObject(map), 56);
                return;
            }
        }
        if (i == 1) {
            SquareDetailHalfActivity.C1(((FeedsFragment) this.f11844a).getActivity(), o(), squareFeed, new Bundle());
            return;
        }
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        if (o() == 5 || (o() == 74 && squareFeed.ifFriend)) {
            int i3 = 0;
            for (SquareFeed squareFeed2 : ((yt1) this.b).e()) {
                int i4 = squareFeed2.feedType;
                if (i4 == 2 || i4 == 3) {
                    arrayList.add(squareFeed2);
                    if (squareFeed2.id == squareFeed.id) {
                        i3 = i2;
                    }
                    i2++;
                }
                if (10000 == squareFeed2.feedType) {
                    break;
                }
            }
            bundle.putInt("key_target_position", i3);
        } else {
            arrayList.add(squareFeed);
        }
        MediaViewActivity.C1(o(), arrayList, this.f11844a.getActivity(), bundle);
    }

    public void R(int i, SquareFeed squareFeed) {
        if (squareFeed == null) {
            return;
        }
        qj5.k0(squareFeed, ((FeedsFragment) this.f11844a).o());
        F(dn0.b(squareFeed.exid), squareFeed);
    }

    public void S(int i, SquareFeed squareFeed) {
        qj5.L(squareFeed, ((FeedsFragment) this.f11844a).o());
        qj5.N(squareFeed, ((FeedsFragment) this.f11844a).o());
        ((FeedsFragment) this.f11844a).M0(i, squareFeed);
    }

    public void T(int i, SquareFeed squareFeed, int i2) {
        ((yt1) this.b).P(i, squareFeed, i2);
    }

    public final void U() {
        if (this.h) {
            qj5.b0(((FeedsFragment) this.f11844a).o(), this.g.values());
            this.g.clear();
        }
    }

    public void V() {
        M m = this.b;
        if (m == 0 || ((yt1) m).e() == null) {
            return;
        }
        if (((yt1) this.b).e().size() > 0) {
            w(new PageState(PageState.State.NORMAL, null));
        } else {
            w(new PageState(PageState.State.EMPTY, null));
        }
    }

    @Override // defpackage.km2
    public void d(String str) {
        ((FeedsFragment) this.f11844a).n0(str);
    }

    @Override // defpackage.km2
    public void g(List<SquareFeed> list) {
        ((FeedsFragment) this.f11844a).l0(list);
    }

    @Override // defpackage.zi5, com.zenmen.listui.list.a
    public void k() {
        List<SquareFeed> listE = ((yt1) this.b).e();
        if (listE != null) {
            SquareLoadFooter squareLoadFooter = (SquareLoadFooter) this.c.getRefreshFooter();
            if (listE.size() <= 1 || TextUtils.isEmpty(listE.get(listE.size() - 1).bottomTips)) {
                if (!E()) {
                    this.c.setEnableLoadMore(true);
                    return;
                } else {
                    squareLoadFooter.setTitleColor(Color.parseColor("#666666"));
                    this.c.setNoMoreData(false);
                    return;
                }
            }
            if (!E()) {
                this.c.setEnableLoadMore(false);
            } else {
                squareLoadFooter.setTitleColor(Color.parseColor("#CACFCE"));
                this.c.finishLoadMoreWithNoMoreData();
            }
        }
    }

    @Override // com.zenmen.listui.list.a
    public int o() {
        V v = this.f11844a;
        if (v != 0) {
            return ((FeedsFragment) v).o();
        }
        return 0;
    }

    @Override // com.zenmen.listui.list.a
    public void u(int i) {
        this.h = i == 0;
        U();
    }

    @Override // com.zenmen.listui.list.a
    public void w(PageState pageState) {
        ((FeedsFragment) this.f11844a).p0(pageState);
    }
}
