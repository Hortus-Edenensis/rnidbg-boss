package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.CellViewControllerManager;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mf6 {
    public static int g = 4;
    public static int h = 80;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GroupItem f19207a;
    public ArrayList<CellItem> b;
    public TabItem c;
    public DynamicConfigFragment d;
    public ArrayList<zz> e;
    public int f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f19208a;

        public a(ArrayList arrayList) {
            this.f19208a = arrayList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view = (View) this.f19208a.get(i);
            if (view != null) {
                viewGroup.removeView(view);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f19208a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            View view = (View) this.f19208a.get(i);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }
    }

    public mf6(GroupItem groupItem, ArrayList<CellItem> arrayList, TabItem tabItem, DynamicConfigFragment dynamicConfigFragment, ArrayList<zz> arrayList2) {
        this.f = 0;
        this.f19207a = groupItem;
        this.b = arrayList;
        this.c = tabItem;
        this.d = dynamicConfigFragment;
        this.e = arrayList2;
        this.f = me1.b(AppContext.getContext(), h);
    }

    public void c(Context context, ViewGroup viewGroup) {
        if (this.b.size() == 0) {
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_dynamic_group_top_vp, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.groupName)).setText(this.f19207a.getNameForShow());
        f((ViewPager) viewInflate.findViewById(R.id.viewpager), (LinearLayout) viewInflate.findViewById(R.id.indicator_wrapper));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, this.f19207a.ignorePadding ? 0 : me1.b(context, 10));
        viewGroup.addView(viewInflate, layoutParams);
    }

    public final View d(Context context, List<CellItem> list) {
        LinearLayout linearLayout = null;
        if (list.size() <= 0) {
            return null;
        }
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        int i = g;
        int iB = me1.b(context, 40);
        int iB2 = me1.b(context, 15);
        int iB3 = me1.b(context, 80);
        me1.b(context, 84);
        int iG = ((((me1.g() - iB2) + iB) - (i * iB3)) - (me1.b(context, 24) * 2)) / (i * 2);
        int i2 = 0;
        for (CellItem cellItem : list) {
            if (i2 % i == 0) {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(80);
                linearLayout2.addView(linearLayout);
            }
            i2++;
            zz zzVarB = CellViewControllerManager.b(cellItem);
            zzVarB.onCreateView(this.d, this.c, this.f19207a, cellItem);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iB3, -2);
            layoutParams.setMargins(iG, 0, iG, 0);
            linearLayout.addView(zzVarB.getView(), layoutParams);
            this.e.add(zzVarB);
        }
        return linearLayout2;
    }

    public final ArrayList<View> e(ArrayList<CellItem> arrayList) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        if (arrayList.size() > g) {
            arrayList2.add(d(AppContext.getContext(), arrayList.subList(0, g)));
            arrayList2.add(d(AppContext.getContext(), arrayList.subList(g, arrayList.size())));
        } else {
            arrayList2.add(d(AppContext.getContext(), arrayList));
        }
        return arrayList2;
    }

    public final void f(ViewPager viewPager, ViewGroup viewGroup) {
        ArrayList<View> arrayListE = e(this.b);
        if (arrayListE.size() > 1) {
            viewGroup.setVisibility(0);
            g(viewGroup, 0);
        } else {
            viewGroup.setVisibility(8);
        }
        viewPager.setAdapter(new a(arrayListE));
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(new b(viewPager, viewGroup));
        i(viewPager, 0, 0.0f);
    }

    public final void g(ViewGroup viewGroup, int i) {
        if (i == 0) {
            h(viewGroup.getChildAt(0), me1.b(AppContext.getContext(), 10));
            viewGroup.getChildAt(0).setSelected(true);
            h(viewGroup.getChildAt(1), me1.b(AppContext.getContext(), 3));
            viewGroup.getChildAt(1).setSelected(false);
            return;
        }
        h(viewGroup.getChildAt(0), me1.b(AppContext.getContext(), 3));
        viewGroup.getChildAt(0).setSelected(false);
        h(viewGroup.getChildAt(1), me1.b(AppContext.getContext(), 10));
        viewGroup.getChildAt(1).setSelected(true);
    }

    public final void h(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public final void i(ViewPager viewPager, int i, float f) {
        int iCeil = 1;
        if (i > 1 || i < 0) {
            return;
        }
        int i2 = this.f;
        if (i == 1) {
            f = 1.0f;
        }
        if (this.b.size() > g) {
            int size = this.b.size();
            int i3 = g;
            iCeil = (int) Math.ceil(((size - i3) * 1.0f) / i3);
        }
        int i4 = iCeil * this.f;
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        layoutParams.height = (int) (((i4 - i2) * f) + i2);
        viewPager.setLayoutParams(layoutParams);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f19209a;
        public final /* synthetic */ ViewGroup b;

        public b(ViewPager viewPager, ViewGroup viewGroup) {
            this.f19209a = viewPager;
            this.b = viewGroup;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            LogUtil.i("ViewPagerGroupHelper", "onPageScrolled position =" + i + " positionOffset=" + f);
            mf6.this.i(this.f19209a, i, f);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            mf6.this.g(this.b, i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    }
}
