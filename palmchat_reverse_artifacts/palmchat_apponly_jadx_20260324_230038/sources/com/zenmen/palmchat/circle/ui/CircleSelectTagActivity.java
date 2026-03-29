package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleTagItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import defpackage.c70;
import defpackage.j70;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleSelectTagActivity extends BaseActionBarActivity {
    public String q;
    public EditText r;
    public TextView s;
    public ListView t;
    public f u;
    public ArrayList<CircleTagItem> v;
    public Toolbar w;
    public TextView x;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<ArrayList<CircleTagItem>>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<ArrayList<CircleTagItem>> baseResponse) {
            CircleSelectTagActivity.this.v = baseResponse.getData();
            TextView textView = CircleSelectTagActivity.this.x;
            CircleSelectTagActivity circleSelectTagActivity = CircleSelectTagActivity.this;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(CollectionUtils.isEmpty(circleSelectTagActivity.v) ? 0 : CircleSelectTagActivity.this.v.size());
            textView.setText(circleSelectTagActivity.getString(R.string.circle_tag_count, objArr));
            CircleSelectTagActivity.this.u.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("circle_tag_list", CircleSelectTagActivity.this.v);
            CircleSelectTagActivity.this.setResult(-1, intent);
            CircleSelectTagActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleSelectTagActivity circleSelectTagActivity = CircleSelectTagActivity.this;
            circleSelectTagActivity.I1(circleSelectTagActivity.r.getText().toString().trim());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<Map<String, Long>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13244a;

        public d(String str) {
            this.f13244a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<Map<String, Long>> baseResponse) {
            CircleSelectTagActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                CircleSelectTagActivity.this.L1(baseResponse.getErrorMsg());
                return;
            }
            c70.R().C0(false, new String[0]);
            Map<String, Long> data = baseResponse.getData();
            CircleTagItem circleTagItem = new CircleTagItem();
            circleTagItem.setTagName(this.f13244a);
            circleTagItem.setTagId(data.get("tagId").longValue());
            if (CircleSelectTagActivity.this.v == null) {
                CircleSelectTagActivity.this.v = new ArrayList();
            }
            CircleSelectTagActivity.this.v.add(circleTagItem);
            CircleSelectTagActivity.this.u.notifyDataSetChanged();
            TextView textView = CircleSelectTagActivity.this.x;
            CircleSelectTagActivity circleSelectTagActivity = CircleSelectTagActivity.this;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(CollectionUtils.isEmpty(circleSelectTagActivity.v) ? 0 : CircleSelectTagActivity.this.v.size());
            textView.setText(circleSelectTagActivity.getString(R.string.circle_tag_count, objArr));
            CircleSelectTagActivity.this.r.setText("");
            CircleSelectTagActivity circleSelectTagActivity2 = CircleSelectTagActivity.this;
            circleSelectTagActivity2.L1(circleSelectTagActivity2.getString(R.string.cicle_tag_add_succ));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends wi0<BaseResponse<Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13245a;

        public e(String str) {
            this.f13245a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<Boolean> baseResponse) {
            CircleSelectTagActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                CircleSelectTagActivity circleSelectTagActivity = CircleSelectTagActivity.this;
                circleSelectTagActivity.L1(circleSelectTagActivity.getString(R.string.circle_tag_remove_failed));
                return;
            }
            c70.R().C0(false, new String[0]);
            Iterator it = CircleSelectTagActivity.this.v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (TextUtils.equals(this.f13245a, String.valueOf(((CircleTagItem) it.next()).getTagId()))) {
                    it.remove();
                    break;
                }
            }
            TextView textView = CircleSelectTagActivity.this.x;
            CircleSelectTagActivity circleSelectTagActivity2 = CircleSelectTagActivity.this;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(CollectionUtils.isEmpty(circleSelectTagActivity2.v) ? 0 : CircleSelectTagActivity.this.v.size());
            textView.setText(circleSelectTagActivity2.getString(R.string.circle_tag_count, objArr));
            CircleSelectTagActivity.this.u.notifyDataSetChanged();
            c70.R().C0(false, new String[0]);
            CircleSelectTagActivity circleSelectTagActivity3 = CircleSelectTagActivity.this;
            circleSelectTagActivity3.L1(circleSelectTagActivity3.getString(R.string.circle_tag_remove_succ));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LayoutInflater f13246a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CircleTagItem f13247a;

            public a(CircleTagItem circleTagItem) {
                this.f13247a = circleTagItem;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CircleSelectTagActivity.this.J1(String.valueOf(this.f13247a.getTagId()));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f13248a;
            public ImageView b;

            public b() {
            }
        }

        public f(Context context) {
            this.f13246a = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (CollectionUtils.isEmpty(CircleSelectTagActivity.this.v)) {
                return 0;
            }
            return CircleSelectTagActivity.this.v.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return CircleSelectTagActivity.this.v.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            b bVar;
            if (view == null) {
                bVar = new b();
                viewInflate = this.f13246a.inflate(R.layout.list_item_circle_select_tag, (ViewGroup) null);
                bVar.f13248a = (TextView) viewInflate.findViewById(R.id.list_circle_select_tag_content);
                bVar.b = (ImageView) viewInflate.findViewById(R.id.list_circle_select_tag_img);
                viewInflate.setTag(bVar);
            } else {
                viewInflate = view;
                bVar = (b) view.getTag();
            }
            CircleTagItem circleTagItem = (CircleTagItem) CircleSelectTagActivity.this.v.get(i);
            bVar.f13248a.setText(circleTagItem.getTagName());
            bVar.b.setOnClickListener(new a(circleTagItem));
            return viewInflate;
        }
    }

    public final void I1(String str) {
        if (str == null || str.length() == 0) {
            L1(getString(R.string.circlie_tag_empty));
            return;
        }
        if (str.length() > 8) {
            L1(getString(R.string.circle_tag_max_length));
            return;
        }
        if (this.u.getCount() >= 5) {
            L1(getString(R.string.circle_tag_max_count));
            return;
        }
        if (!CollectionUtils.isEmpty(this.v)) {
            for (int i = 0; i < this.v.size(); i++) {
                if (str.equals(this.v.get(i).getTagName())) {
                    L1(getString(R.string.circle_tag_already_exist));
                    return;
                }
            }
        }
        showBaseProgressBar();
        c70.R().h(this.q, str, new d(str));
    }

    public final void J1(String str) {
        showBaseProgressBar();
        c70.R().w(this.q, str, new e(str));
    }

    public final void K1() {
        Toolbar toolbarInitToolbar = initToolbar("");
        this.w = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) this.w.findViewById(R.id.title)).setText(R.string.circle_tag_set);
        TextView textView = (TextView) this.w.findViewById(R.id.action_button);
        textView.setText(R.string.circle_finish);
        textView.setOnClickListener(new b());
        this.q = getIntent().getStringExtra(j70.f18338a);
        this.t = (ListView) findViewById(R.id.circle_select_tag_list);
        this.r = (EditText) findViewById(R.id.circle_select_tag_edit);
        this.x = (TextView) findViewById(R.id.circle_tv_label_tag_count);
        f fVar = new f(this);
        this.u = fVar;
        this.t.setAdapter((ListAdapter) fVar);
        TextView textView2 = (TextView) findViewById(R.id.circle_select_tag_add);
        this.s = textView2;
        textView2.setOnClickListener(new c());
    }

    public final void L1(String str) {
        Toast.makeText(this, str, 0).show();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_select_tag);
        K1();
        c70.R().z(this.q, new a());
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
