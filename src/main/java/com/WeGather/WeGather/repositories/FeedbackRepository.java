package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long> {
}
