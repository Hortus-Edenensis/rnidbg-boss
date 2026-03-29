package com.zenmen.square.fragment.online;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.a74;
import defpackage.ds0;
import defpackage.hc2;
import defpackage.l50;
import defpackage.sy5;
import defpackage.y64;
import defpackage.z64;
import defpackage.zk5;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnLinePublicDialog extends LXBottomSheetDialog {
    public List<OnLineStatusItem> h;
    public View i;
    public RecyclerView j;
    public EditText k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public StatusAdapter q;
    public int r;

    /* JADX INFO: compiled from: SearchBox */
    public class StatusAdapter extends RecyclerView.Adapter<StatusViewHolder> {
        public Context e;
        public List<OnLineStatusItem> f;

        public StatusAdapter(Context context) {
            this.e = context;
        }

        public List<OnLineStatusItem> a() {
            return this.f;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull StatusViewHolder statusViewHolder, int i) {
            List<OnLineStatusItem> list = this.f;
            if (list == null || list.size() < i) {
                return;
            }
            statusViewHolder.m(this.f.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return OnLinePublicDialog.this.new StatusViewHolder(LayoutInflater.from(this.e).inflate(R$layout.layout_online_public_item, viewGroup, false));
        }

        public void f(List<OnLineStatusItem> list) {
            this.f = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<OnLineStatusItem> list = this.f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class StatusViewHolder extends RecyclerView.ViewHolder {
        public View d;
        public ImageView e;
        public TextView f;
        public View g;
        public OnLineStatusItem h;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l50.a()) {
                    return;
                }
                StatusViewHolder statusViewHolder = StatusViewHolder.this;
                OnLinePublicDialog.this.D(statusViewHolder.h);
            }
        }

        public StatusViewHolder(@NonNull View view) {
            super(view);
            this.e = (ImageView) view.findViewById(R$id.public_item_icon);
            this.d = view.findViewById(R$id.public_item_select);
            this.f = (TextView) view.findViewById(R$id.public_item_text);
            this.g = view.findViewById(R$id.online_public_item_root);
        }

        public void m(OnLineStatusItem onLineStatusItem) {
            this.h = onLineStatusItem;
            if (onLineStatusItem != null) {
                if (!TextUtils.isEmpty(onLineStatusItem.url)) {
                    hc2.a(OnLinePublicDialog.this.getContext()).load(this.h.url).error(R$drawable.online_status_msg_bg).into(this.e);
                }
                if (this.h.select) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.h.text)) {
                    this.f.setText(this.h.text);
                }
                this.g.setOnClickListener(new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            z64.h();
            OnLinePublicDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            OnLinePublicDialog.this.G();
            z64.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LogUtil.d("OnLineManagerTag", "afterTextChanged count s " + editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            LogUtil.d("OnLineManagerTag", "beforeTextChanged count i " + i2 + " s " + charSequence.toString() + " start " + i + " after " + i3);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            LogUtil.d("OnLineManagerTag", "onTextChanged count i " + i3 + " s " + charSequence.toString());
            int iG = zk5.g(OnLinePublicDialog.this.k, charSequence, OnLinePublicDialog.this.r, null, false);
            if (iG <= OnLinePublicDialog.this.r) {
                OnLinePublicDialog.this.l.setText((iG / 2) + "/" + (OnLinePublicDialog.this.r / 2));
            }
        }
    }

    public OnLinePublicDialog(Context context, List<OnLineStatusItem> list) {
        super(context);
        this.r = 24;
        this.h = list;
    }

    public void D(OnLineStatusItem onLineStatusItem) {
        StatusAdapter statusAdapter = this.q;
        if (statusAdapter == null || statusAdapter.a() == null) {
            return;
        }
        for (int i = 0; i < this.q.a().size(); i++) {
            OnLineStatusItem onLineStatusItem2 = this.q.a().get(i);
            if (onLineStatusItem2 == onLineStatusItem) {
                onLineStatusItem2.select = true;
            } else {
                onLineStatusItem2.select = false;
            }
        }
        this.q.notifyDataSetChanged();
    }

    public final void E() {
        List<OnLineStatusItem> list = this.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.q = new StatusAdapter(getContext());
        for (int i = 0; i < this.h.size(); i++) {
            if (i == 0) {
                this.h.get(i).select = true;
            } else {
                this.h.get(i).select = false;
            }
        }
        this.q.f(this.h);
        this.j.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.j.setAdapter(this.q);
    }

    public final void F() {
        this.i = this.p.findViewById(R$id.public_dialog_close);
        this.j = (RecyclerView) this.p.findViewById(R$id.public_dialog_recycler);
        this.k = (EditText) this.p.findViewById(R$id.public_dialog_edittext);
        this.l = (TextView) this.p.findViewById(R$id.public_dialog_num_count);
        this.m = (TextView) this.p.findViewById(R$id.online_status_desc_view);
        this.o = this.p.findViewById(R$id.online_publish_btn);
        TextView textView = (TextView) this.p.findViewById(R$id.line_dialog_title);
        this.n = textView;
        textView.setText(z64.f);
        this.l.setText("0/" + (this.r / 2));
        this.i.setOnClickListener(new a());
        this.o.setOnClickListener(new b());
        this.k.addTextChangedListener(new c());
    }

    public final void G() {
        OnLineStatusItem onLineStatusItem;
        StatusAdapter statusAdapter = this.q;
        if (statusAdapter == null || statusAdapter.a() == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.q.a().size()) {
                onLineStatusItem = null;
                break;
            }
            if (this.q.a().get(i).select) {
                onLineStatusItem = this.q.a().get(i);
                LogUtil.d("OnLineManagerTag", "publicLineClick select position " + i);
                break;
            }
            i++;
        }
        if (onLineStatusItem != null) {
            z64.D(this.k.getText() != null ? this.k.getText().toString() : "", onLineStatusItem, new d(onLineStatusItem));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        ds0.a().b(new y64(2));
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        this.p = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.layout_online_public_dialog, (ViewGroup) null);
        this.r = z64.h * 2;
        F();
        E();
        this.k.setHint(z64.g);
        this.m.setText(z64.e);
        return this.p;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        z64.k();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements a74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnLineStatusItem f16377a;

        public d(OnLineStatusItem onLineStatusItem) {
            this.f16377a = onLineStatusItem;
        }

        @Override // defpackage.a74
        public void onSuccess(Object obj) {
            if (obj instanceof OnLinePublicData) {
                this.f16377a.id = ((OnLinePublicData) obj).id;
                sy5.h(OnLinePublicDialog.this.getContext(), "状态发布成功", 0);
                y64 y64Var = new y64(1);
                y64Var.b = this.f16377a;
                if (OnLinePublicDialog.this.k.getText() != null) {
                    y64Var.c = OnLinePublicDialog.this.k.getText().toString();
                }
                ds0.a().b(y64Var);
                OnLinePublicDialog.this.dismiss();
            }
        }

        @Override // defpackage.a74
        public void onError(String str) {
        }
    }
}
