package com.zenmen.palmchat.contacts;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.contacts.ContactInviteActivity;
import defpackage.bq6;
import defpackage.gr2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ContactInviteActivity.j> f13550a;
    public LayoutInflater d;
    public Context e;
    public List<PhoneContactVo> b = new ArrayList();
    public List<PhoneContactVo> c = new ArrayList();
    public HashMap<String, Long> f = new HashMap<>();
    public HashMap<String, Boolean> g = new HashMap<>();

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f13551a;
        public TextView b;
        public TextView c;
        public View d;
        public View e;
        public TextView f;

        public C1020a() {
        }
    }

    public a(Context context, ArrayList<ContactInviteActivity.j> arrayList) {
        this.e = context;
        this.d = LayoutInflater.from(context);
        this.f13550a = arrayList;
    }

    public static char a(char c) {
        if (c > 'Z' || c < 'A') {
            return '#';
        }
        return c;
    }

    public void b(ArrayList<ContactInviteActivity.j> arrayList) {
        this.f13550a = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13550a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13550a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1020a c1020a;
        if (view == null) {
            view = this.d.inflate(R.layout.list_item_contact_invite, (ViewGroup) null);
            c1020a = new C1020a();
            c1020a.f13551a = (ImageView) view.findViewById(R.id.portrait);
            c1020a.b = (TextView) view.findViewById(R.id.name);
            c1020a.c = (TextView) view.findViewById(R.id.phone);
            c1020a.d = view.findViewById(R.id.btn_check);
            c1020a.e = view.findViewById(R.id.group_layout);
            c1020a.f = (TextView) view.findViewById(R.id.group_indicator);
            view.setTag(c1020a);
        } else {
            c1020a = (C1020a) view.getTag();
        }
        ContactInviteActivity.j jVar = this.f13550a.get(i);
        String strA = jVar.a();
        String strB = jVar.b();
        String strD = jVar.d();
        String strC = jVar.c();
        boolean zE = jVar.e();
        if (TextUtils.isEmpty(strA)) {
            gr2.j().c(c1020a.f13551a);
            c1020a.f13551a.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(strA, c1020a.f13551a, bq6.s());
        }
        if (TextUtils.isEmpty(strB)) {
            c1020a.b.setText("");
        } else {
            c1020a.b.setText(strB);
        }
        if (!TextUtils.isEmpty(strC)) {
            c1020a.c.setText(strC);
        }
        if (zE) {
            c1020a.d.setBackgroundResource(R.drawable.ic_checkbox_green_check);
        } else {
            c1020a.d.setBackgroundResource(R.drawable.ic_checkbox_uncheck);
        }
        char cA = a(strD.toUpperCase().charAt(0));
        if (i != 0 && a(((ContactInviteActivity.j) getItem(i - 1)).d().toUpperCase().charAt(0)) == cA) {
            c1020a.e.setVisibility(8);
        } else {
            c1020a.e.setVisibility(0);
            c1020a.f.setText(Character.toString(cA));
        }
        return view;
    }
}
