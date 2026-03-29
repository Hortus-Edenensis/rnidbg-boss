package com.beizi.ad.internal.view.a;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends Dialog {
    private static e b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<c> f4447a;
    private int c;

    /* JADX INFO: renamed from: com.beizi.ad.internal.view.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0120a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RecyclerView f4448a;
        private ImageView b;
        private TextView c;
        private RelativeLayout d;
        private RelativeLayout e;
        private EditText f;
        private TextView g;
        private Button h;
        private View i;
        private a j;
        private b k;
        private boolean l;

        public C0120a(final Context context) {
            this.j = new a(context, R.style.beizi_ad_custom_dialog);
            View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_complaint_dialog, (ViewGroup) null, false);
            this.i = viewInflate;
            this.j.addContentView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            this.f4448a = (RecyclerView) this.i.findViewById(R.id.dislike_reasons_list_recycleview);
            this.b = (ImageView) this.i.findViewById(R.id.complaint_dialog_close_view);
            this.c = (TextView) this.i.findViewById(R.id.complaint_other_suggest_view);
            this.d = (RelativeLayout) this.i.findViewById(R.id.complaint_normal_ui);
            this.e = (RelativeLayout) this.i.findViewById(R.id.complaint_other_suggest_layout);
            this.f = (EditText) this.i.findViewById(R.id.complaint_input_other_edittext);
            this.g = (TextView) this.i.findViewById(R.id.complaint_other_suggest_number_textview);
            this.h = (Button) this.i.findViewById(R.id.complaint_other_suggest_submit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f4448a.setLayoutManager(linearLayoutManager);
            a.b.a(new d() { // from class: com.beizi.ad.internal.view.a.a.a.1
                @Override // com.beizi.ad.internal.view.a.a.d
                public void a(View view, int i, String str) {
                    C0120a.this.a(str);
                }
            });
            this.f4448a.setAdapter(a.b);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C0120a.this.l = true;
                    C0120a c0120a = C0120a.this;
                    c0120a.a(context, c0120a.f);
                }
            });
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0120a.this.l) {
                        C0120a.this.l = false;
                        C0120a c0120a = C0120a.this;
                        c0120a.a(context, c0120a.f);
                    } else {
                        if (C0120a.this.j != null) {
                            C0120a.this.j.dismiss();
                        }
                        if (C0120a.this.k != null) {
                            C0120a.this.k.a();
                        }
                    }
                }
            });
            this.f.addTextChangedListener(new TextWatcher() { // from class: com.beizi.ad.internal.view.a.a.a.4
                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    String string = charSequence.toString();
                    int length = charSequence.length();
                    if (string.isEmpty()) {
                        C0120a.this.h.setBackground(ContextCompat.getDrawable(context, R.drawable.beizi_complaint_button_disable_shape));
                        C0120a.this.h.setTextColor(context.getResources().getColor(android.R.color.white));
                        C0120a.this.h.setEnabled(false);
                    } else {
                        C0120a.this.h.setBackground(ContextCompat.getDrawable(context, R.drawable.beizi_complaint_button_enable_shape));
                        C0120a.this.h.setTextColor(context.getResources().getColor(android.R.color.black));
                        C0120a.this.h.setEnabled(true);
                    }
                    C0120a.this.g.setText(String.valueOf(length));
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C0120a.this.a(C0120a.this.f.getText().toString());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            b bVar;
            if (!TextUtils.isEmpty(str) && (bVar = this.k) != null) {
                bVar.a(str);
            }
            a aVar = this.j;
            if (aVar != null) {
                aVar.dismiss();
            }
            m.b("BeiZisAd", str + " 被点击了");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, EditText editText) {
            if (this.l) {
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                a(context, true, editText);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                a(context, false, editText);
            }
        }

        private void a(final Context context, boolean z, final EditText editText) {
            if (z) {
                editText.requestFocus();
                new Timer().schedule(new TimerTask() { // from class: com.beizi.ad.internal.view.a.a.a.6
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                        inputMethodManager.showSoftInput(editText, 2);
                        inputMethodManager.toggleSoftInput(2, 1);
                    }
                }, 100L);
            } else {
                editText.clearFocus();
                ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }

        public C0120a a(b bVar) {
            this.k = bVar;
            return this;
        }

        public a a() {
            this.j.setContentView(this.i);
            this.j.setCancelable(true);
            this.j.setCanceledOnTouchOutside(false);
            return this.j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void a(String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4455a;
        String b;

        public c() {
        }

        public void a(int i) {
            this.f4455a = i;
        }

        public String a() {
            return this.b;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(View view, int i, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends RecyclerView.Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f4456a;
        private List<c> c;

        /* JADX INFO: renamed from: com.beizi.ad.internal.view.a.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0121a extends RecyclerView.ViewHolder {
            private TextView b;
            private View c;

            public C0121a(View view) {
                super(view);
                this.b = (TextView) view.findViewById(R.id.dislike_item_multi_one_title);
                this.c = view.findViewById(R.id.complaint_reason_item_divider);
            }
        }

        public e(Context context, List<c> list) {
            this.c = list;
        }

        public void a(d dVar) {
            this.f4456a = dVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return a.this.c;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
            final String strA = this.c.get(i).a();
            if (viewHolder instanceof C0121a) {
                C0121a c0121a = (C0121a) viewHolder;
                c0121a.b.setText(strA);
                if (this.c.size() > 0 && i == this.c.size() - 1) {
                    c0121a.c.setVisibility(8);
                }
            }
            if (this.f4456a != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.f4456a.a(viewHolder.itemView, viewHolder.getLayoutPosition(), strA);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new C0121a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_complaint_item_multi_one, viewGroup, false));
        }
    }

    public a(@NonNull Context context, int i) {
        super(context, i);
        this.f4447a = null;
        this.c = 1;
        List<c> listB = b();
        this.f4447a = listB;
        b = new e(context, listB);
    }

    private List<c> b() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"垃圾广告", "感觉有被冒犯或被歧视", "广告涉及欺诈造假", "广告涉及色情暴力", "广告涉及违禁商品/服务", "对广告内容不感兴趣"};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            c cVar = new c();
            cVar.a(str);
            cVar.a(this.c);
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
