package com.hannesdorfmann.mosby3.sample.mail.menu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.mosby3.sample.mail.R;

public final class MenuAdapterHolders {

  private MenuAdapterHolders() {
  }

  public static class MenuItemViewHolder extends RecyclerView.ViewHolder {
    public final ImageView icon;
    public final TextView name;
    public final TextView unread;

    public MenuItemViewHolder(View itemView) {
      super(itemView);
      icon = (ImageView) itemView.findViewById(R.id.icon);
      name = (TextView) itemView.findViewById(R.id.name);
      unread = (TextView) itemView.findViewById(R.id.unreadCount);
    }
  }

  public static class StatisticsItemViewHolder extends RecyclerView.ViewHolder {
    public final ImageView icon;

    public StatisticsItemViewHolder(View itemView) {
      super(itemView);
      icon = (ImageView) itemView.findViewById(R.id.icon);
    }
  }
}
