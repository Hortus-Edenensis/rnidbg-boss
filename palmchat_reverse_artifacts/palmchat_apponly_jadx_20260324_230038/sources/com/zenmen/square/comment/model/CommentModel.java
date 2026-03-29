package com.zenmen.square.comment.model;

import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.CommentReplyItem;
import com.zenmen.square.comment.struct.SquareCommentBean;
import com.zenmen.square.comment.struct.SquareCommentList;
import com.zenmen.square.comment.struct.UnitedException;
import defpackage.at2;
import defpackage.bi5;
import defpackage.cw4;
import defpackage.ei5;
import defpackage.mi0;
import defpackage.yk2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentModel implements yk2 {
    @Override // defpackage.yk2
    public void addComment(final AddCommentParam addCommentParam, final at2<CommentPostBean> at2Var) {
        bi5.a(new ei5<BaseNetBean<CommentPostBean>>() { // from class: com.zenmen.square.comment.model.CommentModel.9
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("feedId", Long.valueOf(addCommentParam.feedId));
                map.put("exFeedUid", addCommentParam.exFeedUid);
                map.put("exFromDiscussionUid", addCommentParam.exFromDiscussionUid);
                map.put("exToDiscussionUid", addCommentParam.exToDiscussionUid);
                map.put("exToSuperDiscussionUid", addCommentParam.exToSuperDiscussionUid);
                map.put("toDiscussionId", Long.valueOf(addCommentParam.toDiscussionId));
                map.put("content", addCommentParam.content);
                map.put("random", addCommentParam.random);
                map.put("from", Integer.valueOf(addCommentParam.from));
                map.put("sourceType", Integer.valueOf(addCommentParam.sourceType));
                LocationEx locationExI = d.g().i(86400000L);
                if (locationExI != null) {
                    map.put("longitude", locationExI.getLongitude() + "");
                    map.put("latitude", locationExI.getLatitude() + "");
                }
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean<CommentPostBean> handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean<CommentPostBean>>() { // from class: com.zenmen.square.comment.model.CommentModel.9.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean<CommentPostBean> baseNetBean) {
                CommentPostBean commentPostBean;
                if (baseNetBean.isSuccess() && (commentPostBean = baseNetBean.data) != null) {
                    at2Var.onSuccess(commentPostBean);
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    @Override // defpackage.yk2
    public void addReply(final AddCommentParam addCommentParam, final at2<CommentPostBean> at2Var) {
        bi5.a(new ei5<BaseNetBean<CommentPostBean>>() { // from class: com.zenmen.square.comment.model.CommentModel.10
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("feedId", Long.valueOf(addCommentParam.feedId));
                map.put("exFeedUid", addCommentParam.exFeedUid);
                map.put("exFromDiscussionUid", addCommentParam.exFromDiscussionUid);
                map.put("exToDiscussionUid", addCommentParam.exToDiscussionUid);
                map.put("exToSuperDiscussionUid", addCommentParam.exToSuperDiscussionUid);
                map.put("toDiscussionId", Long.valueOf(addCommentParam.toDiscussionId));
                map.put("content", addCommentParam.content);
                map.put("random", addCommentParam.random);
                map.put("from", Integer.valueOf(addCommentParam.from));
                map.put("sourceType", Integer.valueOf(addCommentParam.sourceType));
                LocationEx locationExI = d.g().i(86400000L);
                if (locationExI != null) {
                    map.put("longitude", locationExI.getLongitude() + "");
                    map.put("latitude", locationExI.getLatitude() + "");
                }
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean<CommentPostBean> handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean<CommentPostBean>>() { // from class: com.zenmen.square.comment.model.CommentModel.10.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean<CommentPostBean> baseNetBean) {
                CommentPostBean commentPostBean;
                if (baseNetBean.isSuccess() && (commentPostBean = baseNetBean.data) != null) {
                    at2Var.onSuccess(commentPostBean);
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(-1, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    @Override // defpackage.yk2
    public void cancelCommentLike(final LikeCommentParam likeCommentParam, final at2<Boolean> at2Var) {
        bi5.e(new ei5<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.4
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("exFeedUid", likeCommentParam.exFeedUid);
                map.put("feedId", Long.valueOf(likeCommentParam.feedId));
                map.put("random", likeCommentParam.random);
                map.put("toCommentId", Long.valueOf(likeCommentParam.toCommentId));
                map.put("exFromDiscussionUid", likeCommentParam.exFromDiscussionUid);
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.4.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean baseNetBean) {
                if (baseNetBean.isSuccess()) {
                    at2Var.onSuccess(Boolean.valueOf(baseNetBean.isSuccess()));
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    @Override // defpackage.yk2
    public void cancelLikeReply(final LikeCommentParam likeCommentParam, final at2<Boolean> at2Var) {
        bi5.e(new ei5<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.6
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("exFeedUid", likeCommentParam.exFeedUid);
                map.put("feedId", Long.valueOf(likeCommentParam.feedId));
                map.put("random", likeCommentParam.random);
                map.put("toCommentId", Long.valueOf(likeCommentParam.toCommentId));
                map.put("exFromDiscussionUid", likeCommentParam.exFromDiscussionUid);
                map.put("exToDiscussionUid", likeCommentParam.exToDiscussionUid);
                map.put("toDiscussionId", Long.valueOf(likeCommentParam.toDiscussionId));
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.6.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean baseNetBean) {
                if (baseNetBean.isSuccess()) {
                    at2Var.onSuccess(Boolean.valueOf(baseNetBean.isSuccess()));
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    @Override // defpackage.yk2
    public void commentLike(final LikeCommentParam likeCommentParam, final at2<Boolean> at2Var) {
        bi5.k(new ei5<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.3
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("exFeedUid", likeCommentParam.exFeedUid);
                map.put("feedId", Long.valueOf(likeCommentParam.feedId));
                map.put("random", likeCommentParam.random);
                map.put("toCommentId", Long.valueOf(likeCommentParam.toCommentId));
                map.put("exFromDiscussionUid", likeCommentParam.exFromDiscussionUid);
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.3.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean baseNetBean) {
                if (baseNetBean.isSuccess()) {
                    at2Var.onSuccess(Boolean.valueOf(baseNetBean.isSuccess()));
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    @Override // defpackage.yk2
    public void getCommentList(final GetCommentsParam getCommentsParam, final at2<mi0> at2Var) {
        bi5.g(new ei5<BaseNetBean<SquareCommentList>>() { // from class: com.zenmen.square.comment.model.CommentModel.1
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("version", Long.valueOf(getCommentsParam.version));
                map.put("reqListType", Integer.valueOf(getCommentsParam.reqListType));
                map.put("feedId", Long.valueOf(getCommentsParam.feedId));
                map.put("exFeedUid", getCommentsParam.exFeedUid);
                map.put("toDiscussionId", Long.valueOf(getCommentsParam.toDiscussionId));
                map.put("exToDiscussionUid", getCommentsParam.exToDiscussionUid);
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean<SquareCommentList> handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean<SquareCommentList>>() { // from class: com.zenmen.square.comment.model.CommentModel.1.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean<SquareCommentList> baseNetBean) {
                if (!baseNetBean.isSuccess() || baseNetBean.data == null) {
                    at2 at2Var2 = at2Var;
                    if (at2Var2 != null) {
                        at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                        return;
                    }
                    return;
                }
                mi0 mi0Var = new mi0();
                List<SquareCommentBean> list = baseNetBean.data.discussionRespDOList;
                ArrayList arrayList = new ArrayList();
                Iterator<SquareCommentBean> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(CommentItem.fromCommentInfo(it.next()));
                }
                mi0Var.h(arrayList);
                mi0Var.j(baseNetBean.data.recShowDiscussions);
                mi0Var.i(baseNetBean.data.ifHasMore);
                at2Var.onSuccess(mi0Var);
            }
        });
    }

    @Override // defpackage.yk2
    public void getReplyList(final GetCommentsParam getCommentsParam, final at2<cw4> at2Var) {
        bi5.g(new ei5<BaseNetBean<SquareCommentList>>() { // from class: com.zenmen.square.comment.model.CommentModel.2
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("version", Long.valueOf(getCommentsParam.version));
                map.put("reqListType", Integer.valueOf(getCommentsParam.reqListType));
                map.put("feedId", Long.valueOf(getCommentsParam.feedId));
                map.put("exFeedUid", getCommentsParam.exFeedUid);
                map.put("toDiscussionId", Long.valueOf(getCommentsParam.toDiscussionId));
                map.put("exToDiscussionUid", getCommentsParam.exToDiscussionUid);
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean<SquareCommentList> handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean<SquareCommentList>>() { // from class: com.zenmen.square.comment.model.CommentModel.2.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean<SquareCommentList> baseNetBean) {
                if (!baseNetBean.isSuccess() || baseNetBean.data == null) {
                    at2 at2Var2 = at2Var;
                    if (at2Var2 != null) {
                        at2Var2.a(new UnitedException(-1, baseNetBean.getErrMsg()));
                        return;
                    }
                    return;
                }
                cw4 cw4Var = new cw4();
                List<SquareCommentBean> list = baseNetBean.data.discussionRespDOList;
                ArrayList arrayList = new ArrayList();
                Iterator<SquareCommentBean> it = list.iterator();
                while (it.hasNext()) {
                    CommentReplyItem commentReplyItemFromReplyInfo = CommentReplyItem.fromReplyInfo(it.next());
                    commentReplyItemFromReplyInfo.setCmtId(getCommentsParam.toDiscussionId);
                    arrayList.add(commentReplyItemFromReplyInfo);
                }
                cw4Var.f(arrayList);
                cw4Var.e(baseNetBean.data.ifHasMore);
                at2Var.onSuccess(cw4Var);
            }
        });
    }

    @Override // defpackage.yk2
    public void likeReply(final LikeCommentParam likeCommentParam, final at2<Boolean> at2Var) {
        bi5.k(new ei5<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.5
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("exFeedUid", likeCommentParam.exFeedUid);
                map.put("feedId", Long.valueOf(likeCommentParam.feedId));
                map.put("random", likeCommentParam.random);
                map.put("toCommentId", Long.valueOf(likeCommentParam.toCommentId));
                map.put("exFromDiscussionUid", likeCommentParam.exFromDiscussionUid);
                map.put("exToDiscussionUid", likeCommentParam.exToDiscussionUid);
                map.put("toDiscussionId", Long.valueOf(likeCommentParam.toDiscussionId));
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.5.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean baseNetBean) {
                if (baseNetBean.isSuccess()) {
                    at2Var.onSuccess(Boolean.TRUE);
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    @Override // defpackage.yk2
    public void removeComment(final RemoveCommentParam removeCommentParam, final at2<BaseNetBean> at2Var) {
        bi5.o(new ei5<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.7
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("exToDiscussionUid", removeCommentParam.exToDiscussionUid);
                map.put("discussionId", Long.valueOf(removeCommentParam.discussionId));
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.7.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean baseNetBean) {
                if (baseNetBean.isSuccess()) {
                    at2Var.onSuccess(baseNetBean);
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    @Override // defpackage.yk2
    public void removeReply(final RemoveCommentParam removeCommentParam, final at2<BaseNetBean> at2Var) {
        bi5.o(new ei5<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.8
            @Override // defpackage.ei5
            public JSONObject genRequestParams() {
                HashMap map = new HashMap();
                map.put("exToDiscussionUid", removeCommentParam.exToDiscussionUid);
                map.put("discussionId", Long.valueOf(removeCommentParam.discussionId));
                return new JSONObject(map);
            }

            @Override // defpackage.ei5
            public BaseNetBean handle(JSONObject jSONObject) {
                return BaseNetBean.createDefault(jSONObject, new TypeToken<BaseNetBean>() { // from class: com.zenmen.square.comment.model.CommentModel.8.1
                }.getType());
            }

            @Override // defpackage.ei5
            public void onPostExecute(BaseNetBean baseNetBean) {
                if (baseNetBean.isSuccess()) {
                    at2Var.onSuccess(baseNetBean);
                    return;
                }
                at2 at2Var2 = at2Var;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(baseNetBean.resultCode, baseNetBean.getErrMsg()));
                }
            }
        });
    }

    public void getCommentInfo(String str, String str2, String str3, String str4, at2<Object> at2Var) {
    }
}
