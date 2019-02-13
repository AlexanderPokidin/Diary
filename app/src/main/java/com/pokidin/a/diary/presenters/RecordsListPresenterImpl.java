package com.pokidin.a.diary.presenters;

import com.pokidin.a.diary.common.Record;
import com.pokidin.a.diary.contracts.RecordsListContract;
import com.pokidin.a.diary.models.RecordsListModelImpl;
import com.pokidin.a.diary.views.RecordsListActivity;

import java.util.List;

public class RecordsListPresenterImpl implements RecordsListContract.RecordsListPresenter {

    RecordsListContract.RecordsListModel mRecordsListModel;
    RecordsListContract.RecordsListView mRecordsListView;
    List<Record> mRecords;

    @Override
    public void getRecordsList() {
        mRecordsListModel = new RecordsListModelImpl();
        mRecords = mRecordsListModel.loadRecords();
    }

    @Override
    public void openRecord(Record record) {
        mRecordsListView = new RecordsListActivity();
        mRecordsListView.showRecordsList(mRecords);
    }
}
