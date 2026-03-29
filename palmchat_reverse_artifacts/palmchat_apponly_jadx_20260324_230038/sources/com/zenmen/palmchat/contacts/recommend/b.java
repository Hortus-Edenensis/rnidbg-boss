package com.zenmen.palmchat.contacts.recommend;

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
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b extends BaseAdapter {
    public LayoutInflater d;
    public Context e;
    public c h;
    public d j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PhoneContactVo> f13659a = new ArrayList();
    public List<PhoneContactVo> b = new ArrayList();
    public List<PhoneContactVo> c = new ArrayList();
    public HashMap<String, Long> f = new HashMap<>();
    public HashMap<String, Boolean> g = new HashMap<>();
    public boolean i = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneContactVo f13660a;

        public a(PhoneContactVo phoneContactVo) {
            this.f13660a = phoneContactVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (hx3.m(AppContext.getContext())) {
                b.this.h.a(this.f13660a);
            } else {
                sy5.e(b.this.e, R.string.contact_add_friend_unable, 1).g();
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.recommend.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1028b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneContactVo f13661a;

        public ViewOnClickListenerC1028b(PhoneContactVo phoneContactVo) {
            this.f13661a = phoneContactVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bo0.r().w(this.f13661a.getUid())) {
                return;
            }
            this.f13661a.setSelected(!r3.isSelected());
            b.this.j(this.f13661a.getUid(), this.f13661a.isSelected());
            b.this.j.onClick();
            b.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(PhoneContactVo phoneContactVo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void onClick();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocialPortraitView f13662a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;

        public e() {
        }
    }

    public b(Context context, c cVar) {
        this.e = context;
        this.d = LayoutInflater.from(context);
        this.h = cVar;
    }

    public final String e(int i, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str2 + "(" + str + ")";
    }

    public List<PhoneContactVo> f() {
        this.c.clear();
        for (PhoneContactVo phoneContactVo : this.f13659a) {
            if (!bo0.r().w(phoneContactVo.getUid())) {
                this.c.add(phoneContactVo);
            }
        }
        return this.c;
    }

    public List<PhoneContactVo> g() {
        this.b.clear();
        for (PhoneContactVo phoneContactVo : this.f13659a) {
            if (this.g.containsKey(phoneContactVo.getUid())) {
                phoneContactVo.setSelected(this.g.get(phoneContactVo.getUid()).booleanValue());
            }
            if (bo0.r().w(phoneContactVo.getUid())) {
                phoneContactVo.setSelected(false);
            } else if (this.f.containsKey(phoneContactVo.getUid()) && this.f.get(phoneContactVo.getUid()).longValue() != 0) {
                phoneContactVo.setSelected(false);
            }
            if (phoneContactVo.isSelected()) {
                this.b.add(phoneContactVo);
            }
        }
        return this.b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13659a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13659a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        if (view == null) {
            view = this.d.inflate(R.layout.list_item_recommend_friends, (ViewGroup) null);
            eVar = new e();
            eVar.f13662a = (SocialPortraitView) view.findViewById(R.id.portrait);
            eVar.b = (TextView) view.findViewById(R.id.nick_name);
            eVar.c = (TextView) view.findViewById(R.id.recommend);
            eVar.d = (TextView) view.findViewById(R.id.confirm_button);
            eVar.e = (ImageView) view.findViewById(R.id.img_select);
            eVar.f13662a.changeShapeType(3);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        PhoneContactVo phoneContactVo = this.f13659a.get(i);
        String iconURL = phoneContactVo.getIconURL();
        String recommendText = phoneContactVo.getRecommendText();
        if (TextUtils.isEmpty(iconURL)) {
            gr2.j().c(eVar.f13662a);
            eVar.f13662a.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(iconURL, eVar.f13662a, bq6.s());
        }
        eVar.b.setText(e(phoneContactVo.getRequestType(), phoneContactVo.getLocalOrRealName(), phoneContactVo.getNickName()));
        if (!TextUtils.isEmpty(recommendText)) {
            eVar.c.setText(recommendText);
        }
        eVar.d.setVisibility(0);
        if (this.g.containsKey(phoneContactVo.getUid())) {
            phoneContactVo.setSelected(this.g.get(phoneContactVo.getUid()).booleanValue());
        }
        if (bo0.r().w(phoneContactVo.getUid())) {
            eVar.d.setEnabled(false);
            eVar.d.setText(R.string.contact_already_friend);
            eVar.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
            eVar.d.setTextColor(this.e.getResources().getColor(R.color.text_color_ffffff));
            phoneContactVo.setSelected(false);
            eVar.e.setVisibility(8);
            view.setBackgroundResource(R.drawable.selector_settings_item_background);
        } else {
            eVar.e.setVisibility(0);
            long j = 0;
            if (this.f.containsKey(phoneContactVo.getUid())) {
                long jLongValue = this.f.get(phoneContactVo.getUid()).longValue();
                if (jLongValue != 0) {
                    phoneContactVo.setSelected(false);
                }
                j = jLongValue;
            }
            if (j == 2) {
                eVar.d.setEnabled(false);
                eVar.d.setText(R.string.contact_friend_wait_confirm);
                eVar.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
                eVar.d.setTextColor(this.e.getResources().getColor(R.color.text_color_ffffff));
            } else if (j == 1) {
                eVar.d.setEnabled(false);
                eVar.d.setText(R.string.contact_already_friend);
                eVar.d.setBackgroundResource(R.drawable.shape_cccccc_bg_radius_15);
                eVar.d.setTextColor(this.e.getResources().getColor(R.color.text_color_ffffff));
            } else {
                eVar.d.setEnabled(true);
                eVar.d.setText(R.string.contact_add_friend);
                eVar.d.setBackgroundResource(R.drawable.selector_btn_green_trans);
                eVar.d.setTextColor(this.e.getResources().getColor(R.color.text_color_ffffff));
            }
        }
        eVar.d.setOnClickListener(new a(phoneContactVo));
        eVar.e.setOnClickListener(new ViewOnClickListenerC1028b(phoneContactVo));
        if (phoneContactVo.isSelected()) {
            eVar.e.setImageResource(R.drawable.ic_checkbox_green_check);
        } else {
            eVar.e.setImageResource(R.drawable.ic_checkbox_gray_check);
        }
        if (!this.i) {
            eVar.e.setVisibility(8);
        }
        return view;
    }

    public void h(String str, long j) {
        this.f.put(str, Long.valueOf(j));
    }

    public void i(List<PhoneContactVo> list, long j) {
        for (PhoneContactVo phoneContactVo : list) {
            if (phoneContactVo.isSelected()) {
                this.f.put(phoneContactVo.getUid(), Long.valueOf(j));
                phoneContactVo.setSelected(false);
                this.g.put(phoneContactVo.getUid(), Boolean.FALSE);
            }
        }
    }

    public void j(String str, boolean z) {
        this.g.put(str, Boolean.valueOf(z));
    }

    public void l(d dVar) {
        this.j = dVar;
    }

    public void m(boolean z) {
        this.i = z;
    }

    public void o(ArrayList<PhoneContactVo> arrayList) {
        this.f13659a.clear();
        if (arrayList != null) {
            this.f13659a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }
}
