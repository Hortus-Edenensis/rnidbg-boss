package com.zenmen.palmchat.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.palmchat.framework.R$style;
import defpackage.ap3;
import defpackage.me1;
import defpackage.sd3;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PermissionDialogUtil {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'WRITE_EXTERNAL_STORAGE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: SearchBox */
    public static final class PermissionInfo {
        private static final /* synthetic */ PermissionInfo[] $VALUES;
        public static final PermissionInfo ACCESS_FINE_LOCATION;
        public static final PermissionInfo CAMERA;
        public static final PermissionInfo READ_CONTACTS;
        public static final PermissionInfo READ_PHONE_STATE = new PermissionInfo("READ_PHONE_STATE", 0, g.c, R$drawable.ic_permission_phone, R$string.permission_phone_state_name, R$string.permission_phone_state_des);
        public static final PermissionInfo RECORD_AUDIO;
        public static final PermissionInfo WRITE_EXTERNAL_STORAGE;
        public int desRes;
        public int icon;
        public int nameRes;
        public String permission;

        private static /* synthetic */ PermissionInfo[] $values() {
            return new PermissionInfo[]{READ_PHONE_STATE, WRITE_EXTERNAL_STORAGE, CAMERA, ACCESS_FINE_LOCATION, READ_CONTACTS, RECORD_AUDIO};
        }

        static {
            int i = R$drawable.ic_permission_storage;
            int i2 = R$string.permission_storage_name;
            int i3 = R$string.permission_storage_des;
            WRITE_EXTERNAL_STORAGE = new PermissionInfo("WRITE_EXTERNAL_STORAGE", 1, g.j, i, i2, i3);
            CAMERA = new PermissionInfo("CAMERA", 2, "android.permission.CAMERA", i, i2, i3);
            ACCESS_FINE_LOCATION = new PermissionInfo("ACCESS_FINE_LOCATION", 3, g.g, i, i2, i3);
            READ_CONTACTS = new PermissionInfo("READ_CONTACTS", 4, "android.permission.READ_CONTACTS", i, i2, i3);
            RECORD_AUDIO = new PermissionInfo("RECORD_AUDIO", 5, "android.permission.RECORD_AUDIO", i, i2, i3);
            $VALUES = $values();
        }

        private PermissionInfo(String str, int i, String str2, int i2, int i3, int i4) {
            this.permission = str2;
            this.icon = i2;
            this.nameRes = i3;
            this.desRes = i4;
        }

        public static PermissionInfo valueOf(String str) {
            return (PermissionInfo) Enum.valueOf(PermissionInfo.class, str);
        }

        public static PermissionInfo[] values() {
            return (PermissionInfo[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum PermissionInfoNew {
        READ_PHONE_STATE(g.c, R$drawable.ic_permission_phone, R$string.per_type_des_phone),
        WRITE_EXTERNAL_STORAGE(g.j, R$drawable.ic_per_store, R$string.per_type_des_store),
        CAMERA("android.permission.CAMERA", R$drawable.ic_per_camera, R$string.per_type_des_camera),
        ACCESS_FINE_LOCATION(g.g, R$drawable.ic_per_loc, R$string.per_type_des_location),
        READ_CONTACTS("android.permission.READ_CONTACTS", R$drawable.ic_permission_contact, R$string.per_type_des_contact),
        RECORD_AUDIO("android.permission.RECORD_AUDIO", R$drawable.ic_per_audio, R$string.per_type_des_audio);

        public int icon;
        public int nameRes;
        public String permission;

        PermissionInfoNew(String str, int i, int i2) {
            this.permission = str;
            this.icon = i;
            this.nameRes = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog.e f15713a;
        public final /* synthetic */ MaterialDialog b;

        public a(MaterialDialog.e eVar, MaterialDialog materialDialog) {
            this.f15713a = eVar;
            this.b = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15713a.onNegative(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f15714a;

        public b(Dialog dialog) {
            this.f15714a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15714a.dismiss();
        }
    }

    public static View a(Context context, String str, boolean z) {
        PermissionInfo permissionInfo = null;
        for (PermissionInfo permissionInfo2 : PermissionInfo.values()) {
            if (permissionInfo2.permission.equals(str)) {
                permissionInfo = permissionInfo2;
            }
        }
        if (permissionInfo == null) {
            return null;
        }
        if (!z) {
            View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_list_item_permission_jump_guide, (ViewGroup) null, false);
            ((TextView) viewInflate.findViewById(R$id.name)).setText(permissionInfo.nameRes);
            return viewInflate;
        }
        View viewInflate2 = LayoutInflater.from(context).inflate(R$layout.layout_list_item_permission_dynamic_request, (ViewGroup) null, false);
        ImageView imageView = (ImageView) viewInflate2.findViewById(R$id.icon);
        TextView textView = (TextView) viewInflate2.findViewById(R$id.name);
        TextView textView2 = (TextView) viewInflate2.findViewById(R$id.des);
        imageView.setImageResource(permissionInfo.icon);
        textView.setText(permissionInfo.nameRes);
        textView2.setText(permissionInfo.desRes);
        return viewInflate2;
    }

    public static View b(Context context, String str) {
        PermissionInfoNew permissionInfoNew = null;
        for (PermissionInfoNew permissionInfoNew2 : PermissionInfoNew.values()) {
            if (permissionInfoNew2.permission.equals(str)) {
                permissionInfoNew = permissionInfoNew2;
            }
        }
        if (permissionInfoNew == null) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_list_item_permission, (ViewGroup) null, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.icon);
        TextView textView = (TextView) viewInflate.findViewById(R$id.name);
        imageView.setImageResource(permissionInfoNew.icon);
        textView.setText(permissionInfoNew.nameRes);
        return viewInflate;
    }

    public static View c(Context context, int i) {
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        if (i == R$layout.layout_contact_calllog_sms_permission_description) {
            ((TextView) viewInflate.findViewById(R$id.title)).setText(R$string.per_usage_calllog_and_sms);
        }
        return viewInflate;
    }

    public static void d(Context context, CharSequence charSequence, MaterialDialog.e eVar) {
        new sd3(context).T(R$string.permission_cancel_dialog_title).k(charSequence).h(false).O(R$string.alert_dialog_open).f(eVar).e().show();
    }

    public static Dialog e(FrameworkBaseActivity frameworkBaseActivity, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, String[] strArr) {
        View viewC;
        if (strArr.length <= 0) {
            return null;
        }
        int i = permissionUsage.usageDesLayoutRes;
        boolean z = i == R$layout.layout_permission_description_init || i == R$layout.layout_permission_description_init1 || i == R$layout.layout_permission_description_init2;
        if (i != 0) {
            viewC = c(frameworkBaseActivity, i);
            if (z) {
                TextView textView = (TextView) viewC.findViewById(R$id.title);
                TextView textView2 = (TextView) viewC.findViewById(R$id.des);
                JSONObject jSONObjectJ = ap3.a().j();
                if (jSONObjectJ != null) {
                    String strOptString = jSONObjectJ.optString("permissionget_title");
                    if (!TextUtils.isEmpty(strOptString)) {
                        textView.setText(strOptString);
                    }
                    String strOptString2 = jSONObjectJ.optString((permissionUsage.usageDesLayoutRes == R$layout.layout_permission_description_init1 ? 1 : 0) != 0 ? "permissionget_use_01" : "permissionget_use_02");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        textView2.setText(strOptString2);
                    }
                }
            }
        } else {
            View viewInflate = LayoutInflater.from(frameworkBaseActivity).inflate(R$layout.layout_dialog_permission_float_des, (ViewGroup) null);
            TextView textView3 = (TextView) viewInflate.findViewById(R$id.title);
            int i2 = permissionUsage.usageDesRes;
            if (i2 != 0) {
                textView3.setText(i2);
            }
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.permission_list);
            int length = strArr.length;
            while (i < length) {
                View viewB = b(frameworkBaseActivity, strArr[i]);
                if (viewB != null) {
                    linearLayout.addView(viewB, new LinearLayout.LayoutParams(-1, me1.q(frameworkBaseActivity, 36)));
                }
                i++;
            }
            viewC = viewInflate;
        }
        try {
            Dialog dialog = new Dialog(frameworkBaseActivity, z ? R$style.Plane_Dialog_Trans : R$style.Plane_Dialog);
            dialog.setContentView(viewC);
            dialog.getWindow().setLayout(-1, -1);
            dialog.setCanceledOnTouchOutside(true);
            viewC.setOnClickListener(new b(dialog));
            dialog.show();
            return dialog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void f(Context context, List<String> list, MaterialDialog.e eVar) {
        if (list.size() > 0) {
            View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_dialog_permission_dynamic_request, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.permission_list);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                View viewA = a(context, it.next(), true);
                if (viewA != null) {
                    linearLayout.addView(viewA);
                }
            }
            MaterialDialog materialDialogE = new sd3(context).p(viewInflate, false).h(false).O(R$string.alert_dialog_open).f(eVar).e();
            View viewFindViewById = materialDialogE.findViewById(R$id.customViewFrame);
            if (viewFindViewById != null) {
                viewFindViewById.setPadding(0, 0, 0, 0);
            }
            materialDialogE.findViewById(R$id.img_close).setOnClickListener(new a(eVar, materialDialogE));
            materialDialogE.show();
        }
    }

    public static void g(Context context, List<String> list, boolean z, MaterialDialog.e eVar) {
        if (list.size() > 0) {
            View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_dialog_permission_jump_guide, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.permission_list);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                View viewA = a(context, it.next(), false);
                if (viewA != null) {
                    linearLayout.addView(viewA);
                }
            }
            MaterialDialog materialDialogE = new sd3(context).p(viewInflate, false).h(false).O(R$string.alert_dialog_open).L(z ? context.getString(R$string.alert_dialog_cancel) : null).f(eVar).e();
            View viewFindViewById = materialDialogE.findViewById(R$id.customViewFrame);
            if (viewFindViewById != null) {
                viewFindViewById.setPadding(0, 0, 0, 0);
            }
            materialDialogE.show();
        }
    }
}
