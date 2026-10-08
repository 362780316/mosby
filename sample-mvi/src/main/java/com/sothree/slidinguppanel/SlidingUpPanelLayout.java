package com.sothree.slidinguppanel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SlidingUpPanelLayout extends FrameLayout {

  public enum PanelState {
    EXPANDED,
    COLLAPSED
  }

  private PanelState panelState = PanelState.COLLAPSED;

  public SlidingUpPanelLayout(Context context) {
    super(context);
  }

  public SlidingUpPanelLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SlidingUpPanelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public PanelState getPanelState() {
    return panelState;
  }

  public void setPanelState(PanelState panelState) {
    this.panelState = panelState;
  }
}
