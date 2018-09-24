package com.suzei.timescheduler.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.suzei.timescheduler.database.ScheduleEntity;
import com.suzei.timescheduler.database.ScheduleRepository;

public class DeleteScheduleViewModel extends ViewModel {

    private ScheduleRepository repository;

    DeleteScheduleViewModel(ScheduleRepository repository) {
        this.repository = repository;
    }

    public void deleteSchedule(ScheduleEntity scheduleEntity) {
        new DeleteScheduleItemTask(repository).execute(scheduleEntity);
    }

    private static class DeleteScheduleItemTask extends AsyncTask<ScheduleEntity, Void, Void> {

        private ScheduleRepository repository;

        DeleteScheduleItemTask(ScheduleRepository repository) {
            this.repository = repository;
        }

        @Override
        protected Void doInBackground(ScheduleEntity... scheduleEntities) {
            repository.deleteSchedule(scheduleEntities[0]);
            return null;
        }

    }

}
