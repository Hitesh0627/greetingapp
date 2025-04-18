package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
