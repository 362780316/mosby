/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hannesdorfmann.mosby3.sample.mail.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.mosby3.sample.mail.R;
import com.hannesdorfmann.mosby3.sample.mail.base.view.ListAdapter;
import com.hannesdorfmann.mosby3.sample.mail.model.mail.Label;
import java.util.List;

/**
 * @author Hannes Dorfmann
 */
public class MenuAdapter extends ListAdapter<List<Label>> {

  public static final int VIEW_TYPE_MENU_ITEM = 0;
  public static final int VIEW_TYPE_STATISTICS_ITEM = 1;

  public interface LabelClickListener {
    public void onLabelClicked(Label label);

    public void onStatisticsClicked();
  }

  private LabelClickListener listener;

  public MenuAdapter(Context context, LabelClickListener listener) {
    super(context);
    this.listener = listener;
  }

  @Override public int getItemCount() {
    if (items == null || items.size() == 0) {
      return 0;
    } else {
      return items.size() + 1; // +1 because of statistics item
    }
  }

  @Override public int getItemViewType(int position) {
    return position == getItemCount() - 1 ? VIEW_TYPE_STATISTICS_ITEM : VIEW_TYPE_MENU_ITEM;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == VIEW_TYPE_STATISTICS_ITEM) {
      View view = inflater.inflate(R.layout.list_menu_statistics, parent, false);
      MenuAdapterHolders.StatisticsItemViewHolder vh =
          new MenuAdapterHolders.StatisticsItemViewHolder(view);
      initViewHolder(vh, view, parent);
      return vh;
    }

    View view = inflater.inflate(R.layout.list_menu_item, parent, false);
    MenuAdapterHolders.MenuItemViewHolder vh = new MenuAdapterHolders.MenuItemViewHolder(view);
    initViewHolder(vh, view, parent);
    return vh;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof MenuAdapterHolders.StatisticsItemViewHolder) {
      bindViewHolder((MenuAdapterHolders.StatisticsItemViewHolder) holder, position);
    } else {
      bindViewHolder((MenuAdapterHolders.MenuItemViewHolder) holder, position);
    }
  }

  public void initViewHolder(MenuAdapterHolders.MenuItemViewHolder vh, View view,
      ViewGroup parent) {
    vh.icon.setColorFilter(context.getResources().getColor(R.color.secondary_text));
  }

  public void bindViewHolder(MenuAdapterHolders.MenuItemViewHolder vh, int position) {
    final Label label = items.get(position);
    vh.icon.setImageResource(label.getIconRes());
    vh.name.setText(label.getName());

    if (label.getUnreadCount() > 0) {
      vh.unread.setVisibility(View.VISIBLE);
      vh.unread.setText("" + label.getUnreadCount());
    } else {
      vh.unread.setVisibility(View.INVISIBLE);
    }

    vh.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        listener.onLabelClicked(label);
      }
    });
  }

  public void initViewHolder(MenuAdapterHolders.StatisticsItemViewHolder vh, View view,
      ViewGroup parent) {
    vh.icon.setColorFilter(context.getResources().getColor(R.color.secondary_text));
    vh.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        listener.onStatisticsClicked();
      }
    });
  }

  public void bindViewHolder(MenuAdapterHolders.StatisticsItemViewHolder vh, int position) {

  }
}
