package com.bulei.sport.server;

import com.huawei.hms.mlsdk.skeleton.MLSkeleton;

import java.util.List;

public interface TransactResult {
    void result(List<MLSkeleton> mlSkeletons);

    void release();
}
