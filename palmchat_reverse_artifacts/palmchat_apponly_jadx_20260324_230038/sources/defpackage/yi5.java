package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.InteractMessageActivity;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.struct.SquareCommentBean;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.fragment.SquareInteractFragment;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.mvp.model.bean.SquareInteractDetail;
import defpackage.nq3;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class yi5 extends zi5<SquareInteractFragment, xi5, SquareInteractBean> {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements nq3.b {
        public a() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                sy5.e(((SquareInteractFragment) yi5.this.f11844a).getActivity(), R$string.square_comment_send_success, 1).g();
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.e(((SquareInteractFragment) yi5.this.f11844a).getActivity(), R$string.square_http_error, 1).g();
                } else {
                    sy5.f(((SquareInteractFragment) yi5.this.f11844a).getActivity(), unitedException.getErrorMsg(), 1).g();
                }
            }
        }
    }

    public yi5(SquareInteractFragment squareInteractFragment, xi5 xi5Var) {
        super(squareInteractFragment, xi5Var);
    }

    public void A(int i, SquareInteractDetail squareInteractDetail) {
        z66.d(squareInteractDetail.exFromUid, squareInteractDetail.sex, ((SquareInteractFragment) this.f11844a).W(), o(), squareInteractDetail.feedId, null, null);
    }

    public void B(SquareInteractDetail squareInteractDetail) {
        n40.a(null, squareInteractDetail.exFromUid, (FrameworkBaseActivity) ((SquareInteractFragment) this.f11844a).getActivity());
    }

    public void C(int i, SquareInteractBean squareInteractBean) {
        SquareInteractDetail squareInteractDetail = squareInteractBean.singleInteract;
        int i2 = squareInteractDetail.feedStatus;
        boolean z = true;
        if (i2 != 0) {
            if (i2 == 1) {
                ((SquareInteractFragment) this.f11844a).n0("该动态被举报，无法访问");
                return;
            } else {
                if (i2 == 2) {
                    ((SquareInteractFragment) this.f11844a).n0("该条动态已删除哦～");
                    return;
                }
                return;
            }
        }
        if (squareInteractDetail.feedType == 8) {
            HashMap map = new HashMap();
            map.put("channelId", squareInteractDetail.channelId);
            map.put("sceneId", squareInteractDetail.sceneId);
            map.put("channelType", Integer.valueOf(squareInteractDetail.channelType));
            bj5.b().a().H(((SquareInteractFragment) this.f11844a).getActivity(), new JSONObject(map), 17);
            return;
        }
        int i3 = squareInteractDetail.noticeType;
        if (i3 != 3 && i3 != 4) {
            z = false;
        }
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.id = squareInteractDetail.feedId;
        squareFeed.exid = squareInteractDetail.exFeedUid;
        squareFeed.feedType = squareInteractDetail.feedType;
        MediaViewActivity.B1(o(), ((SquareInteractFragment) this.f11844a).W(), squareFeed, z);
    }

    public void D(SquareInteractDetail squareInteractDetail) {
        int i = squareInteractDetail.feedStatus;
        if (i == 1) {
            ((SquareInteractFragment) this.f11844a).n0("该动态被举报，无法回复");
            return;
        }
        if (i == 2) {
            ((SquareInteractFragment) this.f11844a).n0("该条动态已删除哦～");
            return;
        }
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.exid = squareInteractDetail.exFeedUid;
        squareFeed.id = squareInteractDetail.feedId;
        squareFeed.feedType = squareInteractDetail.feedType;
        SquareCommentBean squareCommentBean = new SquareCommentBean();
        squareCommentBean.exFeedUid = squareInteractDetail.exFeedUid;
        squareCommentBean.feedId = squareInteractDetail.feedId;
        squareCommentBean.exFromUid = squareInteractDetail.exFromUid;
        squareCommentBean.id = squareInteractDetail.id;
        squareCommentBean.nickname = squareInteractDetail.nickname;
        squareCommentBean.discussionType = squareInteractDetail.discussionType;
        squareCommentBean.exToUid = v4.b(c.b());
        ti0.c().f(((SquareInteractFragment) this.f11844a).getActivity(), squareFeed, squareCommentBean, 17, 0, new a());
    }

    public void E(SquareInteractBean squareInteractBean) {
        int i = squareInteractBean.aggregationNoticeType;
        InteractMessageActivity.A1((i == 3 || i == 1) ? squareInteractBean.singleInteract.toDiscussionId : squareInteractBean.singleInteract.feedId, i, ((SquareInteractFragment) this.f11844a).W());
    }

    @Override // com.zenmen.listui.list.a
    public int o() {
        return ((SquareInteractFragment) this.f11844a).o();
    }
}
