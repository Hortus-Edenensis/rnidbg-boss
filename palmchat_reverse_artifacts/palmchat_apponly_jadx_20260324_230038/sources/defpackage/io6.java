package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class io6 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements on2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData.AdInteractionListener f18214a;

        public a(NestAdData.AdInteractionListener adInteractionListener) {
            this.f18214a = adInteractionListener;
        }

        @Override // defpackage.on2
        public void a(int i, Object obj) {
            if (obj instanceof h) {
                ((h) obj).a(null);
            }
        }

        @Override // defpackage.on2
        public void onAdClicked(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f18214a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked(nestAdData);
            }
        }

        @Override // defpackage.on2
        public void onAdExposed(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f18214a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdExposed(nestAdData);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f18215a;
        public final /* synthetic */ ViewGroup b;

        public b(h hVar, ViewGroup viewGroup) {
            this.f18215a = hVar;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = this.f18215a;
            if (hVar != null) {
                hVar.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f18216a;

        public c(TextView textView) {
            this.f18216a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f18216a.setText(R.string.generic_ad_action_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f18216a.getContext(), R.string.downloaded_action_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f18216a.setText(R.string.generic_ad_action_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f18216a.setText(R.string.generic_ad_action_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f18216a.setText(R.string.generic_ad_action_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f18216a.setText(R.string.generic_ad_action_download);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f18217a;
        public final /* synthetic */ ViewGroup b;

        public d(h hVar, ViewGroup viewGroup) {
            this.f18217a = hVar;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = this.f18217a;
            if (hVar != null) {
                hVar.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f18218a;

        public e(TextView textView) {
            this.f18218a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f18218a.setText(R.string.generic_ad_action_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f18218a.getContext(), R.string.downloaded_action_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f18218a.setText(R.string.generic_ad_action_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f18218a.setText(R.string.generic_ad_action_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f18218a.setText(R.string.generic_ad_action_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f18218a.setText(R.string.generic_ad_action_download);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f18219a;
        public final /* synthetic */ ViewGroup b;

        public f(h hVar, ViewGroup viewGroup) {
            this.f18219a = hVar;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = this.f18219a;
            if (hVar != null) {
                hVar.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f18220a;

        public g(TextView textView) {
            this.f18220a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f18220a.setText(R.string.generic_ad_action_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f18220a.getContext(), R.string.downloaded_action_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f18220a.setText(R.string.generic_ad_action_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f18220a.setText(R.string.generic_ad_action_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f18220a.setText(R.string.generic_ad_action_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f18220a.setText(R.string.generic_ad_action_download);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a(View view);
    }

    public static View a(Context context, NestAdData nestAdData, int i, h hVar, NestAdData.AdInteractionListener adInteractionListener) {
        return i != 1 ? i != 2 ? i != 3 ? new Space(context) : (n6.a() && n6.b(40) == n6.c) ? d(context, nestAdData, hVar, adInteractionListener) : b(context, nestAdData, hVar) : c(context, nestAdData, hVar) : e(context, nestAdData, hVar);
    }

    public static View b(Context context, NestAdData nestAdData, h hVar) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_wkmine_bannerview_content_large, (ViewGroup) null);
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        ViewGroup viewGroupWrapDecorationIfGDT = adHelperFeed.wrapDecorationIfGDT((ViewGroup) viewInflate, nestAdData);
        if (g(nestAdData)) {
            View adView = nestAdData.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    ViewGroup viewGroup = (ViewGroup) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_video);
                    viewGroup.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(nestAdData, viewGroup);
                }
            }
        } else {
            String strF = f(nestAdData);
            if (!TextUtils.isEmpty(strF)) {
                WifiNestAd.INSTANCE.getImageLoader().display((ImageView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_img), strF);
            }
        }
        viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_close).setOnClickListener(new f(hVar, viewGroupWrapDecorationIfGDT));
        TextView textView = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_title);
        String title = nestAdData.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = context.getString(R.string.generic_ad_info_blank);
        }
        textView.setText(title);
        TextView textView2 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_app_name);
        String adAppName = nestAdData.getAdAppName();
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = context.getString(R.string.generic_ad_info_blank);
        }
        textView2.setText(adAppName);
        ImageView imageView = (ImageView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_icon);
        if (nestAdData.supportAdLogo()) {
            imageView.setImageResource(nestAdData.getAdLogoResId());
        } else {
            imageView.setVisibility(8);
        }
        TextView textView3 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_sign);
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            textView3.setText(R.string.generic_ad_sign_personalize);
        } else {
            textView3.setText(R.string.generic_ad_sign_normal);
        }
        TextView textView4 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_action);
        if (nestAdData.getInteractionType().intValue() == 1) {
            textView4.setText(R.string.generic_ad_action_download);
            nestAdData.setAppDownloadListener(new g(textView4));
        } else {
            textView4.setText(R.string.generic_ad_action_see);
        }
        AdComInfoAllLayout adComInfoAllLayout = (AdComInfoAllLayout) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_com_info_layout);
        if (adComInfoAllLayout != null) {
            adComInfoAllLayout.initComInfo(nestAdData);
        }
        adHelperFeed.registerViewAndAction(viewGroupWrapDecorationIfGDT, textView4, new View[]{viewInflate}, null, null, nestAdData);
        return viewGroupWrapDecorationIfGDT;
    }

    public static View c(Context context, NestAdData nestAdData, h hVar) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_wkmine_bannerview_content_normal, (ViewGroup) null);
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        ViewGroup viewGroupWrapDecorationIfGDT = adHelperFeed.wrapDecorationIfGDT((ViewGroup) viewInflate, nestAdData);
        if (g(nestAdData)) {
            View adView = nestAdData.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    ViewGroup viewGroup = (ViewGroup) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_video);
                    viewGroup.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(nestAdData, viewGroup);
                }
            }
        } else {
            String strF = f(nestAdData);
            if (!TextUtils.isEmpty(strF)) {
                WifiNestAd.INSTANCE.getImageLoader().display((ImageView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_img), strF);
            }
        }
        viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_close).setOnClickListener(new d(hVar, viewGroupWrapDecorationIfGDT));
        TextView textView = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_title);
        String title = nestAdData.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = context.getString(R.string.generic_ad_info_blank);
        }
        textView.setText(title);
        TextView textView2 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_app_name);
        String adAppName = nestAdData.getAdAppName();
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = context.getString(R.string.generic_ad_info_blank);
        }
        textView2.setText(adAppName);
        ImageView imageView = (ImageView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_icon);
        if (nestAdData.supportAdLogo()) {
            imageView.setImageResource(nestAdData.getAdLogoResId());
        } else {
            imageView.setVisibility(8);
        }
        TextView textView3 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_sign);
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            textView3.setText(R.string.generic_ad_sign_personalize);
        } else {
            textView3.setText(R.string.generic_ad_sign_normal);
        }
        TextView textView4 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_action);
        if (nestAdData.getInteractionType().intValue() == 1) {
            textView4.setText(R.string.generic_ad_action_download);
            nestAdData.setAppDownloadListener(new e(textView4));
        } else {
            textView4.setText(R.string.generic_ad_action_see);
        }
        AdComInfoAllLayout adComInfoAllLayout = (AdComInfoAllLayout) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_com_info_layout);
        if (adComInfoAllLayout != null) {
            adComInfoAllLayout.initComInfo(nestAdData);
        }
        adHelperFeed.registerViewAndAction(viewGroupWrapDecorationIfGDT, textView4, new View[]{viewInflate}, null, null, nestAdData);
        return viewGroupWrapDecorationIfGDT;
    }

    public static View d(Context context, NestAdData nestAdData, h hVar, NestAdData.AdInteractionListener adInteractionListener) {
        if (context != null && nestAdData != null && hVar != null) {
            iv3 iv3Var = new iv3(nestAdData.getAdScene(), nestAdData, new fv3(hVar, new a(adInteractionListener)));
            View viewD = nv3.d(iv3Var, context);
            if (viewD instanceof ViewGroup) {
                nv3.a(iv3Var, context, (ViewGroup) viewD);
                return viewD;
            }
        }
        return new Space(context);
    }

    public static View e(Context context, NestAdData nestAdData, h hVar) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_wktab_bannerview_content, (ViewGroup) null);
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        ViewGroup viewGroupWrapDecorationIfGDT = adHelperFeed.wrapDecorationIfGDT((ViewGroup) viewInflate, nestAdData);
        if (g(nestAdData)) {
            View adView = nestAdData.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    ViewGroup viewGroup = (ViewGroup) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_video);
                    viewGroup.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(nestAdData, viewGroup);
                }
            }
        } else {
            String strF = f(nestAdData);
            if (!TextUtils.isEmpty(strF)) {
                WifiNestAd.INSTANCE.getImageLoader().display((ImageView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_img), strF);
            }
        }
        TextView textView = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_sign);
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            textView.setText(R.string.generic_ad_sign_personalize);
        } else {
            textView.setText(R.string.generic_ad_sign_normal);
        }
        TextView textView2 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_app_name);
        String adAppName = nestAdData.getAdAppName();
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = context.getString(R.string.generic_ad_info_blank);
        }
        textView2.setText(adAppName);
        TextView textView3 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_name);
        String title = nestAdData.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = context.getString(R.string.generic_ad_info_blank);
        }
        textView3.setText(title);
        viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_close).setOnClickListener(new b(hVar, viewGroupWrapDecorationIfGDT));
        TextView textView4 = (TextView) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_action);
        if (nestAdData.getInteractionType().intValue() == 1) {
            textView4.setText(R.string.generic_ad_action_download);
            nestAdData.setAppDownloadListener(new c(textView4));
        } else {
            textView4.setText(R.string.generic_ad_action_see);
        }
        AdComInfoAllLayout adComInfoAllLayout = (AdComInfoAllLayout) viewGroupWrapDecorationIfGDT.findViewById(R.id.ad_com_info_layout);
        if (adComInfoAllLayout != null) {
            adComInfoAllLayout.initComInfo(nestAdData);
        }
        adHelperFeed.registerViewAndAction(viewGroupWrapDecorationIfGDT, textView4, new View[]{viewInflate}, null, null, nestAdData);
        return viewGroupWrapDecorationIfGDT;
    }

    public static String f(NestAdData nestAdData) {
        List<String> imageList;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public static boolean g(NestAdData nestAdData) {
        int iIntValue = nestAdData.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
    }
}
