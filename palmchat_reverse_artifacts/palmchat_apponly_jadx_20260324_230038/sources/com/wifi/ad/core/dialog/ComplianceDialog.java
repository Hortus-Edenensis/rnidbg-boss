package com.wifi.ad.core.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.wifi.ad.core.R;
import com.wifi.ad.core.custom.flow.GlideImageLoader;
import com.wifi.ad.core.imageloader.GlideRoundedTransformation;
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.ScreenUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ComplianceDialog extends Dialog implements View.OnClickListener {
    private String adDeveloperName;
    private TextView adDeveloperView;
    private String adIconUrl;
    private Bitmap adLogoBitmap;
    private ImageView adLogoView;
    private String adName;
    private TextView adNameView;
    private String adPermissionsUrl;
    private String adPrivacyUrl;
    private String adVersion;
    private TextView adVersionView;
    private DialogClickListener listener;

    /* JADX INFO: compiled from: SearchBox */
    public interface DialogClickListener {
        void onDownloadClick();
    }

    public ComplianceDialog(@NonNull Context context) {
        super(context, R.style.AdComplianceStyle);
        setCanceledOnTouchOutside(false);
    }

    public ComplianceDialog adDeveloperName(String str) {
        this.adDeveloperName = str;
        TextView textView = this.adDeveloperView;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public ComplianceDialog adLogoInfo(Bitmap bitmap, String str) {
        this.adLogoBitmap = bitmap;
        this.adIconUrl = str;
        if (this.adLogoView != null) {
            if (bitmap != null) {
                new GlideImageLoader().loadImage(getContext(), this.adLogoView, bitmap, new GlideRoundedTransformation(getContext(), ScreenUtil.INSTANCE.dp2px(getContext(), 16.0f)));
            } else {
                new GlideImageLoader().loadImage(getContext(), this.adLogoView, str, new GlideRoundedTransformation(getContext(), ScreenUtil.INSTANCE.dp2px(getContext(), 16.0f)));
            }
        }
        return this;
    }

    public ComplianceDialog adName(String str) {
        this.adName = str;
        TextView textView = this.adNameView;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public ComplianceDialog adPermissionsUrl(String str) {
        this.adPermissionsUrl = str;
        return this;
    }

    public ComplianceDialog adPrivacyUrl(String str) {
        this.adPrivacyUrl = str;
        return this;
    }

    public ComplianceDialog adVersion(String str) {
        this.adVersion = str;
        TextView textView = this.adVersionView;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ad_download) {
            dismiss();
            DialogClickListener dialogClickListener = this.listener;
            if (dialogClickListener != null) {
                dialogClickListener.onDownloadClick();
                return;
            }
            return;
        }
        if (view.getId() == R.id.ad_permissions) {
            if (TextUtils.isEmpty(this.adPermissionsUrl)) {
                return;
            }
            AdComplianceUtil.startCommonWebView(this.adPermissionsUrl, getContext().getString(R.string.ad_permission_list), getContext());
        } else if (view.getId() == R.id.ad_privacy) {
            if (TextUtils.isEmpty(this.adPrivacyUrl)) {
                return;
            }
            AdComplianceUtil.startCommonWebView(this.adPrivacyUrl, getContext().getString(R.string.ad_privacy), getContext());
        } else if (view.getId() == R.id.ad_refuse_download) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_ad_compliance);
        this.adLogoView = (ImageView) findViewById(R.id.ad_logo);
        this.adNameView = (TextView) findViewById(R.id.ad_name);
        this.adVersionView = (TextView) findViewById(R.id.ad_version);
        this.adDeveloperView = (TextView) findViewById(R.id.ad_developer_name);
        findViewById(R.id.ad_download).setOnClickListener(this);
        findViewById(R.id.ad_refuse_download).setOnClickListener(this);
        findViewById(R.id.ad_permissions).setOnClickListener(this);
        findViewById(R.id.ad_privacy).setOnClickListener(this);
        if (this.adLogoBitmap != null) {
            new GlideImageLoader().loadImage(getContext(), this.adLogoView, this.adLogoBitmap, new GlideRoundedTransformation(getContext(), ScreenUtil.INSTANCE.dp2px(getContext(), 16.0f)));
        } else if (!TextUtils.isEmpty(this.adIconUrl)) {
            new GlideImageLoader().loadImage(getContext(), this.adLogoView, this.adIconUrl, new GlideRoundedTransformation(getContext(), ScreenUtil.INSTANCE.dp2px(getContext(), 16.0f)));
        }
        if (TextUtils.isEmpty(this.adName)) {
            this.adNameView.setVisibility(8);
        } else {
            this.adNameView.setVisibility(0);
            this.adNameView.setText(this.adName);
        }
        if (TextUtils.isEmpty(this.adVersion)) {
            this.adVersionView.setVisibility(8);
        } else {
            this.adVersionView.setVisibility(0);
            this.adVersionView.setText(String.format(getContext().getString(R.string.ad_version), this.adVersion));
        }
        if (TextUtils.isEmpty(this.adDeveloperName)) {
            this.adDeveloperView.setVisibility(8);
        } else {
            this.adDeveloperView.setVisibility(0);
            this.adDeveloperView.setText(String.format(getContext().getString(R.string.ad_developer_info), this.adDeveloperName));
        }
    }

    public ComplianceDialog setDialogListener(DialogClickListener dialogClickListener) {
        this.listener = dialogClickListener;
        return this;
    }
}
