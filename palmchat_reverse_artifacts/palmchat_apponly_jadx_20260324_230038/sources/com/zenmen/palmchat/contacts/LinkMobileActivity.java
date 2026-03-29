package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.settings.ChangeMobileActivity;
import defpackage.k86;
import defpackage.on0;
import org.apache.webplatform.jssdk.ContactPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LinkMobileActivity extends BaseActionBarActivity {
    public String q;
    public boolean r;

    public final void A1() {
        this.r = AppContext.getContext().getTrayPreferences().a(k86.n(), false);
        TextView textView = (TextView) findViewById(R.id.linked_mobile_text);
        if (getIntent().getIntExtra("link_mobile_state", 0) == 1) {
            String stringExtra = getIntent().getStringExtra("phone");
            if (stringExtra != null && stringExtra.length() > 8) {
                int length = stringExtra.length();
                stringExtra = stringExtra.substring(0, length - 8) + "****" + stringExtra.substring(length - 4, length);
            }
            textView.setText(Html.fromHtml(getString(R.string.linked_mobile_text, "<font color='#1dc1fc'>+" + getIntent().getStringExtra("ic") + " " + stringExtra + "</font>")));
            findViewById(R.id.upload_contacts_btn).setVisibility(8);
            findViewById(R.id.change_mobile_btn).setVisibility(8);
            findViewById(R.id.completed_btn).setVisibility(0);
            return;
        }
        String strK = AccountUtils.k(this);
        if (strK != null && strK.length() > 8) {
            int length2 = strK.length();
            strK = strK.substring(0, length2 - 8) + "****" + strK.substring(length2 - 4, length2);
        }
        textView.setText(Html.fromHtml(getString(R.string.linked_mobile_text, "<font color='#1dc1fc'>+" + AccountUtils.i(this) + " " + strK + "</font>")));
        if (this.r) {
            ((TextView) findViewById(R.id.upload_contacts_btn)).setText(R.string.check_phone_contacts);
            ((TextView) findViewById(R.id.background_decription)).setText(R.string.link_mobile_tips);
        }
    }

    public final void B1(Intent intent) {
        if (intent == null) {
            return;
        }
        this.q = intent.getStringExtra(ContactPlugin.EXTRA_KEY_FROM);
    }

    public final void initActionBar() {
        initToolbar(R.string.link_mobile);
    }

    public void onChangeMobileClicked(View view) {
        startActivity(new Intent(this, (Class<?>) ChangeMobileActivity.class));
        finish();
    }

    public void onCompletedClicked(View view) {
        finish();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_link_mobile);
        B1(getIntent());
        initActionBar();
        A1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onUploadContactsClicked(View view) {
        if (this.r) {
            startActivity(on0.a(this.q));
            finish();
        } else {
            AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            startActivity(on0.a(this.q));
            finish();
        }
    }
}
