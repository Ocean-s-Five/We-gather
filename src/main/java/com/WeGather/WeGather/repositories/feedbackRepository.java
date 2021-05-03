package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.feedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface feedbackRepository extends JpaRepository<feedbackModel, Long> {
}
