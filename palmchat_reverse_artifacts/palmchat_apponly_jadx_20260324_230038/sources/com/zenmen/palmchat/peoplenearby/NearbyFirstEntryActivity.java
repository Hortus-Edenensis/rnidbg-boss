package com.zenmen.palmchat.peoplenearby;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NearbyFirstEntryActivity extends BaseActionBarActivity {
    public TextView q;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NearbyFirstEntryActivity.this.setBack2MainTab(false, "tab_msg");
            Intent intent = new Intent();
            Intent intent2 = NearbyFirstEntryActivity.this.getIntent();
            if (intent2 != null && "value_intent_from_secretary".equals(intent2.getStringExtra("intent_key_from"))) {
                intent.putExtra("intent_key_from", "value_intent_from_secretary");
            }
            intent.setClass(NearbyFirstEntryActivity.this, PeopleNearbyActivity.class);
            intent.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, true);
            intent.putExtra("intent_key_from_firstentry", true);
            if (NearbyFirstEntryActivity.this.getIntent() != null) {
                intent.putExtra("fromType", NearbyFirstEntryActivity.this.getIntent().getIntExtra("fromType", 0));
            }
            NearbyFirstEntryActivity.this.startActivity(intent);
            NearbyFirstEntryActivity.this.finish();
        }
    }

    public final void A1() {
        TextView textView = (TextView) findViewById(R.id.search);
        this.q = textView;
        textView.setOnClickListener(new a());
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_item_fujinderen);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_nearby_first_entry);
        initActionBar();
        A1();
    }
}
