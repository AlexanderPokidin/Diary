package com.pokidin.a.diary.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pokidin.a.diary.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    List<UserData> mData = new ArrayList<>();

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<UserData> users) {
        mData.clear();
        mData.addAll(users);
        notifyDataSetChanged();
    }

    static class UserHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public UserHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text);
        }

        void bind(UserData user) {
            mTextView.setText(String.format("Email: %s, Pass: %s", user.getEmail(), user.getPassword()));
        }
    }
}
