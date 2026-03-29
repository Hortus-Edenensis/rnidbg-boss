package com.zenmen.palmchat.QRCodeScan;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.video.recorder.CameraView;
import defpackage.aq6;
import defpackage.ds0;
import defpackage.k86;
import defpackage.l84;
import defpackage.me1;
import defpackage.qm4;
import defpackage.r25;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ScannerView extends FrameLayout implements qm4 {
    private static final long DECODE_INTERVAL = 1000;
    private static final String TAG = "ScannerView";
    private static final int TARGET_VIEW_MARGIN_TOP_FENGMIAN = 105;
    private static final int TARGET_VIEW_MARGIN_TOP_SAOMA = 125;
    private static final int TARGET_VIEW_WIDTH_FENGMIAN = 100;
    private static final int TARGET_VIEW_WIDTH_SAOMA = 287;
    protected CameraView camera;
    protected aq6 decoder;
    protected AtomicBoolean mDecodeSuc;
    private long mLastDecodeTime;
    private r25 mScannerDecodeThread;
    private ScannerTargetView mScannerTargetView;
    private int mTargetMarginTop;
    private Rect mTargetRect;
    private int mTargetWidth;
    protected b scannerViewEventListener;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f12128a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public a(byte[] bArr, int i, int i2) {
            this.f12128a = bArr;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ScannerView.this.mDecodeSuc.get()) {
                    return;
                }
                String strB = ScannerView.this.decoder.b(this.f12128a, this.b, this.c, new Rect(0, 0, this.b, this.c));
                if (!TextUtils.isEmpty(strB)) {
                    ScannerView.this.mDecodeSuc.set(true);
                    ScannerView.this.scannerViewEventListener.onCodeScanned(strB);
                }
                ScannerView scannerView = ScannerView.this;
                ScannerView.this.scannerViewEventListener.onLightScanned((scannerView.getAverageColor(scannerView.decoder.e()) * 1.0f) / (-1.6777216E7f));
            } catch (Throwable th) {
                LogUtil.e(ScannerView.TAG, th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        boolean onCodeScanned(String str);

        void onLightScanned(float f);
    }

    public ScannerView(Context context) {
        super(context);
        this.mDecodeSuc = new AtomicBoolean(false);
        this.mLastDecodeTime = 0L;
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAverageColor(int[] iArr) {
        int i = 0;
        int iRed = 0;
        int iGreen = 0;
        int iBlue = 0;
        for (int i2 : iArr) {
            i++;
            iRed += Color.red(i2);
            iGreen += Color.green(i2);
            iBlue += Color.blue(i2);
        }
        if (i == 0) {
            return -16777216;
        }
        return Color.rgb(iRed / i, iGreen / i, iBlue / i);
    }

    private int getSaoMaTargetMarginTop() {
        return (((int) ((me1.f() - AppContext.getContext().getResources().getDimension(R.dimen.title_bar_height)) - me1.i(getContext()))) - (k86.e(AppContext.getContext(), 287.0f) + k86.e(getContext(), 48.0f))) / 2;
    }

    public void closeFlash() {
        this.camera.closeFlash();
    }

    public aq6 getDecoder() {
        return this.decoder;
    }

    public int getScannerLayoutResource() {
        return R.layout.view_scanner;
    }

    public View getScannerTargetView() {
        return this.mScannerTargetView;
    }

    public b getScannerViewEventListener() {
        return this.scannerViewEventListener;
    }

    public void initUI() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(getScannerLayoutResource(), this);
        CameraView cameraView = (CameraView) viewInflate.findViewById(R.id.zxscanlib_camera);
        this.camera = cameraView;
        cameraView.setCameraUsage(0);
        this.camera.setPreviewCallback(this);
        this.decoder = new aq6();
        this.mScannerTargetView = (ScannerTargetView) viewInflate.findViewById(R.id.scanner_target_view);
        this.mTargetRect = new Rect();
        this.mTargetWidth = k86.e(AppContext.getContext(), 287.0f);
        this.mTargetMarginTop = getSaoMaTargetMarginTop();
        r25 r25Var = new r25();
        this.mScannerDecodeThread = r25Var;
        r25Var.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mScannerDecodeThread.f20382a.getLooper().quit();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setTargetViewTargetRect(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.camera.setScannerROI(this.mTargetRect);
    }

    @Override // defpackage.qm4
    public void onOpenCameraFailed() {
        ds0.a().b(new l84());
    }

    @Override // defpackage.qm4
    public void onPreviewFrame(byte[] bArr, int i, int i2) {
        if (this.scannerViewEventListener != null) {
            this.mScannerDecodeThread.f20382a.post(new a(bArr, i, i2));
        }
    }

    public void openFlash() {
        this.camera.openFlash();
    }

    public void setScannerViewEventListener(b bVar) {
        this.scannerViewEventListener = bVar;
    }

    public void setTargetViewTargetRect(int i, int i2) {
        Rect rect = this.mTargetRect;
        if (rect == null || i <= 0 || i2 <= 0) {
            return;
        }
        int i3 = this.mTargetWidth;
        int i4 = (i - i3) / 2;
        rect.left = i4;
        int i5 = this.mTargetMarginTop;
        rect.top = i5;
        rect.right = i4 + i3;
        rect.bottom = i5 + i3;
        this.mScannerTargetView.setTargetRect(rect);
    }

    public void startScanner() {
        this.camera.startPreview();
    }

    public void stopScanner() {
        this.camera.stopPreview();
    }

    public void swithToFengmian() {
        this.mTargetWidth = k86.e(AppContext.getContext(), 100.0f);
        this.mTargetMarginTop = k86.e(AppContext.getContext(), 105.0f);
        setTargetViewTargetRect(getWidth(), getHeight());
        postInvalidate();
        this.mScannerTargetView.postInvalidate();
    }

    public void swithToSaoma() {
        this.mTargetWidth = k86.e(AppContext.getContext(), 287.0f);
        this.mTargetMarginTop = getSaoMaTargetMarginTop();
        setTargetViewTargetRect(getWidth(), getHeight());
        postInvalidate();
        this.mScannerTargetView.postInvalidate();
    }

    public ScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDecodeSuc = new AtomicBoolean(false);
        this.mLastDecodeTime = 0L;
        initUI();
    }

    public ScannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDecodeSuc = new AtomicBoolean(false);
        this.mLastDecodeTime = 0L;
        initUI();
    }
}
