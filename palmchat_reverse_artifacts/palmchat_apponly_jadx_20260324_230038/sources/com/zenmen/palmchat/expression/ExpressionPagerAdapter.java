package com.zenmen.palmchat.expression;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ExpressionObject;
import com.zenmen.palmchat.chat.ExpressionGridView;
import com.zenmen.palmchat.chat.ExpressionViewPager;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.fs1;
import defpackage.g03;
import defpackage.lt1;
import defpackage.tl1;
import defpackage.vl1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ExpressionPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13931a;
    public ExpressionViewPager b;
    public InputFragment c;
    public ArrayList<ExpressionObject> d = new ArrayList<>();
    public ArrayList<ExpressionObject> e = new ArrayList<>();
    public lt1 f = null;
    public ArrayList<ExpressionObject> g = new ArrayList<>();
    public ArrayList<ExpressionType> h = new ArrayList<>();
    public boolean i = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum ExpressionType {
        TYPE_EMOJI,
        TYPE_FAV,
        TYPE_LBY,
        TYPE_WORD
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f13932a;

        public a(ExpressionGridView expressionGridView) {
            this.f13932a = expressionGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((String) adapterView.getItemAtPosition(i)).equals(vl1.n)) {
                ExpressionPagerAdapter.this.c.e2();
            } else {
                ExpressionPagerAdapter.this.c.W1((String) this.f13932a.getAdapter().getItem(i), false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ExpressionGridView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f13934a;

        public c(ExpressionGridView expressionGridView) {
            this.f13934a = expressionGridView;
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void a(View view, int i) {
            ExpressionObject expressionObject = (ExpressionObject) this.f13934a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if (!"add".equals(expressionObject.tag)) {
                View childAt = this.f13934a.getChildAt(i - this.f13934a.getFirstVisiblePosition());
                if (childAt == null) {
                    return;
                } else {
                    childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.selector_bg_face_item);
                }
            }
            fs1.a();
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void b(View view, int i) {
            ExpressionPagerAdapter.this.b.requestDisallowInterceptTouchEvent(false);
            ExpressionObject expressionObject = (ExpressionObject) this.f13934a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if (!"add".equals(expressionObject.tag)) {
                View childAt = this.f13934a.getChildAt(i - this.f13934a.getFirstVisiblePosition());
                if (childAt == null) {
                    return;
                } else {
                    childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.selector_bg_face_item);
                }
            }
            fs1.a();
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void c(View view, int i) {
            ExpressionPagerAdapter.this.b.requestDisallowInterceptTouchEvent(true);
            ExpressionObject expressionObject = (ExpressionObject) this.f13934a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if ("add".equals(expressionObject.tag)) {
                fs1.a();
                return;
            }
            View childAt = this.f13934a.getChildAt(i - this.f13934a.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.background_face_item_pressed);
                fs1.b((Activity) ExpressionPagerAdapter.this.f13931a, view.findViewById(R.id.image), expressionObject);
            }
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ExpressionObject expressionObject = (ExpressionObject) adapterView.getAdapter().getItem(i);
            if (expressionObject == null) {
                return;
            }
            if ("add".equals(expressionObject.tag)) {
                Intent intent = new Intent();
                intent.setClass(ExpressionPagerAdapter.this.c.getActivity(), FavoriteExpressionManagerActivity.class);
                ExpressionPagerAdapter.this.c.getActivity().startActivity(intent);
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME106", "1", null, null);
                return;
            }
            if ("jsb".equals(expressionObject.tag)) {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            } else if ("dice".equals(expressionObject.tag)) {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            } else {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ExpressionGridView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f13936a;

        public e(ExpressionGridView expressionGridView) {
            this.f13936a = expressionGridView;
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void a(View view, int i) {
            ExpressionObject expressionObject = (ExpressionObject) this.f13936a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if (!"add".equals(expressionObject.tag)) {
                View childAt = this.f13936a.getChildAt(i - this.f13936a.getFirstVisiblePosition());
                if (childAt == null) {
                    return;
                } else {
                    childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.selector_bg_face_item);
                }
            }
            fs1.a();
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void b(View view, int i) {
            ExpressionPagerAdapter.this.b.requestDisallowInterceptTouchEvent(false);
            ExpressionObject expressionObject = (ExpressionObject) this.f13936a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if (!"add".equals(expressionObject.tag)) {
                View childAt = this.f13936a.getChildAt(i - this.f13936a.getFirstVisiblePosition());
                if (childAt == null) {
                    return;
                } else {
                    childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.selector_bg_face_item);
                }
            }
            fs1.a();
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void c(View view, int i) {
            ExpressionPagerAdapter.this.b.requestDisallowInterceptTouchEvent(true);
            ExpressionObject expressionObject = (ExpressionObject) this.f13936a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if ("add".equals(expressionObject.tag)) {
                fs1.a();
                return;
            }
            View childAt = this.f13936a.getChildAt(i - this.f13936a.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.background_face_item_pressed);
                fs1.b((Activity) ExpressionPagerAdapter.this.f13931a, view.findViewById(R.id.image), expressionObject);
            }
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ExpressionObject expressionObject = (ExpressionObject) adapterView.getAdapter().getItem(i);
            if (expressionObject == null) {
                return;
            }
            if ("add".equals(expressionObject.tag)) {
                Intent intent = new Intent();
                intent.setClass(ExpressionPagerAdapter.this.c.getActivity(), FavoriteExpressionManagerActivity.class);
                ExpressionPagerAdapter.this.c.getActivity().startActivity(intent);
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME106", "1", null, null);
                return;
            }
            if ("jsb".equals(expressionObject.tag)) {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            } else if ("dice".equals(expressionObject.tag)) {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            } else {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements ExpressionGridView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f13938a;

        public g(ExpressionGridView expressionGridView) {
            this.f13938a = expressionGridView;
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void a(View view, int i) {
            ExpressionObject expressionObject = (ExpressionObject) this.f13938a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if (!"add".equals(expressionObject.tag)) {
                View childAt = this.f13938a.getChildAt(i - this.f13938a.getFirstVisiblePosition());
                if (childAt == null) {
                    return;
                } else {
                    childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.selector_bg_face_item);
                }
            }
            fs1.a();
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void b(View view, int i) {
            ExpressionPagerAdapter.this.b.requestDisallowInterceptTouchEvent(false);
            ExpressionObject expressionObject = (ExpressionObject) this.f13938a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if (!"add".equals(expressionObject.tag)) {
                View childAt = this.f13938a.getChildAt(i - this.f13938a.getFirstVisiblePosition());
                if (childAt == null) {
                    return;
                } else {
                    childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.selector_bg_face_item);
                }
            }
            fs1.a();
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void c(View view, int i) {
            ExpressionPagerAdapter.this.b.requestDisallowInterceptTouchEvent(true);
            ExpressionObject expressionObject = (ExpressionObject) this.f13938a.getItemAtPosition(i);
            if (expressionObject == null) {
                return;
            }
            if ("add".equals(expressionObject.tag)) {
                fs1.a();
                return;
            }
            View childAt = this.f13938a.getChildAt(i - this.f13938a.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.findViewById(R.id.image).setBackgroundResource(R.drawable.background_face_item_pressed);
                fs1.b((Activity) ExpressionPagerAdapter.this.f13931a, view.findViewById(R.id.image), expressionObject);
            }
        }

        @Override // com.zenmen.palmchat.chat.ExpressionGridView.b
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ExpressionObject expressionObject = (ExpressionObject) adapterView.getAdapter().getItem(i);
            if (expressionObject == null) {
                return;
            }
            if ("add".equals(expressionObject.tag)) {
                Intent intent = new Intent();
                intent.setClass(ExpressionPagerAdapter.this.c.getActivity(), FavoriteExpressionManagerActivity.class);
                ExpressionPagerAdapter.this.c.getActivity().startActivity(intent);
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME106", "1", null, null);
                return;
            }
            if ("jsb".equals(expressionObject.tag)) {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            } else if ("dice".equals(expressionObject.tag)) {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            } else {
                if (ExpressionPagerAdapter.this.c.l2() != null) {
                    ExpressionPagerAdapter.this.c.l2().j(expressionObject);
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_EXPRESSION, null, "ME101", "1", null, null);
            }
        }
    }

    public ExpressionPagerAdapter(Context context, InputFragment inputFragment, ExpressionViewPager expressionViewPager, boolean z) {
        this.f13931a = context;
        this.c = inputFragment;
        this.b = expressionViewPager;
        if (!z) {
            l(this.d);
        }
        m();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        Runtime.getRuntime().gc();
    }

    public int g() {
        return (int) Math.ceil((vl1.f().size() - 1) / 150.0f);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.h.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    public ExpressionType h(int i) {
        return this.h.get(i);
    }

    public ArrayList<ExpressionObject> i() {
        return this.d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ExpressionGridView expressionGridView = new ExpressionGridView(this.f13931a);
        expressionGridView.setCacheColorHint(this.f13931a.getResources().getColor(android.R.color.transparent));
        expressionGridView.setSelector(android.R.color.transparent);
        expressionGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ExpressionType expressionTypeH = h(i);
        int i2 = 0;
        if (expressionTypeH == ExpressionType.TYPE_EMOJI) {
            expressionGridView.setVerticalSpacing(k(3, (int) this.f13931a.getResources().getDimension(R.dimen.emoji_item_size)));
            expressionGridView.setNumColumns(6);
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, String>> it = vl1.f().entrySet().iterator();
            int i3 = i * 150;
            int i4 = (i + 1) * 150;
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (i2 >= i3 && i2 < i4) {
                    arrayList.add(key);
                }
                i2++;
            }
            if (((String) arrayList.get(arrayList.size() - 1)).equals(vl1.n)) {
                arrayList.remove(arrayList.size() - 1);
            }
            expressionGridView.setAdapter((ListAdapter) new tl1(this.f13931a, arrayList));
            expressionGridView.setOnItemClickListener(new a(expressionGridView));
        } else if (expressionTypeH == ExpressionType.TYPE_WORD) {
            expressionGridView.setDragEnable(true);
            expressionGridView.setVerticalSpacing(k(2, (int) this.f13931a.getResources().getDimension(R.dimen.favorite_expression_item_size)));
            expressionGridView.setNumColumns(4);
            lt1 lt1Var = new lt1(this.f13931a, this.e, 0);
            this.b.addOnPageChangeListener(new b(expressionGridView));
            expressionGridView.setOnTouchChangeListener(new c(expressionGridView));
            expressionGridView.setAdapter((ListAdapter) lt1Var);
        } else if (expressionTypeH == ExpressionType.TYPE_FAV) {
            expressionGridView.setDragEnable(true);
            expressionGridView.setVerticalSpacing(k(2, (int) this.f13931a.getResources().getDimension(R.dimen.favorite_expression_item_size)));
            expressionGridView.setNumColumns(4);
            lt1 lt1Var2 = new lt1(this.f13931a, this.d, 0);
            this.f = lt1Var2;
            this.b.addOnPageChangeListener(new d(expressionGridView));
            expressionGridView.setOnTouchChangeListener(new e(expressionGridView));
            expressionGridView.setAdapter((ListAdapter) lt1Var2);
        } else if (expressionTypeH == ExpressionType.TYPE_LBY) {
            expressionGridView.setDragEnable(true);
            expressionGridView.setVerticalSpacing(k(2, (int) this.f13931a.getResources().getDimension(R.dimen.favorite_expression_item_size)));
            expressionGridView.setNumColumns(4);
            lt1 lt1Var3 = new lt1(this.f13931a, this.g, 0);
            this.b.addOnPageChangeListener(new f(expressionGridView));
            expressionGridView.setOnTouchChangeListener(new g(expressionGridView));
            expressionGridView.setAdapter((ListAdapter) lt1Var3);
        }
        viewGroup.addView(expressionGridView);
        return expressionGridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public int j() {
        return 1;
    }

    public final int k(int i, int i2) {
        int iD = g03.d() - ((int) ((this.f13931a.getResources().getDimension(R.dimen.expression_setting_height) + this.f13931a.getResources().getDimension(R.dimen.expression_pager_indicator)) + 0.5f));
        if (iD != 0) {
            return (iD - (i2 * i)) / (i + 1);
        }
        return 0;
    }

    public final void l(ArrayList<ExpressionObject> arrayList) {
        this.d = arrayList;
        ExpressionObject expressionObject = new ExpressionObject();
        expressionObject.tag = "add";
        this.d.add(0, expressionObject);
    }

    public final void m() {
        if (!this.i) {
            this.h.add(ExpressionType.TYPE_EMOJI);
            this.h.add(ExpressionType.TYPE_FAV);
        } else {
            this.h.add(ExpressionType.TYPE_EMOJI);
            this.h.add(ExpressionType.TYPE_WORD);
            this.h.add(ExpressionType.TYPE_FAV);
            this.h.add(ExpressionType.TYPE_LBY);
        }
    }

    public boolean n() {
        return this.i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        lt1 lt1Var = this.f;
        if (lt1Var != null) {
            lt1Var.b(this.d);
        }
        for (int i = 0; i < this.b.getChildCount(); i++) {
            this.b.getChildAt(i).requestLayout();
        }
    }

    public void o(ArrayList<ExpressionObject> arrayList) {
        if (arrayList != null) {
            l(arrayList);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f13933a;

        public b(ExpressionGridView expressionGridView) {
            this.f13933a = expressionGridView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            this.f13933a.removePopMessage();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f13935a;

        public d(ExpressionGridView expressionGridView) {
            this.f13935a = expressionGridView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            this.f13935a.removePopMessage();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpressionGridView f13937a;

        public f(ExpressionGridView expressionGridView) {
            this.f13937a = expressionGridView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            this.f13937a.removePopMessage();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }
}
