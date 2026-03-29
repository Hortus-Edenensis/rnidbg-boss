package com.zenmen.palmchat.ui.widget.photo.newui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ir5;
import defpackage.me1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NineGridLayoutNew extends ViewGroup {
    public static final int MAX_HEIGHT = 946;
    public static final double MAX_HEIGHT_RATIO = 1.1666666666666667d;
    public static final int MIN_HEIGHT = 240;
    public static final double MIN_HEIGHT_RATIO = 0.3d;
    private static final int SPACE = me1.b(com.zenmen.palmchat.c.b(), 4);
    private static final String TAG = "NineGridLayoutNew";
    public static final int TYPE_1 = 100;
    public static final int TYPE_2 = 200;
    public static final int TYPE_3_1 = 301;
    public static final int TYPE_3_2 = 302;
    public static final int TYPE_4 = 400;
    public static final int TYPE_5 = 500;
    public static final int TYPE_6 = 600;
    public static final int TYPE_7 = 700;
    public static final int TYPE_8 = 800;
    public static final int TYPE_9 = 900;
    protected Context mContext;
    private boolean mIsFirst;
    private List<Media> mMediaList;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f15621a;
        public final /* synthetic */ List b;

        public a(Media media, List list) {
            this.f15621a = media;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(1, this.f15621a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f15622a;
        public final /* synthetic */ List b;

        public b(Media media, List list) {
            this.f15622a = media;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(2, this.f15622a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15623a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public c(int i, Media media, List list) {
            this.f15623a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15623a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15624a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public d(int i, Media media, List list) {
            this.f15624a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15624a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15625a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public e(int i, Media media, List list) {
            this.f15625a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15625a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15626a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public f(int i, Media media, List list) {
            this.f15626a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15626a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15627a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public g(int i, Media media, List list) {
            this.f15627a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15627a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15628a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public h(int i, Media media, List list) {
            this.f15628a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15628a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15629a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public i(int i, Media media, List list) {
            this.f15629a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15629a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15630a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public j(int i, Media media, List list) {
            this.f15630a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15630a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NineGridLayoutNew.this.adjustLayout();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15632a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public l(int i, Media media, List list) {
            this.f15632a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15632a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NineGridLayoutNew.this.adjustLayout();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f15634a;
        public final /* synthetic */ List b;

        public n(Media media, List list) {
            this.f15634a = media;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(0, this.f15634a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15635a;

        public o(int i) {
            this.f15635a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = NineGridLayoutNew.this.getLayoutParams();
            layoutParams.height = this.f15635a;
            NineGridLayoutNew.this.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15636a;
        public final /* synthetic */ Media b;
        public final /* synthetic */ List c;

        public p(int i, Media media, List list) {
            this.f15636a = i;
            this.b = media;
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(this.f15636a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f15637a;
        public final /* synthetic */ List b;

        public q(Media media, List list) {
            this.f15637a = media;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(0, this.f15637a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f15638a;
        public final /* synthetic */ List b;

        public r(Media media, List list) {
            this.f15638a = media;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(1, this.f15638a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f15639a;
        public final /* synthetic */ List b;

        public s(Media media, List list) {
            this.f15639a = media;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(2, this.f15639a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f15640a;
        public final /* synthetic */ List b;

        public t(Media media, List list) {
            this.f15640a = media;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridLayoutNew.this.onClickImage(0, this.f15640a, this.b);
        }
    }

    public NineGridLayoutNew(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustLayout() {
        long jB = ir5.b();
        String str = TAG;
        LogUtil.d(str, "adjustLayout start:" + jB);
        removeAllViews();
        int listSize = getListSize(this.mMediaList);
        setVisibility(0);
        if (listSize == 1) {
            layout_1(this.mMediaList);
        } else if (listSize == 2) {
            layout_2(this.mMediaList);
        } else if (listSize == 3) {
            layout_3(this.mMediaList);
        } else if (listSize == 4) {
            layout_4(this.mMediaList);
        } else if (listSize == 5) {
            layout_5(this.mMediaList);
        } else if (listSize == 6) {
            layout_6(this.mMediaList);
        } else if (listSize == 7) {
            layout_7(this.mMediaList);
        } else if (listSize == 8) {
            layout_8(this.mMediaList);
        } else if (listSize != 9 && listSize <= 9) {
            setVisibility(8);
        } else {
            layout_9(this.mMediaList);
        }
        LogUtil.d(str, "adjustLayout end:" + (ir5.b() - jB));
    }

    private int getListSize(List<Media> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    private void initViews(Context context) {
        this.mContext = context;
    }

    private void layout_1(List<Media> list) {
        int width = getWidth();
        u uVar = new u();
        Media media = list.get(0);
        u uVar2 = new u(media);
        int iMin = Math.min(Math.max((uVar2.b * width) / uVar2.f15641a, 240), MAX_HEIGHT);
        uVar.f(width);
        uVar.e(iMin);
        RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
        ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(uVar.d(), uVar.c()));
        ratioImageViewNew.layout(0, 0, uVar.d(), uVar.c());
        addView(ratioImageViewNew);
        ratioImageViewNew.setOnClickListener(new n(media, list));
        displayOneImage(ratioImageViewNew, media);
        String str = TAG;
        LogUtil.d(str, uVar.toString());
        setContainerHeight(uVar.b);
        LogUtil.d(str, "layout_1 END");
    }

    private void layout_2(List<Media> list) {
        int width = (getWidth() - SPACE) / 2;
        int i2 = 0;
        while (i2 < 2) {
            RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
            ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(width, width));
            int i3 = SPACE;
            int i4 = i2 + 1;
            ratioImageViewNew.layout((width + i3) * i2, 0, (i3 * i2) + (i4 * width), width);
            addView(ratioImageViewNew);
            Media media = list.get(i2);
            ratioImageViewNew.setOnClickListener(new p(i2, media, list));
            displayImage(ratioImageViewNew, media);
            i2 = i4;
        }
        setContainerHeight(width);
    }

    private void layout_3(List<Media> list) {
        int width = getWidth();
        int i2 = SPACE;
        int i3 = (width - i2) / 2;
        u uVar = new u(list.get(0));
        if (uVar.d() >= uVar.c()) {
            RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
            ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(width, i3));
            ratioImageViewNew.layout(0, 0, width, i3);
            addView(ratioImageViewNew);
            Media media = list.get(0);
            ratioImageViewNew.setOnClickListener(new q(media, list));
            displayImage(ratioImageViewNew, media);
            RatioImageViewNew ratioImageViewNew2 = new RatioImageViewNew(this.mContext);
            ratioImageViewNew2.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
            int i4 = i3 * 2;
            ratioImageViewNew2.layout(0, i3 + i2, i3, i4 + i2);
            addView(ratioImageViewNew2);
            Media media2 = list.get(1);
            ratioImageViewNew2.setOnClickListener(new r(media2, list));
            displayImage(ratioImageViewNew2, media2);
            RatioImageViewNew ratioImageViewNew3 = new RatioImageViewNew(this.mContext);
            ratioImageViewNew3.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
            ratioImageViewNew3.layout(i3 + i2, i3 + i2, i4 + i2, i4 + i2);
            addView(ratioImageViewNew3);
            Media media3 = list.get(2);
            ratioImageViewNew3.setOnClickListener(new s(media3, list));
            displayImage(ratioImageViewNew3, media3);
            setContainerHeight(i4 + i2);
            return;
        }
        RatioImageViewNew ratioImageViewNew4 = new RatioImageViewNew(this.mContext);
        ratioImageViewNew4.setLayoutParams(new ViewGroup.LayoutParams(i3, width));
        ratioImageViewNew4.layout(0, 0, i3, width);
        addView(ratioImageViewNew4);
        Media media4 = list.get(0);
        ratioImageViewNew4.setOnClickListener(new t(media4, list));
        displayImage(ratioImageViewNew4, media4);
        RatioImageViewNew ratioImageViewNew5 = new RatioImageViewNew(this.mContext);
        ratioImageViewNew5.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
        int i5 = i3 * 2;
        ratioImageViewNew5.layout(i3 + i2, 0, i5 + i2, i3);
        addView(ratioImageViewNew5);
        Media media5 = list.get(1);
        ratioImageViewNew5.setOnClickListener(new a(media5, list));
        displayImage(ratioImageViewNew5, media5);
        RatioImageViewNew ratioImageViewNew6 = new RatioImageViewNew(this.mContext);
        ratioImageViewNew6.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
        ratioImageViewNew6.layout(i3 + i2, i3 + i2, i5 + i2, i5 + i2);
        addView(ratioImageViewNew6);
        Media media6 = list.get(2);
        ratioImageViewNew6.setOnClickListener(new b(media6, list));
        displayImage(ratioImageViewNew6, media6);
        setContainerHeight(width);
    }

    private void layout_4(List<Media> list) {
        int width = (getWidth() - SPACE) / 2;
        for (int i2 = 0; i2 < 2; i2++) {
            int i3 = 0;
            while (i3 < 2) {
                RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
                ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(width, width));
                int i4 = SPACE;
                int i5 = i3 + 1;
                ratioImageViewNew.layout((width + i4) * i3, (width + i4) * i2, (i3 * i4) + (i5 * width), (i4 * i2) + ((i2 + 1) * width));
                addView(ratioImageViewNew);
                int i6 = (i2 * 2) + i3;
                Media media = list.get(i6);
                ratioImageViewNew.setOnClickListener(new c(i6, media, list));
                displayImage(ratioImageViewNew, media);
                i3 = i5;
            }
        }
        setContainerHeight((width * 2) + SPACE);
    }

    private void layout_5(List<Media> list) {
        int width = getWidth();
        int i2 = SPACE;
        int i3 = (width - i2) / 2;
        int i4 = (width - (i2 * 2)) / 3;
        for (int i5 = 0; i5 < 2; i5++) {
            if (i5 < 1) {
                int i6 = 0;
                while (i6 < 2) {
                    RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
                    ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
                    int i7 = SPACE;
                    int i8 = i6 + 1;
                    ratioImageViewNew.layout((i3 + i7) * i6, (i3 + i7) * i5, (i6 * i7) + (i8 * i3), (i7 * i5) + ((i5 + 1) * i3));
                    addView(ratioImageViewNew);
                    int i9 = (i5 * 2) + i6;
                    Media media = list.get(i9);
                    ratioImageViewNew.setOnClickListener(new d(i9, media, list));
                    displayImage(ratioImageViewNew, media);
                    i6 = i8;
                }
            } else {
                int i10 = 0;
                while (i10 < 3) {
                    RatioImageViewNew ratioImageViewNew2 = new RatioImageViewNew(this.mContext);
                    ratioImageViewNew2.setLayoutParams(new ViewGroup.LayoutParams(i4, i4));
                    int i11 = SPACE;
                    int i12 = i10 + 1;
                    ratioImageViewNew2.layout((i4 + i11) * i10, (i3 + i11) * i5, (i10 * i11) + (i12 * i4), ((i11 + i3) * i5) + i4);
                    addView(ratioImageViewNew2);
                    int i13 = (i5 * 2) + i10;
                    Media media2 = list.get(i13);
                    ratioImageViewNew2.setOnClickListener(new e(i13, media2, list));
                    displayImage(ratioImageViewNew2, media2);
                    i10 = i12;
                }
            }
        }
        setContainerHeight(i3 + i4 + SPACE);
    }

    private void layout_6(List<Media> list) {
        int width = (getWidth() - (SPACE * 2)) / 3;
        for (int i2 = 0; i2 < 2; i2++) {
            int i3 = 0;
            while (i3 < 3) {
                RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
                ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(width, width));
                int i4 = SPACE;
                int i5 = i3 + 1;
                ratioImageViewNew.layout((width + i4) * i3, (width + i4) * i2, (i3 * i4) + (i5 * width), (i4 * i2) + ((i2 + 1) * width));
                addView(ratioImageViewNew);
                int i6 = (i2 * 3) + i3;
                Media media = list.get(i6);
                ratioImageViewNew.setOnClickListener(new f(i6, media, list));
                displayImage(ratioImageViewNew, media);
                i3 = i5;
            }
        }
        setContainerHeight((width * 2) + SPACE);
    }

    private void layout_7(List<Media> list) {
        int width = getWidth();
        int i2 = SPACE;
        int i3 = (width - i2) / 2;
        int i4 = (width - (i2 * 2)) / 3;
        for (int i5 = 0; i5 < 3; i5++) {
            if (i5 < 2) {
                int i6 = 0;
                while (i6 < 2) {
                    RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
                    ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
                    int i7 = SPACE;
                    int i8 = i6 + 1;
                    ratioImageViewNew.layout((i3 + i7) * i6, (i3 + i7) * i5, (i6 * i7) + (i8 * i3), (i7 * i5) + ((i5 + 1) * i3));
                    addView(ratioImageViewNew);
                    int i9 = (i5 * 2) + i6;
                    Media media = list.get(i9);
                    ratioImageViewNew.setOnClickListener(new g(i9, media, list));
                    displayImage(ratioImageViewNew, media);
                    i6 = i8;
                }
            } else {
                int i10 = 0;
                while (i10 < 3) {
                    RatioImageViewNew ratioImageViewNew2 = new RatioImageViewNew(this.mContext);
                    ratioImageViewNew2.setLayoutParams(new ViewGroup.LayoutParams(i4, i4));
                    int i11 = SPACE;
                    int i12 = i10 + 1;
                    ratioImageViewNew2.layout((i4 + i11) * i10, (i3 + i11) * i5, (i10 * i11) + (i12 * i4), ((i11 + i3) * i5) + i4);
                    addView(ratioImageViewNew2);
                    int i13 = (i5 * 2) + i10;
                    Media media2 = list.get(i13);
                    ratioImageViewNew2.setOnClickListener(new h(i13, media2, list));
                    displayImage(ratioImageViewNew2, media2);
                    i10 = i12;
                }
            }
        }
        setContainerHeight((i3 * 2) + i4 + (SPACE * 2));
    }

    private void layout_8(List<Media> list) {
        int width = getWidth();
        int i2 = SPACE;
        int i3 = (width - i2) / 2;
        int i4 = (width - (i2 * 2)) / 3;
        for (int i5 = 0; i5 < 3; i5++) {
            if (i5 < 1) {
                int i6 = 0;
                while (i6 < 2) {
                    RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
                    ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
                    int i7 = SPACE;
                    int i8 = i6 + 1;
                    ratioImageViewNew.layout((i3 + i7) * i6, (i3 + i7) * i5, (i6 * i7) + (i8 * i3), (i7 * i5) + ((i5 + 1) * i3));
                    addView(ratioImageViewNew);
                    Media media = list.get(i6);
                    ratioImageViewNew.setOnClickListener(new i(i6, media, list));
                    displayImage(ratioImageViewNew, media);
                    i6 = i8;
                }
            } else {
                int i9 = 0;
                while (i9 < 3) {
                    RatioImageViewNew ratioImageViewNew2 = new RatioImageViewNew(this.mContext);
                    ratioImageViewNew2.setLayoutParams(new ViewGroup.LayoutParams(i4, i4));
                    int i10 = SPACE;
                    int i11 = i5 - 1;
                    int i12 = i9 + 1;
                    ratioImageViewNew2.layout((i4 + i10) * i9, ((i3 + i10) * 1) + ((i4 + i10) * i11), (i9 * i10) + (i12 * i4), ((i3 + i10) * 1) + (i10 * i11) + ((i11 + 1) * i4));
                    addView(ratioImageViewNew2);
                    int i13 = (i11 * 3) + 2 + i9;
                    Media media2 = list.get(i13);
                    ratioImageViewNew2.setOnClickListener(new j(i13, media2, list));
                    displayImage(ratioImageViewNew2, media2);
                    i9 = i12;
                }
            }
        }
        setContainerHeight((i4 * 2) + i3 + (SPACE * 2));
    }

    private void layout_9(List<Media> list) {
        int width = (getWidth() - (SPACE * 2)) / 3;
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = 0;
            while (i3 < 3) {
                RatioImageViewNew ratioImageViewNew = new RatioImageViewNew(this.mContext);
                ratioImageViewNew.setLayoutParams(new ViewGroup.LayoutParams(width, width));
                int i4 = SPACE;
                int i5 = i3 + 1;
                ratioImageViewNew.layout((width + i4) * i3, (width + i4) * i2, (i3 * i4) + (i5 * width), (i4 * i2) + ((i2 + 1) * width));
                addView(ratioImageViewNew);
                int i6 = (i2 * 3) + i3;
                Media media = list.get(i6);
                ratioImageViewNew.setOnClickListener(new l(i6, media, list));
                displayImage(ratioImageViewNew, media);
                i3 = i5;
            }
        }
        setContainerHeight((width * 3) + (SPACE * 2));
    }

    private void setContainerHeight(int i2) {
        post(new o(i2));
    }

    public abstract void displayImage(RatioImageViewNew ratioImageViewNew, Media media);

    public abstract boolean displayOneImage(RatioImageViewNew ratioImageViewNew, Media media);

    public abstract void onClickImage(int i2, Media media, List<Media> list);

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.mIsFirst) {
            post(new k());
            this.mIsFirst = false;
        }
    }

    public void setMediaList(List<Media> list) {
        LogUtil.d(TAG, "getChildCount:" + getChildCount());
        if (getListSize(list) == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mMediaList.clear();
        this.mMediaList.addAll(list);
        post(new m());
    }

    public NineGridLayoutNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridLayoutNew(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mMediaList = new ArrayList();
        this.mIsFirst = true;
        initViews(context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15641a;
        public int b;

        public u(Media media) {
            if (TextUtils.isEmpty(media.width) || TextUtils.isEmpty(media.height)) {
                this.f15641a = 240;
                this.b = 240;
                return;
            }
            this.f15641a = Integer.parseInt(media.width);
            int i = Integer.parseInt(media.height);
            this.b = i;
            if (this.f15641a == 0 || i == 0) {
                this.f15641a = 240;
                this.b = 240;
            }
        }

        public int c() {
            return this.b;
        }

        public int d() {
            return this.f15641a;
        }

        public void e(int i) {
            this.b = i;
        }

        public void f(int i) {
            this.f15641a = i;
        }

        public String toString() {
            return "ImageSize{width=" + this.f15641a + ", height=" + this.b + '}';
        }

        public u() {
            this(0, 0);
        }

        public u(int i, int i2) {
            if (i > 0 && i2 > 0) {
                this.f15641a = i;
                this.b = i2;
            } else {
                this.f15641a = 240;
                this.b = 240;
            }
        }
    }
}
