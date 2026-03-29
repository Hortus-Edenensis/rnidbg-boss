package com.zm.fissionsdk;

import android.content.Context;
import android.view.View;
import com.zm.adxsdk.protocol.api.interfaces.IWfAdvert;
import com.zm.fissionsdk.api.interfaces.IFissionDraw;
import com.zm.fissionsdk.api.interfaces.IFissionNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zzV2V extends Z2V2W implements IFissionDraw {
    public zzV2V(IWfAdvert iWfAdvert) {
        super(iWfAdvert);
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionDraw
    public View getDrawView(Context context) {
        return getExpressView(context);
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionDraw
    public void setDrawInteractionListener(IFissionDraw.DrawInteractionListener drawInteractionListener) {
        setNativeExpressListener(new zZZ2W(drawInteractionListener));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements IFissionNative.NativeExpressInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionDraw.DrawInteractionListener f16762a;

        public zZZ2W(IFissionDraw.DrawInteractionListener drawInteractionListener) {
            this.f16762a = drawInteractionListener;
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
        public void onClick(View view) {
            IFissionDraw.DrawInteractionListener drawInteractionListener = this.f16762a;
            if (drawInteractionListener != null) {
                drawInteractionListener.onClick(view);
            }
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
        public void onShow() {
            IFissionDraw.DrawInteractionListener drawInteractionListener = this.f16762a;
            if (drawInteractionListener != null) {
                drawInteractionListener.onShow();
            }
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
        public void onShowFailed(int i, String str) {
            IFissionDraw.DrawInteractionListener drawInteractionListener = this.f16762a;
            if (drawInteractionListener != null) {
                drawInteractionListener.onShowFailed(i, str);
            }
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionNative.NativeExpressInteractionListener
        public void onClose() {
        }

        @Override // com.zm.fissionsdk.api.interfaces.IFissionNative.NativeInteractionListener
        public void onCreativeClick(View view) {
        }
    }
}
