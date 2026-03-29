package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.CircleToolAdapter;
import com.zenmen.palmchat.circle.ui.adapter.CircleToolCallback;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import defpackage.c70;
import defpackage.sd3;
import defpackage.wi0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleToolActivity extends BaseActionBarActivity implements CircleToolAdapter.d {
    public String q;
    public CircleToolAdapter r;
    public DatingGroupToolBeans.DatingGroupToolBean s;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleToolActivity.this.hideBaseProgressBar();
            if (baseResponse == null || TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                return;
            }
            Toast.makeText(CircleToolActivity.this, baseResponse.getErrorMsg(), 0).show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<DatingGroupToolBeans>> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DatingGroupToolBeans> baseResponse) {
            CircleToolActivity.this.hideBaseProgressBar();
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                if (baseResponse != null) {
                    Toast.makeText(CircleToolActivity.this, baseResponse.getErrorMsg(), 0).show();
                    return;
                }
                return;
            }
            DatingGroupToolBeans data = baseResponse.getData();
            if (data == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (data.getNotAddedList() != null) {
                arrayList.addAll(data.getNotAddedList());
            }
            if (data.getCustomList() != null) {
                arrayList.addAll(data.getCustomList());
            }
            if (data.getAddedList() != null && !data.getAddedList().isEmpty()) {
                Iterator<DatingGroupToolBeans.DatingGroupToolBean> it = data.getAddedList().iterator();
                while (it.hasNext()) {
                    it.next().setIsUsed(1);
                }
            }
            CircleToolActivity.this.r.l(data.getAddedList(), arrayList);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse> {
        public c() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse == null || TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                return;
            }
            Toast.makeText(CircleToolActivity.this, baseResponse.getErrorMsg(), 0).show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<DatingGroupToolBeans>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13255a;
        public final /* synthetic */ DatingGroupToolBeans.DatingGroupToolBean b;

        public d(boolean z, DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
            this.f13255a = z;
            this.b = datingGroupToolBean;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<DatingGroupToolBeans> baseResponse) {
            CircleToolActivity.this.hideBaseProgressBar();
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                if (baseResponse != null) {
                    Toast.makeText(CircleToolActivity.this, baseResponse.getErrorMsg(), 0).show();
                }
            } else {
                if (this.f13255a) {
                    CircleToolActivity.this.r.d(this.b);
                } else {
                    CircleToolActivity.this.r.k(this.b);
                }
                CircleToolActivity.this.setResult(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G1(int i, int i2) {
        this.r.g(i, i2);
        H1(this.r.f());
    }

    public static void I1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) CircleToolActivity.class);
        intent.putExtra("key_room_id", str);
        context.startActivity(intent);
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleToolAdapter.d
    public void A0(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        if (this.r.f().size() >= 3) {
            new sd3(this).k("群工具最多可配置3个，你已经达到上限了。").N(R.color.color_00AC9A).P("我知道了").e().show();
        } else {
            C1(datingGroupToolBean, true);
        }
    }

    public final void C1(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean, boolean z) {
        if (datingGroupToolBean == null) {
            return;
        }
        if (datingGroupToolBean.getState() == 0) {
            Toast.makeText(this, "审核中，暂不支持添加!", 0).show();
        } else {
            showBaseProgressBar("正在加载", false);
            c70.R().n(this.q, datingGroupToolBean.getId(), z ? 1 : 2, new d(z, datingGroupToolBean));
        }
    }

    public final boolean D1() {
        String stringExtra = getIntent().getStringExtra("key_room_id");
        this.q = stringExtra;
        return TextUtils.isEmpty(stringExtra);
    }

    public final void E1() {
        showBaseProgressBar("正在加载", false);
        c70.R().J(this.q, new b());
    }

    public final void F1() {
        setSupportActionBar(initToolbar(getString(R.string.circle_group_tool)));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        CircleToolAdapter circleToolAdapter = new CircleToolAdapter(this);
        this.r = circleToolAdapter;
        recyclerView.setAdapter(circleToolAdapter);
        registerForContextMenu(recyclerView);
        new ItemTouchHelper(new CircleToolCallback(new CircleToolCallback.a() { // from class: ic0
            @Override // com.zenmen.palmchat.circle.ui.adapter.CircleToolCallback.a
            public final void a(int i, int i2) {
                this.f18145a.G1(i, i2);
            }
        })).attachToRecyclerView(recyclerView);
    }

    public final void H1(List<DatingGroupToolBeans.DatingGroupToolBean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        showBaseProgressBar("正在加载", false);
        ArrayList arrayList = new ArrayList();
        Iterator<DatingGroupToolBeans.DatingGroupToolBean> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        c70.R().o(this.q, arrayList, new a());
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleToolAdapter.d
    public void a1(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        C1(datingGroupToolBean, false);
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleToolAdapter.d
    public void c1() {
        CircleAddToolActivity.Z1(this, 80, this.q);
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleToolAdapter.d
    public void k1(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        this.s = datingGroupToolBean;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 80 && i2 == -1 && intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("key_result_dating_tools_info");
            if (serializableExtra instanceof DatingGroupToolBeans.DatingGroupToolBean) {
                this.r.c((DatingGroupToolBeans.DatingGroupToolBean) serializableExtra);
            }
            E1();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return super.onContextItemSelected(menuItem);
        }
        this.r.j(this.s);
        if (this.s == null) {
            return true;
        }
        c70.R().x(this.s.getId(), new c());
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_tool);
        if (D1()) {
            finish();
        } else {
            E1();
            F1();
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, "删除");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleToolAdapter.d
    public void s(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        CircleAddToolActivity.a2(this, 80, this.q, datingGroupToolBean);
    }
}
