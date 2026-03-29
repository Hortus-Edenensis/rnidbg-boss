package com.zenmen.palmchat.conversations.threadsnew.riskthread;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.by5;
import defpackage.ly4;
import defpackage.sd3;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RiskThreadsListActivity extends BaseActionBarActivity {
    public RecyclerView q;
    public Toolbar r;
    public TextView s;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RcySAdapter<RiskThreadItem, RcyHolder> {
        public final /* synthetic */ List j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, int i, List list) {
            super(context, i);
            this.j = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(RiskThreadItem riskThreadItem, View view) {
            RiskThreadsListActivity.this.E1(riskThreadItem);
            ly4.d().o(true, riskThreadItem.fid);
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, final RiskThreadItem riskThreadItem, int i) {
            ((LXPortraitView) rcyHolder.l(R.id.icon)).setAvatarView(riskThreadItem.icon, null);
            ((TextView) rcyHolder.l(R.id.title)).setText(riskThreadItem.name);
            ((TextView) rcyHolder.l(R.id.message)).setText(riskThreadItem.fid);
            TextView textView = (TextView) rcyHolder.l(R.id.date);
            long j = riskThreadItem.time;
            if (j > 0) {
                textView.setText(by5.e(j, this.e));
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            View viewL = rcyHolder.l(R.id.noMore);
            if (i == this.j.size() - 1) {
                viewL.setVisibility(0);
                ((TextView) rcyHolder.l(R.id.riskShowTime)).setText(ly4.d().i());
            } else {
                viewL.setVisibility(8);
            }
            View viewL2 = rcyHolder.l(R.id.notice);
            if (i == 0) {
                viewL2.setVisibility(0);
            } else {
                viewL2.setVisibility(8);
            }
            rcyHolder.l(R.id.contentLayout).setOnClickListener(new View.OnClickListener() { // from class: my4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f19393a.k(riskThreadItem, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    public final void B1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.r = toolbarInitToolbar;
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.title);
        this.s = textView;
        textView.setText("异常账号消息过滤");
        setSupportActionBar(this.r);
    }

    public final void C1() {
        this.q = (RecyclerView) findViewById(R.id.listView);
        List<RiskThreadItem> listE = ly4.d().e();
        if (listE == null) {
            return;
        }
        a aVar = new a(this, R.layout.list_item_risk_thread, listE);
        this.q.setAdapter(aVar);
        this.q.setLayoutManager(new LinearLayoutManager(this, 1, false));
        aVar.g(ly4.d().e(), true);
        ly4.d().o(false, null);
    }

    public final void E1(RiskThreadItem riskThreadItem) {
        new sd3(this).U("警告").k(ly4.d().h(riskThreadItem.fid)).P("我知道了").f(new b()).e().show();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D1();
        setContentView(R.layout.activity_risk_threads_list);
        B1();
        C1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void D1() {
    }
}
