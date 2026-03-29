package com.zenmen.palmchat.settings.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.picker.wheel.DateWheelPicker;
import defpackage.ai5;
import defpackage.dn0;
import defpackage.f56;
import defpackage.iq5;
import defpackage.l50;
import defpackage.sy5;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CompleteGenderBirthdayDialog extends LXBottomSheetDialog {
    public View h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public DateWheelPicker m;
    public TextView n;
    public String o;
    public int p;
    public int q;
    public g r;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CompleteGenderBirthdayDialog.this.p = 0;
            CompleteGenderBirthdayDialog.this.J();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CompleteGenderBirthdayDialog.this.p = 1;
            CompleteGenderBirthdayDialog.this.J();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            String birthday = CompleteGenderBirthdayDialog.this.m.getBirthday();
            if (!TextUtils.isEmpty(birthday)) {
                CompleteGenderBirthdayDialog completeGenderBirthdayDialog = CompleteGenderBirthdayDialog.this;
                completeGenderBirthdayDialog.I(completeGenderBirthdayDialog.p, birthday);
            }
            zn6.c("pagediscover_pagegenderage_next", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, String> {
        public d() {
            put("from", String.valueOf(CompleteGenderBirthdayDialog.this.q));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {
        public e() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            CompleteGenderBirthdayDialog.this.q();
            if (jSONObject.optInt("resultCode", -1) != 0) {
                sy5.e(CompleteGenderBirthdayDialog.this.getContext(), R.string.send_failed, 0).g();
                return;
            }
            if (CompleteGenderBirthdayDialog.this.r != null) {
                iq5.j(false, new String[0]);
                CompleteGenderBirthdayDialog.this.r.onSuccess();
                CompleteGenderBirthdayDialog.this.r = null;
            }
            CompleteGenderBirthdayDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            CompleteGenderBirthdayDialog.this.q();
            sy5.e(CompleteGenderBirthdayDialog.this.getContext(), R.string.send_failed, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void onCancel();

        void onSuccess();
    }

    public CompleteGenderBirthdayDialog(@NonNull Context context, int i) {
        super(context);
        this.o = AccountUtils.p(getContext());
        this.q = i;
        ContactInfoItem contactInfoItemA = dn0.a(AccountUtils.p(getContext()));
        if (contactInfoItemA != null) {
            this.p = contactInfoItemA.getGender();
        }
    }

    public final void G() {
        this.i = (TextView) this.h.findViewById(R.id.tv_text_title);
        String pagegenderagetitle = ai5.k().j().getGuideInfo().getPagegenderagetitle();
        if (!TextUtils.isEmpty(pagegenderagetitle)) {
            this.i.setText(pagegenderagetitle);
        }
        this.j = (TextView) this.h.findViewById(R.id.tv_text_subtitle);
        String pagegenderageintro = ai5.k().j().getGuideInfo().getPagegenderageintro();
        if (!TextUtils.isEmpty(pagegenderageintro)) {
            this.j.setText(pagegenderageintro);
        }
        TextView textView = (TextView) this.h.findViewById(R.id.btn_male);
        this.k = textView;
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) this.h.findViewById(R.id.btn_female);
        this.l = textView2;
        textView2.setOnClickListener(new b());
        this.m = (DateWheelPicker) this.h.findViewById(R.id.birthday_view);
        TextView textView3 = (TextView) this.h.findViewById(R.id.btn_next);
        this.n = textView3;
        textView3.setOnClickListener(new c());
        J();
        zn6.h("pagediscover_pagegenderage", "view", new d());
    }

    public void H(g gVar) {
        this.r = gVar;
    }

    public void I(int i, String str) {
        y();
        f56 f56Var = new f56(new e(), new f());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DeviceInfoUtil.UID_TAG, this.o);
            jSONObject.put("birthday", str);
            jSONObject.put("sex", i);
            f56Var.o(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
            q();
        }
    }

    public final void J() {
        if (this.h != null) {
            this.n.setEnabled(this.p >= 0);
            this.k.setSelected(this.p == 0);
            this.l.setSelected(this.p == 1);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        g gVar = this.r;
        if (gVar != null) {
            gVar.onCancel();
            this.r = null;
            zn6.c("pagediscover_pagegenderage_close", "click");
        }
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        this.h = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_complete_gender_birthday, (ViewGroup) null);
        G();
        return this.h;
    }
}
