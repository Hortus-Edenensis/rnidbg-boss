package com.zenmen.palmchat.contacts.recommend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.d45;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.sy5;
import defpackage.xn0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<d45> f13663a = new ArrayList();
    public LayoutInflater b;
    public Context c;
    public b d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d45 f13664a;

        public a(d45 d45Var) {
            this.f13664a = d45Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (hx3.m(AppContext.getContext())) {
                c.this.d.a(this.f13664a);
            } else {
                sy5.e(c.this.c, R.string.contact_add_friend_unable, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(d45 d45Var);
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.recommend.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1029c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocialPortraitView f13665a;
        public TextView b;
        public TextView c;
        public TextView d;

        public C1029c() {
        }
    }

    public c(Context context, b bVar) {
        this.c = context;
        this.b = LayoutInflater.from(context);
        this.d = bVar;
    }

    public void c(ArrayList<d45> arrayList) {
        if (arrayList != null) {
            this.f13663a.clear();
            this.f13663a.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13663a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13663a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1029c c1029c;
        if (view == null) {
            view = this.b.inflate(R.layout.list_item_recommend_search, (ViewGroup) null);
            c1029c = new C1029c();
            c1029c.f13665a = (SocialPortraitView) view.findViewById(R.id.portrait);
            c1029c.b = (TextView) view.findViewById(R.id.nick_name);
            c1029c.c = (TextView) view.findViewById(R.id.recommend);
            c1029c.d = (TextView) view.findViewById(R.id.confirm_button);
            c1029c.f13665a.changeShapeType(3);
            view.setTag(c1029c);
        } else {
            c1029c = (C1029c) view.getTag();
        }
        d45 d45Var = this.f13663a.get(i);
        PhoneContactVo phoneContactVoE = d45Var.e();
        int iG = d45Var.g();
        String iconURL = phoneContactVoE.getIconURL();
        String localName = phoneContactVoE.getLocalName();
        String nickName = phoneContactVoE.getNickName();
        String recommendText = phoneContactVoE.getRecommendText();
        if (TextUtils.isEmpty(iconURL)) {
            gr2.j().c(c1029c.f13665a);
            c1029c.f13665a.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(iconURL, c1029c.f13665a, bq6.s());
        }
        if (iG >= 200 || TextUtils.isEmpty(localName) || TextUtils.isEmpty(localName.trim())) {
            if (!TextUtils.isEmpty(nickName)) {
                c1029c.b.setText(nickName);
            }
        } else if (TextUtils.isEmpty(nickName)) {
            c1029c.b.setText(localName.trim());
        } else {
            c1029c.b.setText(localName.trim() + "(" + nickName + ")");
        }
        if (!TextUtils.isEmpty(recommendText)) {
            c1029c.c.setText(recommendText);
        }
        if (bo0.r().w(d45Var.h())) {
            c1029c.d.setEnabled(false);
            c1029c.d.setText(R.string.contact_already_friend);
        } else {
            long jLongValue = xn0.d().b(d45Var.h()) ? xn0.d().c(d45Var.h()).longValue() : 0L;
            if (jLongValue == 2) {
                c1029c.d.setEnabled(false);
                c1029c.d.setText(R.string.contact_friend_wait_confirm);
            } else if (jLongValue == 1) {
                c1029c.d.setEnabled(false);
                c1029c.d.setText(R.string.contact_already_friend);
            } else {
                c1029c.d.setEnabled(true);
                c1029c.d.setText(R.string.contact_add_friend);
            }
        }
        c1029c.d.setOnClickListener(new a(d45Var));
        return view;
    }
}
