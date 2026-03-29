package com.huawei.openalliance.ad.views.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ld;
import com.huawei.hms.ads.le;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.lg;
import com.huawei.openalliance.ad.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private static final Map<String, String> B = new HashMap<String, String>() { // from class: com.huawei.openalliance.ad.views.dialog.b.1
        {
            put(ld.V, "com.tencent.mm");
            put(ld.Code, "com.tencent.mobileqq");
            put(ld.I, "com.sina.weibo");
            put(ld.Z, "com.huawei.works");
        }
    };
    private static final Map<String, Integer> C = new HashMap<String, Integer>() { // from class: com.huawei.openalliance.ad.views.dialog.b.2
        {
            put(ld.V, Integer.valueOf(R.string.hiad_share_wx));
            put(ld.Code, Integer.valueOf(R.string.hiad_share_qq));
        }
    };
    private static final String Code = "PPSShareDialog";
    private static final String I = "http";
    private static final float V = 0.0f;
    private static final String Z = "defImg";
    private final Activity D;
    private View F;
    private final le L;
    private Dialog S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f6985a = new ArrayList();
    private Map<String, String> b = new HashMap();

    public b(Activity activity, le leVar) {
        this.D = activity;
        this.L = leVar;
        Z();
    }

    private void B() {
        this.S = new Dialog(this.D, R.style.HIAD_share_dialog);
        View viewInflate = LayoutInflater.from(this.D).inflate(R.layout.bottom_share_layout, (ViewGroup) null);
        this.F = viewInflate;
        this.S.setContentView(viewInflate);
        this.S.setCanceledOnTouchOutside(true);
        this.S.setCancelable(true);
        Window window = this.S.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setDimAmount(0.0f);
            attributes.gravity = 80;
            attributes.width = this.D.getResources().getDisplayMetrics().widthPixels;
        }
    }

    private void C() {
        Code(R.id.share_wx, ld.V, 1);
        Code(R.id.share_wx_moments, ld.V, 2);
        Code(R.id.share_qq, ld.Code, 1);
        Code(R.id.share_qq_qzone, ld.Code, 2);
        Code(R.id.share_weibo, ld.I, -1);
        Code(R.id.share_weLink, ld.Z, -1);
        Code(R.id.share_more, ld.B, -1);
        if (fh.Code()) {
            fh.Code(Code, "initShareButton end");
        }
    }

    private void Z() {
        if (fh.Code()) {
            fh.Code(Code, "initDialog");
        }
        if (this.D == null) {
            if (fh.Code()) {
                fh.Code(Code, "initDialog filed : context is null");
            }
        } else {
            B();
            this.b = eh.Code(this.D.getApplicationContext()).ap();
            C();
        }
    }

    private boolean I(String str) {
        if (lf.Code(str)) {
            return true;
        }
        if (fh.Code()) {
            fh.Code(Code, "checkForDependencies : %s filed", str);
        }
        return false;
    }

    private boolean Z(String str) {
        if (h.Code(this.D, B.get(str))) {
            return true;
        }
        if (fh.Code()) {
            fh.Code(Code, "checkForInstall : %s filed", str);
        }
        return false;
    }

    public void Code() {
        Dialog dialog;
        if (this.D == null || this.L == null || (dialog = this.S) == null) {
            fh.Code(Code, "context,nativeAd or dialog is empty");
        } else {
            dialog.show();
        }
    }

    public void V() {
        Dialog dialog = this.S;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.S.dismiss();
    }

    private void Code(int i, final String str, final int i2) {
        View viewFindViewById = this.F.findViewById(i);
        if (ld.Code.equals(str) || ld.V.equals(str)) {
            if (Code(str, viewFindViewById)) {
                return;
            }
        } else if (ld.I.equals(str)) {
            if (!V(str) || !Z(str)) {
                viewFindViewById.setVisibility(8);
                return;
            }
        } else if (ld.Z.equals(str) && (!I(str) || !Z(str))) {
            viewFindViewById.setVisibility(8);
            return;
        }
        Code(str);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dialog.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.Code(str, i2);
                db.Code(b.this.D, str, b.this.L.L());
                fh.Code(b.Code, "click %s share", str);
            }
        });
    }

    private boolean V(String str) {
        if (this.b.get(str) != null) {
            return I(str);
        }
        if (fh.Code()) {
            fh.Code(Code, "checkForAppId : %s filed", str);
        }
        return false;
    }

    public void Code(DialogInterface.OnDismissListener onDismissListener) {
        Dialog dialog = this.S;
        if (dialog != null) {
            dialog.setOnDismissListener(onDismissListener);
        }
    }

    private void Code(String str) {
        String str2 = B.get(str);
        if (this.f6985a.contains(str2)) {
            return;
        }
        this.f6985a.add(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Code(String str, int i) {
        Boolean bool;
        String strCode;
        lg lgVar = new lg();
        lgVar.Code(this.b.get(str));
        if (1 != i) {
            if (2 == i) {
                bool = Boolean.FALSE;
            }
            if (ld.B.equals(str)) {
                lgVar.Code(this.f6985a);
            }
            V();
            strCode = this.L.Code();
            if (strCode != null || !strCode.startsWith("http")) {
                this.L.Code(this.b.get(Z));
            }
            lf.Code(str, this.D, this.L, lgVar);
        }
        bool = Boolean.TRUE;
        lgVar.Code(bool);
        if (ld.B.equals(str)) {
        }
        V();
        strCode = this.L.Code();
        if (strCode != null) {
            this.L.Code(this.b.get(Z));
        }
        lf.Code(str, this.D, this.L, lgVar);
    }

    private boolean Code(final String str, View view) {
        if (!V(str)) {
            view.setVisibility(8);
            return true;
        }
        if (Z(str)) {
            return false;
        }
        Code(str);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.dialog.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Toast.makeText(b.this.D, b.this.D.getResources().getString(R.string.hiad_share_app_not_install, b.this.D.getResources().getString(((Integer) b.C.get(str)).intValue())), 0).show();
                fh.Code(b.Code, "click %s share : app not support", str);
            }
        });
        return true;
    }
}
