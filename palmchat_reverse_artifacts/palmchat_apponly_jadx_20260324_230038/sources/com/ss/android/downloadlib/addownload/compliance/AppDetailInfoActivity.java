package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AppDetailInfoActivity extends Activity {
    private ListView b;
    private LinearLayout fx;
    private long iz;
    private TextView nr;
    private long pn;
    private ImageView u;
    private List<Pair<String, String>> x;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public View fx;
        public TextView nr;
        public TextView u;

        private nr() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends BaseAdapter {
        private u() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AppDetailInfoActivity.this.x.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return AppDetailInfoActivity.this.x.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            nr nrVar;
            if (view == null) {
                view = View.inflate(AppDetailInfoActivity.this, R.layout.ttdownloader_item_permission, null);
                nrVar = new nr();
                nrVar.u = (TextView) view.findViewById(R.id.tv_permission_title);
                nrVar.nr = (TextView) view.findViewById(R.id.tv_permission_description);
                nrVar.fx = view.findViewById(R.id.dash_line);
                view.setTag(nrVar);
            } else {
                nrVar = (nr) view.getTag();
            }
            nrVar.u.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.x.get(i)).first);
            nrVar.nr.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.x.get(i)).second);
            if (i == getCount() - 1) {
                nrVar.fx.setVisibility(8);
            }
            return view;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        x.u("lp_app_detail_click_close", this.iz);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (u()) {
            nr();
        } else {
            com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
        }
    }

    private void nr() {
        this.u = (ImageView) findViewById(R.id.iv_detail_back);
        this.nr = (TextView) findViewById(R.id.tv_empty);
        this.b = (ListView) findViewById(R.id.permission_list);
        this.fx = (LinearLayout) findViewById(R.id.ll_download);
        if (this.x.isEmpty()) {
            this.b.setVisibility(8);
            this.nr.setVisibility(0);
        } else {
            this.b.setAdapter((ListAdapter) new u());
        }
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.u("lp_app_detail_click_close", AppDetailInfoActivity.this.iz);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.fx.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.u("lp_app_detail_click_download", AppDetailInfoActivity.this.iz);
                com.ss.android.downloadlib.addownload.compliance.nr.u().nr(AppDetailInfoActivity.this.iz);
                com.ss.android.socialbase.appdownloader.fx.u((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.fx.u(com.ss.android.downloadlib.addownload.compliance.nr.u().nr());
            }
        });
    }

    public static void u(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean u() {
        this.pn = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.nr.nr nrVarU = fx.u().u(this.pn);
        if (nrVarU == null) {
            return false;
        }
        this.iz = nrVarU.nr;
        this.x = nrVarU.n;
        return true;
    }
}
