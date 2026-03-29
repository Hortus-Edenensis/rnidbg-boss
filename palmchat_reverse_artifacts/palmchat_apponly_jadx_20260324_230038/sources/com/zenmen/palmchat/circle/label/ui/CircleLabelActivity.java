package com.zenmen.palmchat.circle.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.label.bean.CircleLabel;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.circle.label.ui.view.CircleLabelEditView;
import com.zenmen.palmchat.circle.label.ui.view.CircleLabelFlowLayout;
import com.zenmen.palmchat.circle.label.ui.view.CircleLabelRecommendView;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.c70;
import defpackage.fa0;
import defpackage.ha0;
import defpackage.ja0;
import defpackage.oy5;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleLabelActivity extends BaseActionBarActivity {
    public EditText q;
    public CircleLabelFlowLayout<CircleLabelEditView> r;
    public CircleLabelFlowLayout<CircleLabelRecommendView> s;
    public TextView t;
    public ha0 u;
    public GroupInfoItem v;
    public boolean w;
    public oy5 x;
    public final CircleLabelEditView.a y = new CircleLabelEditView.a() { // from class: ba0
        @Override // com.zenmen.palmchat.circle.label.ui.view.CircleLabelEditView.a
        public final void a(CircleLabel circleLabel) {
            this.f1674a.P1(circleLabel);
        }
    };

    public static List<RoomTag> G1(Intent intent) {
        return (ArrayList) intent.getSerializableExtra("choose_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M1(View view) {
        U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(int i) {
        V1(i > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(View view) {
        String string = this.q.getText().toString();
        if (TextUtils.isEmpty(string) || string.length() > 4) {
            return;
        }
        if (this.r.getChooseViews().size() >= 3) {
            this.x.d(this, R.string.circle_label_choose_limit, 0);
        } else {
            if (L1(string)) {
                return;
            }
            this.r.addLabelChildView(ja0.b(this, string, this.y), 0);
            this.q.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1(CircleLabel circleLabel) {
        CircleLabelRecommendView circleLabelRecommendView;
        if (circleLabel.originGroup == 2 && (circleLabelRecommendView = (CircleLabelRecommendView) this.s.unCheckLabelView(circleLabel.id)) != null) {
            circleLabelRecommendView.getData().isChoose = false;
            circleLabelRecommendView.updateState();
        }
        this.r.removeLabelView(circleLabel.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1(CircleLabelRecommendView circleLabelRecommendView, CircleLabel circleLabel) {
        J1();
        if (circleLabel.isChoose) {
            circleLabel.isChoose = false;
            circleLabelRecommendView.updateState();
            if (circleLabel.originGroup != 2 || TextUtils.isEmpty(circleLabel.id)) {
                return;
            }
            this.r.removeLabelView(circleLabel.id);
            return;
        }
        if (this.r.getChooseViews().size() >= 3) {
            this.x.d(this, R.string.circle_label_choose_limit, 0);
        } else {
            if (L1(circleLabel.labelName)) {
                return;
            }
            circleLabel.isChoose = true;
            circleLabelRecommendView.updateState();
            this.r.addLabelChildView(ja0.a(this, fa0.a(circleLabel), this.y), 0);
        }
    }

    public static void X1(Activity activity, GroupInfoItem groupInfoItem, int i) {
        Intent intent = new Intent(activity, (Class<?>) CircleLabelActivity.class);
        intent.putExtra("info_item", groupInfoItem);
        activity.startActivityForResult(intent, i);
    }

    public boolean F1() {
        GroupInfoItem groupInfoItem = this.v;
        return groupInfoItem != null && (groupInfoItem.getRoleType() == 1 || this.v.getRoleType() == 2);
    }

    public final void H1() {
        this.v = (GroupInfoItem) getIntent().getParcelableExtra("info_item");
        this.w = F1();
    }

    public final void I1() {
        if (this.w) {
            return;
        }
        findViewById(R.id.clb_ed_rl).setVisibility(8);
        this.t.setVisibility(8);
    }

    public final void J1() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public final void K1() {
        this.s = (CircleLabelFlowLayout) findViewById(R.id.clb_r_rv);
        CircleLabelFlowLayout<CircleLabelEditView> circleLabelFlowLayout = (CircleLabelFlowLayout) findViewById(R.id.clb_c_container);
        this.r = circleLabelFlowLayout;
        circleLabelFlowLayout.setLabelContainChangeListener(new CircleLabelFlowLayout.a() { // from class: z90
            @Override // com.zenmen.palmchat.circle.label.ui.view.CircleLabelFlowLayout.a
            public final void a(int i) {
                this.f22379a.N1(i);
            }
        });
        this.q = (EditText) findViewById(R.id.custom_label_ed);
        ((TextView) findViewById(R.id.label_add)).setOnClickListener(new View.OnClickListener() { // from class: aa0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1184a.O1(view);
            }
        });
    }

    public final boolean L1(String str) {
        if (!this.r.isExistLabelName(str)) {
            return false;
        }
        this.x.d(this, R.string.circle_label_choose_duplicate, 0);
        return true;
    }

    public void R1(List<CircleLabel> list) {
        Iterator<CircleLabel> it = list.iterator();
        while (it.hasNext()) {
            this.r.addLabelChildView(ja0.a(this, it.next(), this.y));
        }
    }

    public void S1(List<CircleLabel> list) {
        Iterator<CircleLabel> it = list.iterator();
        while (it.hasNext()) {
            final CircleLabelRecommendView circleLabelRecommendViewC = ja0.c(this, it.next());
            if (this.w) {
                circleLabelRecommendViewC.setLabelRecClickListener(new CircleLabelRecommendView.a() { // from class: da0
                    @Override // com.zenmen.palmchat.circle.label.ui.view.CircleLabelRecommendView.a
                    public final void a(CircleLabel circleLabel) {
                        this.f17003a.Q1(circleLabelRecommendViewC, circleLabel);
                    }
                });
            }
            this.s.addLabelChildView(circleLabelRecommendViewC);
        }
    }

    public void T1() {
        ArrayList arrayList = new ArrayList();
        for (CircleLabel circleLabel : this.r.getChooseLabels()) {
            RoomTag roomTag = new RoomTag();
            roomTag.tagId = circleLabel.id;
            roomTag.tagName = circleLabel.labelName;
            arrayList.add(roomTag);
        }
        c70.R().C0(false, new String[0]);
        Intent intent = new Intent();
        intent.putExtra("choose_list", arrayList);
        setResult(-1, intent);
        finish();
    }

    public final void U1() {
        this.u.f(this.v.getGroupId(), this.r.getChooseLabels());
    }

    public final void V1(boolean z) {
        findViewById(R.id.clb_c_title).setVisibility(z ? 0 : 8);
        findViewById(R.id.clb_c_container).setVisibility(z ? 0 : 8);
    }

    public void W1(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.send_failed);
        }
        sy5.f(this, str, 0).g();
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        ((TextView) findViewById(R.id.title)).setText(getString(R.string.circle_label_custom));
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        this.t = textView;
        textView.setVisibility(0);
        this.t.setText(R.string.circle_ok);
        this.t.setTextSize(16.0f);
        this.t.setTextColor(getResources().getColor(R.color.color_222222));
        this.t.setOnClickListener(new View.OnClickListener() { // from class: ca0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1932a.M1(view);
            }
        });
        setSupportActionBar(toolbarInitToolbar);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_label_info);
        initActionBar();
        H1();
        K1();
        I1();
        ha0 ha0Var = new ha0(this.w);
        this.u = ha0Var;
        ha0Var.c(this);
        this.u.e(this.v.getGroupId());
        this.x = new oy5();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.u.d();
        this.x.b();
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
