package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.u.nr.b;
import com.bytedance.sdk.component.widget.recycler.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class u implements x.u {
    Runnable b;
    final InterfaceC0233u fx;
    final x iz;
    private int n;
    final ArrayList<nr> nr;
    final boolean pn;
    final ArrayList<nr> u;
    private b.u<nr> x;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        int b;
        Object fx;
        int nr;
        int u;

        public nr(int i, int i2, int i3, Object obj) {
            this.u = i;
            this.nr = i2;
            this.b = i3;
            this.fx = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            nr nrVar = (nr) obj;
            int i = this.u;
            if (i != nrVar.u) {
                return false;
            }
            if (i == 8 && Math.abs(this.b - this.nr) == 1 && this.b == nrVar.nr && this.nr == nrVar.b) {
                return true;
            }
            if (this.b != nrVar.b || this.nr != nrVar.nr) {
                return false;
            }
            Object obj2 = this.fx;
            if (obj2 != null) {
                if (!obj2.equals(nrVar.fx)) {
                    return false;
                }
            } else if (nrVar.fx != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.u * 31) + this.nr) * 31) + this.b;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + u() + ",s:" + this.nr + "c:" + this.b + ",p:" + this.fx + "]";
        }

        public String u() {
            int i = this.u;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : com.kuaishou.weapon.p0.t.w : "add";
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0233u {
        void b(int i, int i2);

        void fx(int i, int i2);

        void nr(int i, int i2);

        RecyclerView.q u(int i);

        void u(int i, int i2);

        void u(int i, int i2, Object obj);
    }

    public u(InterfaceC0233u interfaceC0233u) {
        this(interfaceC0233u, false);
    }

    private void b(nr nrVar) {
        int i = nrVar.nr;
        int i2 = nrVar.b + i;
        int i3 = i;
        byte b = -1;
        int i4 = 0;
        while (i < i2) {
            if (this.fx.u(i) != null || b(i)) {
                if (b == 0) {
                    pn(u(4, i3, i4, nrVar.fx));
                    i3 = i;
                    i4 = 0;
                }
                b = 1;
            } else {
                if (b == 1) {
                    x(u(4, i3, i4, nrVar.fx));
                    i3 = i;
                    i4 = 0;
                }
                b = 0;
            }
            i4++;
            i++;
        }
        if (i4 != nrVar.b) {
            Object obj = nrVar.fx;
            u(nrVar);
            nrVar = u(4, i3, i4, obj);
        }
        if (b == 0) {
            pn(nrVar);
        } else {
            x(nrVar);
        }
    }

    private void iz(nr nrVar) {
        x(nrVar);
    }

    private void pn(nr nrVar) {
        int i;
        int i2 = nrVar.u;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iNr = nr(nrVar.nr, i2);
        int i3 = nrVar.nr;
        int i4 = nrVar.u;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(nrVar)));
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < nrVar.b; i6++) {
            int iNr2 = nr(nrVar.nr + (i * i6), nrVar.u);
            int i7 = nrVar.u;
            if (i7 == 2 ? iNr2 == iNr : i7 == 4 && iNr2 == iNr + 1) {
                i5++;
            } else {
                nr nrVarU = u(i7, iNr, i5, nrVar.fx);
                u(nrVarU, i3);
                u(nrVarU);
                if (nrVar.u == 4) {
                    i3 += i5;
                }
                iNr = iNr2;
                i5 = 1;
            }
        }
        Object obj = nrVar.fx;
        u(nrVar);
        if (i5 > 0) {
            nr nrVarU2 = u(nrVar.u, iNr, i5, obj);
            u(nrVarU2, i3);
            u(nrVarU2);
        }
    }

    private void x(nr nrVar) {
        this.nr.add(nrVar);
        int i = nrVar.u;
        if (i == 1) {
            this.fx.fx(nrVar.nr, nrVar.b);
            return;
        }
        if (i == 2) {
            this.fx.nr(nrVar.nr, nrVar.b);
        } else if (i == 4) {
            this.fx.u(nrVar.nr, nrVar.b, nrVar.fx);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(nrVar)));
            }
            this.fx.b(nrVar.nr, nrVar.b);
        }
    }

    public void fx() {
        int size = this.nr.size();
        for (int i = 0; i < size; i++) {
            this.nr.get(i);
        }
        u(this.nr);
        this.n = 0;
    }

    public void nr() {
        this.iz.u(this.u);
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            nr nrVar = this.u.get(i);
            int i2 = nrVar.u;
            if (i2 == 1) {
                iz(nrVar);
            } else if (i2 == 2) {
                fx(nrVar);
            } else if (i2 == 4) {
                b(nrVar);
            } else if (i2 == 8) {
                nr(nrVar);
            }
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.u.clear();
    }

    public void u() {
        u(this.u);
        u(this.nr);
        this.n = 0;
    }

    public u(InterfaceC0233u interfaceC0233u, boolean z) {
        this.x = new b.nr(30);
        this.u = new ArrayList<>();
        this.nr = new ArrayList<>();
        this.n = 0;
        this.fx = interfaceC0233u;
        this.pn = z;
        this.iz = new x(this);
    }

    public boolean iz() {
        return (this.nr.isEmpty() || this.u.isEmpty()) ? false : true;
    }

    public void u(nr nrVar, int i) {
        int i2 = nrVar.u;
        if (i2 == 2) {
            this.fx.u(i, nrVar.b);
        } else {
            if (i2 == 4) {
                this.fx.u(i, nrVar.b, nrVar.fx);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private void fx(nr nrVar) {
        boolean z;
        byte b;
        int i = nrVar.nr;
        int i2 = nrVar.b + i;
        byte b2 = -1;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.fx.u(i3) != null || b(i3)) {
                if (b2 == 0) {
                    pn(u(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b2 == 1) {
                    x(u(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b2 = b;
        }
        if (i4 != nrVar.b) {
            u(nrVar);
            nrVar = u(2, i, i4, null);
        }
        if (b2 == 0) {
            pn(nrVar);
        } else {
            x(nrVar);
        }
    }

    public boolean u(int i) {
        return (i & this.n) != 0;
    }

    public int u(int i, int i2) {
        int size = this.nr.size();
        while (i2 < size) {
            nr nrVar = this.nr.get(i2);
            int i3 = nrVar.u;
            if (i3 == 8) {
                int i4 = nrVar.nr;
                if (i4 == i) {
                    i = nrVar.b;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (nrVar.b <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = nrVar.nr;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = nrVar.b;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += nrVar.b;
                }
            }
            i2++;
        }
        return i;
    }

    private void nr(nr nrVar) {
        x(nrVar);
    }

    private int nr(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.nr.size() - 1; size >= 0; size--) {
            nr nrVar = this.nr.get(size);
            int i5 = nrVar.u;
            if (i5 == 8) {
                int i6 = nrVar.nr;
                int i7 = nrVar.b;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            nrVar.nr = i6 + 1;
                            nrVar.b = i7 + 1;
                        } else if (i2 == 2) {
                            nrVar.nr = i6 - 1;
                            nrVar.b = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        nrVar.b = i7 + 1;
                    } else if (i2 == 2) {
                        nrVar.b = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        nrVar.nr = i6 + 1;
                    } else if (i2 == 2) {
                        nrVar.nr = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = nrVar.nr;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= nrVar.b;
                    } else if (i5 == 2) {
                        i += nrVar.b;
                    }
                } else if (i2 == 1) {
                    nrVar.nr = i8 + 1;
                } else if (i2 == 2) {
                    nrVar.nr = i8 - 1;
                }
            }
        }
        for (int size2 = this.nr.size() - 1; size2 >= 0; size2--) {
            nr nrVar2 = this.nr.get(size2);
            if (nrVar2.u == 8) {
                int i9 = nrVar2.b;
                if (i9 == nrVar2.nr || i9 < 0) {
                    this.nr.remove(size2);
                    u(nrVar2);
                }
            } else if (nrVar2.b <= 0) {
                this.nr.remove(size2);
                u(nrVar2);
            }
        }
        return i;
    }

    private boolean b(int i) {
        int size = this.nr.size();
        for (int i2 = 0; i2 < size; i2++) {
            nr nrVar = this.nr.get(i2);
            int i3 = nrVar.u;
            if (i3 == 8) {
                if (u(nrVar.b, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = nrVar.nr;
                int i5 = nrVar.b + i4;
                while (i4 < i5) {
                    if (u(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public int fx(int i) {
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            nr nrVar = this.u.get(i2);
            int i3 = nrVar.u;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = nrVar.nr;
                    if (i4 <= i) {
                        int i5 = nrVar.b;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = nrVar.nr;
                    if (i6 == i) {
                        i = nrVar.b;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (nrVar.b <= i) {
                            i++;
                        }
                    }
                }
            } else if (nrVar.nr <= i) {
                i += nrVar.b;
            }
        }
        return i;
    }

    public boolean u(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.u.add(u(4, i, i2, obj));
        this.n |= 4;
        return this.u.size() == 1;
    }

    public void pn() {
        fx();
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            nr nrVar = this.u.get(i);
            int i2 = nrVar.u;
            if (i2 == 1) {
                this.fx.fx(nrVar.nr, nrVar.b);
            } else if (i2 == 2) {
                this.fx.u(nrVar.nr, nrVar.b);
            } else if (i2 == 4) {
                this.fx.u(nrVar.nr, nrVar.b, nrVar.fx);
            } else if (i2 == 8) {
                this.fx.b(nrVar.nr, nrVar.b);
            }
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }
        u(this.u);
        this.n = 0;
    }

    public boolean b() {
        return this.u.size() > 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.x.u
    public nr u(int i, int i2, int i3, Object obj) {
        nr nrVarU = this.x.u();
        if (nrVarU == null) {
            return new nr(i, i2, i3, obj);
        }
        nrVarU.u = i;
        nrVarU.nr = i2;
        nrVarU.b = i3;
        nrVarU.fx = obj;
        return nrVarU;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.x.u
    public void u(nr nrVar) {
        if (this.pn) {
            return;
        }
        nrVar.fx = null;
        this.x.u(nrVar);
    }

    public void u(List<nr> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            u(list.get(i));
        }
        list.clear();
    }

    public int nr(int i) {
        return u(i, 0);
    }
}
