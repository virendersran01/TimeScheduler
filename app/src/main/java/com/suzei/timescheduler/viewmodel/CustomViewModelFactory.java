package com.suzei.timescheduler.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.suzei.timescheduler.database.ScheduleRepository;

public class CustomViewModelFactory implements ViewModelProvider.Factory {

    private final ScheduleRepository repository;

    public CustomViewModelFactory(ScheduleRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(CreateScheduleViewModel.class)) {
            return (T) new CreateScheduleViewModel(repository);
        }

        else if (modelClass.isAssignableFrom(DeleteAllScheduleViewModel.class)) {
            return (T) new DeleteAllScheduleViewModel(repository);
        }

        else if (modelClass.isAssignableFrom(DeleteScheduleViewModel.class)) {
            return (T) new DeleteScheduleViewModel(repository);
        }

        else if (modelClass.isAssignableFrom(ScheduleCollectionViewModel.class)) {
            return (T) new ScheduleCollectionViewModel(repository);
        }

        else if (modelClass.isAssignableFrom(ScheduleItemViewModel.class)) {
            return (T) new ScheduleItemViewModel(repository);
        }

        else if (modelClass.isAssignableFrom(UpdateScheduleViewModel.class)) {
            return (T) new UpdateScheduleViewModel(repository);
        }

        else {
            throw new IllegalArgumentException("Invalid modelClass" + modelClass.getSimpleName());
        }

    }

}
