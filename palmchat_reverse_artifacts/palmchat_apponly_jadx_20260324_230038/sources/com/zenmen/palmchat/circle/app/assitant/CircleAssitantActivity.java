package com.zenmen.palmchat.circle.app.assitant;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleEditWelcomeActivity;
import defpackage.c70;
import defpackage.j70;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleAssitantActivity extends BaseActionBarActivity {
    public ListView q;
    public String r;
    public TextView s;
    public CircleItem t;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(CircleAssitantActivity.this, CircleEditWelcomeActivity.class);
            intent.putExtra(j70.f18338a, CircleAssitantActivity.this.r);
            CircleAssitantActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<CircleItem>> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleItem> baseResponse) {
            CircleAssitantActivity.this.t = baseResponse.getData();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_assitant);
        setSupportActionBar(initToolbar("小助手"));
        this.r = getIntent().getStringExtra(j70.f18338a);
        this.q = (ListView) findViewById(R.id.circle_assitant_list);
        findViewById(R.id.circle_set_welcome).setOnClickListener(new a());
        this.s = (TextView) findViewById(R.id.circle_welcome_content);
        c70.R().k0(this.r, new b());
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
