package com.zenmen.palmchat.login.countrycode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.login.countrycode.b;
import defpackage.eo0;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<b.a> f14461a;

    /* JADX INFO: renamed from: com.zenmen.palmchat.login.countrycode.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1070a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f14462a;
        public LinearLayout b;
        public TextView c;

        public C1070a() {
        }
    }

    public a(ArrayList<b.a> arrayList) {
        this.f14461a = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14461a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f14461a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1070a c1070a;
        if (view == null) {
            view = LayoutInflater.from(AppContext.getContext()).inflate(R.layout.list_item_country_code, (ViewGroup) null);
        }
        if (view.getTag() == null) {
            c1070a = new C1070a();
            c1070a.f14462a = (TextView) view.findViewById(R.id.original_name);
            c1070a.b = (LinearLayout) view.findViewById(R.id.group_area);
            c1070a.c = (TextView) view.findViewById(R.id.group_indicator);
        } else {
            c1070a = (C1070a) view.getTag();
        }
        b.a aVar = this.f14461a.get(i);
        if (aVar == null) {
            c1070a.f14462a.setVisibility(8);
            c1070a.b.setVisibility(8);
        } else if (AppContext.getContext().getResources().getConfiguration().locale.getCountry().equals("CN")) {
            c1070a.f14462a.setText(aVar.f14464a);
            if (i == 0) {
                c1070a.b.setVisibility(0);
                if (aVar.d.charAt(0) == 8593) {
                    c1070a.c.setText(AppContext.getContext().getString(R.string.country_code_default));
                } else {
                    c1070a.c.setText(Character.toString(eo0.a(aVar.d.charAt(0))));
                }
            } else if (eo0.a(this.f14461a.get(i - 1).d.charAt(0)) == aVar.d.charAt(0)) {
                c1070a.b.setVisibility(8);
            } else {
                c1070a.b.setVisibility(0);
                c1070a.c.setText(Character.toString(eo0.a(aVar.d.charAt(0))));
            }
        } else {
            c1070a.f14462a.setText(aVar.c);
            if (i != 0 && eo0.a(this.f14461a.get(i - 1).c.charAt(0)) == aVar.c.charAt(0)) {
                c1070a.b.setVisibility(8);
            } else {
                c1070a.b.setVisibility(0);
                c1070a.c.setText(Character.toString(eo0.a(aVar.c.charAt(0))));
            }
        }
        return view;
    }
}
