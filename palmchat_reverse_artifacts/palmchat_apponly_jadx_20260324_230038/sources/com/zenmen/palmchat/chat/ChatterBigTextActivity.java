package com.zenmen.palmchat.chat;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import defpackage.vl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatterBigTextActivity extends BaseActionBarActivity implements View.OnClickListener {
    public TextView q;
    public String r = null;

    public final void A1() {
        setSupportActionBar(initToolbar(""));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_fragment_big_text);
        A1();
        this.q = (TextView) findViewById(R.id.text);
        String stringExtra = getIntent().getStringExtra("big_text");
        this.r = stringExtra;
        this.q.setText(vl1.c(stringExtra, this, vl1.g));
        findViewById(R.id.container).setOnClickListener(this);
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
