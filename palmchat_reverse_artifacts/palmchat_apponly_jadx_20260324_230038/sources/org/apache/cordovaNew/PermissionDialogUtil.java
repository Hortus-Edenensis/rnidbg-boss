package org.apache.cordovaNew;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class PermissionDialogUtil {
    private static final SimpleArrayMap<String, Integer> MIN_SDK_PERMISSIONS;
    public static final String SP_NAME = "wifi_social";

    /* JADX INFO: compiled from: SearchBox */
    public enum PermissionInfoNew {
        ACCESS_FINE_LOCATION(g.g, R.drawable.ic_per_loc, R.string.per_type_des_location);

        public int icon;
        public int nameRes;
        public String permission;

        PermissionInfoNew(String str, int i, int i2) {
            this.permission = str;
            this.icon = i;
            this.nameRes = i2;
        }
    }

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(8);
        MIN_SDK_PERMISSIONS = simpleArrayMap;
        simpleArrayMap.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        simpleArrayMap.put("android.permission.BODY_SENSORS", 20);
        simpleArrayMap.put("android.permission.READ_CALL_LOG", 16);
        simpleArrayMap.put(g.i, 16);
        simpleArrayMap.put("android.permission.USE_SIP", 9);
        simpleArrayMap.put("android.permission.WRITE_CALL_LOG", 16);
        simpleArrayMap.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        simpleArrayMap.put("android.permission.WRITE_SETTINGS", 23);
    }

    public static boolean getBooleanValue(Context context, String str, boolean z) {
        SharedPreferences uISharedPreferences = getUISharedPreferences(context);
        return uISharedPreferences != null ? uISharedPreferences.getBoolean(str, z) : z;
    }

    private static View getDynamicRequestItemNew(Context context, String str) {
        PermissionInfoNew permissionInfoNew = null;
        for (PermissionInfoNew permissionInfoNew2 : PermissionInfoNew.values()) {
            if (permissionInfoNew2.permission.equals(str)) {
                permissionInfoNew = permissionInfoNew2;
            }
        }
        if (permissionInfoNew == null) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_list_item_permission, (ViewGroup) null, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
        TextView textView = (TextView) viewInflate.findViewById(R.id.name);
        imageView.setImageResource(permissionInfoNew.icon);
        textView.setText(permissionInfoNew.nameRes);
        return viewInflate;
    }

    public static SharedPreferences getUISharedPreferences(Context context) {
        try {
            return context.getSharedPreferences(SP_NAME, 4);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean hasSelfPermission(Context context, String str) {
        try {
            return PermissionChecker.checkSelfPermission(context, str) == 0;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static boolean hasSelfPermissions(Context context, String... strArr) {
        for (String str : strArr) {
            if (permissionExists(str) && !hasSelfPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean permissionExists(String str) {
        Integer num = MIN_SDK_PERMISSIONS.get(str);
        return num == null || Build.VERSION.SDK_INT >= num.intValue();
    }

    public static void putBooleanValue(Context context, String str, boolean z) {
        SharedPreferences uISharedPreferences = getUISharedPreferences(context);
        if (uISharedPreferences != null) {
            SharedPreferences.Editor editorEdit = uISharedPreferences.edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        }
    }

    public static boolean shouldShowSysPermissionDialog(Activity activity, String... strArr) {
        boolean z = false;
        for (String str : strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("firstCheckRationale");
            sb.append(str);
            z = z || (ActivityCompat.shouldShowRequestPermissionRationale(activity, str) || getBooleanValue(activity, sb.toString(), true));
        }
        return z;
    }

    public static Dialog showPermissionDesDialogOnSysProcessing2(Context context, int i, String[] strArr) {
        if (strArr.length <= 0) {
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_dialog_permission_float_des, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        if (i != 0) {
            textView.setText(i);
        }
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.permission_list);
        for (String str : strArr) {
            View dynamicRequestItemNew = getDynamicRequestItemNew(context, str);
            if (dynamicRequestItemNew != null) {
                linearLayout.addView(dynamicRequestItemNew, new LinearLayout.LayoutParams(-1, sp2px(context, 36)));
            }
        }
        try {
            final Dialog dialog = new Dialog(context, R.style.Plane_Dialog);
            dialog.setContentView(viewInflate);
            dialog.getWindow().setLayout(-1, -1);
            dialog.setCanceledOnTouchOutside(true);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: org.apache.cordovaNew.PermissionDialogUtil.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
            return dialog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int sp2px(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
