package com.zenmen.palmchat.activity.webview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import defpackage.an;
import defpackage.ru;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f12418a;
    public List<ru> b;
    public e c;
    public String d;
    public ru e;
    public TextView f;
    public TextView g;

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.webview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0964a implements AdapterView.OnItemClickListener {
        public C0964a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Iterator it = a.this.b.iterator();
            while (it.hasNext()) {
                ((ru) it.next()).k(false);
            }
            a.this.e = (ru) adapterView.getAdapter().getItem(i);
            a.this.e.k(true);
            ((e) adapterView.getAdapter()).notifyDataSetChanged();
            a.this.f.setEnabled(true);
            a.this.g.setEnabled(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f12418a != null) {
                a.this.f12418a.b(a.this.e);
            }
            a.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f12418a != null) {
                a.this.f12418a.a(a.this.e);
            }
            a.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(ru ruVar);

        void b(ru ruVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ru> f12422a;

        public e(List<ru> list) {
            this.f12422a = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f12422a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f12422a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.f12422a.get(i).hashCode();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = LayoutInflater.from(a.this.getContext()).inflate(R.layout.item_web_share, (ViewGroup) null);
            ((ImageView) viewInflate.findViewById(R.id.img_app_icon)).setImageDrawable(this.f12422a.get(i).a());
            ((TextView) viewInflate.findViewById(R.id.tv_app_name)).setText(this.f12422a.get(i).b().trim());
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_app_selected);
            if (this.f12422a.get(i).f()) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(4);
            }
            return viewInflate;
        }
    }

    public a(Context context, String str) {
        super(context, R.style.commonDialog);
        this.d = str;
        this.b = ru.c(getContext(), this.d);
        this.c = new e(this.b);
    }

    public Dialog g(d dVar) {
        this.f12418a = dVar;
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.web_popup_share, (ViewGroup) null);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = an.b(770);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        setContentView(viewInflate);
        setCancelable(true);
        ListView listView = (ListView) viewInflate.findViewById(R.id.lsv_content);
        this.f = (TextView) viewInflate.findViewById(R.id.tv_always);
        this.g = (TextView) viewInflate.findViewById(R.id.tv_ones);
        listView.setAdapter((ListAdapter) this.c);
        listView.setOnItemClickListener(new C0964a());
        this.f.setOnClickListener(new b());
        this.g.setOnClickListener(new c());
        return this;
    }

    public void h() {
        List<ru> listC = ru.c(getContext(), this.d);
        this.b.clear();
        boolean z = false;
        for (ru ruVar : listC) {
            if (this.e != null && ruVar.d().equals(this.e.d())) {
                z = true;
                ruVar.k(true);
                this.e = ruVar;
            }
            this.b.add(ruVar);
        }
        if (!z) {
            this.e = null;
            this.f.setEnabled(false);
            this.g.setEnabled(false);
        }
        this.c.notifyDataSetChanged();
    }
}
