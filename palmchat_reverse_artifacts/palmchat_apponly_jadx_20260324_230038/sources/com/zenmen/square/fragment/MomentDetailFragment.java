package com.zenmen.square.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.bean.MomentsDetailEvent;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.photoview.PhotoView;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.adapter.SquareFriendPageAdapter;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.databinding.LayoutMomentsDetailFullBinding;
import com.zenmen.square.lxpager.BasePagerBean;
import com.zenmen.square.lxpager.PagerFragment;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import com.zenmen.square.mvvm.MediaFriendViewModel;
import com.zenmen.square.ui.anim.VideoLikeBigStar;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.PageIndicatorView;
import com.zenmen.square.ui.widget.SquareDetailVideoView;
import com.zenmen.square.ui.widget.SquareHackyViewPager;
import com.zenmen.square.ui.widget.SquarePhotoView;
import defpackage.a46;
import defpackage.ai5;
import defpackage.an1;
import defpackage.az2;
import defpackage.bj5;
import defpackage.cy5;
import defpackage.dn0;
import defpackage.fg6;
import defpackage.fk2;
import defpackage.gr2;
import defpackage.hg1;
import defpackage.is0;
import defpackage.j23;
import defpackage.k86;
import defpackage.l50;
import defpackage.me1;
import defpackage.n5;
import defpackage.nq3;
import defpackage.py5;
import defpackage.qj5;
import defpackage.ry5;
import defpackage.si0;
import defpackage.sy5;
import defpackage.ti0;
import defpackage.v4;
import defpackage.wg3;
import defpackage.xt1;
import defpackage.yy2;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MomentDetailFragment extends PagerFragment implements xt1.a {
    public xt1 A;
    public ContactInfoItem B;
    public py5 C;
    public View E;
    public boolean F;
    public long I;
    public boolean J;
    public PageIndicatorView K;
    public SquareHackyViewPager e;
    public SquareFriendPageAdapter f;
    public String g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public Rect n;
    public DoubleClickView o;
    public View p;
    public View q;
    public View s;
    public MediaFriendViewModel t;
    public LayoutMomentsDetailFullBinding u;
    public wg3 v;
    public SquareFeed w;
    public Long x;
    public String y;
    public Feed z;
    public ArrayList<FeedBean> l = new ArrayList<>();
    public boolean m = false;
    public boolean r = false;
    public boolean G = true;
    public FeedNetDao.FeedNetListener H = new a();
    public GestureDetector.OnDoubleTapListener L = new e();
    public boolean M = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedNetDao.FeedNetListener {
        public a() {
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            MomentDetailFragment.this.F = false;
            MomentDetailFragment.this.Q0();
            Log.d("MomentDetailFragment", "FeedNetListener onFail,  error is " + exc);
            MomentDetailFragment.this.j1("");
            if (MomentDetailFragment.this.z == null) {
                MomentDetailFragment.this.G0();
            }
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            NetResponseData netResponseData;
            MomentDetailFragment.this.F = false;
            MomentDetailFragment.this.Q0();
            if (netResponse == null) {
                MomentDetailFragment.this.j1("");
                if (MomentDetailFragment.this.z == null) {
                    MomentDetailFragment.this.G0();
                }
                Log.d("MomentDetailFragment", "NetResponse is null");
                return;
            }
            int i = netResponse.resultCode;
            if (i == 0 && (netResponseData = netResponse.data) != null) {
                Feed feed = new Feed(Long.valueOf(netResponseData.feedId), Long.valueOf(netResponseData.clientId), netResponseData.uid, Long.valueOf(netResponseData.createDt), netResponseData.content, netResponseData.feedType, netResponseData.privateStatus, netResponseData.status, netResponseData.cover, Long.valueOf(netResponseData.version), Integer.valueOf(netResponseData.feedSource), netResponseData.location, netResponseData.mediaList);
                feed.setSource(netResponseData.source);
                feed.setCommentList(netResponseData.comments);
                feed.setLikesList(netResponseData.likes);
                feed.setShowComments(netResponseData.showComments);
                feed.commentNum = netResponseData.commentNum;
                MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
                momentsDetailEvent.eventType = 2;
                momentsDetailEvent.feed = feed;
                an1.c().l(momentsDetailEvent);
                MomentDetailFragment.this.z = feed;
                MomentDetailFragment.this.z.isFirstRefresh = false;
                MomentDetailFragment.this.d.q(MomentDetailFragment.this.z);
                MomentDetailFragment.this.p1();
                return;
            }
            if (i != 1901) {
                MomentDetailFragment.this.j1(netResponse.errorMsg);
                if (MomentDetailFragment.this.z == null) {
                    qj5.t(MomentDetailFragment.this.h, new SquareFeed(), 0, null, null);
                    return;
                }
                return;
            }
            MomentsDetailEvent momentsDetailEvent2 = new MomentsDetailEvent();
            momentsDetailEvent2.eventType = 3;
            momentsDetailEvent2.feedId = MomentDetailFragment.this.x;
            an1.c().l(momentsDetailEvent2);
            String str = netResponse.errorMsg;
            if (TextUtils.isEmpty(str)) {
                str = "动态已删除";
            }
            MomentDetailFragment.this.l1();
            long jCurrentTimeMillis = 500 - (System.currentTimeMillis() - MomentDetailFragment.this.I);
            if (MomentDetailFragment.this.z.isTargetPosition && MomentDetailFragment.this.z.isFirstRefresh) {
                MomentDetailFragment.this.B0(jCurrentTimeMillis, str);
            } else {
                MomentDetailFragment.this.d.m(MomentDetailFragment.this.z);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16301a;
        public final /* synthetic */ Activity b;

        public b(String str, Activity activity) {
            this.f16301a = str;
            this.b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            MomentDetailFragment.this.Q0();
            MomentDetailFragment.this.j1(this.f16301a);
            Activity activity = this.b;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Observer<ContactInfoItem> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable ContactInfoItem contactInfoItem) {
            if (MomentDetailFragment.this.K0() == null) {
                return;
            }
            if (MomentDetailFragment.this.B == null) {
                MomentDetailFragment.this.B = contactInfoItem;
            }
            boolean z = false;
            if (contactInfoItem != null && TextUtils.equals(contactInfoItem.getUid(), v4.e(MomentDetailFragment.this.getContext()))) {
                MomentDetailFragment.this.u.f16222a.setVisibility(4);
                MomentDetailFragment.this.u.b.setVisibility(0);
                return;
            }
            MomentDetailFragment.this.u.f16222a.setVisibility(0);
            if (contactInfoItem != null && !contactInfoItem.getIsStranger()) {
                z = true;
            }
            MomentDetailFragment.this.u.f16222a.setText(z ? MomentDetailFragment.this.getString(R$string.square_btn_go_normal_chat) : ai5.k().g().getSquareChatText(MomentDetailFragment.this.getContext()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements GestureDetector.OnDoubleTapListener {
        public e() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (MomentDetailFragment.this.K0() == null) {
                return false;
            }
            new VideoLikeBigStar(MomentDetailFragment.this.getContext()).animBigStart((ViewGroup) MomentDetailFragment.this.s, motionEvent);
            MomentDetailFragment.this.E0();
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (MomentDetailFragment.this.K0() == null) {
                return false;
            }
            MomentDetailFragment.this.m1();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements is0.f {
        public f() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0 && MomentDetailFragment.this.K0() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(az.at, 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onImmediateClickEvent("M41", null, jSONObject.toString());
                MomentDetailFragment.this.v.e(MomentDetailFragment.this.z);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements nq3.b {
        public g() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                sy5.e(MomentDetailFragment.this.getContext(), R$string.square_comment_send_success, 1).g();
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.f(MomentDetailFragment.this.getContext(), unitedException.getErrorMsg(), 1).g();
                    return;
                }
                if (unitedException.getCode() != 1901 && unitedException.getCode() != 1911) {
                    sy5.e(MomentDetailFragment.this.getContext(), R$string.square_http_error, 1).g();
                    return;
                }
                if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.f(MomentDetailFragment.this.getContext(), unitedException.getErrorMsg(), 1).g();
                } else if (unitedException.getCode() == 1911) {
                    sy5.e(MomentDetailFragment.this.getContext(), com.zenmen.palmchat.friendcircle.R$string.feed_comment_delete_error, 1).g();
                } else {
                    sy5.e(MomentDetailFragment.this.getContext(), com.zenmen.palmchat.friendcircle.R$string.feed_content_delete_error, 1).g();
                }
            }
        }
    }

    @BindingAdapter({"momentAvatarUrl"})
    public static void c1(EffectiveShapeView effectiveShapeView, String str) {
        effectiveShapeView.setBorderColor(Color.parseColor("#ffffff"));
        gr2.j().h(k86.p(str), effectiveShapeView, a46.l());
    }

    @BindingAdapter({"setMomentBottomString"})
    public static void e1(TextView textView, String str) {
        textView.setText(si0.b(textView.getContext()));
    }

    @BindingAdapter({"setNickName"})
    public static void f1(TextView textView, MediaFriendViewModel mediaFriendViewModel) {
        if (mediaFriendViewModel != null) {
            if (mediaFriendViewModel.c().canDelete()) {
                textView.setVisibility(4);
                return;
            }
            textView.setVisibility(0);
            ContactInfoItem contactInfoItemA = mediaFriendViewModel.a();
            if (contactInfoItemA != null) {
                textView.setText(contactInfoItemA.getNameForShow());
                if (contactInfoItemA.isOfficialAccount()) {
                    textView.setTextColor(textView.getContext().getResources().getColor(R$color.Gg));
                    return;
                }
                int iG = fg6.g(contactInfoItemA.getExt());
                if (fg6.q(iG)) {
                    textView.setTextColor(fg6.n(textView.getContext(), iG));
                } else {
                    textView.setTextColor(textView.getContext().getResources().getColor(R$color.white));
                }
            }
        }
    }

    @BindingAdapter({"setMomentPublishTime"})
    public static void g1(TextView textView, long j) {
        textView.setText(cy5.h(j));
    }

    @BindingAdapter({"setVipIcon"})
    public static void h1(ImageView imageView, MediaFriendViewModel mediaFriendViewModel) {
        if (mediaFriendViewModel == null) {
            imageView.setVisibility(8);
            return;
        }
        if (mediaFriendViewModel.c().canDelete()) {
            imageView.setVisibility(8);
            return;
        }
        ContactInfoItem contactInfoItemA = mediaFriendViewModel.a();
        if (contactInfoItemA == null) {
            imageView.setVisibility(8);
            return;
        }
        int iG = fg6.g(contactInfoItemA.getExt());
        if (!fg6.q(iG)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(fg6.e(iG));
            imageView.setVisibility(0);
        }
    }

    public final void A0(Feed feed) {
        this.l.clear();
        this.l = new ArrayList<>();
        for (Media media : feed.getMediaList()) {
            FeedBean feedBean = new FeedBean();
            MediaItem mediaItem = new MediaItem();
            if (feed.getFeedType() == 3) {
                mediaItem.mimeType = 1;
            }
            if (media.localPath != null) {
                if (new File(media.localPath).exists()) {
                    mediaItem.fileFullPath = media.localPath;
                }
            } else if (feed.getFeedType() == 3) {
                mediaItem.fileFullPath = media.videoUrl;
            } else {
                mediaItem.fileFullPath = media.url;
            }
            mediaItem.thumbnailPath = media.midUrl;
            feedBean.putFeed(feed);
            feedBean.setFeedId(feed.getId());
            feedBean.setMediaItem(mediaItem);
            feedBean.setWidth(media.width);
            feedBean.setHeight(media.height);
            this.l.add(feedBean);
        }
    }

    public final void B0(long j, String str) {
        if (this.s != null) {
            this.s.postDelayed(new b(str, I0()), j);
        } else {
            Q0();
            j1(str);
            G0();
        }
    }

    public void C0(Long l) {
        if (isRemoving()) {
            return;
        }
        MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
        momentsDetailEvent.eventType = 3;
        momentsDetailEvent.feedId = l;
        an1.c().l(momentsDetailEvent);
        this.d.m(this.z);
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public View D() {
        return this.q;
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public boolean E() {
        PhotoView photoViewM0;
        FeedBean feedBeanK0 = K0();
        if (feedBeanK0 == null || feedBeanK0.getMediaItem().mimeType != 0 || (photoViewM0 = M0()) == null) {
            return false;
        }
        return photoViewM0.isScaled();
    }

    public final void E0() {
        if (K0() == null || K0().isIfLike()) {
            return;
        }
        n1();
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void F() {
        super.F();
        Feed feed = this.z;
        if (feed == null || feed.isEmptyFeed() || this.z.getFeedType() != 3) {
            return;
        }
        SquareFriendPageAdapter squareFriendPageAdapter = new SquareFriendPageAdapter(getContext(), this.z, isResumed());
        this.f = squareFriendPageAdapter;
        squareFriendPageAdapter.i(0);
        this.e.setAdapter(this.f);
        this.e.setCurrentItem(0, true);
        this.f.notifyDataSetChanged();
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void G(BasePagerBean basePagerBean, int i) {
        if (basePagerBean instanceof Feed) {
            this.z = (Feed) basePagerBean;
        }
    }

    public final void G0() {
        FrameworkBaseActivity frameworkBaseActivityI0 = I0();
        if (frameworkBaseActivityI0 != null) {
            frameworkBaseActivityI0.finish();
        }
    }

    public FrameworkBaseActivity I0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof FrameworkBaseActivity) {
            return (FrameworkBaseActivity) activity;
        }
        return null;
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void J() {
        if (this.z == null || this.e == null || E() || this.e.getCurrentItem() != this.z.getMediaList().size() - 1) {
            return;
        }
        onAvatarClick(null);
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void K() {
        FrameworkBaseActivity frameworkBaseActivityI0;
        if (this.z == null || this.e == null || E() || this.e.getCurrentItem() != 0 || (frameworkBaseActivityI0 = I0()) == null) {
            return;
        }
        frameworkBaseActivityI0.onBackPressed();
    }

    public final FeedBean K0() {
        if (this.j < this.l.size()) {
            return this.l.get(this.j);
        }
        return null;
    }

    @Override // com.zenmen.square.lxpager.PagerFragment
    public void L(hg1 hg1Var) {
        View view = this.s;
        if (view == null || hg1Var == null) {
            return;
        }
        hg1Var.t(view, view.findViewById(R$id.layout_mediaview));
    }

    public final void L0() {
        Bundle arguments = getArguments();
        this.g = arguments.getString("KEY_FROM");
        this.h = arguments.getInt("from_type", 0);
        this.J = arguments.getBoolean("key_show_comment", false);
        this.i = arguments.getInt("selectIndex", 0);
        this.k = arguments.getBoolean("long_click", true);
        this.j = this.i;
        this.B = (ContactInfoItem) arguments.getParcelable("user_detail_contact_info");
        this.m = arguments.getBoolean("extra_key_show_delete", false);
        this.n = (Rect) arguments.getParcelable("extra_key_transition_rect");
        Feed feed = this.z;
        if (feed != null) {
            this.x = feed.getFeedId();
            this.y = this.z.getUid();
        }
        if (this.B == null) {
            this.B = dn0.a(this.y);
        }
    }

    public final PhotoView M0() {
        SquareFriendPageAdapter squareFriendPageAdapter = this.f;
        if (squareFriendPageAdapter == null) {
            return null;
        }
        View viewF = squareFriendPageAdapter.f(this.j);
        if (viewF instanceof SquarePhotoView) {
            return ((SquarePhotoView) viewF).getPhotoView();
        }
        return null;
    }

    public final SquareDetailVideoView N0() {
        SquareFriendPageAdapter squareFriendPageAdapter = this.f;
        if (squareFriendPageAdapter == null) {
            return null;
        }
        View viewF = squareFriendPageAdapter.f(this.j);
        if (viewF instanceof SquareDetailVideoView) {
            return (SquareDetailVideoView) viewF;
        }
        return null;
    }

    public final void O0() {
        if (this.u == null) {
            return;
        }
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString(DeviceInfoUtil.UID_TAG, this.z.getUid());
        bundle.putInt("from", 40);
        aVar.b(bundle);
        startActivity(n5.a(getContext(), aVar));
    }

    public final void Q0() {
        this.E.setVisibility(8);
    }

    public final void R0() {
        wg3 wg3Var = new wg3(getContext());
        this.v = wg3Var;
        wg3Var.d(this);
        this.t = (MediaFriendViewModel) ViewModelProviders.of(this).get(MediaFriendViewModel.class);
        Feed feed = this.z;
        if (feed == null || feed.isEmptyFeed()) {
            l1();
            this.I = System.currentTimeMillis();
            W0();
        }
    }

    public final void S0() {
        if (M0() == null) {
            this.o.setOnDoubleTabListener(this.L);
            this.o.setVisibility(0);
            return;
        }
        for (View view : this.f.g()) {
            if (view instanceof SquarePhotoView) {
                SquarePhotoView squarePhotoView = (SquarePhotoView) view;
                if (squarePhotoView.getPhotoView() != null) {
                    squarePhotoView.getPhotoView().setOnDoubleTapListener(this.L);
                }
            }
        }
        this.o.setVisibility(8);
    }

    public final void T0(int i) {
        this.K = (PageIndicatorView) this.s.findViewById(R$id.page_indicator);
        PageIndicatorView.c cVar = new PageIndicatorView.c();
        cVar.i(i).j(a46.b(getContext(), 4.0f));
        this.K.initConfig(cVar, this.e);
    }

    public final void V0() {
        if (this.B == null) {
            sy5.e(getContext(), R$string.get_user_info_failed, 0).g();
            return;
        }
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(this.h));
        String strC = az2.c(SquareFeedForChatCard.parse(this.w));
        if (this.B.getIsStranger()) {
            map.put("relationtype", 0);
            qj5.h0(this.w, map);
            bj5.b().a().r(I0(), this.B, strC);
        } else {
            map.put("relationtype", 1);
            qj5.h0(this.w, map);
            bj5.b().a().B(I0(), this.B, strC);
        }
    }

    public final void W0() {
        if (this.F) {
            return;
        }
        this.F = true;
        this.v.f(this.x.longValue(), this.y, this.H);
    }

    public boolean X0(SquareFeed squareFeed, Feed feed) {
        if (feed == null || squareFeed.id != feed.getId()) {
            return false;
        }
        FeedBean feedBeanK0 = K0();
        if (feedBeanK0 == null) {
            return true;
        }
        feed.commentNum = squareFeed.discussionNum;
        feedBeanK0.putFeed(feed);
        return true;
    }

    @Override // xt1.a
    public void Y0(SquareFeedEvent squareFeedEvent) {
        Feed feed = this.z;
        if (feed != null && squareFeedEvent.eventType == 2 && X0(squareFeedEvent.feed, feed)) {
            this.u.invalidateAll();
            this.u.executePendingBindings();
        }
    }

    public final void Z0() {
        this.t.b().observe(this, new c());
    }

    public void a1(FeedBean feedBean) {
        if (feedBean.isIfLike()) {
            feedBean.likeNums--;
        } else {
            feedBean.likeNums++;
        }
        feedBean.setIfLike(!feedBean.isIfLike());
        this.t.f(feedBean);
        this.u.invalidateAll();
        this.u.executePendingBindings();
        MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
        momentsDetailEvent.eventType = 2;
        momentsDetailEvent.feed = this.z;
        an1.c().l(momentsDetailEvent);
    }

    public final void b1(int i) {
        this.j = i;
        this.f.i(i);
    }

    public void i1(View view) {
        if (this.z == null) {
            return;
        }
        if (view != this.u.c) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 3);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M24", "1", null, jSONObject.toString());
            if (this.t.c().discussionNum == 0) {
                k1();
                return;
            } else {
                ti0.c().d(getContext(), this.w, 4, 0);
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(az.at, 3);
            jSONObject2.put("type", 1);
        } catch (Exception unused2) {
        }
        ArrayList<FeedBean> arrayList = this.l;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        LogUtil.uploadInfoImmediate("M242", "1", null, jSONObject2.toString());
        k1();
    }

    public final void j1(String str) {
        if (TextUtils.isEmpty(str)) {
            ry5.a("网络异常，请稍后再试");
        } else {
            ry5.a(str);
        }
    }

    public final void k1() {
        ti0.c().f(I0(), this.w, null, 4, 0, new g());
    }

    public final void l1() {
        this.E.setVisibility(0);
    }

    public final void m1() {
        if (this.q.getVisibility() != 0) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(4);
        }
    }

    public final void n1() {
        if (K0() == null) {
            return;
        }
        if (K0().isIfLike()) {
            this.v.g(K0(), Long.valueOf(j23.a(this.z)), this.z);
        } else {
            this.v.c(K0(), this.z);
        }
    }

    public void onArrowPress(View view) {
        G0();
    }

    public void onAvatarClick(View view) {
        if ("from_publish_comment".equals(this.g)) {
            G0();
        } else {
            O0();
        }
    }

    public void onChatBtnClick(View view) {
        if (this.z == null) {
            return;
        }
        V0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.C = py5.b();
        L0();
        if (this.B == null) {
            j1("非好友暂无法操作");
            G0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.layout_moments_detail_full, viewGroup, false);
        this.s = viewInflate;
        this.E = viewInflate.findViewById(R$id.mask);
        this.p = this.s.findViewById(R$id.feed_detail_title_bar);
        this.q = this.s.findViewById(R$id.infoLayout);
        this.o = (DoubleClickView) this.s.findViewById(R$id.v_feed_detail_cover);
        R0();
        p1();
        this.A = new xt1(this);
        an1.c().p(this.A);
        this.p.setPadding(0, a46.n(getContext()), 0, 0);
        return this.s;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.A != null) {
            an1.c().r(this.A);
        }
        super.onDestroy();
    }

    public void onMoreBtnClick(View view) {
        if (this.z == null || l50.a() || this.u == null) {
            return;
        }
        I0().showPopupMenu(I0(), this.p, new String[]{getResources().getString(R$string.delete)}, new int[]{R$drawable.ic_square_media_view_delete}, new f(), null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Feed feed = this.z;
        if (feed == null || feed.getFeedType() != 3 || N0() == null) {
            return;
        }
        N0().pausePlayer();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Feed feed = this.z;
        if (feed != null && (feed.isTargetPosition || feed.isEmptyFeed())) {
            W0();
        }
        Feed feed2 = this.z;
        if (feed2 == null || feed2.getFeedType() != 3 || N0() == null) {
            return;
        }
        N0().startPlay();
    }

    public void p1() {
        Feed feed = this.z;
        if (feed == null || feed.isEmptyFeed()) {
            return;
        }
        this.w = SquareFeed.convertToSquareFeed(this.z, this.B);
        A0(this.z);
        x0();
        this.u.invalidateAll();
        this.u.executePendingBindings();
    }

    public final void r1() {
        if (this.f == null && getContext() != null) {
            SquareFriendPageAdapter squareFriendPageAdapter = new SquareFriendPageAdapter(getContext(), this.z, isResumed());
            this.f = squareFriendPageAdapter;
            squareFriendPageAdapter.i(this.i);
            this.e = (SquareHackyViewPager) this.s.findViewById(R$id.viewpager);
            T0(this.z.getMediaList().size());
            this.e.setAdapter(this.f);
            this.e.setCurrentItem(this.i, true);
            this.e.setPageMargin(me1.b(getContext(), 17));
            this.e.addOnPageChangeListener(new d());
            if (this.l.size() > 1) {
                this.u.g.setText((this.j + 1) + "/" + this.l.size());
            }
            this.u.y.setTextSize(16);
            this.u.y.setText(this.t.c().content.trim(), this.z.getId());
            if (this.J) {
                this.J = false;
                ti0.c().b(getContext(), this.z, 4, 0);
            }
        }
    }

    public final void x0() {
        this.u = (LayoutMomentsDetailFullBinding) DataBindingUtil.bind(this.s);
        this.t.f(K0());
        this.u.c(this.t);
        this.u.setLifecycleOwner(this);
        this.u.b(this);
        Z0();
        this.t.d(this.B);
        r1();
        S0();
        if (this.G) {
            this.G = false;
            qj5.t(this.h, this.w, 1, null, null);
        }
    }

    public void y0(View view) {
        if (this.z == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(az.at, 3);
            Feed feed = this.z;
            jSONObject.put("type", (feed == null || !j23.b(feed)) ? 1 : 2);
        } catch (Exception unused) {
        }
        LogUtil.uploadInfoImmediate("M241", "1", null, jSONObject.toString());
        a46.C(view, R$anim.square_click_like_anim);
        n1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Log.d("MFull", "onPageScrolled position:" + i + ",positionOffset:" + f + ",positionOffsetPixels:" + i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            MomentDetailFragment.this.b1(i);
            if (MomentDetailFragment.this.l.size() > 1) {
                MomentDetailFragment.this.u.g.setText((i + 1) + "/" + MomentDetailFragment.this.l.size());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    }
}
