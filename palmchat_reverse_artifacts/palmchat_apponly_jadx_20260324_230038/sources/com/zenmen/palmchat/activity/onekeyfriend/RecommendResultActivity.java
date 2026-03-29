package com.zenmen.palmchat.activity.onekeyfriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.k86;
import defpackage.st2;
import defpackage.zt5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecommendResultActivity extends BaseActionBarActivity {
    public static final String u = k86.i("activity.onekeyfriend.finish");
    public static final String v = k86.i("activity.onekeyfriend.godiscover");
    public Toolbar q;
    public TextView r;
    public ImageView s;
    public TextView t;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TeenagersModeManager.a().d()) {
                zt5.c();
                return;
            }
            Intent intentC = st2.c();
            intentC.putExtra("intent_key_from", "value_intent_from_secretary");
            intentC.putExtra("fromType", 1);
            LogUtil.onClickEvent("93322", null, null);
            RecommendResultActivity.this.startActivity(intentC);
            RecommendResultActivity.this.B1(true);
        }
    }

    public final void B1(boolean z) {
        Intent intent = new Intent(u);
        intent.putExtra(v, z);
        sendLocalBroadcast(intent);
        finish();
    }

    public final void C1() {
        this.q = initToolbar(-1);
        this.r = (TextView) findViewById(R.id.actionbar_title);
        this.s = (ImageView) findViewById(R.id.actionbar_title_icon);
        this.r.setText(R.string.recommend_friend_result_title);
        this.s.setVisibility(8);
        setSupportActionBar(this.q);
    }

    public final void D1() {
        TextView textView = (TextView) findViewById(R.id.btn_enter_nearby);
        this.t = textView;
        textView.setOnClickListener(new a());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        B1(false);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recommend_result);
        C1();
        D1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        B1(false);
        return true;
    }
}
