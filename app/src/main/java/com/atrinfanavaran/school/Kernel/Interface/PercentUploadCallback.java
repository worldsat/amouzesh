package com.atrinfanavaran.school.Kernel.Interface;

public interface PercentUploadCallback {
    void percent(long totalSize, long sendSize, float percent, float speed, boolean canceled);
}
