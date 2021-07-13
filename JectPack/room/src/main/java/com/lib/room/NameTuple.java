package com.lib.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

/**
 * @author :huangguofeng
 * date    :2021/1/23
 * package :com.lib.room
 * desc    :
 */
public class NameTuple {
    @ColumnInfo(name = "firstName")
    public String firstName;

    @ColumnInfo(name = "lastName")
    @NonNull
    public String lastName;
}
