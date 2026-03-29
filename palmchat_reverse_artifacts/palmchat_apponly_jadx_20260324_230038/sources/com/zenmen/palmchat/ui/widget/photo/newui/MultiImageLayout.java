package com.zenmen.palmchat.ui.widget.photo.newui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$styleable;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.ei4;
import defpackage.hc2;
import defpackage.k86;
import defpackage.kc2;
import defpackage.zn6;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MultiImageLayout extends ViewGroup {
    private static final float DEFAULT_SPACING = 3.0f;
    private static final int MAX_COUNT = 9;
    private static final int[][][] ROW_COLUMNS = {new int[0][], new int[][]{new int[]{1}}, new int[][]{new int[]{2}}, new int[][]{new int[]{1, 2}}, new int[][]{new int[]{2, 2}}, new int[][]{new int[]{2, 3}}, new int[][]{new int[]{3, 3}}, new int[][]{new int[]{1, 3, 3}, new int[]{2, 2, 3}}, new int[][]{new int[]{2, 3, 3}}, new int[][]{new int[]{3, 3, 3}}};
    private int from;
    private boolean isFromTimeLine;
    private Feed mFeed;
    private Long mFeedId;
    private List<Media> mMediaList;
    private float mSpacing;
    private boolean needLoad;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15620a;

        public a(int i) {
            this.f15620a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MultiImageLayout multiImageLayout = MultiImageLayout.this;
            multiImageLayout.startPhotoPreview(multiImageLayout.mMediaList, this.f15620a);
            MultiImageLayout.this.logImageClick();
        }
    }

    public MultiImageLayout(Context context) {
        this(context, null);
    }

    private int[] calcForSingleImage(int i) {
        int[] iArr = {i, i};
        Media media = this.mMediaList.get(0);
        float f = media.width != null ? Integer.parseInt(r2) : 0.0f;
        float f2 = media.height != null ? Integer.parseInt(r0) : 0.0f;
        if (f == 0.0f || f2 == 0.0f) {
            int iB = a46.b(getContext(), 180.0f);
            iArr[0] = iB;
            iArr[1] = Math.round(iB * 1.3333334f);
        } else if (f > f2) {
            int iB2 = a46.b(getContext(), 208.0f);
            iArr[0] = iB2;
            iArr[1] = Math.round(iB2 * 0.75f);
        } else {
            int iB3 = a46.b(getContext(), 180.0f);
            iArr[0] = iB3;
            iArr[1] = Math.round(iB3 * 1.3333334f);
        }
        return iArr;
    }

    private int calcHeightForMultipleImages(int i) {
        int[] rowColumns = getRowColumns();
        float fCalcImageSize = 0.0f;
        for (int i2 = 0; i2 < rowColumns.length; i2++) {
            fCalcImageSize += calcImageSize(i, Math.max(rowColumns[i2], 2));
            if (i2 > 0) {
                fCalcImageSize += this.mSpacing;
            }
        }
        return Math.round(fCalcImageSize);
    }

    private float calcImageSize(float f, int i) {
        return (f - ((i - 1) * this.mSpacing)) / i;
    }

    private ImageView createImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    private int getImageCount() {
        return this.mMediaList.size();
    }

    private int[] getRowColumns() {
        int[][] iArr = ROW_COLUMNS[getImageCount()];
        return iArr[(iArr.length == 2 && isFirstImagePortrait()) ? (char) 1 : (char) 0];
    }

    private String getUrl(Media media) {
        if (media.localPath != null && new File(media.localPath).exists()) {
            return media.localPath;
        }
        if (!TextUtils.isEmpty(media.url)) {
            return media.url;
        }
        String str = media.midUrl;
        return str != null ? str : media.url;
    }

    private boolean isFirstImagePortrait() {
        Media media = this.mMediaList.get(0);
        String str = media.width;
        int i = str != null ? Integer.parseInt(str) : 0;
        String str2 = media.height;
        return i < (str2 != null ? Integer.parseInt(str2) : 0);
    }

    private void layoutImage(int i, float f, float f2, float f3, float f4) {
        View childAt = getChildAt(i);
        childAt.layout(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4));
        if (i < 0 || i >= this.mMediaList.size() || !(childAt instanceof ImageView)) {
            return;
        }
        loadImage((ImageView) childAt, this.mMediaList.get(i), getImageCount() > 1 ? 4 : 8);
    }

    private void layoutMultipleImages(float f) {
        int[] rowColumns = getRowColumns();
        float fLayoutRowOfSingleImage = 0.0f;
        int i = 0;
        for (int i2 = 0; i2 < rowColumns.length; i2++) {
            int i3 = rowColumns[i2];
            fLayoutRowOfSingleImage += (i3 == 1 ? layoutRowOfSingleImage(i, fLayoutRowOfSingleImage, f) : layoutRowOfMultipleImages(i, i3, fLayoutRowOfSingleImage, f)) + this.mSpacing;
            i += rowColumns[i2];
        }
    }

    private float layoutRowOfMultipleImages(int i, int i2, float f, float f2) {
        float fCalcImageSize = calcImageSize(f2, i2);
        float f3 = f + fCalcImageSize;
        float f4 = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            layoutImage(i + i3, f4, f, f4 + fCalcImageSize, f3);
            f4 += this.mSpacing + fCalcImageSize;
        }
        return fCalcImageSize;
    }

    private float layoutRowOfSingleImage(int i, float f, float f2) {
        float fCalcImageSize = calcImageSize(f2, 2);
        layoutImage(i, 0.0f, f, f2, f + fCalcImageSize);
        return fCalcImageSize;
    }

    private void layoutThreeImages(int i, int i2) {
        if (!isFirstImagePortrait()) {
            layoutMultipleImages(i);
            return;
        }
        float f = i;
        float fCalcImageSize = calcImageSize(f, 2);
        float f2 = i2;
        layoutImage(0, 0.0f, 0.0f, fCalcImageSize, f2);
        float f3 = fCalcImageSize + this.mSpacing;
        layoutImage(1, f3, 0.0f, f, fCalcImageSize);
        layoutImage(2, f3, f3, f, f2);
    }

    private void loadImage(ImageView imageView, Media media, int i) {
        if (this.needLoad) {
            String url = getUrl(media);
            if (url == null) {
                imageView.setImageResource(R$drawable.delete_default);
                return;
            }
            kc2<Bitmap> kc2VarDiskCacheStrategy = hc2.a(getContext()).asBitmap().load(a46.h(imageView, k86.p(url))).transition(BitmapTransitionOptions.withCrossFade()).transform(new MultiTransformation(new CenterCrop(), new RoundedCornersTransformation(i, 0))).diskCacheStrategy(DiskCacheStrategy.DATA);
            int i2 = R$drawable.bg_feed_item_loading;
            kc2VarDiskCacheStrategy.placeholder(i2).fallback(i2).error(i2).into(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logImageClick() {
        if (this.isFromTimeLine && this.mFeedId != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("feed_id", this.mFeedId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("M31", "1", null, jSONObject.toString());
        }
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(this.from));
        map.put("feedid", this.mFeed.getFeedId());
        map.put("feedType", Integer.valueOf(this.mFeed.getFeedType()));
        map.put(ReportItem.RequestKeyRequestId, this.mFeed.reqId);
        zn6.j("pagediscover_feeds", "click", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoPreview(List<Media> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (Media media : list) {
            FeedBean feedBean = new FeedBean();
            MediaItem mediaItem = new MediaItem();
            if (media.localPath != null && new File(media.localPath).exists()) {
                mediaItem.fileFullPath = media.localPath;
            }
            String str = media.url;
            if (str != null) {
                mediaItem.fileFullPath = str;
            }
            mediaItem.thumbnailPath = media.midUrl;
            feedBean.setMediaItem(mediaItem);
            feedBean.setWidth(media.width);
            feedBean.setHeight(media.height);
            arrayList.add(feedBean);
        }
        Activity activity = (Activity) getContext();
        Feed feed = this.mFeed;
        ei4.e(activity, feed, arrayList, i, 0, feed.getId(), this.mFeed.getUid(), this.from);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (getImageCount() == 1) {
            layoutImage(0, 0.0f, 0.0f, i5, i6);
        } else if (getImageCount() == 3) {
            layoutThreeImages(i5, i6);
        } else if (getImageCount() > 1) {
            layoutMultipleImages(i5);
        }
        this.needLoad = false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getName() + " layout_width must be \"match_parent\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int iCalcHeightForMultipleImages = 0;
        if (getImageCount() == 1) {
            int[] iArrCalcForSingleImage = calcForSingleImage(size);
            int i3 = iArrCalcForSingleImage[0];
            iCalcHeightForMultipleImages = iArrCalcForSingleImage[1];
            size = i3;
        } else if (getImageCount() > 1) {
            iCalcHeightForMultipleImages = calcHeightForMultipleImages(size);
        }
        setMeasuredDimension(size, iCalcHeightForMultipleImages);
    }

    public void setFeed(Feed feed) {
        this.mFeed = feed;
    }

    public void setFeedId(Long l) {
        this.mFeedId = l;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setFromTimeLine(boolean z) {
        this.isFromTimeLine = z;
    }

    public void setMediaList(List<Media> list) {
        this.needLoad = true;
        this.mMediaList.clear();
        if (list != null) {
            this.mMediaList.addAll(list.subList(0, Math.min(list.size(), 9)));
        }
        if (getImageCount() == 1) {
            removeAllViews();
        }
        int imageCount = getImageCount() - getChildCount();
        if (imageCount > 0) {
            for (int i = 0; i < imageCount; i++) {
                addView(createImageView());
            }
        } else if (imageCount < 0) {
            removeViews(getImageCount(), -imageCount);
        }
        for (int i2 = 0; i2 < getImageCount(); i2++) {
            ImageView imageView = (ImageView) getChildAt(i2);
            imageView.setImageResource(R$drawable.bg_feed_item_loading);
            imageView.setOnClickListener(new a(i2));
        }
    }

    public MultiImageLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMediaList = new ArrayList();
        this.isFromTimeLine = false;
        this.needLoad = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MultiImageLayout);
        this.mSpacing = typedArrayObtainStyledAttributes.getDimension(R$styleable.MultiImageLayout_spacing, 3.0f);
        typedArrayObtainStyledAttributes.recycle();
    }
}
