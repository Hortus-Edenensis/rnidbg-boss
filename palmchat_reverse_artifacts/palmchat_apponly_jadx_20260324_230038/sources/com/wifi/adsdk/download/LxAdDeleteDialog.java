package com.wifi.adsdk.download;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.lxad.ad.R;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdDeleteDialog extends Dialog {
    private View cancelView;
    private String curPkgName;
    private String curPkgUrl;
    private TextView descView;
    private View doneView;
    private Activity mAct;
    private ViewGroup mContentView;
    private Context mContext;
    private String title;

    public LxAdDeleteDialog(@NonNull Context context, JSONObject jSONObject) {
        super(context, R.style.AdPopFullScreenDialog);
        setCanceledOnTouchOutside(false);
        this.mContentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_download_apk_delete, (ViewGroup) null);
        this.mContext = context;
        if (context instanceof Activity) {
            this.mAct = (Activity) context;
        }
        if (jSONObject != null) {
            this.curPkgName = jSONObject.optString("pkgName");
            this.curPkgUrl = jSONObject.optString(LxAdDLManager.ITEM_PKGURL);
            this.title = jSONObject.optString("title");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDownApp() {
        LxAdLog.d("LXadsplash LxAdDeleteDialog deleteDownApp curPkgName " + this.curPkgName);
        LxAdDLManager.getInstance(this.mContext).deleteDownApp(this.curPkgUrl, this.curPkgName);
        dismiss();
    }

    private void initView() {
        View viewFindViewById = this.mContentView.findViewById(R.id.down_delete_cancel);
        this.cancelView = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.download.LxAdDeleteDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdDeleteDialog.this.dismiss();
            }
        });
        this.descView = (TextView) this.mContentView.findViewById(R.id.download_desc);
        View viewFindViewById2 = this.mContentView.findViewById(R.id.down_delete_done);
        this.doneView = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.download.LxAdDeleteDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckDoubleClick.isFastDoubleClick()) {
                    return;
                }
                LxAdDeleteDialog.this.deleteDownApp();
            }
        });
    }

    private void setData() {
        if (TextUtils.isEmpty(this.title)) {
            return;
        }
        this.descView.setText("确认要删除" + this.title + "的下载任务吗？");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Activity activity = this.mAct;
        if (activity instanceof LxAdDownDeleteActivity) {
            activity.finish();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mContentView);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            initView();
            setData();
        } catch (Exception unused) {
        }
    }
}
