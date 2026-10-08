package com.hannesdorfmann.mosby3.sample.mail.statistics;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.mosby3.sample.mail.R;

public final class StatisticsAdapterHolders {

  private StatisticsAdapterHolders() {
  }

  public static class StatisticItemViewHolder extends RecyclerView.ViewHolder {
    public final TextView text;

    public StatisticItemViewHolder(View itemView) {
      super(itemView);
      text = (TextView) itemView.findViewById(R.id.text);
    }
  }
}
