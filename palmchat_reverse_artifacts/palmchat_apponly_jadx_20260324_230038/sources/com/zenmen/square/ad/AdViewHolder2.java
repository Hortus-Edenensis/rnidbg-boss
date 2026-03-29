package com.zenmen.square.ad;

import android.view.View;
import android.view.ViewGroup;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.databinding.SquareGenericListItemAdBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.c6;
import defpackage.fn1;
import defpackage.hv3;
import defpackage.iv3;
import defpackage.nv3;
import defpackage.on2;
import defpackage.wh5;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AdViewHolder2 extends BaseViewHolder<SquareFeed, SquareGenericListItemAdBinding, zt1> {
    public int f;
    public c6 g;
    public NestAdData h;
    public ViewGroup i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements on2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16172a;

        public a(int i) {
            this.f16172a = i;
        }

        @Override // defpackage.on2
        public void a(int i, Object obj) {
            if (obj instanceof SquareFeed) {
                ((zt1) AdViewHolder2.this.e).l(i, (SquareFeed) obj);
            }
        }

        @Override // defpackage.on2
        public void onAdClicked(NestAdData nestAdData) {
            if (AdViewHolder2.this.f == 1) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.M(), AdViewHolder2.this.f, "LX-35416", wh5.P());
                return;
            }
            if (AdViewHolder2.this.f == 2) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.J(), AdViewHolder2.this.f, "LX-35416", wh5.P());
            } else if (AdViewHolder2.this.f == 73) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.K(), AdViewHolder2.this.f, "LX-43408", wh5.N());
            } else if (AdViewHolder2.this.f == 74) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.L(), AdViewHolder2.this.f, "LX-44460", wh5.O());
            }
        }

        @Override // defpackage.on2
        public void onAdExposed(NestAdData nestAdData) {
            if (AdViewHolder2.this.f == 1) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.M(), AdViewHolder2.this.f, "LX-35416", wh5.P());
                return;
            }
            if (AdViewHolder2.this.f == 2) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.J(), AdViewHolder2.this.f, "LX-35416", wh5.P());
            } else if (AdViewHolder2.this.f == 73) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.K(), AdViewHolder2.this.f, "LX-43408", wh5.N());
            } else if (AdViewHolder2.this.f == 74) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16172a, wh5.L(), AdViewHolder2.this.f, "LX-44460", wh5.O());
            }
        }
    }

    public AdViewHolder2(ViewGroup viewGroup, int i) {
        super(viewGroup);
        this.i = null;
        hv3.h = 1;
        this.f = i;
        if (i == 1) {
            this.g = wh5.I();
        } else if (i == 2) {
            this.g = wh5.F();
        } else if (i == 73) {
            this.g = wh5.G();
        } else if (i == 74) {
            this.g = wh5.H();
        } else {
            this.g = new c6();
        }
        LogUtil.d("", "NativeType AdViewHolder2 start ");
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(SquareFeed squareFeed, int i) {
        LogUtil.d("", "NativeType AdViewHolder2 bind position " + i + " bean " + squareFeed);
        int i2 = this.f;
        NestAdData nestAdDataD = i2 == 1 ? wh5.D(squareFeed.adKey.intValue()) : i2 == 2 ? wh5.A(squareFeed.adKey.intValue()) : i2 == 73 ? wh5.B(squareFeed.adKey.intValue()) : i2 == 74 ? wh5.C(squareFeed.adKey.intValue()) : null;
        if (nestAdDataD == null) {
            return;
        }
        iv3 iv3Var = new iv3(nestAdDataD.getAdScene(), nestAdDataD, new hv3(i, this.g, this.f, squareFeed, new a(i)));
        View viewD = nv3.d(iv3Var, this.itemView.getContext());
        if (viewD == null) {
            return;
        }
        if (viewD instanceof ViewGroup) {
            this.i = (ViewGroup) viewD;
            ((ViewGroup) this.itemView).removeAllViews();
            ((ViewGroup) this.itemView).addView(this.i, new ViewGroup.LayoutParams(-1, -1));
            nv3.a(iv3Var, this.itemView.getContext(), this.i);
        }
        NestAdData nestAdData = this.h;
        if (nestAdData != null) {
            nestAdData.setAppDownloadListener(new b());
        }
        this.h = nestAdDataD;
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements NestAdData.AppDownloadListener {
        public b() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
        }
    }
}
