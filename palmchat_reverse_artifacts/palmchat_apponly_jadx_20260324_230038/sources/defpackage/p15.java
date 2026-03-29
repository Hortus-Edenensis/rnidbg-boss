package defpackage;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.t;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0003\u0010\r¨\u0006\u0015"}, d2 = {"Lp15;", "", "", "a", "Ljava/lang/String;", t.l, "()Ljava/lang/String;", "imageKey", "c", "matteKey", "", "Lq15;", "Ljava/util/List;", "()Ljava/util/List;", "frames", "Lorg/json/JSONObject;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "<init>", "(Lorg/json/JSONObject;)V", "Lcom/opensource/svgaplayer/proto/SpriteEntity;", "(Lcom/opensource/svgaplayer/proto/SpriteEntity;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class p15 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String imageKey;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String matteKey;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final List<q15> frames;

    public p15(JSONObject jSONObject) {
        this.imageKey = jSONObject.optString("imageKey");
        this.matteKey = jSONObject.optString("matteKey");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("frames");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    q15 q15Var = new q15(jSONObjectOptJSONObject);
                    if ((!q15Var.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List) q15Var.d())).i() && arrayList.size() > 0) {
                        q15Var.f(((q15) CollectionsKt___CollectionsKt.last((List) arrayList)).d());
                    }
                    arrayList.add(q15Var);
                }
            }
        }
        this.frames = CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public final List<q15> a() {
        return this.frames;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getImageKey() {
        return this.imageKey;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getMatteKey() {
        return this.matteKey;
    }

    public p15(SpriteEntity spriteEntity) {
        List<q15> listEmptyList;
        this.imageKey = spriteEntity.imageKey;
        this.matteKey = spriteEntity.matteKey;
        List<FrameEntity> list = spriteEntity.frames;
        if (list == null) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<FrameEntity> list2 = list;
            listEmptyList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            q15 q15Var = null;
            for (FrameEntity it : list2) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                q15 q15Var2 = new q15(it);
                if ((!q15Var2.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List) q15Var2.d())).i() && q15Var != null) {
                    q15Var2.f(q15Var.d());
                }
                listEmptyList.add(q15Var2);
                q15Var = q15Var2;
            }
        }
        this.frames = listEmptyList;
    }
}
