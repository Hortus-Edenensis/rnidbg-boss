package com.zenmen.palmchat.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<AddressInfo> f15260a;
    public Context b;
    public int c;
    public ContactInfoItem d;
    public b e;

    /* JADX INFO: renamed from: com.zenmen.palmchat.settings.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1103a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AddressInfo f15261a;

        public ViewOnClickListenerC1103a(AddressInfo addressInfo) {
            this.f15261a = addressInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.e != null) {
                a.this.e.S0(this.f15261a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void S0(AddressInfo addressInfo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f15262a;
        public TextView b;
        public TextView c;
        public View d;
        public View e;
        public View f;
        public View g;

        public c() {
        }
    }

    public a(Context context, ArrayList<AddressInfo> arrayList, int i, ContactInfoItem contactInfoItem, b bVar) {
        this.b = context;
        this.f15260a = arrayList;
        this.c = i;
        this.d = contactInfoItem;
        this.e = bVar;
    }

    public String b() {
        int i = this.c;
        if (i == 0) {
            return this.d.getCountry();
        }
        if (i == 1) {
            return this.d.getProvince();
        }
        if (i == 2) {
            return this.d.getCity();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f15260a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f15260a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        c cVar;
        ArrayList<AddressInfo> arrayList;
        if (view == null) {
            cVar = new c();
            viewInflate = LayoutInflater.from(this.b).inflate(R.layout.layout_item_address, (ViewGroup) null);
            cVar.b = (TextView) viewInflate.findViewById(R.id.address);
            cVar.c = (TextView) viewInflate.findViewById(R.id.selectView);
            cVar.f15262a = (TextView) viewInflate.findViewById(R.id.cate);
            cVar.d = viewInflate.findViewById(R.id.layout);
            cVar.e = viewInflate.findViewById(R.id.sep);
            cVar.f = viewInflate.findViewById(R.id.space);
            cVar.g = viewInflate.findViewById(R.id.spaceTop);
            viewInflate.setTag(cVar);
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        AddressInfo addressInfo = this.f15260a.get(i);
        boolean zEquals = addressInfo.key.equals(b());
        if (zEquals) {
            cVar.c.setVisibility(0);
        } else {
            cVar.c.setVisibility(8);
        }
        if (i == 0) {
            if (this.c == 0) {
                cVar.f15262a.setVisibility(0);
                cVar.g.setVisibility(8);
                if (!zEquals || (arrayList = addressInfo.childList) == null || arrayList.size() <= 0) {
                    cVar.f.setVisibility(8);
                } else {
                    cVar.f.setVisibility(0);
                    cVar.e.setVisibility(8);
                }
            } else {
                cVar.g.setVisibility(0);
                cVar.f15262a.setVisibility(8);
                cVar.f.setVisibility(8);
            }
        } else if (i == this.f15260a.size() - 1) {
            cVar.f.setVisibility(0);
            cVar.f15262a.setVisibility(8);
            cVar.g.setVisibility(8);
        } else {
            cVar.g.setVisibility(8);
            cVar.f15262a.setVisibility(8);
            cVar.f.setVisibility(8);
        }
        cVar.b.setText(addressInfo.name);
        cVar.d.setOnClickListener(new ViewOnClickListenerC1103a(addressInfo));
        return viewInflate;
    }
}
