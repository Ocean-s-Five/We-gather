package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface feedbackRepository extends JpaRepository<Feedback, Long> {
}
