package defpackage;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.circle.ui.adapter.TabAdapter;
import com.zenmen.palmchat.circle.ui.view.IndicatorLineView;
import com.zenmen.palmchat.circle.ui.view.TabLayoutScroll;
import com.zenmen.palmchat.circle.ui.view.TabViewHolder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ss5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TabLayoutScroll f20834a;
    public ViewPager b;
    public int c = 0;
    public int d = 0;
    public float e = -1.0f;
    public int f = 0;
    public int g = 0;
    public int h = -1;
    public int i = 0;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public int n = -1;
    public TabAdapter<T> o;
    public fp2<T> p;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabLayoutScroll f20835a;
        public final /* synthetic */ ViewPager b;

        public a(TabLayoutScroll tabLayoutScroll, ViewPager viewPager) {
            this.f20835a = tabLayoutScroll;
            this.b = viewPager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (!ss5.this.j) {
                ss5.this.k = true;
                ss5.this.i -= i;
            }
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.f20835a.getHorizontalRecyclerView().findViewHolderForAdapterPosition(this.b.getCurrentItem());
            if (((IndicatorLineView) this.f20835a.getIndicatorView()) != null) {
                if (viewHolderFindViewHolderForAdapterPosition != null) {
                    this.f20835a.getIndicatorView().getIndicator().k(this.f20835a.getIndicatorView().getIndicator().f()).j((int) ((viewHolderFindViewHolderForAdapterPosition.itemView.getLeft() + ((viewHolderFindViewHolderForAdapterPosition.itemView.getWidth() * 1.0f) / 2.0f)) - (this.f20835a.getIndicatorView().getIndicator().d() / 2)));
                } else {
                    this.f20835a.getIndicatorView().getIndicator().k(0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f20836a;
        public final /* synthetic */ TabLayoutScroll b;

        public b(ViewPager viewPager, TabLayoutScroll tabLayoutScroll) {
            this.f20836a = viewPager;
            this.b = tabLayoutScroll;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i != 0) {
                return;
            }
            if (ss5.this.l) {
                ss5.this.n = this.f20836a.getCurrentItem();
                ss5.this.m = true;
            }
            ss5.this.l = false;
            ss5.this.e = -1.0f;
            ss5.this.h = -1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int i3;
            int i4;
            double dE;
            int width = (int) ((this.b.getWidth() * 1.0f) / 2.0f);
            if (ss5.this.k && ss5.this.i != 0) {
                this.b.getHorizontalRecyclerView().stopScroll();
                ss5.this.j = true;
                this.b.getHorizontalRecyclerView().scrollBy(ss5.this.i, 0);
                ss5.this.j = false;
                ss5.this.k = false;
                ss5.this.i = 0;
                return;
            }
            if (ss5.this.l) {
                if (i == this.f20836a.getCurrentItem() - 1 || i == this.f20836a.getCurrentItem()) {
                    if (this.b.getHorizontalRecyclerView().findViewHolderForAdapterPosition(this.f20836a.getCurrentItem()) != null) {
                        if (ss5.this.e == -1.0f) {
                            ss5.this.e = (r4.itemView.getLeft() + ((r4.itemView.getWidth() * 1.0f) / 2.0f)) - width;
                        }
                        if (ss5.this.h == -1) {
                            ss5.this.h = this.b.getHorizontalRecyclerView().getOffsetX();
                        }
                        if (f != 0.0f) {
                            ss5.this.j = true;
                            if (ss5.this.e > 0.0f) {
                                this.b.getHorizontalRecyclerView().scrollTo((int) (ss5.this.h - (ss5.this.e * f)), 0);
                            } else if (ss5.this.e < 0.0f) {
                                this.b.getHorizontalRecyclerView().scrollTo((int) (ss5.this.h - (ss5.this.e * (1.0f - f))), 0);
                            }
                            ss5.this.j = false;
                        }
                    } else if (this.b.getIndicatorView() != null) {
                        this.b.getIndicatorView().getIndicator().k(0).g();
                    }
                }
                ss5.this.c = i;
                return;
            }
            TabViewHolder tabViewHolder = (TabViewHolder) this.b.getHorizontalRecyclerView().findViewHolderForAdapterPosition(i);
            if (tabViewHolder != null) {
                int width2 = (int) ((tabViewHolder.itemView.getWidth() * 1.0f) / 2.0f);
                int left = tabViewHolder.itemView.getLeft();
                int iA = this.b.getHorizontalRecyclerView().getItemDecoration().a();
                int i5 = i + 1;
                TabViewHolder tabViewHolder2 = (TabViewHolder) this.b.getHorizontalRecyclerView().findViewHolderForAdapterPosition(i5);
                if (i == 0) {
                    ss5.this.d = 0;
                    ss5.this.g = 0;
                    if (tabViewHolder2 != null) {
                        ss5.this.f = (int) (iA + width2 + ((tabViewHolder2.itemView.getWidth() * 1.0f) / 2.0f));
                    }
                } else if (ss5.this.c < i) {
                    if (tabViewHolder2 != null) {
                        ss5.this.d = (int) ((tabViewHolder2.itemView.getLeft() + ((tabViewHolder2.itemView.getWidth() * 1.0f) / 2.0f)) - width);
                        if (ss5.this.d < 0) {
                            ss5.this.d = 0;
                        }
                        ss5.this.g = this.b.getHorizontalRecyclerView().getOffsetX();
                        ss5.this.f = (int) (iA + width2 + ((tabViewHolder2.itemView.getWidth() * 1.0f) / 2.0f));
                    }
                } else if (ss5.this.c > i) {
                    ss5.this.d = (left + width2) - width;
                    if (ss5.this.d > 0) {
                        ss5.this.d = 0;
                    }
                    ss5.this.g = this.b.getHorizontalRecyclerView().getOffsetX();
                    if (tabViewHolder2 != null) {
                        ss5.this.f = (int) (iA + width2 + ((tabViewHolder2.itemView.getWidth() * 1.0f) / 2.0f));
                    }
                } else if (ss5.this.m) {
                    if (i == ss5.this.n && tabViewHolder2 != null) {
                        ss5.this.d = (int) ((tabViewHolder2.itemView.getLeft() + ((tabViewHolder2.itemView.getWidth() * 1.0f) / 2.0f)) - width);
                        ss5.this.g = this.b.getHorizontalRecyclerView().getOffsetX();
                        ss5.this.f = (int) (iA + width2 + ((tabViewHolder2.itemView.getWidth() * 1.0f) / 2.0f));
                    }
                    ss5.this.m = false;
                }
                if (ss5.this.d != 0 && f != 0.0f && ss5.this.c == i) {
                    ss5.this.j = true;
                    if (ss5.this.d > 0) {
                        this.b.getHorizontalRecyclerView().scrollTo((int) (ss5.this.g - (ss5.this.d * f)), 0);
                    } else {
                        this.b.getHorizontalRecyclerView().scrollTo((int) (ss5.this.g - (ss5.this.d * (1.0f - f))), 0);
                    }
                    ss5.this.j = false;
                }
                if (this.b.getIndicatorView() != null) {
                    qs2 indicator = this.b.getIndicatorView().getIndicator();
                    int iF = this.b.getIndicatorView().getIndicator().f();
                    double dF = this.b.getIndicatorView().getIndicator().f();
                    if (f == 0.0f) {
                        dE = 0.0d;
                        i4 = iF;
                        i3 = i5;
                    } else {
                        i4 = iF;
                        i3 = i5;
                        dE = ((double) this.b.getIndicatorView().getIndicator().e()) * (0.5d - Math.abs(0.5d - ((double) f)));
                    }
                    indicator.k(Math.max(i4, (int) (dF + dE))).j((int) (((left + width2) - (this.b.getIndicatorView().getIndicator().d() / 2)) + (ss5.this.f * f)));
                } else {
                    i3 = i5;
                }
                if (ss5.this.f != 0 && tabViewHolder2 != null) {
                    ss5.this.p.c(tabViewHolder, i, false, 1.0f - f, tabViewHolder2, i3, true, f);
                }
            } else {
                this.b.getHorizontalRecyclerView().scrollToPosition(i);
                TabViewHolder tabViewHolder3 = (TabViewHolder) this.b.getHorizontalRecyclerView().findViewHolderForAdapterPosition(i);
                if (tabViewHolder3 != null) {
                    int width3 = (int) ((tabViewHolder3.itemView.getWidth() * 1.0f) / 2.0f);
                    int left2 = tabViewHolder3.itemView.getLeft();
                    if (this.b.getIndicatorView() != null) {
                        this.b.getIndicatorView().getIndicator().k(this.b.getIndicatorView().getIndicator().f()).j((int) ((left2 + width3) - ((this.b.getIndicatorView().getIndicator().d() * 1.0f) / 2.0f)));
                    }
                } else if (this.b.getIndicatorView() != null) {
                    this.b.getIndicatorView().getIndicator().k(0).g();
                }
            }
            ss5.this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ss5.this.o.n(this.f20836a.getCurrentItem());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends TabAdapter<T> {
        public final /* synthetic */ ViewPager h;
        public final /* synthetic */ TabLayoutScroll i;

        public c(ViewPager viewPager, TabLayoutScroll tabLayoutScroll) {
            this.h = viewPager;
            this.i = tabLayoutScroll;
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.TabAdapter
        public void h(TabViewHolder tabViewHolder, int i, T t, boolean z) {
            ss5.this.p.e(tabViewHolder, i, t, z);
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.TabAdapter
        public int i(int i, T t) {
            return ss5.this.p.b(i, t);
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.TabAdapter
        public void m(TabViewHolder tabViewHolder, int i, T t) {
            ss5.this.k = false;
            ss5.this.i = 0;
            ss5.this.l = true;
            this.h.setCurrentItem(i);
            if (this.i.getHorizontalRecyclerView().findViewHolderForAdapterPosition(this.h.getCurrentItem()) != null) {
                if (this.i.getIndicatorView() != null) {
                    this.i.getIndicatorView().getIndicator().k(this.i.getIndicatorView().getIndicator().f()).j((int) ((r0.itemView.getLeft() + ((r0.itemView.getWidth() * 1.0f) / 2.0f)) - (this.i.getIndicatorView().getIndicator().d() / 2)));
                }
            } else if (this.i.getIndicatorView() != null) {
                this.i.getIndicatorView().getIndicator().k(0).g();
            }
            ss5.this.p.a(tabViewHolder, i, t);
        }
    }

    public ss5(TabLayoutScroll tabLayoutScroll, ViewPager viewPager) {
        this.f20834a = tabLayoutScroll;
        this.b = viewPager;
        tabLayoutScroll.getHorizontalRecyclerView().addOnScrollListener(new a(tabLayoutScroll, viewPager));
        viewPager.addOnPageChangeListener(new b(viewPager, tabLayoutScroll));
        this.o = new c(viewPager, tabLayoutScroll);
    }

    public TabAdapter<T> A(fp2<T> fp2Var) {
        this.p = fp2Var;
        this.f20834a.setAdapter(this.o);
        this.b.setAdapter(fp2Var.d());
        return this.o;
    }
}
