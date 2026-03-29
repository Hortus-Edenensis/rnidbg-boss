package com.zenmen.palmchat.webplatform.miniPrograms;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.R$drawable;
import com.zenmen.palmchat.webplatform.R$id;
import com.zenmen.palmchat.webplatform.R$layout;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a extends BaseAdapter {
    public LayoutInflater b;
    public Context c;
    public View.OnClickListener d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15954a = "MiniProgramsListAdapter";
    public List<Package> e = new ArrayList();

    /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.miniPrograms.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1140a implements View.OnClickListener {
        public ViewOnClickListenerC1140a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.d.onClick(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f15956a;
        public TextView b;
        public TextView c;
        public View d;
        public int e;

        public b() {
        }
    }

    public a(Context context, View.OnClickListener onClickListener) {
        this.c = context;
        this.b = LayoutInflater.from(context);
        this.d = onClickListener;
    }

    public void b(List<Package> list) {
        LogUtil.i("MiniProgramsListAdapter", "setData size = " + list.size());
        this.e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        if (view == null) {
            bVar = new b();
            viewInflate = this.b.inflate(R$layout.layout_activity_miniprograms_list_itme, (ViewGroup) null);
            bVar.f15956a = (ImageView) viewInflate.findViewById(R$id.mini_program_item_icon);
            bVar.b = (TextView) viewInflate.findViewById(R$id.mini_program_item_name);
            bVar.c = (TextView) viewInflate.findViewById(R$id.mini_program_item_des);
            bVar.d = viewInflate.findViewById(R$id.divider_line);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        bVar.e = i;
        je1.a aVarU = new je1.a().s(true).t(true).u(true);
        int i2 = R$drawable.media_pick_grid_item_background;
        je1 je1VarR = aVarU.B(i2).A(i2).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        String str = this.e.get(i).icon;
        LogUtil.i("MiniProgramsListAdapter", "icon url = " + str);
        gr2.j().h(k86.p(str), bVar.f15956a, je1VarR);
        bVar.b.setText(this.e.get(i).name);
        bVar.c.setText(this.e.get(i).description);
        viewInflate.setOnClickListener(new ViewOnClickListenerC1140a());
        return viewInflate;
    }
}
