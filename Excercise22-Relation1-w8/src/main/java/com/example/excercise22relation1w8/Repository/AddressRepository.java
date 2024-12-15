package com.example.excercise22relation1w8.Repository;

import com.example.excercise22relation1w8.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}
