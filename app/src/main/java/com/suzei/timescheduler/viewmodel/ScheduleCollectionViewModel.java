package com.suzei.timescheduler.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.suzei.timescheduler.database.ScheduleEntity;
import com.suzei.timescheduler.database.ScheduleRepository;

import java.util.List;

public class ScheduleCollectionViewModel extends ViewModel {

    private ScheduleRepository repository;

    ScheduleCollectionViewModel(ScheduleRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<ScheduleEntity>> getAllSchedule() {
        return repository.getAllSchedule();
    }

    public LiveData<ScheduleEntity> getScheduleById(String itemId) {
        return repository.getScheduleById(itemId);
    }

}
