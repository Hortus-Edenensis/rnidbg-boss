package com.zenmen.square.comment.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zenmen.square.R$color;
import com.zenmen.square.R$dimen;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$style;
import defpackage.me1;
import defpackage.pe6;
import defpackage.tn;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16208a;
    public d b;
    public ListView c;
    public List<c> d;
    public b e;
    public int f;

    /* JADX INFO: renamed from: com.zenmen.square.comment.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1154a implements AdapterView.OnItemClickListener {
        public C1154a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.this.dismiss();
            c item = a.this.e.getItem(i);
            if (a.this.b != null) {
                a.this.b.a(a.this, item);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BaseAdapter {
        public b() {
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c getItem(int i) {
            if (i < getCount()) {
                return (c) a.this.d.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (a.this.d != null) {
                return a.this.d.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (getItem(i) != null ? Integer.valueOf(r3.f16211a) : null).intValue();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            TextView textView;
            if (view == null) {
                textView = new TextView(viewGroup.getContext());
                textView.setTextColor(-13421773);
                textView.setIncludeFontPadding(false);
                textView.setCompoundDrawablePadding(me1.b(viewGroup.getContext(), 14));
                if (a.this.f == 1) {
                    textView.setTextSize(18.0f);
                    textView.setHeight(a.this.f16208a + a.this.f16208a + tn.b(a.this.getContext(), 18));
                    textView.setGravity(17);
                } else if (a.this.f == 0) {
                    textView.setTextSize(16.0f);
                    textView.setGravity(16);
                    textView.setPadding(tn.b(a.this.getContext(), 24), a.this.f16208a, a.this.f16208a, a.this.f16208a);
                }
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                view2 = textView;
            } else {
                view2 = view;
                textView = (TextView) view;
            }
            c item = getItem(i);
            if (item.c == 0) {
                textView.setTextColor(pe6.b(a.this.getContext(), R$color.square_color_ff222222));
            } else if (item.c == 1) {
                textView.setTextColor(pe6.b(a.this.getContext(), R$color.square_color_green));
            } else if (item.c == 2) {
                textView.setTextColor(pe6.b(a.this.getContext(), R$color.square_color_FFFF8300));
            } else if (item.c == 3) {
                textView.setTextColor(pe6.b(a.this.getContext(), R$color.square_color_red));
            } else if (item.c == 4) {
                textView.setTextColor(pe6.b(a.this.getContext(), R$color.square_color_FF939393));
            }
            textView.setText(getItem(i).b);
            textView.setCompoundDrawablesWithIntrinsicBounds(getItem(i).e, 0, 0, 0);
            if (item.f() > 0) {
                textView.setTextSize(item.f());
            }
            getCount();
            textView.setBackgroundResource(R$drawable.square_md_btn_selector_ripple);
            return view2;
        }

        public /* synthetic */ b(a aVar, C1154a c1154a) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16211a;
        public String b;
        public int c;
        public int d;
        public int e;

        public c(int i, String str, int i2) {
            this.f16211a = i;
            this.b = str;
            this.e = i2;
        }

        public int e() {
            return this.f16211a;
        }

        public int f() {
            return this.d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(a aVar, c cVar);
    }

    public a(Context context) {
        super(context, R$style.square_dialog_theme_style);
    }

    public void f(List<c> list) {
        this.d = list;
        b bVar = this.e;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void g(d dVar) {
        this.b = dVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16208a = tn.b(getContext(), 15);
        Window window = getWindow();
        window.setDimAmount(0.6f);
        C1154a c1154a = null;
        if (this.f != 1) {
            window.setGravity(17);
            View viewInflate = View.inflate(getContext(), R$layout.square_menu_dialog, null);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(getContext().getResources().getDimension(R$dimen.square_feed_dp_4));
            gradientDrawable.setColor(pe6.b(getContext(), R$color.square_white));
            viewInflate.setBackgroundDrawable(gradientDrawable);
            setContentView(viewInflate);
        }
        tn.h(getContext());
        window.setAttributes(window.getAttributes());
        getWindow().setBackgroundDrawableResource(R$drawable.square_wid_bg);
        ListView listView = (ListView) findViewById(R$id.menuList);
        this.c = listView;
        listView.setOnItemClickListener(new C1154a());
        ListView listView2 = this.c;
        b bVar = new b(this, c1154a);
        this.e = bVar;
        listView2.setAdapter((ListAdapter) bVar);
    }
}
