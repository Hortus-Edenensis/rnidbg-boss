package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GeneralSettingsActivity extends BaseActionBarActivity {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GeneralSettingsActivity.this.startActivity(new Intent(GeneralSettingsActivity.this, (Class<?>) CleanStorageActivity.class));
        }
    }

    public final void A1() {
        findViewById(R.id.clean_storage).setOnClickListener(new a());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 156;
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_message_general);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_common_settings);
        initActionBar();
        A1();
    }
}
