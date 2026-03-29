package com.zenmen.palmchat.mine.track;

import android.app.Application;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.MaskFilterSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.huawei.hms.ads.gh;
import com.qq.e.comm.constants.ErrorCode;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.databinding.FragmentTrackCommonBinding;
import com.zenmen.palmchat.databinding.UserTrackFooterViewBinding;
import com.zenmen.palmchat.databinding.UserTrackRecycleviewItemBinding;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.mine.track.UserTrackBean;
import com.zenmen.palmchat.square.SMultRecycleAdapter;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.square.ui.widget.ListStateView;
import com.zenmen.square.ui.widget.SquarePullHeader;
import defpackage.a46;
import defpackage.ap3;
import defpackage.b05;
import defpackage.bj5;
import defpackage.c74;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.fg6;
import defpackage.iv0;
import defpackage.j74;
import defpackage.lb3;
import defpackage.me1;
import defpackage.q05;
import defpackage.qm5;
import defpackage.ro2;
import defpackage.sy5;
import defpackage.wz5;
import defpackage.xu4;
import defpackage.z66;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TrackUserFragment extends BaseFragment {
    public int f;
    public FragmentTrackCommonBinding g;
    public boolean h = false;
    public View.OnClickListener i = new e();
    public SMultRecycleAdapter j = new f();
    public HashSet<String> k = new HashSet<>();
    public int l = 0;
    public boolean m = false;

    /* JADX INFO: compiled from: SearchBox */
    public class StickyItemDecoration extends RecyclerView.ItemDecoration {
        public final Paint b;
        public final Paint c;
        public final int d;
        public final Context e;
        public final List<Object> f;

        public StickyItemDecoration(Context context, List<Object> list) {
            this.e = context;
            this.f = list;
            this.d = me1.b(context, 36);
            Paint paint = new Paint();
            this.b = paint;
            paint.setColor(-1);
            Paint paint2 = new Paint(1);
            this.c = paint2;
            paint2.setColor(-14540254);
            paint2.setTextSize(me1.b(context, 17));
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, String str, int i) {
            canvas.drawRect(0.0f, i, recyclerView.getWidth(), this.d + i, this.b);
            canvas.drawText(str, me1.b(this.e, 16), ((i + this.d) - me1.b(this.e, 2)) - this.c.getFontMetrics().bottom, this.c);
        }

        public final boolean b(int i) {
            return this.f.get(i) instanceof String;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            String strW;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == -1 || b(childAdapterPosition)) {
                rect.top = 0;
                return;
            }
            String strW2 = TrackUserFragment.this.W(((UserTrackBean.UserTrackBeanList) this.f.get(childAdapterPosition)).getOptTime().longValue());
            if (childAdapterPosition > 0) {
                int i = childAdapterPosition - 1;
                strW = !b(i) ? TrackUserFragment.this.W(((UserTrackBean.UserTrackBeanList) this.f.get(i)).getOptTime().longValue()) : "";
            }
            if (strW2.equals(strW)) {
                rect.top = 0;
            } else {
                rect.top = this.d;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v0, types: [com.zenmen.palmchat.mine.track.TrackUserFragment$StickyItemDecoration] */
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childCount = recyclerView.getChildCount();
            ?? r0 = 0;
            int i = 0;
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1 && !b(childAdapterPosition)) {
                    ?? W = TrackUserFragment.this.W(((UserTrackBean.UserTrackBeanList) this.f.get(childAdapterPosition)).getOptTime().longValue());
                    if (!W.equals(r0)) {
                        a(canvas, recyclerView, W, Math.max(childAt.getTop() - this.d, 0));
                        r0 = W;
                    }
                }
                i++;
                r0 = r0;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition;
            int i;
            if (recyclerView.getChildCount() == 0 || this.f.size() == 0 || (childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0))) == -1 || b(childAdapterPosition)) {
                return;
            }
            String strW = TrackUserFragment.this.W(((UserTrackBean.UserTrackBeanList) this.f.get(childAdapterPosition)).getOptTime().longValue());
            int i2 = 1;
            while (true) {
                if (i2 >= recyclerView.getChildCount()) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i2);
                int childAdapterPosition2 = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition2 == -1 || b(childAdapterPosition2) || strW.equals(TrackUserFragment.this.W(((UserTrackBean.UserTrackBeanList) this.f.get(childAdapterPosition2)).getOptTime().longValue()))) {
                    i2++;
                } else {
                    int top = childAt.getTop();
                    int i3 = this.d;
                    i = top <= i3 * 2 ? (int) ((((i3 * 2) - top) * i3) / i3) : 0;
                }
            }
            int iMax = Math.max(Math.min(i, this.d), 0);
            canvas.save();
            canvas.translate(0.0f, -iMax);
            a(canvas, recyclerView, strW, 0);
            canvas.restore();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserTrackBean.UserTrackBeanList f14737a;

        public a(UserTrackBean.UserTrackBeanList userTrackBeanList) {
            this.f14737a = userTrackBeanList;
            put("tab", 1);
            put("subtab", Integer.valueOf(TrackUserFragment.this.f + 1));
            put("tuid", userTrackBeanList.getUid());
            put("page", Integer.valueOf(userTrackBeanList.getPage()));
            put(EventParams.KEY_CT_SDK_POSITION, Integer.valueOf(userTrackBeanList.getPosition()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements q05.d<LXBaseNetBean<UserTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14738a;
        public final /* synthetic */ xu4 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Long d;

        public b(boolean z, xu4 xu4Var, int i, Long l) {
            this.f14738a = z;
            this.b = xu4Var;
            this.c = i;
            this.d = l;
        }

        @Override // q05.d
        public void a(Exception exc) {
            TrackUserFragment trackUserFragment = TrackUserFragment.this;
            if (!trackUserFragment.m) {
                trackUserFragment.m = true;
            }
            if (this.f14738a) {
                this.b.finishLoadMore(false);
                return;
            }
            trackUserFragment.l0(new PageState(PageState.State.ERROR, null));
            TrackUserFragment.this.g.e.setVisibility(8);
            this.b.finishRefresh(false);
        }

        @Override // q05.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(LXBaseNetBean<UserTrackBean> lXBaseNetBean) {
            UserTrackBean userTrackBean;
            UserTrackBean userTrackBean2;
            UserTrackBean userTrackBean3;
            UserTrackBean userTrackBean4;
            if (q05.o(TrackUserFragment.this.getActivity())) {
                return;
            }
            TrackUserFragment trackUserFragment = TrackUserFragment.this;
            if (!trackUserFragment.m) {
                trackUserFragment.m = true;
            }
            if (!this.f14738a) {
                trackUserFragment.j.b().clear();
                this.b.finishRefresh();
            } else if (lXBaseNetBean == null || (userTrackBean = lXBaseNetBean.data) == null || userTrackBean.getResultList() == null || !lXBaseNetBean.data.getResultList().isEmpty()) {
                this.b.finishLoadMore();
            } else {
                this.b.finishLoadMoreWithNoMoreData();
            }
            if (lXBaseNetBean != null && (userTrackBean4 = lXBaseNetBean.data) != null && userTrackBean4.getResultList() != null && lXBaseNetBean.data.getResultList().size() > 0) {
                TrackUserFragment.this.l = this.c;
                b05.a("当前是第===》" + TrackUserFragment.this.l + "页");
                if (TrackUserFragment.this.f != 0 && this.d.longValue() == 0) {
                    b05.d("设置可以滚动");
                    this.b.setEnableLoadMore(true);
                }
                int i = 0;
                while (i < lXBaseNetBean.data.getResultList().size()) {
                    lXBaseNetBean.data.getResultList().get(i).setPage(TrackUserFragment.this.l + 1);
                    UserTrackBean.UserTrackBeanList userTrackBeanList = lXBaseNetBean.data.getResultList().get(i);
                    i++;
                    userTrackBeanList.setPosition(i);
                }
                TrackUserFragment.this.j.b().addAll(lXBaseNetBean.data.getResultList());
            }
            if (!this.f14738a) {
                if (lXBaseNetBean == null || (userTrackBean3 = lXBaseNetBean.data) == null) {
                    TrackUserFragment.this.l0(new PageState(PageState.State.ERROR, null));
                    TrackUserFragment.this.g.e.setVisibility(8);
                } else if (userTrackBean3.getResultList() == null || lXBaseNetBean.data.getResultList().isEmpty()) {
                    TrackUserFragment.this.l0(new PageState(PageState.State.EMPTY, null));
                    TrackUserFragment.this.g.e.setVisibility(8);
                } else {
                    TrackUserFragment.this.l0(new PageState(PageState.State.NORMAL, null));
                    if (TrackUserFragment.this.k0()) {
                        TrackUserFragment.this.g.e.setVisibility(0);
                    } else {
                        TrackUserFragment.this.g.e.setVisibility(8);
                    }
                }
            }
            if (lXBaseNetBean != null && (userTrackBean2 = lXBaseNetBean.data) != null && ((userTrackBean2.getResultList() == null || lXBaseNetBean.data.getResultList().isEmpty()) && this.f14738a)) {
                for (int size = TrackUserFragment.this.j.b().size() - 1; size >= 0; size--) {
                    if (TrackUserFragment.this.j.b().get(size) instanceof String) {
                        TrackUserFragment.this.j.b().remove(size);
                    }
                }
                TrackUserFragment.this.j.b().add(lXBaseNetBean.data.getBottomTip());
            }
            if (TrackUserFragment.this.c0() && TrackUserFragment.this.j.b().size() > 0 && (TrackUserFragment.this.j.b().get(TrackUserFragment.this.j.b().size() - 1) instanceof UserTrackBean.UserTrackBeanList)) {
                for (int size2 = TrackUserFragment.this.j.b().size() - 1; size2 >= 0; size2--) {
                    if (TrackUserFragment.this.j.b().get(size2) instanceof String) {
                        TrackUserFragment.this.j.b().remove(size2);
                    }
                }
                TrackUserFragment.this.j.b().add(lXBaseNetBean.data.getBottomTip());
            }
            TrackUserFragment.this.j.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("tab", 1);
            put("subtab", Integer.valueOf(TrackUserFragment.this.f + 1));
            put("vague", Integer.valueOf(!TrackUserFragment.this.k0() ? 1 : 0));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ lb3 f14740a;

        public d(lb3 lb3Var) {
            this.f14740a = lb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            lb3 lb3Var;
            if (!TrackUserFragment.this.c0() || (lb3Var = this.f14740a) == null) {
                return;
            }
            int iB = lb3Var.b();
            if (iB == 1 || iB == 2) {
                TrackUserFragment trackUserFragment = TrackUserFragment.this;
                trackUserFragment.h = true;
                trackUserFragment.g.e.setVisibility(8);
                TrackUserFragment.this.j.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PageState.State state = TrackUserFragment.this.g.c.getState().f11843a;
            if (state == PageState.State.LOADING || state == PageState.State.EMPTY) {
                return;
            }
            TrackUserFragment.this.g.b.autoRefresh();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends SMultRecycleAdapter {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements SMultRecycleAdapter.a<SMultRecycleAdapter.ViewHolder> {
            public a() {
            }

            @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.a
            public SMultRecycleAdapter.ViewHolder a(ViewGroup viewGroup) {
                return TrackUserFragment.this.new o(UserTrackRecycleviewItemBinding.b(TrackUserFragment.this.getLayoutInflater(), viewGroup, false));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements SMultRecycleAdapter.a<SMultRecycleAdapter.ViewHolder> {
            public b() {
            }

            @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.a
            public SMultRecycleAdapter.ViewHolder a(ViewGroup viewGroup) {
                return TrackUserFragment.this.new n(UserTrackFooterViewBinding.b(TrackUserFragment.this.getLayoutInflater(), viewGroup, false));
            }
        }

        public f() {
            a(UserTrackBean.UserTrackBeanList.class, new a());
            a(String.class, new b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements j74 {
        public g() {
        }

        @Override // defpackage.j74
        public void a(@NonNull xu4 xu4Var) {
            TrackUserFragment.this.h0(false, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements c74 {
        public h() {
        }

        @Override // defpackage.c74
        public void onLoadMore(@NonNull xu4 xu4Var) {
            TrackUserFragment.this.h0(true, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            ap3.x(TrackUserFragment.this.getContext(), gh.Code);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends RecyclerView.OnScrollListener {
        public j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            b05.a("mRecycleview===》滑动的时候");
            TrackUserFragment.this.j0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b05.a("mRecycleview===》加载完成的时候");
            TrackUserFragment.this.j0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnLayoutChangeListener {
        public m() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (TrackUserFragment.this.g.e.getVisibility() != 0) {
                TrackUserFragment.this.g.f13898a.setPadding(0, 0, 0, 0);
                return;
            }
            FragmentTrackCommonBinding fragmentTrackCommonBinding = TrackUserFragment.this.g;
            fragmentTrackCommonBinding.f13898a.setPadding(0, 0, 0, fragmentTrackCommonBinding.e.getHeight());
            TrackUserFragment.this.g.f13898a.setClipToPadding(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends SMultRecycleAdapter.ViewHolder<String> {
        public UserTrackFooterViewBinding d;

        public n(UserTrackFooterViewBinding userTrackFooterViewBinding) {
            super(userTrackFooterViewBinding.getRoot());
            this.d = userTrackFooterViewBinding;
        }

        @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.ViewHolder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void l(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                this.d.f13916a.setText("");
            } else {
                this.d.f13916a.setText(str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends SMultRecycleAdapter.ViewHolder<UserTrackBean.UserTrackBeanList> {
        public UserTrackRecycleviewItemBinding d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UserTrackBean.UserTrackBeanList f14751a;

            /* JADX INFO: renamed from: com.zenmen.palmchat.mine.track.TrackUserFragment$o$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1079a extends HashMap<String, Object> {
                public C1079a() {
                    put("subtab", Integer.valueOf(TrackUserFragment.this.f + 1));
                    put("tuid", a.this.f14751a.getUid());
                    put("page", Integer.valueOf(a.this.f14751a.getPage()));
                    put(EventParams.KEY_CT_SDK_POSITION, Integer.valueOf(a.this.f14751a.getPosition()));
                }
            }

            public a(UserTrackBean.UserTrackBeanList userTrackBeanList) {
                this.f14751a = userTrackBeanList;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                int i;
                int i2;
                if (q05.p()) {
                    return;
                }
                if (TrackUserFragment.this.k0()) {
                    ap3.x(TrackUserFragment.this.getContext(), gh.Code);
                    return;
                }
                q05.a("pagefootprint_userclick", 0, new C1079a());
                if (TrackUserFragment.this.f != 0) {
                    if (TrackUserFragment.this.f == 1) {
                        i = 5046;
                        i2 = 107;
                    } else if (TrackUserFragment.this.f == 2) {
                        i = ErrorCode.SPLASH_PRELOAD_NOT_MATCH_NO_AD;
                        i2 = 108;
                    } else {
                        i = ErrorCode.DOWNLOADED_NOT_INSTALL_APK;
                        i2 = 106;
                    }
                }
                z66.f(this.f14751a.getUid().toString(), null, this.f14751a.getGender().intValue(), 60, i, i2, TrackUserFragment.this.getActivity());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UserTrackBean.UserTrackBeanList f14753a;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {
                public a() {
                    put("subtab", Integer.valueOf(TrackUserFragment.this.f + 1));
                    put("tuid", b.this.f14753a.getUid());
                    put("page", Integer.valueOf(b.this.f14753a.getPage()));
                    put(EventParams.KEY_CT_SDK_POSITION, Integer.valueOf(b.this.f14753a.getPosition()));
                }
            }

            /* JADX INFO: renamed from: com.zenmen.palmchat.mine.track.TrackUserFragment$o$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1080b implements ro2.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FrameworkBaseActivity f14755a;

                public C1080b(FrameworkBaseActivity frameworkBaseActivity) {
                    this.f14755a = frameworkBaseActivity;
                }

                @Override // ro2.b
                public void a(ContactInfoItem contactInfoItem) {
                    FrameworkBaseActivity frameworkBaseActivity = this.f14755a;
                    if (frameworkBaseActivity != null) {
                        frameworkBaseActivity.hideBaseProgressBar();
                    }
                    if (contactInfoItem != null) {
                        TrackUserFragment.this.e0(contactInfoItem);
                    }
                }

                @Override // ro2.b
                public void onError(String str) {
                    FrameworkBaseActivity frameworkBaseActivity = this.f14755a;
                    if (frameworkBaseActivity != null) {
                        frameworkBaseActivity.hideBaseProgressBar();
                    }
                    Application applicationB = com.zenmen.palmchat.c.b();
                    if (applicationB != null) {
                        sy5.f(applicationB, applicationB.getString(R.string.get_user_info_failed), 0).g();
                    }
                }
            }

            public b(UserTrackBean.UserTrackBeanList userTrackBeanList) {
                this.f14753a = userTrackBeanList;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q05.p()) {
                    return;
                }
                if (TrackUserFragment.this.k0()) {
                    ap3.x(TrackUserFragment.this.getContext(), gh.Code);
                    return;
                }
                q05.a("pagefootprint_chatclick", 0, new a());
                FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) TrackUserFragment.this.getActivity();
                if (frameworkBaseActivity != null) {
                    frameworkBaseActivity.showBaseProgressBar("", false);
                }
                bj5.b().a().J(this.f14753a.getUid().toString(), new C1080b(frameworkBaseActivity));
            }
        }

        public o(UserTrackRecycleviewItemBinding userTrackRecycleviewItemBinding) {
            super(userTrackRecycleviewItemBinding.getRoot());
            this.d = userTrackRecycleviewItemBinding;
        }

        @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.ViewHolder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void l(UserTrackBean.UserTrackBeanList userTrackBeanList, int i) {
            this.d.c.setAvatarView(userTrackBeanList.getAvatar(), 0, R.drawable.default_portrait_new, null, null, TrackUserFragment.this.k0());
            String nickname = !TextUtils.isEmpty(userTrackBeanList.getNickname()) ? userTrackBeanList.getNickname() : "";
            if (userTrackBeanList.getGender() == null || userTrackBeanList.getGender().intValue() != 1) {
                this.d.f.setImageResource(R.drawable.icon_sex_male);
            } else {
                this.d.f.setImageResource(R.drawable.icon_sex_female);
            }
            ContactInfoItem contactInfoItemA = dn0.a(userTrackBeanList.getUid().toString());
            if (contactInfoItemA == null || contactInfoItemA.getIsStranger()) {
                this.d.f13917a.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_say_hi_left_new1, 0, 0, 0);
                this.d.f13917a.setText("打招呼");
            } else {
                this.d.f13917a.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_say_hi_left_new2, 0, 0, 0);
                this.d.f13917a.setText("发消息");
            }
            if (TextUtils.isEmpty(userTrackBeanList.getDesc())) {
                this.d.g.setText("");
            } else {
                this.d.g.setText(userTrackBeanList.getDesc());
            }
            this.d.e.setOnClickListener(new a(userTrackBeanList));
            this.d.f13917a.setOnClickListener(new b(userTrackBeanList));
            if (!TrackUserFragment.this.k0()) {
                this.d.d.setText(nickname);
                return;
            }
            this.d.d.setLayerType(1, null);
            SpannableString spannableString = new SpannableString(nickname);
            spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.NORMAL)), 0, spannableString.length(), 17);
            this.d.d.setText(spannableString);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        ViewPager viewPagerY;
        b05.a("onUserVisibleChange===>" + z + ",index==>" + this.f);
        if (!z || (viewPagerY = Y()) == null) {
            return;
        }
        int currentItem = viewPagerY.getCurrentItem();
        if (currentItem == this.f) {
            b05.a("正常加载数据");
            if (!this.m) {
                this.g.b.autoRefresh();
            }
            this.h = fg6.f(AppContext.getContext());
            q05.a("pagefootprint", 0, new c());
            return;
        }
        b05.a("忽略错误的可见性回调：当前页面=" + currentItem + "，Fragment索引=" + this.f);
    }

    public String W(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        int i2 = calendar.get(1);
        int i3 = calendar.get(6);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i4 = calendar.get(1);
        return (i2 == i4 && i3 == calendar.get(6)) ? "今天" : i2 == i4 ? iv0.a(j2, "M月d日") : iv0.a(j2, "yyyy年M月d日");
    }

    public final ViewPager Y() {
        if (getParentFragment() instanceof UserTrackFragment) {
            return ((UserTrackFragment) getParentFragment()).f.f13899a;
        }
        return null;
    }

    public final void Z() {
        this.g.c.setOnClickListener(this.i);
        this.g.c.setTopMargin(a46.b(getContext(), 80.0f));
        this.g.c.setImageSize(a46.b(getContext(), 180.0f), a46.b(getContext(), 143.0f));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.g.f13898a.setLayoutManager(linearLayoutManager);
        this.g.f13898a.setAdapter(this.j);
        this.g.f13898a.addItemDecoration(new StickyItemDecoration(getContext(), this.j.b()));
        if (c0()) {
            this.g.b.setEnableLoadMore(false);
        }
        this.g.b.setOnRefreshListener(new g());
        this.g.b.setOnLoadMoreListener(new h());
        this.g.b.setRefreshHeader(new SquarePullHeader(getContext()));
        this.g.b.setRefreshFooter(new SAppUtil.CustomClassicsFooter(getContext()));
        this.g.d.setOnClickListener(new i());
        int i2 = this.f;
        String str = i2 == 0 ? "暂未发现擦肩而过的人" : i2 == 1 ? "暂无浏览记录" : "";
        if (i2 == 2) {
            str = "暂无喜欢的人";
        }
        this.g.c.setEmptyString(str);
        this.g.f13898a.addOnScrollListener(new j());
        this.g.f13898a.post(new k());
        this.j.registerAdapterDataObserver(new l());
        this.g.e.addOnLayoutChangeListener(new m());
    }

    public boolean c0() {
        return this.f == 0;
    }

    public final void e0(ContactInfoItem contactInfoItem) {
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        contactInfoItemM792clone.setSourceType(60);
        int i2 = this.f;
        if (i2 == 0) {
            contactInfoItemM792clone.setBizType(ErrorCode.DOWNLOADED_NOT_INSTALL_APK);
        } else if (i2 == 1) {
            contactInfoItemM792clone.setBizType(5046);
        } else if (i2 == 2) {
            contactInfoItemM792clone.setBizType(ErrorCode.SPLASH_PRELOAD_NOT_MATCH_NO_AD);
        }
        if (contactInfoItemM792clone.getIsStranger()) {
            bj5.b().a().r(getActivity(), contactInfoItemM792clone, "");
        } else {
            bj5.b().a().B(getActivity(), contactInfoItemM792clone, "");
        }
    }

    public void h0(boolean z, xu4 xu4Var) {
        int i2;
        long jLongValue = 0;
        if (z) {
            SMultRecycleAdapter sMultRecycleAdapter = this.j;
            if (sMultRecycleAdapter != null && sMultRecycleAdapter.b().size() > 0) {
                if (this.j.b().get(this.j.b().size() - 1) instanceof UserTrackBean.UserTrackBeanList) {
                    jLongValue = ((UserTrackBean.UserTrackBeanList) this.j.b().get(this.j.b().size() - 1)).getVersion().longValue();
                } else if (this.j.b().size() > 1 && (this.j.b().get(this.j.b().size() - 2) instanceof UserTrackBean.UserTrackBeanList)) {
                    jLongValue = ((UserTrackBean.UserTrackBeanList) this.j.b().get(this.j.b().size() - 2)).getVersion().longValue();
                }
            }
            i2 = this.l + 1;
        } else {
            this.l = 0;
            i2 = 0;
        }
        wz5.i().g(this.f, Long.valueOf(jLongValue), new b(z, xu4Var, i2, Long.valueOf(jLongValue)));
    }

    public final void j0() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.g.f13898a.getLayoutManager();
        if (linearLayoutManager == null || this.j.b() == null) {
            return;
        }
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
            b05.a("初始化显示第" + iFindFirstVisibleItemPosition + "个");
            if (iFindFirstVisibleItemPosition < this.j.b().size() && iFindFirstVisibleItemPosition >= 0 && this.j.b().size() > 0 && (this.j.b().get(iFindFirstVisibleItemPosition) instanceof UserTrackBean.UserTrackBeanList)) {
                UserTrackBean.UserTrackBeanList userTrackBeanList = (UserTrackBean.UserTrackBeanList) this.j.b().get(iFindFirstVisibleItemPosition);
                String string = userTrackBeanList.getUid().toString();
                if (!this.k.contains(string)) {
                    this.k.add(string);
                    b05.a("上传数据:" + string);
                    q05.a("pagefootprint_content", 0, new a(userTrackBeanList));
                }
            }
        }
    }

    public boolean k0() {
        return c0() && !this.h && this.g.c.getVisibility() == 8;
    }

    public void l0(PageState pageState) {
        ListStateView listStateView = this.g.c;
        if (listStateView != null) {
            listStateView.setVisibility(0);
            this.g.c.setState(pageState, R.drawable.icon_track_net_error, R.drawable.icon_track_dynamic_empty);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments().getInt("ARG_PARAM_INDEX", 0);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentTrackCommonBinding fragmentTrackCommonBindingB = FragmentTrackCommonBinding.b(layoutInflater, viewGroup, false);
        this.g = fragmentTrackCommonBindingB;
        return fragmentTrackCommonBindingB.getRoot();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (c0()) {
            ds0.a().d(this);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (c0()) {
            ds0.a().c(this);
        }
        Z();
    }

    @qm5
    public void receivedVipCheckEvent(lb3 lb3Var) {
        if (q05.o(getActivity())) {
            return;
        }
        getActivity().runOnUiThread(new d(lb3Var));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends RecyclerView.AdapterDataObserver {
        public l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            TrackUserFragment.this.j0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            TrackUserFragment.this.j0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            TrackUserFragment.this.j0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            TrackUserFragment.this.j0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            TrackUserFragment.this.j0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            TrackUserFragment.this.j0();
        }
    }
}
