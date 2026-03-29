package com.zenmen.palmchat.chat.aigreeting;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amap.api.services.core.AMapException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingBuyResult;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import defpackage.a9;
import defpackage.b9;
import defpackage.io2;
import defpackage.me1;
import defpackage.nb3;
import defpackage.of2;
import defpackage.sy5;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiGreetingBuyDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f12724a;
    public final f b;
    public SkuItem c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AiGreetingSkuItemView f12725a;
        public final /* synthetic */ AiGreetingSkuItemView b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ SkuItem d;

        public a(AiGreetingSkuItemView aiGreetingSkuItemView, AiGreetingSkuItemView aiGreetingSkuItemView2, TextView textView, SkuItem skuItem) {
            this.f12725a = aiGreetingSkuItemView;
            this.b = aiGreetingSkuItemView2;
            this.c = textView;
            this.d = skuItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f12725a.setSelect(true);
            this.b.setSelect(false);
            this.c.setText(this.d.btnText + "(" + this.d.totalLxBeanNum + ")连信豆");
            AiGreetingBuyDialog.this.c = this.d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AiGreetingSkuItemView f12726a;
        public final /* synthetic */ AiGreetingSkuItemView b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ SkuItem d;

        public b(AiGreetingSkuItemView aiGreetingSkuItemView, AiGreetingSkuItemView aiGreetingSkuItemView2, TextView textView, SkuItem skuItem) {
            this.f12726a = aiGreetingSkuItemView;
            this.b = aiGreetingSkuItemView2;
            this.c = textView;
            this.d = skuItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f12726a.setSelect(false);
            this.b.setSelect(true);
            this.c.setText(this.d.btnText + "(" + this.d.totalLxBeanNum + ")连信豆");
            AiGreetingBuyDialog.this.c = this.d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AiGreetingBuyDialog.this.b.b(AiGreetingBuyDialog.this.c != null && AiGreetingBuyDialog.this.c.packageDealType == 2);
            AiGreetingBuyDialog.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a();

        void b(boolean z);
    }

    public AiGreetingBuyDialog(@NonNull Activity activity, f fVar) {
        super(activity, R.style.CircleBottomDialog);
        this.c = null;
        this.f12724a = activity;
        this.b = fVar;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        s();
    }

    public final void r() {
        SkuItem skuItem = this.c;
        if (skuItem != null) {
            a9.c(skuItem.cfgId, new e());
        }
    }

    public void s() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_ai_greeting_buy, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.remainTv)).setText(b9.d().f().getRemainCountForShow());
        SkuConfig skuConfig = b9.d().f().skuConfig;
        if (skuConfig != null) {
            ((TextView) viewInflate.findViewById(R.id.titleTv)).setText(skuConfig.mainTitle);
            ((TextView) viewInflate.findViewById(R.id.desContentView)).setText(skuConfig.purchaseInstructions);
            TextView textView = (TextView) viewInflate.findViewById(R.id.buy);
            List<SkuItem> list = skuConfig.packageDealList;
            if (list != null && list.size() > 1) {
                AiGreetingSkuItemView aiGreetingSkuItemView = (AiGreetingSkuItemView) viewInflate.findViewById(R.id.sku1);
                AiGreetingSkuItemView aiGreetingSkuItemView2 = (AiGreetingSkuItemView) viewInflate.findViewById(R.id.sku2);
                SkuItem skuItem = skuConfig.packageDealList.get(0);
                SkuItem skuItem2 = skuConfig.packageDealList.get(1);
                aiGreetingSkuItemView.update(skuItem);
                aiGreetingSkuItemView2.update(skuItem2);
                aiGreetingSkuItemView.setSelect(true);
                aiGreetingSkuItemView2.setSelect(false);
                textView.setText(skuItem.btnText + "(" + skuItem.totalLxBeanNum + ")连信豆");
                this.c = skuItem;
                aiGreetingSkuItemView.setOnClickListener(new a(aiGreetingSkuItemView, aiGreetingSkuItemView2, textView, skuItem));
                aiGreetingSkuItemView2.setOnClickListener(new b(aiGreetingSkuItemView, aiGreetingSkuItemView2, textView, skuItem2));
                textView.setOnClickListener(new c());
            }
        }
        setCanceledOnTouchOutside(true);
        setOnCancelListener(new d());
        setContentView(viewInflate, new ViewGroup.LayoutParams(me1.g(), -2));
        t(viewInflate);
    }

    public final void t(View view) {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
            attributes.height = me1.b(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            attributes.flags &= 2;
            window.setAttributes(attributes);
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) view.getParent());
            bottomSheetBehaviorFrom.setPeekHeight(me1.b(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            bottomSheetBehaviorFrom.setDraggable(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements io2<LXBaseNetBean<AiGreetingBuyResult>> {
        public e() {
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiGreetingBuyResult> lXBaseNetBean, Exception exc) {
            if (lXBaseNetBean != null && lXBaseNetBean.isSuccess()) {
                AiGreetingBuyDialog.this.b.a();
                sy5.h(AppContext.getContext(), "爱力值注入成功！", 0);
                AiGreetingBuyDialog.this.dismiss();
            } else {
                if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 5008) {
                    return;
                }
                nb3.k(AiGreetingBuyDialog.this.f12724a, of2.e(AMapException.CODE_AMAP_CLIENT_ERROR_PROTOCOL, 160101, ""), AiGreetingBuyDialog.this.c.totalLxBeanNum, new a());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements nb3.c {
            public a() {
            }

            @Override // nb3.c
            public void a(int i, String str, Object obj) {
            }
        }
    }
}
