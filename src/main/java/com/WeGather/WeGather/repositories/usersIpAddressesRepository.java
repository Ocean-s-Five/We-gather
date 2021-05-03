package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.UsersIpAddressesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersIpAddressesRepository extends JpaRepository<UsersIpAddressesModel, Long> {
}
