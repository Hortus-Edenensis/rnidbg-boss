package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.fileupload.dao.UploadResultVo;
import com.zenmen.palmchat.framework.square.bean.ShareSmsBean;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$string;
import com.zenmen.square.bean.SquareContactBean;
import com.zenmen.square.bean.SquareFriendBean;
import com.zenmen.square.bean.SquareShareFeedBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.tag.bean.CommonResponse;
import defpackage.bn2;
import defpackage.qp4;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class mj5 extends Observable {
    public static final String f = "mj5";
    public static mj5 g;
    public SquareShareFeedBean c;
    public int d;
    public int e;
    public uo2 b = bj5.b().c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f19238a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class a implements qp4.f {

        /* JADX INFO: renamed from: mj5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1247a implements Runnable {
            public RunnableC1247a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                mj5.this.w("发布失败，请稍后再试");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (mj5.this.c == null) {
                    return;
                }
                mj5 mj5Var = mj5.this;
                mj5Var.v(mj5Var.c.feedType == 3 ? 10 : (mj5.this.e * 90) / mj5.this.d);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f19242a;
            public final /* synthetic */ int b;

            public c(int i, int i2) {
                this.f19242a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                LogUtil.d(mj5.f, "uploadImage onProgress：" + this.f19242a + ", byteCount: " + this.b);
                if (mj5.this.c != null && this.f19242a < 100) {
                    mj5 mj5Var = mj5.this;
                    mj5Var.v(mj5Var.c.feedType == 3 ? this.f19242a / 10 : ((mj5.this.e * 90) / mj5.this.d) + ((this.f19242a * 9) / (mj5.this.d * 10)));
                }
            }
        }

        public a() {
        }

        @Override // qp4.f
        public void a(Exception exc) {
            LogUtil.d(mj5.f, "uploadImage fail!!");
            mj5.this.f19238a.post(new RunnableC1247a());
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            if (mj5.this.c == null) {
                return;
            }
            mj5 mj5Var = mj5.this;
            mj5Var.v(mj5Var.c.feedType == 3 ? 10 : 90);
            LogUtil.d(mj5.f, "uploadImage success!!");
            for (int i = 0; i < arrayList.size(); i++) {
                mj5.this.c.mediaList.get(i).thumbUrl = arrayList.get(i).thumbUrl;
                mj5.this.c.mediaList.get(i).midUrl = arrayList.get(i).midUrl;
                mj5.this.c.mediaList.get(i).url = arrayList.get(i).url;
            }
            if (mj5.this.c.feedType != 3) {
                mj5.this.C();
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            if (mj5.this.c.mediaList != null) {
                Iterator<Media> it = mj5.this.c.mediaList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().localPath);
                }
            }
            mj5.this.I(arrayList2);
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
            LogUtil.d(mj5.f, "onItemSuccess：");
            mj5.m(mj5.this);
            mj5.this.f19238a.post(new b());
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
            mj5.this.f19238a.post(new c(i, i2));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements bn2.d {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f19247a;

            public a(int i) {
                this.f19247a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                mj5.this.v(((this.f19247a * 5) / 10) + 10);
            }
        }

        public c() {
        }

        @Override // bn2.d
        public void a(int i) {
            mj5.this.f19238a.post(new a(i));
        }

        @Override // bn2.d
        public void b(boolean z, int i, String str) {
            if (!z || mj5.this.c == null || mj5.this.c.mediaList == null || mj5.this.c.mediaList.size() <= 0) {
                return;
            }
            mj5.this.c.mediaList.get(0).localPath = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends tw4<CommonResponse<SquareFeed>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f19249a;

            public a(String str) {
                this.f19249a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f19249a;
                if (TextUtils.isEmpty(str)) {
                    str = "发布失败，请稍后再试";
                }
                mj5.this.w(str);
            }
        }

        public d() {
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareFeed> commonResponse) {
            if (mj5.this.c == null) {
                return;
            }
            LogUtil.d(mj5.f, "shareFeed success!!");
            if (commonResponse.getData() == null) {
                mj5.this.w("发布失败，请稍后再试");
                return;
            }
            mj5.this.c.squareFeed = commonResponse.getData();
            mj5.this.c.squareFeed.initedTime = SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, k86.a("key_inited_time"), -1L);
            SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
            SquareFeed squareFeed = mj5.this.c.squareFeed;
            squareFeedEvent.feed = squareFeed;
            squareFeed.visibleType = mj5.this.c.visibleType;
            squareFeedEvent.eventType = 1;
            if (mj5.this.s(squareFeedEvent.feed)) {
                squareFeedEvent.feed.official = true;
            }
            ds0.a().b(squareFeedEvent);
            if (mj5.this.c != null && mj5.this.c.ae != null && mj5.this.c.ae.getAeId() > 0) {
                try {
                    sy5.e(com.zenmen.palmchat.c.b(), R$string.square_publish_ae_toast, 1).g();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            mj5.this.p();
            SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_square_share_success"), Boolean.TRUE);
            mj5.this.c = null;
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            LogUtil.d(mj5.f, "shareFeed error!!");
            mj5.this.f19238a.post(new a(str));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends tw4<CommonResponse<ShareSmsBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f19250a;
        public final /* synthetic */ List b;

        public e(List list, List list2) {
            this.f19250a = list;
            this.b = list2;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<ShareSmsBean> commonResponse) {
            if (mj5.this.c != null) {
                LogUtil.d(mj5.f, "pullSms success!!");
                mj5.this.c.shareSmsBean = commonResponse.getData();
                if (mj5.this.c.shareSmsBean != null) {
                    mj5.this.c.shareSmsBean.numbers = this.f19250a;
                }
                for (SquareContactBean squareContactBean : this.b) {
                    SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, k86.a("key_square_share_feed_" + squareContactBean.number), Integer.valueOf(squareContactBean.feedCount + 1));
                }
                mj5.this.x(4);
            }
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            mj5.this.x(5);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            mj5.this.c = null;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (mj5.this.c == null || mj5.this.c.publicStatus != 5) {
                return;
            }
            mj5 mj5Var = mj5.this;
            mj5Var.y(true, mj5Var.c.squareFeed, mj5.this.c.contactLists);
        }
    }

    public static /* synthetic */ int m(mj5 mj5Var) {
        int i = mj5Var.e;
        mj5Var.e = i + 1;
        return i;
    }

    public static mj5 r() {
        if (g == null) {
            synchronized (mj5.class) {
                if (g == null) {
                    g = new mj5();
                }
            }
        }
        return g;
    }

    public boolean A() {
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean == null) {
            return false;
        }
        squareShareFeedBean.resetUploadStatus();
        B(this.c);
        return true;
    }

    public void B(SquareShareFeedBean squareShareFeedBean) {
        try {
            this.c = squareShareFeedBean;
            if (squareShareFeedBean.isRecallImage) {
                C();
            } else {
                List<Media> list = squareShareFeedBean.mediaList;
                if (list != null && list.size() > 0) {
                    this.d = squareShareFeedBean.mediaList.size();
                    this.e = 0;
                    if (squareShareFeedBean.feedType == 2) {
                        D();
                    } else {
                        F();
                    }
                } else if (squareShareFeedBean.feedType == 1) {
                    E();
                } else {
                    w("发布失败，请稍后再试");
                }
            }
        } catch (Exception e2) {
            w("发布失败，请稍后再试");
            e2.printStackTrace();
        }
    }

    public final void C() {
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean != null) {
            this.b.e(squareShareFeedBean, new d());
        }
    }

    public final void D() {
        ArrayList<String> arrayList = new ArrayList<>();
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean != null) {
            List<Media> list = squareShareFeedBean.mediaList;
            if (list != null) {
                Iterator<Media> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().localPath);
                }
            }
            SquareShareFeedBean squareShareFeedBean2 = this.c;
            squareShareFeedBean2.publicProgressImage = squareShareFeedBean2.mediaList.get(0).localPath;
            H(arrayList);
        }
    }

    public final void E() {
        C();
    }

    public final void F() {
        ArrayList<String> arrayList = new ArrayList<>();
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean != null) {
            List<Media> list = squareShareFeedBean.mediaList;
            if (list != null) {
                Iterator<Media> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().localThumbPath);
                }
            }
            String str = this.c.mediaList.get(0).localPath;
            String str2 = this.c.mediaList.get(0).localThumbPath;
            this.c.publicProgressImage = str2;
            if (str == null || str2 == null) {
                return;
            }
            String str3 = f;
            LogUtil.d(str3, "localPath:" + str);
            LogUtil.d(str3, "localThumbPath:" + str2);
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && file2.exists()) {
                H(arrayList);
            } else {
                w("发布失败，请稍后再试");
            }
        }
    }

    public void G(Context context) {
        new sd3(context).k("发送通讯录好友失败，请重新尝试").P("重新发送").L("取消发送").f(new f()).Q();
    }

    public final void H(ArrayList<String> arrayList) {
        zo4.e(arrayList, true, 0, new a(), 4);
        x(1);
    }

    public final void I(ArrayList<String> arrayList) {
        zo4.f(arrayList, true, 2, 4, new b(), new c());
    }

    @Override // java.util.Observable
    public void addObserver(Observer observer) {
        super.addObserver(observer);
    }

    public final void p() {
        List<SquareContactBean> list;
        List<SquareFriendBean> list2;
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean != null) {
            if (squareShareFeedBean.sendLxFriendFlag && (list2 = squareShareFeedBean.lxFriendBeanList) != null) {
                for (SquareFriendBean squareFriendBean : list2) {
                    bj5.b().a().p(this.c.squareFeed, squareFriendBean.item);
                    SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_FEED_IN_CHAT, k86.a("key_square_share_feed_" + squareFriendBean.item.getUid()), Integer.valueOf(squareFriendBean.feedCount + 1));
                }
            }
            q();
            x(2);
            SquareShareFeedBean squareShareFeedBean2 = this.c;
            if (!squareShareFeedBean2.sendContactsFriendFlag || (list = squareShareFeedBean2.contactLists) == null) {
                return;
            }
            y(false, squareShareFeedBean2.squareFeed, list);
        }
    }

    public final void q() {
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean == null || !squareShareFeedBean.clearMedia) {
            return;
        }
        List<Media> list = squareShareFeedBean.mediaList;
        if (list != null) {
            for (Media media : list) {
                pu1.e(media.localThumbPath);
                pu1.e(media.localPath);
            }
        }
        SquareShareFeedBean squareShareFeedBean2 = this.c;
        squareShareFeedBean2.publicProgressImage = null;
        squareShareFeedBean2.clearMedia = false;
    }

    public final boolean s(SquareFeed squareFeed) {
        ContactInfoItem contactInfoItemB;
        if (squareFeed == null || (contactInfoItemB = dn0.b(squareFeed.exid)) == null) {
            return false;
        }
        return contactInfoItemB.isOfficialAccount();
    }

    public boolean t() {
        int i;
        SquareShareFeedBean squareShareFeedBean = this.c;
        return squareShareFeedBean != null && ((i = squareShareFeedBean.publicStatus) == 1 || i == -1);
    }

    public boolean u() {
        return this.c != null;
    }

    public final void v(int i) {
        LogUtil.d(f, "notifyPercent :" + i);
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean == null || squareShareFeedBean.publicStatus != 1 || i >= 100) {
            return;
        }
        squareShareFeedBean.percent = i;
        setChanged();
        notifyObservers(this.c);
    }

    public final void w(String str) {
        SquareShareFeedBean squareShareFeedBean = this.c;
        if (squareShareFeedBean != null) {
            squareShareFeedBean.errorMsg = str;
            squareShareFeedBean.publicStatus = -1;
            setChanged();
            notifyObservers(this.c);
        }
    }

    public final void x(int i) {
        if (this.c != null) {
            if (i == 2) {
                sy5.e(com.zenmen.palmchat.c.b(), R$string.square_post_bar_success, 1).g();
            } else if (i == -1) {
                sy5.e(com.zenmen.palmchat.c.b(), R$string.square_post_bar_fail, 1).g();
            }
            if (i == 2) {
                this.c.percent = 100;
            }
            this.c.publicStatus = i;
            setChanged();
            notifyObservers(this.c);
        }
    }

    public final void y(boolean z, SquareFeed squareFeed, List<SquareContactBean> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<SquareContactBean> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().number);
        }
        this.b.h(squareFeed.id, arrayList, new e(arrayList, list));
        if (z) {
            x(3);
        }
    }

    public void z() {
        q();
        this.c = null;
        setChanged();
        notifyObservers();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements qp4.f {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                mj5.this.w("发布失败，请稍后再试");
            }
        }

        /* JADX INFO: renamed from: mj5$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1248b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f19245a;

            public RunnableC1248b(int i) {
                this.f19245a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                mj5.this.v(((this.f19245a * 3) / 10) + 60);
            }
        }

        public b() {
        }

        @Override // qp4.f
        public void a(Exception exc) {
            LogUtil.d(mj5.f, "uploadVideo fail!!");
            mj5.this.f19238a.post(new a());
        }

        @Override // qp4.f
        public void b(ArrayList<UploadResultVo> arrayList) {
            if (mj5.this.c == null || mj5.this.c.mediaList == null) {
                return;
            }
            mj5.this.v(90);
            if (arrayList == null || arrayList.size() != 1) {
                mj5.this.w("发布失败，请稍后再试");
                return;
            }
            LogUtil.d(mj5.f, "uploadVideo success!!");
            mj5.this.c.mediaList.get(0).videoUrl = arrayList.get(0).url;
            mj5.this.C();
        }

        @Override // qp4.f
        public void onProgress(int i, int i2) {
            mj5.this.f19238a.post(new RunnableC1248b(i));
        }

        @Override // qp4.f
        public void c(UploadResultVo uploadResultVo) {
        }
    }
}
