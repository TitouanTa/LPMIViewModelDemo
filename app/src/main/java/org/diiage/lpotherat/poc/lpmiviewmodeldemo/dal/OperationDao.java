package org.diiage.lpotherat.poc.lpmiviewmodeldemo.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.diiage.lpotherat.poc.lpmiviewmodeldemo.model.Operation;

import java.util.List;

@Dao
public interface OperationDao {
    @Insert
    long insert(Operation operation);

    @Update
    void update(Operation operation);

    @Delete
    void delete(Operation operation);

    @Query("SELECT * FROM Operation")
    LiveData<List<Operation>> getAll();

    @Query("SELECT * FROM Operation WHERE id = :id")
    LiveData<Operation> getById(long id);

}
