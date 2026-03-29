package com.zenmen.palmchat.chat.imp.BigText;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.imp.BigText.c;
import com.zenmen.palmchat.chat.imp.BigText.d;
import com.zenmen.palmchat.chat.imp.BigText.e;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g03;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.me1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.v02;
import defpackage.vs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FontPageAdapter extends PagerAdapter {
    public static String l = "FontPageAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12876a;
    public BigTextViewPager b;
    public d c;
    public e.b d;
    public v02 g;
    public d h;
    public GridView i;
    public int f = 0;
    public View j = null;
    public c.a k = new c();
    public List<v02> e = vs.b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridView f12877a;

        public a(GridView gridView) {
            this.f12877a = gridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            v02 v02Var = (v02) this.f12877a.getAdapter().getItem(i);
            FontPageAdapter.this.g = v02Var;
            LogUtil.i(FontPageAdapter.l, "onItemClick, selectedID = " + v02Var.f21335a);
            FontPageAdapter.this.h = (d) this.f12877a.getAdapter();
            if (v02Var.f21335a == 0) {
                FontPageAdapter.this.h.c(0);
                FontPageAdapter.this.d.a(FontPageAdapter.this.g, null);
                FontPageAdapter.this.f = v02Var.f21335a;
                return;
            }
            String strB = com.zenmen.palmchat.chat.imp.BigText.c.b(v02Var);
            if (strB == null) {
                if (FontPageAdapter.this.j == null) {
                    FontPageAdapter.this.v(view);
                    return;
                } else {
                    if (FontPageAdapter.this.j == view) {
                        return;
                    }
                    sy5.e(FontPageAdapter.this.f12876a, R.string.font_downloading, 0).g();
                    return;
                }
            }
            LogUtil.i(FontPageAdapter.l, "fontfile exist, name = " + v02Var.b);
            FontPageAdapter.this.h.c(v02Var.f21335a);
            FontPageAdapter.this.d.a(FontPageAdapter.this.g, strB);
            FontPageAdapter.this.f = v02Var.f21335a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12878a;

        public b(View view) {
            this.f12878a = view;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (!hx3.n()) {
                sy5.e(FontPageAdapter.this.f12876a, R.string.default_response_error, 0).g();
                return;
            }
            FontPageAdapter.this.j = this.f12878a;
            com.zenmen.palmchat.chat.imp.BigText.c.d().a(FontPageAdapter.this.f12876a, FontPageAdapter.this.g, FontPageAdapter.this.k);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements c.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f12880a;

            public a(int i) {
                this.f12880a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a aVarA = FontPageAdapter.this.h.a(this.f12880a);
                if (aVarA != null) {
                    aVarA.d.setVisibility(0);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f12881a;
            public final /* synthetic */ String b;

            public b(int i, String str) {
                this.f12881a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                FontPageAdapter.this.h.a(this.f12881a);
                if (FontPageAdapter.this.h != null) {
                    FontPageAdapter.this.h.c(this.f12881a);
                }
                FontPageAdapter.this.f = this.f12881a;
                FontPageAdapter.this.d.a(FontPageAdapter.this.g, com.zenmen.palmchat.chat.imp.BigText.c.c(this.b));
                FontPageAdapter.this.j = null;
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.imp.BigText.FontPageAdapter$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0996c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f12882a;
            public final /* synthetic */ int b;

            public RunnableC0996c(int i, int i2) {
                this.f12882a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a aVarA = FontPageAdapter.this.h.a(this.f12882a);
                if (aVarA != null) {
                    aVarA.d.setProgress(this.b);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f12883a;

            public d(int i) {
                this.f12883a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a aVarA = FontPageAdapter.this.h.a(this.f12883a);
                if (aVarA != null) {
                    aVarA.d.setVisibility(8);
                }
                sy5.f(FontPageAdapter.this.f12876a, FontPageAdapter.this.f12876a.getResources().getString(R.string.font_download_fail), 0).g();
                FontPageAdapter.this.j = null;
            }
        }

        public c() {
        }

        @Override // com.zenmen.palmchat.chat.imp.BigText.c.a
        public void a(Exception exc, int i) {
            LogUtil.i(FontPageAdapter.l, "onDownloadFail e = " + exc.toString() + ", id = " + i);
            if (FontPageAdapter.this.f12876a instanceof Activity) {
                ((Activity) FontPageAdapter.this.f12876a).runOnUiThread(new d(i));
            }
        }

        @Override // com.zenmen.palmchat.chat.imp.BigText.c.a
        public void b(int i, String str) {
            LogUtil.i(FontPageAdapter.l, "onDownloadingComplete id =" + i + ", path = " + str);
            if (FontPageAdapter.this.f12876a instanceof Activity) {
                ((Activity) FontPageAdapter.this.f12876a).runOnUiThread(new b(i, str));
            }
        }

        @Override // com.zenmen.palmchat.chat.imp.BigText.c.a
        public void c(int i, int i2) {
            LogUtil.i(FontPageAdapter.l, "onDownloading progress =" + i);
            if (FontPageAdapter.this.f12876a instanceof Activity) {
                ((Activity) FontPageAdapter.this.f12876a).runOnUiThread(new RunnableC0996c(i2, i));
            }
        }

        @Override // com.zenmen.palmchat.chat.imp.BigText.c.a
        public void d(int i) {
            LogUtil.i(FontPageAdapter.l, "onDownloadingStarted id= " + i);
            if (FontPageAdapter.this.f12876a instanceof Activity) {
                ((Activity) FontPageAdapter.this.f12876a).runOnUiThread(new a(i));
            }
        }
    }

    public FontPageAdapter(Context context, BigTextViewPager bigTextViewPager, e.b bVar) {
        this.f12876a = context;
        this.b = bigTextViewPager;
        this.d = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        Runtime.getRuntime().gc();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.e != null) {
            return (int) Math.ceil(r0.size() / 6.0f);
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int i2;
        GridView gridView = new GridView(this.f12876a);
        gridView.setCacheColorHint(this.f12876a.getResources().getColor(android.R.color.transparent));
        gridView.setSelector(android.R.color.transparent);
        gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int iS = s(2, me1.b(this.f12876a, 85));
        gridView.setPadding(me1.b(this.f12876a, 10), iS, me1.b(this.f12876a, 10), iS);
        gridView.setVerticalSpacing(iS);
        gridView.setNumColumns(3);
        ArrayList arrayList = new ArrayList();
        List<v02> list = this.e;
        if (list != null && list.size() > 0) {
            LogUtil.i(l, "currentFontConfigs size = " + this.e.size() + ", pageCount = " + getCount());
            int i3 = i * 6;
            int i4 = (i + 1) * 6;
            if (i == 0) {
                arrayList.add(new v02(0, "默认", null, null));
                i2 = 1;
            } else {
                i2 = 0;
            }
            for (int i5 = 0; i5 < this.e.size(); i5++) {
                if (i == 0) {
                    if (i2 >= i3 && i2 < i4) {
                        arrayList.add(this.e.get(i5));
                        LogUtil.i(l, "currentFontConfigs index = " + i2 + "; i = " + i5 + ", position = " + i);
                    }
                } else if (i == getCount() - 1) {
                    if (i2 >= i3 - 1 && i2 < i4) {
                        arrayList.add(this.e.get(i5));
                        LogUtil.i(l, "currentFontConfigs index = " + i2 + "; i = " + i5 + ", position = " + i);
                    }
                } else if (i2 >= i3 - 1 && i2 < i4 - 1) {
                    arrayList.add(this.e.get(i5));
                    LogUtil.i(l, "currentFontConfigs index = " + i2 + "; i = " + i5 + ", position = " + i);
                }
                i2++;
            }
            LogUtil.i(l, "currentPageConfigs size = " + arrayList.size() + ", position = " + i);
        }
        this.i = gridView;
        d dVar = new d(this.f12876a, arrayList, this.d, i, gridView);
        this.c = dVar;
        gridView.setAdapter((ListAdapter) dVar);
        this.c.e(this.f);
        gridView.setOnItemClickListener(new a(gridView));
        viewGroup.addView(gridView);
        return gridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        for (int i = 0; i < this.b.getChildCount(); i++) {
            this.b.getChildAt(i).requestLayout();
        }
    }

    public final View r() {
        View viewInflate = LayoutInflater.from(this.f12876a).inflate(R.layout.font_dialog, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.font_dialog_img);
        TextView textView = (TextView) viewInflate.findViewById(R.id.font_dialog_text);
        gr2.j().g(this.g.c, imageView);
        textView.setText(this.g.b + "字体包大约" + this.g.d);
        return viewInflate;
    }

    public final int s(int i, int i2) {
        int iD = g03.d() - ((int) (this.f12876a.getResources().getDimension(R.dimen.expression_pager_indicator) + me1.b(com.zenmen.palmchat.c.b(), 1)));
        if (iD != 0) {
            return (iD - (i2 * i)) / (i + 1);
        }
        return 0;
    }

    public void t(int i) {
        LogUtil.i(l, "onPageSelected, selected = " + this.f + ", pageIndex = " + i);
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            GridView gridView = (GridView) this.b.getChildAt(i2);
            this.i = gridView;
            d dVar = (d) gridView.getAdapter();
            this.h = dVar;
            dVar.c(this.f);
        }
    }

    public void u(int i) {
        this.f = i;
    }

    public final void v(View view) {
        if (this.g == null) {
            return;
        }
        new sd3(this.f12876a).p(r(), false).N(R.color.material_dialog_positive_color).K(R.string.alert_dialog_cancel).O(R.string.font_dialog_download).f(new b(view)).e().show();
    }
}
