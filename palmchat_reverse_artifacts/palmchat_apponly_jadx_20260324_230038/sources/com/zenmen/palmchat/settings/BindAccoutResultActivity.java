package com.zenmen.palmchat.settings;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class BindAccoutResultActivity extends BaseActionBarActivity {
    public final void initActionBar() {
        initToolbar(R.string.set_account);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bind_account_result);
        initActionBar();
        ((TextView) findViewById(R.id.account)).setText(getIntent().getStringExtra("info"));
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
