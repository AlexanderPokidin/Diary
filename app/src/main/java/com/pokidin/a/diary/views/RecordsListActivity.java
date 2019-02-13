package com.pokidin.a.diary.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pokidin.a.diary.R;
import com.pokidin.a.diary.common.Record;
import com.pokidin.a.diary.contracts.RecordsListContract;
import com.pokidin.a.diary.models.RecordsListModelImpl;
import com.pokidin.a.diary.presenters.RecordsListPresenterImpl;

import java.util.List;

public class RecordsListActivity extends AppCompatActivity implements RecordsListContract.RecordsListView {

    private RecordsListContract.RecordsListPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private RecordAdapter mRecordAdapter;
    private RecordsListModelImpl mModel; // Нельзя использовать. Нужно удалить

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records_list);

        mPresenter = new RecordsListPresenterImpl();
        mModel = new RecordsListModelImpl();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.rv_records);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        mRecordAdapter = new RecordAdapter(mModel.loadRecords());
        mRecyclerView.setAdapter(mRecordAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void showRecordsList(List<Record> records) {

    }

    @Override
    public void onRecordClicked(Record record) {

    }
}
