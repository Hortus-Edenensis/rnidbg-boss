package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.widget.CommonInfoCellView;
import defpackage.nl0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VenusPrivacyActivity extends BaseActionBarActivity {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VenusPrivacyActivity.this.C1(nl0.d + "/help/legal/lxAnchor.html");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VenusPrivacyActivity.this.C1(nl0.d + "/help/legal/realnameQuthentication.html");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VenusPrivacyActivity.this.C1("https://ebinfo.shengpay.com/protocol/lxagreement.html");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VenusPrivacyActivity.this.C1(nl0.d + "/help/legal/giftAgreement.html");
        }
    }

    public final void B1() {
        ((CommonInfoCellView) findViewById(R.id.privacy1)).setClickListener(new a());
        ((CommonInfoCellView) findViewById(R.id.privacy2)).setClickListener(new b());
        ((CommonInfoCellView) findViewById(R.id.privacy3)).setClickListener(new c());
        ((CommonInfoCellView) findViewById(R.id.privacy4)).setClickListener(new d());
    }

    public final void C1(String str) {
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_venus_privacy);
        initToolbar("已签约协议");
        B1();
    }
}
