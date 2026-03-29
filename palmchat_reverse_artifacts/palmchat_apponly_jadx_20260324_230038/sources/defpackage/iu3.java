package defpackage;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.constants.ErrorCode;
import com.zenmen.find.ConditionHelper;
import com.zenmen.listui.list.BaseRecyclerView;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$string;
import com.zenmen.square.fragment.NearByFragment;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.ro2;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class iu3 extends zi5<NearByFragment, gu3, NearByBean> implements km2<NearByBean> {
    public Set<NearByBean> g;
    public boolean h;
    public Runnable i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f18265a;
        public final /* synthetic */ NearByBean b;

        public a(FrameworkBaseActivity frameworkBaseActivity, NearByBean nearByBean) {
            this.f18265a = frameworkBaseActivity;
            this.b = nearByBean;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            FrameworkBaseActivity frameworkBaseActivity = this.f18265a;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.hideBaseProgressBar();
            }
            if (contactInfoItem != null) {
                iu3 iu3Var = iu3.this;
                NearByBean nearByBean = this.b;
                iu3Var.E(contactInfoItem, nearByBean.imprId, nearByBean);
            }
        }

        @Override // ro2.b
        public void onError(String str) {
            FrameworkBaseActivity frameworkBaseActivity = this.f18265a;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.hideBaseProgressBar();
            }
            Application applicationB = c.b();
            if (applicationB != null) {
                sy5.f(applicationB, applicationB.getString(R$string.get_user_info_failed), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            iu3.this.M();
        }
    }

    public iu3(NearByFragment nearByFragment, gu3 gu3Var) {
        super(nearByFragment, gu3Var);
        this.g = new HashSet();
        this.h = false;
        this.i = new b();
        gu3Var.U(this);
    }

    public void A(NearByBean nearByBean) {
        RecyclerView.Adapter adapter;
        List<NearByBean> listE = ((gu3) this.b).e();
        if (listE != null) {
            listE.remove(nearByBean);
            BaseRecyclerView baseRecyclerView = this.d;
            if (baseRecyclerView == null || (adapter = baseRecyclerView.getAdapter()) == null) {
                return;
            }
            adapter.notifyDataSetChanged();
        }
    }

    public void B(ContactInfoItem contactInfoItem, NearByBean nearByBean) {
        if (contactInfoItem != null) {
            E(contactInfoItem, nearByBean.imprId, nearByBean);
            return;
        }
        FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) ((NearByFragment) this.f11844a).getActivity();
        if (frameworkBaseActivity != null) {
            frameworkBaseActivity.showBaseProgressBar("", false);
        }
        bj5.b().a().q(nearByBean.exid, new a(frameworkBaseActivity, nearByBean));
    }

    public void C() {
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            z66.f(contactInfoItemF.getUid(), contactInfoItemF.getExid(), contactInfoItemF.getGender(), 0, 0, 0, ((NearByFragment) this.f11844a).getActivity());
        }
    }

    public void D() {
        ap3.q(((NearByFragment) this.f11844a).getActivity(), "3");
    }

    public final void E(ContactInfoItem contactInfoItem, String str, NearByBean nearByBean) {
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        if (nearByBean == null || !nearByBean.isSuperExpose()) {
            contactInfoItemM792clone.setSourceType(46);
            if (o() == 48) {
                contactInfoItemM792clone.setBizType(bj5.b().a().u(68));
            } else if (o() == 49) {
                contactInfoItemM792clone.setBizType(bj5.b().a().u(65));
            } else if (o() == 113) {
                contactInfoItemM792clone.setSourceType(60);
                contactInfoItemM792clone.setBizType(bj5.b().a().u(62));
            } else if (o() == 75) {
                contactInfoItemM792clone.setBizType(bj5.b().a().u(5016));
            }
        } else {
            contactInfoItemM792clone.setSourceType(60);
            contactInfoItemM792clone.setBizType(bj5.b().a().u(nearByBean.getChatBizType(2)));
        }
        if (nearByBean != null && nearByBean.userType == NearByBean.TAG_TYPE_FEED_SEPARATION) {
            contactInfoItemM792clone.setSourceType(60);
            contactInfoItemM792clone.setBizType(bj5.b().a().u(5033));
        }
        if (nearByBean != null && nearByBean.userType == NearByBean.TAG_TYPE_FEED_POLISH) {
            contactInfoItemM792clone.setSourceType(60);
            contactInfoItemM792clone.setBizType(bj5.b().a().u(ErrorCode.BIDDING_C2S_TIMEOUT));
        }
        if (nearByBean != null && nearByBean.isAiChat()) {
            contactInfoItemM792clone.setSourceType(60);
            int iU = bj5.b().a().u(ErrorCode.DOWNLOADED_NOT_INSTALL_APK_NOT_EXITS);
            if (o() == 48) {
                iU = bj5.b().a().u(5065);
            } else if (o() == 49) {
                iU = bj5.b().a().u(5066);
            }
            LogUtil.d("", "AIP从找朋友直接打招呼 aiBizType " + iU);
            contactInfoItemM792clone.setBizType(iU);
        }
        if (contactInfoItemM792clone.getIsStranger()) {
            bj5.b().a().r(((NearByFragment) this.f11844a).getActivity(), contactInfoItemM792clone, str);
        } else {
            bj5.b().a().B(((NearByFragment) this.f11844a).getActivity(), contactInfoItemM792clone, "");
        }
        this.h = true;
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void c(int i, NearByBean nearByBean) {
        t(i, nearByBean);
    }

    public void G(int i, NearByBean nearByBean) {
        NearByBean.Ext ext;
        if (nearByBean.userType == 11 && (ext = nearByBean.ext) != null && ext.isValid()) {
            bj5.b().a().H(((NearByFragment) this.f11844a).getActivity(), nearByBean.ext.toJSON(), o());
        } else {
            z66.e(nearByBean.exid, nearByBean.gender, ((NearByFragment) this.f11844a).W(), o(), -1L, nearByBean.imprId, null, nearByBean);
        }
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public void b(int i, NearByBean nearByBean) {
        ((NearByFragment) this.f11844a).m0(i);
        N();
    }

    @Override // defpackage.km2
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void e(int i, NearByBean nearByBean) {
        ((NearByFragment) this.f11844a).L0(i, nearByBean);
        N();
    }

    public void J() {
        int i;
        int i2;
        M m = this.b;
        if (m != 0) {
            int i3 = 25;
            int i4 = 49;
            if (((gu3) m).R()) {
                if (o() != 48 && o() == 49) {
                    i = 25;
                    i2 = 49;
                } else {
                    i = 22;
                    i2 = 48;
                }
                bj5.b().a().I(((NearByFragment) this.f11844a).getActivity(), i, i2, -1, -1L);
                return;
            }
            if (!((gu3) this.b).L()) {
                sy5.f(((NearByFragment) this.f11844a).W(), "该功能内测中，敬请期待", 0).g();
                return;
            }
            if (o() == 48 || o() != 49) {
                i3 = 22;
                i4 = 48;
            }
            bj5.b().a().V(((NearByFragment) this.f11844a).getActivity(), i3, i4);
        }
    }

    public void K() {
        ConditionHelper.openFilterDialog(o(), (FrameworkBaseActivity) ((NearByFragment) this.f11844a).getActivity());
    }

    public void L() {
        zn6.b("pagelffriend_mapfindercard");
        ap3.a().a0((FrameworkBaseActivity) ((NearByFragment) this.f11844a).getActivity(), "zenxin://activity?page=a0406&openMap=true&subTabName=userrecommend");
    }

    public final void M() {
        BaseRecyclerView baseRecyclerViewMo794e;
        V v = this.f11844a;
        if (v != 0 && (baseRecyclerViewMo794e = ((NearByFragment) v).e()) != null && this.g.size() > 0 && baseRecyclerViewMo794e.getScrollState() == 0) {
            qj5.P(((NearByFragment) this.f11844a).getSid(), this.g);
            this.g.clear();
        }
    }

    public void N() {
        M m = this.b;
        if (m == 0 || ((gu3) m).e() == null) {
            return;
        }
        if (((gu3) this.b).e().size() > 0) {
            w(new PageState(PageState.State.NORMAL, null));
        } else {
            w(new PageState(PageState.State.EMPTY, null));
        }
    }

    @Override // com.zenmen.listui.list.a, defpackage.j74
    public void a(@NonNull xu4 xu4Var) {
        super.a(xu4Var);
        ds0.a().b(new xn5(1));
    }

    @Override // defpackage.km2
    public void d(String str) {
        ((NearByFragment) this.f11844a).n0(str);
    }

    @Override // defpackage.km2
    public void g(List<NearByBean> list) {
        ((NearByFragment) this.f11844a).l0(list);
    }

    @Override // defpackage.zi5, com.zenmen.listui.list.a
    public void k() {
        List<NearByBean> listE = ((gu3) this.b).e();
        if (listE != null) {
            if (listE.size() <= 1 || TextUtils.isEmpty(listE.get(listE.size() - 1).bottomTips)) {
                this.e = true;
                this.c.setEnableLoadMore(true);
            } else {
                this.e = false;
                this.c.setEnableLoadMore(false);
            }
        }
    }

    @Override // com.zenmen.listui.list.a, defpackage.lm2
    public void onResume() {
        super.onResume();
        if (this.h) {
            this.h = false;
        }
    }

    @Override // com.zenmen.listui.list.a
    public void u(int i) {
        super.u(i);
        M();
    }

    @Override // com.zenmen.listui.list.a
    public void w(PageState pageState) {
        super.w(pageState);
        ((NearByFragment) this.f11844a).p0(pageState);
    }

    public void z(NearByBean nearByBean) {
        super.i(nearByBean);
        this.g.add(nearByBean);
        ((NearByFragment) this.f11844a).e().removeCallbacks(this.i);
        ((NearByFragment) this.f11844a).e().postDelayed(this.i, 1000L);
    }
}
