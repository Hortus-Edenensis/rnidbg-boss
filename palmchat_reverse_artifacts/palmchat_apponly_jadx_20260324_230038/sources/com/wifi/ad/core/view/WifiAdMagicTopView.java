package com.wifi.ad.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifi.ad.core.R;
import com.wifi.ad.core.custom.flow.GlideImageLoader;
import com.wifi.ad.core.imageloader.GlideCircleTransform;
import com.wifi.ad.core.utils.UIUtils;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WifiAdMagicTopView extends RelativeLayout {
    private ImageView appIcon;
    private TextView appName;
    private TextView appTime;
    private Config config;
    private String[] timeArray;

    /* JADX INFO: compiled from: SearchBox */
    public static class Config {
        private String appName;
        private String cardIcon;

        /* JADX INFO: compiled from: SearchBox */
        public static class Builder {
            private final Config config = new Config();

            public Config build() {
                return this.config;
            }

            public Builder setAppName(String str) {
                this.config.appName = str;
                return this;
            }

            public Builder setCardIcon(String str) {
                this.config.cardIcon = str;
                return this;
            }
        }

        public String getAppName() {
            if (TextUtils.isEmpty(this.appName)) {
                this.appName = "推荐";
            }
            return this.appName;
        }

        public String getCardIcon() {
            return this.cardIcon;
        }
    }

    public WifiAdMagicTopView(Context context) {
        super(context);
        this.timeArray = new String[]{"1分钟前", "5分钟前", "10分钟前"};
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_wifi_ad_magic_top_view, (ViewGroup) this, true);
        viewInflate.setPadding(0, (int) UIUtils.getStatusBarHeight(context), 0, 0);
        this.appIcon = (ImageView) viewInflate.findViewById(R.id.app_logo);
        this.appName = (TextView) viewInflate.findViewById(R.id.app_name);
        this.appTime = (TextView) viewInflate.findViewById(R.id.app_time);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.view.WifiAdMagicTopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    public void configViewData(Config config) {
        this.config = config;
        this.appName.setText(config.getAppName());
        this.appTime.setText(this.timeArray[new Random().nextInt(2)]);
        new GlideImageLoader().loadImage(getContext(), this.appIcon, config.cardIcon, new GlideCircleTransform(getContext()));
    }

    public WifiAdMagicTopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.timeArray = new String[]{"1分钟前", "5分钟前", "10分钟前"};
        initView(context);
    }

    public WifiAdMagicTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.timeArray = new String[]{"1分钟前", "5分钟前", "10分钟前"};
        initView(context);
    }
}
