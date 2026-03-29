package com.zenmen.palmchat.conversations.threadsnew.adapter;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.zenmen.palmchat.conversations.threadsnew.adapter.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class RecyclerViewCursorAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements Filterable, a.InterfaceC1038a {
    public boolean e;
    public Cursor f;
    public int g;
    public DataSetObserver h;
    public a i;
    public FilterQueryProvider j;

    public abstract void a(VH vh, Cursor cursor);

    public Cursor b(Cursor cursor) {
        DataSetObserver dataSetObserver;
        Cursor cursor2 = this.f;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null && (dataSetObserver = this.h) != null) {
            cursor2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f = cursor;
        if (cursor != null) {
            DataSetObserver dataSetObserver2 = this.h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.g = cursor.getColumnIndexOrThrow("_id");
            this.e = true;
            notifyDataSetChanged();
        } else {
            this.g = -1;
            this.e = false;
            notifyDataSetChanged();
        }
        return cursor2;
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.adapter.a.InterfaceC1038a
    public void changeCursor(Cursor cursor) {
        Cursor cursorB = b(cursor);
        if (cursorB != null) {
            cursorB.close();
        }
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.adapter.a.InterfaceC1038a
    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.adapter.a.InterfaceC1038a
    public Cursor getCursor() {
        return this.f;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i == null) {
            this.i = new a(this);
        }
        return this.i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Cursor cursor;
        if (!this.e || (cursor = this.f) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.e && (cursor = this.f) != null && cursor.moveToPosition(i)) {
            return this.f.getLong(this.g);
        }
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i) {
        if (!this.e) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f.moveToPosition(i)) {
            a(vh, this.f);
            return;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.adapter.a.InterfaceC1038a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.j;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f;
    }
}
