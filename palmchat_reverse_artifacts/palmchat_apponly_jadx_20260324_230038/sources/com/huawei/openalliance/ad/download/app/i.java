package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import com.huawei.openalliance.ad.utils.ag;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
class i extends BaseAdapter {
    private static final int Code = 2;
    private List<PermissionEntity> I;
    private Context V;
    private LayoutInflater Z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        TextView Code;

        public a(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_child_tv);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        TextView Code;

        public b(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_parent_tv);
        }
    }

    public i(Context context, List<PermissionEntity> list) {
        this.V = context;
        this.I = list;
        this.Z = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ag.Code(this.I)) {
            return 0;
        }
        return this.I.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ag.Code(this.I)) {
            return null;
        }
        return this.I.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (ag.Code(this.I)) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (ag.Code(this.I) || this.I.get(i) == null) {
            return 0;
        }
        return this.I.get(i).V();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[PHI: r0 r7 r8
      0x0069: PHI (r0v9 java.lang.String) = (r0v4 java.lang.String), (r0v11 java.lang.String) binds: [B:22:0x0066, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x0069: PHI (r7v6 android.view.View) = (r7v1 android.view.View), (r7v7 android.view.View) binds: [B:22:0x0066, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x0069: PHI (r8v9 android.widget.TextView) = (r8v4 android.widget.TextView), (r8v13 android.widget.TextView) binds: [B:22:0x0066, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        String strCode;
        TextView textView;
        a aVar;
        PermissionEntity permissionEntity = this.I.get(i);
        int itemViewType = getItemViewType(i);
        String str = "";
        if (itemViewType == 0) {
            if (view == null) {
                view = this.Z.inflate(R.layout.hiad_permission_dialog_parent_item, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            strCode = permissionEntity != null ? permissionEntity.Code() : "";
            textView = bVar.Code;
            if (!TextUtils.isEmpty(strCode)) {
            }
            textView.setText(str);
        } else if (itemViewType == 1) {
            if (view == null) {
                view = this.Z.inflate(R.layout.hiad_permission_dialog_child_item, viewGroup, false);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            strCode = permissionEntity != null ? permissionEntity.Code() : "";
            textView = aVar.Code;
            if (!TextUtils.isEmpty(strCode)) {
                str = strCode;
            }
            textView.setText(str);
        }
        fh.Code("AppPermissionsDialog", "getView, time:%s, position:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
