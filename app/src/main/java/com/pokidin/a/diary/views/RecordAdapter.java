package com.pokidin.a.diary.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pokidin.a.diary.R;
import com.pokidin.a.diary.common.Record;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private List<Record> mRecords;

    public RecordAdapter(List<Record> records) {
        mRecords = records;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Record record = mRecords.get(position); // Проверить порядок вызовов
        holder.mTitle.setText(record.getTitle());
        holder.mContent.setText(record.getContent());
    }

    @Override
    public int getItemCount() {
        if (mRecords == null) {
            return 0;
        } else {
            return mRecords.size();
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mTitle;
        TextView mContent;

        ViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.cv_record);
            mTitle = itemView.findViewById(R.id.tv_item_title);
            mContent = itemView.findViewById(R.id.tv_item_content);
        }
    }
}
