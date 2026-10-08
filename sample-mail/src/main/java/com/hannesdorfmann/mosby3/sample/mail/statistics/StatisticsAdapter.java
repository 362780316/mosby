package com.hannesdorfmann.mosby3.sample.mail.statistics;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.mosby3.sample.mail.R;
import com.hannesdorfmann.mosby3.sample.mail.base.view.ListAdapter;
import com.hannesdorfmann.mosby3.sample.mail.model.mail.statistics.MailsCount;
import java.util.List;

/**
 * @author Hannes Dorfmann
 */
public class StatisticsAdapter extends ListAdapter<List<MailsCount>> {

  public StatisticsAdapter(Context context) {
    super(context);
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.list_statistics, parent, false);
    return new StatisticsAdapterHolders.StatisticItemViewHolder(view);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    bindViewHolder((StatisticsAdapterHolders.StatisticItemViewHolder) holder, position);
  }

  public void bindViewHolder(StatisticsAdapterHolders.StatisticItemViewHolder vh, int position) {
    MailsCount count = items.get(position);
    vh.text.setText(count.getMailsCount() + " mails in " + count.getLabel());
  }
}
