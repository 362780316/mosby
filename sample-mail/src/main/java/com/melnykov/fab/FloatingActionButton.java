package com.melnykov.fab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

public class FloatingActionButton extends AppCompatImageButton {

  public FloatingActionButton(Context context) {
    super(context);
    init();
  }

  public FloatingActionButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public FloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setScaleType(ScaleType.CENTER);
  }

  public void attachToRecyclerView(RecyclerView recyclerView) {
  }

  public void attachToScrollView(ObservableScrollView scrollView) {
  }
}
