package com.zenmen.palmchat.circle.ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.baidu.location.LocationConst;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.dialog.a;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.a46;
import defpackage.bq6;
import defpackage.c70;
import defpackage.dv0;
import defpackage.gr2;
import defpackage.iq5;
import defpackage.k80;
import defpackage.l03;
import defpackage.oc0;
import defpackage.qa0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.vs0;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DialogCircleQuickRemoveOrShutUp extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GroupInfoItem f13261a;
    public FrameworkBaseActivity b;
    public k80 c;
    public String d;
    public ViewGroup e;
    public boolean f;
    public TextView g;
    public ContactInfoItem h;
    public f i;
    public Response.Listener<JSONObject> j;
    public Response.ErrorListener k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (DialogCircleQuickRemoveOrShutUp.this.b != null) {
                DialogCircleQuickRemoveOrShutUp.this.b.hideBaseProgressBar();
            }
            if (iOptInt != 0) {
                if (DialogCircleQuickRemoveOrShutUp.this.c.d(DialogCircleQuickRemoveOrShutUp.this.b, iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG))) {
                    return;
                }
                DialogCircleQuickRemoveOrShutUp.this.P();
            } else {
                iq5.j(false, new String[0]);
                DialogCircleQuickRemoveOrShutUp.this.R();
                if (DialogCircleQuickRemoveOrShutUp.this.i != null) {
                    DialogCircleQuickRemoveOrShutUp.this.i.b();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (DialogCircleQuickRemoveOrShutUp.this.b != null) {
                DialogCircleQuickRemoveOrShutUp.this.b.hideBaseProgressBar();
            }
            DialogCircleQuickRemoveOrShutUp.this.P();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13264a;

        public c(int i) {
            this.f13264a = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (TextUtils.isEmpty(DialogCircleQuickRemoveOrShutUp.this.d)) {
                DialogCircleQuickRemoveOrShutUp.this.dismiss();
                return;
            }
            l03 l03Var = new l03(DialogCircleQuickRemoveOrShutUp.this.j, DialogCircleQuickRemoveOrShutUp.this.k);
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(DialogCircleQuickRemoveOrShutUp.this.d);
                l03Var.n(arrayList, DialogCircleQuickRemoveOrShutUp.this.f13261a.getGroupId(), this.f13264a);
                if (DialogCircleQuickRemoveOrShutUp.this.b != null) {
                    DialogCircleQuickRemoveOrShutUp.this.b.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                }
            } catch (DaoException unused) {
                if (DialogCircleQuickRemoveOrShutUp.this.b != null) {
                    DialogCircleQuickRemoveOrShutUp.this.b.hideBaseProgressBar();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse> {
        public d() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                sy5.f(AppContext.getContext(), "已禁言", 0).g();
                c70.R().C0(false, new String[0]);
                DialogCircleQuickRemoveOrShutUp.this.f = true;
                DialogCircleQuickRemoveOrShutUp.this.S();
                return;
            }
            if (DialogCircleQuickRemoveOrShutUp.this.c.d(DialogCircleQuickRemoveOrShutUp.this.b, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                return;
            }
            if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
            } else {
                sy5.f(AppContext.getContext(), baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends wi0<BaseResponse> {
        public e() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                sy5.f(AppContext.getContext(), "已解除", 0).g();
                c70.R().C0(false, new String[0]);
                DialogCircleQuickRemoveOrShutUp.this.f = false;
                DialogCircleQuickRemoveOrShutUp.this.S();
                return;
            }
            if (DialogCircleQuickRemoveOrShutUp.this.c.d(DialogCircleQuickRemoveOrShutUp.this.b, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                return;
            }
            if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
            } else {
                sy5.f(AppContext.getContext(), baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a();

        void b();
    }

    public DialogCircleQuickRemoveOrShutUp(@NonNull Context context, f fVar) {
        super(context, R.style.CircleRoundDialog);
        this.j = new a();
        this.k = new b();
        this.i = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(int i) {
        new sd3(getContext()).k(i == 0 ? "删除成员" : "删除成员并禁止加群").K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new c(i)).e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        oc0.g("lx_operate_profile_click");
        this.i.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        oc0.g("lx_operate_cancel_click");
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        oc0.g("lx_operate_delete_click");
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        HashMap map = new HashMap();
        map.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, Integer.valueOf(this.f ? 1 : 0));
        oc0.h("lx_operate_ban_click", map);
        if (this.f) {
            F();
        } else {
            E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(List list) {
        if (list == null || list.size() <= 0) {
            this.f = false;
            this.g.setText("禁言");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ContactInfoItem) it.next()).getUid().equals(this.d)) {
                this.f = true;
                this.g.setText("解除禁言");
                return;
            } else {
                this.f = false;
                this.g.setText("禁言");
            }
        }
    }

    public final void D() {
        if (this.f13261a.getRoomType() == 1 || this.f13261a.getRoomType() == 2) {
            dismiss();
            new com.zenmen.palmchat.circle.ui.dialog.a(this.b, new a.InterfaceC1015a() { // from class: rc1
                @Override // com.zenmen.palmchat.circle.ui.dialog.a.InterfaceC1015a
                public final void a(int i) {
                    this.f20437a.H(i);
                }
            }).show();
        }
    }

    public final void E() {
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.f13261a.getGroupId())) {
            dismiss();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.d);
        qa0.i().k(this.f13261a.getGroupId(), arrayList, new d());
    }

    public final void F() {
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.f13261a.getGroupId())) {
            dismiss();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.d);
        qa0.i().m(this.f13261a.getGroupId(), arrayList, new e());
    }

    public final void G() {
        this.e = (ViewGroup) findViewById(R.id.root);
        this.g = (TextView) findViewById(R.id.silence);
        View viewFindViewById = findViewById(R.id.detail);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: nc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19488a.I(view);
            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() { // from class: oc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19737a.J(view);
            }
        });
        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() { // from class: pc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19990a.K(view);
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: qc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20224a.L(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.name);
        textView.setText(this.h.getNameForShow());
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.head);
        if (!vs0.a().e("isGroupGiftEnable", false)) {
            effectiveShapeView.setVisibility(0);
            effectiveShapeView.changeShapeType(3);
            gr2.j().h(this.h.getIconURL(), (EffectiveShapeView) findViewById(R.id.head), bq6.s());
            viewFindViewById.setVisibility(0);
            textView.setVisibility(0);
            return;
        }
        effectiveShapeView.setVisibility(8);
        viewFindViewById.setVisibility(8);
        textView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.topMargin = a46.b(getContext(), 30.0f);
        this.g.setLayoutParams(layoutParams);
    }

    public final void N() {
        c70.R().O(this.f13261a.getGroupId(), new dv0() { // from class: sc1
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f20712a.M((List) obj);
            }
        });
    }

    public final void O() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
            attributes.flags &= 2;
            attributes.windowAnimations = R.style.DialogOutAndInStyle;
            window.setAttributes(attributes);
        }
    }

    public final void P() {
        sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
    }

    public void Q(FrameworkBaseActivity frameworkBaseActivity, GroupInfoItem groupInfoItem, ContactInfoItem contactInfoItem) {
        this.f13261a = groupInfoItem;
        this.b = frameworkBaseActivity;
        this.h = contactInfoItem;
        this.d = contactInfoItem.getUid();
        this.c = new k80(this.f13261a);
        N();
        oc0.g("lx_groupchat_operate_show");
        super.show();
    }

    public final void R() {
        sy5.f(AppContext.getContext(), "已删除", 0).g();
    }

    public final void S() {
        if (this.f) {
            this.g.setText("解除禁言");
        } else {
            this.g.setText("禁言");
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_circle_quick_remove_shutup_layout);
        G();
        O();
    }
}
