package com.zenmen.palmchat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class HeaderFooterGridView extends GridView {
    private static final String TAG = "HeaderFooterGridView";
    private ArrayList<a> mFooterViewInfos;
    private ArrayList<a> mHeaderViewInfos;
    private int mNumColmuns;
    private int mRequestedNumColumns;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f15966a;
        public ViewGroup b;
        public Object c;
        public boolean d;

        public a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((HeaderFooterGridView.this.getMeasuredWidth() - HeaderFooterGridView.this.getPaddingLeft()) - HeaderFooterGridView.this.getPaddingRight(), View.MeasureSpec.getMode(i)), i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements WrapperListAdapter, Filterable {
        public final ListAdapter b;
        public ArrayList<a> d;
        public ArrayList<a> e;
        public boolean f;
        public final boolean g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataSetObservable f15968a = new DataSetObservable();
        public int c = 1;

        public c(ArrayList<a> arrayList, ArrayList<a> arrayList2, ListAdapter listAdapter) {
            this.b = listAdapter;
            this.g = listAdapter instanceof Filterable;
            if (arrayList == null) {
                throw new IllegalArgumentException("headerViewInfos cannot be null");
            }
            if (arrayList2 == null) {
                throw new IllegalArgumentException("footerViewInfos cannot be null");
            }
            this.d = arrayList;
            this.e = arrayList2;
            this.f = a(arrayList) && a(this.e);
        }

        public final boolean a(ArrayList<a> arrayList) {
            if (arrayList == null) {
                return true;
            }
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().d) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return this.f && listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int b() {
            return this.e.size();
        }

        public int c() {
            return this.d.size();
        }

        public void e() {
            this.f15968a.notifyChanged();
        }

        public boolean f(View view) {
            boolean z = false;
            for (int i = 0; i < this.e.size(); i++) {
                if (this.e.get(i).f15966a == view) {
                    this.e.remove(i);
                    if (a(this.d) && a(this.e)) {
                        z = true;
                    }
                    this.f = z;
                    this.f15968a.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        public boolean g(View view) {
            boolean z = false;
            for (int i = 0; i < this.d.size(); i++) {
                if (this.d.get(i).f15966a == view) {
                    this.d.remove(i);
                    if (a(this.d) && a(this.e)) {
                        z = true;
                    }
                    this.f = z;
                    this.f15968a.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ListAdapter listAdapter = this.b;
            if (listAdapter == null) {
                return (c() * this.c) + (b() * this.c);
            }
            int count = listAdapter.getCount();
            int i = this.c;
            int i2 = count % i;
            return (c() * this.c) + this.b.getCount() + (i2 == 0 ? 0 : i - i2) + (b() * this.c);
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.g) {
                return ((Filterable) this.b).getFilter();
            }
            return null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int iC = c();
            int i2 = this.c;
            int i3 = iC * i2;
            if (i < i3) {
                if (i % i2 == 0) {
                    return this.d.get(i / i2).c;
                }
                return null;
            }
            if (i < this.b.getCount() + i3) {
                int i4 = i - i3;
                ListAdapter listAdapter = this.b;
                if (listAdapter != null && i4 < listAdapter.getCount()) {
                    return this.b.getItem(i4);
                }
            }
            int count = this.b.getCount();
            int i5 = this.c;
            int i6 = count % i5;
            int i7 = i6 == 0 ? 0 : i5 - i6;
            if (i < this.b.getCount() + i3 + i7) {
                return null;
            }
            if (i >= this.b.getCount() + i3 + i7 + (b() * this.c) || i % this.c != 0) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            return this.e.get((((i - i3) - this.b.getCount()) - i7) / this.c).c;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            int i2;
            int iC = c() * this.c;
            ListAdapter listAdapter = this.b;
            if (listAdapter == null || i < iC || i >= listAdapter.getCount() + iC || (i2 = i - iC) >= this.b.getCount()) {
                return -1L;
            }
            return this.b.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            int iC = c();
            int i2 = this.c;
            int i3 = iC * i2;
            if (i < i3 && i % i2 != 0) {
                ListAdapter listAdapter = this.b;
                if (listAdapter != null) {
                    return listAdapter.getViewTypeCount();
                }
                return 1;
            }
            ListAdapter listAdapter2 = this.b;
            if (listAdapter2 != null && i >= i3 && i < listAdapter2.getCount() + i3 + (this.c - (this.b.getCount() % this.c))) {
                int i4 = i - i3;
                int count = this.b.getCount();
                if (i4 < count) {
                    return this.b.getItemViewType(i4);
                }
                if (count != 0 && this.c != 1) {
                    return this.b.getItemViewType(count - 1);
                }
            }
            int iB = b() * this.c;
            ListAdapter listAdapter3 = this.b;
            if (listAdapter3 == null || i >= i3 + listAdapter3.getCount() + iB) {
                return -2;
            }
            ListAdapter listAdapter4 = this.b;
            if (listAdapter4 != null) {
                return listAdapter4.getViewTypeCount();
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int iC = c();
            int i2 = this.c;
            int i3 = iC * i2;
            if (i < i3) {
                ViewGroup viewGroup2 = this.d.get(i / i2).b;
                if (i % this.c == 0) {
                    return viewGroup2;
                }
                View view2 = new View(viewGroup.getContext());
                view2.setVisibility(4);
                view2.setMinimumHeight(viewGroup2.getHeight());
                return view2;
            }
            if (i < this.b.getCount() + i3) {
                int i4 = i - i3;
                ListAdapter listAdapter = this.b;
                if (listAdapter != null && i4 < listAdapter.getCount()) {
                    View view3 = this.b.getView(i4, view, viewGroup);
                    view3.setVisibility(0);
                    return view3;
                }
            }
            int count = this.b.getCount();
            int i5 = this.c;
            int i6 = count % i5;
            int i7 = i6 != 0 ? i5 - i6 : 0;
            if (i < this.b.getCount() + i3 + i7) {
                View view4 = this.b.getView(r6.getCount() - 1, view, viewGroup);
                view4.setVisibility(4);
                return view4;
            }
            if (i >= this.b.getCount() + i3 + i7 + (b() * this.c)) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            ViewGroup viewGroup3 = this.e.get((((i - i3) - this.b.getCount()) - i7) / this.c).b;
            if (i % this.c == 0) {
                return viewGroup3;
            }
            View view5 = new View(viewGroup.getContext());
            view5.setVisibility(4);
            view5.setMinimumHeight(viewGroup3.getHeight());
            return view5;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount() + 1;
            }
            return 2;
        }

        @Override // android.widget.WrapperListAdapter
        public ListAdapter getWrappedAdapter() {
            return this.b;
        }

        public void h(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            }
            if (this.c != i) {
                this.c = i;
                e();
            }
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return false;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            ListAdapter listAdapter = this.b;
            return (listAdapter == null || listAdapter.isEmpty()) && c() == 0 && b() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            int iC = c();
            int i2 = this.c;
            int i3 = iC * i2;
            if (i < i3) {
                return i % i2 == 0 && this.d.get(i / i2).d;
            }
            if (i < this.b.getCount() + i3) {
                int i4 = i - i3;
                ListAdapter listAdapter = this.b;
                if (listAdapter != null && i4 < listAdapter.getCount()) {
                    return this.b.isEnabled(i4);
                }
            }
            int count = this.b.getCount();
            int i5 = this.c;
            int i6 = count % i5;
            int i7 = i6 == 0 ? 0 : i5 - i6;
            if (i < this.b.getCount() + i3 + i7) {
                return false;
            }
            if (i < this.b.getCount() + i3 + i7 + (b() * this.c)) {
                return i % this.c == 0 && this.e.get((((i - i3) - this.b.getCount()) - i7) / this.c).d;
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f15968a.registerObserver(dataSetObserver);
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f15968a.unregisterObserver(dataSetObserver);
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public HeaderFooterGridView(Context context) {
        super(context);
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mNumColmuns = 1;
        initHeaderGridView();
    }

    private void initHeaderGridView() {
        super.setClipChildren(false);
    }

    private void removeFixedViewInfo(View view, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f15966a == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    public void addFooterView(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null && !(adapter instanceof c)) {
            throw new IllegalStateException("Cannot add footer view to grid -- setAdapter has already been called.");
        }
        a aVar = new a();
        b bVar = new b(getContext());
        bVar.addView(view);
        aVar.f15966a = view;
        aVar.b = bVar;
        aVar.c = obj;
        aVar.d = z;
        this.mFooterViewInfos.add(aVar);
        if (adapter != null) {
            ((c) adapter).e();
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null && !(adapter instanceof c)) {
            throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        }
        a aVar = new a();
        b bVar = new b(getContext());
        bVar.addView(view);
        aVar.f15966a = view;
        aVar.b = bVar;
        aVar.c = obj;
        aVar.d = z;
        this.mHeaderViewInfos.add(aVar);
        if (adapter != null) {
            ((c) adapter).e();
        }
    }

    public int getFooterViewCount() {
        return this.mFooterViewInfos.size();
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    @Override // android.widget.GridView
    @SuppressLint({"NewApi"})
    public int getNumColumns() {
        return super.getNumColumns();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.mRequestedNumColumns;
        if (i3 != -1) {
            this.mNumColmuns = i3;
        }
        if (this.mNumColmuns <= 0) {
            this.mNumColmuns = 1;
        }
        ListAdapter adapter = getAdapter();
        if (adapter == null || !(adapter instanceof c)) {
            return;
        }
        ((c) adapter).h(getNumColumns());
    }

    public boolean removeFooterView(View view) {
        boolean z = false;
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((c) adapter).f(view)) {
                z = true;
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
        }
        return z;
    }

    public boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((c) adapter).g(view)) {
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
        }
        return z;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.mRequestedNumColumns = i;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
            super.setAdapter(listAdapter);
            return;
        }
        c cVar = new c(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        int numColumns = getNumColumns();
        if (numColumns > 1) {
            cVar.h(numColumns);
        }
        super.setAdapter((ListAdapter) cVar);
    }

    public HeaderFooterGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mNumColmuns = 1;
        initHeaderGridView();
    }

    public HeaderFooterGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mNumColmuns = 1;
        initHeaderGridView();
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean z) {
    }
}
