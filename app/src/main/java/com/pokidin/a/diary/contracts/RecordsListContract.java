package com.pokidin.a.diary.contracts;

import com.pokidin.a.diary.common.Record;

import java.util.List;

public interface RecordsListContract {
    interface RecordsListModel {
        List<Record> loadRecords();

        interface OnFinishedListener {
            void onFinished(String string);
        }
    }

    interface RecordsListView {
        void showRecordsList(List<Record> records);

        void onRecordClicked(Record record);
    }

    interface RecordsListPresenter {
        void getRecordsList();

        void openRecord(Record record);
    }

}
