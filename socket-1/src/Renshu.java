class Renshu {
  // xを2倍にして返す関数
  public int doubleValue(int x) {
    return x * 2;
  }

  // ここに続きを実装していく。
  public int sumUpToN(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i++) {
      sum += i;
    }
    return sum;
  }

  public int sumFromPtoQ(int p, int q) {
    int sum = 0;
    if (p > q) {
      return -1;
    }
    for (int i = p; i <= q; i++) {
      sum += i;
    }
    return sum;
  }

  public int sumFromArrayIndex(int[] a, int index) {
    int sum = 0;
    if (index > a.length - 1) {
      return -1;
    }
    for (int i = index; i < a.length; i++) {
      sum += a[i];
    }
    return sum;
  }

  public int selectMaxValue(int[] a) {
    int maxValue = a[0];
    for (int i : a) {
      if (i > maxValue) {
        maxValue = i;
      }
    }
    return maxValue;
  }

  public int selectMinValue(int[] a) {
    int minValue = a[0];
    for (int i : a) {
      if (i < minValue) {
        minValue = i;
      }
    }
    return minValue;
  }

  public int selectMaxIndex(int[] a) {
    int maxIndex = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > a[maxIndex]) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  public int selectMinIndex(int[] a) {
    int minIndex = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < a[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public void swapArrayElements(int[] p, int i, int j) {
    int temp = p[i];
    p[i] = p[j];
    p[j] = temp;
  }

  public boolean swapTwoArrays(int[] a, int[] b) {
    if (a.length != b.length) {
      return false;
    }
    int[] temp = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      temp[i] = a[i];
      a[i] = b[i];
      b[i] = temp[i];
    }
    return true;
  }
}