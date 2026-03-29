package com.zenmen.media.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.media.crop.RangeBar;
import com.zenmen.palmchat.R;
import defpackage.b35;
import defpackage.n54;
import defpackage.sm5;
import defpackage.wc;
import defpackage.wv;
import defpackage.x86;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MCropView extends RelativeLayout implements RangeBar.OnRangeBarChangeListener {
    private static final String TAG = "MCropView";
    static boolean mstop2 = false;
    private int CROP_VIEW_MARGIN;
    private int CROP_VIEW_MARGIN_Percent;
    private final int CompactThumbHeight;
    private final int CompactThumbWidth;
    private int MIN_THUMB_COUNT;
    private final int NormalThumbHeight;
    private final int NormalThumbWidth;
    private LinearLayoutManager linearLayoutManager;
    private RangeAdapter mAdapter;
    private Context mContext;
    private List<AlbumBean> mDataList;
    private int mFirstVisibleItem;
    private int mLastOffset;
    private int mLeftThumbIndex;
    private int mRangeEnd;
    private int mRangeStart;
    private RangeBar mRangerBar;
    private RecyclerView mRecyclerView;
    private MediaMetadataRetriever mRetriever;
    private int mRightThumbIndex;
    private OnSeekListener mSeekListener;
    private VideoInfo mVideoInfo;
    private RecyclerView.OnScrollListener onScrollListener;

    /* JADX INFO: compiled from: SearchBox */
    public class AlbumBean {
        public Bitmap thumb;

        private AlbumBean() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnSeekListener {
        void onSeek(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class RangeAdapter extends RecyclerView.Adapter<Holder> {
        private Context mCtx;
        private List<AlbumBean> mData;

        /* JADX INFO: compiled from: SearchBox */
        public class Holder extends RecyclerView.ViewHolder {
            public TextView duration;
            public ImageView image;

            public Holder(View view) {
                super(view);
                this.image = (ImageView) view.findViewById(R.id.album_solo_image);
                this.duration = (TextView) view.findViewById(R.id.album_solo_title);
            }
        }

        public RangeAdapter(Context context, List<AlbumBean> list) {
            this.mCtx = context;
            this.mData = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(Holder holder, int i) {
            ViewGroup.LayoutParams layoutParams = holder.image.getLayoutParams();
            layoutParams.width = MCropView.this.mRangerBar.getMeasuredWidth() / MCropView.this.MIN_THUMB_COUNT;
            holder.image.setLayoutParams(layoutParams);
            if (i < this.mData.size()) {
                holder.image.setImageBitmap(this.mData.get(i).thumb);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new Holder(LayoutInflater.from(this.mCtx).inflate(R.layout.item_album_solo, viewGroup, false));
        }
    }

    public MCropView(Context context) {
        this(context, null);
    }

    private void initView() {
        this.mRangerBar = new RangeBar(this.mContext);
        RecyclerView recyclerView = new RecyclerView(this.mContext);
        this.mRecyclerView = recyclerView;
        recyclerView.setBackgroundColor(-16777216);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        this.linearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.setLayoutManager(this.linearLayoutManager);
        this.mRecyclerView.addOnScrollListener(this.onScrollListener);
        this.mRecyclerView.setClipToPadding(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        this.mRecyclerView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        int i = this.CROP_VIEW_MARGIN;
        layoutParams2.setMargins(i, 0, i, 0);
        this.mRangerBar.setLayoutParams(layoutParams2);
        RangeAdapter rangeAdapter = new RangeAdapter(this.mContext, this.mDataList);
        this.mAdapter = rangeAdapter;
        this.mRecyclerView.setAdapter(rangeAdapter);
        RecyclerView recyclerView2 = this.mRecyclerView;
        int i2 = this.CROP_VIEW_MARGIN;
        recyclerView2.setPadding(i2, 0, i2, 0);
        Log.e(TAG, "mRangebar.getX() = " + this.mRangerBar.getX() + "mRangerBar.getLeftThumbX() = " + this.mRangerBar.getLeftThumbStartX() + "mRecyclerView.getRight() " + this.mRecyclerView.getRight() + "mRangerBar.getRightThumbX()" + this.mRangerBar.getRightThumbEndX());
        addView(this.mRecyclerView);
        addView(this.mRangerBar);
        View view = new View(this.mContext);
        view.setAlpha(0.39215687f);
        view.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.CROP_VIEW_MARGIN, -1);
        layoutParams3.addRule(9);
        view.setLayoutParams(layoutParams3);
        View view2 = new View(this.mContext);
        view2.setAlpha(0.39215687f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.CROP_VIEW_MARGIN, -1);
        layoutParams4.addRule(11);
        view2.setBackgroundColor(-16777216);
        view2.setLayoutParams(layoutParams4);
        addView(view);
        addView(view2);
        this.mRangerBar.setOnRangeBarChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeek() {
        int i;
        this.mFirstVisibleItem = this.linearLayoutManager.findFirstVisibleItemPosition();
        View childAt = this.linearLayoutManager.getChildAt(0);
        if (childAt == null) {
            return;
        }
        Log.e(TAG, "onScrollStateChanged child 0 getX() = " + childAt.getX() + " v.getLeft() " + childAt.getLeft());
        StringBuilder sb = new StringBuilder();
        sb.append("onScrollStateChanged mFirstVisibleItem = ");
        sb.append(this.mFirstVisibleItem);
        Log.e(TAG, sb.toString());
        int iIntValue = Integer.valueOf(this.mVideoInfo.getDuration()).intValue();
        int iIntValue2 = this.MIN_THUMB_COUNT;
        if (iIntValue <= iIntValue2) {
            iIntValue2 = Integer.valueOf(this.mVideoInfo.getDuration()).intValue();
        }
        int i2 = this.MIN_THUMB_COUNT;
        float f = iIntValue2;
        float f2 = ((((this.mRightThumbIndex - this.mLeftThumbIndex) + 1) * i2) / ((i2 * 3.0f) / 10.0f)) * f;
        float f3 = iIntValue2 < i2 ? f / i2 : 1.0f;
        int paddingLeft = (int) (((this.mRecyclerView.getPaddingLeft() - this.CROP_VIEW_MARGIN) / childAt.getMeasuredWidth()) * f3 * 1000.0f);
        this.mLastOffset = paddingLeft - (((int) (this.mFirstVisibleItem * f3)) * 1000);
        Log.e(TAG, "mRangeStart = " + this.mRangeStart + "offsetCount = " + paddingLeft + " duration = " + f2);
        int i3 = this.mRangeStart;
        int i4 = this.mLastOffset;
        int i5 = i3 - i4;
        int i6 = (i3 - i4) + ((int) f2);
        int iIntValue3 = i5 >= 0 ? i5 : 0;
        if (Integer.valueOf(this.mVideoInfo.getDuration()).intValue() <= this.MIN_THUMB_COUNT && iIntValue3 > (i = iIntValue2 * 1000)) {
            iIntValue3 = i;
        } else if (Integer.valueOf(this.mVideoInfo.getDuration()).intValue() > this.MIN_THUMB_COUNT && iIntValue3 > Integer.valueOf(this.mVideoInfo.getDuration()).intValue() * 1000) {
            iIntValue3 = Integer.valueOf(this.mVideoInfo.getDuration()).intValue() * 1000;
        }
        OnSeekListener onSeekListener = this.mSeekListener;
        if (onSeekListener != null) {
            onSeekListener.onSeek(iIntValue3, i6);
        }
    }

    @Override // com.zenmen.media.crop.RangeBar.OnRangeBarChangeListener
    public void onIndexChangeListener(RangeBar rangeBar, int i, int i2) {
        this.mRecyclerView.setPadding((int) (this.mRangerBar.getX() + this.mRangerBar.getLeftThumbStartX()), 0, (this.mRecyclerView.getMeasuredWidth() - ((int) this.mRangerBar.getRightThumbEndX())) - ((RelativeLayout.LayoutParams) this.mRangerBar.getLayoutParams()).rightMargin, 0);
    }

    @Override // com.zenmen.media.crop.RangeBar.OnRangeBarChangeListener
    public void onIndexFixedListener(RangeBar rangeBar, int i, int i2) {
        Log.e(TAG, "leftThumbIndex:" + i + "___rightThumbIndex:" + i2);
        Log.e(TAG, "mLeftThumbIndex = " + this.mLeftThumbIndex + " mRightThumbIndex + " + this.mRightThumbIndex);
        int iIntValue = Integer.valueOf(this.mVideoInfo.getDuration()).intValue();
        int iIntValue2 = this.MIN_THUMB_COUNT;
        if (iIntValue <= iIntValue2) {
            iIntValue2 = Integer.valueOf(this.mVideoInfo.getDuration()).intValue();
        }
        int i3 = this.MIN_THUMB_COUNT;
        float f = (i3 * 3.0f) / 10.0f;
        float f2 = iIntValue2;
        float f3 = ((((i2 - i) + 1) * i3) / f) * f2;
        int i4 = this.mRangeStart + ((int) ((((i - this.mLeftThumbIndex) * i3) / f) * f2));
        this.mRangeStart = i4;
        int i5 = (int) f3;
        this.mRangeEnd = i4 + i5;
        Log.e(TAG, "mRangeStart = " + this.mRangeStart + " mRangeEnd " + this.mRangeEnd + " duration = " + f3 + " mFirstVisibleItem = " + this.mFirstVisibleItem);
        this.mLeftThumbIndex = i;
        this.mRightThumbIndex = i2;
        OnSeekListener onSeekListener = this.mSeekListener;
        if (onSeekListener != null) {
            int i6 = this.mRangeStart;
            int i7 = this.mLastOffset;
            onSeekListener.onSeek(i6 - i7, (i6 - i7) + i5);
        }
    }

    public void setOnSeekListener(OnSeekListener onSeekListener) {
        this.mSeekListener = onSeekListener;
    }

    public void setVideoInfo(VideoInfo videoInfo, long j) {
        if (videoInfo == null) {
            return;
        }
        this.mVideoInfo = videoInfo;
        this.MIN_THUMB_COUNT = (int) Math.max(1L, Math.min(j / 1000, Integer.parseInt(videoInfo.getDuration())));
        this.mRangerBar.setFullDuration(Integer.parseInt(this.mVideoInfo.getDuration()));
        this.mRangerBar.post(new Runnable() { // from class: com.zenmen.media.crop.MCropView.1
            @Override // java.lang.Runnable
            public void run() {
                MCropView.this.mLastOffset = 0;
                MCropView.this.mLeftThumbIndex = 0;
                MCropView.this.mRangerBar.setThumbIndices(0, MCropView.this.mRangerBar.getmTickCount() - 1);
                MCropView.this.mRecyclerView.scrollTo(0, 0);
            }
        });
        n54.a(new n54.a<AlbumBean>() { // from class: com.zenmen.media.crop.MCropView.3
            @Override // defpackage.c5
            public void call(sm5<? super AlbumBean> sm5Var) {
                MCropView.this.mRetriever.setDataSource(MCropView.this.mVideoInfo.getVideoPath());
                int iIntValue = Integer.valueOf(MCropView.this.mVideoInfo.getDuration()).intValue();
                Log.e(MCropView.TAG, "count = " + iIntValue);
                int i = 0;
                if (iIntValue >= MCropView.this.MIN_THUMB_COUNT) {
                    while (i < iIntValue) {
                        AlbumBean albumBean = new AlbumBean();
                        Bitmap frameAtTime = MCropView.this.mRetriever.getFrameAtTime(i * 1000 * 1000);
                        if (x86.e(MCropView.this.mContext)) {
                            albumBean.thumb = Bitmap.createScaledBitmap(frameAtTime, 45, 90, true);
                        } else {
                            albumBean.thumb = Bitmap.createScaledBitmap(frameAtTime, 63, 112, true);
                        }
                        frameAtTime.recycle();
                        Log.e(MCropView.TAG, "thumb.width = " + albumBean.thumb.getWidth() + "thumb.height = " + albumBean.thumb.getHeight());
                        sm5Var.onNext(albumBean);
                        i++;
                    }
                } else {
                    while (i < MCropView.this.MIN_THUMB_COUNT) {
                        AlbumBean albumBean2 = new AlbumBean();
                        if (x86.e(MCropView.this.mContext)) {
                            Bitmap frameAtTime2 = MCropView.this.mRetriever.getFrameAtTime(i * 1000 * 1000);
                            albumBean2.thumb = Bitmap.createScaledBitmap(frameAtTime2, 45, 90, true);
                            frameAtTime2.recycle();
                        } else {
                            albumBean2.thumb = MCropView.this.mRetriever.getFrameAtTime(i * 100 * 1000);
                        }
                        sm5Var.onNext(albumBean2);
                        i++;
                    }
                }
                sm5Var.onCompleted();
            }
        }).u(b35.c()).i(wc.a()).s(new sm5<AlbumBean>() { // from class: com.zenmen.media.crop.MCropView.2
            @Override // defpackage.o54
            public void onCompleted() {
                MCropView.this.mAdapter.notifyDataSetChanged();
            }

            @Override // defpackage.sm5
            public void onStart() {
                MCropView.this.mDataList.clear();
                MCropView.this.mAdapter.notifyDataSetChanged();
            }

            @Override // defpackage.o54
            public void onNext(AlbumBean albumBean) {
                MCropView.this.mDataList.add(albumBean);
                MCropView.this.mAdapter.notifyDataSetChanged();
            }

            @Override // defpackage.o54
            public void onError(Throwable th) {
            }
        });
    }

    public void updateMaxDuration(long j) {
        if (this.mVideoInfo == null || ((int) Math.min(j / 1000, Integer.parseInt(r0.getDuration()))) == this.MIN_THUMB_COUNT) {
            return;
        }
        setVideoInfo(this.mVideoInfo, j);
    }

    public MCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDataList = new ArrayList();
        this.mRangeStart = 0;
        this.mRangeEnd = wv.a() * 1000;
        this.mLastOffset = 0;
        this.mFirstVisibleItem = 0;
        this.mLeftThumbIndex = 0;
        this.mRightThumbIndex = 300;
        this.CROP_VIEW_MARGIN = 100;
        this.CROP_VIEW_MARGIN_Percent = 5;
        this.NormalThumbHeight = 112;
        this.NormalThumbWidth = 63;
        this.CompactThumbHeight = 90;
        this.CompactThumbWidth = 45;
        this.MIN_THUMB_COUNT = wv.a();
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.zenmen.media.crop.MCropView.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                Log.i("onScrollStateChanged", "onScrollStateChanged :" + i2);
                if (i2 == 0) {
                    MCropView.this.updateSeek();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }
        };
        this.mContext = context;
        try {
            int i2 = getResources().getDisplayMetrics().heightPixels;
            float f = getResources().getDisplayMetrics().density;
            int i3 = getResources().getDisplayMetrics().widthPixels;
            if (i3 != 0) {
                this.CROP_VIEW_MARGIN = (i3 * this.CROP_VIEW_MARGIN_Percent) / 100;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();
        this.mRetriever = new MediaMetadataRetriever();
    }
}
