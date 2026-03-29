package com.zenmen.square.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.square.R$color;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.tag.adapter.SquareTagAdapter;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.widget.SquareTagSelectHelper;
import defpackage.ai5;
import defpackage.bj5;
import defpackage.l50;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareSettingTagActivity extends FrameworkBaseActivity {
    public SquareTagSelectHelper q;
    public TextView r;
    public TextView s;
    public int t = 6;
    public uo2 u;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ArrayList<SquareTagBean> selectedBeans = SquareSettingTagActivity.this.q.getSelectedBeans();
            if (selectedBeans.size() > SquareSettingTagActivity.this.t) {
                SquareSettingTagActivity squareSettingTagActivity = SquareSettingTagActivity.this;
                sy5.f(squareSettingTagActivity, squareSettingTagActivity.getResources().getString(R$string.square_tag_setting_limit, Integer.valueOf(SquareSettingTagActivity.this.t)), 0).g();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<SquareTagBean> it = selectedBeans.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().getId());
                }
                jSONObject.put("tagids", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.f("pagemy_tagchoosepage_complete", "click", jSONObject);
            SquareSettingTagActivity.this.I1(selectedBeans);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends tw4<CommonResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16135a;

        public c(ArrayList arrayList) {
            this.f16135a = arrayList;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse commonResponse) {
            SquareSettingTagActivity.this.hideBaseProgressBar();
            Intent intent = new Intent();
            intent.putExtra("selected_tags", this.f16135a);
            SquareSettingTagActivity.this.setResult(-1, intent);
            SquareSettingTagActivity.this.finish();
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            SquareSettingTagActivity.this.hideBaseProgressBar();
            SquareSettingTagActivity squareSettingTagActivity = SquareSettingTagActivity.this;
            squareSettingTagActivity.J1(squareSettingTagActivity, null, squareSettingTagActivity.getString(com.zenmen.square.R$string.square_operation_fail));
        }
    }

    public final void F1() {
        ArrayList<SquareTagBean> selectedBeans = this.q.getSelectedBeans();
        if (selectedBeans != null && !selectedBeans.isEmpty()) {
            selectedBeans.size();
        }
        this.s.setText("完成");
    }

    public final void G1() {
        this.r = (TextView) findViewById(R$id.sub_title);
        this.q = (SquareTagSelectHelper) findViewById(R$id.tag);
        this.s = (TextView) findViewById(R$id.confirm);
        this.q.bind(new a());
        this.q.setSelectMax(this.t);
        this.s.setOnClickListener(new b());
        F1();
    }

    public final void H1() {
        this.q.load();
    }

    public final void I1(ArrayList<SquareTagBean> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<SquareTagBean> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(it.next().getId()));
            }
        }
        showBaseProgressBar();
        this.u.b(arrayList2, new c(arrayList2));
    }

    public void J1(Activity activity, String str, String str2) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        new sd3(activity).k(str).O(R$string.alert_dialog_ok).f(null).e().show();
    }

    public final void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R$id.toolbar);
        ai5.k().j().getGuideInfo().getPagetagtitle();
        initToolbar(toolbar, "选择对外展示的生活方式", true);
        getToolbar().setBackgroundResource(R$color.white);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.square_layout_activity_setting_tag);
        this.u = bj5.b().c();
        initActionBar();
        G1();
        H1();
        zn6.c("pagemy_tagchoosepage", "view");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SquareTagSelectHelper.f {
        public a() {
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void a() {
            SquareSettingTagActivity squareSettingTagActivity = SquareSettingTagActivity.this;
            squareSettingTagActivity.t = squareSettingTagActivity.q.getSelectMax();
            SquareSettingTagActivity.this.F1();
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void b(SquareTagAdapter.a aVar) {
            SquareSettingTagActivity.this.F1();
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public SquareTagSelectHelper.Scene getScene() {
            return SquareTagSelectHelper.Scene.SETTING;
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void c() {
        }
    }
}
