package com.bulei.sport.server;

import android.util.SparseArray;

import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.skeleton.MLSkeleton;
import com.huawei.hms.mlsdk.skeleton.MLSkeletonAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class SkeletonAnalyzerTransactor implements MLAnalyzer.MLTransactor<MLSkeleton> {
    TransactResult transactResult;
    public SkeletonAnalyzerTransactor(TransactResult transactResult){
        this.transactResult = transactResult;
    }
    @Override
    public void transactResult(MLAnalyzer.Result<MLSkeleton> results) {
        SparseArray<MLSkeleton> items = results.getAnalyseList();
        // 开发者根据需要处理识别结果，例如，在此方法中进行相似度计算，从而在检测到特定姿势后进行拍照等操作。
        // 需要注意，这里只对检测结果进行处理，不可调用ML Kit提供的其他检测相关接口。
        // 将SparseArray封装的结果转换为List数组，以便进行相似度比较。
        List<MLSkeleton> resultsList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            resultsList.add(items.valueAt(i));
        }

        transactResult.result(resultsList);
    }
    @Override
    public void destroy() {
        // 检测结束回调方法，用于释放资源等。
        transactResult.release();
    }
}
