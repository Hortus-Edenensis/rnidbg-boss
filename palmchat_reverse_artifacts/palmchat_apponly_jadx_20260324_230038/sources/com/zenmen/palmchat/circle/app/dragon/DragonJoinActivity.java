package com.zenmen.palmchat.circle.app.dragon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.c5;
import defpackage.c70;
import defpackage.dv0;
import defpackage.gr2;
import defpackage.j70;
import defpackage.lg1;
import defpackage.mg1;
import defpackage.pc0;
import defpackage.ry5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DragonJoinActivity extends BaseActionBarActivity {
    public String B;
    public String C;
    public mg1 E;
    public DragonConfirmItem F;
    public TextView G;
    public int H;
    public Toolbar q;
    public TextView r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public DragonItem x;
    public LinearLayout z;
    public ArrayList<DragonConfirmItem> y = new ArrayList<>();
    public HashMap<Long, EditText> A = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DragonJoinActivity.this.F == null || !"删除".equals(DragonJoinActivity.this.r.getText())) {
                DragonJoinActivity.this.T1();
            } else {
                DragonJoinActivity.this.S1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse == null) {
                ry5.a(DragonJoinActivity.this.getString(R.string.send_failed));
                return;
            }
            if (baseResponse.getResultCode() != 0) {
                ry5.a(baseResponse.getErrorMsg());
                return;
            }
            int i = 0;
            while (true) {
                if (i >= DragonJoinActivity.this.z.getChildCount()) {
                    i = -1;
                    break;
                }
                Object tag = DragonJoinActivity.this.z.getChildAt(i).getTag(R.id.tag_data);
                if ((tag instanceof DragonConfirmItem) && DragonJoinActivity.this.F.getDragonItemId() == ((DragonConfirmItem) tag).getDragonItemId()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i > -1) {
                DragonJoinActivity.this.z.removeViewAt(i);
            }
            if (!DragonJoinActivity.this.y.isEmpty()) {
                Iterator it = DragonJoinActivity.this.y.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((DragonConfirmItem) it.next()).getDragonItemId() == DragonJoinActivity.this.F.getDragonItemId()) {
                        it.remove();
                        break;
                    }
                }
            }
            DragonJoinActivity.this.E.d(DragonJoinActivity.this.z);
            ry5.a(DragonJoinActivity.this.getString(R.string.send_success));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse<Long>> {
        public c() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<Long> baseResponse) {
            DragonJoinActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                ry5.a(baseResponse.getErrorMsg());
            } else {
                ry5.a(DragonJoinActivity.this.getString(R.string.send_success));
                DragonJoinActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<DragonItem>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements c5<DragonConfirmItem> {
            public a() {
            }

            @Override // defpackage.c5
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(DragonConfirmItem dragonConfirmItem) {
                if (DragonJoinActivity.this.B.equals(dragonConfirmItem.uid)) {
                    DragonJoinActivity.this.r.setText("删除");
                }
                DragonJoinActivity.this.V1();
                DragonJoinActivity.this.F = dragonConfirmItem;
            }
        }

        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(EditText editText, View view, boolean z) {
            if (view == editText && z) {
                DragonJoinActivity.this.r.setText("发布");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            DragonJoinActivity.this.F = null;
            DragonJoinActivity.this.r.setText("发布");
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DragonItem> baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                DragonJoinActivity.this.A.clear();
                DragonItem data = baseResponse.getData();
                DragonJoinActivity.this.y = data.getItems();
                DragonJoinActivity.this.x = data;
                TextView textView = DragonJoinActivity.this.G;
                DragonJoinActivity dragonJoinActivity = DragonJoinActivity.this;
                int i = 0;
                textView.setText(dragonJoinActivity.getString(R.string.dragon_join_desc, Integer.valueOf(dragonJoinActivity.y.size()), Integer.valueOf(DragonJoinActivity.this.H)));
                DragonJoinActivity.this.U1();
                boolean z = DragonJoinActivity.this.x.isOverTime && System.currentTimeMillis() - DragonJoinActivity.this.x.timeDeadLine > 0;
                while (i < DragonJoinActivity.this.y.size()) {
                    DragonConfirmItem dragonConfirmItem = (DragonConfirmItem) DragonJoinActivity.this.y.get(i);
                    mg1 mg1Var = DragonJoinActivity.this.E;
                    DragonJoinActivity dragonJoinActivity2 = DragonJoinActivity.this;
                    i++;
                    EditText editTextC = mg1Var.c(dragonJoinActivity2, dragonJoinActivity2.x.type, DragonJoinActivity.this.z, dragonConfirmItem, i, false, new a());
                    if (editTextC != null) {
                        DragonJoinActivity.this.A.put(Long.valueOf(dragonConfirmItem.sid), editTextC);
                    }
                }
                if (z) {
                    return;
                }
                if (2 == DragonJoinActivity.this.x.type || 1 == DragonJoinActivity.this.x.type) {
                    DragonConfirmItem dragonConfirmItem2 = new DragonConfirmItem();
                    dragonConfirmItem2.uid = DragonJoinActivity.this.B;
                    dragonConfirmItem2.sid = DragonConfirmItem.UNDEFINED_ID;
                    dragonConfirmItem2.uname = bo0.r().l(dragonConfirmItem2.uid).getNameForShow();
                    dragonConfirmItem2.content = "";
                    mg1 mg1Var2 = DragonJoinActivity.this.E;
                    DragonJoinActivity dragonJoinActivity3 = DragonJoinActivity.this;
                    final EditText editTextB = mg1Var2.b(dragonJoinActivity3, dragonJoinActivity3.x.type, DragonJoinActivity.this.z, dragonConfirmItem2, DragonJoinActivity.this.y.size() + 1, true);
                    editTextB.requestFocus();
                    editTextB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: og1
                        @Override // android.view.View.OnFocusChangeListener
                        public final void onFocusChange(View view, boolean z2) {
                            this.f19754a.d(editTextB, view, z2);
                        }
                    });
                    editTextB.setOnClickListener(new View.OnClickListener() { // from class: pg1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f20009a.e(view);
                        }
                    });
                    DragonJoinActivity.this.A.put(Long.valueOf(dragonConfirmItem2.sid), editTextB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(List list) {
        this.H = list.size();
    }

    public final void S1() {
        lg1 lg1VarC = lg1.c();
        DragonItem dragonItem = this.x;
        lg1VarC.b(dragonItem.groupId, dragonItem.dragonId, this.F.getDragonItemId(), new b());
    }

    public final void T1() {
        if (this.A.isEmpty()) {
            ry5.a("已过期");
            return;
        }
        Iterator<Map.Entry<Long, EditText>> it = this.A.entrySet().iterator();
        String string = "";
        while (it.hasNext()) {
            string = it.next().getValue().getText().toString();
        }
        if (TextUtils.isEmpty(string.trim())) {
            ry5.a("请输入接龙内容");
            return;
        }
        showBaseProgressBar("正在处理", false);
        lg1 lg1VarC = lg1.c();
        DragonItem dragonItem = this.x;
        lg1VarC.f(dragonItem.groupId, dragonItem.dragonId, string, new c());
    }

    public final void U1() {
        String str;
        this.t.setText(this.x.publisherName);
        DragonItem dragonItem = this.x;
        if (dragonItem.publishTime > 0) {
            long jCurrentTimeMillis = dragonItem.timeDeadLine - System.currentTimeMillis();
            long j = jCurrentTimeMillis / 86400000;
            long j2 = (jCurrentTimeMillis % 86400000) / 3600000;
            long j3 = (jCurrentTimeMillis % 3600000) / 60000;
            if (jCurrentTimeMillis > 0) {
                str = "还剩";
                if (j > 0) {
                    str = "还剩" + j + "天";
                }
                if (j2 > 0) {
                    str = str + j2 + "小时";
                }
                if (j3 > 0) {
                    str = str + j3 + "分";
                }
            } else {
                str = "已过期";
            }
            this.u.setText(str);
        }
        this.v.setText(pc0.b(this.x.timeDeadLine));
        this.w.setText(this.x.content);
    }

    public final void V1() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    public final void X1() {
        lg1 lg1VarC = lg1.c();
        DragonItem dragonItem = this.x;
        lg1VarC.i(dragonItem.groupId, dragonItem.dragonId, new d());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_dragon_join);
        this.B = getIntent().getStringExtra(j70.b);
        this.C = bo0.r().l(this.B).getNameForShow();
        this.x = (DragonItem) getIntent().getSerializableExtra(j70.e);
        c70.R().M(this.x.groupId, new dv0() { // from class: ng1
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f19507a.W1((List) obj);
            }
        });
        Toolbar toolbarInitToolbar = initToolbar("");
        this.q = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("参与群接龙");
        setSupportActionBar(this.q);
        TextView textView = (TextView) this.q.findViewById(R.id.action_button);
        this.r = textView;
        textView.setText("发布");
        this.r.setOnClickListener(new a());
        this.s = (ImageView) findViewById(R.id.circle_dragon_join_head);
        gr2.j().h(this.x.publisherHeadUrl, this.s, bq6.s());
        this.t = (TextView) findViewById(R.id.circle_dragon_join_name);
        this.u = (TextView) findViewById(R.id.circle_dragon_join_time);
        this.v = (TextView) findViewById(R.id.circle_dragon_join_deadline);
        this.w = (TextView) findViewById(R.id.circle_dragon_join_content);
        this.z = (LinearLayout) findViewById(R.id.layout_circle_dragon_join_fellow);
        this.G = (TextView) findViewById(R.id.dragon_join_count_desc);
        this.E = new mg1();
        U1();
        X1();
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
