/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sibu.flightsystemweb.repository;

import com.sibu.flightsystemweb.domain.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stud
 */
@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {
    
}
