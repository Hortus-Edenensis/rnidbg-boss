package com.zenmen.palmchat.test;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SxActivity extends BaseActionBarActivity {
    public Context q;
    public String r = "SxFragment";

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sx);
        this.q = this;
        initToolbar(-1).setBackgroundResource(R.color.color_trans);
        Button button = (Button) findViewById(R.id.btn_test);
        findViewById(R.id.rootView);
        button.setOnClickListener(new a());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
