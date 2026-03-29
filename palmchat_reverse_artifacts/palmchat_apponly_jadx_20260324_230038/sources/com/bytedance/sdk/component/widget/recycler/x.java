package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.u;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class x {
    final u u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        u.nr u(int i, int i2, int i3, Object obj);

        void u(u.nr nrVar);
    }

    public x(u uVar) {
        this.u = uVar;
    }

    private void fx(List<u.nr> list, int i, u.nr nrVar, int i2, u.nr nrVar2) {
        int i3 = nrVar.b;
        int i4 = nrVar2.nr;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = nrVar.nr;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            nrVar.nr = i6 + nrVar2.b;
        }
        int i7 = nrVar2.nr;
        if (i7 <= i3) {
            nrVar.b = i3 + nrVar2.b;
        }
        nrVar2.nr = i7 + i5;
        list.set(i, nrVar2);
        list.set(i2, nrVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nr(List<u.nr> list, int i, u.nr nrVar, int i2, u.nr nrVar2) {
        u.nr nrVarU;
        int i3;
        int i4;
        int i5 = nrVar.b;
        int i6 = nrVar2.nr;
        u.nr nrVarU2 = null;
        if (i5 >= i6) {
            int i7 = nrVar2.b;
            if (i5 < i6 + i7) {
                nrVar2.b = i7 - 1;
                nrVarU = this.u.u(4, nrVar.nr, 1, nrVar2.fx);
            }
            i3 = nrVar.nr;
            i4 = nrVar2.nr;
            if (i3 > i4) {
                nrVar2.nr = i4 + 1;
            } else {
                int i8 = nrVar2.b;
                if (i3 < i4 + i8) {
                    int i9 = (i4 + i8) - i3;
                    nrVarU2 = this.u.u(4, i3 + 1, i9, nrVar2.fx);
                    nrVar2.b -= i9;
                }
            }
            list.set(i2, nrVar);
            if (nrVar2.b <= 0) {
                list.set(i, nrVar2);
            } else {
                list.remove(i);
                this.u.u(nrVar2);
            }
            if (nrVarU != null) {
                list.add(i, nrVarU);
            }
            if (nrVarU2 == null) {
                list.add(i, nrVarU2);
                return;
            }
            return;
        }
        nrVar2.nr = i6 - 1;
        nrVarU = null;
        i3 = nrVar.nr;
        i4 = nrVar2.nr;
        if (i3 > i4) {
        }
        list.set(i2, nrVar);
        if (nrVar2.b <= 0) {
        }
        if (nrVarU != null) {
        }
        if (nrVarU2 == null) {
        }
    }

    public void u(List<u.nr> list) {
        while (true) {
            int iNr = nr(list);
            if (iNr == -1) {
                return;
            } else {
                u(list, iNr, iNr + 1);
            }
        }
    }

    private void u(List<u.nr> list, int i, int i2) {
        u.nr nrVar = list.get(i);
        u.nr nrVar2 = list.get(i2);
        int i3 = nrVar2.u;
        if (i3 == 1) {
            fx(list, i, nrVar, i2, nrVar2);
        } else if (i3 == 2) {
            u(list, i, nrVar, i2, nrVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            nr(list, i, nrVar, i2, nrVar2);
        }
    }

    public void u(List<u.nr> list, int i, u.nr nrVar, int i2, u.nr nrVar2) {
        boolean z;
        int i3 = nrVar.nr;
        int i4 = nrVar.b;
        boolean z2 = false;
        if (i3 < i4) {
            if (nrVar2.nr == i3 && nrVar2.b == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (nrVar2.nr == i4 + 1 && nrVar2.b == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = nrVar2.nr;
        if (i4 < i5) {
            nrVar2.nr = i5 - 1;
        } else {
            int i6 = nrVar2.b;
            if (i4 < i5 + i6) {
                nrVar2.b = i6 - 1;
                nrVar.u = 2;
                nrVar.b = 1;
                if (nrVar2.b == 0) {
                    list.remove(i2);
                    this.u.u(nrVar2);
                    return;
                }
                return;
            }
        }
        int i7 = nrVar.nr;
        int i8 = nrVar2.nr;
        u.nr nrVarU = null;
        if (i7 <= i8) {
            nrVar2.nr = i8 + 1;
        } else {
            int i9 = nrVar2.b;
            if (i7 < i8 + i9) {
                nrVarU = this.u.u(2, i7 + 1, (i8 + i9) - i7, null);
                nrVar2.b = nrVar.nr - nrVar2.nr;
            }
        }
        if (z2) {
            list.set(i, nrVar2);
            list.remove(i2);
            this.u.u(nrVar);
            return;
        }
        if (z) {
            if (nrVarU != null) {
                int i10 = nrVar.nr;
                if (i10 > nrVarU.nr) {
                    nrVar.nr = i10 - nrVarU.b;
                }
                int i11 = nrVar.b;
                if (i11 > nrVarU.nr) {
                    nrVar.b = i11 - nrVarU.b;
                }
            }
            int i12 = nrVar.nr;
            if (i12 > nrVar2.nr) {
                nrVar.nr = i12 - nrVar2.b;
            }
            int i13 = nrVar.b;
            if (i13 > nrVar2.nr) {
                nrVar.b = i13 - nrVar2.b;
            }
        } else {
            if (nrVarU != null) {
                int i14 = nrVar.nr;
                if (i14 >= nrVarU.nr) {
                    nrVar.nr = i14 - nrVarU.b;
                }
                int i15 = nrVar.b;
                if (i15 >= nrVarU.nr) {
                    nrVar.b = i15 - nrVarU.b;
                }
            }
            int i16 = nrVar.nr;
            if (i16 >= nrVar2.nr) {
                nrVar.nr = i16 - nrVar2.b;
            }
            int i17 = nrVar.b;
            if (i17 >= nrVar2.nr) {
                nrVar.b = i17 - nrVar2.b;
            }
        }
        list.set(i, nrVar2);
        if (nrVar.nr != nrVar.b) {
            list.set(i2, nrVar);
        } else {
            list.remove(i2);
        }
        if (nrVarU != null) {
            list.add(i, nrVarU);
        }
    }

    private int nr(List<u.nr> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).u != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
