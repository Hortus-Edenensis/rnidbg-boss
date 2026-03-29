package com.yuyakaido.android.cardstackview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.yuyakaido.android.cardstackview.Direction, still in use, count: 1, list:
  (r0v0 com.yuyakaido.android.cardstackview.Direction) from 0x002e: FILLED_NEW_ARRAY (r0v0 com.yuyakaido.android.cardstackview.Direction), (r1v1 com.yuyakaido.android.cardstackview.Direction) A[WRAPPED] (LINE:47) elemType: com.yuyakaido.android.cardstackview.Direction
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class Direction {
    Left,
    Right,
    Top,
    Bottom;

    public static final List<Direction> FREEDOM;
    public static final List<Direction> HORIZONTAL;
    public static final List<Direction> RIGHT;
    public static final List<Direction> VERTICAL;

    static {
        Direction direction = Right;
        HORIZONTAL = Arrays.asList(direction, direction);
        VERTICAL = Arrays.asList(direction, direction);
        FREEDOM = Arrays.asList(values());
        RIGHT = Collections.singletonList(direction);
    }

    private Direction() {
    }

    public static Direction valueOf(String str) {
        return (Direction) Enum.valueOf(Direction.class, str);
    }

    public static Direction[] values() {
        return (Direction[]) $VALUES.clone();
    }
}
