package com.kwad.components.ad.reward.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h extends s implements View.OnClickListener {
    protected ImageView BX;

    @Nullable
    protected KsAppTagsView Cb;
    protected KsConvertButton Cs;
    protected TextView Ct;

    @Nullable
    protected TextView Cu;

    @Nullable
    protected TextView Cv;
    protected a Cw;

    @LayoutRes
    protected int Cx = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean Cy = true;

    @Nullable
    protected KsLogoView mLogoView;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void jl();

        void jm();

        void jn();

        void jo();

        void jp();

        void jq();
    }

    private void ai(int i) {
        KsConvertButton ksConvertButton = this.Cs;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().ct(false).cw(false).cv(true).cu(true);
        }
        this.Cs.postInvalidate();
    }

    private void h(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.BX = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.Ct = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.Cb = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.Cu = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.Cv = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.Cs = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    private static int lp() {
        return R.id.ksad_common_app_card_root;
    }

    public final void a(a aVar) {
        this.Cw = aVar;
    }

    public final void g(ViewGroup viewGroup) {
        super.a(viewGroup, jk(), lp());
        h(this.vZ);
        ViewGroup viewGroup2 = this.vZ;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.Cs.setOnClickListener(this);
            this.BX.setOnClickListener(this);
            this.Ct.setOnClickListener(this);
            TextView textView = this.Cu;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.Cv;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.Cb;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    public int jk() {
        return R.id.ksad_common_app_card_stub;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.Cs)) {
            a aVar2 = this.Cw;
            if (aVar2 != null) {
                aVar2.jl();
                return;
            }
            return;
        }
        if (view.equals(this.BX)) {
            a aVar3 = this.Cw;
            if (aVar3 != null) {
                aVar3.jm();
                return;
            }
            return;
        }
        if (view.equals(this.Ct)) {
            a aVar4 = this.Cw;
            if (aVar4 != null) {
                aVar4.jn();
                return;
            }
            return;
        }
        if (view.equals(this.Cu) || view.equals(this.Cv)) {
            a aVar5 = this.Cw;
            if (aVar5 != null) {
                aVar5.jo();
                return;
            }
            return;
        }
        if (view.equals(this.Cb)) {
            a aVar6 = this.Cw;
            if (aVar6 != null) {
                aVar6.jp();
                return;
            }
            return;
        }
        if (!view.equals(this.vZ) || (aVar = this.Cw) == null) {
            return;
        }
        aVar.jq();
    }

    public final void show() {
        ViewGroup viewGroup = this.vZ;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.Cy));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        KsAppTagsView ksAppTagsView;
        KsConvertButton ksConvertButton;
        int i2;
        TextView textView2;
        if (aVar == null) {
            return;
        }
        ai(aVar.in());
        KsLogoView ksLogoView = this.mLogoView;
        if (ksLogoView != null) {
            ksLogoView.aS(aVar.ij());
        }
        this.Ct.setText(aVar.getTitle());
        TextView textView3 = this.Cu;
        if (textView3 != null) {
            textView3.setText(aVar.hq());
        }
        TextView textView4 = this.Cv;
        if (textView4 != null) {
            textView4.setText(aVar.hq());
            if (TextUtils.isEmpty(aVar.hq())) {
                i2 = 8;
            } else if (aVar.im()) {
                i2 = 8;
                i = 0;
                textView2 = this.Cu;
                if (textView2 != null) {
                    textView2.setVisibility(i2);
                }
                textView = this.Cv;
            } else {
                i2 = 0;
            }
            i = 8;
            textView2 = this.Cu;
            if (textView2 != null) {
            }
            textView = this.Cv;
        } else {
            textView = this.Cu;
            if (textView != null) {
                i = TextUtils.isEmpty(aVar.hq()) ? 8 : 0;
            }
            ksAppTagsView = this.Cb;
            if (ksAppTagsView != null) {
                ksAppTagsView.a(aVar.il(), this.Cx);
                this.Cb.setVisibility(aVar.im() ? 8 : 0);
            }
            ksConvertButton = this.Cs;
            if (ksConvertButton != null) {
                ksConvertButton.a(aVar.ik(), aVar.ij());
            }
            KSImageLoader.loadAppIcon(this.BX, aVar.hp(), aVar.ij(), 12);
        }
        textView.setVisibility(i);
        ksAppTagsView = this.Cb;
        if (ksAppTagsView != null) {
        }
        ksConvertButton = this.Cs;
        if (ksConvertButton != null) {
        }
        KSImageLoader.loadAppIcon(this.BX, aVar.hp(), aVar.ij(), 12);
    }
}
