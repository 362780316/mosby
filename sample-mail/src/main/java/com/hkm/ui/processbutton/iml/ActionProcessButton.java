package com.hkm.ui.processbutton.iml;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;

public class ActionProcessButton extends AppCompatButton {

  public enum Mode {
    ENDLESS
  }

  private int progress;

  public ActionProcessButton(Context context) {
    super(context);
  }

  public ActionProcessButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ActionProcessButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public void setMode(Mode mode) {
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public int getProgress() {
    return progress;
  }
}
