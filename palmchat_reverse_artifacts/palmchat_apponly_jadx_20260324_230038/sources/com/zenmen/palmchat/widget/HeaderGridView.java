package com.zenmen.palmchat.widget;

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
public class HeaderGridView extends GridView {
    private static final String TAG = "HeaderGridView";
    private ArrayList<a> mHeaderViewInfos;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f15969a;
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
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft()) - HeaderGridView.this.getPaddingRight(), View.MeasureSpec.getMode(i)), i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements WrapperListAdapter, Filterable {
        public final ListAdapter b;
        public ArrayList<a> d;
        public boolean e;
        public final boolean f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataSetObservable f15971a = new DataSetObservable();
        public int c = 1;

        public c(ArrayList<a> arrayList, ListAdapter listAdapter) {
            this.b = listAdapter;
            this.f = listAdapter instanceof Filterable;
            if (arrayList == null) {
                throw new IllegalArgumentException("headerViewInfos cannot be null");
            }
            this.d = arrayList;
            this.e = a(arrayList);
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
                return this.e && listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int b() {
            return this.d.size();
        }

        public void c() {
            this.f15971a.notifyChanged();
        }

        public boolean e(View view) {
            for (int i = 0; i < this.d.size(); i++) {
                if (this.d.get(i).f15969a == view) {
                    this.d.remove(i);
                    this.e = a(this.d);
                    this.f15971a.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        public void f(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            }
            if (this.c != i) {
                this.c = i;
                c();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b != null ? (b() * this.c) + this.b.getCount() : b() * this.c;
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.f) {
                return ((Filterable) this.b).getFilter();
            }
            return null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int iB = b();
            int i2 = this.c;
            int i3 = iB * i2;
            if (i < i3) {
                if (i % i2 == 0) {
                    return this.d.get(i / i2).c;
                }
                return null;
            }
            int i4 = i - i3;
            ListAdapter listAdapter = this.b;
            if (listAdapter == null || i4 >= listAdapter.getCount()) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            return this.b.getItem(i4);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            int i2;
            int iB = b() * this.c;
            ListAdapter listAdapter = this.b;
            if (listAdapter == null || i < iB || (i2 = i - iB) >= listAdapter.getCount()) {
                return -1L;
            }
            return this.b.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            int i2;
            int iB = b();
            int i3 = this.c;
            int i4 = iB * i3;
            if (i < i4 && i % i3 != 0) {
                ListAdapter listAdapter = this.b;
                if (listAdapter != null) {
                    return listAdapter.getViewTypeCount();
                }
                return 1;
            }
            ListAdapter listAdapter2 = this.b;
            if (listAdapter2 == null || i < i4 || (i2 = i - i4) >= listAdapter2.getCount()) {
                return -2;
            }
            return this.b.getItemViewType(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int iB = b();
            int i2 = this.c;
            int i3 = iB * i2;
            if (i >= i3) {
                int i4 = i - i3;
                ListAdapter listAdapter = this.b;
                if (listAdapter == null || i4 >= listAdapter.getCount()) {
                    throw new ArrayIndexOutOfBoundsException(i);
                }
                return this.b.getView(i4, view, viewGroup);
            }
            ViewGroup viewGroup2 = this.d.get(i / i2).b;
            if (i % this.c == 0) {
                return viewGroup2;
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            view.setMinimumHeight(viewGroup2.getHeight());
            return view;
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
            return (listAdapter == null || listAdapter.isEmpty()) && b() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            int iB = b();
            int i2 = this.c;
            int i3 = iB * i2;
            if (i < i3) {
                return i % i2 == 0 && this.d.get(i / i2).d;
            }
            int i4 = i - i3;
            ListAdapter listAdapter = this.b;
            if (listAdapter == null || i4 >= listAdapter.getCount()) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            return this.b.isEnabled(i4);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f15971a.registerObserver(dataSetObserver);
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f15971a.unregisterObserver(dataSetObserver);
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public HeaderGridView(Context context) {
        super(context);
        this.mHeaderViewInfos = new ArrayList<>();
        initHeaderGridView();
    }

    private void initHeaderGridView() {
        super.setClipChildren(false);
    }

    private void removeFixedViewInfo(View view, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f15969a == view) {
                arrayList.remove(i);
                return;
            }
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
        aVar.f15969a = view;
        aVar.b = bVar;
        aVar.c = obj;
        aVar.d = z;
        this.mHeaderViewInfos.add(aVar);
        if (adapter != null) {
            ((c) adapter).c();
        }
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter == null || !(adapter instanceof c)) {
            return;
        }
        ((c) adapter).f(getNumColumns());
    }

    public boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((c) adapter).e(view)) {
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
        }
        return z;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.mHeaderViewInfos.size() <= 0) {
            super.setAdapter(listAdapter);
            return;
        }
        c cVar = new c(this.mHeaderViewInfos, listAdapter);
        int numColumns = getNumColumns();
        if (numColumns > 1) {
            cVar.f(numColumns);
        }
        super.setAdapter((ListAdapter) cVar);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeaderViewInfos = new ArrayList<>();
        initHeaderGridView();
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeaderViewInfos = new ArrayList<>();
        initHeaderGridView();
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean z) {
    }
}
