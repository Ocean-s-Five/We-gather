package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.UserConfigurationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfigurationRepository extends JpaRepository<UserConfigurationModel,Long> {
}
