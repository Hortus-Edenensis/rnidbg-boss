package com.zenmen.palmchat.groupchat;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.oc0;
import defpackage.q30;
import defpackage.v8;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a extends BaseAdapter {
    public GroupInfoItem c;
    public LayoutInflater d;
    public int e;
    public d h;
    public boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<e> f14312a = new ArrayList<>();
    public ArrayList<ContactInfoItem> b = new ArrayList<>();
    public boolean f = false;
    public boolean g = false;

    /* JADX INFO: renamed from: com.zenmen.palmchat.groupchat.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1060a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14313a;
        public final /* synthetic */ ContactInfoItem b;
        public final /* synthetic */ c c;

        public ViewOnClickListenerC1060a(int i, ContactInfoItem contactInfoItem, c cVar) {
            this.f14313a = i;
            this.b = contactInfoItem;
            this.c = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.h != null) {
                if (this.f14313a == 0 && this.b == null) {
                    return;
                }
                a.this.h.z(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f14314a;

        public b(c cVar) {
            this.f14314a = cVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (a.this.h == null) {
                return true;
            }
            a.this.h.t0(this.f14314a);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ContactInfoItem f14315a;
        public int b;

        public c(ContactInfoItem contactInfoItem, int i) {
            this.f14315a = contactInfoItem;
            this.b = i;
        }

        public ContactInfoItem a() {
            return this.f14315a;
        }

        public int b() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void t0(c cVar);

        void z(c cVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<c> f14316a = new ArrayList<>();

        public e() {
        }
    }

    public a(Context context, int i, GroupInfoItem groupInfoItem, d dVar, boolean z) {
        this.i = false;
        this.h = dVar;
        this.d = LayoutInflater.from(context);
        this.e = i;
        this.c = groupInfoItem;
        this.i = z;
    }

    public final void b(ArrayList<c> arrayList, ArrayList<ContactInfoItem> arrayList2) {
        int i = this.e;
        if (i == 0) {
            boolean z = false;
            if (v8.h() && arrayList2 != null && arrayList2.size() > 0 && v8.C(arrayList2.get(0).getUid())) {
                z = true;
            }
            if (z) {
                return;
            }
            arrayList.add(new c(null, 1));
            return;
        }
        if (i != 1 || this.c.getGroupExtTypeFromExtension() == 1) {
            return;
        }
        if (!oc0.f() || this.c.getInviteSwitch() != 0 || this.c.getRoleType() != 3) {
            arrayList.add(new c(null, 1));
        }
        if ((e() || (oc0.f() && this.c.getRoleType() == 2)) && arrayList2.size() > 1) {
            arrayList.add(new c(null, 2));
        }
    }

    public final ArrayList<e> c(ArrayList<ContactInfoItem> arrayList) {
        ArrayList<c> arrayList2 = new ArrayList<>();
        Iterator<ContactInfoItem> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new c(it.next(), 0));
        }
        b(arrayList2, arrayList);
        int size = arrayList2.size() % 5;
        int i = size == 0 ? 0 : 5 - size;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList2.add(new c(null, 3));
        }
        ArrayList<e> arrayList3 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList2.size(); i3 += 5) {
            int i4 = i3 / 5;
            e eVar = new e();
            for (int i5 = 0; i5 < 5; i5++) {
                eVar.f14316a.add(arrayList2.get((i4 * 5) + i5));
            }
            arrayList3.add(eVar);
        }
        return arrayList3;
    }

    public final boolean e() {
        GroupInfoItem groupInfoItem;
        String strP = AccountUtils.p(AppContext.getContext());
        return this.e == 1 && (groupInfoItem = this.c) != null && strP != null && strP.equals(groupInfoItem.getGroupOwner());
    }

    public void f(ArrayList<ContactInfoItem> arrayList) {
        if (arrayList != null) {
            this.b.clear();
            this.b.addAll(arrayList);
            this.f14312a = c(this.b);
            notifyDataSetChanged();
        }
    }

    public void g(boolean z) {
        this.f = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14312a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f14312a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        q30 q30VarA;
        if (view == null) {
            view = this.d.inflate(R.layout.chat_members_row_item, (ViewGroup) null, false);
        }
        if (view.getTag() == null) {
            q30VarA = q30.a(view);
            view.setTag(q30VarA);
        } else {
            q30VarA = (q30) view.getTag();
        }
        e eVar = this.f14312a.get(i);
        for (int i2 = 0; i2 < eVar.f14316a.size(); i2++) {
            c cVar = eVar.f14316a.get(i2);
            ContactInfoItem contactInfoItemA = cVar.a();
            int iB = cVar.b();
            gr2.j().c(q30VarA.b.get(i2));
            if (iB == 3) {
                q30VarA.b.get(i2).setVisibility(4);
                q30VarA.c.get(i2).setVisibility(4);
            } else if (iB == 1) {
                if (this.f) {
                    q30VarA.b.get(i2).setVisibility(4);
                } else {
                    q30VarA.b.get(i2).setVisibility(0);
                    if (this.i) {
                        q30VarA.b.get(i2).setImageResource(R.drawable.icon_group_add_new);
                    } else {
                        q30VarA.b.get(i2).setImageResource(R.drawable.selector_add_button_background);
                    }
                }
                if (this.i) {
                    q30VarA.c.get(i2).setVisibility(0);
                    q30VarA.c.get(i2).setText(R.string.recommend_friend_dialog_message_new_batch_add);
                } else {
                    q30VarA.c.get(i2).setVisibility(4);
                }
            } else if (iB == 2) {
                if (this.f) {
                    q30VarA.b.get(i2).setVisibility(4);
                } else {
                    if (this.i) {
                        q30VarA.b.get(i2).setImageResource(R.drawable.icon_group_delete_new);
                    } else {
                        q30VarA.b.get(i2).setImageResource(R.drawable.selector_delete_button_background);
                    }
                    q30VarA.b.get(i2).setVisibility(0);
                }
                if (this.i) {
                    q30VarA.c.get(i2).setVisibility(0);
                    q30VarA.c.get(i2).setText(R.string.delete);
                } else {
                    q30VarA.c.get(i2).setVisibility(4);
                }
            } else if (iB == 0 && contactInfoItemA != null) {
                q30VarA.b.get(i2).setVisibility(0);
                q30VarA.b.get(i2).changeShapeType(3);
                q30VarA.b.get(i2).setDegreeForRoundRectangle(24, 24);
                q30VarA.c.get(i2).setVisibility(0);
                ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemA.getUid());
                if (contactInfoItemL != null) {
                    contactInfoItemA.setIconURL(contactInfoItemL.getIconURL());
                    contactInfoItemA.setRemarkName(contactInfoItemL.getRemarkName());
                    contactInfoItemA.setRemarkAllPinyin(contactInfoItemL.getRemarkAllPinyin());
                    contactInfoItemA.setRemarkFirstPinyin(contactInfoItemL.getRemarkFirstPinyin());
                }
                if (TextUtils.isEmpty(contactInfoItemA.getIconURL())) {
                    q30VarA.b.get(i2).setImageResource(R.drawable.default_portrait);
                } else {
                    gr2.j().h(contactInfoItemA.getIconURL(), q30VarA.b.get(i2), bq6.s());
                }
                q30VarA.c.get(i2).setText(contactInfoItemA.getNameForShow());
            }
            if (this.f && contactInfoItemA != null && contactInfoItemA.getIsGroupOwner() == 0) {
                q30VarA.d.get(i2).setVisibility(0);
            } else {
                q30VarA.d.get(i2).setVisibility(4);
            }
            q30VarA.f20163a.get(i2).setOnClickListener(new ViewOnClickListenerC1060a(iB, contactInfoItemA, cVar));
            if (e()) {
                q30VarA.f20163a.get(i2).setOnLongClickListener(new b(cVar));
            }
        }
        return view;
    }
}
