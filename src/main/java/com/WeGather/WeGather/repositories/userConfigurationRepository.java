package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.UserConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userConfigurationRepository extends JpaRepository<UserConfiguration,Long> {
}
