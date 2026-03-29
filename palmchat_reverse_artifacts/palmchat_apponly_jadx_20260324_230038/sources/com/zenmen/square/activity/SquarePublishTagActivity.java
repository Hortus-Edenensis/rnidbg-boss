package com.zenmen.square.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$color;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.tag.adapter.SquareTagAdapter;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.widget.SquareTagSelectHelper;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquarePublishTagActivity extends FrameworkBaseActivity {
    public SquareTagSelectHelper q;
    public TextView r;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList<SquareTagBean> selectedBeans = SquarePublishTagActivity.this.q.getSelectedBeans();
            if (selectedBeans == null || selectedBeans.isEmpty()) {
                return;
            }
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("tags", selectedBeans);
            SquarePublishTagActivity.this.setResult(-1, intent);
            SquarePublishTagActivity.this.finish();
        }
    }

    public final void C1() {
        ArrayList<SquareTagBean> selectedBeans = this.q.getSelectedBeans();
        if (selectedBeans == null || selectedBeans.isEmpty()) {
            this.r.setEnabled(false);
        } else {
            this.r.setEnabled(true);
        }
    }

    public final void D1() {
        this.q = (SquareTagSelectHelper) findViewById(R$id.tag);
        this.r = (TextView) findViewById(R$id.confirm);
        this.q.bind(new a());
        this.r.setOnClickListener(new b());
        C1();
    }

    public final void E1() {
        this.q.load();
    }

    public final void initActionBar() {
        initToolbar(R$id.toolbar, SquareBasePublishActivity.Z1(this), true);
        getToolbar().setBackgroundResource(R$color.white);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.square_layout_activity_publish_tag);
        initActionBar();
        D1();
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
    public class a implements SquareTagSelectHelper.f {
        public a() {
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void a() {
            SquarePublishTagActivity.this.C1();
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void b(SquareTagAdapter.a aVar) {
            SquarePublishTagActivity.this.C1();
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public SquareTagSelectHelper.Scene getScene() {
            return SquareTagSelectHelper.Scene.PUBLISH_TOTAL;
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void c() {
        }
    }
}
