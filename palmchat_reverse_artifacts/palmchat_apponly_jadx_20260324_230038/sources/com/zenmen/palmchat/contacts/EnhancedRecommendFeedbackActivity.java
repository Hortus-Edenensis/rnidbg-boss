package com.zenmen.palmchat.contacts;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.io0;
import defpackage.k86;
import defpackage.sy5;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class EnhancedRecommendFeedbackActivity extends BaseActionBarActivity {
    public LinearLayout q;
    public RadioGroup r;
    public EditText s;
    public TextView t;
    public int u = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.radioButton1 /* 2131366652 */:
                    EnhancedRecommendFeedbackActivity.this.u = 1;
                    break;
                case R.id.radioButton2 /* 2131366653 */:
                    EnhancedRecommendFeedbackActivity.this.u = 2;
                    break;
            }
            EnhancedRecommendFeedbackActivity.this.q.setEnabled(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_has_feedback"), Boolean.TRUE);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", EnhancedRecommendFeedbackActivity.this.u);
                LogUtil.onClickEvent("2R2", null, jSONObject.toString());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("content", EnhancedRecommendFeedbackActivity.this.s.getText().toString().trim());
                LogUtil.onClickEvent("2R3", null, jSONObject2.toString());
                LogUtil.onClickEvent("2R4", null, null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            sy5.e(AppContext.getContext(), R.string.enhanced_recommend_feedback_success, 0).g();
            EnhancedRecommendFeedbackActivity.this.finish();
        }
    }

    public final void E1() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.feedback_radioGroup);
        this.r = radioGroup;
        radioGroup.setOnCheckedChangeListener(new a());
        this.r.requestFocus();
        EditText editText = (EditText) findViewById(R.id.feedback_content_edit);
        this.s = editText;
        editText.addTextChangedListener(new b());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.submit_btn);
        this.q = linearLayout;
        linearLayout.setEnabled(false);
        this.q.setOnClickListener(new c());
        this.t = (TextView) findViewById(R.id.feedback_tip);
        int iG = io0.g();
        if (iG <= 0) {
            this.t.setText(R.string.enhanced_recommend_feedback_tip_0_day);
        } else {
            this.t.setText(getString(R.string.enhanced_recommend_feedback_tip, Integer.valueOf(iG)));
        }
        LogUtil.onClickEvent("2R0", null, null);
    }

    public final void initActionBar() {
        setSupportActionBar(initToolbar(R.string.enhanced_recommend_feedback));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_enhanced_recommend_feedback);
        initActionBar();
        E1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
