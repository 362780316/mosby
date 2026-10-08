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

package com.hannesdorfmann.mosby3.sample.mail.base.view;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * @author Hannes Dorfmann
 */
public abstract class ListAdapter<T extends List> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  protected final Context context;
  protected final LayoutInflater inflater;
  protected T items;

  public ListAdapter(Context context) {
    this.context = context;
    this.inflater = LayoutInflater.from(context);
  }

  @Override public int getItemCount() {
    return items == null ? 0 : items.size();
  }

  public T getItems() {
    return items;
  }

  public void setItems(T items) {
    this.items = items;
  }
}
