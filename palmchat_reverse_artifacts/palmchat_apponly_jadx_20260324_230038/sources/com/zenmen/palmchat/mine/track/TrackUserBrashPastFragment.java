package com.zenmen.palmchat.mine.track;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.databinding.FragmentTrackCommonBinding;
import com.zenmen.palmchat.databinding.UserTrackRecycleviewItemBinding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.mine.track.UserTrackBean;
import com.zenmen.palmchat.square.SBaseRecycleAdapter;
import com.zenmen.palmchat.square.SBaseViewHolder;
import com.zenmen.square.ui.widget.SquarePullHeader;
import defpackage.b05;
import defpackage.c74;
import defpackage.iv0;
import defpackage.j74;
import defpackage.me1;
import defpackage.q05;
import defpackage.wz5;
import defpackage.xu4;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TrackUserBrashPastFragment extends BaseFragment {
    public int f;
    public FragmentTrackCommonBinding g;
    public SBaseRecycleAdapter<UserTrackBean.UserTrackBeanList, SBaseViewHolder> i;
    public List<UserTrackBean.UserTrackBeanList> h = new ArrayList();
    public int j = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class StickyItemDecoration extends RecyclerView.ItemDecoration {
        public final Paint b;
        public final Paint c;
        public final int d;
        public final Context e;

        public StickyItemDecoration(Context context) {
            this.e = context;
            this.d = me1.b(context, 36);
            Paint paint = new Paint();
            this.b = paint;
            paint.setColor(-1);
            Paint paint2 = new Paint(1);
            this.c = paint2;
            paint2.setColor(-14540254);
            paint2.setTextSize(me1.b(context, 17));
            paint2.setTypeface(Typeface.DEFAULT_BOLD);
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, String str, int i) {
            canvas.drawRect(0.0f, i, recyclerView.getWidth(), this.d + i, this.b);
            canvas.drawText(str, me1.b(this.e, 16), ((i + this.d) - me1.b(this.e, 2)) - this.c.getFontMetrics().bottom, this.c);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            String strR;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == -1) {
                return;
            }
            TrackUserBrashPastFragment trackUserBrashPastFragment = TrackUserBrashPastFragment.this;
            String strR2 = trackUserBrashPastFragment.R(trackUserBrashPastFragment.h.get(childAdapterPosition).getOptTime().longValue());
            if (childAdapterPosition > 0) {
                TrackUserBrashPastFragment trackUserBrashPastFragment2 = TrackUserBrashPastFragment.this;
                strR = trackUserBrashPastFragment2.R(trackUserBrashPastFragment2.h.get(childAdapterPosition - 1).getOptTime().longValue());
            } else {
                strR = "";
            }
            if (strR2.equals(strR)) {
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
        /* JADX WARN: Type inference failed for: r8v0, types: [com.zenmen.palmchat.mine.track.TrackUserBrashPastFragment$StickyItemDecoration] */
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childCount = recyclerView.getChildCount();
            ?? r0 = 0;
            int i = 0;
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    TrackUserBrashPastFragment trackUserBrashPastFragment = TrackUserBrashPastFragment.this;
                    ?? R = trackUserBrashPastFragment.R(trackUserBrashPastFragment.h.get(childAdapterPosition).getOptTime().longValue());
                    if (!R.equals(r0)) {
                        a(canvas, recyclerView, R, Math.max(childAt.getTop() - this.d, 0));
                        r0 = R;
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
            if (recyclerView.getChildCount() == 0 || TrackUserBrashPastFragment.this.h.size() == 0 || (childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0))) == -1) {
                return;
            }
            TrackUserBrashPastFragment trackUserBrashPastFragment = TrackUserBrashPastFragment.this;
            String strR = trackUserBrashPastFragment.R(trackUserBrashPastFragment.h.get(childAdapterPosition).getOptTime().longValue());
            int i2 = 1;
            while (true) {
                if (i2 >= recyclerView.getChildCount()) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i2);
                int childAdapterPosition2 = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition2 != -1) {
                    TrackUserBrashPastFragment trackUserBrashPastFragment2 = TrackUserBrashPastFragment.this;
                    if (!strR.equals(trackUserBrashPastFragment2.R(trackUserBrashPastFragment2.h.get(childAdapterPosition2).getOptTime().longValue()))) {
                        int top = childAt.getTop();
                        int i3 = this.d;
                        i = top <= i3 * 2 ? (int) ((((i3 * 2) - top) * i3) / i3) : 0;
                    }
                }
                i2++;
            }
            int iMax = Math.max(Math.min(i, this.d), 0);
            canvas.save();
            canvas.translate(0.0f, -iMax);
            a(canvas, recyclerView, strR, 0);
            canvas.restore();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements j74 {
        public b() {
        }

        @Override // defpackage.j74
        public void a(@NonNull xu4 xu4Var) {
            TrackUserBrashPastFragment.this.V(false, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements c74 {
        public c() {
        }

        @Override // defpackage.c74
        public void onLoadMore(@NonNull xu4 xu4Var) {
            TrackUserBrashPastFragment.this.V(true, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements q05.d<LXBaseNetBean<UserTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14736a;
        public final /* synthetic */ xu4 b;
        public final /* synthetic */ int c;

        public d(boolean z, xu4 xu4Var, int i) {
            this.f14736a = z;
            this.b = xu4Var;
            this.c = i;
        }

        @Override // q05.d
        public void a(Exception exc) {
            if (this.f14736a) {
                this.b.finishLoadMore(false);
            } else {
                this.b.finishRefresh(false);
            }
        }

        @Override // q05.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(LXBaseNetBean<UserTrackBean> lXBaseNetBean) {
            UserTrackBean userTrackBean;
            UserTrackBean userTrackBean2;
            UserTrackBean userTrackBean3;
            if (q05.o(TrackUserBrashPastFragment.this.getActivity())) {
                return;
            }
            if (!this.f14736a) {
                TrackUserBrashPastFragment.this.h.clear();
                this.b.finishRefresh();
            } else if (lXBaseNetBean == null || (userTrackBean = lXBaseNetBean.data) == null || userTrackBean.getResultList() == null || !lXBaseNetBean.data.getResultList().isEmpty()) {
                this.b.finishLoadMore();
            } else {
                this.b.finishLoadMoreWithNoMoreData();
            }
            if (lXBaseNetBean != null && (userTrackBean3 = lXBaseNetBean.data) != null && userTrackBean3.getResultList() != null && lXBaseNetBean.data.getResultList().size() > 0) {
                TrackUserBrashPastFragment trackUserBrashPastFragment = TrackUserBrashPastFragment.this;
                trackUserBrashPastFragment.j = this.c;
                trackUserBrashPastFragment.h.addAll(lXBaseNetBean.data.getResultList());
                if (TrackUserBrashPastFragment.this.j == 0) {
                    b05.d("设置可以滚动");
                    this.b.setEnableLoadMore(true);
                }
            }
            if (lXBaseNetBean != null && (userTrackBean2 = lXBaseNetBean.data) != null && (userTrackBean2.getResultList() == null || lXBaseNetBean.data.getResultList().isEmpty())) {
                TrackUserBrashPastFragment trackUserBrashPastFragment2 = TrackUserBrashPastFragment.this;
                if (trackUserBrashPastFragment2.j == 0 && !this.f14736a) {
                    trackUserBrashPastFragment2.h.clear();
                }
            }
            TrackUserBrashPastFragment.this.i.notifyDataSetChanged();
        }
    }

    public String R(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(6);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i3 = calendar.get(1);
        return (i == i3 && i2 == calendar.get(6)) ? "今天" : i == i3 ? iv0.a(j, "M月d日") : iv0.a(j, "yyyy年M月d日");
    }

    public final void T() {
        ClassicsFooter.REFRESH_FOOTER_NOTHING = "已经到底了~";
        this.i = new a(getContext(), this.h);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.g.f13898a.setLayoutManager(linearLayoutManager);
        this.g.f13898a.setAdapter(this.i);
        this.g.f13898a.addItemDecoration(new StickyItemDecoration(getContext()));
        if (this.f == 0) {
            this.g.b.setEnableLoadMore(false);
        }
        this.g.b.setOnRefreshListener(new b());
        this.g.b.setOnLoadMoreListener(new c());
        this.g.b.setRefreshHeader(new SquarePullHeader(getContext()));
        this.g.b.setRefreshFooter(new ClassicsFooter(getContext()));
    }

    public void V(boolean z, xu4 xu4Var) {
        wz5.i().e(new d(z, xu4Var, z ? this.j + 1 : 0));
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        T();
        V(false, this.g.b);
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends SBaseRecycleAdapter<UserTrackBean.UserTrackBeanList, SBaseViewHolder> {
        public a(Context context, List list) {
            super(context, list);
        }

        @Override // com.zenmen.palmchat.square.SBaseRecycleAdapter
        public SBaseViewHolder a(@NonNull ViewGroup viewGroup, int i) {
            return new C1078a(UserTrackRecycleviewItemBinding.b(TrackUserBrashPastFragment.this.getLayoutInflater(), viewGroup, false));
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.mine.track.TrackUserBrashPastFragment$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1078a extends SBaseViewHolder<UserTrackBean.UserTrackBeanList, UserTrackRecycleviewItemBinding> {
            public C1078a(UserTrackRecycleviewItemBinding userTrackRecycleviewItemBinding) {
                super(userTrackRecycleviewItemBinding);
            }

            @Override // com.zenmen.palmchat.square.SBaseViewHolder
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public void l(SBaseViewHolder<UserTrackBean.UserTrackBeanList, UserTrackRecycleviewItemBinding> sBaseViewHolder, UserTrackBean.UserTrackBeanList userTrackBeanList, int i) {
            }
        }
    }
}
