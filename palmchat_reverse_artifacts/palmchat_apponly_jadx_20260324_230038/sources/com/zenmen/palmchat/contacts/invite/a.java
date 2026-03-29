package com.zenmen.palmchat.contacts.invite;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import defpackage.hx3;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends BaseAdapter {
    public LayoutInflater b;
    public Context c;
    public b f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PhoneContactVo> f13610a = new ArrayList();
    public HashMap<String, Long> d = new HashMap<>();
    public HashMap<PhoneContactVo, Boolean> e = new HashMap<>();
    public boolean g = false;

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.invite.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1026a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneContactVo f13611a;

        public ViewOnClickListenerC1026a(PhoneContactVo phoneContactVo) {
            this.f13611a = phoneContactVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (hx3.m(AppContext.getContext())) {
                a.this.f.a(this.f13611a);
            } else {
                sy5.e(a.this.c, R.string.send_failed, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(PhoneContactVo phoneContactVo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f13612a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;

        public c() {
        }
    }

    public a(Context context, b bVar) {
        this.c = context;
        this.b = LayoutInflater.from(context);
        this.f = bVar;
    }

    public HashMap<PhoneContactVo, Boolean> c() {
        return this.e;
    }

    public void e(PhoneContactVo phoneContactVo) {
        Boolean bool = this.e.get(phoneContactVo);
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.e.put(phoneContactVo, Boolean.valueOf(!bool.booleanValue()));
        notifyDataSetChanged();
    }

    public void f(String str, long j) {
        this.d.put(str, Long.valueOf(j));
    }

    public void g(boolean z) {
        this.g = z;
        this.e.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13610a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13610a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = this.b.inflate(R.layout.list_item_contact_invite_friends, (ViewGroup) null);
            cVar = new c();
            cVar.f13612a = (TextView) view.findViewById(R.id.first_name);
            cVar.b = (TextView) view.findViewById(R.id.nick_name);
            cVar.c = (TextView) view.findViewById(R.id.recommend);
            cVar.d = (TextView) view.findViewById(R.id.confirm_button);
            cVar.e = (ImageView) view.findViewById(R.id.select);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        PhoneContactVo phoneContactVo = this.f13610a.get(i);
        String recommendText = phoneContactVo.getRecommendText();
        String localName = phoneContactVo.getLocalName();
        if (!TextUtils.isEmpty(localName) && localName.trim().length() > 0) {
            cVar.f13612a.setText(localName.trim().substring(0, 1));
        }
        cVar.b.setText(phoneContactVo.getLocalName());
        cVar.c.setText(recommendText);
        cVar.d.setVisibility(0);
        if ((this.d.containsKey(phoneContactVo.getMd5Phone()) ? this.d.get(phoneContactVo.getMd5Phone()).longValue() : 0L) == 1) {
            cVar.d.setEnabled(false);
            cVar.d.setText(R.string.contact_invite_friends_invited);
        } else {
            cVar.d.setEnabled(true);
            cVar.d.setText(R.string.contact_invite_friends_invite);
        }
        if (this.g) {
            cVar.e.setVisibility(0);
            cVar.d.setVisibility(4);
            if (this.e.get(phoneContactVo) == null || !this.e.get(phoneContactVo).booleanValue()) {
                cVar.e.setImageResource(R.drawable.invite_friend_unselect);
            } else {
                cVar.e.setImageResource(R.drawable.invite_friend_selected);
            }
        } else {
            cVar.e.setVisibility(8);
            cVar.d.setVisibility(0);
        }
        cVar.d.setOnClickListener(new ViewOnClickListenerC1026a(phoneContactVo));
        return view;
    }

    public void h(ArrayList<PhoneContactVo> arrayList) {
        this.f13610a.clear();
        if (arrayList != null) {
            this.f13610a.addAll(arrayList);
        }
        this.e.clear();
        notifyDataSetChanged();
    }
}
