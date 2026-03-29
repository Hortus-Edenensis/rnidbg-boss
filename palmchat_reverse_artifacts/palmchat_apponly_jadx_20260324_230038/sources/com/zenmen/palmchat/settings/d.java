package com.zenmen.palmchat.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15297a;
    public LayoutInflater b;
    public ArrayList<a> c;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15298a;
        public String b;
        public boolean c;

        public a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f15299a;

        public b() {
        }
    }

    public d(Context context, ArrayList<a> arrayList) {
        this.f15297a = context;
        this.c = arrayList;
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.b.inflate(R.layout.layout_sound_item, (ViewGroup) null);
            bVar = new b();
            bVar.f15299a = (TextView) view.findViewById(R.id.itemTv);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        a aVar = this.c.get(i);
        bVar.f15299a.setText(aVar.b);
        if (aVar.c) {
            bVar.f15299a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f15297a.getResources().getDrawable(R.drawable.icon_gender_item_select), (Drawable) null);
        } else {
            bVar.f15299a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }
}
