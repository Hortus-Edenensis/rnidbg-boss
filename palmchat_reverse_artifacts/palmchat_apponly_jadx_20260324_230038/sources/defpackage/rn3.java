package defpackage;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rn3 extends BaseAdapter implements SectionIndexer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ListAdapter> f20511a = new ArrayList<>();
    public a b = new a();
    public HashSet<ListAdapter> c = new HashSet<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends DataSetObserver {
        @Override // android.database.DataSetObserver
        public void onChanged() {
            rn3.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            rn3.this.notifyDataSetInvalidated();
        }

        public a() {
        }
    }

    public void a(ListAdapter listAdapter) {
        this.f20511a.add(listAdapter);
        listAdapter.registerDataSetObserver(this.b);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int count = 0;
        for (ListAdapter listAdapter : this.f20511a) {
            if (!this.c.contains(listAdapter)) {
                count += listAdapter.getCount();
            }
        }
        return count;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        for (ListAdapter listAdapter : this.f20511a) {
            if (!this.c.contains(listAdapter)) {
                int count = listAdapter.getCount();
                if (i < count) {
                    return listAdapter.getItem(i);
                }
                i -= count;
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        for (ListAdapter listAdapter : this.f20511a) {
            if (!this.c.contains(listAdapter)) {
                int count = listAdapter.getCount();
                if (i < count) {
                    return listAdapter.getItemId(i);
                }
                i -= count;
            }
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int viewTypeCount;
        int i2 = 0;
        for (ListAdapter listAdapter : this.f20511a) {
            if (this.c.contains(listAdapter)) {
                viewTypeCount = listAdapter.getViewTypeCount();
            } else {
                int count = listAdapter.getCount();
                if (i < count) {
                    return i2 + listAdapter.getItemViewType(i);
                }
                i -= count;
                viewTypeCount = listAdapter.getViewTypeCount();
            }
            i2 += viewTypeCount;
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        int count = 0;
        for (ListAdapter listAdapter : this.f20511a) {
            if (!this.c.contains(listAdapter)) {
                if (listAdapter instanceof SectionIndexer) {
                    SectionIndexer sectionIndexer = (SectionIndexer) listAdapter;
                    Object[] sections = sectionIndexer.getSections();
                    int length = sections != null ? sections.length : 0;
                    if (i < length) {
                        return count + sectionIndexer.getPositionForSection(i);
                    }
                    if (sections != null) {
                        i -= length;
                    }
                }
                count += listAdapter.getCount();
            }
        }
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        Object[] sections;
        int length = 0;
        for (ListAdapter listAdapter : this.f20511a) {
            if (!this.c.contains(listAdapter)) {
                int count = listAdapter.getCount();
                if (i < count) {
                    if (listAdapter instanceof SectionIndexer) {
                        return length + ((SectionIndexer) listAdapter).getSectionForPosition(i);
                    }
                    return 0;
                }
                if ((listAdapter instanceof SectionIndexer) && (sections = ((SectionIndexer) listAdapter).getSections()) != null) {
                    length += sections.length;
                }
                i -= count;
            }
        }
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        Object[] sections;
        ArrayList arrayList = new ArrayList();
        Iterator<ListAdapter> it = this.f20511a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ListAdapter next = it.next();
            if (!this.c.contains(next) && (next instanceof SectionIndexer) && (sections = ((SectionIndexer) next).getSections()) != null) {
                for (Object obj : sections) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList.toArray(new Object[0]);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        for (ListAdapter listAdapter : this.f20511a) {
            if (!this.c.contains(listAdapter)) {
                int count = listAdapter.getCount();
                if (i < count) {
                    return listAdapter.getView(i, view, viewGroup);
                }
                i -= count;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        Iterator<ListAdapter> it = this.f20511a.iterator();
        int viewTypeCount = 0;
        while (it.hasNext()) {
            viewTypeCount += it.next().getViewTypeCount();
        }
        return Math.max(viewTypeCount, 1);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        for (ListAdapter listAdapter : this.f20511a) {
            if (!this.c.contains(listAdapter)) {
                int count = listAdapter.getCount();
                if (i < count) {
                    return listAdapter.isEnabled(i);
                }
                i -= count;
            }
        }
        return false;
    }
}
