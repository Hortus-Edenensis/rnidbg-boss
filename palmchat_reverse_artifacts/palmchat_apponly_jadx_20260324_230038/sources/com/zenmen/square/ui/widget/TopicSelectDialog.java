package com.zenmen.square.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.R$style;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.topic.bean.TopicListBean;
import defpackage.bj5;
import defpackage.l50;
import defpackage.me1;
import defpackage.tw4;
import defpackage.vo2;
import defpackage.xj5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TopicSelectDialog extends BottomSheetDialog implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ListView f16583a;
    public g b;
    public ProgressBar c;
    public View d;
    public f e;
    public vo2 f;
    public BottomSheetBehavior<FrameLayout> g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicSelectDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicSelectDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends tw4<CommonResponse<TopicListBean>> {
        public d() {
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<TopicListBean> commonResponse) {
            TopicSelectDialog.this.c.setVisibility(8);
            TopicSelectDialog.this.q(commonResponse.getData() != null ? commonResponse.getData().getTopicList(TopicListBean.Topic.TopicType.PUBLIC) : null);
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            TopicSelectDialog.this.c.setVisibility(8);
            List<TopicListBean.Topic> listI = xj5.h().i();
            if (listI != null) {
                TopicSelectDialog.this.q(listI);
            } else {
                TopicSelectDialog.this.d.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TopicSelectDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(TopicListBean.Topic topic);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TopicSelectDialog f16589a;
        public List<a> b;
        public int c = -1;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TopicListBean.Topic f16590a;

            public a() {
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f16591a;
            public ImageView b;

            public b() {
            }

            public /* synthetic */ b(a aVar) {
                this();
            }
        }

        public g(TopicSelectDialog topicSelectDialog, List<a> list) {
            this.f16589a = topicSelectDialog;
            this.b = list;
        }

        public void b(int i) {
            this.c = i;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.f16589a.getContext()).inflate(R$layout.square_layout_item_topic_select, (ViewGroup) null);
                bVar = new b(null);
                bVar.f16591a = (TextView) view.findViewById(R$id.name);
                bVar.b = (ImageView) view.findViewById(R$id.check_image);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            a aVar = this.b.get(i);
            if (aVar.f16590a != null) {
                bVar.f16591a.setText("# " + aVar.f16590a.getTopicName());
            } else {
                bVar.f16591a.setText(view.getResources().getString(R$string.string_select_topic_null));
            }
            if (i == this.c) {
                bVar.f16591a.setTextColor(view.getContext().getResources().getColor(R$color.Ga));
                bVar.b.setImageResource(R$drawable.square_location_selected);
                view.setBackgroundResource(R$drawable.square_topic_select_item_bg_selected);
            } else {
                bVar.f16591a.setTextColor(view.getContext().getResources().getColor(R$color.Gb));
                bVar.b.setImageResource(R$drawable.square_location_unselected);
                view.setBackgroundResource(R$drawable.square_topic_select_item_bg_unselected);
            }
            return view;
        }
    }

    public TopicSelectDialog(@NonNull Context context, boolean z, f fVar) {
        super(context, R$style.SquareBottomDialog);
        View viewInflate = getLayoutInflater().inflate(R$layout.square_layout_dialog_topic_select, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R$id.list);
        this.f16583a = listView;
        listView.setOnItemClickListener(this);
        this.c = (ProgressBar) viewInflate.findViewById(R$id.progress_loading);
        this.d = viewInflate.findViewById(R$id.error);
        int i = R$id.list_layout;
        if (viewInflate.findViewById(i).getLayoutParams() != null) {
            viewInflate.findViewById(i).getLayoutParams().height = (int) (((double) me1.f()) * 0.7d);
        }
        viewInflate.findViewById(R$id.close).setOnClickListener(new a());
        viewInflate.findViewById(R$id.space).setOnClickListener(new b());
        setContentView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.design_bottom_sheet);
        if (frameLayout != null) {
            try {
                BottomSheetBehavior<FrameLayout> bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                this.g = bottomSheetBehaviorFrom;
                bottomSheetBehaviorFrom.setSkipCollapsed(true);
                this.g.setBottomSheetCallback(new c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.e = fVar;
        this.f = bj5.b().d();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (l50.a()) {
            return;
        }
        g gVar = this.b;
        if (gVar != null && gVar.b != null && i < this.b.b.size() && i >= 0) {
            this.e.a(((g.a) this.b.b.get(i)).f16590a);
            this.b.b(i);
        }
        this.f16583a.post(new e());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        p();
    }

    public final void p() {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.f.l(new d());
    }

    public final void q(List<TopicListBean.Topic> list) {
        ArrayList arrayList = new ArrayList();
        a aVar = null;
        if (list != null) {
            for (TopicListBean.Topic topic : list) {
                g.a aVar2 = new g.a(aVar);
                aVar2.f16590a = topic;
                arrayList.add(aVar2);
            }
        }
        arrayList.add(new g.a(aVar));
        g gVar = new g(this, arrayList);
        this.b = gVar;
        this.f16583a.setAdapter((ListAdapter) gVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BottomSheetBehavior.BottomSheetCallback {
        public c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            if (i == 5) {
                TopicSelectDialog.this.cancel();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
        }
    }
}
