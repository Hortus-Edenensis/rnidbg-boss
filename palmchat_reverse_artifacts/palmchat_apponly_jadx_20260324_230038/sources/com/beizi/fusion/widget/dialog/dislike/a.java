package com.beizi.fusion.widget.dialog.dislike;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beizi.fusion.R;
import com.beizi.fusion.tool.am;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends Dialog {
    private static h b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f4804a;
    private int c;
    private int d;

    /* JADX INFO: renamed from: com.beizi.fusion.widget.dialog.dislike.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0144a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RecyclerView f4805a;
        private View b;
        private a c;
        private c d;

        public C0144a(Context context) {
            this.c = new a(context, R.style.beizi_custom_dialog);
            View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_dislike_dialog, (ViewGroup) null, false);
            this.b = viewInflate;
            this.c.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            this.f4805a = (RecyclerView) this.b.findViewById(R.id.beizi_dislike_reasons_list_recycleview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f4805a.setLayoutManager(linearLayoutManager);
            a.b.a(new e() { // from class: com.beizi.fusion.widget.dialog.dislike.a.a.1
                @Override // com.beizi.fusion.widget.dialog.dislike.a.e
                public void a(View view, int i) {
                    if (C0144a.this.c != null) {
                        C0144a.this.c.dismiss();
                    }
                    if (C0144a.this.d != null) {
                        C0144a.this.d.a();
                    }
                }
            });
            this.f4805a.setAdapter(a.b);
            WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
            Point point = new Point();
            this.c.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
            attributes.width = (int) (((double) point.x) * 0.85d);
            attributes.gravity = 17;
            this.c.getWindow().setAttributes(attributes);
        }

        public C0144a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public a a() {
            this.c.setContentView(this.b);
            this.c.setCancelable(true);
            this.c.setCanceledOnTouchOutside(true);
            return this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4807a;
        String b;
        List<d> c;

        public b() {
        }

        public List<d> a() {
            return this.c;
        }

        public String b() {
            return this.b;
        }

        public void a(List<d> list) {
            this.c = list;
        }

        public void a(int i) {
            this.f4807a = i;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4808a;

        public d() {
        }

        public String a() {
            return this.f4808a;
        }

        public void a(String str) {
            this.f4808a = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(View view, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(View view, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends RecyclerView.Adapter {
        private List<d> b;
        private Context c;
        private f d;

        /* JADX INFO: renamed from: com.beizi.fusion.widget.dialog.dislike.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0145a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            TextView f4811a;

            public C0145a(View view) {
                super(view);
                this.f4811a = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview_item);
            }
        }

        public g(Context context, List<d> list) {
            this.c = context;
            this.b = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) final int i) {
            C0145a c0145a = (C0145a) viewHolder;
            c0145a.f4811a.setText(this.b.get(i).a());
            am.a(c0145a.itemView, "#FFFAF6F6", 0, "", 10);
            c0145a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.d != null) {
                        g.this.d.a(view, i);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new C0145a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two_recycle_item, viewGroup, false));
        }

        public void a(f fVar) {
            this.d = fVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends RecyclerView.Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f4812a;
        private Context c;
        private List<b> d;

        /* JADX INFO: renamed from: com.beizi.fusion.widget.dialog.dislike.a$h$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0146a extends RecyclerView.ViewHolder {
            private TextView b;

            public C0146a(View view) {
                super(view);
                this.b = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_one_title);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends RecyclerView.ViewHolder {
            private TextView b;
            private RecyclerView c;

            public b(View view) {
                super(view);
                this.b = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_title);
                this.c = (RecyclerView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview);
            }
        }

        public h(Context context, List<b> list) {
            this.c = context;
            this.d = list;
        }

        public void a(e eVar) {
            this.f4812a = eVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (this.d.get(i).a() == null || this.d.get(i).a().size() <= 0) ? a.this.c : a.this.d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof C0146a) {
                ((C0146a) viewHolder).b.setText(this.d.get(i).b());
            } else {
                b bVar = (b) viewHolder;
                bVar.b.setText(this.d.get(i).b());
                bVar.c.setLayoutManager(new FlowLayoutManager());
                a aVar = a.this;
                g gVar = aVar.new g(aVar.getContext(), this.d.get(i).a());
                bVar.c.setAdapter(gVar);
                gVar.a(new f() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.1
                    @Override // com.beizi.fusion.widget.dialog.dislike.a.f
                    public void a(View view, int i2) {
                        e eVar = h.this.f4812a;
                        if (eVar != null) {
                            eVar.a(view, i2);
                        }
                    }
                });
                bVar.c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.2
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                        super.getItemOffsets(rect, view, recyclerView, state);
                        rect.bottom = 30;
                        rect.left = 60;
                    }
                });
            }
            if (this.f4812a != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int layoutPosition = viewHolder.getLayoutPosition();
                        if (a.this.d != h.this.getItemViewType(layoutPosition)) {
                            h.this.f4812a.a(viewHolder.itemView, layoutPosition);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return i == a.this.c ? new C0146a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_one, viewGroup, false)) : new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two, viewGroup, false));
        }
    }

    public a(@NonNull Context context, int i) {
        super(context, i);
        this.f4804a = null;
        this.c = 1;
        this.d = 2;
        List<b> listB = b();
        this.f4804a = listB;
        b = new h(context, listB);
    }

    private List<b> b() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.a("内容无法正常展示（卡顿、黑白屏）");
        bVar.a(this.c);
        arrayList.add(bVar);
        b bVar2 = new b();
        bVar2.a("不感兴趣");
        bVar2.a(this.c);
        arrayList.add(bVar2);
        b bVar3 = new b();
        bVar3.a("无法关闭");
        bVar3.a(this.c);
        arrayList.add(bVar3);
        ArrayList arrayList2 = new ArrayList();
        d dVar = new d();
        dVar.a("疑似抄袭");
        arrayList2.add(dVar);
        d dVar2 = new d();
        dVar2.a("虚假欺诈");
        arrayList2.add(dVar2);
        d dVar3 = new d();
        dVar3.a("违法违规");
        arrayList2.add(dVar3);
        d dVar4 = new d();
        dVar4.a("低俗色情");
        arrayList2.add(dVar4);
        b bVar4 = new b();
        bVar4.a("举报广告");
        bVar4.a(arrayList2);
        bVar4.a(this.c);
        arrayList.add(bVar4);
        return arrayList;
    }
}
