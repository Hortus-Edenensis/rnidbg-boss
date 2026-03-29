package com.beizi.ad.internal.download;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.ad.lance.a.j;
import com.beizi.fusion.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends BaseExpandableListAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4402a;
    private List<com.beizi.ad.internal.download.b> b;

    /* JADX INFO: renamed from: com.beizi.ad.internal.download.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0116a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f4403a;
        BeiZiWebView b;

        public C0116a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f4404a;
        ImageView b;
        View c;

        public b() {
        }
    }

    public a(Context context, List<com.beizi.ad.internal.download.b> list) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f4402a = context;
        arrayList.clear();
        this.b.addAll(list);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.b.get(i).c();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f4402a).inflate(R.layout.beizi_download_dialog_expand_child_item, (ViewGroup) null);
        C0116a c0116a = new C0116a();
        c0116a.f4403a = (TextView) viewInflate.findViewById(R.id.beizi_addeci_content_tv);
        c0116a.b = (BeiZiWebView) viewInflate.findViewById(R.id.beizi_addeci_content_wb);
        viewInflate.setTag(c0116a);
        if ("text".equals(this.b.get(i).b())) {
            c0116a.f4403a.setVisibility(0);
            c0116a.b.setVisibility(8);
            c0116a.f4403a.setText(this.b.get(i).c());
        } else if ("h5".equals(this.b.get(i).b())) {
            c0116a.f4403a.setVisibility(8);
            c0116a.b.setVisibility(0);
            c0116a.b.loadUrl(this.b.get(i).c(), j.a());
        }
        return viewInflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f4402a).inflate(R.layout.beizi_download_dialog_expand_parent_item, (ViewGroup) null);
            bVar = new b();
            bVar.f4404a = (TextView) view.findViewById(R.id.beizi_addep_title_tv);
            bVar.b = (ImageView) view.findViewById(R.id.beizi_addep_fold_iv);
            bVar.c = view.findViewById(R.id.beizi_addep_item_divider_view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f4404a.setText(this.b.get(i).a());
        if (z) {
            bVar.f4404a.setTextColor(Color.parseColor("#FF8E15"));
            bVar.b.setBackgroundResource(R.mipmap.beizi_icon_arrow_unfold);
        } else {
            bVar.f4404a.setTextColor(Color.parseColor("#333333"));
            bVar.b.setBackgroundResource(R.mipmap.beizi_icon_arrow_fold);
        }
        if (i == 0) {
            bVar.c.setVisibility(8);
        } else {
            bVar.c.setVisibility(0);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
