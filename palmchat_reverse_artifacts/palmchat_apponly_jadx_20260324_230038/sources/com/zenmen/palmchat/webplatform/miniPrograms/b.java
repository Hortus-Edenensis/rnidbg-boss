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
import com.zenmen.palmchat.webplatform.R$string;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class b extends BaseAdapter {
    public LayoutInflater b;
    public Context c;
    public View.OnClickListener d;
    public View.OnLongClickListener e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15957a = "MiniProgramsMainAdapter";
    public List<Package> f = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d.onClick(view);
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.miniPrograms.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnLongClickListenerC1141b implements View.OnLongClickListener {
        public ViewOnLongClickListenerC1141b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return b.this.e.onLongClick(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f15960a;
        public TextView b;
        public View c;
        public View d;
        public int e;
        public ImageView f;

        public c() {
        }
    }

    public b(Context context, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        this.c = context;
        this.b = LayoutInflater.from(context);
        this.d = onClickListener;
        this.e = onLongClickListener;
    }

    public void c(List<Package> list) {
        LogUtil.i("MiniProgramsMainAdapter", "setData size = " + list.size());
        this.f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f.size() + 1;
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
        c cVar;
        if (view == null) {
            cVar = new c();
            viewInflate = this.b.inflate(R$layout.layout_activity_miniprograms_itme, (ViewGroup) null);
            cVar.f15960a = (ImageView) viewInflate.findViewById(R$id.mini_program_item_icon);
            cVar.b = (TextView) viewInflate.findViewById(R$id.mini_program_item_name);
            cVar.c = viewInflate.findViewById(R$id.divider);
            cVar.d = viewInflate.findViewById(R$id.divider_line);
            cVar.f = (ImageView) viewInflate.findViewById(R$id.mini_more);
            viewInflate.setTag(cVar);
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        cVar.e = i;
        if (i == 0) {
            cVar.f15960a.setVisibility(8);
            cVar.c.setVisibility(0);
            cVar.d.setVisibility(8);
            cVar.b.setText(this.c.getResources().getString(R$string.mini_program_nearby));
            cVar.f.setVisibility(0);
        } else {
            cVar.f15960a.setVisibility(0);
            cVar.c.setVisibility(8);
            cVar.f.setVisibility(8);
            cVar.d.setVisibility(0);
            int i2 = i - 1;
            cVar.b.setText(this.f.get(i2).name);
            je1.a aVarU = new je1.a().s(true).t(true).u(true);
            int i3 = R$drawable.media_pick_grid_item_background;
            je1 je1VarR = aVarU.B(i3).A(i3).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
            String str = this.f.get(i2).icon;
            LogUtil.i("MiniProgramsListAdapter", "icon url = " + str);
            gr2.j().h(k86.p(str), cVar.f15960a, je1VarR);
        }
        viewInflate.setOnClickListener(new a());
        if (i < 1) {
            viewInflate.setOnLongClickListener(null);
        } else {
            viewInflate.setOnLongClickListener(new ViewOnLongClickListenerC1141b());
        }
        return viewInflate;
    }
}
