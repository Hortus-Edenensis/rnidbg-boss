package com.zenmen.palmchat.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NetUnavailableActivity extends BaseActionBarActivity {
    public Toolbar q;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NetUnavailableActivity.this.finish();
        }
    }

    public final void A1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.net_status_unavailable);
        this.q = toolbarInitToolbar;
        toolbarInitToolbar.setNavigationIcon(R.drawable.ic_clear_white);
        this.q.setNavigationOnClickListener(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_net_unavailable);
        A1();
    }
}
