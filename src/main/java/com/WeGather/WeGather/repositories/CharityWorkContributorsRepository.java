package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.CharityWorkContributors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharityWorkContributorsRepository extends CrudRepository<CharityWorkContributors,Long> {
    @Query(value = "select * from charity_work_contributors where worked_raiser_id=?1 ",nativeQuery = true)
    public List<CharityWorkContributors> findByUserWorkRaiserId(Long id);

}
