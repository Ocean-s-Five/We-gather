package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface feedbackRepository extends JpaRepository<feedback, Long> {
}
