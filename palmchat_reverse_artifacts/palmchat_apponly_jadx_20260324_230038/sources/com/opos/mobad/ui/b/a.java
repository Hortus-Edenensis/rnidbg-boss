package com.opos.mobad.ui.b;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a implements com.opos.mobad.ui.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ListView f10231a;
    c b;

    /* JADX INFO: renamed from: com.opos.mobad.ui.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0804a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10232a;
        public final String b;

        public C0804a(String str, String str2) {
            this.f10232a = str;
            this.b = str2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f10233a;
        private TextView b;

        public b(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            int iA = com.opos.cmn.an.h.f.a.a(context, 12.0f);
            int iA2 = com.opos.cmn.an.h.f.a.a(context, 24.0f);
            setPadding(iA2, iA, iA2, iA);
            TextView textView = new TextView(getContext());
            this.f10233a = textView;
            textView.setId(View.generateViewId());
            this.f10233a.setTextColor(Color.parseColor("#D9000000"));
            this.f10233a.setTextSize(1, 16.0f);
            this.f10233a.setGravity(17);
            this.f10233a.setGravity(51);
            this.f10233a.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            addView(this.f10233a, layoutParams);
            TextView textView2 = new TextView(getContext());
            this.b = textView2;
            textView2.setTextColor(Color.parseColor("#C4000000"));
            this.b.setTextSize(1, 12.0f);
            this.b.setGravity(17);
            this.b.setGravity(51);
            this.b.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.f10233a.getId());
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(context, 3.0f);
            addView(this.b, layoutParams2);
        }

        public void a(C0804a c0804a) {
            TextView textView;
            int i;
            if (c0804a == null) {
                return;
            }
            this.f10233a.setText(TextUtils.isEmpty(c0804a.f10232a) ? "" : c0804a.f10232a);
            if (TextUtils.isEmpty(c0804a.b)) {
                textView = this.b;
                i = 8;
            } else {
                this.b.setText(c0804a.b);
                textView = this.b;
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<C0804a> f10234a = new ArrayList();

        public void a(List<C0804a> list) {
            this.f10234a.clear();
            this.f10234a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f10234a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f10234a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0804a c0804a = (C0804a) getItem(i);
            d dVarA = d.a(view, viewGroup);
            dVarA.f10235a.a(c0804a);
            return dVarA.f10235a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f10235a;

        private d(b bVar) {
            this.f10235a = bVar;
        }

        public static final d a(View view, View view2) {
            if (view != null) {
                return (d) view.getTag();
            }
            b bVar = new b(view2.getContext());
            d dVar = new d(bVar);
            bVar.setTag(dVar);
            return dVar;
        }
    }

    public a(Context context) {
        ListView listView = new ListView(context);
        this.f10231a = listView;
        listView.setDividerHeight(0);
        c cVar = new c();
        this.b = cVar;
        this.f10231a.setAdapter((ListAdapter) cVar);
    }

    @Override // com.opos.mobad.ui.b.d
    public int a() {
        return 1;
    }

    @Override // com.opos.mobad.ui.b.d
    public View b() {
        return this.f10231a;
    }

    public static List<C0804a> b(Map<String, String> map) {
        com.opos.cmn.an.f.a.b("ComplianceListView", "transformMapToList = " + map);
        ArrayList arrayList = new ArrayList();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new C0804a(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.ui.b.d
    public void a(String str) {
    }

    @Override // com.opos.mobad.ui.b.d
    public void a(Map<String, String> map) {
        this.b.a(b(map));
    }

    @Override // com.opos.mobad.ui.b.d
    public void c() {
    }
}
