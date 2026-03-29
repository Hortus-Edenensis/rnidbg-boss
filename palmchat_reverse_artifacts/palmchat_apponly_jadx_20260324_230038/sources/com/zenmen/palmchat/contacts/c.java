package com.zenmen.palmchat.contacts;

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
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PhoneContactVo> f13565a = new ArrayList();
    public LayoutInflater b;
    public Context c;
    public b d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneContactVo f13566a;

        public a(PhoneContactVo phoneContactVo) {
            this.f13566a = phoneContactVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.d.a(this.f13566a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(PhoneContactVo phoneContactVo);
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1022c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f13567a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public View f;

        public C1022c() {
        }
    }

    public c(Context context, b bVar) {
        this.c = context;
        this.b = LayoutInflater.from(context);
        this.d = bVar;
    }

    public static char b(char c) {
        if (c == '#') {
            return c;
        }
        if (c > 'Z' || c < 'A') {
            return '#';
        }
        return c;
    }

    public final char c(String str) {
        try {
            return str.charAt(0);
        } catch (Exception unused) {
            return "#".charAt(0);
        }
    }

    public void e(ArrayList<PhoneContactVo> arrayList) {
        this.f13565a.clear();
        if (arrayList != null) {
            this.f13565a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13565a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13565a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1022c c1022c;
        PhoneContactItem phoneContactItem;
        if (view == null) {
            view = this.b.inflate(R.layout.list_item_phone_contact, (ViewGroup) null);
            c1022c = new C1022c();
            c1022c.f13567a = (ImageView) view.findViewById(R.id.portrait);
            c1022c.c = (TextView) view.findViewById(R.id.name);
            c1022c.b = (TextView) view.findViewById(R.id.nick_name);
            c1022c.d = (TextView) view.findViewById(R.id.group_indicator);
            c1022c.f = view.findViewById(R.id.divider);
            c1022c.e = (TextView) view.findViewById(R.id.confirm_button);
            view.setTag(c1022c);
        } else {
            c1022c = (C1022c) view.getTag();
        }
        PhoneContactVo phoneContactVo = this.f13565a.get(i);
        String nickName = phoneContactVo.getNickName();
        String iconURL = phoneContactVo.getIconURL();
        String localName = phoneContactVo.getLocalName();
        if (TextUtils.isEmpty(localName) && (phoneContactItem = d.j().m().get(phoneContactVo.getMd5Phone())) != null) {
            localName = phoneContactItem.y();
        }
        c1022c.c.setText(localName);
        c1022c.b.setText(this.c.getString(R.string.contact_zx_nick_name, nickName));
        c1022c.e.setVisibility(0);
        if (TextUtils.isEmpty(iconURL)) {
            c1022c.f13567a.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(iconURL, c1022c.f13567a, bq6.s());
        }
        if (phoneContactVo.getIsFriend() != 1) {
            c1022c.e.setEnabled(false);
            c1022c.e.setText(R.string.contact_already_friend);
        } else if (phoneContactVo.isClicked()) {
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(this.c, R.string.contact_add_friend_unable, 1).g();
            }
            c1022c.e.setEnabled(false);
            c1022c.e.setText(R.string.contact_friend_wait_confirm);
        } else {
            c1022c.e.setEnabled(true);
            c1022c.e.setText(R.string.contact_add_friend);
        }
        c1022c.e.setOnClickListener(new a(phoneContactVo));
        char cB = b(c(phoneContactVo.getLocalNameFirstPinyin()));
        if (i != 0 && b(c(((PhoneContactVo) getItem(i - 1)).getLocalNameFirstPinyin())) == cB) {
            c1022c.d.setVisibility(8);
        } else {
            c1022c.d.setVisibility(0);
            c1022c.d.setText(Character.toString(cB));
        }
        if (i != getCount() - 1 && b(c(((PhoneContactVo) getItem(i + 1)).getLocalNameFirstPinyin())) == cB) {
            c1022c.f.setVisibility(0);
        } else {
            c1022c.f.setVisibility(8);
        }
        return view;
    }
}
