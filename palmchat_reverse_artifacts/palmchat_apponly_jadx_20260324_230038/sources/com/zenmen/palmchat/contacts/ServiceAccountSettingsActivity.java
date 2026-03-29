package com.zenmen.palmchat.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import defpackage.bo0;
import defpackage.c65;
import defpackage.d65;
import defpackage.fn0;
import defpackage.qm5;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ServiceAccountSettingsActivity extends BaseActionBarActivity {
    public ContactInfoItem q;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInfoItem contactInfoItemL = bo0.r().l(ServiceAccountSettingsActivity.this.q.getUid());
            if (contactInfoItemL != null) {
                contactInfoItemL.setIdentifyCode(ServiceAccountSettingsActivity.this.q.getIdentifyCode());
                ServiceAccountSettingsActivity.this.q = contactInfoItemL;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13465a;

        public b(ContactInfoItem contactInfoItem) {
            this.f13465a = contactInfoItem;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            d65.n(this.f13465a, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13466a;

        public c(ContactInfoItem contactInfoItem) {
            this.f13466a = contactInfoItem;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ServiceAccountSettingsActivity.this.E1("account_set_switch02", z);
            d65.l(this.f13466a, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13467a;

        public d(ContactInfoItem contactInfoItem) {
            this.f13467a = contactInfoItem;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ServiceAccountSettingsActivity.this.E1("account_set_switch04", z);
            d65.m(this.f13467a, z);
        }
    }

    public static boolean D1(ContactInfoItem contactInfoItem) {
        return d65.f(contactInfoItem) || d65.h(contactInfoItem) || d65.j(contactInfoItem);
    }

    public static void G1(Context context, ContactInfoItem contactInfoItem) {
        Intent intent = new Intent(context, (Class<?>) ServiceAccountSettingsActivity.class);
        intent.putExtra("key_contact_info", contactInfoItem);
        intent.addFlags(536870912);
        context.startActivity(intent);
    }

    public final void E1(String str, boolean z) {
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, this.q.getUid());
        map.put("status", z ? "1" : "0");
        c65.b(str, map);
    }

    public final void F1() {
        ContactInfoItem contactInfoItem = this.q;
        initToolbar(R.string.string_bottle_setting_toolbar);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_top_set);
        View viewFindViewById = findViewById(R.id.layout_top_set);
        if (d65.j(contactInfoItem)) {
            checkBox.setChecked(d65.i(contactInfoItem));
            checkBox.setOnCheckedChangeListener(new b(contactInfoItem));
        } else {
            viewFindViewById.setVisibility(8);
        }
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.cb_mute_notify);
        View viewFindViewById2 = findViewById(R.id.layout_mute_notice);
        if (d65.f(contactInfoItem)) {
            boolean zE = d65.e(contactInfoItem);
            E1("account_set_switch01", zE);
            checkBox2.setChecked(zE);
            checkBox2.setOnCheckedChangeListener(new c(contactInfoItem));
        } else {
            viewFindViewById2.setVisibility(8);
        }
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.cb_receive_msg);
        View viewFindViewById3 = findViewById(R.id.layout_receive_msg);
        View viewFindViewById4 = findViewById(R.id.tv_receive_msg_tip);
        if (d65.h(contactInfoItem)) {
            boolean zG = d65.g(contactInfoItem);
            E1("account_set_switch03", zG);
            checkBox3.setChecked(zG);
            checkBox3.setOnCheckedChangeListener(new d(contactInfoItem));
        } else {
            viewFindViewById3.setVisibility(8);
            viewFindViewById4.setVisibility(8);
        }
        c65.c("account_set_p01", this.q.getUid());
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = (ContactInfoItem) getIntent().getParcelableExtra("key_contact_info");
        setContentView(R.layout.layout_activity_service_account_settings);
        F1();
        bo0.r().i().j(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bo0.r().i().l(this);
    }
}
