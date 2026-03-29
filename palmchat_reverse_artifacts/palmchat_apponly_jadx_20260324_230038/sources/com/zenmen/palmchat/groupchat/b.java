package com.zenmen.palmchat.groupchat;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bq6;
import defpackage.gr2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14317a;
    public InterfaceC1061b b;
    public LinearLayout c;
    public HorizontalScrollView d;
    public final int e = 2;
    public int f = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.b != null) {
                b.this.b.a((ContactInfoItem) view.getTag());
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.groupchat.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1061b {
        void a(ContactInfoItem contactInfoItem);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SocialPortraitView f14319a;
        public TextView b;
        public final View c;

        public c(View view) {
            this.f14319a = (SocialPortraitView) view.findViewById(R.id.portrait);
            this.b = (TextView) view.findViewById(R.id.first_name);
            this.c = view.findViewById(R.id.cover);
        }
    }

    public b(Context context, InterfaceC1061b interfaceC1061b, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout) {
        this.f14317a = context;
        this.b = interfaceC1061b;
        this.d = horizontalScrollView;
        this.c = linearLayout;
    }

    public void b(c cVar, ContactInfoItem contactInfoItem) {
        cVar.f14319a.changeShapeType(3);
        cVar.f14319a.setDegreeForRoundRectangle(10, 10);
        if (contactInfoItem != null && "phone contact".equals(contactInfoItem.getIconURL())) {
            cVar.f14319a.setVisibility(8);
            cVar.b.setVisibility(0);
            if (!TextUtils.isEmpty(contactInfoItem.getNickName()) && contactInfoItem.getNickName().trim().length() > 0) {
                cVar.b.setText(contactInfoItem.getNickName().trim().substring(0, 1));
            }
        } else if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getIconURL())) {
            cVar.f14319a.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(contactInfoItem.getIconURL(), cVar.f14319a, bq6.s());
        }
        cVar.c.setVisibility(8);
    }

    public void c() {
        for (int childCount = this.c.getChildCount(); childCount > 0; childCount--) {
            this.c.removeViewAt(childCount - 1);
        }
    }

    public void d() {
        ContactInfoItem contactInfoItem;
        int i = this.f + 1;
        this.f = i;
        int i2 = i % 2;
        this.f = i2;
        if (i2 != 0 || this.c.getChildCount() <= 0) {
            contactInfoItem = null;
        } else {
            contactInfoItem = (ContactInfoItem) this.c.getChildAt(r0.getChildCount() - 1).getTag();
        }
        InterfaceC1061b interfaceC1061b = this.b;
        if (interfaceC1061b != null) {
            interfaceC1061b.a(contactInfoItem);
        }
        if (this.c.getChildCount() <= 0 || this.f <= 0) {
            return;
        }
        this.c.getChildAt(r0.getChildCount() - 1).findViewById(R.id.cover).setVisibility(0);
    }

    public void e(ContactInfoItem contactInfoItem) {
        boolean z;
        this.f = 0;
        int i = 0;
        while (true) {
            if (i >= this.c.getChildCount()) {
                i = 0;
                z = false;
                break;
            }
            ContactInfoItem contactInfoItem2 = (ContactInfoItem) this.c.getChildAt(i).getTag();
            if (contactInfoItem2 != null && contactInfoItem != null && TextUtils.equals(contactInfoItem2.getUid(), contactInfoItem.getUid())) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.c.removeViewAt(i);
        } else {
            View viewInflate = LayoutInflater.from(this.f14317a).inflate(R.layout.list_item_group_init_activity_chosen_list, (ViewGroup) null, false);
            viewInflate.setTag(contactInfoItem);
            b(new c(viewInflate), contactInfoItem);
            this.c.addView(viewInflate);
            viewInflate.setOnClickListener(new a());
        }
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            this.c.getChildAt(i2).findViewById(R.id.cover).setVisibility(8);
        }
    }
}
