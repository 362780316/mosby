package github.chenupt.dragtoplayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.hannesdorfmann.mosby3.sample.mail.R;

public class DragTopLayout extends LinearLayout {

  private SimplePanelListener listener;
  private float downY;
  private int collapseOffset;

  public DragTopLayout(Context context) {
    super(context);
    init(null);
  }

  public DragTopLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public DragTopLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    setOrientation(VERTICAL);

    if (attrs != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DragTopLayout);
      collapseOffset = typedArray.getDimensionPixelSize(
          R.styleable.DragTopLayout_dtlCollapseOffset, 0);
      typedArray.recycle();
    }
  }

  public void listener(SimplePanelListener listener) {
    this.listener = listener;
  }

  @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
    if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
      downY = ev.getY();
    }

    return super.onInterceptTouchEvent(ev);
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    if (listener != null) {
      if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
        downY = event.getY();
      } else if (event.getActionMasked() == MotionEvent.ACTION_MOVE && collapseOffset > 0) {
        float progress = Math.min(1f, Math.max(0f, (downY - event.getY()) / collapseOffset));
        listener.onSliding(progress);
      }
    }

    return super.onTouchEvent(event);
  }

  public static class SimplePanelListener {
    public void onSliding(float ratio) {
    }
  }
}
